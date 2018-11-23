package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RegStud
  implements Serializable
{
  private RegStudPK comp_id;
  private Short crsHrs;
  private String msCrsType;
  private String first;
  private String second;
  private String mid;
  private String practical;
  private String finalm;
  private String crsMark;
  private BigDecimal crsPoints;
  private String crsStatus;
  private String crsLevel;
  private String inGpa;
  private String repeated;
  private String crsClass;
  private Integer crsFees;
  private String userId;
  private Date timeStamp;
  private String isActive;
  private String notes;
  private RegCourseStatus regCourseStatus;
  private RegCourse regCourse;
  
  public RegStud(RegStudPK comp_id, Short crsHrs, String msCrsType, String crsMark, String first,String second,String finalm,String practical,String mid,BigDecimal crsPoints, String crsStatus, String crsLevel, String inGpa, String repeated, String crsClass, Integer crsFees, String userId, Date timeStamp, String isActive, String notes)
  {
    this.comp_id = comp_id;
    this.crsHrs = crsHrs;
    this.msCrsType = msCrsType;
    this.crsMark = crsMark;
     this.first = first;
      this.second = second;
       this.mid = mid;
        this.finalm = finalm;
         this.practical = practical;
    this.crsPoints = crsPoints;
    this.crsStatus = crsStatus;
    this.crsLevel = crsLevel;
    this.inGpa = inGpa;
    this.repeated = repeated;
    this.crsClass = crsClass;
    this.crsFees = crsFees;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
    this.notes = notes;
  }
  
  public RegStud() {}
  
  public RegStud(RegStudPK comp_id, Short crsHrs, String inGpa, String userId, Date timeStamp, String isActive)
  {
    this.comp_id = comp_id;
    this.crsHrs = crsHrs;
    this.inGpa = inGpa;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
  }
  
  public RegStudPK getComp_id()
  {
    return this.comp_id;
  }
  
  public void setComp_id(RegStudPK comp_id)
  {
    this.comp_id = comp_id;
  }
  
  public RegCourse getRegCourse()
  {
    return this.regCourse;
  }
  
  public void setRegCourse(RegCourse regCourse)
  {
    this.regCourse = regCourse;
  }
  
  public RegCourseStatus getRegCourseStatus()
  {
    return this.regCourseStatus;
  }
  
  public void setRegCourseStatus(RegCourseStatus regCourseStatus)
  {
    this.regCourseStatus = regCourseStatus;
  }
  
  public Short getCrsHrs()
  {
    return this.crsHrs;
  }
  
  public void setCrsHrs(Short crsHrs)
  {
    this.crsHrs = crsHrs;
  }
  
  public String getMsCrsType()
  {
    return this.msCrsType;
  }
  
  public void setMsCrsType(String msCrsType)
  {
    this.msCrsType = msCrsType;
  }
  
  public String getCrsMark()
  {
    return this.crsMark;
  }
  
  public void setCrsMark(String crsMark)
  {
    this.crsMark = crsMark;
  }
  
  public BigDecimal getCrsPoints()
  {
    return this.crsPoints;
  }
  
  public void setCrsPoints(BigDecimal crsPoints)
  {
    this.crsPoints = crsPoints;
  }
  
  public String getCrsStatus()
  {
    return this.crsStatus;
  }
  
  public void setCrsStatus(String crsStatus)
  {
    this.crsStatus = crsStatus;
  }
  
  public String getCrsLevel()
  {
    return this.crsLevel;
  }
  
  public void setCrsLevel(String crsLevel)
  {
    this.crsLevel = crsLevel;
  }
  
  public String getInGpa()
  {
    return this.inGpa;
  }
  
  public void setInGpa(String inGpa)
  {
    this.inGpa = inGpa;
  }
  
  public String getRepeated()
  {
    return this.repeated;
  }
  
  public void setRepeated(String repeated)
  {
    this.repeated = repeated;
  }
  
  public String getCrsClass()
  {
    return this.crsClass;
  }
  
  public void setCrsClass(String crsClass)
  {
    this.crsClass = crsClass;
  }
  
  public Integer getCrsFees()
  {
    return this.crsFees;
  }
  
  public void setCrsFees(Integer crsFees)
  {
    this.crsFees = crsFees;
  }
  
  public String getUserId()
  {
    return this.userId;
  }
  
  public void setUserId(String userId)
  {
    this.userId = userId;
  }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getPractical() {
        return practical;
    }

    public void setPractical(String practical) {
        this.practical = practical;
    }

    public String getFinalm() {
        return finalm;
    }

    public void setFinalm(String finalm) {
        this.finalm = finalm;
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
    if (!(other instanceof RegStud)) {
      return false;
    }
    RegStud castOther = (RegStud)other;
    return new EqualsBuilder().append(getComp_id(), castOther.getComp_id()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getComp_id()).toHashCode();
  }
}



/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\

 * Qualified Name:     ps.edu.diyar.studentInfo.database.RegStud

 * JD-Core Version:    0.7.0.1

 */