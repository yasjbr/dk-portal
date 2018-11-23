package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RegAcademicRank
  implements Serializable
{
  private String rankNo;
  private String rankAName;
  private String rankLName;
  private String userId;
  private Date timeStamp;
  private String isActive;
  private String notes;
  private Set regEmployes;
  
  public RegAcademicRank(String rankNo, String rankAName, String rankLName, String userId, Date timeStamp, String isActive, String notes, Set regEmployes)
  {
    this.rankNo = rankNo;
    this.rankAName = rankAName;
    this.rankLName = rankLName;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
    this.notes = notes;
    this.regEmployes = regEmployes;
  }
  
  public RegAcademicRank() {}
  
  public RegAcademicRank(String rankNo, String rankAName, String userId, Date timeStamp, String isActive, Set regEmployes)
  {
    this.rankNo = rankNo;
    this.rankAName = rankAName;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
    this.regEmployes = regEmployes;
  }
  
  public String getRankNo()
  {
    return this.rankNo;
  }
  
  public void setRankNo(String rankNo)
  {
    this.rankNo = rankNo;
  }
  
  public String getRankAName()
  {
    return this.rankAName;
  }
  
  public void setRankAName(String rankAName)
  {
    this.rankAName = rankAName;
  }
  
  public String getRankLName()
  {
    return this.rankLName;
  }
  
  public void setRankLName(String rankLName)
  {
    this.rankLName = rankLName;
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
  
  public Set getRegEmployes()
  {
    return this.regEmployes;
  }
  
  public void setRegEmployes(Set regEmployes)
  {
    this.regEmployes = regEmployes;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("rankNo", getRankNo()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof RegAcademicRank)) {
      return false;
    }
    RegAcademicRank castOther = (RegAcademicRank)other;
    return new EqualsBuilder().append(getRankNo(), castOther.getRankNo()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getRankNo()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.RegAcademicRank
 * JD-Core Version:    0.7.0.1
 */