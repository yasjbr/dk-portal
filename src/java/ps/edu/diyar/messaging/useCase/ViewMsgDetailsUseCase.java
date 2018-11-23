package ps.edu.diyar.messaging.useCase;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.HibernateException;
import ps.edu.diyar.common.component.AuditInfo;
import ps.edu.diyar.common.component.DataAccessObjectImpl;
import ps.edu.diyar.common.useCase.ComponentUseCase;
import ps.edu.diyar.messaging.database.PrtlMessageRecipient;
import ps.edu.diyar.messaging.database.PrtlMessageRecipientPK;
import ps.edu.diyar.messaging.database.PrtlMsgSenderInfoVw;

public class ViewMsgDetailsUseCase
  implements ComponentUseCase
{
  public Collection execute(Collection input, HttpServletRequest request)
    throws HibernateException
  {
    ArrayList retList = new ArrayList();
    
    List tempList = null;
    
    Iterator itr = input.iterator();
    
    String messageId = (String)itr.next();
    String isRead = (String)itr.next();
    String userId = (String)itr.next();
    String senderId = (String)itr.next();
    
    DataAccessObjectImpl cmp = new DataAccessObjectImpl();
    try
    {
      tempList = cmp.getList("msg.getMsgDetails", new Object[] { new Long(messageId), senderId });
      if ((tempList != null) && (tempList.size() > 0))
      {
        PrtlMsgSenderInfoVw prtlMsgSenderInfoVw = (PrtlMsgSenderInfoVw)tempList.get(0);
        if (isRead.equals("F"))
        {
          AuditInfo auditInfo = new AuditInfo(request);
          updateMessageStatus(messageId, userId, auditInfo.getRemoteIp());
        }
        retList.add(prtlMsgSenderInfoVw);
      }
    }
    catch (Exception ce)
    {
      ce.printStackTrace();
      System.err.println("Error in ViewMsgDetailsUseCase.execute:" + ce);
    }
    return retList;
  }
  
  private void updateMessageStatus(String msgId, String userId, String computerIp)
  {
    try
    {
      PrtlMessageRecipientPK objPk = new PrtlMessageRecipientPK(new Long(msgId), userId);
      PrtlMessageRecipient obj = new PrtlMessageRecipient(objPk, "T", new Date(), computerIp,"F",null);
      new DataAccessObjectImpl().update(obj);
    }
    catch (Exception e)
    {
      System.err.println("Error in ViewMsgDetailsUseCase.updateMessageStatus :" + e);
    }
  }
}



/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\

 * Qualified Name:     ps.edu.diyar.messaging.useCase.ViewMsgDetailsUseCase

 * JD-Core Version:    0.7.0.1

 */