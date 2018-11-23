package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RegCourseType
  implements Serializable
{
  private String typeNo;
  private String typeAName;
  private String typeLName;
  private String userId;
  private Date timeStamp;
  private String isActive;
  private String notes;
  private Set regCourses;
  
  public RegCourseType(String typeNo, String typeAName, String typeLName, String userId, Date timeStamp, String isActive, String notes, Set regCourses)
  {
    this.typeNo = typeNo;
    this.typeAName = typeAName;
    this.typeLName = typeLName;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
    this.notes = notes;
    this.regCourses = regCourses;
  }
  
  public RegCourseType() {}
  
  public RegCourseType(String typeNo, String typeAName, String userId, Date timeStamp, String isActive, Set regCourses)
  {
    this.typeNo = typeNo;
    this.typeAName = typeAName;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
    this.regCourses = regCourses;
  }
  
  public String getTypeNo()
  {
    return this.typeNo;
  }
  
  public void setTypeNo(String typeNo)
  {
    this.typeNo = typeNo;
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
  
  public Set getRegCourses()
  {
    return this.regCourses;
  }
  
  public void setRegCourses(Set regCourses)
  {
    this.regCourses = regCourses;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("typeNo", getTypeNo()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof RegCourseType)) {
      return false;
    }
    RegCourseType castOther = (RegCourseType)other;
    return new EqualsBuilder().append(getTypeNo(), castOther.getTypeNo()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getTypeNo()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.RegCourseType
 * JD-Core Version:    0.7.0.1
 */