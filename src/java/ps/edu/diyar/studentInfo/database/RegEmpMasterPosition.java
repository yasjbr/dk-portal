package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RegEmpMasterPosition
  implements Serializable
{
  private String masterPosNo;
  private String mPosAName;
  private String mPosLName;
  private String userId;
  private Date timeStamp;
  private String isActive;
  private String notes;
  private Set regEmpPositions;
  
  public RegEmpMasterPosition(String masterPosNo, String mPosAName, String mPosLName, String userId, Date timeStamp, String isActive, String notes, Set regEmpPositions)
  {
    this.masterPosNo = masterPosNo;
    this.mPosAName = mPosAName;
    this.mPosLName = mPosLName;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
    this.notes = notes;
    this.regEmpPositions = regEmpPositions;
  }
  
  public RegEmpMasterPosition() {}
  
  public RegEmpMasterPosition(String masterPosNo, String mPosAName, String userId, Date timeStamp, String isActive, Set regEmpPositions)
  {
    this.masterPosNo = masterPosNo;
    this.mPosAName = mPosAName;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
    this.regEmpPositions = regEmpPositions;
  }
  
  public String getMasterPosNo()
  {
    return this.masterPosNo;
  }
  
  public void setMasterPosNo(String masterPosNo)
  {
    this.masterPosNo = masterPosNo;
  }
  
  public String getPosAName()
  {
    return this.mPosAName;
  }
  
  public void setPosAName(String mPosAName)
  {
    this.mPosAName = mPosAName;
  }
  
  public String getPosLName()
  {
    return this.mPosLName;
  }
  
  public void setPosLName(String mPosLName)
  {
    this.mPosLName = mPosLName;
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
  
  public Set getRegEmpPositions()
  {
    return this.regEmpPositions;
  }
  
  public void setRegEmpPositions(Set regEmpPositions)
  {
    this.regEmpPositions = regEmpPositions;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("masterPosNo", getMasterPosNo()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof RegEmpMasterPosition)) {
      return false;
    }
    RegEmpMasterPosition castOther = (RegEmpMasterPosition)other;
    return new EqualsBuilder().append(getMasterPosNo(), castOther.getMasterPosNo()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getMasterPosNo()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.RegEmpMasterPosition
 * JD-Core Version:    0.7.0.1
 */