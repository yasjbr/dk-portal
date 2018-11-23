package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RegHealthStatu
  implements Serializable
{
  private String statusNo;
  private String statusAName;
  private String statusLName;
  private String userId;
  private Date timeStamp;
  private String isActive;
  private String notes;
  private Set regEmployes;
  private Set regStudInfos;
  private Set prtlAdmApplications;
  
  public RegHealthStatu(String statusNo, String statusAName, String statusLName, String userId, Date timeStamp, String isActive, String notes, Set regEmployes, Set regStudInfos, Set prtlAdmApplications)
  {
    this.statusNo = statusNo;
    this.statusAName = statusAName;
    this.statusLName = statusLName;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
    this.notes = notes;
    this.regEmployes = regEmployes;
    this.regStudInfos = regStudInfos;
    this.prtlAdmApplications = prtlAdmApplications;
  }
  
  public RegHealthStatu() {}
  
  public RegHealthStatu(String statusNo, String statusAName, String userId, Date timeStamp, String isActive, Set regEmployes, Set regStudInfos, Set prtlAdmApplications)
  {
    this.statusNo = statusNo;
    this.statusAName = statusAName;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
    this.regEmployes = regEmployes;
    this.regStudInfos = regStudInfos;
    this.prtlAdmApplications = prtlAdmApplications;
  }
  
  public String getStatusNo()
  {
    return this.statusNo;
  }
  
  public void setStatusNo(String statusNo)
  {
    this.statusNo = statusNo;
  }
  
  public String getStatusAName()
  {
    return this.statusAName;
  }
  
  public void setStatusAName(String statusAName)
  {
    this.statusAName = statusAName;
  }
  
  public String getStatusLName()
  {
    return this.statusLName;
  }
  
  public void setStatusLName(String statusLName)
  {
    this.statusLName = statusLName;
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
  
  public Set getRegEmployes()
  {
    return this.regEmployes;
  }
  
  public void setRegEmployes(Set regEmployes)
  {
    this.regEmployes = regEmployes;
  }
  
  public Set getRegStudInfos()
  {
    return this.regStudInfos;
  }
  
  public void setRegStudInfos(Set regStudInfos)
  {
    this.regStudInfos = regStudInfos;
  }
  
  public Set getPrtlAdmApplications()
  {
    return this.prtlAdmApplications;
  }
  
  public void setPrtlAdmApplications(Set prtlAdmApplications)
  {
    this.prtlAdmApplications = prtlAdmApplications;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("statusNo", getStatusNo()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof RegHealthStatu)) {
      return false;
    }
    RegHealthStatu castOther = (RegHealthStatu)other;
    return new EqualsBuilder().append(getStatusNo(), castOther.getStatusNo()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getStatusNo()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.RegHealthStatu
 * JD-Core Version:    0.7.0.1
 */