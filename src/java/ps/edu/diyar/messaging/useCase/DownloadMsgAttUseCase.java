package ps.edu.diyar.messaging.useCase;

import java.io.PrintStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.HibernateException;
import ps.edu.diyar.common.exceptions.ComponentException;
import ps.edu.diyar.common.useCase.ComponentUseCase;
import ps.edu.diyar.messaging.component.MessageComponent;

public class DownloadMsgAttUseCase
  implements ComponentUseCase
{
  public Collection execute(Collection input, HttpServletRequest request)
    throws HibernateException
  {
    List result = null;
    
    Iterator itr = input.iterator();
    
    String id = (String)itr.next();
    try
    {
      String seed = id.substring(0, 20);
      String fileId = id.substring(20);
      
      result = new MessageComponent().getList("msg.getMessageAtt", new Object[] { new Long(fileId), seed });
    }
    catch (ComponentException e)
    {
      e.printStackTrace();
      System.err.println("Error in DownloadMsgAttUseCase " + e);
    }
    return result;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.messaging.useCase.DownloadMsgAttUseCase
 * JD-Core Version:    0.7.0.1
 */