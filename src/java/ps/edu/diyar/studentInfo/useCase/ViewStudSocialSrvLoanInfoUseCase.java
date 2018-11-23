package ps.edu.diyar.studentInfo.useCase;

import java.io.PrintStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.HibernateException;
import ps.edu.diyar.common.component.DataAccessObjectImpl;
import ps.edu.diyar.common.useCase.ComponentUseCase;

public class ViewStudSocialSrvLoanInfoUseCase
  implements ComponentUseCase
{
  public Collection execute(Collection input, HttpServletRequest request)
    throws HibernateException
  {
    List retList = null;
    Iterator itr = input.iterator();
    String studId = (String)itr.next();
    String termNo = (String)itr.next();
    try
    {
      DataAccessObjectImpl cmp = new DataAccessObjectImpl();
      retList = cmp.getList("stud.getStudSocialSrvLoanInfo", new Object[] { studId, termNo });
      if ((retList != null) && (retList.size() > 0))
      {
        Collection retListPLoan = cmp.getList("stud.getStudSocialSrvLoanPersonal", new Object[] { studId, termNo });
        if ((retListPLoan != null) && (retListPLoan.size() > 0)) {
          request.setAttribute("retListPLoan", retListPLoan);
        }
        Collection retListFLoan = cmp.getList("stud.getStudSocialSrvLoanFamily", new Object[] { studId, termNo });
        if ((retListFLoan != null) && (retListFLoan.size() > 0)) {
          request.setAttribute("retListFLoan", retListFLoan);
        }
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
      System.err.println("Error in ViewStudSocialSrvLoanInfoUseCase.execute:" + e);
    }
    return retList;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.useCase.ViewStudSocialSrvLoanInfoUseCase
 * JD-Core Version:    0.7.0.1
 */