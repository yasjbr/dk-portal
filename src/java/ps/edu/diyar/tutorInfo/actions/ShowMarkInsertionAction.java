package ps.edu.diyar.tutorInfo.actions;

import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import ps.edu.diyar.common.tools.SessionTraker;
import ps.edu.diyar.tutorInfo.useCase.ShowMarkInsertionUseCase;

public class ShowMarkInsertionAction
  extends Action
{
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    if (!SessionTraker.isSessionExist(request)) {
      return mapping.findForward("invalidAccess");
    }
    Collection termSchedule = new ShowMarkInsertionUseCase().execute(new ArrayList(), request);
    if ((termSchedule != null) && (termSchedule.size() != 0)) {
      request.setAttribute("tutorTermSchedule", termSchedule);
    }
    return mapping.findForward("success");
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.tutorInfo.actions.ShowMarkInsertionAction
 * JD-Core Version:    0.7.0.1
 */