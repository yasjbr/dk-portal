package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RegCoursePrereq
  implements Serializable
{
  private RegCoursePrereqPK comp_id;
  private String cpType;
  private String userId;
  private Date timeStamp;
  private String isActive;
  private String notes;
  
  public RegCoursePrereq(RegCoursePrereqPK comp_id, String cpType, String userId, Date timeStamp, String isActive, String notes)
  {
    this.comp_id = comp_id;
    this.cpType = cpType;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
    this.notes = notes;
  }
  
  public RegCoursePrereq() {}
  
  public RegCoursePrereq(RegCoursePrereqPK comp_id, String cpType, String userId, Date timeStamp, String isActive)
  {
    this.comp_id = comp_id;
    this.cpType = cpType;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
  }
  
  public RegCoursePrereqPK getComp_id()
  {
    return this.comp_id;
  }
  
  public void setComp_id(RegCoursePrereqPK comp_id)
  {
    this.comp_id = comp_id;
  }
  
  public String getCpType()
  {
    return this.cpType;
  }
  
  public void setCpType(String cpType)
  {
    this.cpType = cpType;
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
    if (!(other instanceof RegCoursePrereq)) {
      return false;
    }
    RegCoursePrereq castOther = (RegCoursePrereq)other;
    return new EqualsBuilder().append(getComp_id(), castOther.getComp_id()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getComp_id()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.RegCoursePrereq
 * JD-Core Version:    0.7.0.1
 */