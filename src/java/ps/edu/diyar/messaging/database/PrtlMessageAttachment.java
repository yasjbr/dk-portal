package ps.edu.diyar.messaging.database;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class PrtlMessageAttachment
  implements Serializable
{
  private PrtlMessageAttachmentPK comp_id;
  private String fileName;
  private Blob fileContent;
  private String fileType;
  private String fileSize;
  private String seed;
  private Date timeStamp;
  
  public PrtlMessageAttachment(PrtlMessageAttachmentPK comp_id, String fileName, Blob fileContent, String fileType, String fileSize, String seed, Date timeStamp)
  {
    this.comp_id = comp_id;
    this.fileName = fileName;
    this.fileContent = fileContent;
    this.fileType = fileType;
    this.fileSize = fileSize;
    this.seed = seed;
    this.timeStamp = timeStamp;
  }
  
  public PrtlMessageAttachment() {}
  
  public PrtlMessageAttachment(PrtlMessageAttachmentPK comp_id, String fileName, String seed)
  {
    this.comp_id = comp_id;
    this.fileName = fileName;
    this.seed = seed;
  }
  
  public PrtlMessageAttachmentPK getComp_id()
  {
    return this.comp_id;
  }
  
  public void setComp_id(PrtlMessageAttachmentPK comp_id)
  {
    this.comp_id = comp_id;
  }
  
  public String getFileName()
  {
    return this.fileName;
  }
  
  public void setFileName(String fileName)
  {
    this.fileName = fileName;
  }
  
  public Blob getFileContent()
  {
    return this.fileContent;
  }
  
  public void setFileContent(Blob fileContent)
  {
    this.fileContent = fileContent;
  }
  
  public String getFileType()
  {
    return this.fileType;
  }
  
  public void setFileType(String fileType)
  {
    this.fileType = fileType;
  }
  
  public String getFileSize()
  {
    return this.fileSize;
  }
  
  public void setFileSize(String fileSize)
  {
    this.fileSize = fileSize;
  }
  
  public String getSeed()
  {
    return this.seed;
  }
  
  public void setSeed(String seed)
  {
    this.seed = seed;
  }
  
  public Date getTimeStamp()
  {
    return this.timeStamp;
  }
  
  public void setTimeStamp(Date timeStamp)
  {
    this.timeStamp = timeStamp;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("comp_id", getComp_id()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof PrtlMessageAttachment)) {
      return false;
    }
    PrtlMessageAttachment castOther = (PrtlMessageAttachment)other;
    return new EqualsBuilder().append(getComp_id(), castOther.getComp_id()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getComp_id()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.messaging.database.PrtlMessageAttachment
 * JD-Core Version:    0.7.0.1
 */