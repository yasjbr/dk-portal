package ps.edu.diyar.studentInfo.actions;

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
import ps.edu.diyar.common.component.AuditInfo;
import ps.edu.diyar.common.component.ServletContextAttribute;
import ps.edu.diyar.common.tools.SessionTraker;
import ps.edu.diyar.login.database.struct.UserInfo;
import ps.edu.diyar.studentInfo.component.StudCourseRegComponent;
import ps.edu.diyar.studentInfo.database.struct.StudentInfoHolder;

public class DeleteRegedCourseAction
  extends Action
{
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    if (!SessionTraker.isSessionExist(request)) {
      return mapping.findForward("invalidAccess");
    }
    if (!request.getMethod().equalsIgnoreCase("POST"))
    {
      ActionMessages errors = new ActionMessages();
      errors.add("error.errorOccuered", new ActionMessage("portal.error.internalMessage", "Invalid Access Method!"));
      saveErrors(request, errors);
      return mapping.findForward("result");
    }
    String studId = "";
    if (request.getSession().getAttribute("studentInfo") != null)
    {
      StudentInfoHolder studInfo = (StudentInfoHolder)((List)request.getSession().getAttribute("studentInfo")).get(0);
      studId = studInfo.getStudentId();
    }
    else if (request.getSession().getAttribute("deptMaster") != null)
    {
      studId = request.getParameter("stud_id");
    }
    ActionMessages errors = new ActionMessages();
    ServletContextAttribute scmp = new ServletContextAttribute(request);
    
    AuditInfo auditInfo = new AuditInfo(request);
    UserInfo userInfo = auditInfo.getUserLoginInfo();
    String userId = userInfo.getUserId();
    String remoteAddr = request.getRemoteAddr();
    
    String crsNo = request.getParameter("no");
    int crsHours = Integer.parseInt(request.getParameter("hrs"));
    String regCalItem = (String)request.getSession().getAttribute("currentRegCalItem");
    String regTerm = scmp.getCrsRegTerm();
    if ((crsNo == null) || (crsNo.equalsIgnoreCase(""))) {
      return mapping.findForward("result");
    }
    StudCourseRegComponent cmp = new StudCourseRegComponent();
    String result = cmp.deleteCourse(studId, regTerm, crsNo, crsHours, regCalItem, userId, remoteAddr);
    if ((result == null) || (result.length() <= 0)) {
      result = "تمت عملية الحذف";
    }
    errors.add("error.errorOccuered", new ActionMessage("portal.error.internalError", result));
    saveErrors(request, errors);
    if (request.getSession().getAttribute("deptMaster") != null) {
      return new ActionForward(mapping.findForward("success").getPath() + "?studId=" + studId);
    }
    return mapping.findForward("result");
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.actions.DeleteRegedCourseAction
 * JD-Core Version:    0.7.0.1
 */