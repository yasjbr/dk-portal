package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RegSpecDiploma
  implements Serializable
{
  private String specNo;
  private String specAName;
  private String specLName;
  private String userId;
  private Date timeStamp;
  private String isActive;
  private String notes;
  
  public RegSpecDiploma(String specNo, String specAName, String specLName, String userId, Date timeStamp, String isActive, String notes)
  {
    this.specNo = specNo;
    this.specAName = specAName;
    this.specLName = specLName;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
    this.notes = notes;
  }
  
  public RegSpecDiploma() {}
  
  public RegSpecDiploma(String specNo, String specAName, String userId, Date timeStamp, String isActive)
  {
    this.specNo = specNo;
    this.specAName = specAName;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
  }
  
  public String getSpecNo()
  {
    return this.specNo;
  }
  
  public void setSpecNo(String specNo)
  {
    this.specNo = specNo;
  }
  
  public String getSpecAName()
  {
    return this.specAName;
  }
  
  public void setSpecAName(String specAName)
  {
    this.specAName = specAName;
  }
  
  public String getSpecLName()
  {
    return this.specLName;
  }
  
  public void setSpecLName(String specLName)
  {
    this.specLName = specLName;
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
    return new ToStringBuilder(this).append("specNo", getSpecNo()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof RegSpecDiploma)) {
      return false;
    }
    RegSpecDiploma castOther = (RegSpecDiploma)other;
    return new EqualsBuilder().append(getSpecNo(), castOther.getSpecNo()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getSpecNo()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.RegSpecDiploma
 * JD-Core Version:    0.7.0.1
 */