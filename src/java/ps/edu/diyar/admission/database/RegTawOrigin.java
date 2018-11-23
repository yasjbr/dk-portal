package ps.edu.diyar.admission.database;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RegTawOrigin
  implements Serializable
{
  private String tawOriginNo;
  private String tawOriginAName;
  private String tawOriginLName;
  private String userId;
  private Date timeStamp;
  private String isActive;
  private String notes;
  private String hasBranch;
  
  public RegTawOrigin(String tawOriginNo, String tawOriginAName, String tawOriginLName, String userId, Date timeStamp, String isActive, String notes, String hasBranch)
  {
    this.tawOriginNo = tawOriginNo;
    this.tawOriginAName = tawOriginAName;
    this.tawOriginLName = tawOriginLName;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
    this.notes = notes;
    this.hasBranch = hasBranch;
  }
  
  public RegTawOrigin() {}
  
  public RegTawOrigin(String tawOriginNo, String tawOriginAName, String userId, Date timeStamp, String isActive)
  {
    this.tawOriginNo = tawOriginNo;
    this.tawOriginAName = tawOriginAName;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
  }
  
  public String getTawOriginNo()
  {
    return this.tawOriginNo;
  }
  
  public void setTawOriginNo(String tawOriginNo)
  {
    this.tawOriginNo = tawOriginNo;
  }
  
  public String getTawOriginAName()
  {
    return this.tawOriginAName;
  }
  
  public void setTawOriginAName(String tawOriginAName)
  {
    this.tawOriginAName = tawOriginAName;
  }
  
  public String getTawOriginLName()
  {
    return this.tawOriginLName;
  }
  
  public void setTawOriginLName(String tawOriginLName)
  {
    this.tawOriginLName = tawOriginLName;
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
  
  public String getHasBranch()
  {
    return this.hasBranch;
  }
  
  public void setHasBranch(String hasBranch)
  {
    this.hasBranch = hasBranch;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("tawOriginNo", getTawOriginNo()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof RegTawOrigin)) {
      return false;
    }
    RegTawOrigin castOther = (RegTawOrigin)other;
    return new EqualsBuilder().append(getTawOriginNo(), castOther.getTawOriginNo()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getTawOriginNo()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.admission.database.RegTawOrigin
 * JD-Core Version:    0.7.0.1
 */