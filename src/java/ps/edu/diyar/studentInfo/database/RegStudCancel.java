package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RegStudCancel
  implements Serializable
{
  private RegStudCancelPK comp_id;
  private String studStatus;
  private Date cancellDate;
  private Integer termCountCancell;
  private String userId;
  private Date timeStamp;
  private String notes;
  private String isActive;
  
  public RegStudCancel(RegStudCancelPK comp_id, String studStatus, Date cancellDate, Integer termCountCancell, String userId, Date timeStamp, String notes, String isActive)
  {
    this.comp_id = comp_id;
    this.studStatus = studStatus;
    this.cancellDate = cancellDate;
    this.termCountCancell = termCountCancell;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.notes = notes;
    this.isActive = isActive;
  }
  
  public RegStudCancel() {}
  
  public RegStudCancel(RegStudCancelPK comp_id, String studStatus, Date cancellDate, String userId, Date timeStamp, String isActive)
  {
    this.comp_id = comp_id;
    this.studStatus = studStatus;
    this.cancellDate = cancellDate;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
  }
  
  public RegStudCancelPK getComp_id()
  {
    return this.comp_id;
  }
  
  public void setComp_id(RegStudCancelPK comp_id)
  {
    this.comp_id = comp_id;
  }
  
  public String getStudStatus()
  {
    return this.studStatus;
  }
  
  public void setStudStatus(String studStatus)
  {
    this.studStatus = studStatus;
  }
  
  public Date getCancellDate()
  {
    return this.cancellDate;
  }
  
  public void setCancellDate(Date cancellDate)
  {
    this.cancellDate = cancellDate;
  }
  
  public Integer getTermCountCancell()
  {
    return this.termCountCancell;
  }
  
  public void setTermCountCancell(Integer termCountCancell)
  {
    this.termCountCancell = termCountCancell;
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
  
  public String getNotes()
  {
    return this.notes;
  }
  
  public void setNotes(String notes)
  {
    this.notes = notes;
  }
  
  public String getIsActive()
  {
    return this.isActive;
  }
  
  public void setIsActive(String isActive)
  {
    this.isActive = isActive;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("comp_id", getComp_id()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof RegStudCancel)) {
      return false;
    }
    RegStudCancel castOther = (RegStudCancel)other;
    return new EqualsBuilder().append(getComp_id(), castOther.getComp_id()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getComp_id()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.RegStudCancel
 * JD-Core Version:    0.7.0.1
 */