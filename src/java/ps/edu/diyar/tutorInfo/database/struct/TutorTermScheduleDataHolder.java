package ps.edu.diyar.tutorInfo.database.struct;

import ps.edu.diyar.common.tools.SecondsToHoursTimeConvertor;

public class TutorTermScheduleDataHolder
{
  private String courseNo;
  private String courseName;
  private String classNo;
  private String dayName;
  private Integer beginTime;
  private Integer endTime;
  private String roomName;
  private String tutorName;
  private Integer courseHours;
  private Short classReg;
  private String termNo;
  
  public TutorTermScheduleDataHolder() {}
  
  public TutorTermScheduleDataHolder(String courseNo, String courseName, String classNo, Integer courseHours, Short classReg, String termNo)
  {
    this.courseNo = courseNo;
    this.courseName = courseName;
    this.classNo = classNo;
    this.courseHours = courseHours;
    this.classReg = classReg;
    this.termNo = termNo;
  }
  
  public TutorTermScheduleDataHolder(String courseNo, String courseName, String classNo, String dayName, Integer beginTime, Integer endTime, String roomName, Integer courseHours, Short classReg, String termNo)
  {
    this.courseNo = courseNo;
    this.courseName = courseName;
    this.classNo = classNo;
    this.dayName = dayName;
    this.beginTime = beginTime;
    this.endTime = endTime;
    this.roomName = roomName;
    this.courseHours = courseHours;
    this.classReg = classReg;
    this.termNo = termNo;
  }
  
  public TutorTermScheduleDataHolder(String crsNo, String crsAName, String termNo, String classNo)
  {
    this.courseNo = crsNo;
    this.courseName = crsAName;
    this.termNo = termNo;
    this.classNo = classNo;
  }
  
  public String getCourseNo()
  {
    return this.courseNo;
  }
  
  public void setCourseNo(String courseNo)
  {
    this.courseNo = courseNo;
  }
  
  public void setCourseName(String courseName)
  {
    this.courseName = courseName;
  }
  
  public String getCourseName()
  {
    return this.courseName;
  }
  
  public void setClassNo(String classNo)
  {
    this.classNo = classNo;
  }
  
  public String getClassNo()
  {
    return this.classNo;
  }
  
  public void setDayName(String dayName)
  {
    this.dayName = dayName;
  }
  
  public String getDayName()
  {
    return this.dayName;
  }
  
  public void setBeginTime(Integer beginTime)
  {
    this.beginTime = beginTime;
  }
  
  public String getBeginTime()
  {
    return SecondsToHoursTimeConvertor.timeFormatConvertor(String.valueOf(this.beginTime));
  }
  
  public void setEndTime(Integer endTime)
  {
    this.endTime = endTime;
  }
  
  public String getEndTime()
  {
    return SecondsToHoursTimeConvertor.timeFormatConvertor(String.valueOf(this.endTime));
  }
  
  public void setRoomName(String roomName)
  {
    this.roomName = roomName;
  }
  
  public String getRoomName()
  {
    return this.roomName;
  }
  
  public void setTutorName(String tutorName)
  {
    this.tutorName = tutorName;
  }
  
  public String getTutorName()
  {
    return this.tutorName;
  }
  
  public void setCourseHours(Integer courseHours)
  {
    this.courseHours = courseHours;
  }
  
  public Integer getCourseHours()
  {
    return this.courseHours;
  }
  
  public Short getClassReg()
  {
    return this.classReg;
  }
  
  public void setClassReg(Short classReg)
  {
    this.classReg = classReg;
  }
  
  public String getTermNo()
  {
    return this.termNo;
  }
  
  public void setTermNo(String termNo)
  {
    this.termNo = termNo;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.tutorInfo.database.struct.TutorTermScheduleDataHolder
 * JD-Core Version:    0.7.0.1
 */