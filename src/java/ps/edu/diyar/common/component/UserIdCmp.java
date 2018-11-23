package ps.edu.diyar.common.component;

import java.util.Collection;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import ps.edu.diyar.studentInfo.database.struct.StudentInfoHolder;
import ps.edu.diyar.tutorInfo.database.struct.TutorInfoHolder;

public class UserIdCmp
{
  public static String getStudIdOrTutorId(HttpServletRequest request)
  {
    String userId = "";
    if (request.getSession().getAttribute("studentInfo") != null)
    {
      StudentInfoHolder studentInfo = (StudentInfoHolder)((Collection)request.getSession().getAttribute("studentInfo")).iterator().next();
      userId = studentInfo.getStudentId();
    }
    else if (request.getSession().getAttribute("tutorInfo") != null)
    {
      TutorInfoHolder tutorInfo = (TutorInfoHolder)((Collection)request.getSession().getAttribute("tutorInfo")).iterator().next();
      userId = tutorInfo.getEmpNo();
    }
    return userId;
  }
}

 