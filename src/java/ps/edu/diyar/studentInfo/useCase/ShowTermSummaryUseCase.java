package ps.edu.diyar.studentInfo.useCase;

import java.io.PrintStream;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.hibernate.HibernateException;
import ps.edu.diyar.common.component.DataAccessObjectImpl;
import ps.edu.diyar.common.tools.RequestSelectedTermIndexBinder;
import ps.edu.diyar.common.useCase.ComponentUseCase;
import ps.edu.diyar.deptMaster.database.struct.DeptMasterInfoHolder;
import ps.edu.diyar.studentInfo.database.struct.StudentInfoHolder;

public class ShowTermSummaryUseCase
  implements ComponentUseCase
{
  public Collection execute(Collection input, HttpServletRequest request)
    throws HibernateException
  {
    List termSummaryList = null;
    try
    {
      HttpSession session = request.getSession();
      String crntTermNo = null;
      String studId = null;
      if (request.getSession().getAttribute("studentInfo") != null)
      {
        StudentInfoHolder studentInfo = (StudentInfoHolder)((List)session.getAttribute("studentInfo")).get(0);
        crntTermNo = studentInfo.getSystemCurrentTermNo();
        studId = studentInfo.getStudentId();
      }
      else if (request.getSession().getAttribute("deptMaster") != null)
      {
          
          System.out.println("deptMaster is not null ----------------");
        DeptMasterInfoHolder deptMasterInfo = (DeptMasterInfoHolder)((List)request.getSession().getAttribute("deptMaster")).get(0);
        crntTermNo = deptMasterInfo.getCurrentTermNo();
        studId = request.getParameter("studId");
         if (studId == null ){
       studId= (String) session.getAttribute("selectedStudId");
// this comes from the session when studid is not seleted 
    }
      }
      
      
      String selectedTerm = "";
      if (request.getParameter("term") != null)
      {
        selectedTerm = request.getParameter("term");
      }
      else
      {
        selectedTerm = crntTermNo;
        request.setAttribute("term", selectedTerm);
      }
      DataAccessObjectImpl cmp = new DataAccessObjectImpl();
      if ((request.getParameter("index") == null) && (session.getAttribute("termsList") != null)) {
          System.out.println("aysel");
          request.setAttribute("index", RequestSelectedTermIndexBinder.setRequestSelectedTermIndex((List)session.getAttribute("termsList"), selectedTerm));
      }
      termSummaryList = cmp.getList("Portal.getStudentCurrentTermSummary", new Object[] { studId, selectedTerm });
    }
    catch (Exception e)
    {
      e.printStackTrace();
      System.out.println("Error in the show term summary use case ..." + e);
    }
    return termSummaryList;
  }
}


 