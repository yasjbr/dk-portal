package ps.edu.diyar.studentInfo.useCase;

import java.io.PrintStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import ps.edu.diyar.common.component.DataAccessObjectImpl;
import ps.edu.diyar.common.useCase.ComponentUseCase;

public class GetUserInfoUseCase
  implements ComponentUseCase
{
  private static Logger logger = Logger.getLogger(GetUserInfoUseCase.class);
  
  public Collection execute(Collection input, HttpServletRequest request)
    throws HibernateException
  {
    List retList = null;
    
    Iterator iter = input.iterator();
    String userId = (String)iter.next();
    try
    {
      DataAccessObjectImpl cmp = new DataAccessObjectImpl();
      retList = cmp.getList("user.getUserInfo", new Object[] { userId });
    }
    catch (Exception e)
    {
      logger.error("*** GetUserInfoUseCase.execute has ComponentException detials :" + e.toString());
      System.err.println("*** GetUserInfoUseCase.execute has ComponentException detials :" + e.toString());
    }
    return retList;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.useCase.GetUserInfoUseCase
 * JD-Core Version:    0.7.0.1
 */