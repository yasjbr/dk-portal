package ps.edu.diyar.tutorInfo.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import ps.edu.diyar.common.component.AuditInfo;
import ps.edu.diyar.common.component.DataAccessObjectImpl;
import ps.edu.diyar.common.exceptions.ComponentException;
import ps.edu.diyar.common.tools.Randomizer;
import ps.edu.diyar.common.tools.SessionTraker;
import ps.edu.diyar.login.database.struct.UserInfo;
import ps.edu.diyar.studentInfo.database.RegCrsWht;
import ps.edu.diyar.studentInfo.useCase.GetCrsInfoUseCase;
import ps.edu.diyar.studentInfo.useCase.TutorMarkCommitUseCase;
import ps.edu.diyar.tutorInfo.database.struct.StudentListForCourse;
import ps.edu.diyar.tutorInfo.database.struct.TutorInfoHolder;
import ps.edu.diyar.tutorInfo.forms.MarksInsertionForm;
import ps.edu.diyar.tutorInfo.useCase.CheckCalenderDatesUseCase;
import ps.edu.diyar.tutorInfo.useCase.CheckM1CalenderDatesUseCase;
import ps.edu.diyar.tutorInfo.useCase.CheckM2CalenderDatesUseCase;
import ps.edu.diyar.tutorInfo.useCase.CheckMFinCalenderDatesUseCase;
import ps.edu.diyar.tutorInfo.useCase.CheckMMidCalenderDatesUseCase;
import ps.edu.diyar.tutorInfo.useCase.TutorMarkInsertionUseCase;

