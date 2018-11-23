package ps.edu.diyar.messaging.useCase;

import java.io.PrintStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import ps.edu.diyar.common.component.DataAccessObjectImpl;
import ps.edu.diyar.common.useCase.ComponentUseCase;

public class ViewAllMsgUseCase
  implements ComponentUseCase
{
  private static Logger logger = Logger.getLogger(ViewAllMsgUseCase.class);
  
  public Collection execute(Collection input, HttpServletRequest request)
    throws HibernateException
  {
    List retList = null;
    
    Iterator iter = input.iterator();
    
    String userId = (String)iter.next();
    String crsNo = (String)iter.next();
    String crsClass = (String)iter.next();
    String termNo = (String)iter.next();
    try
    {
      String firstRow = request.getParameter("d-3972-p");
      if (firstRow == null) {
        firstRow = "1";
      }
      String maxRow = "5";
      
      DataAccessObjectImpl cmp = new DataAccessObjectImpl();
      
        System.out.println("  "+ userId +"  " + crsNo + "  "+ crsClass+"   "+ termNo );
      Collection msgList = cmp.getList("msg.getInboxMsg", new Object[] { userId, crsNo, crsClass, termNo });
      if ((msgList != null) && (msgList.size() > 0)) {
        request.setAttribute("msgList", msgList);
      }
      //request.setAttribute("count", cmp.getList("msg.getInboxMsgCount", new Object[] { userId, crsNo, crsClass, termNo }).iterator().next());
    }
    catch (Exception e)
    {
      logger.error("*** ViewAllMsgUseCase.execute has ComponentException detials :" + e.toString());
      System.err.println("*** ViewAllMsgUseCase.execute has ComponentException detials :" + e.toString());
    }
    return retList;
  }
}
