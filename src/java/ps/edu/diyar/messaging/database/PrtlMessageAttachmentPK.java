package ps.edu.diyar.messaging.database;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class PrtlMessageAttachmentPK
  implements Serializable
{
  private Long fileId;
  private Long msgId;
  
  public PrtlMessageAttachmentPK(Long fileId, Long msgId)
  {
    this.fileId = fileId;
    this.msgId = msgId;
  }
  
  public PrtlMessageAttachmentPK() {}
  
  public Long getFileId()
  {
    return this.fileId;
  }
  
  public void setFileId(Long fileId)
  {
    this.fileId = fileId;
  }
  
  public Long getMsgId()
  {
    return this.msgId;
  }
  
  public void setMsgId(Long msgId)
  {
    this.msgId = msgId;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("fileId", getFileId()).append("msgId", getMsgId()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof PrtlMessageAttachmentPK)) {
      return false;
    }
    PrtlMessageAttachmentPK castOther = (PrtlMessageAttachmentPK)other;
    return new EqualsBuilder().append(getFileId(), castOther.getFileId()).append(getMsgId(), castOther.getMsgId()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getFileId()).append(getMsgId()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.messaging.database.PrtlMessageAttachmentPK
 * JD-Core Version:    0.7.0.1
 */