public class MarkInsertionCheckAction
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
    
    String termNo = request.getParameter("termNo");
    ArrayList input = new ArrayList();
    ArrayList inp = new ArrayList();
    

    inp.add(termNo);
    inp.add(outForm.getCrsNo());
    inp.add(outForm.getClassNo());
    
    Collection calender = new CheckCalenderDatesUseCase().execute(inp, request); /// returns true if now 
    ///
    Collection calenderM1 = new CheckM1CalenderDatesUseCase().execute(inp, request); //true if M1 is now  
    Collection calenderM2 = new CheckM2CalenderDatesUseCase().execute(inp, request); //true if M1 is now  
    Collection calenderMMid = new CheckMMidCalenderDatesUseCase().execute(inp, request); //true if M1 is now
    Collection calenderMFinal = new CheckMFinCalenderDatesUseCase().execute(inp, request); //true if M1 is now
    
     System.out.println("pleaseeeeeeeee 22");
    if ((request.getAttribute("calenderInfoM1") != null) ||
       (request.getAttribute("calenderInfoM2") != null)||
       (request.getAttribute("calenderInfoMMid") != null)||
       (request.getAttribute("calenderInfoMFin") != null)){
        request.setAttribute("calenderInfoAny", "true");
        
        System.out.println("infoooooooooooooooooo"+request.getAttribute("calenderInfoMMid"));
  }
    ////
    if ((calender != null) && (calender.size() != 0)) {
      request.setAttribute("calenderDates", calender);
    }
    
    
    inp = new ArrayList();
    inp.add(outForm.getCrsNo());
    
    Collection courseInfo = new GetCrsInfoUseCase().execute(inp, request);
    if ((courseInfo != null) && (courseInfo.size() != 0)) {
      request.setAttribute("courseInfo", courseInfo);
    }
    
    System.out.println("5-5-5-5-");
    ArrayList marksList = checkMarks(request, outForm, errors); //checks marks <= weights or in the correct format
    System.out.println("6-6-6-6-");
    errors = (ActionMessages)marksList.get(2);
      System.out.println("errors"+errors);
    if ((((Boolean)marksList.get(1)).booleanValue()) || (!errors.isEmpty()))
    {
         System.out.println("6-6-6-6-ERRROR");
      request.setAttribute("studentListForCourse", (List)marksList.get(0));
      saveErrors(request, errors);
      return mapping.findForward("errors");
    }
    input = new ArrayList();
    String classNo = outForm.getClassNo();
    String crsNo = outForm.getCrsNo();
    TutorInfoHolder tutorInfo = (TutorInfoHolder)((List)request.getSession().getAttribute("tutorInfo")).get(0);
    
    String tutor = tutorInfo.getEmpNo();
    
    input.add(classNo);
    input.add(crsNo);
    input.add(termNo);
    input.add(tutor);
    input.add(tutorInfo.getEmpNo());
    if ((outForm.getSubmitValue() != null) && (outForm.getSubmitValue().trim().equals("0")))
    {
         
      saveMarks(input, request, response);
      return mapping.findForward("saveData");
    }
    if ((outForm.getSubmitValue() != null) && (outForm.getSubmitValue().trim().equals("2")))
    {
        System.out.println("came here  "+"youi pressed save");
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
            System.out.println("eeeeerrrr");
          errors.add("errorFormat", new ActionMessage("errors.markInsertion.badMarkFormat", request.getParameter("studId" + count)));
        }
      }
      else
      {
        isEmpty = new Boolean(true);
      }
      
      
      
      //////////////////////  
      
     DataAccessObjectImpl cmp = new DataAccessObjectImpl();
     List courseWt=null;
     RegCrsWht rwt;
     String fw =null;
      String sw =null;
       String midw =null;
        String finw =null;
        try {
            courseWt = cmp.getList("Portal.getCourseWht", new Object[] {  outForm.getCrsNo() });
        } catch (ComponentException ex) {
            Logger.getLogger(MarkInsertionCheckAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    if ((courseWt != null) && (courseWt.size() != 0)) {
         rwt =  (RegCrsWht) courseWt.get(0);
         fw=  rwt.getFirst();
          sw=  rwt.getSecond();
           midw=  rwt.getMid();
            finw=  rwt.getFinalm();
            request.setAttribute("courseWt", courseWt);
         
    }
      if ((request.getParameter("f" + count) != null) && (request.getParameter("f" + count).trim().length() != 0))
      {
        st.setFirstMark(request.getParameter("f" + count));
        if (!markPattern.matcher(request.getParameter("f" + count).trim()).matches()) {
          errors.add("errorFormat", new ActionMessage("errors.markInsertion.badMarkFormat", request.getParameter("studId" + count)));
        } else if (new Integer(request.getParameter("f" + count).trim()).intValue() >   Integer.parseInt(fw)) {
          errors.add("errorFormat", new ActionMessage("errors.markInsertion.badMarkFormat", request.getParameter("studId" + count)));
        }
      }
      else
      {
           System.out.println("eeeeisEmptyerrrr");
        isEmpty = new Boolean(true);
      }
      
      
       if ((request.getParameter("s" + count) != null) && (request.getParameter("s" + count).trim().length() != 0))
      {
        st.setSecondMark(request.getParameter("s" + count));
        if (!markPattern.matcher(request.getParameter("s" + count).trim()).matches()) {
          errors.add("errorFormat", new ActionMessage("errors.markInsertion.badMarkFormat", request.getParameter("studId" + count)));
        } else if (new Integer(request.getParameter("s" + count).trim()).intValue() >   Integer.parseInt(sw)) {
          errors.add("errorFormat", new ActionMessage("errors.markInsertion.badMarkFormat", request.getParameter("studId" + count)));
        }
      }
      else
      {
           System.out.println("eeeeisEmptyerrrr");
        isEmpty = new Boolean(true);
      }
       
       
        if ((request.getParameter("md" + count) != null) && (request.getParameter("md" + count).trim().length() != 0))
      {
        st.setMidMark(request.getParameter("md" + count));
        if (!markPattern.matcher(request.getParameter("md" + count).trim()).matches()) {
          errors.add("errorFormat", new ActionMessage("errors.markInsertion.badMarkFormat", request.getParameter("studId" + count)));
        } else if (new Integer(request.getParameter("md" + count).trim()).intValue() >   Integer.parseInt(midw)) {
          errors.add("errorFormat", new ActionMessage("errors.markInsertion.badMarkFormat", request.getParameter("studId" + count)));
        }
      }
      else
      {
           System.out.println("eeeeisEmptyerrrr");
        isEmpty = new Boolean(true);
      }
        
        
         if ((request.getParameter("fn" + count) != null) && (request.getParameter("fn" + count).trim().length() != 0))
      {
        st.setFinMark(request.getParameter("fn" + count));
        if (!markPattern.matcher(request.getParameter("fn" + count).trim()).matches()) {
          errors.add("errorFormat", new ActionMessage("errors.markInsertion.badMarkFormat", request.getParameter("studId" + count)));
        } else if (new Integer(request.getParameter("fn" + count).trim()).intValue() >   Integer.parseInt(finw)) {
          errors.add("errorFormat", new ActionMessage("errors.markInsertion.badMarkFormat", request.getParameter("studId" + count)));
        }
      }
      else
      {
           System.out.println("eeeeisEmptyerrrr");
        isEmpty = new Boolean(true);
      }
      ///////////////////////
      
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
     System.out.println("1-1-1-1 ....");
    result = new TutorMarkInsertionUseCase().execute(input, request);
     System.out.println("1-1-1-1");
    if (result == null)
    {
       
      message = new ActionMessage("tutorInfo.markInsertion.saveSuccess");
    }
    else
    {
      Iterator iter = result.iterator();
      String error = (String)iter.next();
       System.out.println("2-2-2-2-");
      if (error.equals("approved")) {
        message = new ActionMessage("tutorInfo.markInsertion.NotAllowToSave");
         System.out.println("2-2-2-2-cccc");
      } else {
           System.out.println("2ffff-2-2-2-");
        message = new ActionMessage("tutorInfo.markInsertion.saveFail");
      }
    }
     System.out.println("3-3-3-3-3");
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

 