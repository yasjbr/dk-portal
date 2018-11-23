package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RegCourseWht
  implements Serializable
{
  private RegCourseWhtPK comp_id;
  private short first;
  private short second;
  private short third;
  private short practical;
  private short finalMark;
  private String userId;
  private Date timeStamp;
  private String isActive;
  private String notes;
  
  public RegCourseWht(RegCourseWhtPK comp_id, short first, short second, short third, short practical, short finalMark, String userId, Date timeStamp, String isActive, String notes)
  {
    this.comp_id = comp_id;
    this.first = first;
    this.second = second;
    this.third = third;
    this.practical = practical;
    this.finalMark = finalMark;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
    this.notes = notes;
  }
  
  public RegCourseWht() {}
  
  public RegCourseWht(RegCourseWhtPK comp_id, String userId, Date timeStamp, String isActive)
  {
    this.comp_id = comp_id;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
  }
  
  public RegCourseWhtPK getComp_id()
  {
    return this.comp_id;
  }
  
  public void setComp_id(RegCourseWhtPK comp_id)
  {
    this.comp_id = comp_id;
  }
  
  public short getFirst()
  {
    return this.first;
  }
  
  public void setFirst(short first)
  {
    this.first = first;
  }
  
  public short getSecond()
  {
    return this.second;
  }
  
  public void setSecond(short second)
  {
    this.second = second;
  }
  
  public short getThird()
  {
    return this.third;
  }
  
  public void setThird(short third)
  {
    this.third = third;
  }
  
  public short getPractical()
  {
    return this.practical;
  }
  
  public void setPractical(short practical)
  {
    this.practical = practical;
  }
  
  public short getFinalMark()
  {
    return this.finalMark;
  }
  
  public void setFinalMark(short finalMark)
  {
    this.finalMark = finalMark;
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
    if (!(other instanceof RegCourseWht)) {
      return false;
    }
    RegCourseWht castOther = (RegCourseWht)other;
    return new EqualsBuilder().append(getComp_id(), castOther.getComp_id()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getComp_id()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.RegCourseWht
 * JD-Core Version:    0.7.0.1
 */