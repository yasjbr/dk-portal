package ps.edu.diyar.messaging.database.struct;

import java.util.Date;

public class PrtlTutorMessage
{
  private String senderId;
  private Long msgId;
  private String msgTitle;
  private String msgBody;
  private Date timeStamp;
  private String servirity;
  private String senderName;
 
   
  
  public PrtlTutorMessage() {}
  
  public PrtlTutorMessage(Long msgId,  String senderId, String senderName, String msgTitle, Date timeStamp, String servirity  )
  {
    this.msgId = msgId;

    this.msgTitle = msgTitle;
    this.senderId = senderId;
    this.senderName = senderName;
    this.timeStamp = timeStamp;
    this.servirity = servirity;

  }
 
  
  
  
  
  public String getMsgBody()
  {
    return this.msgBody;
  }
  
  public void setMsgBody(String msgBody)
  {
    this.msgBody = msgBody;
  }
  
  public String getSenderName()
  {
    return this.senderName;
  }
  
  public void setSenderName(String senderName)
  {
    this.senderName = senderName;
  }
  
  public String getServirity()
  {
    return this.servirity;
  }
  
  public void setServirity(String servirity)
  {
    this.servirity = servirity;
  }
  
  public Date getTimeStamp()
  {
    return this.timeStamp;
  }
  
  public void setTimeStamp(Date timeStamp)
  {
    this.timeStamp = timeStamp;
  }
  
  public String getSenderId()
  {
    return this.senderId;
  }
  
  public void setSenderId(String senderId)
  {
    this.senderId = senderId;
  }
  
  public Long getMsgId()
  {
    return this.msgId;
  }
  
  public void setMsgId(Long msgId)
  {
    this.msgId = msgId;
  }
  
   
  
  public String getMsgTitle()
  {
    return this.msgTitle;
  }
  
  public void setMsgTitle(String msgTitle)
  {
    this.msgTitle = msgTitle;
  }

    

     
  
  
  
  
}


 