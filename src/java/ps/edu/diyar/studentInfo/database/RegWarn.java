package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RegWarn
  implements Serializable
{
  private String warnNo;
  private String warnAName;
  private String warnLName;
  private String userId;
  private Date timeStamp;
  private String isActive;
  private String notes;
  
  public RegWarn(String warnNo, String warnAName, String warnLName, String userId, Date timeStamp, String isActive, String notes)
  {
    this.warnNo = warnNo;
    this.warnAName = warnAName;
    this.warnLName = warnLName;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
    this.notes = notes;
  }
  
  public RegWarn() {}
  
  public RegWarn(String warnNo, String warnAName, String userId, Date timeStamp, String isActive)
  {
    this.warnNo = warnNo;
    this.warnAName = warnAName;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
  }
  
  public String getWarnNo()
  {
    return this.warnNo;
  }
  
  public void setWarnNo(String warnNo)
  {
    this.warnNo = warnNo;
  }
  
  public String getWarnAName()
  {
    return this.warnAName;
  }
  
  public void setWarnAName(String warnAName)
  {
    this.warnAName = warnAName;
  }
  
  public String getWarnLName()
  {
    return this.warnLName;
  }
  
  public void setWarnLName(String warnLName)
  {
    this.warnLName = warnLName;
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
    return new ToStringBuilder(this).append("warnNo", getWarnNo()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof RegWarn)) {
      return false;
    }
    RegWarn castOther = (RegWarn)other;
    return new EqualsBuilder().append(getWarnNo(), castOther.getWarnNo()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getWarnNo()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.RegWarn
 * JD-Core Version:    0.7.0.1
 */