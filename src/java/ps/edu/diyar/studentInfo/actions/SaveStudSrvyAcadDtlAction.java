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
import ps.edu.diyar.common.tools.Randomizer;
import ps.edu.diyar.common.tools.SessionTraker;
import ps.edu.diyar.studentInfo.database.struct.StudentInfoHolder;
import ps.edu.diyar.studentInfo.forms.StudSocialSurveyAcadDtlForm;
import ps.edu.diyar.studentInfo.useCase.SaveStudSrvyAcadDtlUseCase;
import ps.edu.diyar.studentInfo.useCase.ViewStudSrvyAcadDtlDataUseCase;

public class SaveStudSrvyAcadDtlAction
  extends Action
{
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    if (!SessionTraker.isSessionExist(request)) {
      return mapping.findForward("invalidAccess");
    }
    StudSocialSurveyAcadDtlForm inForm = (StudSocialSurveyAcadDtlForm)form;
    
    StudentInfoHolder studInfo = (StudentInfoHolder)((List)request.getSession().getAttribute("studentInfo")).get(0);
    

    ArrayList input = new ArrayList();
    
    input.add(studInfo.getStudentId());
    input.add(studInfo.getSystemCurrentTermNo());
    input.add(inForm.getRelativeType());
    input.add(inForm.getRelativeAName());
    input.add(inForm.getEnroleDate());
    input.add(inForm.getCountryNo());
    input.add(inForm.getCollegeNo());
    input.add(inForm.getYearlyCost());
    input.add(inForm.getDonarAName());
    input.add(inForm.getRelativeStudNo());
    input.add(inForm.getSchoolNo());
    input.add(inForm.getSchoolType());
    input.add(inForm.getAcademicSeq());
    input.add(inForm.getOperType());
    
    Collection result = new SaveStudSrvyAcadDtlUseCase().execute(input, request);
    if ((result != null) && (result.size() > 0))
    {
      if ((inForm.getOperType() != null) && (inForm.getOperType().equals("3"))) {
        CommonOperationMessage.deleteFailed(request);
      } else {
        CommonOperationMessage.saveFailed(request);
      }
      new ViewStudSrvyAcadDtlDataUseCase().execute(null, request);
      request.setAttribute("viDvAdd", (inForm.getOperType() != null) && (!inForm.getOperType().equals("")) ? inForm.getOperType() : "1");
      return mapping.findForward("failedP" + inForm.getRelativeType());
    }
    String path = mapping.findForward(new StringBuilder().append("successP").append(inForm.getRelativeType()).toString()).getPath() + "?relativeType=" + inForm.getRelativeType() + "&.rv=" + Randomizer.shortRandom();
    if ((inForm.getOperType() != null) && (inForm.getOperType().equals("3"))) {}
    inForm.reset();
    return new ActionForward(path);
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.actions.SaveStudSrvyAcadDtlAction
 * JD-Core Version:    0.7.0.1
 */