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
import ps.edu.diyar.studentInfo.forms.SrvyHealthDetailForm;
import ps.edu.diyar.studentInfo.useCase.SaveStudSocialHealthDetailUseCase;

public class SaveStudSocialHealthDetailAction
  extends Action
{
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    if (!SessionTraker.isSessionExist(request)) {
      return mapping.findForward("invalidAccess");
    }
    SrvyHealthDetailForm inForm = (SrvyHealthDetailForm)form;
    
    StudentInfoHolder studInfo = (StudentInfoHolder)((List)request.getSession().getAttribute("studentInfo")).get(0);
    


    ArrayList input = new ArrayList();
    
    input.add(studInfo.getStudentId());
    input.add(studInfo.getSystemCurrentTermNo());
    input.add(inForm.getFamilyHasInsurance());
    input.add(inForm.getInsFamilyMembers());
    input.add(inForm.getInsuranceType());
    input.add(inForm.getFamilyHasJerusalem());
    input.add(inForm.getJerFamilyMembers());
    input.add(inForm.getIsFamilyHasChronic());
    input.add(inForm.getChronicName());
    input.add(inForm.getMedicalReport());
    input.add(inForm.getPatientName());
    input.add(inForm.getPatientAge());
    input.add(inForm.getPatientRelative());
    input.add(inForm.getHasDisabilities());
    input.add(inForm.getDisabilitiesCount());
    input.add(inForm.getDisabilitiesDesc());
    


    Collection result = new SaveStudSocialHealthDetailUseCase().execute(input, request);
    if ((result != null) && (result.size() > 0)) {
      CommonOperationMessage.saveFailed(request);
    }
    return mapping.findForward("success");
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.actions.SaveStudSocialHealthDetailAction
 * JD-Core Version:    0.7.0.1
 */