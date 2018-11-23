package ps.edu.diyar.deptMaster.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import ps.edu.diyar.colgMaster.database.struct.ColgMasterInfoHolder;
import ps.edu.diyar.common.tools.SessionTraker;
import ps.edu.diyar.deptMaster.database.struct.DeptMasterInfoHolder;
import ps.edu.diyar.studentInfo.useCase.GetCrsInfoUseCase;
import ps.edu.diyar.tutorInfo.component.TutorTermScheduleComponent;
import ps.edu.diyar.tutorInfo.database.struct.TutorInfoHolder;
import ps.edu.diyar.tutorInfo.forms.MarksInsertionForm;
import ps.edu.diyar.tutorInfo.useCase.CheckCalenderDatesUseCase;
import ps.edu.diyar.tutorInfo.useCase.GetTutorInfoUseCase;
import ps.edu.diyar.tutorInfo.useCase.IsClassMarksApprovedUseCase;

public class MarksApprovePageAction
  extends Action
{
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    if (!SessionTraker.isSessionExist(request)) {
      return mapping.findForward("invalidAccess");
    }
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
    String crsNo = request.getParameter("crsNo");
    String classNo = request.getParameter("classNo");
    String empNo = request.getParameter("empNo");
    


    ArrayList inp = new ArrayList();
    inp.add(empNo);
    Collection tutInfo = new GetTutorInfoUseCase().execute(inp, request);
    if ((tutInfo != null) && (tutInfo.size() > 0))
    {
      TutorInfoHolder obj = (TutorInfoHolder)tutInfo.iterator().next();
      if (!obj.getDeptNo().equals(deptNo)) {
        throw new Exception("user try browse mark student for tutor out department");
      }
      request.setAttribute("tutInfo", tutInfo);
    }
    Object[] param = { termNo, crsNo, classNo, empNo };
    
    ArrayList input = new ArrayList();
    input.add(termNo);
    input.add(crsNo);
    input.add(classNo);
    
    List studentList = new TutorTermScheduleComponent().getTutorsStudentListForMarksInsertion(param);
    
    Collection calender = new CheckCalenderDatesUseCase().execute(input, request);
    input.add(calender);
    Collection isApproved = new IsClassMarksApprovedUseCase().execute(input, request);
    if ((isApproved != null) && (isApproved.size() > 0))
    {
      if (request.getAttribute("calenderInfo") != null) {
        request.removeAttribute("calenderInfo");
      }
      request.setAttribute("error.marksApproved", "false");
    }
    if ((calender != null) && (calender.size() != 0)) {
      request.setAttribute("calenderDates", calender);
    }
    if ((studentList != null) && (studentList.size() != 0)) {
      request.setAttribute("studentListForCourse", studentList);
    }
    input = new ArrayList();
    input.add(crsNo);
    
    Collection courseInfo = new GetCrsInfoUseCase().execute(input, request);
    if ((courseInfo != null) && (courseInfo.size() != 0)) {
      request.setAttribute("courseInfo", courseInfo);
    }
    request.setAttribute("crsNo", crsNo);
    outForm.setTermNo(termNo);
    outForm.setCrsNo(crsNo);
    outForm.setClassNo(classNo);
    outForm.setEmpNo(empNo);
    
    return mapping.findForward("success");
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.deptMaster.actions.MarksApprovePageAction
 * JD-Core Version:    0.7.0.1
 */