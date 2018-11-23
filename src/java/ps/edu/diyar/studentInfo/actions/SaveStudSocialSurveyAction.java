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
import ps.edu.diyar.common.component.AuditInfo;
import ps.edu.diyar.common.tools.SessionTraker;
import ps.edu.diyar.studentInfo.database.struct.StudentInfoHolder;
import ps.edu.diyar.studentInfo.forms.StudSocialSurveyForm;
import ps.edu.diyar.studentInfo.useCase.SaveStudSocialSurveyUseCase;

public class SaveStudSocialSurveyAction
  extends Action
{
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    if (!SessionTraker.isSessionExist(request)) {
      return mapping.findForward("invalidAccess");
    }
    StudSocialSurveyForm inForm = (StudSocialSurveyForm)form;
    
    StudentInfoHolder studInfo = (StudentInfoHolder)((List)request.getSession().getAttribute("studentInfo")).get(0);
    


    ArrayList input = new ArrayList();
    input.add(studInfo.getStudentId());
    input.add(studInfo.getSystemCurrentTermNo());
    input.add(inForm.getFatherAName());
    input.add(inForm.getFatherIdCardType());
    input.add(inForm.getFatherIdCard());
    input.add(inForm.getFatherDob());
    input.add(inForm.getFatherAcademicLevel());
    input.add(inForm.getMotherAName());
    input.add(inForm.getMotherIdCardType());
    input.add(inForm.getMotherIdCard());
    input.add(inForm.getMotherDob());
    input.add(inForm.getMotherAcademicLevel());
    input.add(inForm.getFamilyCountAll());
    input.add(inForm.getFamilyCountUnder18());
    input.add(inForm.getBrothersCount());
    input.add(inForm.getSistersCount());
    input.add(inForm.getOtherMaleCount());
    input.add(inForm.getOtherFemaleCount());
    input.add(inForm.getWifeOneAName());
    input.add(inForm.getWifeOneDob());
    input.add(inForm.getWifeOneIdCardType());
    input.add(inForm.getWifeOneIdCard());
    input.add(inForm.getWifeOneAcadmicLevel());
    input.add(inForm.getChildrenCount());
    input.add(inForm.getOtherAcademicExpensive());
    input.add(inForm.getOtherAcademicCost());
    input.add(inForm.getHaveOtherWork());
    input.add(inForm.getOtherWork());
    input.add(inForm.getOtherWorkCrossIncome());
    input.add(inForm.getFamilyIncome());
    input.add(inForm.getFamilyUnemployed());
    input.add(inForm.getUnemployedResons());
    input.add(inForm.getPayer());
    input.add(inForm.getOtherPayer());
    input.add(studInfo.getStudentId());
    input.add(new AuditInfo(request).getRemoteIp());
    
    Collection result = new SaveStudSocialSurveyUseCase().execute(input, request);
    if ((result != null) && (result.size() > 0)) {
      CommonOperationMessage.saveFailed(request);
    } else {
      CommonOperationMessage.saveSuccess(request);
    }
    return mapping.findForward("success");
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.actions.SaveStudSocialSurveyAction
 * JD-Core Version:    0.7.0.1
 */