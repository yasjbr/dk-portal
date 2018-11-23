package ps.edu.diyar.deptMaster.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import ps.edu.diyar.colgMaster.database.struct.ColgMasterInfoHolder;
import ps.edu.diyar.common.component.AuditInfo;
import ps.edu.diyar.common.tools.Randomizer;
import ps.edu.diyar.common.tools.SessionTraker;
import ps.edu.diyar.deptMaster.database.struct.DeptMasterInfoHolder;
import ps.edu.diyar.login.database.struct.UserInfo;
import ps.edu.diyar.studentInfo.useCase.GetCrsInfoUseCase;
import ps.edu.diyar.studentInfo.useCase.TutorMarkCommitUseCase;
import ps.edu.diyar.tutorInfo.database.struct.StudentListForCourse;
import ps.edu.diyar.tutorInfo.database.struct.TutorInfoHolder;
import ps.edu.diyar.tutorInfo.forms.MarksInsertionForm;
import ps.edu.diyar.tutorInfo.useCase.CheckCalenderDatesUseCase;
import ps.edu.diyar.tutorInfo.useCase.GetTutorInfoUseCase;
import ps.edu.diyar.tutorInfo.useCase.TutorMarkInsertionUseCase;

public class MarksApproveCheckAction
  extends Action
{
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    if (!SessionTraker.isSessionExist(request)) {
      return mapping.findForward("invalidAccess");
    }
    ActionMessages errors = new ActionMessages();
    MarksInsertionForm outForm = (MarksInsertionForm)form;
    
    String termNo = "";
    String deptNo = "";
    if (request.getSession().getAttribute("deptMaster") != null)
    {
      DeptMasterInfoHolder dptMstr = (DeptMasterInfoHolder)((List)request.getSession().getAttribute("deptMaster")).get(0);
      termNo = dptMstr.getCurrentTermNo();
      deptNo = dptMstr.getDeptNo();
    }
    else if (request.getSession().getAttribute("colgMaster") != null)
    {
      ColgMasterInfoHolder colgMasterInfo = (ColgMasterInfoHolder)((List)request.getSession().getAttribute("colgMaster")).get(0);
      termNo = colgMasterInfo.getCurrentTermNo();
      deptNo = (String)request.getSession().getAttribute("browseDept");
    }
    ArrayList input = new ArrayList();
    ArrayList inp = new ArrayList();
    

    inp.add(termNo);
    inp.add(outForm.getCrsNo());
    inp.add(outForm.getClassNo());
    
    Collection calender = new CheckCalenderDatesUseCase().execute(inp, request);
    if ((calender != null) && (calender.size() != 0)) {
      request.setAttribute("calenderDates", calender);
    }
    inp = new ArrayList();
    inp.add(outForm.getCrsNo());
    
    Collection courseInfo = new GetCrsInfoUseCase().execute(inp, request);
    if ((courseInfo != null) && (courseInfo.size() != 0)) {
      request.setAttribute("courseInfo", courseInfo);
    }
    String tutorNo = request.getParameter("empNo");
    
    ArrayList input_tut_info = new ArrayList();
    input_tut_info.add(tutorNo);
    Collection tutInfo = new GetTutorInfoUseCase().execute(input_tut_info, request);
    if ((tutInfo != null) && (tutInfo.size() > 0))
    {
      TutorInfoHolder obj = (TutorInfoHolder)tutInfo.iterator().next();
      if (!obj.getDeptNo().equals(deptNo)) {
        throw new Exception("user try browse mark student for tutor out department");
      }
      request.setAttribute("tutInfo", tutInfo);
    }
    ArrayList marksList = checkMarks(request, outForm, errors);
    errors = (ActionMessages)marksList.get(2);
    if ((((Boolean)marksList.get(1)).booleanValue()) || (!errors.isEmpty()))
    {
      request.setAttribute("studentListForCourse", (List)marksList.get(0));
      saveErrors(request, errors);
      return mapping.findForward("errors");
    }
    input = new ArrayList();
    String classNo = outForm.getClassNo();
    String crsNo = outForm.getCrsNo();
    



    input.add(classNo);
    input.add(crsNo);
    input.add(termNo);
    input.add(tutorNo);
    input.add(tutorNo);
    if ((outForm.getSubmitValue() != null) && (outForm.getSubmitValue().trim().equals("0")))
    {
      saveMarks(input, request, response);
      return mapping.findForward("saveData");
    }
    if ((outForm.getSubmitValue() != null) && (outForm.getSubmitValue().trim().equals("2")))
    {
      saveMarks(input, request, response);
      return mapping.findForward("success");
    }
    commitMarks(input, request, response);
    return mapping.findForward("saveData");
  }
  
  public ArrayList checkMarks(HttpServletRequest request, MarksInsertionForm outForm, ActionMessages errors)
  {
    int count = 1;
    ArrayList dataList = new ArrayList();
    StudentListForCourse st = new StudentListForCourse();
    Boolean isEmpty = new Boolean(false);
    
    Pattern markPattern = Pattern.compile("\\d{1,3}");
    
    ArrayList marksList = new ArrayList();
    while (request.getParameterMap().containsKey("studId" + count))
    {
      st = new StudentListForCourse();
      st.setStudId(request.getParameter("studId" + count));
      if ((request.getParameter("m" + count) != null) && (request.getParameter("m" + count).trim().length() != 0))
      {
        st.setCrsMark(request.getParameter("m" + count));
        if (!markPattern.matcher(request.getParameter("m" + count).trim()).matches()) {
          errors.add("errorFormat", new ActionMessage("errors.markInsertion.badMarkFormat", request.getParameter("studId" + count)));
        } else if (new Integer(request.getParameter("m" + count).trim()).intValue() > 100) {
          errors.add("errorFormat", new ActionMessage("errors.markInsertion.badMarkFormat", request.getParameter("studId" + count)));
        }
      }
      else
      {
        isEmpty = new Boolean(true);
      }
      if ((request.getParameter("studName" + count) != null) && (request.getParameter("studName" + count).trim().length() != 0))
      {
        String studName = "";
        try
        {
          studName = new String(request.getParameter("studName" + count).getBytes("ISO8859_1"), "utf8");
        }
        catch (Exception e) {}
        st.setStudAName(studName);
      }
      marksList.add(st);
      count++;
    }
    if ((outForm.getSubmitValue() != null) && (outForm.getSubmitValue().trim().equals("2")))
    {
      isEmpty = new Boolean(false);
    }
    else if (((outForm.getMarksChecked() == null) || (outForm.getMarksChecked().trim().length() == 0)) && (isEmpty.booleanValue()))
    {
      outForm.setMarksChecked("y");
      errors.add("missingdata", new ActionMessage("errors.markInsertion.emptyMarks"));
    }
    else
    {
      isEmpty = new Boolean(false);
    }
    dataList.add(marksList);
    dataList.add(isEmpty);
    dataList.add(errors);
    
    return dataList;
  }
  
  public void saveMarks(ArrayList input, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    ActionMessage message = null;
    ActionMessages errors = new ActionMessages();
    
    Collection result = null;
    result = new TutorMarkInsertionUseCase().execute(input, request);
    if (result == null)
    {
      message = new ActionMessage("tutorInfo.markInsertion.saveSuccess");
    }
    else
    {
      Iterator iter = result.iterator();
      String error = (String)iter.next();
      if (error.equals("approved")) {
        message = new ActionMessage("tutorInfo.markInsertion.NotAllowToSave");
      } else {
        message = new ActionMessage("tutorInfo.markInsertion.saveFail");
      }
    }
    errors.add("error.save", message);
    saveErrors(request, errors);
    request.setAttribute("studentListForCourse", request.getAttribute("studentListForCourse"));
  }
  
  public void commitMarks(ArrayList input, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    ActionMessage message = null;
    ActionMessages errors = new ActionMessages();
    
    Collection result = null;
    AuditInfo auditInfo = new AuditInfo(request);
    input.add(auditInfo.getUserLoginInfo().getUserId());
    input.add(auditInfo.getRemoteIp());
    
    result = new TutorMarkCommitUseCase().execute(input, request);
    if (result == null)
    {
      Iterator iter = input.iterator();
      
      String classNo = (String)iter.next();
      String crsNo = (String)iter.next();
      String termNo = (String)iter.next();
      
      message = new ActionMessage("tutorInfo.markInsertion.commitSuccess", new Object[] { Randomizer.shortRandom() + "", classNo, crsNo, termNo });
    }
    else
    {
      Iterator iter = result.iterator();
      String error = (String)iter.next();
      if (error.equals("approved")) {
        message = new ActionMessage("tutorInfo.markInsertion.NotAllowToSave");
      } else {
        message = new ActionMessage("tutorInfo.markInsertion.commitFail");
      }
    }
    errors.add("error.commit", message);
    saveErrors(request, errors);
    request.setAttribute("studentListForCourse", request.getAttribute("studentListForCourse"));
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.deptMaster.actions.MarksApproveCheckAction
 * JD-Core Version:    0.7.0.1
 */