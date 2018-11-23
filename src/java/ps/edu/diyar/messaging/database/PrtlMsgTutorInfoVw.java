package ps.edu.diyar.messaging.database;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;

public class PrtlMsgTutorInfoVw
  implements Serializable
{
  private PrtlMsgTutorInfoVwPK comp_id;
  private String msgTitle;
  private String hasAttachment;
  private String termNo;
  private String crsNo;
  private String classNo;
  private String extraInfo;
  private String senderName;
 
  private Date msgDate;
 
  private String servirity;
  private String msgBody;
  private String msgSeed;
 
  private String senderDeleted;
  private String recipientDeleted;
  
  
  public PrtlMsgTutorInfoVw() {}
  
  public PrtlMsgTutorInfoVw(String msgTitle, String hasAttachment, String termNo, String crsNo, String classNo, String extraInfo, String senderName )
  {
    this.msgTitle = msgTitle;
    this.hasAttachment = hasAttachment;
    this.termNo = termNo;
    this.crsNo = crsNo;
    this.classNo = classNo;
    this.extraInfo = extraInfo;
    this.senderName = senderName;
     
     
  }

    public String getSenderDeleted() {
        return senderDeleted;
    }

    public void setSenderDeleted(String senderDeleted) {
        this.senderDeleted = senderDeleted;
    }

    public String getRecipientDeleted() {
        return recipientDeleted;
    }

    public void setRecipientDeleted(String recipientDeleted) {
        this.recipientDeleted = recipientDeleted;
    }
  
  
  
  
  
  public String getMsgSeed()
  {
    return this.msgSeed;
  }
  
  public void setMsgSeed(String msgSeed)
  {
    this.msgSeed = msgSeed;
  }
  
  public String getMsgBody()
  {
    return this.msgBody;
  }
  
  public void setMsgBody(String msgBody)
  {
    this.msgBody = msgBody;
  }
  
  public String getServirity()
  {
    return this.servirity;
  }
  
  public void setServirity(String servirity)
  {
    this.servirity = servirity;
  }
  
  public Date getMsgDate()
  {
    return this.msgDate;
  }
  
  public void setMsgDate(Date msgDate)
  {
    this.msgDate = msgDate;
  }
  
   
   
   
  
  public PrtlMsgTutorInfoVwPK getComp_id()
  {
    return this.comp_id;
  }
  
  public void setComp_id(PrtlMsgTutorInfoVwPK comp_id)
  {
    this.comp_id = comp_id;
  }
  
  public String getMsgTitle()
  {
    return this.msgTitle;
  }
  
  public void setMsgTitle(String msgTitle)
  {
    this.msgTitle = msgTitle;
  }
  
  public String getHasAttachment()
  {
    return this.hasAttachment;
  }
  
  public void setHasAttachment(String hasAttachment)
  {
    this.hasAttachment = hasAttachment;
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
  
  public String getSenderName()
  {
    return this.senderName;
  }
  
  public void setSenderName(String senderName)
  {
    this.senderName = senderName;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).toString();
  }

    
  
  
  
}
 