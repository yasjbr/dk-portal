package ps.edu.diyar.deptMaster.actions;

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
import ps.edu.diyar.common.component.AuditInfo;
import ps.edu.diyar.common.tools.SessionTraker;
import ps.edu.diyar.login.database.struct.UserInfo;
import ps.edu.diyar.tutorInfo.useCase.GetTutorInfoUseCase;

public class GoToTutAcountAction
  extends Action
{
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    if (!SessionTraker.isSessionExist(request)) {
      return mapping.findForward("invalidAccess");
    }
    String userId = new AuditInfo(request).getUserLoginInfo().getUserId();
    HttpSession session = request.getSession();
    
    ArrayList inputTutorInfo = new ArrayList();
    inputTutorInfo.add(userId);
    Collection tutorInfo = new GetTutorInfoUseCase().execute(inputTutorInfo, request);
    if (tutorInfo != null)
    {
      session.removeAttribute("deptMaster");
      session.setAttribute("tutorInfo", tutorInfo);
      return mapping.findForward("tutorLayout");
    }
    ActionMessages errors = new ActionMessages();
    errors.add("error.goTutAcount", new ActionMessage("portal.error.goTutAcount"));
    saveErrors(request, errors);
    return mapping.findForward("fail");
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.deptMaster.actions.GoToTutAcountAction
 * JD-Core Version:    0.7.0.1
 */