package ps.edu.diyar.deptMaster.usecase;

import ps.edu.diyar.tutorInfo.useCase.*;
import java.io.PrintStream;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.hibernate.HibernateException;
import ps.edu.diyar.common.useCase.ComponentUseCase;
import ps.edu.diyar.tutorInfo.component.TutorComponent;
import ps.edu.diyar.tutorInfo.database.struct.TutorInfoHolder;

public class DeptTutorTermListUseCase
        implements ComponentUseCase {

    public Collection execute(Collection input, HttpServletRequest request)
            throws HibernateException {

        List termList = null;

        try {

            HttpSession session = request.getSession();
            System.out.println("selectedTutot----------------." + session.getAttribute("selectedTutor"));

            TutorComponent tutorCmp = new TutorComponent();

            termList = tutorCmp.getTutorTermsList((String) session.getAttribute("selectedTutor"));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in the tutor terms list use case" + e);
        }

        return termList;
    }
}
