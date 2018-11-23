package ps.edu.diyar.studentInfo.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import ps.edu.diyar.colgMaster.database.struct.ColgMasterInfoHolder;
import ps.edu.diyar.common.tools.SessionTraker;
import ps.edu.diyar.deptMaster.database.struct.DeptMasterInfoHolder;
import ps.edu.diyar.login.database.PrtlSecUser;
import ps.edu.diyar.studentInfo.database.struct.StudentInfoHolder;
import ps.edu.diyar.studentInfo.forms.UpdatePasswordForm;
import ps.edu.diyar.studentInfo.useCase.GetUserInfoUseCase;
import ps.edu.diyar.tutorInfo.database.struct.TutorInfoHolder;

public class ChangePasswordAction
  extends Action
{
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    if (!SessionTraker.isSessionExist(request)) {
      return mapping.findForward("invalidAccess");
    }
    UpdatePasswordForm inputForm = (UpdatePasswordForm)form;
    
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
    if (request.getAttribute("org.apache.struts.actions.ERROR") == null)
    {
      ArrayList input = new ArrayList();
      input.add(user);
      


      Collection userData = new GetUserInfoUseCase().execute(input, request);
      if ((userData != null) && (userData.size() > 0))
      {
        PrtlSecUser prtlSecUser = (PrtlSecUser)userData.iterator().next();
        
        inputForm.setEmail(prtlSecUser.getEmail());
        inputForm.setMobile(prtlSecUser.getMobile());
        inputForm.setSmsReg((prtlSecUser.getSmsReg() != null) && (prtlSecUser.getSmsReg().equalsIgnoreCase("Y")) ? "on" : "");
      }
    }
    return mapping.findForward("showPage");
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.actions.ChangePasswordAction
 * JD-Core Version:    0.7.0.1
 */