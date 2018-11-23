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
import ps.edu.diyar.common.tools.SessionTraker;
import ps.edu.diyar.studentInfo.database.struct.StudentInfoHolder;
import ps.edu.diyar.studentInfo.forms.SrvyWorkRelativeForm;
import ps.edu.diyar.studentInfo.useCase.ViewStudSocialSrvWorkRelativeInfoUseCase;

public class ViewStudSocialSrvWorkRelativeInfoAction
  extends Action
{
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    if (!SessionTraker.isSessionExist(request)) {
      return mapping.findForward("invalidAccess");
    }
    StudentInfoHolder studInfo = (StudentInfoHolder)((List)request.getSession().getAttribute("studentInfo")).get(0);
    

    String wrlIsLiveIn = request.getParameter("liveIn");
    if (request.getAttribute("liveIn") != null) {
      wrlIsLiveIn = (String)request.getAttribute("liveIn");
    }
    ArrayList inpt = new ArrayList();
    inpt.add(studInfo.getStudentId());
    inpt.add(studInfo.getSystemCurrentTermNo());
    inpt.add(wrlIsLiveIn);
    Collection retList = new ViewStudSocialSrvWorkRelativeInfoUseCase().execute(inpt, request);
    if ((retList != null) && (retList.size() > 0)) {
      request.setAttribute("srvWrlDataList", retList);
    }
    SrvyWorkRelativeForm inForm = (SrvyWorkRelativeForm)form;
    inForm.setWrlIsLiveIn(wrlIsLiveIn);
    

    return mapping.findForward("success");
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.actions.ViewStudSocialSrvWorkRelativeInfoAction
 * JD-Core Version:    0.7.0.1
 */