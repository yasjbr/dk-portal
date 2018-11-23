package ps.edu.diyar.messaging.actions;

import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import ps.edu.diyar.common.component.UserIdCmp;
import ps.edu.diyar.common.constant.SystemConstant;
import ps.edu.diyar.common.tools.SessionTraker;
import ps.edu.diyar.messaging.useCase.ViewMsgDetailsUseCase;

public class ViewMsgDetailsAction
  extends Action
{
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    if (!SessionTraker.isSessionExist(request)) {
      return mapping.findForward("invalidAccess");
    }
    String messageId = request.getParameter("msgId");
    String isRead = request.getParameter("read");
    String senderId = request.getParameter("senderId");
    



    ArrayList input = new ArrayList();
    
    input.add(messageId);
    input.add(isRead);
    input.add(UserIdCmp.getStudIdOrTutorId(request));
    input.add(senderId);
    
    Collection messages = new ViewMsgDetailsUseCase().execute(input, request);
    request.setAttribute("messages", messages);
    
    return mapping.findForward(SystemConstant.SUCCESS);
  }
}


 