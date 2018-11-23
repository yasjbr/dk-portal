package ps.edu.diyar.studentInfo.useCase;

import java.io.PrintStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.hibernate.HibernateException;
import ps.edu.diyar.common.component.DataAccessObjectImpl;
import ps.edu.diyar.common.tools.RequestSelectedTermIndexBinder;
import ps.edu.diyar.common.useCase.ComponentUseCase;
import ps.edu.diyar.deptMaster.database.struct.DeptMasterInfoHolder;
import ps.edu.diyar.studentInfo.database.struct.StudentInfoHolder;

public class ShowCourseSummaryUseCase
  implements ComponentUseCase
{
  public Collection execute(Collection input, HttpServletRequest request)
    throws HibernateException
  {
    List courseSummaryList = null;
    try
    {
      HttpSession session = request.getSession();
      
      String studId = null;
      
      
      if (request.getSession().getAttribute("studentInfo") != null)
      {
        StudentInfoHolder studentInfo = (StudentInfoHolder)((List)session.getAttribute("studentInfo")).get(0);
       // crntTermNo = studentInfo.getSystemCurrentTermNo();
        studId = studentInfo.getStudentId();
      }
       
      String selectedCourse = "";
      if (request.getParameter("course") != null)
      {
        selectedCourse = request.getParameter("course").trim();
      }
     // selectedCourse="DAK2177";
      DataAccessObjectImpl cmp = new DataAccessObjectImpl();
       
      courseSummaryList = cmp.getList("Portal.getCourseWht", new Object[] {  selectedCourse });
       System.out.println("3ala shooooo"+selectedCourse+'6'+courseSummaryList.size());
    
    }
    catch (Exception e)
    {
      e.printStackTrace();
      System.out.println("Error in the show term summary use case" + e);
    }
    return courseSummaryList;
  }
}

 
 