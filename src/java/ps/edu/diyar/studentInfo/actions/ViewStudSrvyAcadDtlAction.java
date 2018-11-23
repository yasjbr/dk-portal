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
import ps.edu.diyar.studentInfo.useCase.ViewStudSrvyAcadDtlDataUseCase;
import ps.edu.diyar.studentInfo.useCase.ViewStudSrvyAcadDtlUseCase;

public class ViewStudSrvyAcadDtlAction
  extends Action
{
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    if (!SessionTraker.isSessionExist(request)) {
      return mapping.findForward("invalidAccess");
    }
    StudentInfoHolder studInfo = (StudentInfoHolder)((List)request.getSession().getAttribute("studentInfo")).get(0);
    

    String relativeType = request.getParameter("relativeType");
    
    ArrayList input = new ArrayList();
    input.add(studInfo.getStudentId());
    input.add(studInfo.getSystemCurrentTermNo());
    input.add(relativeType);
    
    Collection retList = new ViewStudSrvyAcadDtlUseCase().execute(input, request);
    if ((retList != null) && (retList.size() > 0)) {
      request.setAttribute("srvAcadDtl", retList);
    }
    new ViewStudSrvyAcadDtlDataUseCase().execute(null, request);
    


    return mapping.findForward("successP" + relativeType);
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.actions.ViewStudSrvyAcadDtlAction
 * JD-Core Version:    0.7.0.1
 */