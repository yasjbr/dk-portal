package ps.edu.diyar.admission.database;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RegSchool
  implements Serializable
{
  private String schoolNo;
  private String schoolAName;
  private String schoolLName;
  private String userId;
  private Date timeStamp;
  private String isActive;
  private String notes;
  private String countryNo;
  private String governate;
  private String localityNo;
  private String street;
  
  public RegSchool(String schoolNo, String schoolAName, String schoolLName, String userId, Date timeStamp, String isActive, String notes, String countryNo, String governate, String localityNo, String street)
  {
    this.schoolNo = schoolNo;
    this.schoolAName = schoolAName;
    this.schoolLName = schoolLName;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
    this.notes = notes;
    this.countryNo = countryNo;
    this.governate = governate;
    this.localityNo = localityNo;
    this.street = street;
  }
  
  public RegSchool() {}
  
  public RegSchool(String schoolNo, String schoolAName, String userId, Date timeStamp, String isActive, String countryNo, String governate, String localityNo)
  {
    this.schoolNo = schoolNo;
    this.schoolAName = schoolAName;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
    this.countryNo = countryNo;
    this.governate = governate;
    this.localityNo = localityNo;
  }
  
  public String getSchoolNo()
  {
    return this.schoolNo;
  }
  
  public void setSchoolNo(String schoolNo)
  {
    this.schoolNo = schoolNo;
  }
  
  public String getSchoolAName()
  {
    return this.schoolAName;
  }
  
  public void setSchoolAName(String schoolAName)
  {
    this.schoolAName = schoolAName;
  }
  
  public String getSchoolLName()
  {
    return this.schoolLName;
  }
  
  public void setSchoolLName(String schoolLName)
  {
    this.schoolLName = schoolLName;
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
  
  public String getCountryNo()
  {
    return this.countryNo;
  }
  
  public void setCountryNo(String countryNo)
  {
    this.countryNo = countryNo;
  }
  
  public String getGovernate()
  {
    return this.governate;
  }
  
  public void setGovernate(String governate)
  {
    this.governate = governate;
  }
  
  public String getLocalityNo()
  {
    return this.localityNo;
  }
  
  public void setLocalityNo(String localityNo)
  {
    this.localityNo = localityNo;
  }
  
  public String getStreet()
  {
    return this.street;
  }
  
  public void setStreet(String street)
  {
    this.street = street;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("schoolNo", getSchoolNo()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof RegSchool)) {
      return false;
    }
    RegSchool castOther = (RegSchool)other;
    return new EqualsBuilder().append(getSchoolNo(), castOther.getSchoolNo()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getSchoolNo()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.admission.database.RegSchool
 * JD-Core Version:    0.7.0.1
 */