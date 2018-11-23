package ps.edu.diyar.studentInfo.database.struct;

import ps.edu.diyar.common.tools.TimeConvertor;

public class MsCoursesList
{
  private String msCrsType;
  private String mscrsTypeName;
  private String crsNo;
  private String crsName;
  private String crsHrs;
  private Integer crsMark;
  private String crsStatus;
  private String crsStatusAName;
  private String termNo;
  private String classNo;
  private Integer begTime;
  private Integer endTime;
  private String dayAName;
  private String dayNo;
  private String tutorNo;
  private String tutorAName;
  private String begEndTime;
  private String studId;
  
  public MsCoursesList() {}
  
  public MsCoursesList(String msCrsType, String mscrsTypeName, String crsNo, String crsName, Integer crsHrs, Integer crsMark, String crsStatus, String crsStatusAName, String termNo)
  {
    this.msCrsType = msCrsType;
    this.mscrsTypeName = mscrsTypeName;
    this.crsNo = crsNo;
    this.crsName = crsName;
    this.crsHrs = String.valueOf(crsHrs);
    this.crsMark = crsMark;
    this.crsStatus = crsStatus;
    this.crsStatusAName = crsStatusAName;
    this.termNo = termNo;
  }
  
  public MsCoursesList(String msCrsType, String mscrsTypeName, String crsNo, String crsName, Integer crsHrs, String crsMark, String crsStatus, String crsStatusAName, String termNo)
  {
    this.msCrsType = msCrsType;
    this.mscrsTypeName = mscrsTypeName;
    this.crsNo = crsNo;
    this.crsName = crsName;
    this.crsHrs = String.valueOf(crsHrs);
    if (crsMark != null) {
      this.crsMark = Integer.valueOf(Integer.parseInt(crsMark));
    }
    this.crsStatus = crsStatus;
    this.crsStatusAName = crsStatusAName;
    this.termNo = termNo;
  }
  
  public MsCoursesList(String msCrsType, String mscrsTypeName, String crsNo, String crsName, Integer crsHrs, Integer crsMark, String crsStatus, String crsStatusAName, String termNo, String classNo, Integer begTime, Integer endTime, String dayNo, String dayAName, String tutorNo, String tutorAName)
  {
    this.msCrsType = msCrsType;
    this.mscrsTypeName = mscrsTypeName;
    this.crsNo = crsNo;
    this.crsName = crsName;
    this.crsHrs = String.valueOf(crsHrs);
    this.crsMark = crsMark;
    this.crsStatus = crsStatus;
    this.crsStatusAName = crsStatusAName;
    this.termNo = termNo;
    this.classNo = classNo;
    this.begTime = begTime;
    this.endTime = endTime;
    this.dayNo = dayNo;
    this.dayAName = dayAName;
    this.tutorNo = tutorNo;
    this.tutorAName = tutorAName;
  }
  
  public MsCoursesList(String msCrsType, String mscrsTypeName, String crsNo, String crsName, Integer crsHrs, Integer crsMark, String crsStatus, String crsStatusAName, String termNo, String classNo, Integer begTime, Integer endTime, String dayNo, String dayAName, String tutorNo, String tutorAName, String studId)
  {
    this.msCrsType = msCrsType;
    this.mscrsTypeName = mscrsTypeName;
    this.crsNo = crsNo;
    this.crsName = crsName;
    this.crsHrs = String.valueOf(crsHrs);
    this.crsMark = crsMark;
    this.crsStatus = crsStatus;
    this.crsStatusAName = crsStatusAName;
    this.termNo = termNo;
    this.classNo = classNo;
    this.begTime = begTime;
    this.endTime = endTime;
    this.dayNo = dayNo;
    this.dayAName = dayAName;
    this.tutorNo = tutorNo;
    this.tutorAName = tutorAName;
    this.studId = studId;
  }
  
