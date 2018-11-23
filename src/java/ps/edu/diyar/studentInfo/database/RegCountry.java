package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RegCountry
  implements Serializable
{
  private String countryNo;
  private String countryAName;
  private String countryLName;
  private String natAFemaleName;
  private String natAMaleName;
  private String natLName;
  private String userId;
  private Date timeStamp;
  private String isActive;
  private String notes;
  
  public RegCountry(String countryNo, String countryAName, String countryLName, String natAFemaleName, String natAMaleName, String natLName, String userId, Date timeStamp, String isActive, String notes)
  {
    this.countryNo = countryNo;
    this.countryAName = countryAName;
    this.countryLName = countryLName;
    this.natAFemaleName = natAFemaleName;
    this.natAMaleName = natAMaleName;
    this.natLName = natLName;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
    this.notes = notes;
  }
  
  public RegCountry() {}
  
  public RegCountry(String countryNo, String countryAName, String natAFemaleName, String natAMaleName, String userId, Date timeStamp, String isActive)
  {
    this.countryNo = countryNo;
    this.countryAName = countryAName;
    this.natAFemaleName = natAFemaleName;
    this.natAMaleName = natAMaleName;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
  }
  
  public String getCountryNo()
  {
    return this.countryNo;
  }
  
  public void setCountryNo(String countryNo)
  {
    this.countryNo = countryNo;
  }
  
  public String getCountryAName()
  {
    return this.countryAName;
  }
  
  public void setCountryAName(String countryAName)
  {
    this.countryAName = countryAName;
  }
  
  public String getCountryLName()
  {
    return this.countryLName;
  }
  
  public void setCountryLName(String countryLName)
  {
    this.countryLName = countryLName;
  }
  
  public String getNatAFemaleName()
  {
    return this.natAFemaleName;
  }
  
  public void setNatAFemaleName(String natAFemaleName)
  {
    this.natAFemaleName = natAFemaleName;
  }
  
  public String getNatAMaleName()
  {
    return this.natAMaleName;
  }
  
  public void setNatAMaleName(String natAMaleName)
  {
    this.natAMaleName = natAMaleName;
  }
  
  public String getNatLName()
  {
    return this.natLName;
  }
  
  public void setNatLName(String natLName)
  {
    this.natLName = natLName;
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
    return new ToStringBuilder(this).append("countryNo", getCountryNo()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof RegCountry)) {
      return false;
    }
    RegCountry castOther = (RegCountry)other;
    return new EqualsBuilder().append(getCountryNo(), castOther.getCountryNo()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getCountryNo()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.RegCountry
 * JD-Core Version:    0.7.0.1
 */