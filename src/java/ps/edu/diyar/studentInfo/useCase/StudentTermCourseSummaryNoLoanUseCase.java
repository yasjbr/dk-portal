package ps.edu.diyar.studentInfo.useCase;

import java.io.PrintStream;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import ps.edu.diyar.common.component.DataAccessObjectImpl;
import ps.edu.diyar.common.exceptions.ComponentException;
import ps.edu.diyar.common.useCase.ComponentUseCase;
import ps.edu.diyar.studentInfo.database.struct.StudentInfoHolder;

public class StudentTermCourseSummaryNoLoanUseCase
  implements ComponentUseCase
{
  private static Logger logger = Logger.getLogger(StudentTermCourseSummaryUseCase.class);
  
  public Collection execute(Collection input, HttpServletRequest request)
    throws HibernateException
  {
    List termSummary = null;
    boolean currentMarksTerm = false;
    try
    {
      DataAccessObjectImpl cmp = new DataAccessObjectImpl();
      
      StudentInfoHolder studentInfo = (StudentInfoHolder)((List)request.getSession().getAttribute("studentInfo")).get(0);
      String currentTermNo = studentInfo.getSystemCurrentTermNo();
      String selectedTerm = request.getParameter("term");
      if ((selectedTerm == null) || (selectedTerm.trim().equals("")))
      {
        selectedTerm = currentTermNo;
        currentMarksTerm = true;
      }
      else if (selectedTerm.equalsIgnoreCase(currentTermNo))
      {
        currentMarksTerm = true;
      }
      if (currentMarksTerm)
      {
        termSummary = cmp.getList("Portal.getStudentCurrentTermCourseSummary", new Object[] { studentInfo.getStudentId(), selectedTerm });
        

        request.setAttribute("showingCurrentSystemTerm", new String("systemTerm"));
      }
      else
      {
        termSummary = cmp.getList("Portal.getStudentTermCourseSummary", new Object[] { studentInfo.getStudentId(), selectedTerm });
      }
      return termSummary;
    }
    catch (ComponentException ce)
    {
      ce = 
      






        ce;System.out.println("Error in the show term course summary use case" + ce);logger.error("Error in getting chart use case " + ce);return termSummary;
    }
    finally {}
    //return termSummary;
  }
}



/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\

 * Qualified Name:     ps.edu.diyar.studentInfo.useCase.StudentTermCourseSummaryNoLoanUseCase

 * JD-Core Version:    0.7.0.1

 */