  public MsCoursesList(String studId, String termNo, String crsNo, String crHrs, String crsAName, String classNo, Integer begTime, Integer endTime, String dayNo, String dayAName, String empNo, String tutorAName)
  {
    this.studId = studId;
    this.termNo = termNo;
    this.crsName = crsAName;
    this.crsNo = crsNo;
    this.classNo = classNo;
    this.begTime = begTime;
    this.endTime = endTime;
    this.dayNo = dayNo;
    this.dayAName = dayAName;
    this.tutorAName = empNo;
    this.tutorAName = tutorAName;
    this.crsHrs = crHrs;
  }
  
  public String getStudId()
  {
    return this.studId;
  }
  
  public void setStudId(String studId)
  {
    this.studId = studId;
  }
  
  public String getMsCrsType()
  {
    return this.msCrsType;
  }
  
  public void setMsCrsType(String msCrsType)
  {
    this.msCrsType = msCrsType;
  }
  
  public String getMscrsTypeName()
  {
    return this.mscrsTypeName;
  }
  
  public void setMscrsTypeName(String mscrsTypeName)
  {
    this.mscrsTypeName = mscrsTypeName;
  }
  
  public String getCrsNo()
  {
    return this.crsNo;
  }
  
  public void setCrsNo(String crsNo)
  {
    this.crsNo = crsNo;
  }
  
  public String getCrsName()
  {
    return this.crsName;
  }
  
  public void setCrsName(String crsName)
  {
    this.crsName = crsName;
  }
  
  public String getCrsHrs()
  {
    return this.crsHrs;
  }
  
  public void setCrsHrs(String crsHrs)
  {
    this.crsHrs = crsHrs;
  }
  
  public Integer getCrsMark()
  {
    return this.crsMark;
  }
  
  public void setCrsMark(Integer crsMark)
  {
    this.crsMark = crsMark;
  }
  
  public String getCrsStatus()
  {
    return this.crsStatus;
  }
  
  public void setCrsStatus(String crsStatus)
  {
    this.crsStatus = crsStatus;
  }
  
  public String getTermNo()
  {
    return this.termNo;
  }
  
  public void setTermNo(String termNo)
  {
    this.termNo = termNo;
  }
  
  public String getCrsStatusAName()
  {
    return this.crsStatusAName;
  }
  
  public void setCrsStatusAName(String crsStatusAName)
  {
    this.crsStatusAName = crsStatusAName;
  }
  
  public String getClassNo()
  {
    return this.classNo;
  }
  
  public void setClassNo(String classNo)
  {
    this.classNo = classNo;
  }
  
  public String getBegTime()
  {
    return TimeConvertor.timeFormatConvertor(this.begTime);
  }
  
  public void setBegTime(Integer begTime)
  {
    this.begTime = begTime;
  }
  
  public String getEndTime()
  {
    return TimeConvertor.timeFormatConvertor(this.endTime);
  }
  
  public void setEndTime(Integer endTime)
  {
    this.endTime = endTime;
  }
  
  public String getDayAName()
  {
    return this.dayAName;
  }
  
  public void setDayAName(String dayAName)
  {
    this.dayAName = dayAName;
  }
  
  public String getTutorNo()
  {
    return this.tutorNo;
  }
  
  public void setTutorNo(String tutorNo)
  {
    this.tutorNo = tutorNo;
  }
  
  public String getTutorAName()
  {
    return this.tutorAName;
  }
  
  public void setTutorAName(String tutorAName)
  {
    this.tutorAName = tutorAName;
  }
  
  public String getDayNo()
  {
    return this.dayNo;
  }
  
  public void setDayNo(String dayNo)
  {
    this.dayNo = dayNo;
  }
  
  public String getBegEndTime()
  {
    return this.begEndTime;
  }
  
  public void setBegEndTime(String begEndTime)
  {
    this.begEndTime = begEndTime;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.struct.MsCoursesList
 * JD-Core Version:    0.7.0.1
 */