package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;

public class PrtlStudScheduleVw
  implements Serializable
{
  private PrtlStudScheduleVwPK comp_id;
  private Short classReg;
  private String crsAName;
  private Integer crHrs;
  private Integer begTime;
  private Integer endTime;
  private String roomNo;
  private String dayNo;
  private String dayAName;
  
  public String getDayNo()
  {
    return this.dayNo;
  }
  
  public void setDayNo(String dayNo)
  {
    this.dayNo = dayNo;
  }
  
  public String getDayAName()
  {
    return this.dayAName;
  }
  
  public void setDayAName(String dayAName)
  {
    this.dayAName = dayAName;
  }
  
  public PrtlStudScheduleVwPK getComp_id()
  {
    return this.comp_id;
  }
  
  public void setComp_id(PrtlStudScheduleVwPK comp_id)
  {
    this.comp_id = comp_id;
  }
  
  public Short getClassReg()
  {
    return this.classReg;
  }
  
  public void setClassReg(Short classReg)
  {
    this.classReg = classReg;
  }
  
  public String getCrsAName()
  {
    return this.crsAName;
  }
  
  public void setCrsAName(String crsAName)
  {
    this.crsAName = crsAName;
  }
  
  public Integer getCrHrs()
  {
    return this.crHrs;
  }
  
  public void setCrHrs(Integer crHrs)
  {
    this.crHrs = crHrs;
  }
  
  public Integer getBegTime()
  {
    return this.begTime;
  }
  
  public void setBegTime(Integer begTime)
  {
    this.begTime = begTime;
  }
  
  public Integer getEndTime()
  {
    return this.endTime;
  }
  
  public void setEndTime(Integer endTime)
  {
    this.endTime = endTime;
  }
  
  public String getRoomNo()
  {
    return this.roomNo;
  }
  
  public void setRoomNo(String roomNo)
  {
    this.roomNo = roomNo;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.PrtlStudScheduleVw
 * JD-Core Version:    0.7.0.1
 */