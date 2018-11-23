package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RegCalendar
  implements Serializable
{
  private RegCalendarPK comp_id;
  private Date begDate;
  private Date endDate;
  private String userId;
  private Date timeStamp;
  private String isActive;
  private String notes;
  
  public RegCalendar(RegCalendarPK comp_id, Date begDate, Date endDate, String userId, Date timeStamp, String isActive, String notes)
  {
    this.comp_id = comp_id;
    this.begDate = begDate;
    this.endDate = endDate;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
    this.notes = notes;
  }
  
  public RegCalendar() {}
  
  public RegCalendar(RegCalendarPK comp_id, Date begDate, Date endDate, String userId, Date timeStamp)
  {
    this.comp_id = comp_id;
    this.begDate = begDate;
    this.endDate = endDate;
    this.userId = userId;
    this.timeStamp = timeStamp;
  }
  
  public RegCalendarPK getComp_id()
  {
    return this.comp_id;
  }
  
  public void setComp_id(RegCalendarPK comp_id)
  {
    this.comp_id = comp_id;
  }
  
  public Date getBegDate()
  {
    return this.begDate;
  }
  
  public void setBegDate(Date begDate)
  {
    this.begDate = begDate;
  }
  
  public Date getEndDate()
  {
    return this.endDate;
  }
  
  public void setEndDate(Date endDate)
  {
    this.endDate = endDate;
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
    if (!(other instanceof RegCalendar)) {
      return false;
    }
    RegCalendar castOther = (RegCalendar)other;
    return new EqualsBuilder().append(getComp_id(), castOther.getComp_id()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getComp_id()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.RegCalendar
 * JD-Core Version:    0.7.0.1
 */