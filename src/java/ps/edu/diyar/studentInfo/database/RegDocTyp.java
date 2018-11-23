package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RegDocTyp
  implements Serializable
{
  private String docNo;
  private String docAName;
  private String docLName;
  private String userId;
  private Date timeStamp;
  private String isActive;
  private String notes;
  private Set regStudInfos;
  private Set prtlAdmApplications;
  
  public RegDocTyp(String docNo, String docAName, String docLName, String userId, Date timeStamp, String isActive, String notes, Set regStudInfos, Set prtlAdmApplications)
  {
    this.docNo = docNo;
    this.docAName = docAName;
    this.docLName = docLName;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
    this.notes = notes;
    this.regStudInfos = regStudInfos;
    this.prtlAdmApplications = prtlAdmApplications;
  }
  
  public RegDocTyp() {}
  
  public RegDocTyp(String docNo, String docAName, String userId, Date timeStamp, String isActive, Set regStudInfos, Set prtlAdmApplications)
  {
    this.docNo = docNo;
    this.docAName = docAName;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
    this.regStudInfos = regStudInfos;
    this.prtlAdmApplications = prtlAdmApplications;
  }
  
  public String getDocNo()
  {
    return this.docNo;
  }
  
  public void setDocNo(String docNo)
  {
    this.docNo = docNo;
  }
  
  public String getDocAName()
  {
    return this.docAName;
  }
  
  public void setDocAName(String docAName)
  {
    this.docAName = docAName;
  }
  
  public String getDocLName()
  {
    return this.docLName;
  }
  
  public void setDocLName(String docLName)
  {
    this.docLName = docLName;
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
    return new ToStringBuilder(this).append("docNo", getDocNo()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof RegDocTyp)) {
      return false;
    }
    RegDocTyp castOther = (RegDocTyp)other;
    return new EqualsBuilder().append(getDocNo(), castOther.getDocNo()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getDocNo()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.RegDocTyp
 * JD-Core Version:    0.7.0.1
 */