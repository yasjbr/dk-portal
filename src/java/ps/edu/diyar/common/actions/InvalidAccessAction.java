package ps.edu.diyar.common.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

public class InvalidAccessAction
  extends Action
{
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    ActionMessages errors = new ActionMessages();
    errors.add("org.apache.struts.action.GLOBAL_MESSAGE", new ActionMessage("errors.relginUser"));
    saveErrors(request, errors);
    
    return mapping.findForward("success");
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.common.actions.InvalidAccessAction
 * JD-Core Version:    0.7.0.1
 */