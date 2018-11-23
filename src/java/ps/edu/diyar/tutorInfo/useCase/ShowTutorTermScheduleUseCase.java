package ps.edu.diyar.tutorInfo.useCase;

import java.io.PrintStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.hibernate.HibernateException;
import ps.edu.diyar.common.tools.RequestSelectedTermIndexBinder;
import ps.edu.diyar.common.useCase.ComponentUseCase;
import ps.edu.diyar.common.utils.TermsList;
import ps.edu.diyar.tutorInfo.component.TutorTermScheduleComponent;
import ps.edu.diyar.tutorInfo.database.struct.TutorInfoHolder;

public class ShowTutorTermScheduleUseCase
  implements ComponentUseCase
{
  public Collection execute(Collection input, HttpServletRequest request)
    throws HibernateException
  {
    List termsList = null;
     String empNo=null;
    try
    {
        
      HttpSession session = request.getSession();
      TutorInfoHolder tutorInfo = (TutorInfoHolder)((List)request.getSession().getAttribute("tutorInfo")).get(0);
      String selectedTerm = tutorInfo.getCurrentTermNo();
      
        System.out.println("stsuc---------111 ");
      
      
      //////
      
    empNo=  tutorInfo.getEmpNo();
       
      //// 
         System.out.println("stsuc---------11 ");
      TutorTermScheduleComponent termSchedule = new TutorTermScheduleComponent();
      if (request.getParameter("term") != null) {
        selectedTerm = request.getParameter("term");
          System.out.println("stsuc---------1 ");
      }
      if ((request.getParameter("index") == null) && (session.getAttribute("termsList") != null)) {
        request.setAttribute("index", RequestSelectedTermIndexBinder.setRequestSelectedTermIndex((List)session.getAttribute("termsList"), selectedTerm));
      }
      termsList = termSchedule.getTutorTermSchedule(new Object[] { selectedTerm,empNo });
      if ((request.getParameter("term") == null) && (session.getAttribute("termsList") != null))
      {
        int offset = -1;
        
        List terms = (List)session.getAttribute("termsList");
        Iterator iter = terms.iterator();
        while (iter.hasNext())
        {
          TermsList term = (TermsList)iter.next();
          offset++;
          if (term.getTermNo().equals(selectedTerm))
          {
            request.setAttribute("index", "" + offset);
            request.setAttribute("term", selectedTerm);
            break;
          }
        }
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
      System.out.println("Error in the show Tutor term schedule use case" + e);
    }
    return termsList;
  }
}

