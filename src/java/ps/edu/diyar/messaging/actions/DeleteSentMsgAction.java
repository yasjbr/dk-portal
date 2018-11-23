package ps.edu.diyar.messaging.actions;

import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import ps.edu.diyar.common.component.UserIdCmp;
import ps.edu.diyar.common.constant.SystemConstant;
import ps.edu.diyar.common.tools.Randomizer;
import ps.edu.diyar.common.tools.SessionTraker;
import ps.edu.diyar.messaging.useCase.DeleteMsgUseCase;
import ps.edu.diyar.messaging.useCase.DeleteSentMsgUseCase;

public class DeleteSentMsgAction
  extends Action
{
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    if (!SessionTraker.isSessionExist(request)) {
      return mapping.findForward("invalidAccess");
    }
    String userId = "";
    


    userId = UserIdCmp.getStudIdOrTutorId(request);
    

    ArrayList inputs = new ArrayList();
    inputs.add(request.getParameter("deletedValue"));
    inputs.add(userId);
    inputs.add(request.getParameter("msgtype"));
    
    Collection msgDeleted = new DeleteSentMsgUseCase().execute(inputs, request);
    ActionMessages messages = new ActionMessages();
    if (msgDeleted != null) {
      messages.add("msgDeleted", new ActionMessage("message.deleteMessageFail"));
    } else {
      messages.add("msgDeleted", new ActionMessage("message.deleteMessageSuccess"));
    }
    saveErrors(request, messages);
    
    String termNo = request.getParameter("termNo");
    String crsNo = request.getParameter("crsNo");
    String crsClass = request.getParameter("crsClass");
    
    return new ActionForward(mapping.findForward(SystemConstant.SUCCESS).getPath() + "?termNo=" + termNo + "&crsNo=" + crsNo + "&crsClass=" + crsClass + "&.rv=" + Randomizer.shortRandom(), true);
  }
}

