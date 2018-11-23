package ps.edu.diyar.admission.database;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RegTawBranch
  implements Serializable
{
  private String tawBranchNo;
  private String tawBranchAName;
  private String tawBranchLName;
  private String userId;
  private Date timeStamp;
  private String isActive;
  private String notes;
  
  public RegTawBranch(String tawBranchNo, String tawBranchAName, String tawBranchLName, String userId, Date timeStamp, String isActive, String notes)
  {
    this.tawBranchNo = tawBranchNo;
    this.tawBranchAName = tawBranchAName;
    this.tawBranchLName = tawBranchLName;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
    this.notes = notes;
  }
  
  public RegTawBranch() {}
  
  public RegTawBranch(String tawBranchNo, String tawBranchAName, String userId, Date timeStamp, String isActive)
  {
    this.tawBranchNo = tawBranchNo;
    this.tawBranchAName = tawBranchAName;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
  }
  
  public String getTawBranchNo()
  {
    return this.tawBranchNo;
  }
  
  public void setTawBranchNo(String tawBranchNo)
  {
    this.tawBranchNo = tawBranchNo;
  }
  
  public String getTawBranchAName()
  {
    return this.tawBranchAName;
  }
  
  public void setTawBranchAName(String tawBranchAName)
  {
    this.tawBranchAName = tawBranchAName;
  }
  
  public String getTawBranchLName()
  {
    return this.tawBranchLName;
  }
  
  public void setTawBranchLName(String tawBranchLName)
  {
    this.tawBranchLName = tawBranchLName;
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
    return new ToStringBuilder(this).append("tawBranchNo", getTawBranchNo()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof RegTawBranch)) {
      return false;
    }
    RegTawBranch castOther = (RegTawBranch)other;
    return new EqualsBuilder().append(getTawBranchNo(), castOther.getTawBranchNo()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getTawBranchNo()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.admission.database.RegTawBranch
 * JD-Core Version:    0.7.0.1
 */