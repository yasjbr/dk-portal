package ps.edu.diyar.messaging.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import ps.edu.diyar.common.struct.LabelValue;
import ps.edu.diyar.common.tools.SessionTraker;
import ps.edu.diyar.messaging.database.struct.PrtlMessage;
import ps.edu.diyar.messaging.forms.CalculateHoursFeesForm;
import ps.edu.diyar.messaging.forms.CreateMsgForm;
import ps.edu.diyar.messaging.useCase.ReplayMessageUseCase;
import ps.edu.diyar.studentInfo.useCase.GetTutorOfThisCrsUseCase;
import ps.edu.diyar.tutorInfo.useCase.GetStudNameUseCase;

public class CreateMsgAction
  extends Action
{
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    if (!SessionTraker.isSessionExist(request)) {
      return mapping.findForward("invalidAccess");
    }
    CreateMsgForm inForm = (CreateMsgForm)form;
    

    String crsNo = request.getParameter("crsNo");
    String crsClass = request.getParameter("crsClass");
    String termNo = request.getParameter("termNo");
    String senderId = request.getParameter("senderId");
    

    ArrayList input = new ArrayList();
    input.add(crsNo);
    input.add(crsClass);
    input.add(termNo);
    if (request.getSession().getAttribute("studentInfo") != null)
    {
      Collection reciverList = new GetTutorOfThisCrsUseCase().execute(input, request);
      if ((reciverList != null) && (reciverList.size() > 0))
      {
        LabelValue rcInfo = (LabelValue)reciverList.iterator().next();
        inForm.setEdit(true);
        inForm.setRecieverName(rcInfo.getLabel());
        inForm.setRecieverId(rcInfo.getValue());
        inForm.setCrsNo(crsNo);
        inForm.setCrsClass(crsClass);
      }
    }
    else if (request.getSession().getAttribute("tutorInfo") != null)
    {
      input.clear();
      input.add(senderId);
      Collection reciverList = new GetStudNameUseCase().execute(input, request);
      if ((reciverList != null) && (reciverList.size() > 0))
      {
        LabelValue rcInfo = (LabelValue)reciverList.iterator().next();
        inForm.setEdit(true);
        inForm.setRecieverName(rcInfo.getLabel());
        inForm.setRecieverId(rcInfo.getValue());
        inForm.setCrsNo(crsNo);
        inForm.setCrsClass(crsClass);
      }
    }
    if ((request.getParameter("msgId") != null) && (!request.getParameter("msgId").toString().trim().equals("")))
    {
      input = new ArrayList();
      input.add(request.getParameter("msgId"));
      Collection messageTemplate = new ReplayMessageUseCase().execute(input, request);
      
      PrtlMessage inerOldMsg = (PrtlMessage)((ArrayList)messageTemplate).get(0);
      inForm.setMessageBody(inerOldMsg.getMsgBody());
      inForm.setSubject(inerOldMsg.getMsgTitle());
      inForm.setEdit(true);
    }
    return mapping.findForward("showPage");
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.messaging.actions.CreateMsgAction
 * JD-Core Version:    0.7.0.1
 */