package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RegLocality
  implements Serializable
{
  private RegLocalityPK comp_id;
  private String localityAName;
  private String localityLName;
  private String userId;
  private Date timeStamp;
  private String isActive;
  private String notes;
  
  public RegLocality(RegLocalityPK comp_id, String localityAName, String localityLName, String userId, Date timeStamp, String isActive, String notes)
  {
    this.comp_id = comp_id;
    this.localityAName = localityAName;
    this.localityLName = localityLName;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
    this.notes = notes;
  }
  
  public RegLocality() {}
  
  public RegLocality(RegLocalityPK comp_id, String localityAName, String userId, Date timeStamp, String isActive)
  {
    this.comp_id = comp_id;
    this.localityAName = localityAName;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
  }
  
  public RegLocalityPK getComp_id()
  {
    return this.comp_id;
  }
  
  public void setComp_id(RegLocalityPK comp_id)
  {
    this.comp_id = comp_id;
  }
  
  public String getLocalityAName()
  {
    return this.localityAName;
  }
  
  public void setLocalityAName(String localityAName)
  {
    this.localityAName = localityAName;
  }
  
  public String getLocalityLName()
  {
    return this.localityLName;
  }
  
  public void setLocalityLName(String localityLName)
  {
    this.localityLName = localityLName;
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
    return new ToStringBuilder(this).append("comp_id", getComp_id()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof RegLocality)) {
      return false;
    }
    RegLocality castOther = (RegLocality)other;
    return new EqualsBuilder().append(getComp_id(), castOther.getComp_id()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getComp_id()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.RegLocality
 * JD-Core Version:    0.7.0.1
 */