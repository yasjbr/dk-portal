package ps.edu.diyar.studentInfo.useCase;

import java.io.PrintStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import ps.edu.diyar.common.component.DataAccessObjectImpl;
import ps.edu.diyar.common.component.ServletContextAttribute;
import ps.edu.diyar.common.component.UserIdCmp;
import ps.edu.diyar.common.exceptions.ComponentException;
import ps.edu.diyar.common.useCase.ComponentUseCase;

public class GetUnreadInboxMsgCountUseCase
  implements ComponentUseCase
{
  private static Logger logger = Logger.getLogger(GetTermInfoUseCase.class);
  
  
  
  
  public Collection execute(Collection input, HttpServletRequest request)
    throws HibernateException
  {
    List retList = null;
    try
    {
      DataAccessObjectImpl cmp = new DataAccessObjectImpl();
      
      String userId = UserIdCmp.getStudIdOrTutorId(request);
      String termNo = new ServletContextAttribute(request).getCurentTerm();
    // String termNo="161";
      System.out.println("----------------------------00000 "+termNo);
      retList = cmp.getList("msg.getUnreadInboxMsgCount", new Object[] { userId, termNo });
      Long unreadMsgCount = (Long)retList.iterator().next();
      if ((unreadMsgCount != null) && (unreadMsgCount.longValue() > 0L)) {
        request.setAttribute("foundUnreadMsg", "true");
      }
    }
    catch (ComponentException e)
    {
      logger.error("*** Error in " + getClass().getName() + ".execute has ComponentException detials :" + e.toString());
      System.err.println("*** Error in " + getClass().getName() + ".execute has ComponentException detials :" + e.toString());
    }
    return retList;
  }
}



/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\

 * Qualified Name:     ps.edu.diyar.studentInfo.useCase.GetUnreadInboxMsgCountUseCase

 * JD-Core Version:    0.7.0.1

 */