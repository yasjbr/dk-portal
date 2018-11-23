package ps.edu.diyar.tutorInfo.actions;

import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import ps.edu.diyar.common.tools.SessionTraker;
import ps.edu.diyar.tutorInfo.useCase.ShowTutorTermScheduleUseCase;
import ps.edu.diyar.tutorInfo.useCase.TutorTermListUseCase;

public class TutorTermScheduleAction
  extends Action
{
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    if (!SessionTraker.isSessionExist(request)) {
      return mapping.findForward("invalidAccess");
    }
    HttpSession session = request.getSession();
    if (session.getAttribute("termsList") == null)
    {
      Collection termsList = new TutorTermListUseCase().execute(new ArrayList(), request);
      if ((termsList != null) && (termsList.size() != 0)) {
        session.setAttribute("termsList", termsList);
      }
    }
    Collection termSchedule = new ShowTutorTermScheduleUseCase().execute(new ArrayList(), request);
    if ((termSchedule != null) && (termSchedule.size() != 0)) {
      request.setAttribute("tutorTermSchedule", termSchedule);
    }
    return mapping.findForward("success");
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.tutorInfo.actions.TutorTermScheduleAction
 * JD-Core Version:    0.7.0.1
 */