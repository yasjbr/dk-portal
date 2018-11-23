package ps.edu.diyar.messaging.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.upload.FormFile;
import ps.edu.diyar.common.component.AuditInfo;
import ps.edu.diyar.common.constant.SystemConstant;
import ps.edu.diyar.common.tools.SessionTraker;
import ps.edu.diyar.messaging.forms.CalculateHoursFeesForm;
import ps.edu.diyar.messaging.forms.CreateMsgForm;
import ps.edu.diyar.messaging.useCase.SendMsgUseCase;
import ps.edu.diyar.studentInfo.database.struct.StudentInfoHolder;
import ps.edu.diyar.tutorInfo.database.struct.TutorInfoHolder;

public class SendMsgAction
  extends Action
{
  private static Logger logger = Logger.getLogger(SendMsgAction.class);
  
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    if (!SessionTraker.isSessionExist(request)) {
      return mapping.findForward("invalidAccess");
    }
    String termNo = "";
    String sender = "";
    ActionMessage message = null;
    ActionMessages errors = new ActionMessages();
    if (request.getSession().getAttribute("studentInfo") != null)
    {
      StudentInfoHolder studentInfo = (StudentInfoHolder)((List)request.getSession().getAttribute("studentInfo")).get(0);
      termNo = studentInfo.getSystemCurrentTermNo();
      sender = studentInfo.getStudentId();
    }
    else if (request.getSession().getAttribute("tutorInfo") != null)
    {
      TutorInfoHolder tutorInfoHolder = (TutorInfoHolder)((List)request.getSession().getAttribute("tutorInfo")).get(0);
      termNo = tutorInfoHolder.getCurrentTermNo();
      sender = tutorInfoHolder.getEmpNo();
    }
    CreateMsgForm inForm = (CreateMsgForm)form;
    
    String recieverId = inForm.getRecieverId();
    String subject = inForm.getSubject();
    String messageBody = inForm.getMessageBody();
    FormFile file = inForm.getTheFile();
    String remoteIp = new AuditInfo(request).getRemoteIp();
    String crsNo = inForm.getCrsNo();
    String crsClass = inForm.getCrsClass();
    
    ArrayList input = new ArrayList();
    input.add(subject);
    input.add(messageBody);
    input.add(recieverId);
    input.add(sender);
    input.add("normal");
    input.add(file);
    input.add(termNo);
    input.add("");
    input.add(crsNo);
    input.add(crsClass);
    input.add(remoteIp);
     input.add("F");
      input.add("");
    
    Collection result = null;
    
    result = new SendMsgUseCase().execute(input, request);
    if (result == null) {
      message = new ActionMessage("tutorInfo.messages.messageSent");
    } else {
      message = new ActionMessage("tutorInfo.messages.messagefailed");
    }
    errors.add("org.apache.struts.action.GLOBAL_MESSAGE", message);
    saveErrors(request, errors);
    

    return mapping.findForward(SystemConstant.SUCCESS);
  }
}



/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\

 * Qualified Name:     ps.edu.diyar.messaging.actions.SendMsgAction

 * JD-Core Version:    0.7.0.1

 */