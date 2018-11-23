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

public class ViewMsgRecipientsUseCase
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
      tempList = cmp.getList("msg.getMsgRecipients", new Object[] { new Long(messageId) });
      if ((tempList != null) && (tempList.size() > 0))
      {
      //  PrtlMsgSenderInfoVw prtlMsgSenderInfoVw = (PrtlMsgSenderInfoVw)tempList.get(0);
      //  String recipientName = (String) tempList.get(0);
          request.setAttribute("messages", tempList);
        //retList.add(prtlMsgSenderInfoVw);
         System.out.println("messageId 2 "+messageId);
      }
    }
    catch (Exception ce)
    {
      ce.printStackTrace();
      System.err.println("Error in ViewMsgRecipientsUseCase.execute:" + ce);
    }
    return retList;
  }
  
   
}


 