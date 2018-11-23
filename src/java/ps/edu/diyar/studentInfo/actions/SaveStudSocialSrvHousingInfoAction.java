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
import ps.edu.diyar.studentInfo.forms.SrvyHousingForm;
import ps.edu.diyar.studentInfo.useCase.SaveStudSocialSrvHousingInfoUseCase;

public class SaveStudSocialSrvHousingInfoAction
  extends Action
{
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    if (!SessionTraker.isSessionExist(request)) {
      return mapping.findForward("invalidAccess");
    }
    SrvyHousingForm inForm = (SrvyHousingForm)form;
    
    StudentInfoHolder studInfo = (StudentInfoHolder)((List)request.getSession().getAttribute("studentInfo")).get(0);
    


    ArrayList input = new ArrayList();
    
    input.add(studInfo.getStudentId());
    input.add(studInfo.getSystemCurrentTermNo());
    input.add(inForm.getLivePlace());
    input.add(inForm.getLiveRentCost());
    input.add(inForm.getIsLiveShare());
    input.add(inForm.getLiveHouseType());
    input.add(inForm.getLiveIsOld());
    input.add(inForm.getLiveNoRoom());
    input.add(inForm.getLiveHouseCost());
    input.add(inForm.getLiveOwnerName());
    input.add(inForm.getLiveOwnerPhone());
    input.add(inForm.getLiveHouseDistrict());
    input.add(inForm.getLiveHouseTown());
    input.add(inForm.getLiveHousePob());
    input.add(inForm.getLiveHouseStreet());
    input.add(inForm.getLiveHousePhone());
    input.add(inForm.getHasFamilyBuilding());
    input.add(inForm.getHasFamilyLand());
    input.add(inForm.getHasFamilyCar());
    
    input.add(inForm.getBldngNo());
    input.add(inForm.getBldngType());
    input.add(inForm.getBldngCount());
    input.add(inForm.getBldngUsage());
    input.add(inForm.getBldngPlace());
    
    input.add(inForm.getCarNo());
    input.add(inForm.getCarType());
    input.add(inForm.getCarYear());
    input.add(inForm.getCarCount());
    
    input.add(inForm.getLandCount());
    input.add(inForm.getLandType());
    input.add(inForm.getLandArea());
    input.add(inForm.getLandUsage());
    input.add(inForm.getLandPalce());
    


    input.add(inForm.getTblId());
    input.add(inForm.getTblOprType());
    

    Collection result = new SaveStudSocialSrvHousingInfoUseCase().execute(input, request);
    if ((result != null) && (result.size() > 0)) {
      CommonOperationMessage.saveFailed(request);
    }
    return mapping.findForward("success");
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.actions.SaveStudSocialSrvHousingInfoAction
 * JD-Core Version:    0.7.0.1
 */