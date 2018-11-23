package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;

public class PrtlStudRegisteredCrsVw
  implements Serializable
{
  private PrtlStudRegisteredCrsVwPK comp_id;
  private String crsAName;
  private Integer begTime;
  private Integer endTime;
  private String dayNo;
  private String dayAName;
  private String empNo;
  private String crHrs;
  private String tutorAName;
  
  public PrtlStudRegisteredCrsVw() {}
  
  public PrtlStudRegisteredCrsVw(String crsAName, Integer begTime, Integer endTime, String dayNo, String dayAName, String empNo, String tutorAName)
  {
    this.crsAName = crsAName;
    this.begTime = begTime;
    this.endTime = endTime;
    this.dayNo = dayNo;
    this.dayAName = dayAName;
    this.empNo = empNo;
    this.tutorAName = tutorAName;
  }
  
  public PrtlStudRegisteredCrsVwPK getComp_id()
  {
    return this.comp_id;
  }
  
  public void setComp_id(PrtlStudRegisteredCrsVwPK comp_id)
  {
    this.comp_id = comp_id;
  }
  
  public String getCrsAName()
  {
    return this.crsAName;
  }
  
  public void setCrsAName(String crsAName)
  {
    this.crsAName = crsAName;
  }
  
  public String getCrHrs()
  {
    return this.crHrs;
  }
  
  public void setCrHrs(String crHrs)
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
  
  public String getEmpNo()
  {
    return this.empNo;
  }
  
  public void setEmpNo(String empNo)
  {
    this.empNo = empNo;
  }
  
  public String getTutorAName()
  {
    return this.tutorAName;
  }
  
  public void setTutorAName(String tutorAName)
  {
    this.tutorAName = tutorAName;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.PrtlStudRegisteredCrsVw
 * JD-Core Version:    0.7.0.1
 */