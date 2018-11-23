package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RegEmpJobTyp
  implements Serializable
{
  private String jobTypeNo;
  private String typeAName;
  private String typeLName;
  private String userId;
  private Date timeStamp;
  private String isActive;
  private String notes;
  private Set regEmployes;
  
  public RegEmpJobTyp(String jobTypeNo, String typeAName, String typeLName, String userId, Date timeStamp, String isActive, String notes, Set regEmployes)
  {
    this.jobTypeNo = jobTypeNo;
    this.typeAName = typeAName;
    this.typeLName = typeLName;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
    this.notes = notes;
    this.regEmployes = regEmployes;
  }
  
  public RegEmpJobTyp() {}
  
  public RegEmpJobTyp(String jobTypeNo, String typeAName, String userId, Date timeStamp, String isActive, Set regEmployes)
  {
    this.jobTypeNo = jobTypeNo;
    this.typeAName = typeAName;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
    this.regEmployes = regEmployes;
  }
  
  public String getJobTypeNo()
  {
    return this.jobTypeNo;
  }
  
  public void setJobTypeNo(String jobTypeNo)
  {
    this.jobTypeNo = jobTypeNo;
  }
  
  public String getTypeAName()
  {
    return this.typeAName;
  }
  
  public void setTypeAName(String typeAName)
  {
    this.typeAName = typeAName;
  }
  
  public String getTypeLName()
  {
    return this.typeLName;
  }
  
  public void setTypeLName(String typeLName)
  {
    this.typeLName = typeLName;
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
  
  public String toString()
  {
    return new ToStringBuilder(this).append("jobTypeNo", getJobTypeNo()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof RegEmpJobTyp)) {
      return false;
    }
    RegEmpJobTyp castOther = (RegEmpJobTyp)other;
    return new EqualsBuilder().append(getJobTypeNo(), castOther.getJobTypeNo()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getJobTypeNo()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.RegEmpJobTyp
 * JD-Core Version:    0.7.0.1
 */