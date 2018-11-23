package ps.edu.diyar.messaging.database;

import java.io.Serializable;

public class PrtlMsgTutorInfoVwPK
  implements Serializable
{
  private Long msgId;
  private String senderId;
  
  public PrtlMsgTutorInfoVwPK() {}
  
  public PrtlMsgTutorInfoVwPK(Long msgId, String senderId)
  {
    this.msgId = msgId;
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
  
  public String getSenderId()
  {
    return this.senderId;
  }
  
  public void setSenderId(String senderId)
  {
    this.senderId = senderId;
  }
  
  public boolean equals(Object o)
  {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    PrtlMsgTutorInfoVwPK that = (PrtlMsgTutorInfoVwPK)o;
    if (this.msgId != null ? !this.msgId.equals(that.msgId) : that.msgId != null) {
      return false;
    }
    if (this.senderId != null ? !this.senderId.equals(that.senderId) : that.senderId != null) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int result = this.msgId != null ? this.msgId.hashCode() : 0;
    result = 31 * result + (this.senderId != null ? this.senderId.hashCode() : 0);
    return result;
  }
}
