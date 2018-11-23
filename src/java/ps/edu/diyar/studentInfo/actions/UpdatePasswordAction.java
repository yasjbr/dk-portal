package ps.edu.diyar.studentInfo.actions;

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
import ps.edu.diyar.admission.component.CommonOperationMessage;
import ps.edu.diyar.colgMaster.database.struct.ColgMasterInfoHolder;
import ps.edu.diyar.common.tools.SessionTraker;
import ps.edu.diyar.deptMaster.database.struct.DeptMasterInfoHolder;
import ps.edu.diyar.studentInfo.database.struct.StudentInfoHolder;
import ps.edu.diyar.studentInfo.forms.UpdatePasswordForm;
import ps.edu.diyar.studentInfo.useCase.UpdatePasswordUseCase;
import ps.edu.diyar.tutorInfo.database.struct.TutorInfoHolder;

public class UpdatePasswordAction
  extends Action
{
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    if (!SessionTraker.isSessionExist(request)) {
      return mapping.findForward("invalidAccess");
    }
    UpdatePasswordForm inForm = (UpdatePasswordForm)form;
    ActionMessages messages = new ActionMessages();
    ActionMessage message = null;
    String returnPath = "success";
    ArrayList inputs = new ArrayList();
    boolean updateMoodlePswd = false;
    String userName = "";
    
    String user = "";
    if (request.getSession().getAttribute("studentInfo") != null)
    {
      StudentInfoHolder studentInfo = (StudentInfoHolder)((List)request.getSession().getAttribute("studentInfo")).get(0);
      user = studentInfo.getStudentId();
    }
    else if (request.getSession().getAttribute("tutorInfo") != null)
    {
      TutorInfoHolder tutorInfo = (TutorInfoHolder)((List)request.getSession().getAttribute("tutorInfo")).get(0);
      user = tutorInfo.getEmpNo();
    }
    else if (request.getSession().getAttribute("deptMaster") != null)
    {
      DeptMasterInfoHolder deptMasterInfoHolder = (DeptMasterInfoHolder)((List)request.getSession().getAttribute("deptMaster")).get(0);
      user = deptMasterInfoHolder.getEmpNo();
    }
    else if (request.getSession().getAttribute("colgMaster") != null)
    {
      ColgMasterInfoHolder colgMasterInfoHolder = (ColgMasterInfoHolder)((List)request.getSession().getAttribute("colgMaster")).get(0);
      user = colgMasterInfoHolder.getEmpNo();
    }
    inputs.add(user);
    inputs.add("N");
    

    inputs.add(inForm.getOldPassword());
    inputs.add(inForm.getNewPassword());
    inputs.add(inForm.getEmail());
    inputs.add(inForm.getMobile());
    inputs.add("OWN");
    


    Collection result = new UpdatePasswordUseCase().execute(inputs, request);
    if ((result != null) && (result.size() > 0))
    {
      messages.add("wrongOldPassword", new ActionMessage("errors.wrongOldPassword"));
      returnPath = "failed";
    }
    else
    {
      messages.add("successUpdate", new ActionMessage("message.passwordChangeSuccess"));
      
      CommonOperationMessage.updateSuccess(request);
    }
    saveErrors(request, messages);
    
    return mapping.findForward(returnPath);
  }
}
