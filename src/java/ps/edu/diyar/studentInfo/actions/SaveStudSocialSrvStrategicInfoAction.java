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
import ps.edu.diyar.admission.component.CommonOperationMessage;
import ps.edu.diyar.common.tools.SessionTraker;
import ps.edu.diyar.studentInfo.database.struct.StudentInfoHolder;
import ps.edu.diyar.studentInfo.forms.SrvyStrategicForm;
import ps.edu.diyar.studentInfo.useCase.SaveStudSocialSrvStrategicInfoUseCase;

public class SaveStudSocialSrvStrategicInfoAction
  extends Action
{
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    if (!SessionTraker.isSessionExist(request)) {
      return mapping.findForward("invalidAccess");
    }
    SrvyStrategicForm inForm = (SrvyStrategicForm)form;
    
    StudentInfoHolder studInfo = (StudentInfoHolder)((List)request.getSession().getAttribute("studentInfo")).get(0);
    


    ArrayList input = new ArrayList();
    
    input.add(studInfo.getStudentId());
    input.add(studInfo.getSystemCurrentTermNo());
    input.add(inForm.getStgcHasLoan());
    input.add(inForm.getStgcSource());
    input.add(inForm.getStgcFamily());
    input.add(inForm.getStgcOutsideHelp());
    input.add(inForm.getStgcAffairs());
    input.add(inForm.getStgcCaseNo());
    input.add(inForm.getStgcUnrwa());
    input.add(inForm.getStgcUnrwaNo());
    input.add(inForm.getStgcOther());
    
    Collection result = new SaveStudSocialSrvStrategicInfoUseCase().execute(input, request);
    if ((result != null) && (result.size() > 0)) {
      CommonOperationMessage.saveFailed(request);
    }
    return mapping.findForward("success");
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.actions.SaveStudSocialSrvStrategicInfoAction
 * JD-Core Version:    0.7.0.1
 */