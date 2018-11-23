package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RegLangLevel
  implements Serializable
{
  private String levelNo;
  private String levelAName;
  private String levelLName;
  private String userId;
  private Date timeStamp;
  private String isActive;
  private String notes;
  
  public RegLangLevel(String levelNo, String levelAName, String levelLName, String userId, Date timeStamp, String isActive, String notes)
  {
    this.levelNo = levelNo;
    this.levelAName = levelAName;
    this.levelLName = levelLName;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
    this.notes = notes;
  }
  
  public RegLangLevel() {}
  
  public RegLangLevel(String levelNo, String levelAName, String userId, Date timeStamp, String isActive)
  {
    this.levelNo = levelNo;
    this.levelAName = levelAName;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
  }
  
  public String getLevelNo()
  {
    return this.levelNo;
  }
  
  public void setLevelNo(String levelNo)
  {
    this.levelNo = levelNo;
  }
  
  public String getLevelAName()
  {
    return this.levelAName;
  }
  
  public void setLevelAName(String levelAName)
  {
    this.levelAName = levelAName;
  }
  
  public String getLevelLName()
  {
    return this.levelLName;
  }
  
  public void setLevelLName(String levelLName)
  {
    this.levelLName = levelLName;
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
    return new ToStringBuilder(this).append("levelNo", getLevelNo()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof RegLangLevel)) {
      return false;
    }
    RegLangLevel castOther = (RegLangLevel)other;
    return new EqualsBuilder().append(getLevelNo(), castOther.getLevelNo()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getLevelNo()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.RegLangLevel
 * JD-Core Version:    0.7.0.1
 */