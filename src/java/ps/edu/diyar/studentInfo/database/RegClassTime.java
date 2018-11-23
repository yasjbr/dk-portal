package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RegClassTime
  implements Serializable
{
  private RegClassTimePK comp_id;
  private String dayNo;
  private Integer begTime;
  private Integer endTime;
  private String roomNo;
  private String userId;
  private Date timeStamp;
  private String isActive;
  private String notes;
  
  public RegClassTime(RegClassTimePK comp_id, String dayNo, Integer begTime, Integer endTime, String roomNo, String userId, Date timeStamp, String isActive, String notes)
  {
    this.comp_id = comp_id;
    this.dayNo = dayNo;
    this.begTime = begTime;
    this.endTime = endTime;
    this.roomNo = roomNo;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
    this.notes = notes;
  }
  
  public RegClassTime() {}
  
  public RegClassTime(RegClassTimePK comp_id, String userId, Date timeStamp, String isActive)
  {
    this.comp_id = comp_id;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
  }
  
  public RegClassTimePK getComp_id()
  {
    return this.comp_id;
  }
  
  public void setComp_id(RegClassTimePK comp_id)
  {
    this.comp_id = comp_id;
  }
  
  public String getDayNo()
  {
    return this.dayNo;
  }
  
  public void setDayNo(String dayNo)
  {
    this.dayNo = dayNo;
  }
  
  public Integer getBegTime()
  {
    return this.begTime;
  }
  
  public void setBegTime(Integer begTime)
  {
    this.begTime = begTime;
  }
  
  public Integer getEndTime()
  {
    return this.endTime;
  }
  
  public void setEndTime(Integer endTime)
  {
    this.endTime = endTime;
  }
  
  public String getRoomNo()
  {
    return this.roomNo;
  }
  
  public void setRoomNo(String roomNo)
  {
    this.roomNo = roomNo;
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
    if (!(other instanceof RegClassTime)) {
      return false;
    }
    RegClassTime castOther = (RegClassTime)other;
    return new EqualsBuilder().append(getComp_id(), castOther.getComp_id()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getComp_id()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.RegClassTime
 * JD-Core Version:    0.7.0.1
 */