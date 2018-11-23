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
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import ps.edu.diyar.common.component.AuditInfo;
import ps.edu.diyar.common.tools.SessionTraker;
import ps.edu.diyar.deptMaster.usecase.GetDeptMasterInfoUseCase;
import ps.edu.diyar.login.database.struct.UserInfo;

public class GoToDeptMstrAcountAction
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
    
    ArrayList inputDeptMasterInfo = new ArrayList();
    inputDeptMasterInfo.add(userId);
    Collection deptMasterInfo = new GetDeptMasterInfoUseCase().execute(inputDeptMasterInfo, request);
    if (deptMasterInfo != null)
    {
      session.removeAttribute("tutorInfo");
      session.setAttribute("deptMaster", deptMasterInfo);
      return mapping.findForward("deptMstrLayout");
    }
    ActionMessages errors = new ActionMessages();
    errors.add("error.goDeptMstrAcount", new ActionMessage("portal.error.goDeptMstrAcount"));
    saveErrors(request, errors);
    return mapping.findForward("fail");
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.tutorInfo.actions.GoToDeptMstrAcountAction
 * JD-Core Version:    0.7.0.1
 */