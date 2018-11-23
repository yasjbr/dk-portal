package ps.edu.diyar.deptMaster.actions;

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
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import ps.edu.diyar.common.tools.SessionTraker;
import ps.edu.diyar.deptMaster.database.struct.DeptMasterInfoHolder;
import ps.edu.diyar.studentInfo.database.struct.StudentInfoHolder;
import ps.edu.diyar.studentInfo.useCase.GetStudentInfoUseCase;

public class LoadStudentRegCrsInfoAction
  extends Action
{
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    if (!SessionTraker.isSessionExist(request)) {
      return mapping.findForward("invalidAccess");
    }
    String studId = request.getParameter("studId");
    
    String studSpecTypeNo = null;
    String studSpecNo = null;
    String studMajorSheet = null;
    

    DeptMasterInfoHolder deptMasterInfoHolder = (DeptMasterInfoHolder)((List)request.getSession().getAttribute("deptMaster")).get(0);
    
    boolean studInDpt = false;
    
    ArrayList input = new ArrayList();
    input.add(studId);
    Collection retList = new GetStudentInfoUseCase().execute(input, request);
    if ((retList != null) && (retList.size() > 0))
    {
      StudentInfoHolder studentInfoHolder = (StudentInfoHolder)retList.iterator().next();
      if ((studentInfoHolder.getDeptNo() != null) && (deptMasterInfoHolder.getDeptNo() != null) && (studentInfoHolder.getDeptNo().equals(deptMasterInfoHolder.getDeptNo()))) {
        studInDpt = true;
      }
      if (!studInDpt)
      {
        ActionMessages errors = new ActionMessages();
        errors.add("error.errorOccuered", new ActionMessage("portal.error.studNotInDpt"));
        saveErrors(request, errors);
        return mapping.findForward("fail");
      }
      studSpecTypeNo = studentInfoHolder.getSpecTypeNo();
      studSpecNo = studentInfoHolder.getSpecializationNo();
      studMajorSheet = studentInfoHolder.getMajorSheet();
    }
    else
    {
      ActionMessages errors = new ActionMessages();
      errors.add("error.errorOccuered", new ActionMessage("portal.error.studNotInDpt"));
      saveErrors(request, errors);
      return mapping.findForward("fail");
    }
    return new ActionForward(mapping.findForward("success").getPath() + "?studId=" + studId + "&studSpecTypeNo=" + studSpecTypeNo + "&studSpecNo=" + studSpecNo + "&studMajorSheet=" + studMajorSheet);
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.deptMaster.actions.LoadStudentRegCrsInfoAction
 * JD-Core Version:    0.7.0.1
 */