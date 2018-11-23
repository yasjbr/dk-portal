package ps.edu.diyar.admission.database;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class AdmAppsStatus
  implements Serializable
{
  private String statId;
  private String statAName;
  private String statLName;
  private String userId;
  private Date timeStamp;
  private String isActive;
  private String notes;
  
  public AdmAppsStatus(String statId, String statAName, String statLName, String userId, Date timeStamp, String isActive, String notes)
  {
    this.statId = statId;
    this.statAName = statAName;
    this.statLName = statLName;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
    this.notes = notes;
  }
  
  public AdmAppsStatus() {}
  
  public AdmAppsStatus(String statId, String statAName, String userId, Date timeStamp)
  {
    this.statId = statId;
    this.statAName = statAName;
    this.userId = userId;
    this.timeStamp = timeStamp;
  }
  
  public String getStatId()
  {
    return this.statId;
  }
  
  public void setStatId(String statId)
  {
    this.statId = statId;
  }
  
  public String getStatAName()
  {
    return this.statAName;
  }
  
  public void setStatAName(String statAName)
  {
    this.statAName = statAName;
  }
  
  public String getStatLName()
  {
    return this.statLName;
  }
  
  public void setStatLName(String statLName)
  {
    this.statLName = statLName;
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
    return new ToStringBuilder(this).append("statId", getStatId()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof AdmAppsStatus)) {
      return false;
    }
    AdmAppsStatus castOther = (AdmAppsStatus)other;
    return new EqualsBuilder().append(getStatId(), castOther.getStatId()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getStatId()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.admission.database.AdmAppsStatus
 * JD-Core Version:    0.7.0.1
 */