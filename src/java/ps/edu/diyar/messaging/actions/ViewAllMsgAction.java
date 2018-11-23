package ps.edu.diyar.messaging.actions;

import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import ps.edu.diyar.common.component.UserIdCmp;
import ps.edu.diyar.common.constant.SystemConstant;
import ps.edu.diyar.common.tools.SessionTraker;
import ps.edu.diyar.messaging.useCase.ViewAllMsgUseCase;
import ps.edu.diyar.studentInfo.useCase.GetCrsInfoUseCase;

public class ViewAllMsgAction
  extends Action
{
  private static Logger logger = Logger.getLogger(ViewAllMsgAction.class);
  
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    if (!SessionTraker.isSessionExist(request)) {
      return mapping.findForward("invalidAccess");
    }
    String crsNo = request.getParameter("crsNo");
    String crsClass = request.getParameter("crsClass");
    String termNo = request.getParameter("termNo");
    
    request.setAttribute("crsNo", crsNo);
    request.setAttribute("crsClass", crsClass);
    request.setAttribute("termNo", termNo);
    
    ArrayList input = new ArrayList();
    input.add(crsNo);
    Collection crsInfo = new GetCrsInfoUseCase().execute(input, request);
    if ((crsInfo != null) && (crsInfo.size() > 0)) {
      request.setAttribute("crsInfo", crsInfo);
    }
    ArrayList inpt = new ArrayList();
    inpt.add(UserIdCmp.getStudIdOrTutorId(request));
    inpt.add(crsNo);
    inpt.add(crsClass);
    inpt.add(termNo);
    
    new ViewAllMsgUseCase().execute(inpt, request);
    


    return mapping.findForward(SystemConstant.SUCCESS);
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.messaging.actions.ViewAllMsgAction
 * JD-Core Version:    0.7.0.1
 */