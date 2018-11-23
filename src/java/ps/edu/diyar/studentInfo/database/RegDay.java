package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RegDay
  implements Serializable
{
  private String dayNo;
  private String dayAName;
  private String dayLName;
  private String dayAbbrev;
  private String userId;
  private Date timeStamp;
  private String isActive;
  private String notes;
  private Set regClassTimes;
  
  public RegDay(String dayNo, String dayAName, String dayLName, String dayAbbrev, String userId, Date timeStamp, String isActive, String notes, Set regClassTimes)
  {
    this.dayNo = dayNo;
    this.dayAName = dayAName;
    this.dayLName = dayLName;
    this.dayAbbrev = dayAbbrev;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
    this.notes = notes;
    this.regClassTimes = regClassTimes;
  }
  
  public RegDay() {}
  
  public RegDay(String dayNo, String dayAName, String userId, Date timeStamp, String isActive, Set regClassTimes)
  {
    this.dayNo = dayNo;
    this.dayAName = dayAName;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
    this.regClassTimes = regClassTimes;
  }
  
  public String getDayNo()
  {
    return this.dayNo;
  }
  
  public void setDayNo(String dayNo)
  {
    this.dayNo = dayNo;
  }
  
  public String getDayAName()
  {
    return this.dayAName;
  }
  
  public void setDayAName(String dayAName)
  {
    this.dayAName = dayAName;
  }
  
  public String getDayLName()
  {
    return this.dayLName;
  }
  
  public void setDayLName(String dayLName)
  {
    this.dayLName = dayLName;
  }
  
  public String getDayAbbrev()
  {
    return this.dayAbbrev;
  }
  
  public void setDayAbbrev(String dayAbbrev)
  {
    this.dayAbbrev = dayAbbrev;
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
  
  public Set getRegClassTimes()
  {
    return this.regClassTimes;
  }
  
  public void setRegClassTimes(Set regClassTimes)
  {
    this.regClassTimes = regClassTimes;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("dayNo", getDayNo()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof RegDay)) {
      return false;
    }
    RegDay castOther = (RegDay)other;
    return new EqualsBuilder().append(getDayNo(), castOther.getDayNo()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getDayNo()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.RegDay
 * JD-Core Version:    0.7.0.1
 */