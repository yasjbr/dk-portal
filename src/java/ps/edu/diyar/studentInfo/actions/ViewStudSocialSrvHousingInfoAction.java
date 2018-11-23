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
import ps.edu.diyar.admission.useCase.GetGovernateListUseCase;
import ps.edu.diyar.common.tools.SessionTraker;
import ps.edu.diyar.studentInfo.database.SrvyHousing;
import ps.edu.diyar.studentInfo.database.struct.StudentInfoHolder;
import ps.edu.diyar.studentInfo.forms.SrvyHousingForm;
import ps.edu.diyar.studentInfo.useCase.ViewStudSocialSrvHousingInfoUseCase;

public class ViewStudSocialSrvHousingInfoAction
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
    

    ArrayList inpt = new ArrayList();
    inpt.add(studInfo.getStudentId());
    inpt.add(studInfo.getSystemCurrentTermNo());
    
    Collection result = new ViewStudSocialSrvHousingInfoUseCase().execute(inpt, request);
    if ((result != null) && (result.size() > 0))
    {
      SrvyHousing obj = (SrvyHousing)result.iterator().next();
      
      inForm.setEditOpperation(true);
      
      inForm.setLivePlace(obj.getLivePlace());
      if (obj.getLiveRentCost() != null) {
        inForm.setLiveRentCost(String.valueOf(obj.getLiveRentCost()));
      }
      inForm.setIsLiveShare(obj.getIsLiveShare());
      inForm.setLiveHouseType(obj.getLiveHouseType());
      inForm.setLiveIsOld(obj.getLiveIsOld());
      if (obj.getLiveNoRoom() != null) {
        inForm.setLiveNoRoom(String.valueOf(obj.getLiveNoRoom()));
      }
      if (obj.getLiveHouseCost() != null) {
        inForm.setLiveHouseCost(String.valueOf(obj.getLiveHouseCost()));
      }
      inForm.setLiveOwnerName(obj.getLiveOwnerName());
      inForm.setLiveOwnerPhone(obj.getLiveOwnerPhone());
      inForm.setLiveHouseDistrict(obj.getLiveHouseDistrict());
      inForm.setLiveHouseTown(obj.getLiveHouseTown());
      inForm.setLiveHousePob(obj.getLiveHousePob());
      inForm.setLiveHouseStreet(obj.getLiveHouseStreet());
      inForm.setLiveHousePhone(obj.getLiveHousePhone());
      inForm.setHasFamilyBuilding(obj.getHasFamilyBuilding());
      inForm.setHasFamilyLand(obj.getHasFamilyLand());
      inForm.setHasFamilyCar(obj.getHasFamilyCar());
    }
    ArrayList inp = new ArrayList();
    inp.add("1");
    Collection resultList = new GetGovernateListUseCase().execute(inp, request);
    if ((resultList != null) && (resultList.size() > 0)) {
      request.setAttribute("governateList", resultList);
    }
    return mapping.findForward("success");
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.actions.ViewStudSocialSrvHousingInfoAction
 * JD-Core Version:    0.7.0.1
 */