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
import ps.edu.diyar.admission.component.CommonOperationMessage;
import ps.edu.diyar.common.component.ServletContextAttribute;
import ps.edu.diyar.common.tools.SessionTraker;
import ps.edu.diyar.deptMaster.database.struct.DeptMasterInfoHolder;
import ps.edu.diyar.deptMaster.usecase.UnApproveRegStudUseCase;
import ps.edu.diyar.studentInfo.database.struct.StudentInfoHolder;
import ps.edu.diyar.studentInfo.useCase.GetStudentInfoUseCase;

public class UnApproveRegStudAction
  extends Action
{
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    if (!SessionTraker.isSessionExist(request)) {
      return mapping.findForward("invalidAccess");
    }
    String deptNo = "";
    if (request.getSession().getAttribute("deptMaster") != null)
    {
      DeptMasterInfoHolder deptMasterInfo = (DeptMasterInfoHolder)((List)request.getSession().getAttribute("deptMaster")).get(0);
      deptNo = deptMasterInfo.getDeptNo();
    }
    ServletContextAttribute scmp = new ServletContextAttribute(request);
    
    String studId = request.getParameter("studId");
    String calItem = request.getParameter("calItem");
    String regTermNo = scmp.getCrsRegTerm();
    
    ArrayList input = new ArrayList();
    input.add(studId);
    Collection retList = new GetStudentInfoUseCase().execute(input, request);
    if ((retList != null) && (retList.size() > 0))
    {
      StudentInfoHolder studentInfoHolder = (StudentInfoHolder)retList.iterator().next();
      if ((studentInfoHolder.getDeptNo() != null) && (deptNo != null) && (!studentInfoHolder.getDeptNo().equals(deptNo)))
      {
        ActionMessages errors = new ActionMessages();
        errors.add("error.errorOccuered", new ActionMessage("portal.error.studNotInDpt"));
        saveErrors(request, errors);
        return mapping.findForward("fail");
      }
    }
    else
    {
      ActionMessages errors = new ActionMessages();
      errors.add("error.errorOccuered", new ActionMessage("portal.error.studNotInDpt"));
      saveErrors(request, errors);
      return mapping.findForward("fail");
    }
    ArrayList inpt = new ArrayList();
    inpt.add(studId);
    inpt.add(regTermNo);
    inpt.add(calItem);
    Collection resList = new UnApproveRegStudUseCase().execute(inpt, request);
    if ((resList != null) && (resList.size() > 0)) {
      CommonOperationMessage.updateFailed(request);
    } else {
      CommonOperationMessage.updateSuccess(request);
    }
    return mapping.findForward("success");
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.deptMaster.actions.UnApproveRegStudAction
 * JD-Core Version:    0.7.0.1
 */