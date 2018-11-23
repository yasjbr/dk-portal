package ps.edu.diyar.login.actions;

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
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import ps.edu.diyar.colgMaster.usecase.GetColgMasterInfoUseCase;
import ps.edu.diyar.deptMaster.usecase.GetDeptMasterInfoUseCase;
import ps.edu.diyar.login.database.struct.UserInfo;
import ps.edu.diyar.login.forms.LoginForm;
import ps.edu.diyar.login.usecase.LoginUseCase;
import ps.edu.diyar.messaging.database.PrtlNotifications;
import ps.edu.diyar.studentInfo.useCase.GetNotificationsUseCase;
import ps.edu.diyar.studentInfo.useCase.GetStudentInfoUseCase;
import ps.edu.diyar.tutorInfo.useCase.GetTutorInfoUseCase;

public class LoginAction
  extends Action
{
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    LoginForm item = (LoginForm)form;
    
    ActionMessages errors = new ActionMessages();
    
    String userId = item.getUserId().trim();
    String userPwd = item.getPassword();
    HttpSession session = request.getSession(true);
    
    ArrayList input = new ArrayList();
    input.add(userId);
    input.add(userPwd);
    
    Collection retList = new LoginUseCase().execute(input, request);
    if ((retList != null) && (retList.size() > 0))
    {
      UserInfo userInfo = (UserInfo)retList.iterator().next();
      session.setAttribute("userInfo", userInfo);
      
       /////////////////// Get Notifications
       ArrayList notInput = new ArrayList();
       notInput.add(userId);
       Collection notRetList = new GetNotificationsUseCase().execute(input, request);
       if ((notRetList != null) && (notRetList.size() > 0))
    {
       session.setAttribute("userNotifications", notRetList); 
       Iterator itd = notRetList.iterator();
       while (itd.hasNext()) {
          PrtlNotifications  ds = (PrtlNotifications) itd.next();
           System.out.println("dd"+ds.getNotMsg());
       }
    }
   
       
       ////////////////////////////////
      int roleId = userInfo.getRoleid().intValue();
      String roleLayout = userInfo.getRoleCat();
      boolean userAccountNotValid = false;
      switch (roleId)
      {
      case 1: 
          System.out.println("case 1");
        ArrayList inputStudInfo = new ArrayList();
        inputStudInfo.add(item.getUserId());
        Collection studentInfo = new GetStudentInfoUseCase().execute(inputStudInfo, request);
        if (studentInfo != null) {
          session.setAttribute("studentInfo", studentInfo);
        } else {
          userAccountNotValid = true;
        }
        break;
      case 2: 
          System.out.println("case 2");
        ArrayList inputTutorInfo = new ArrayList();
        inputTutorInfo.add(item.getUserId());
        Collection tutorInfo = new GetTutorInfoUseCase().execute(inputTutorInfo, request);
        if (tutorInfo != null) {
          session.setAttribute("tutorInfo", tutorInfo);
        } else {
          userAccountNotValid = true;
        }
        break;
      case 3: 
          System.out.println("case 3");
        ArrayList inputDeptMasterInfo = new ArrayList();
        inputDeptMasterInfo.add(item.getUserId());
        Collection deptMasterInfo = new GetDeptMasterInfoUseCase().execute(inputDeptMasterInfo, request);
        if (deptMasterInfo != null) {
          session.setAttribute("deptMaster", deptMasterInfo);
        } else {
          userAccountNotValid = true;
        }
        break;
      case 4: 
          System.out.println("case 4");
        ArrayList inputColgMasterInfo = new ArrayList();
        inputColgMasterInfo.add(item.getUserId());
        Collection colgMasterInfo = new GetColgMasterInfoUseCase().execute(inputColgMasterInfo, request);
        if (colgMasterInfo != null) {
          session.setAttribute("colgMaster", colgMasterInfo);
        } else {
          userAccountNotValid = true;
        }
        break;
      }
      if (userAccountNotValid)
      {
        session.invalidate();
        errors.add("org.apache.struts.action.GLOBAL_MESSAGE", new ActionMessage("errors.userAccountNotValid"));
        saveErrors(request, errors);
        return mapping.findForward("fail");
      }
      session.setAttribute("userLogged", "true");
      return mapping.findForward(roleLayout);
    }
    Integer logAttemptsCount = Integer.valueOf(1);
    if (session.getAttribute("logAttemptsCount") != null) {
      logAttemptsCount = Integer.valueOf(((Integer)session.getAttribute("logAttemptsCount")).intValue() + 1);
    }
    session.setAttribute("logAttemptsCount", logAttemptsCount);
    if (logAttemptsCount.intValue() >= 3) {
      session.setAttribute("captchImageRequired", "captchImageRequired");
    }
    errors.add("org.apache.struts.action.GLOBAL_MESSAGE", new ActionMessage("errors.userNotExist"));
    saveErrors(request, errors);
    



    return mapping.findForward("fail");
  }
}

 