package ps.edu.diyar.admission.actions;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import ps.edu.diyar.admission.useCase.AdmApplicationLoadDataUseCase;
import ps.edu.diyar.admission.useCase.AdmApplicationLoadUseCase;
import ps.edu.diyar.common.tools.SessionTraker;

public class AdmApplicationLoadAction
  extends Action
{
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    if (!SessionTraker.isUserAdmLogged(request)) {
      return mapping.findForward("invalidAccess");
    }
    ArrayList inpt = new ArrayList();
    inpt.add(form);
    
    new AdmApplicationLoadUseCase().execute(inpt, request);
    
    new AdmApplicationLoadDataUseCase().execute(null, request);
    
    return mapping.findForward("success");
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.admission.actions.AdmApplicationLoadAction
 * JD-Core Version:    0.7.0.1
 */