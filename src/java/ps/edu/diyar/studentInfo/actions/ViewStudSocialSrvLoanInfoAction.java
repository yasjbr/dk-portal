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
import ps.edu.diyar.common.tools.SessionTraker;
import ps.edu.diyar.studentInfo.database.SrvyLoan;
import ps.edu.diyar.studentInfo.database.struct.StudentInfoHolder;
import ps.edu.diyar.studentInfo.forms.SrvyLoanForm;
import ps.edu.diyar.studentInfo.useCase.ViewStudSocialSrvLoanInfoUseCase;

public class ViewStudSocialSrvLoanInfoAction
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
    

    ArrayList inpt = new ArrayList();
    inpt.add(studInfo.getStudentId());
    inpt.add(studInfo.getSystemCurrentTermNo());
    
    Collection result = new ViewStudSocialSrvLoanInfoUseCase().execute(inpt, request);
    if ((result != null) && (result.size() > 0))
    {
      SrvyLoan obj = (SrvyLoan)result.iterator().next();
      
      inForm.setEditOpperation(true);
      
      inForm.setApplyLoan(obj.getApplyLoan());
      inForm.setApplyReason(obj.getApplyReason());
      inForm.setTakeLoan(obj.getTakeLoan());
      inForm.setLoanType(obj.getLoanType());
      inForm.setLoanPeriod(obj.getLoanPeriod());
      if (obj.getLoanTermCount() != null) {
        inForm.setLoanTermCount(String.valueOf(obj.getLoanTermCount()));
      }
      inForm.setHasFamilyLoan(obj.getHasFamilyLoan());
    }
    return mapping.findForward("success");
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.actions.ViewStudSocialSrvLoanInfoAction
 * JD-Core Version:    0.7.0.1
 */