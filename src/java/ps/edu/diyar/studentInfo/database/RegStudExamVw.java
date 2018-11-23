package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import java.util.Date;
import ps.edu.diyar.common.tools.SecondsToHoursTimeConvertor;

public class RegStudExamVw
  implements Serializable
{
  private RegStudExamVwPK comp_id;
  private String crsAName;
  private String roomNo;
  private String classNo;
  private Integer sessionDay;
  private String sDay;
  private Integer sessionNo;
  private String name;
  private Date sessionDate;
  private Integer begTime;
  private Integer endTime;
  private String tutorNo;
  
  public RegStudExamVwPK getComp_id()
  {
    return this.comp_id;
  }
  
  public void setComp_id(RegStudExamVwPK comp_id)
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
  
  public String getRoomNo()
  {
    return this.roomNo;
  }
  
  public void setRoomNo(String roomNo)
  {
    this.roomNo = roomNo;
  }
  
  public String getClassNo()
  {
    return this.classNo;
  }
  
  public void setClassNo(String classNo)
  {
    this.classNo = classNo;
  }
  
  public Integer getSessionDay()
  {
    return this.sessionDay;
  }
  
  public void setSessionDay(Integer sessionDay)
  {
    this.sessionDay = sessionDay;
  }
  
  public String getsDay()
  {
    return this.sDay;
  }
  
  public void setsDay(String sDay)
  {
    this.sDay = sDay;
  }
  
  public Integer getSessionNo()
  {
    return this.sessionNo;
  }
  
  public void setSessionNo(Integer sessionNo)
  {
    this.sessionNo = sessionNo;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public void setName(String name)
  {
    this.name = name;
  }
  
  public Date getSessionDate()
  {
    return this.sessionDate;
  }
  
  public void setSessionDate(Date sessionDate)
  {
    this.sessionDate = sessionDate;
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
  
  public String getTutorNo()
  {
    return this.tutorNo;
  }
  
  public void setTutorNo(String tutorNo)
  {
    this.tutorNo = tutorNo;
  }
  
  public String getEndTimeFormatted()
  {
    return SecondsToHoursTimeConvertor.timeFormatConvertor(String.valueOf(this.endTime));
  }
  
  public String getBegTimeFormatted()
  {
    return SecondsToHoursTimeConvertor.timeFormatConvertor(String.valueOf(this.begTime));
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.RegStudExamVw
 * JD-Core Version:    0.7.0.1
 */