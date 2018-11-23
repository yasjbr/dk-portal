package ps.edu.diyar.messaging.database;

import java.io.Serializable;
import java.sql.Clob;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class PrtlMessageContent
  implements Serializable
{
  private Long msgId;
  private String msgTitle;
  private Clob msgBody;
  private String msgType;
  private String hasAttachment;
  private String servirity;
  private String seed;
  private String senderId;
  private String termNo;
  private String crsNo;
  private String classNo;
  private String extraInfo;
  private Date timeStamp;
  private String computerIp;
  private String deleted;
  private String deleteDate;
  
  
  public PrtlMessageContent(Long msgId, String msgTitle, Clob msgBody, String msgType, String hasAttachment, String servirity, String seed, String senderId, String termNo, String crsNo, String classNo, String extraInfo, Date timeStamp, String computerIp,String deleted,String deleteDate)
  {
    this.msgId = msgId;
    this.msgTitle = msgTitle;
    this.msgBody = msgBody;
    this.msgType = msgType;
    this.hasAttachment = hasAttachment;
    this.servirity = servirity;
    this.seed = seed;
    this.senderId = senderId;
    this.termNo = termNo;
    this.crsNo = crsNo;
    this.classNo = classNo;
    this.extraInfo = extraInfo;
    this.timeStamp = timeStamp;
    this.computerIp = computerIp;
    
   this.deleted =deleted;
 this.deleteDate=deleteDate;
  }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public String getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(String deleteDate) {
        this.deleteDate = deleteDate;
    }
  
  
  
  public PrtlMessageContent() {}
  
  public PrtlMessageContent(Long msgId, String msgTitle, Clob msgBody, String senderId, Date timeStamp)
  {
    this.msgId = msgId;
    this.msgTitle = msgTitle;
    this.msgBody = msgBody;
    this.senderId = senderId;
    this.timeStamp = timeStamp;
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
  
  public Clob getMsgBody()
  {
    return this.msgBody;
  }
  
  public void setMsgBody(Clob msgBody)
  {
    this.msgBody = msgBody;
  }
  
  public String getMsgType()
  {
    return this.msgType;
  }
  
  public void setMsgType(String msgType)
  {
    this.msgType = msgType;
  }
  
  public String getHasAttachment()
  {
    return this.hasAttachment;
  }
  
  public void setHasAttachment(String hasAttachment)
  {
    this.hasAttachment = hasAttachment;
  }
  
  public String getServirity()
  {
    return this.servirity;
  }
  
  public void setServirity(String servirity)
  {
    this.servirity = servirity;
  }
  
  public String getSeed()
  {
    return this.seed;
  }
  
  public void setSeed(String seed)
  {
    this.seed = seed;
  }
  
  public String getSenderId()
  {
    return this.senderId;
  }
  
  public void setSenderId(String senderId)
  {
    this.senderId = senderId;
  }
  
  public String getTermNo()
  {
    return this.termNo;
  }
  
  public void setTermNo(String termNo)
  {
    this.termNo = termNo;
  }
  
  public String getCrsNo()
  {
    return this.crsNo;
  }
  
  public void setCrsNo(String crsNo)
  {
    this.crsNo = crsNo;
  }
  
  public String getClassNo()
  {
    return this.classNo;
  }
  
  public void setClassNo(String classNo)
  {
    this.classNo = classNo;
  }
  
  public String getExtraInfo()
  {
    return this.extraInfo;
  }
  
  public void setExtraInfo(String extraInfo)
  {
    this.extraInfo = extraInfo;
  }
  
  public Date getTimeStamp()
  {
    return this.timeStamp;
  }
  
  public void setTimeStamp(Date timeStamp)
  {
    this.timeStamp = timeStamp;
  }
  
  public String getComputerIp()
  {
    return this.computerIp;
  }
  
  public void setComputerIp(String computerIp)
  {
    this.computerIp = computerIp;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("msgId", getMsgId()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof PrtlMessageContent)) {
      return false;
    }
    PrtlMessageContent castOther = (PrtlMessageContent)other;
    return new EqualsBuilder().append(getMsgId(), castOther.getMsgId()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getMsgId()).toHashCode();
  }
}



/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\

 * Qualified Name:     ps.edu.diyar.messaging.database.PrtlMessageContent

 * JD-Core Version:    0.7.0.1

 */