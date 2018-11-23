package ps.edu.diyar.tutorInfo.useCase;

import java.io.PrintStream;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.hibernate.HibernateException;
import ps.edu.diyar.common.useCase.ComponentUseCase;
import ps.edu.diyar.tutorInfo.component.TutorComponent;
import ps.edu.diyar.tutorInfo.database.struct.TutorInfoHolder;

public class TutorTermListUseCase
  implements ComponentUseCase
{
  public Collection execute(Collection input, HttpServletRequest request)
    throws HibernateException
  {
      
      System.out.println("ffgg------------");
    List termList = null;
    String empNo=null;
    
       if (request.getParameter("tutNo") != null) {
        empNo=request.getParameter("tutNo");
         
      }
       
    try
    {
        if (empNo == null) {
            
           TutorInfoHolder tutorInfo = (TutorInfoHolder)((List)request.getSession().getAttribute("tutorInfo")).get(0); 
        empNo= tutorInfo.getEmpNo();
    }
          System.out.println("11...jj"+empNo);
   //   TutorInfoHolder tutorInfo = (TutorInfoHolder)((List)request.getSession().getAttribute("tutorInfo")).get(0);
      TutorComponent tutorCmp = new TutorComponent();
     // termList = tutorCmp.getTutorTermsList(tutorInfo.getEmpNo());
       termList = tutorCmp.getTutorTermsList(empNo);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      System.out.println("Error in the tutor terms list use case" + e);
    }
    
      System.out.println("empno----------------."+empNo);
    return termList;
  }
}
 