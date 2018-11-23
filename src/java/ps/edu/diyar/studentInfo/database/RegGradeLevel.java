package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RegGradeLevel
  implements Serializable
{
  private String sequence;
  private BigDecimal minGrade;
  private BigDecimal maxGrade;
  private String gradeLevelAName;
  private String gradeLevelLName;
  private String userId;
  private Date timeStamp;
  private String isActive;
  private String notes;
  
  public RegGradeLevel(String sequence, BigDecimal minGrade, BigDecimal maxGrade, String gradeLevelAName, String gradeLevelLName, String userId, Date timeStamp, String isActive, String notes)
  {
    this.sequence = sequence;
    this.minGrade = minGrade;
    this.maxGrade = maxGrade;
    this.gradeLevelAName = gradeLevelAName;
    this.gradeLevelLName = gradeLevelLName;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
    this.notes = notes;
  }
  
  public RegGradeLevel() {}
  
  public RegGradeLevel(String sequence, BigDecimal minGrade, BigDecimal maxGrade, String gradeLevelAName, String userId, Date timeStamp, String isActive)
  {
    this.sequence = sequence;
    this.minGrade = minGrade;
    this.maxGrade = maxGrade;
    this.gradeLevelAName = gradeLevelAName;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
  }
  
  public String getSequence()
  {
    return this.sequence;
  }
  
  public void setSequence(String sequence)
  {
    this.sequence = sequence;
  }
  
  public BigDecimal getMinGrade()
  {
    return this.minGrade;
  }
  
  public void setMinGrade(BigDecimal minGrade)
  {
    this.minGrade = minGrade;
  }
  
  public BigDecimal getMaxGrade()
  {
    return this.maxGrade;
  }
  
  public void setMaxGrade(BigDecimal maxGrade)
  {
    this.maxGrade = maxGrade;
  }
  
  public String getGradeLevelAName()
  {
    return this.gradeLevelAName;
  }
  
  public void setGradeLevelAName(String gradeLevelAName)
  {
    this.gradeLevelAName = gradeLevelAName;
  }
  
  public String getGradeLevelLName()
  {
    return this.gradeLevelLName;
  }
  
  public void setGradeLevelLName(String gradeLevelLName)
  {
    this.gradeLevelLName = gradeLevelLName;
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
    return new ToStringBuilder(this).append("sequence", getSequence()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof RegGradeLevel)) {
      return false;
    }
    RegGradeLevel castOther = (RegGradeLevel)other;
    return new EqualsBuilder().append(getSequence(), castOther.getSequence()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getSequence()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.RegGradeLevel
 * JD-Core Version:    0.7.0.1
 */