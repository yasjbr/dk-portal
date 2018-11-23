package ps.edu.diyar.admission.actions;

import java.io.PrintStream;
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
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import ps.edu.diyar.admission.component.AdmComponent;
import ps.edu.diyar.admission.database.struct.AdmInfoHolder;
import ps.edu.diyar.admission.forms.AdmLoginForm;
import ps.edu.diyar.admission.useCase.GetAdmTermNoUseCase;
import ps.edu.diyar.admission.useCase.GetOpenedAdmCalenderItemUseCase;
import ps.edu.diyar.common.constant.SystemConstant;
import ps.edu.diyar.studentInfo.database.PrtlSetup;

public class AdmLoginAction
  extends Action
{
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    Collection retList = new GetOpenedAdmCalenderItemUseCase().execute(null, request);
    if ((retList == null) || (retList.size() == 0))
    {
      setMessage("errors.colsedAdmCalender", request);
      return mapping.findForward(SystemConstant.FAIL);
    }
    AdmLoginForm item = (AdmLoginForm)form;
    
    PrtlSetup prtlSetup = new PrtlSetup("", "");
    
    Collection resList = new GetAdmTermNoUseCase().execute(null, request);
    if ((resList != null) && (resList.size() > 0)) {
      prtlSetup = (PrtlSetup)resList.iterator().next();
    }
    String userId = item.getUserId().trim();
    String password = item.getPassword();
    String termNo = prtlSetup.getSetupValue();
    
    List admInfo = login(userId, password);
    if ((admInfo != null) && (admInfo.size() > 0))
    {
      AdmInfoHolder admInfoHolder = new AdmInfoHolder();
      admInfoHolder.setAdmTermNo(termNo);
      admInfoHolder.setAppNo(userId);
      

      HttpSession session = request.getSession(true);
      session.setAttribute("admInfo", admInfoHolder);
      


      return mapping.findForward(SystemConstant.SUCCESS);
    }
    setMessage("errors.userNotExist", request);
    return mapping.findForward(SystemConstant.FAIL);
  }
  
  public List login(String userId, String password)
  {
    List retList = null;
    try
    {
      retList = new AdmComponent().getAdmAccountInfo(userId, password);
    }
    catch (Exception e)
    {
      System.out.println("Error loginig user: " + e);
    }
    return retList;
  }
  
  private void setMessage(String keyMsg, HttpServletRequest request)
  {
    ActionMessages errors = new ActionMessages();
    errors.add("org.apache.struts.action.GLOBAL_MESSAGE", new ActionMessage(keyMsg));
    saveErrors(request, errors);
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.admission.actions.AdmLoginAction
 * JD-Core Version:    0.7.0.1
 */