package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RegTerm
  implements Serializable
{
  private String termNo;
  private String termAName;
  private String termLName;
  private String userId;
  private Date timeStamp;
  private String isActive;
  private String notes;
  private String isIntensive;
  
  public RegTerm(String termNo, String termAName, String termLName, String userId, Date timeStamp, String isActive, String notes, String isIntensive)
  {
    this.termNo = termNo;
    this.termAName = termAName;
    this.termLName = termLName;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
    this.notes = notes;
    this.isIntensive = isIntensive;
  }
  
  public RegTerm() {}
  
  public RegTerm(String termNo, String termAName, String userId, Date timeStamp, String isActive, String isIntensive)
  {
    this.termNo = termNo;
    this.termAName = termAName;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
    this.isIntensive = isIntensive;
  }
  
  public String getTermNo()
  {
    return this.termNo;
  }
  
  public void setTermNo(String termNo)
  {
    this.termNo = termNo;
  }
  
  public String getTermAName()
  {
    return this.termAName;
  }
  
  public void setTermAName(String termAName)
  {
    this.termAName = termAName;
  }
  
  public String getTermLName()
  {
    return this.termLName;
  }
  
  public void setTermLName(String termLName)
  {
    this.termLName = termLName;
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
  
  public String getIsIntensive()
  {
    return this.isIntensive;
  }
  
  public void setIsIntensive(String isIntensive)
  {
    this.isIntensive = isIntensive;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("termNo", getTermNo()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof RegTerm)) {
      return false;
    }
    RegTerm castOther = (RegTerm)other;
    return new EqualsBuilder().append(getTermNo(), castOther.getTermNo()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getTermNo()).toHashCode();
  }
}



/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\

 * Qualified Name:     ps.edu.diyar.studentInfo.database.RegTerm

 * JD-Core Version:    0.7.0.1

 */

  