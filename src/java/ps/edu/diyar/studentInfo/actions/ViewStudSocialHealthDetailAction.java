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
import ps.edu.diyar.studentInfo.database.SrvyHealthDetail;
import ps.edu.diyar.studentInfo.database.struct.StudentInfoHolder;
import ps.edu.diyar.studentInfo.forms.SrvyHealthDetailForm;
import ps.edu.diyar.studentInfo.useCase.ViewStudSocialHealthDetailUseCase;

public class ViewStudSocialHealthDetailAction
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
    

    ArrayList inpt = new ArrayList();
    inpt.add(studInfo.getStudentId());
    inpt.add(studInfo.getSystemCurrentTermNo());
    
    Collection result = new ViewStudSocialHealthDetailUseCase().execute(inpt, request);
    if ((result != null) && (result.size() > 0))
    {
      SrvyHealthDetail obj = (SrvyHealthDetail)result.iterator().next();
      
      inForm.setEditOpperation(true);
      
      inForm.setFamilyHasInsurance(obj.getFamilyHasInsurance());
      if (obj.getInsFamilyMembers() != null) {
        inForm.setInsFamilyMembers(String.valueOf(obj.getInsFamilyMembers()));
      }
      inForm.setInsuranceType(obj.getInsuranceType());
      inForm.setFamilyHasJerusalem(obj.getFamilyHasJerusalem());
      if (obj.getJerFamilyMembers() != null) {
        inForm.setJerFamilyMembers(String.valueOf(obj.getJerFamilyMembers()));
      }
      inForm.setIsFamilyHasChronic(obj.getIsFamilyHasChronic());
      inForm.setChronicName(obj.getChronicName());
      inForm.setPatientName(obj.getPatientName());
      if (obj.getPatientAge() != null) {
        inForm.setPatientAge(String.valueOf(obj.getPatientAge()));
      }
      inForm.setPatientRelative(obj.getPatientRelative());
      inForm.setHasDisabilities(obj.getHasDisabilities());
      if (obj.getDisabilitiesCount() != null) {
        inForm.setDisabilitiesCount(String.valueOf(obj.getDisabilitiesCount()));
      }
      inForm.setDisabilitiesDesc(obj.getDisabilitiesDesc());
      if (obj.getMedicalReport() != null) {
        request.getSession().setAttribute("showLink", Boolean.valueOf(true));
      } else {
        request.getSession().removeAttribute("showLink");
      }
    }
    return mapping.findForward("success");
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.actions.ViewStudSocialHealthDetailAction
 * JD-Core Version:    0.7.0.1
 */