package ps.edu.diyar.messaging.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.upload.FormFile;
import ps.edu.diyar.common.tools.SessionTraker;
import ps.edu.diyar.messaging.forms.SendTutorMessageForm;
import ps.edu.diyar.messaging.useCase.SendTutorMessageUseCase;
import ps.edu.diyar.tutorInfo.database.struct.TutorInfoHolder;

public class SendTutorMessageAction
  extends Action
{
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    if (!SessionTraker.isSessionExist(request)) {
      return mapping.findForward("invalidAccess");
    }
    SendTutorMessageForm outForm = (SendTutorMessageForm)form;
    

    String currentTermNo = null;
    String userId = null;
    

    TutorInfoHolder tutorInfo = (TutorInfoHolder)((List)request.getSession().getAttribute("tutorInfo")).get(0);
    currentTermNo = tutorInfo.getCurrentTermNo();
    userId = tutorInfo.getEmpNo();
    String crsNo = request.getParameter("crsNo");
    String classNo = request.getParameter("classNo");
    
    request.setAttribute("classNo", classNo);
    request.setAttribute("crsNo", crsNo);
    




    sendMessage(outForm, request, response, userId, crsNo, classNo, currentTermNo);
    outForm.repopulateExistUsersLists(request);
    outForm.repopulateSelectedUsersLists(request);
    outForm.setDecode(false);
    return mapping.findForward("success");
  }
  
  public void sendMessage(SendTutorMessageForm outForm, HttpServletRequest request, HttpServletResponse response, String userId, String crsNo, String classNo, String currentTermNo)
    throws Exception
  {
    ArrayList input = new ArrayList();
    ActionMessage message = null;
    ActionMessages errors = new ActionMessages();
    
    String subject = outForm.getSubjectWrapper();
    String messageBody = outForm.getMessageBody();
    String[] listOfReciever = outForm.getRecieverStudent();
    String servirity = outForm.getServirity();
    

    FormFile file = outForm.getTheFile();
    
    input.add(subject);
    input.add(messageBody);
    input.add(listOfReciever);
    input.add(userId);
    input.add(servirity);
    input.add(file);
    input.add(currentTermNo);
    input.add(crsNo);
    input.add(classNo);
    input.add("");
    input.add(request.getRemoteHost());
    input.add("F");
    input.add("");
    
    Collection result = null;
    result = new SendTutorMessageUseCase().execute(input, request);
    if (result == null) {
      message = new ActionMessage("tutorInfo.messages.messageSent");
    } else {
      message = new ActionMessage("tutorInfo.messages.messagefailed");
    }
    errors.add("messageSendStatus", message);
    saveErrors(request, errors);
    request.setAttribute("studentListForCourse", request.getAttribute("studentListForCourse"));
  }
}



/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\

 * Qualified Name:     ps.edu.diyar.messaging.actions.SendTutorMessageAction

 * JD-Core Version:    0.7.0.1

 */