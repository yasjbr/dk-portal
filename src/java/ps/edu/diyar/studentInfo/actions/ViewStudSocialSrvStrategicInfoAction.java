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
import ps.edu.diyar.studentInfo.database.SrvyStrategic;
import ps.edu.diyar.studentInfo.database.struct.StudentInfoHolder;
import ps.edu.diyar.studentInfo.forms.SrvyStrategicForm;
import ps.edu.diyar.studentInfo.useCase.ViewStudSocialSrvStrategicInfoUseCase;

public class ViewStudSocialSrvStrategicInfoAction
  extends Action
{
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    if (!SessionTraker.isSessionExist(request)) {
      return mapping.findForward("invalidAccess");
    }
    SrvyStrategicForm inForm = (SrvyStrategicForm)form;
    
    StudentInfoHolder studInfo = (StudentInfoHolder)((List)request.getSession().getAttribute("studentInfo")).get(0);
    

    ArrayList inpt = new ArrayList();
    inpt.add(studInfo.getStudentId());
    inpt.add(studInfo.getSystemCurrentTermNo());
    
    Collection result = new ViewStudSocialSrvStrategicInfoUseCase().execute(inpt, request);
    if ((result != null) && (result.size() > 0))
    {
      SrvyStrategic obj = (SrvyStrategic)result.iterator().next();
      
      inForm.setEditOpperation(true);
      inForm.setStgcHasLoan(obj.getStgcHasLoan());
      inForm.setStgcSource(obj.getStgcSource());
      inForm.setStgcFamily(obj.getStgcFamily());
      inForm.setStgcOutsideHelp(obj.getStgcOutsideHelp());
      inForm.setStgcAffairs(obj.getStgcAffairs());
      inForm.setStgcCaseNo(obj.getStgcCaseNo());
      inForm.setStgcUnrwa(obj.getStgcUnrwa());
      inForm.setStgcUnrwaNo(obj.getStgcUnrwaNo());
      inForm.setStgcOther(obj.getStgcOther());
    }
    return mapping.findForward("success");
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.actions.ViewStudSocialSrvStrategicInfoAction
 * JD-Core Version:    0.7.0.1
 */