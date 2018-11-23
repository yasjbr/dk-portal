package ps.edu.diyar.deptMaster.actions;

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
import ps.edu.diyar.common.constant.SystemConstant;
import ps.edu.diyar.common.tools.SessionTraker;
import ps.edu.diyar.deptMaster.database.struct.DeptMasterInfoHolder;
import ps.edu.diyar.deptMaster.usecase.TutorsDeptListUseCase;

public class TutorsDeptListAction
  extends Action
{
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    if (!SessionTraker.isSessionExist(request)) {
      return mapping.findForward("invalidAccess");
    }
    String deptNo = "";
    if (request.getSession().getAttribute("deptMaster") != null)
    {
      DeptMasterInfoHolder deptMasterInfo = (DeptMasterInfoHolder)((List)request.getSession().getAttribute("deptMaster")).get(0);
      deptNo = deptMasterInfo.getDeptNo();
    }
    else if (request.getSession().getAttribute("colgMaster") != null)
    {
      deptNo = request.getParameter("deptNo");
      request.getSession().setAttribute("browseDept", deptNo);
    }
    ArrayList input = new ArrayList();
    input.add(deptNo);
    Collection res = new TutorsDeptListUseCase().execute(input, request);
    if ((res != null) && (res.size() > 0)) {
      request.setAttribute("tutDptList", res);
    } else {
      request.setAttribute(SystemConstant.SEARCH_NOT_FOUND_RESULT, "true");
    }
    return mapping.findForward("success");
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.deptMaster.actions.TutorsDeptListAction
 * JD-Core Version:    0.7.0.1
 */