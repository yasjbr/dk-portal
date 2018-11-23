package ps.edu.diyar.studentInfo.useCase;

import java.io.PrintStream;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.hibernate.HibernateException;
import ps.edu.diyar.common.component.DataAccessObjectImpl;
import ps.edu.diyar.common.useCase.ComponentUseCase;
import ps.edu.diyar.studentInfo.database.struct.StudentInfoHolder;

public class StudentTermsListUseCase_1
  implements ComponentUseCase
{
  public Collection execute(Collection input, HttpServletRequest request)
    throws HibernateException
  {
    List termList = null;
    try
    {
       // if (request.getSession().getAttribute("studentInfo") != null) {
        
      StudentInfoHolder studentInfo = (StudentInfoHolder)((List)request.getSession().getAttribute("studentInfo")).get(0);
      DataAccessObjectImpl cmp = new DataAccessObjectImpl();
      termList = cmp.getList("Portal.getStudentTermsList", new Object[] { studentInfo.getStudentId() });
    }
    catch (Exception e)
    {
      e.printStackTrace();
      System.err.println("Error in StudentTermsListUseCase.execute:" + e);
    }
    return termList;
  }
}