package ps.edu.diyar.studentInfo.actions;

import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import ps.edu.diyar.common.tools.SessionTraker;
import ps.edu.diyar.studentInfo.useCase.ShowTermSummaryUseCase;
import ps.edu.diyar.studentInfo.useCase.StudentTermCourseSummaryUseCase;
import ps.edu.diyar.studentInfo.useCase.StudentTermsListUseCase;

public class ShowTermSummaryAction
  extends Action
{
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
     
      
    if (!SessionTraker.isSessionExist(request)) {
      return mapping.findForward("invalidAccess");
    }
     String selectedStudId =  request.getParameter("studId");
      String selectedStudName =  request.getParameter("studName");
      System.out.println("selectedStudId"+selectedStudId);
        
      
    ActionMessage message = null;
    ActionMessages messages = new ActionMessages();
    
    HttpSession session = request.getSession();
    
      session.setAttribute("selectedStudId", selectedStudId);
       session.setAttribute("selectedStudName", selectedStudName);
      
    Collection currentTermSummary = new ShowTermSummaryUseCase().execute(new ArrayList(), request);
    if ((currentTermSummary != null) && (currentTermSummary.size() != 0)) {
      request.setAttribute("selectedTermSummary", currentTermSummary);
    }
    Collection termsList = new StudentTermsListUseCase().execute(new ArrayList(), request);
    if ((termsList != null) && (termsList.size() != 0)) {
      session.setAttribute("termsList", termsList);
    }
    Collection termCourseSummary = new StudentTermCourseSummaryUseCase().execute(new ArrayList(), request);
    if ((termCourseSummary != null) && (termCourseSummary.size() != 0))
    {
      request.setAttribute("termCourseSummary", termCourseSummary);
        System.out.println("1h1");
    }
    else if (request.getAttribute("Error") != null)
    {
           System.out.println("1g1");
      message = new ActionMessage("studentInfo.messages.NotBalance");
      messages.add("org.apache.struts.action.GLOBAL_MESSAGE", message);
      saveErrors(request, messages);
    }
    return mapping.findForward("success");
  }
}

