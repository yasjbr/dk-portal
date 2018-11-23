package ps.edu.diyar.studentInfo.useCase;

import java.io.PrintStream;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.hibernate.HibernateException;
import ps.edu.diyar.common.component.DataAccessObjectImpl;
import ps.edu.diyar.common.useCase.ComponentUseCase;
import ps.edu.diyar.deptMaster.database.struct.DeptMasterInfoHolder;
import ps.edu.diyar.studentInfo.database.struct.StudentInfoHolder;

public class StudentTermsListUseCase
  implements ComponentUseCase
{
  public Collection execute(Collection input, HttpServletRequest request)
    throws HibernateException
  {
    List termList = null;
      HttpSession session = request.getSession();
    String crntTermNo = null;
      String studId = null;
      
    try
    {
        
        
        if (request.getSession().getAttribute("studentInfo") != null)
      {
        StudentInfoHolder studentInfo = (StudentInfoHolder)((List)session.getAttribute("studentInfo")).get(0);
        crntTermNo = studentInfo.getSystemCurrentTermNo();
        studId = studentInfo.getStudentId();
      }
      else if (request.getSession().getAttribute("deptMaster") != null)
      {
          
          System.out.println("deptMaster is not null StudentTermsListUseCase ");
        DeptMasterInfoHolder deptMasterInfo = (DeptMasterInfoHolder)((List)request.getSession().getAttribute("deptMaster")).get(0);
        crntTermNo = deptMasterInfo.getCurrentTermNo();
        studId = request.getParameter("studId");
        
         if (studId == null ){
       studId= (String) session.getAttribute("selectedStudId");
// this comes from the session when studid is not seleted 
    }
      }
        
        
      //StudentInfoHolder studentInfo = (StudentInfoHolder)((List)request.getSession().getAttribute("studentInfo")).get(0);
      DataAccessObjectImpl cmp = new DataAccessObjectImpl();
      termList = cmp.getList("Portal.getStudentTermsList", new Object[] { studId });
    }
    catch (Exception e)
    {
      e.printStackTrace();
      System.err.println("Error in StudentTermsListUseCase.execute:" + e);
    }
    return termList;
  }
}