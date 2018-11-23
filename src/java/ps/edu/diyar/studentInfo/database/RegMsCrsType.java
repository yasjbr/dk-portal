package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RegMsCrsType
  implements Serializable
{
  private String msCrsType;
  private String msCrsTypeAName;
  private String msCrsTypeLName;
  private String userId;
  private Date timeStamp;
  private String isActive;
  private String notes;
  
  public RegMsCrsType(String msCrsType, String msCrsTypeAName, String msCrsTypeLName, String userId, Date timeStamp, String isActive, String notes)
  {
    this.msCrsType = msCrsType;
    this.msCrsTypeAName = msCrsTypeAName;
    this.msCrsTypeLName = msCrsTypeLName;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
    this.notes = notes;
  }
  
  public RegMsCrsType() {}
  
  public RegMsCrsType(String msCrsType, String msCrsTypeAName, String userId, Date timeStamp, String isActive)
  {
    this.msCrsType = msCrsType;
    this.msCrsTypeAName = msCrsTypeAName;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
  }
  
  public String getMsCrsType()
  {
    return this.msCrsType;
  }
  
  public void setMsCrsType(String msCrsType)
  {
    this.msCrsType = msCrsType;
  }
  
  public String getMsCrsTypeAName()
  {
    return this.msCrsTypeAName;
  }
  
  public void setMsCrsTypeAName(String msCrsTypeAName)
  {
    this.msCrsTypeAName = msCrsTypeAName;
  }
  
  public String getMsCrsTypeLName()
  {
    return this.msCrsTypeLName;
  }
  
  public void setMsCrsTypeLName(String msCrsTypeLName)
  {
    this.msCrsTypeLName = msCrsTypeLName;
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
    return new ToStringBuilder(this).append("msCrsType", getMsCrsType()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof RegMsCrsType)) {
      return false;
    }
    RegMsCrsType castOther = (RegMsCrsType)other;
    return new EqualsBuilder().append(getMsCrsType(), castOther.getMsCrsType()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getMsCrsType()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.RegMsCrsType
 * JD-Core Version:    0.7.0.1
 */