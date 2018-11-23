package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RegTutorOfficeHourPK
  implements Serializable
{
  private String tutorNo;
  private String termNo;
  private Integer dayNo;
  private int begTime;
  
  public RegTutorOfficeHourPK(String tutorNo, String termNo, Integer dayNo, int begTime)
  {
    this.tutorNo = tutorNo;
    this.termNo = termNo;
    this.dayNo = dayNo;
    this.begTime = begTime;
  }
  
  public RegTutorOfficeHourPK() {}
  
  public String getTutorNo()
  {
    return this.tutorNo;
  }
  
  public void setTutorNo(String tutorNo)
  {
    this.tutorNo = tutorNo;
  }
  
  public String getTermNo()
  {
    return this.termNo;
  }
  
  public void setTermNo(String termNo)
  {
    this.termNo = termNo;
  }
  
  public Integer getDayNo()
  {
    return this.dayNo;
  }
  
  public void setDayNo(Integer dayNo)
  {
    this.dayNo = dayNo;
  }
  
  public int getBegTime()
  {
    return this.begTime;
  }
  
  public void setBegTime(int begTime)
  {
    this.begTime = begTime;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("tutorNo", getTutorNo()).append("termNo", getTermNo()).append("dayNo", getDayNo()).append("begTime", getBegTime()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof RegTutorOfficeHourPK)) {
      return false;
    }
    RegTutorOfficeHourPK castOther = (RegTutorOfficeHourPK)other;
    return new EqualsBuilder().append(getTutorNo(), castOther.getTutorNo()).append(getTermNo(), castOther.getTermNo()).append(getDayNo(), castOther.getDayNo()).append(getBegTime(), castOther.getBegTime()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getTutorNo()).append(getTermNo()).append(getDayNo()).append(getBegTime()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.RegTutorOfficeHourPK
 * JD-Core Version:    0.7.0.1
 */