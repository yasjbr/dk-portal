package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RegCollege
  implements Serializable
{
  private String collegeNo;
  private String collegeAName;
  private String collegeLName;
  private String userId;
  private Date timeStamp;
  private String isActive;
  private String notes;
  
  public RegCollege(String collegeNo, String collegeAName, String collegeLName, String userId, Date timeStamp, String isActive, String notes)
  {
    this.collegeNo = collegeNo;
    this.collegeAName = collegeAName;
    this.collegeLName = collegeLName;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
    this.notes = notes;
  }
  
  public RegCollege() {}
  
  public RegCollege(String collegeNo, String collegeAName, String userId, Date timeStamp, String isActive)
  {
    this.collegeNo = collegeNo;
    this.collegeAName = collegeAName;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
  }
  
  public String getCollegeNo()
  {
    return this.collegeNo;
  }
  
  public void setCollegeNo(String collegeNo)
  {
    this.collegeNo = collegeNo;
  }
  
  public String getCollegeAName()
  {
    return this.collegeAName;
  }
  
  public void setCollegeAName(String collegeAName)
  {
    this.collegeAName = collegeAName;
  }
  
  public String getCollegeLName()
  {
    return this.collegeLName;
  }
  
  public void setCollegeLName(String collegeLName)
  {
    this.collegeLName = collegeLName;
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
    return new ToStringBuilder(this).append("collegeNo", getCollegeNo()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof RegCollege)) {
      return false;
    }
    RegCollege castOther = (RegCollege)other;
    return new EqualsBuilder().append(getCollegeNo(), castOther.getCollegeNo()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getCollegeNo()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.RegCollege
 * JD-Core Version:    0.7.0.1
 */