package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RegJobs
  implements Serializable
{
  private String jobNo;
  private String jobAName;
  private String jobLName;
  private String userId;
  private Date timeStamp;
  private String isActive;
  private String notes;
  
  public RegJobs(String jobNo, String jobAName, String jobLName, String userId, Date timeStamp, String isActive, String notes)
  {
    this.jobNo = jobNo;
    this.jobAName = jobAName;
    this.jobLName = jobLName;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
    this.notes = notes;
  }
  
  public RegJobs() {}
  
  public RegJobs(String jobNo, String jobAName, String userId, Date timeStamp, String isActive)
  {
    this.jobNo = jobNo;
    this.jobAName = jobAName;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
  }
  
  public String getJobNo()
  {
    return this.jobNo;
  }
  
  public void setJobNo(String jobNo)
  {
    this.jobNo = jobNo;
  }
  
  public String getJobAName()
  {
    return this.jobAName;
  }
  
  public void setJobAName(String jobAName)
  {
    this.jobAName = jobAName;
  }
  
  public String getJobLName()
  {
    return this.jobLName;
  }
  
  public void setJobLName(String jobLName)
  {
    this.jobLName = jobLName;
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
    return new ToStringBuilder(this).append("jobNo", getJobNo()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof RegJobs)) {
      return false;
    }
    RegJobs castOther = (RegJobs)other;
    return new EqualsBuilder().append(getJobNo(), castOther.getJobNo()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getJobNo()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.RegJobs
 * JD-Core Version:    0.7.0.1
 */