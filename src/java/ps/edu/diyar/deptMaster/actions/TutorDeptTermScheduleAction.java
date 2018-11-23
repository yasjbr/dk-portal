package ps.edu.diyar.deptMaster.actions;

import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import ps.edu.diyar.common.tools.SessionTraker;
import ps.edu.diyar.deptMaster.usecase.DeptTutorTermListUseCase;
import ps.edu.diyar.deptMaster.usecase.ShowDeptTutorTermScheduleUseCase;
import ps.edu.diyar.tutorInfo.useCase.ShowTutorTermScheduleUseCase;
import ps.edu.diyar.tutorInfo.useCase.TutorTermListUseCase;

public class TutorDeptTermScheduleAction
        extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        if (!SessionTraker.isSessionExist(request)) {
            return mapping.findForward("invalidAccess");
        }
        HttpSession session = request.getSession();

        if (request.getParameter("tutNo") != null) {
            session.setAttribute("selectedTutor", request.getParameter("tutNo"));
        }

        Collection termsList = new DeptTutorTermListUseCase().execute(new ArrayList(), request);
        if ((termsList != null) && (termsList.size() != 0)) {
            session.setAttribute("termsList", termsList);
        }


        
    Collection termSchedule = new ShowDeptTutorTermScheduleUseCase().execute(new ArrayList(), request);
    if ((termSchedule != null) && (termSchedule.size() != 0)) {
      request.setAttribute("tutorTermSchedule", termSchedule);
    }
         
        return mapping.findForward("success");
    }
}

 
