package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RegRoom
  implements Serializable
{
  private String roomNo;
  private String roomAName;
  private String roomLName;
  private String userId;
  private Date timeStamp;
  private String isActive;
  private String notes;
  private Integer capacity;
  private Set regClassTimes;
  
  public RegRoom(String roomNo, String roomAName, String roomLName, String userId, Date timeStamp, String isActive, String notes, Integer capacity, Set regClassTimes)
  {
    this.roomNo = roomNo;
    this.roomAName = roomAName;
    this.roomLName = roomLName;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
    this.notes = notes;
    this.capacity = capacity;
    this.regClassTimes = regClassTimes;
  }
  
  public RegRoom() {}
  
  public RegRoom(String roomNo, String roomAName, String userId, Date timeStamp, String isActive, Set regClassTimes)
  {
    this.roomNo = roomNo;
    this.roomAName = roomAName;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
    this.regClassTimes = regClassTimes;
  }
  
  public String getRoomNo()
  {
    return this.roomNo;
  }
  
  public void setRoomNo(String roomNo)
  {
    this.roomNo = roomNo;
  }
  
  public String getRoomAName()
  {
    return this.roomAName;
  }
  
  public void setRoomAName(String roomAName)
  {
    this.roomAName = roomAName;
  }
  
  public String getRoomLName()
  {
    return this.roomLName;
  }
  
  public void setRoomLName(String roomLName)
  {
    this.roomLName = roomLName;
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
  
  public Integer getCapacity()
  {
    return this.capacity;
  }
  
  public void setCapacity(Integer capacity)
  {
    this.capacity = capacity;
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
    return new ToStringBuilder(this).append("roomNo", getRoomNo()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof RegRoom)) {
      return false;
    }
    RegRoom castOther = (RegRoom)other;
    return new EqualsBuilder().append(getRoomNo(), castOther.getRoomNo()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getRoomNo()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.RegRoom
 * JD-Core Version:    0.7.0.1
 */