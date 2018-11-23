package ps.edu.diyar.studentInfo.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import ps.edu.diyar.common.tools.SessionTraker;
import ps.edu.diyar.studentInfo.database.RegCrsWht;
import ps.edu.diyar.studentInfo.useCase.ShowCourseSummaryUseCase;
import ps.edu.diyar.studentInfo.useCase.ShowTermSummaryUseCase;
import ps.edu.diyar.studentInfo.useCase.StudentTermCourseSummaryUseCase;

public class ShowSelectedCourseSummaryAction
        extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        System.out.println("course details");
        ActionMessage message = null;
        ActionMessages messages = new ActionMessages();
        if (!SessionTraker.isSessionExist(request)) {
            return mapping.findForward("invalidAccess");
        }

        Collection selectedCourseSummary = new ShowCourseSummaryUseCase().execute(new ArrayList(), request);
        if ((selectedCourseSummary != null) && (selectedCourseSummary.size() != 0)) {
            request.setAttribute("selectedCourseSummary", selectedCourseSummary);

            Iterator it = selectedCourseSummary.iterator();
            System.out.println("sizeeee" + selectedCourseSummary.size());
            while (it.hasNext()) {
                RegCrsWht element = (RegCrsWht) it.next();
                System.out.print(element.getFirst() + " ");
                System.out.println("3ala d");
            }
        } else if (request.getAttribute("Error") != null) {
            System.out.println("error marks will not get displayed");

            message = new ActionMessage("studentInfo.messages.NotBalance");
            messages.add("org.apache.struts.action.GLOBAL_MESSAGE", message);
            saveErrors(request, messages);
        }

        return mapping.findForward("success");
    }
}
