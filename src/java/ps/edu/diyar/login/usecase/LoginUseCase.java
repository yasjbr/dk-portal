package ps.edu.diyar.login.usecase;

import java.io.PrintStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import ps.edu.diyar.common.component.DataAccessObjectImpl;
import ps.edu.diyar.common.useCase.ComponentUseCase;

public class LoginUseCase
  implements ComponentUseCase
{
  private static Logger logger = Logger.getLogger(LoginUseCase.class);
  
  public Collection execute(Collection input, HttpServletRequest request)
    throws HibernateException
  {
    List retList = null;
    
    Iterator iter = input.iterator();
    String userId = (String)iter.next();
    String userPwd = (String)iter.next();
    try
    {
      DataAccessObjectImpl cmp = new DataAccessObjectImpl();
      retList = cmp.getList("login.getUserInfo", new Object[] { userId, userPwd });
    }
    catch (Exception e)
    {
      logger.error("*** LoginUseCase.execute has ComponentException detials :" + e.toString());
      System.err.println("*** LoginUseCase.execute has ComponentException detials :" + e.toString());
    }
    return retList;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.login.usecase.LoginUseCase
 * JD-Core Version:    0.7.0.1
 */