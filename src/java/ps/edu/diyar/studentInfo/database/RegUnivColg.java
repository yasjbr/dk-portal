package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RegUnivColg
  implements Serializable
{
  private String ucNo;
  private String ucAName;
  private String ucLName;
  private String ucType;
  private String userId;
  private Date timeStamp;
  private String isActive;
  private String notes;
  
  public RegUnivColg(String ucNo, String ucAName, String ucLName, String ucType, String userId, Date timeStamp, String isActive, String notes)
  {
    this.ucNo = ucNo;
    this.ucAName = ucAName;
    this.ucLName = ucLName;
    this.ucType = ucType;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
    this.notes = notes;
  }
  
  public RegUnivColg() {}
  
  public RegUnivColg(String ucNo, String ucAName, String ucType, String userId, Date timeStamp, String isActive)
  {
    this.ucNo = ucNo;
    this.ucAName = ucAName;
    this.ucType = ucType;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
  }
  
  public String getUcNo()
  {
    return this.ucNo;
  }
  
  public void setUcNo(String ucNo)
  {
    this.ucNo = ucNo;
  }
  
  public String getUcAName()
  {
    return this.ucAName;
  }
  
  public void setUcAName(String ucAName)
  {
    this.ucAName = ucAName;
  }
  
  public String getUcLName()
  {
    return this.ucLName;
  }
  
  public void setUcLName(String ucLName)
  {
    this.ucLName = ucLName;
  }
  
  public String getUcType()
  {
    return this.ucType;
  }
  
  public void setUcType(String ucType)
  {
    this.ucType = ucType;
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
    return new ToStringBuilder(this).append("ucNo", getUcNo()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof RegUnivColg)) {
      return false;
    }
    RegUnivColg castOther = (RegUnivColg)other;
    return new EqualsBuilder().append(getUcNo(), castOther.getUcNo()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getUcNo()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.RegUnivColg
 * JD-Core Version:    0.7.0.1
 */