package ps.edu.diyar.colgMaster.actions;

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
import ps.edu.diyar.colgMaster.database.struct.ColgMasterInfoHolder;
import ps.edu.diyar.colgMaster.usecase.ColgListUseCase;
import ps.edu.diyar.common.constant.SystemConstant;
import ps.edu.diyar.common.tools.SessionTraker;

public class ColgListAction
  extends Action
{
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    if (!SessionTraker.isSessionExist(request)) {
      return mapping.findForward("invalidAccess");
    }
    ColgMasterInfoHolder colgMasterInfoHolder = (ColgMasterInfoHolder)((List)request.getSession().getAttribute("colgMaster")).get(0);
    
    ArrayList input = new ArrayList();
    input.add(colgMasterInfoHolder.getCollegeNo());
    input.add(request.getParameter("tutNo"));
    Collection res = new ColgListUseCase().execute(input, request);
    if ((res != null) && (res.size() > 0)) {
      request.setAttribute("colgList", res);
    } else {
      request.setAttribute(SystemConstant.SEARCH_NOT_FOUND_RESULT, "true");
    }
    return mapping.findForward("success");
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.colgMaster.actions.ColgListAction
 * JD-Core Version:    0.7.0.1
 */