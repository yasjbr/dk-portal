package ps.edu.diyar.admission.database;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class AdmExceptionsTyp
  implements Serializable
{
  private Byte expId;
  private String expAName;
  private String expLName;
  private String userId;
  private Date timeStamp;
  private String isActive;
  private String notes;
  private Set admAppsExceptions;
  
  public AdmExceptionsTyp(Byte expId, String expAName, String expLName, String userId, Date timeStamp, String isActive, String notes, Set admAppsExceptions)
  {
    this.expId = expId;
    this.expAName = expAName;
    this.expLName = expLName;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
    this.notes = notes;
    this.admAppsExceptions = admAppsExceptions;
  }
  
  public AdmExceptionsTyp() {}
  
  public AdmExceptionsTyp(Byte expId, String expAName, String expLName, String userId, Date timeStamp, Set admAppsExceptions)
  {
    this.expId = expId;
    this.expAName = expAName;
    this.expLName = expLName;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.admAppsExceptions = admAppsExceptions;
  }
  
  public Byte getExpId()
  {
    return this.expId;
  }
  
  public void setExpId(Byte expId)
  {
    this.expId = expId;
  }
  
  public String getExpAName()
  {
    return this.expAName;
  }
  
  public void setExpAName(String expAName)
  {
    this.expAName = expAName;
  }
  
  public String getExpLName()
  {
    return this.expLName;
  }
  
  public void setExpLName(String expLName)
  {
    this.expLName = expLName;
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
  
  public Set getAdmAppsExceptions()
  {
    return this.admAppsExceptions;
  }
  
  public void setAdmAppsExceptions(Set admAppsExceptions)
  {
    this.admAppsExceptions = admAppsExceptions;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("expId", getExpId()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof AdmExceptionsTyp)) {
      return false;
    }
    AdmExceptionsTyp castOther = (AdmExceptionsTyp)other;
    return new EqualsBuilder().append(getExpId(), castOther.getExpId()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getExpId()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.admission.database.AdmExceptionsTyp
 * JD-Core Version:    0.7.0.1
 */