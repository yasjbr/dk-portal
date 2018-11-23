package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RegCourse
  implements Serializable
{
  private String crsNo;
  private String crsAName;
  private String crsLName;
  private Integer crHrs;
  private int crHrsT;
  private int crHrsP;
  private short meetTime;
  private String inGpa;
  private String userId;
  private Date timeStamp;
  private String isActive;
  private String notes;
  private String crsDescA;
  private String crsDescL;
  private RegCourseType regCourseType;
  private Set regCoursePrereqsByCrsNo;
  private Set regCoursePrereqsByPrereqCrsNo;
  private Set regStudInits;
  private Set regCourseWhts;
  private Set regMsDtls;
  private Set regStuds;
  private Set regClasss;
  
  public RegCourse(String crsNo, String crsAName, String crsLName, Integer crHrs, int crHrsT, int crHrsP, short meetTime, String inGpa, String userId, Date timeStamp, String isActive, String notes, String crsDescA, String crsDescL, RegCourseType regCourseType, Set regCoursePrereqsByCrsNo, Set regCoursePrereqsByPrereqCrsNo, Set regStudInits, Set regCourseWhts, Set regMsDtls, Set regStuds, Set regClasss)
  {
    this.crsNo = crsNo;
    this.crsAName = crsAName;
    this.crsLName = crsLName;
    this.crHrs = crHrs;
    this.crHrsT = crHrsT;
    this.crHrsP = crHrsP;
    this.meetTime = meetTime;
    this.inGpa = inGpa;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
    this.notes = notes;
    this.crsDescA = crsDescA;
    this.crsDescL = crsDescL;
    this.regCourseType = regCourseType;
    this.regCoursePrereqsByCrsNo = regCoursePrereqsByCrsNo;
    this.regCoursePrereqsByPrereqCrsNo = regCoursePrereqsByPrereqCrsNo;
    this.regStudInits = regStudInits;
    this.regCourseWhts = regCourseWhts;
    this.regMsDtls = regMsDtls;
    this.regStuds = regStuds;
    this.regClasss = regClasss;
  }
  
  public RegCourse() {}
  
  public RegCourse(String crsNo, String userId, Date timeStamp, String isActive, RegCourseType regCourseType, Set regCoursePrereqsByCrsNo, Set regCoursePrereqsByPrereqCrsNo, Set regStudInits, Set regCourseWhts, Set regMsDtls, Set regStuds, Set regClasss)
  {
    this.crsNo = crsNo;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
    this.regCourseType = regCourseType;
    this.regCoursePrereqsByCrsNo = regCoursePrereqsByCrsNo;
    this.regCoursePrereqsByPrereqCrsNo = regCoursePrereqsByPrereqCrsNo;
    this.regStudInits = regStudInits;
    this.regCourseWhts = regCourseWhts;
    this.regMsDtls = regMsDtls;
    this.regStuds = regStuds;
    this.regClasss = regClasss;
  }
  
  public RegCourse(String crsNo)
  {
    this.crsNo = crsNo;
  }
  
  public String getCrsNo()
  {
    return this.crsNo;
  }
  
  public void setCrsNo(String crsNo)
  {
    this.crsNo = crsNo;
  }
  
  public String getCrsAName()
  {
    return this.crsAName;
  }
  
  public void setCrsAName(String crsAName)
  {
    this.crsAName = crsAName;
  }
  
  public String getCrsLName()
  {
    return this.crsLName;
  }
  
  public void setCrsLName(String crsLName)
  {
    this.crsLName = crsLName;
  }
  
  public Integer getCrHrs()
  {
    return this.crHrs;
  }
  
  public void setCrHrs(Integer crHrs)
  {
    this.crHrs = crHrs;
  }
  
  public int getCrHrsT()
  {
    return this.crHrsT;
  }
  
  public void setCrHrsT(int crHrsT)
  {
    this.crHrsT = crHrsT;
  }
  
  public int getCrHrsP()
  {
    return this.crHrsP;
  }
  
  public void setCrHrsP(int crHrsP)
  {
    this.crHrsP = crHrsP;
  }
  
  public short getMeetTime()
  {
    return this.meetTime;
  }
  
  public void setMeetTime(short meetTime)
  {
    this.meetTime = meetTime;
  }
  
  public String getInGpa()
  {
    return this.inGpa;
  }
  
  public void setInGpa(String inGpa)
  {
    this.inGpa = inGpa;
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
  
  public String getCrsDescA()
  {
    return this.crsDescA;
  }
  
  public void setCrsDescA(String crsDescA)
  {
    this.crsDescA = crsDescA;
  }
  
  public String getCrsDescL()
  {
    return this.crsDescL;
  }
  
  public void setCrsDescL(String crsDescL)
  {
    this.crsDescL = crsDescL;
  }
  
  public RegCourseType getRegCourseType()
  {
    return this.regCourseType;
  }
  
  public void setRegCourseType(RegCourseType regCourseType)
  {
    this.regCourseType = regCourseType;
  }
  
  public Set getRegCoursePrereqsByCrsNo()
  {
    return this.regCoursePrereqsByCrsNo;
  }
  
  public void setRegCoursePrereqsByCrsNo(Set regCoursePrereqsByCrsNo)
  {
    this.regCoursePrereqsByCrsNo = regCoursePrereqsByCrsNo;
  }
  
  public Set getRegCoursePrereqsByPrereqCrsNo()
  {
    return this.regCoursePrereqsByPrereqCrsNo;
  }
  
  public void setRegCoursePrereqsByPrereqCrsNo(Set regCoursePrereqsByPrereqCrsNo)
  {
    this.regCoursePrereqsByPrereqCrsNo = regCoursePrereqsByPrereqCrsNo;
  }
  
  public Set getRegStudInits()
  {
    return this.regStudInits;
  }
  
  public void setRegStudInits(Set regStudInits)
  {
    this.regStudInits = regStudInits;
  }
  
  public Set getRegCourseWhts()
  {
    return this.regCourseWhts;
  }
  
  public void setRegCourseWhts(Set regCourseWhts)
  {
    this.regCourseWhts = regCourseWhts;
  }
  
  public Set getRegMsDtls()
  {
    return this.regMsDtls;
  }
  
  public void setRegMsDtls(Set regMsDtls)
  {
    this.regMsDtls = regMsDtls;
  }
  
  public Set getRegStuds()
  {
    return this.regStuds;
  }
  
  public void setRegStuds(Set regStuds)
  {
    this.regStuds = regStuds;
  }
  
  public Set getRegClasss()
  {
    return this.regClasss;
  }
  
  public void setRegClasss(Set regClasss)
  {
    this.regClasss = regClasss;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("crsNo", getCrsNo()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof RegCourse)) {
      return false;
    }
    RegCourse castOther = (RegCourse)other;
    return new EqualsBuilder().append(getCrsNo(), castOther.getCrsNo()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getCrsNo()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.RegCourse
 * JD-Core Version:    0.7.0.1
 */