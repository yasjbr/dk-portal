package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RegSpecTypes
  implements Serializable
{
  private String specTypeNo;
  private String specTypeAName;
  private String specTypeLName;
  private String userId;
  private Date timeStamp;
  private String isActive;
  private String notes;
  
  public RegSpecTypes(String specTypeNo, String specTypeAName, String specTypeLName, String userId, Date timeStamp, String isActive, String notes)
  {
    this.specTypeNo = specTypeNo;
    this.specTypeAName = specTypeAName;
    this.specTypeLName = specTypeLName;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
    this.notes = notes;
  }
  
  public RegSpecTypes() {}
  
  public RegSpecTypes(String specTypeNo, String specTypeAName, String userId, Date timeStamp, String isActive)
  {
    this.specTypeNo = specTypeNo;
    this.specTypeAName = specTypeAName;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
  }
  
  public String getSpecTypeNo()
  {
    return this.specTypeNo;
  }
  
  public void setSpecTypeNo(String specTypeNo)
  {
    this.specTypeNo = specTypeNo;
  }
  
  public String getSpecTypeAName()
  {
    return this.specTypeAName;
  }
  
  public void setSpecTypeAName(String specTypeAName)
  {
    this.specTypeAName = specTypeAName;
  }
  
  public String getSpecTypeLName()
  {
    return this.specTypeLName;
  }
  
  public void setSpecTypeLName(String specTypeLName)
  {
    this.specTypeLName = specTypeLName;
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
    return new ToStringBuilder(this).append("specTypeNo", getSpecTypeNo()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof RegSpecTypes)) {
      return false;
    }
    RegSpecTypes castOther = (RegSpecTypes)other;
    return new EqualsBuilder().append(getSpecTypeNo(), castOther.getSpecTypeNo()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getSpecTypeNo()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.RegSpecTypes
 * JD-Core Version:    0.7.0.1
 */