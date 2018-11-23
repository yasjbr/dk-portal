package ps.edu.diyar.studentInfo.useCase;

import java.io.PrintStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.HibernateException;
import ps.edu.diyar.common.component.DataAccessObjectImpl;
import ps.edu.diyar.common.useCase.ComponentUseCase;

public class GetStudSocialSrvWorkDtlInfoUseCase
  implements ComponentUseCase
{
  public Collection execute(Collection input, HttpServletRequest request)
    throws HibernateException
  {
    List retList = null;
    Iterator itr = input.iterator();
    String studId = (String)itr.next();
    String termNo = (String)itr.next();
    String workerType = (String)itr.next();
    try
    {
      DataAccessObjectImpl cmp = new DataAccessObjectImpl();
      retList = cmp.getList("stud.getStudSocialSrvWorkDtlInfo", new Object[] { studId, termNo, workerType });
    }
    catch (Exception e)
    {
      e.printStackTrace();
      System.err.println("Error in GetStudSocialSrvWorkDtlInfoUseCase.execute:" + e);
    }
    return retList;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.useCase.GetStudSocialSrvWorkDtlInfoUseCase
 * JD-Core Version:    0.7.0.1
 */