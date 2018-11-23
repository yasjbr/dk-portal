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
import ps.edu.diyar.studentInfo.forms.SrvyLoanForm;
import ps.edu.diyar.studentInfo.useCase.SaveStudSocialSrvLoanInfoUseCase;

public class SaveStudSocialSrvLoanInfoAction
  extends Action
{
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    if (!SessionTraker.isSessionExist(request)) {
      return mapping.findForward("invalidAccess");
    }
    SrvyLoanForm inForm = (SrvyLoanForm)form;
    
    StudentInfoHolder studInfo = (StudentInfoHolder)((List)request.getSession().getAttribute("studentInfo")).get(0);
    


    ArrayList input = new ArrayList();
    
    input.add(studInfo.getStudentId());
    input.add(studInfo.getSystemCurrentTermNo());
    input.add(inForm.getApplyLoan());
    input.add(inForm.getApplyReason());
    input.add(inForm.getTakeLoan());
    input.add(inForm.getLoanType());
    input.add(inForm.getLoanPeriod());
    input.add(inForm.getLoanTermCount());
    input.add(inForm.getHasFamilyLoan());
    

    input.add(inForm.getFmlyCounter());
    input.add(inForm.getFmlyLoaner());
    input.add(inForm.getFmlyType());
    input.add(inForm.getFmlyAmount());
    input.add(inForm.getFmlyPeriod());
    

    input.add(inForm.getPrsnCounter());
    input.add(inForm.getPrsnLoaner());
    input.add(inForm.getPrsnAmount());
    input.add(inForm.getPrsnDate());
    

    input.add(inForm.getTblId());
    input.add(inForm.getTblOprType());
    

    Collection result = new SaveStudSocialSrvLoanInfoUseCase().execute(input, request);
    if ((result != null) && (result.size() > 0)) {
      CommonOperationMessage.saveFailed(request);
    }
    return mapping.findForward("success");
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.actions.SaveStudSocialSrvLoanInfoAction
 * JD-Core Version:    0.7.0.1
 */