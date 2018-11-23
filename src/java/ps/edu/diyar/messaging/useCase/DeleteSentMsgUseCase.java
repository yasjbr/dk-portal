package ps.edu.diyar.messaging.useCase;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import ps.edu.diyar.common.component.DataAccessObjectImpl;
import ps.edu.diyar.common.useCase.ComponentUseCase;
import ps.edu.diyar.messaging.component.MessageComponent;
import ps.edu.diyar.messaging.database.PrtlMessageRecipient;
import ps.edu.diyar.messaging.database.PrtlMessageRecipientPK;

public class DeleteSentMsgUseCase
  implements ComponentUseCase
{
  private static Logger logger = Logger.getLogger(DeleteMsgUseCase.class);
  
  public Collection execute(Collection input, HttpServletRequest request)
    throws HibernateException
  {
    List retList = null;
    Iterator iter = input.iterator();
    String msgs = (String)iter.next();
    String userId = (String)iter.next();
    String msgType = (String)iter.next();
    try
    {
      if ((msgs != null) && (msgs.length() != 0) && (userId != null) && (userId.trim().length() != 0))
      {
        MessageComponent cmp = new MessageComponent();
         //retList = cmp.deleteMsg(new Object[] { userId, msgs })
          System.out.println("msgType" + msgType);
         retList = cmp.vDeleteSentMsg(new Object[] { userId, msgs }) ;      
      }
      return retList;
    }
    catch (Exception ce)
    {
      ce = 
      ce;logger.error("Error in DeleteMsgUseCase:  " + ce);ce.printStackTrace();return retList;
    }
    finally {}
    //return retList;
  }
  
  
  
  private void updateMessage(String msgId, String userId, String computerIp)
  {
    try
    {
      PrtlMessageRecipientPK objPk = new PrtlMessageRecipientPK(new Long(msgId), userId);
      PrtlMessageRecipient obj = new PrtlMessageRecipient(objPk, "T", new Date(), computerIp,"F",null);
      new DataAccessObjectImpl().update(obj);
    }
    catch (Exception e)
    {
      System.err.println("Error in MessageComonent.updateMessage :" + e);
    }
  }
}



/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\

 * Qualified Name:     ps.edu.diyar.messaging.useCase.DeleteMsgUseCase

 * JD-Core Version:    0.7.0.1

 */