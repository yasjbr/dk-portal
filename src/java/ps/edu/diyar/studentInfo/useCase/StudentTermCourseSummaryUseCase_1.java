package ps.edu.diyar.studentInfo.useCase;

import java.io.PrintStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import ps.edu.diyar.common.component.DataAccessObjectImpl;
import ps.edu.diyar.common.exceptions.ComponentException;
import ps.edu.diyar.common.useCase.ComponentUseCase;
import ps.edu.diyar.studentInfo.component.StudentInfoComponent;
import ps.edu.diyar.studentInfo.database.PrtlStudBalanceVw;
import ps.edu.diyar.studentInfo.database.RegCourseStatus;
import ps.edu.diyar.studentInfo.database.RegStud;
import ps.edu.diyar.studentInfo.database.struct.StudentInfoHolder;
import ps.edu.diyar.studentInfo.database.struct.TermCoursesSummaryHolder;

public class StudentTermCourseSummaryUseCase_1
  implements ComponentUseCase
{
  private static Logger logger = Logger.getLogger(StudentTermCourseSummaryUseCase.class);
  
  public Collection execute(Collection input, HttpServletRequest request)
    throws HibernateException
  {
      System.out.println("execute in StudentTermCourseSummaryUseCase");
              
    List termSummary = null;
    List financialList2 = null;
    List financialLoan = null;
    boolean hasDebit = false;
    boolean hasLoan = false;
    boolean currentMarksTerm = false;
    try
    {
       System.out.println("xxxcdg");
      DataAccessObjectImpl cmp = new DataAccessObjectImpl();
      
      StudentInfoHolder studentInfo = (StudentInfoHolder)((List)request.getSession().getAttribute("studentInfo")).get(0);
      String currentTermNo = studentInfo.getSystemCurrentTermNo();
      String selectedTerm = request.getParameter("term");
      if ((selectedTerm == null) || (selectedTerm.trim().equals("")))
      {
           System.out.println("x21");
        selectedTerm = currentTermNo;
          System.out.println("selectedTerm"+selectedTerm);
        currentMarksTerm = true;
      }
      else if (selectedTerm.equalsIgnoreCase(currentTermNo))
      {
           System.out.println("xww1");
        currentMarksTerm = true;
      }
       System.out.println("    tox "+ studentInfo.getStudentId()+ selectedTerm);
      StudentInfoComponent termSummaryCmp = new StudentInfoComponent();
      financialList2 = termSummaryCmp.getStudentFinancialTermsDebt(new Object[] { studentInfo.getStudentId(), selectedTerm });
      if (financialList2.size() != 0)
      {
        System.out.println("x1gg");
        PrtlStudBalanceVw sasStudBalanceTemp = (PrtlStudBalanceVw)financialList2.get(0);
        Double termBalance = sasStudBalanceTemp.getTermBalance();
        System.out.println("    toxy "+ termBalance);
        if (termBalance.doubleValue() < 0.0D)
        {
          System.out.println("xgfg1");
          hasDebit = true;
          financialLoan = termSummaryCmp.getStudentFinancialTermsLoan(new Object[] { studentInfo.getStudentId(), selectedTerm });
          if (financialLoan.size() != 0) {
            hasLoan = true;
          }
        }
      }
      if ((!hasDebit) || ((hasDebit) && (hasLoan)))
      {
        if (currentMarksTerm)
        {
             System.out.println("xvccvccvv1");
          termSummary = cmp.getList("Portal.getStudentCurrentTermCourseSummary", new Object[] { studentInfo.getStudentId(), selectedTerm });
          

          request.setAttribute("showingCurrentSystemTerm", new String("systemTerm"));
          if (hasLoan)
          {
            Iterator iter = termSummary.iterator();
            while (iter.hasNext())
            {
              TermCoursesSummaryHolder termSumTemp = (TermCoursesSummaryHolder)iter.next();
              termSumTemp.setMark("");
              termSumTemp.setRegStatusAName("مسجل");
            }
            request.setAttribute("hasLoan", "hasLoan");
          }
        }
        else
        {
          termSummary = cmp.getList("Portal.getStudentTermCourseSummary", new Object[] { studentInfo.getStudentId(), selectedTerm });
          if (hasLoan)
          {
            Iterator iter = termSummary.iterator();
            while (iter.hasNext())
            {
              RegStud termSumTemp = (RegStud)iter.next();
              termSumTemp.setCrsMark("");
              termSumTemp.getRegCourseStatus().setStatusAName("مسجل");
            }
            request.setAttribute("hasLoan", "hasLoan");
          }
        }
      }
      else 
      {
        request.setAttribute("Error", "Error");
          System.out.println("erorrrrrrrrrrr this will prevent student displaying thier marks");
      }
      return termSummary;
    }
    catch (ComponentException ce)
    {
      ce =  ce;
        System.out.println("Error in the show term course summary use case" + ce);logger.error("Error in getting chart use case " + ce);return termSummary;
    }
    finally {}
   // return termSummary;
  }
}
