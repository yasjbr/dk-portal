package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RegCertTypes
  implements Serializable
{
  private String certNo;
  private String certAName;
  private String certLName;
  private String userId;
  private Date timeStamp;
  private String isActive;
  private String notes;
  
  public RegCertTypes(String certNo, String certAName, String certLName, String userId, Date timeStamp, String isActive, String notes)
  {
    this.certNo = certNo;
    this.certAName = certAName;
    this.certLName = certLName;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
    this.notes = notes;
  }
  
  public RegCertTypes() {}
  
  public RegCertTypes(String certNo, String certAName, String userId, Date timeStamp, String isActive)
  {
    this.certNo = certNo;
    this.certAName = certAName;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
  }
  
  public String getCertNo()
  {
    return this.certNo;
  }
  
  public void setCertNo(String certNo)
  {
    this.certNo = certNo;
  }
  
  public String getCertAName()
  {
    return this.certAName;
  }
  
  public void setCertAName(String certAName)
  {
    this.certAName = certAName;
  }
  
  public String getCertLName()
  {
    return this.certLName;
  }
  
  public void setCertLName(String certLName)
  {
    this.certLName = certLName;
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
    return new ToStringBuilder(this).append("certNo", getCertNo()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof RegCertTypes)) {
      return false;
    }
    RegCertTypes castOther = (RegCertTypes)other;
    return new EqualsBuilder().append(getCertNo(), castOther.getCertNo()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getCertNo()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.RegCertTypes
 * JD-Core Version:    0.7.0.1
 */