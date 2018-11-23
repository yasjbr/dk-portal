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
import ps.edu.diyar.studentInfo.forms.SrvyWorkDetailForm;
import ps.edu.diyar.studentInfo.useCase.SaveStudSocialSrvWorkDtlInfoUseCase;

public class SaveStudSocialSrvWorkDtlInfoAction
  extends Action
{
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    if (!SessionTraker.isSessionExist(request)) {
      return mapping.findForward("invalidAccess");
    }
    SrvyWorkDetailForm inForm = (SrvyWorkDetailForm)form;
    
    StudentInfoHolder studInfo = (StudentInfoHolder)((List)request.getSession().getAttribute("studentInfo")).get(0);
    


    ArrayList input = new ArrayList();
    input.add(studInfo.getStudentId());
    input.add(studInfo.getSystemCurrentTermNo());
    input.add(inForm.getWorkerType());
    input.add(inForm.getIsWork());
    input.add(inForm.getWrkSector());
    input.add(inForm.getWrkOther());
    input.add(inForm.getWrkCompany());
    input.add(inForm.getWrkJob());
    input.add(inForm.getWrkAddress());
    input.add(inForm.getWrkPhone());
    input.add(inForm.getWrkSalary());
    input.add(inForm.getWrkReason());
    
    input.add(inForm.getWrkType1());
    input.add(inForm.getWrkType2());
    

    Collection result = new SaveStudSocialSrvWorkDtlInfoUseCase().execute(input, request);
    if ((result != null) && (result.size() > 0)) {
      CommonOperationMessage.saveFailed(request);
    }
    String falg = "";
    if ((inForm.getWorkerType() != null) && (inForm.getWorkerType().trim().equals("fath"))) {
      falg = "P2";
    } else if ((inForm.getWorkerType() != null) && (inForm.getWorkerType().trim().equals("moth"))) {
      falg = "P3";
    } else if ((inForm.getWorkerType() != null) && (inForm.getWorkerType().trim().equals("wife"))) {
      falg = "P4";
    }
    return mapping.findForward("success" + falg);
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.actions.SaveStudSocialSrvWorkDtlInfoAction
 * JD-Core Version:    0.7.0.1
 */