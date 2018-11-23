package ps.edu.diyar.messaging.useCase;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.HibernateException;
import ps.edu.diyar.common.component.DataAccessObjectImpl;
import ps.edu.diyar.common.exceptions.ComponentException;
import ps.edu.diyar.common.useCase.ComponentUseCase;
import ps.edu.diyar.messaging.database.PrtlMsgSenderInfoVw;
import ps.edu.diyar.messaging.database.PrtlMsgSenderInfoVwPK;
import ps.edu.diyar.messaging.database.struct.PrtlMessage;

public class ReplayMessageUseCase
  implements ComponentUseCase
{
  public Collection execute(Collection input, HttpServletRequest request)
    throws HibernateException
  {
    ArrayList retList = new ArrayList();
    List tempList = null;
    Iterator itr = input.iterator();
    
    String messageId = (String)itr.next();
    
    DataAccessObjectImpl cmp = new DataAccessObjectImpl();
    try
    {
      tempList = cmp.getList("msg.getMessageDetail", new Object[] { new Long(messageId) });
    }
    catch (ComponentException ce)
    {
      System.out.println("Error " + ce);
    }
    Iterator objectsItr = tempList.iterator();
    while (objectsItr.hasNext())
    {
      PrtlMsgSenderInfoVw prtlMsgSenderInfoVw = (PrtlMsgSenderInfoVw)objectsItr.next();
      
      PrtlMessage prtlMessage = new PrtlMessage();
      
      prtlMessage.setMsgId(prtlMsgSenderInfoVw.getComp_id().getMsgId());
      prtlMessage.setMsgTitle("RE:" + prtlMsgSenderInfoVw.getMsgTitle());
      try
      {
        StringBuffer oldMsgBody = new StringBuffer();
        oldMsgBody.append("<br><hr />");
        oldMsgBody.append("<div align=\"right\">&nbsp;المرسل: " + prtlMsgSenderInfoVw.getSenderName() + "</div>");
        oldMsgBody.append("<div align=\"right\">&nbsp;التاريخ: " + prtlMsgSenderInfoVw.getMsgDate() + "</div><br>");
        oldMsgBody.append(prtlMsgSenderInfoVw.getMsgBody());
        prtlMessage.setMsgBody(oldMsgBody.toString());
      }
      catch (Exception e)
      {
        System.err.println("Error converting to string " + e);
      }
      retList.add(prtlMessage);
    }
    return retList;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.messaging.useCase.ReplayMessageUseCase
 * JD-Core Version:    0.7.0.1
 */