
package ps.edu.diyar.studentInfo.useCase;

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

public class ShowTermFinancialDetalUseCase  implements ComponentUseCase   {
    public Collection execute(Collection input, HttpServletRequest request)
    throws HibernateException
  {
  List financialDetailList = null;
  
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
            DeptMasterInfoHolder deptMasterInfo = (DeptMasterInfoHolder)((List)request.getSession().getAttribute("deptMaster")).get(0);
            crntTermNo = deptMasterInfo.getCurrentTermNo();
            studId = request.getParameter("studId");
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
        request.setAttribute("index", RequestSelectedTermIndexBinder.setRequestSelectedTermIndex((List)session.getAttribute("termsList"), selectedTerm));
      }
       
       financialDetailList = cmp.getList("Portal.getStudentCurrentTermFinancialDetail", new Object[] { studId, selectedTerm });
  }
  
  catch(Exception e){
    e.printStackTrace();
  }
 
  return financialDetailList;
  } 
}
