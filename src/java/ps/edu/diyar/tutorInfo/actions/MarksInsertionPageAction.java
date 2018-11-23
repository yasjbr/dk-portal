package ps.edu.diyar.tutorInfo.actions;

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
import ps.edu.diyar.common.component.DataAccessObjectImpl;
import ps.edu.diyar.common.tools.SessionTraker;
import ps.edu.diyar.studentInfo.useCase.GetCrsInfoUseCase;
import ps.edu.diyar.tutorInfo.component.TutorTermScheduleComponent;
import ps.edu.diyar.tutorInfo.database.struct.TutorInfoHolder;
import ps.edu.diyar.tutorInfo.forms.MarksInsertionForm;
import ps.edu.diyar.tutorInfo.useCase.CheckCalenderDatesUseCase;
import ps.edu.diyar.tutorInfo.useCase.CheckM1CalenderDatesUseCase;
import ps.edu.diyar.tutorInfo.useCase.CheckM2CalenderDatesUseCase;
import ps.edu.diyar.tutorInfo.useCase.CheckMFinCalenderDatesUseCase;
import ps.edu.diyar.tutorInfo.useCase.CheckMMidCalenderDatesUseCase;
import ps.edu.diyar.tutorInfo.useCase.CheckMPracticalCalenderDatesUseCase;
import ps.edu.diyar.tutorInfo.useCase.IsClassMarksApprovedUseCase;

public class MarksInsertionPageAction
  extends Action
{
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    if (!SessionTraker.isSessionExist(request)) {
      return mapping.findForward("invalidAccess");
    }
    MarksInsertionForm outForm = (MarksInsertionForm)form; // not sure what is this!!
    
    String termNo =  request.getParameter("termNo");
    String crsNo = request.getParameter("crsNo");
    String classNo = request.getParameter("classNo");
    
    // tutor details
    TutorInfoHolder tutorInfo = (TutorInfoHolder)((List)request.getSession().getAttribute("tutorInfo")).get(0);
    
    Object[] param = { termNo, crsNo, classNo, tutorInfo.getEmpNo() };
    
    ArrayList input = new ArrayList();
    input.add(termNo);
    input.add(crsNo);
    input.add(classNo);
     
    List studentList = new TutorTermScheduleComponent().getTutorsStudentListForMarksInsertion(param);
    
    Collection calender = new CheckCalenderDatesUseCase().execute(input, request); //true if MP is now
    input.add(calender);
    
    
    //////////////
    Collection calenderM1 = new CheckM1CalenderDatesUseCase().execute(input, request); //true if M1 is now
    input.add(calenderM1);
    
     Collection calenderM2 = new CheckM2CalenderDatesUseCase().execute(input, request); //true if M1 is now
    input.add(calenderM2);
    
     Collection calenderMMid = new CheckMMidCalenderDatesUseCase().execute(input, request); //true if M1 is now
    input.add(calenderMMid);
    
    
    
     Collection calenderMFinal = new CheckMFinCalenderDatesUseCase().execute(input, request); //true if M1 is now
    input.add(calenderMFinal);
    
      System.out.println("pleaseeeeeeeee");
    if ((request.getAttribute("calenderInfoM1") != null) ||
       (request.getAttribute("calenderInfoM2") != null)||
       (request.getAttribute("calenderInfoMMid") != null)||
      
       (request.getAttribute("calenderInfoMFin") != null)){
             request.setAttribute("calenderInfoAny", "true");
  }
     
    
    
    /////////////
  
     
     
     
    Collection isApproved = new IsClassMarksApprovedUseCase().execute(input, request);  /// a record of approvement if approved
   
    if ((isApproved != null) && (isApproved.size() > 0))// if marks are approved then stop calendar and hide save buttons
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
    
    ///
    DataAccessObjectImpl cmp = new DataAccessObjectImpl();
    List courseWt = cmp.getList("Portal.getCourseWht", new Object[] {  crsNo });
    if ((courseWt != null) && (courseWt.size() != 0)) {
        System.out.println("course has weights");
      request.setAttribute("courseWt", courseWt);
    }
    else
    {
       System.out.println("nnnn course has weights"); 
    }
    
    //
    
    
    
    
    request.setAttribute("crsNo", crsNo);
    outForm.setTermNo(termNo);
    outForm.setCrsNo(crsNo);
    outForm.setClassNo(classNo);
    
    return mapping.findForward("success");
  }
}

 