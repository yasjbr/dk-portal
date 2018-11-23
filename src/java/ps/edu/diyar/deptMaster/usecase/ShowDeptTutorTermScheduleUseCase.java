package ps.edu.diyar.deptMaster.usecase;

import ps.edu.diyar.tutorInfo.useCase.*;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.hibernate.HibernateException;
import ps.edu.diyar.common.tools.RequestSelectedTermIndexBinder;
import ps.edu.diyar.common.useCase.ComponentUseCase;
import ps.edu.diyar.common.utils.TermsList;
import ps.edu.diyar.deptMaster.database.struct.DeptMasterInfoHolder;
import ps.edu.diyar.tutorInfo.component.TutorTermScheduleComponent;
import ps.edu.diyar.tutorInfo.database.struct.TutorInfoHolder;

public class ShowDeptTutorTermScheduleUseCase
        implements ComponentUseCase {

    public Collection execute(Collection input, HttpServletRequest request)
            throws HibernateException {
        List termsList = null;
        String empNo = null;
        try {

            DeptMasterInfoHolder dptMstr = (DeptMasterInfoHolder) ((List) request.getSession().getAttribute("deptMaster")).get(0);
            //     dptMstr.getCurrentTermNo();

            HttpSession session = request.getSession();

            ArrayList inputTutorInfo = new ArrayList();
            inputTutorInfo.add(session.getAttribute("selectedTutor"));
            Collection selectedTutorInfo = new GetTutorInfoUseCase().execute(inputTutorInfo, request);
            if (selectedTutorInfo != null) {
                session.setAttribute("selectedTutorInfo", selectedTutorInfo);
            }

            // TutorInfoHolder tutorInfo = (TutorInfoHolder) ((List) request.getSession().getAttribute("tutorInfo")).get(0);
            String selectedTerm = dptMstr.getCurrentTermNo();//"181";// tutorInfo.getCurrentTermNo();

            System.out.println("stsuc---------111    " + selectedTerm);

            System.out.println("stsuc---------11 ");
            TutorTermScheduleComponent termSchedule = new TutorTermScheduleComponent();
            if (request.getParameter("term") != null) {
                selectedTerm = request.getParameter("term");
                System.out.println("stsuc---------1 ");
            }
            System.out.println("stsuc8888888888888881 ");
            if ((request.getParameter("index") == null) && (session.getAttribute("termsList") != null)) {
                System.out.println("ggggggggggggggggg111");
                request.setAttribute("index", RequestSelectedTermIndexBinder.setRequestSelectedTermIndex((List) session.getAttribute("termsList"), selectedTerm));
            }

            System.out.println("nnnnnnnnnnnnnn,, ");
            termsList = termSchedule.getTutorTermSchedule(new Object[]{selectedTerm, session.getAttribute("selectedTutor")});
            if ((request.getParameter("term") == null) && (session.getAttribute("termsList") != null)) {
                int offset = -1;

                List terms = (List) session.getAttribute("termsList");
                Iterator iter = terms.iterator();
                while (iter.hasNext()) {
                    TermsList term = (TermsList) iter.next();
                    offset++;
                    if (term.getTermNo().equals(selectedTerm)) {
                        request.setAttribute("index", "" + offset);
                        request.setAttribute("term", selectedTerm);
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in the show Dept Tutor term schedule use case" + e);
        }
        return termsList;
    }
}
