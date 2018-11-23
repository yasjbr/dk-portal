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

public class ShowMarkInsertionUseCase
  implements ComponentUseCase
{
  public Collection execute(Collection input, HttpServletRequest request)
    throws HibernateException
  {
    List termsList = null;
    try
    {
      HttpSession session = request.getSession();
      TutorInfoHolder tutorInfo = (TutorInfoHolder)((List)request.getSession().getAttribute("tutorInfo")).get(0);
      String selectedTerm = tutorInfo.getCurrentTermNo();
      
      TutorTermScheduleComponent termSchedule = new TutorTermScheduleComponent();
      if (request.getParameter("term") != null) {
        selectedTerm = request.getParameter("term");
      }
      if ((request.getParameter("index") == null) && (session.getAttribute("termsList") != null)) {
        request.setAttribute("index", RequestSelectedTermIndexBinder.setRequestSelectedTermIndex((List)session.getAttribute("termsList"), selectedTerm));
      }
      termsList = termSchedule.getTutorMarkInsertion(new Object[] { selectedTerm, tutorInfo.getEmpNo() });
      if ((request.getParameter("term") == null) && (session.getAttribute("termsList") != null))
      {
           System.out.println("testing this term    ......."+request.getParameter("term"));
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
      System.out.println("Error in the show Tutor term/schedule use case" + e);
    }
    
     System.out.println("testing this term    ......."+request.getParameter("term"));
    return termsList;
  }
}



/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\

 * Qualified Name:     ps.edu.diyar.tutorInfo.useCase.ShowMarkInsertionUseCase

 * JD-Core Version:    0.7.0.1

 */