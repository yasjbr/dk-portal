package ps.edu.diyar.messaging.database;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class PrtlMessageRecipientPK
  implements Serializable
{
  private Long msgId;
  private String recipientId;
  
  public PrtlMessageRecipientPK(Long msgId, String recipientId)
  {
    this.msgId = msgId;
    this.recipientId = recipientId;
  }
  
  public PrtlMessageRecipientPK() {}
  
  public Long getMsgId()
  {
    return this.msgId;
  }
  
  public void setMsgId(Long msgId)
  {
    this.msgId = msgId;
  }
  
  public String getRecipientId()
  {
    return this.recipientId;
  }
  
  public void setRecipientId(String recipientId)
  {
    this.recipientId = recipientId;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("msgId", getMsgId()).append("recipientId", getRecipientId()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof PrtlMessageRecipientPK)) {
      return false;
    }
    PrtlMessageRecipientPK castOther = (PrtlMessageRecipientPK)other;
    return new EqualsBuilder().append(getMsgId(), castOther.getMsgId()).append(getRecipientId(), castOther.getRecipientId()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getMsgId()).append(getRecipientId()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.messaging.database.PrtlMessageRecipientPK
 * JD-Core Version:    0.7.0.1
 */