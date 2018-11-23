package ps.edu.diyar.messaging.actions;

import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import ps.edu.diyar.common.tools.SessionTraker;
import ps.edu.diyar.messaging.useCase.SendMessageStudentsListUseCase;

public class ViewTutorMessageAction
  extends Action
{
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    if (!SessionTraker.isSessionExist(request)) {
      return mapping.findForward("invalidAccess");
    }
    Collection studentList = new SendMessageStudentsListUseCase().execute(new ArrayList(), request);
    if ((studentList != null) && (studentList.size() > 0)) {
      request.setAttribute("existUsersList", studentList);
    }
    return mapping.findForward("success");
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.messaging.actions.ViewTutorMessageAction
 * JD-Core Version:    0.7.0.1
 */