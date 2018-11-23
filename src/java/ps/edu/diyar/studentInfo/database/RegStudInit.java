package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RegStudInit
  implements Serializable
{
  private RegStudInitPK comp_id;
  private short crsHrs;
  private String userId;
  private Date timeStamp;
  private String isActive;
  private String notes;
  private String posted;
  
  public RegStudInit(RegStudInitPK comp_id, short crsHrs, String userId, Date timeStamp, String isActive, String notes, String posted)
  {
    this.comp_id = comp_id;
    this.crsHrs = crsHrs;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
    this.notes = notes;
    this.posted = posted;
  }
  
  public RegStudInit() {}
  
  public RegStudInit(RegStudInitPK comp_id, short crsHrs, String userId, Date timeStamp, String isActive, String posted)
  {
    this.comp_id = comp_id;
    this.crsHrs = crsHrs;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
    this.posted = posted;
  }
  
  public RegStudInitPK getComp_id()
  {
    return this.comp_id;
  }
  
  public void setComp_id(RegStudInitPK comp_id)
  {
    this.comp_id = comp_id;
  }
  
  public short getCrsHrs()
  {
    return this.crsHrs;
  }
  
  public void setCrsHrs(short crsHrs)
  {
    this.crsHrs = crsHrs;
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
  
  public String getPosted()
  {
    return this.posted;
  }
  
  public void setPosted(String posted)
  {
    this.posted = posted;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("comp_id", getComp_id()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof RegStudInit)) {
      return false;
    }
    RegStudInit castOther = (RegStudInit)other;
    return new EqualsBuilder().append(getComp_id(), castOther.getComp_id()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getComp_id()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.RegStudInit
 * JD-Core Version:    0.7.0.1
 */