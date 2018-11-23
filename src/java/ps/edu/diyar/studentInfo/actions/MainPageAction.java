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
import ps.edu.diyar.studentInfo.database.struct.StudentInfoHolder;
import ps.edu.diyar.studentInfo.useCase.ChkShowPrintPayRepUseCase;
import ps.edu.diyar.studentInfo.useCase.GetUnreadInboxMsgCountUseCase;

public class MainPageAction
  extends Action
{
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    if (!SessionTraker.isSessionExist(request)) {
      return mapping.findForward("invalidAccess");
    }
    HttpSession session = request.getSession();
    
    StudentInfoHolder studInfo = (StudentInfoHolder)((List)session.getAttribute("studentInfo")).get(0);
    if (session.getAttribute("showPayRep") == null)
    {
      ArrayList inpt = new ArrayList();
      inpt.add(studInfo.getStudentId());
      Collection retList = new ChkShowPrintPayRepUseCase().execute(inpt, request);
      if ((retList != null) && (retList.size() > 0))
      {
        String res = (String)retList.iterator().next();
        if ((res != null) && (res.equals("Y"))) {
          session.setAttribute("showPayRep", "Y");
        } else {
          session.setAttribute("showPayRep", "N");
        }
      }
    }
    new GetUnreadInboxMsgCountUseCase().execute(null, request);
    


    return mapping.findForward("mainPage");
  }
}



/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\

 * Qualified Name:     ps.edu.diyar.studentInfo.actions.MainPageAction

 * JD-Core Version:    0.7.0.1

 */