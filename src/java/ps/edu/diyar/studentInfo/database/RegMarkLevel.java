package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RegMarkLevel
  implements Serializable
{
  private String sequence;
  private BigDecimal minMark;
  private BigDecimal maxMark;
  private String markLevelAName;
  private String markLevelLName;
  private String markLevelAbbr;
  private BigDecimal markLevelPoint;
  private String userId;
  private Date timeStamp;
  private String isActive;
  private String notes;
  private String crsStatus;
  
  public RegMarkLevel(String sequence, BigDecimal minMark, BigDecimal maxMark, String markLevelAName, String markLevelLName, String markLevelAbbr, BigDecimal markLevelPoint, String userId, Date timeStamp, String isActive, String notes, String crsStatus)
  {
    this.sequence = sequence;
    this.minMark = minMark;
    this.maxMark = maxMark;
    this.markLevelAName = markLevelAName;
    this.markLevelLName = markLevelLName;
    this.markLevelAbbr = markLevelAbbr;
    this.markLevelPoint = markLevelPoint;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
    this.notes = notes;
    this.crsStatus = crsStatus;
  }
  
  public RegMarkLevel() {}
  
  public RegMarkLevel(String sequence, BigDecimal minMark, BigDecimal maxMark, String markLevelAName, String markLevelAbbr, BigDecimal markLevelPoint, String userId, Date timeStamp, String isActive)
  {
    this.sequence = sequence;
    this.minMark = minMark;
    this.maxMark = maxMark;
    this.markLevelAName = markLevelAName;
    this.markLevelAbbr = markLevelAbbr;
    this.markLevelPoint = markLevelPoint;
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
  
  public BigDecimal getMinMark()
  {
    return this.minMark;
  }
  
  public void setMinMark(BigDecimal minMark)
  {
    this.minMark = minMark;
  }
  
  public BigDecimal getMaxMark()
  {
    return this.maxMark;
  }
  
  public void setMaxMark(BigDecimal maxMark)
  {
    this.maxMark = maxMark;
  }
  
  public String getMarkLevelAName()
  {
    return this.markLevelAName;
  }
  
  public void setMarkLevelAName(String markLevelAName)
  {
    this.markLevelAName = markLevelAName;
  }
  
  public String getMarkLevelLName()
  {
    return this.markLevelLName;
  }
  
  public void setMarkLevelLName(String markLevelLName)
  {
    this.markLevelLName = markLevelLName;
  }
  
  public String getMarkLevelAbbr()
  {
    return this.markLevelAbbr;
  }
  
  public void setMarkLevelAbbr(String markLevelAbbr)
  {
    this.markLevelAbbr = markLevelAbbr;
  }
  
  public BigDecimal getMarkLevelPoint()
  {
    return this.markLevelPoint;
  }
  
  public void setMarkLevelPoint(BigDecimal markLevelPoint)
  {
    this.markLevelPoint = markLevelPoint;
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
  
  public String getCrsStatus()
  {
    return this.crsStatus;
  }
  
  public void setCrsStatus(String crsStatus)
  {
    this.crsStatus = crsStatus;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("sequence", getSequence()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof RegMarkLevel)) {
      return false;
    }
    RegMarkLevel castOther = (RegMarkLevel)other;
    return new EqualsBuilder().append(getSequence(), castOther.getSequence()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getSequence()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.RegMarkLevel
 * JD-Core Version:    0.7.0.1
 */