package ps.edu.diyar.studentInfo.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import ps.edu.diyar.common.tools.SessionTraker;
import ps.edu.diyar.studentInfo.useCase.ShowTermSummaryUseCase;
import ps.edu.diyar.studentInfo.useCase.StudentTermCourseSummaryUseCase;

public class ShowSelectedTermSummaryAction
  extends Action
{
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
      System.out.println("hielyer");
    ActionMessage message = null;
    ActionMessages messages = new ActionMessages();
    if (!SessionTraker.isSessionExist(request)) {
      return mapping.findForward("invalidAccess");
    }
     System.out.println("2");
    Collection selectedTermSummary = new ShowTermSummaryUseCase().execute(new ArrayList(), request);
    if ((selectedTermSummary != null) && (selectedTermSummary.size() != 0)) {
      request.setAttribute("selectedTermSummary", selectedTermSummary);
        System.out.println("selected is not null ");
    }
     System.out.println("3----------------");
    List termCourseSummary = (List)new StudentTermCourseSummaryUseCase().execute(new ArrayList(), request);
    if ((termCourseSummary != null) && (termCourseSummary.size() != 0))
    {
         System.out.println("33");
      request.setAttribute("termCourseSummary", termCourseSummary);
    }
//    else if (request.getAttribute("Error") != null)
//    {
//         System.out.println("error marks will not get displayed");
//       
//      message = new ActionMessage("studentInfo.messages.NotBalance");
//      messages.add("org.apache.struts.action.GLOBAL_MESSAGE", message);
//      saveErrors(request, messages);
//    }
      
    return mapping.findForward("success");
  }
}


 