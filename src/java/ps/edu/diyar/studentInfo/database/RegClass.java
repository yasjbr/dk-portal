package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RegClass
  implements Serializable
{
  private RegClassPK comp_id;
  private String classOpened;
  private Short classMaxNo;
  private Integer classMinNo;
  private Short classReg;
  private String userId;
  private Date timeStamp;
  private String isActive;
  private String notes;
  private String classIsSpecial;
  private String tutorNo;
  
  public RegClass(RegClassPK comp_id, String classOpened, Short classMaxNo, Integer classMinNo, Short classReg, String userId, Date timeStamp, String isActive, String notes, String classIsSpecial)
  {
    this.comp_id = comp_id;
    this.classOpened = classOpened;
    this.classMaxNo = classMaxNo;
    this.classMinNo = classMinNo;
    this.classReg = classReg;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
    this.notes = notes;
    this.classIsSpecial = classIsSpecial;
  }
  
  public RegClass() {}
  
  public RegClass(RegClassPK comp_id, String userId, Date timeStamp, String isActive)
  {
    this.comp_id = comp_id;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
  }
  
  public String getTutorNo()
  {
    return this.tutorNo;
  }
  
  public void setTutorNo(String tutorNo)
  {
    this.tutorNo = tutorNo;
  }
  
  public RegClassPK getComp_id()
  {
    return this.comp_id;
  }
  
  public void setComp_id(RegClassPK comp_id)
  {
    this.comp_id = comp_id;
  }
  
  public String getClassOpened()
  {
    return this.classOpened;
  }
  
  public void setClassOpened(String classOpened)
  {
    this.classOpened = classOpened;
  }
  
  public Short getClassMaxNo()
  {
    return this.classMaxNo;
  }
  
  public void setClassMaxNo(Short classMaxNo)
  {
    this.classMaxNo = classMaxNo;
  }
  
  public Integer getClassMinNo()
  {
    return this.classMinNo;
  }
  
  public void setClassMinNo(Integer classMinNo)
  {
    this.classMinNo = classMinNo;
  }
  
  public Short getClassReg()
  {
    return this.classReg;
  }
  
  public void setClassReg(Short classReg)
  {
    this.classReg = classReg;
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
  
  public String getClassIsSpecial()
  {
    return this.classIsSpecial;
  }
  
  public void setClassIsSpecial(String classIsSpecial)
  {
    this.classIsSpecial = classIsSpecial;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("comp_id", getComp_id()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof RegClass)) {
      return false;
    }
    RegClass castOther = (RegClass)other;
    return new EqualsBuilder().append(getComp_id(), castOther.getComp_id()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getComp_id()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.RegClass
 * JD-Core Version:    0.7.0.1
 */