package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RegDept
  implements Serializable
{
  private RegDeptPK comp_id;
  private String deptAName;
  private String deptLName;
  private String userId;
  private Date timeStamp;
  private String isActive;
  private String notes;
  
  public RegDept(RegDeptPK comp_id, String deptAName, String deptLName, String userId, Date timeStamp, String isActive, String notes)
  {
    this.comp_id = comp_id;
    this.deptAName = deptAName;
    this.deptLName = deptLName;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
    this.notes = notes;
  }
  
  public RegDept() {}
  
  public RegDept(RegDeptPK comp_id, String deptAName, String userId, Date timeStamp, String isActive)
  {
    this.comp_id = comp_id;
    this.deptAName = deptAName;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
  }
  
  public RegDeptPK getComp_id()
  {
    return this.comp_id;
  }
  
  public void setComp_id(RegDeptPK comp_id)
  {
    this.comp_id = comp_id;
  }
  
  public String getDeptAName()
  {
    return this.deptAName;
  }
  
  public void setDeptAName(String deptAName)
  {
    this.deptAName = deptAName;
  }
  
  public String getDeptLName()
  {
    return this.deptLName;
  }
  
  public void setDeptLName(String deptLName)
  {
    this.deptLName = deptLName;
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
    return new ToStringBuilder(this).append("comp_id", getComp_id()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof RegDept)) {
      return false;
    }
    RegDept castOther = (RegDept)other;
    return new EqualsBuilder().append(getComp_id(), castOther.getComp_id()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getComp_id()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.RegDept
 * JD-Core Version:    0.7.0.1
 */