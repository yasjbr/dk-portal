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
import ps.edu.diyar.deptMaster.database.struct.DeptMasterInfoHolder;
import ps.edu.diyar.studentInfo.component.StudentInfoComponent;
import ps.edu.diyar.studentInfo.database.PrtlStudBalanceVw;
import ps.edu.diyar.studentInfo.database.RegCourseStatus;
import ps.edu.diyar.studentInfo.database.RegStud;
import ps.edu.diyar.studentInfo.database.struct.StudentInfoHolder;
import ps.edu.diyar.studentInfo.database.struct.TermCoursesSummaryHolder;

public class StudentTermCourseSummaryUseCase_11102017
  implements ComponentUseCase
{
  private static Logger logger = Logger.getLogger(StudentTermCourseSummaryUseCase_11102017.class);
  
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
          
          
       System.out.println("xxxcdg");
      DataAccessObjectImpl cmp = new DataAccessObjectImpl();
      
      //StudentInfoHolder studentInfo = (StudentInfoHolder)((List)request.getSession().getAttribute("studentInfo")).get(0);
      //String currentTermNo = studentInfo.getSystemCurrentTermNo();
      String selectedTerm = request.getParameter("term");
      if ((selectedTerm == null) || (selectedTerm.trim().equals("")))
      {
        System.out.println("x21");
        selectedTerm = crntTermNo;
        System.out.println("selectedTerm"+selectedTerm);
        currentMarksTerm = true;
      }
      else if (selectedTerm.equalsIgnoreCase(crntTermNo))
      {
        System.out.println("xww1");
        currentMarksTerm = true;
      }
        System.out.println("session.getAttribute(\"selectedStudId\");" +session.getAttribute("selectedStudId")); 
       System.out.println("   ... tox "+ studId+ selectedTerm);
      
      StudentInfoComponent termSummaryCmp = new StudentInfoComponent();
      financialList2 = termSummaryCmp.getStudentFinancialTermsDebt(new Object[] { studId, selectedTerm });
      if (financialList2.size() != 0)
      {
        System.out.println("x1gg");
        PrtlStudBalanceVw sasStudBalanceTemp = (PrtlStudBalanceVw)financialList2.get(0);
        Double termBalance = sasStudBalanceTemp.getTermBalance();
        System.out.println("    toxy "+ termBalance);
        if (termBalance.doubleValue() < 0.0D)
        {
          System.out.println("student balance is minus");
          hasDebit = true;
          financialLoan = termSummaryCmp.getStudentFinancialTermsLoan(new Object[] { studId, selectedTerm });
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
          termSummary = cmp.getList("Portal.getStudentCurrentTermCourseSummary", new Object[] { studId, selectedTerm });
          

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
          termSummary = cmp.getList("Portal.getStudentTermCourseSummary", new Object[] { studId, selectedTerm });
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
