package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RegCalendarItem
  implements Serializable
{
  private String itemNo;
  private String itemAName;
  private String itemLName;
  private String userId;
  private Date timeStamp;
  private String isActive;
  private String notes;
  
  public RegCalendarItem(String itemNo, String itemAName, String itemLName, String userId, Date timeStamp, String isActive, String notes)
  {
    this.itemNo = itemNo;
    this.itemAName = itemAName;
    this.itemLName = itemLName;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
    this.notes = notes;
  }
  
  public RegCalendarItem() {}
  
  public RegCalendarItem(String itemNo, String itemAName, String userId, Date timeStamp, String isActive)
  {
    this.itemNo = itemNo;
    this.itemAName = itemAName;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
  }
  
  public String getItemNo()
  {
    return this.itemNo;
  }
  
  public void setItemNo(String itemNo)
  {
    this.itemNo = itemNo;
  }
  
  public String getItemAName()
  {
    return this.itemAName;
  }
  
  public void setItemAName(String itemAName)
  {
    this.itemAName = itemAName;
  }
  
  public String getItemLName()
  {
    return this.itemLName;
  }
  
  public void setItemLName(String itemLName)
  {
    this.itemLName = itemLName;
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
    return new ToStringBuilder(this).append("itemNo", getItemNo()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof RegCalendarItem)) {
      return false;
    }
    RegCalendarItem castOther = (RegCalendarItem)other;
    return new EqualsBuilder().append(getItemNo(), castOther.getItemNo()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getItemNo()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.RegCalendarItem
 * JD-Core Version:    0.7.0.1
 */