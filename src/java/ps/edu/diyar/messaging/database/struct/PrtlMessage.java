package ps.edu.diyar.messaging.database.struct;

import java.util.Date;

public class PrtlMessage
{
  private String senderId;
  private Long msgId;
  private String viewed;
  private String msgTitle;
  private String msgBody;
  private Date timeStamp;
  private String servirity;
  private String senderName;
  private String recipientName;
  private String recipientId;
   
  
  public PrtlMessage() {}
  
  public PrtlMessage(Long msgId, String viewed, String senderId, String senderName, String msgTitle, Date timeStamp, String servirity,String recipientName,  String recipientId )
  {
    this.msgId = msgId;
    this.viewed = viewed;
    this.msgTitle = msgTitle;
    this.senderId = senderId;
    this.senderName = senderName;
    this.timeStamp = timeStamp;
    this.servirity = servirity;
    this.recipientName= recipientName;
    this.recipientId = recipientId;
  }

    public String getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(String recipientId) {
        this.recipientId = recipientId;
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
  
  public String getViewed()
  {
    return this.viewed;
  }
  
  public void setViewed(String viewed)
  {
    this.viewed = viewed;
  }
  
  public String getMsgTitle()
  {
    return this.msgTitle;
  }
  
  public void setMsgTitle(String msgTitle)
  {
    this.msgTitle = msgTitle;
  }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

     
  
  
  
  
}


 