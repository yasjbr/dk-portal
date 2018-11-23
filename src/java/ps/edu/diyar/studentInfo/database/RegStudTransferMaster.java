package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RegStudTransferMaster
  implements Serializable
{
  private String studId;
  private String prevCollege;
  private String prevSpec;
  private String userId;
  private Date timeStamp;
  private String isActive;
  private String notes;
  
  public RegStudTransferMaster(String studId, String prevCollege, String prevSpec, String userId, Date timeStamp, String isActive, String notes)
  {
    this.studId = studId;
    this.prevCollege = prevCollege;
    this.prevSpec = prevSpec;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
    this.notes = notes;
  }
  
  public RegStudTransferMaster() {}
  
  public RegStudTransferMaster(String studId, String userId, Date timeStamp, String isActive)
  {
    this.studId = studId;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
  }
  
  public String getStudId()
  {
    return this.studId;
  }
  
  public void setStudId(String studId)
  {
    this.studId = studId;
  }
  
  public String getPrevCollege()
  {
    return this.prevCollege;
  }
  
  public void setPrevCollege(String prevCollege)
  {
    this.prevCollege = prevCollege;
  }
  
  public String getPrevSpec()
  {
    return this.prevSpec;
  }
  
  public void setPrevSpec(String prevSpec)
  {
    this.prevSpec = prevSpec;
  }
  
  public String getUserId()
  {
    return this.userId;
  }
  
  public void setUserId(String userId)
  {
    this.userId = userId;
  }
  
  public Date getTimeStamp()
  {
    return this.timeStamp;
  }
  
  public void setTimeStamp(Date timeStamp)
  {
    this.timeStamp = timeStamp;
  }
  
  public String getIsActive()
  {
    return this.isActive;
  }
  
  public void setIsActive(String isActive)
  {
    this.isActive = isActive;
  }
  
  public String getNotes()
  {
    return this.notes;
  }
  
  public void setNotes(String notes)
  {
    this.notes = notes;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("studId", getStudId()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof RegStudTransferMaster)) {
      return false;
    }
    RegStudTransferMaster castOther = (RegStudTransferMaster)other;
    return new EqualsBuilder().append(getStudId(), castOther.getStudId()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getStudId()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.RegStudTransferMaster
 * JD-Core Version:    0.7.0.1
 */