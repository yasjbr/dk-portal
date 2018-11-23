package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RegMsNo
  implements Serializable
{
  private String msNo;
  private String userId;
  private Date timeStamp;
  private String isActive;
  private String notes;
  
  public RegMsNo(String msNo, String userId, Date timeStamp, String isActive, String notes)
  {
    this.msNo = msNo;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
    this.notes = notes;
  }
  
  public RegMsNo() {}
  
  public RegMsNo(String msNo, String userId, Date timeStamp, String isActive)
  {
    this.msNo = msNo;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
  }
  
  public String getMsNo()
  {
    return this.msNo;
  }
  
  public void setMsNo(String msNo)
  {
    this.msNo = msNo;
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
    return new ToStringBuilder(this).append("msNo", getMsNo()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof RegMsNo)) {
      return false;
    }
    RegMsNo castOther = (RegMsNo)other;
    return new EqualsBuilder().append(getMsNo(), castOther.getMsNo()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getMsNo()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.RegMsNo
 * JD-Core Version:    0.7.0.1
 */