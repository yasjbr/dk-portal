package ps.edu.diyar.studentInfo.database.struct;

public class TutorListForCenter
{
  private String tutorNo;
  private String tutorCenter;
  private String tutorUserId;
  private String tutorAName;
  private String tutorStatus;
  private String titleA;
  private String idcardNo;
  private String specAName;
  private Double acLoad;
  private String gradeNo;
  private String email;
  private String mobile;
  
  public TutorListForCenter() {}
  
  public TutorListForCenter(String tutorNo, String tutorCenter, String tutorAName, String email, String mobile, Double acLoad, String titleA, String idcardNo, String specAName, String gradeNo)
  {
    this.tutorNo = tutorNo;
    this.tutorCenter = tutorCenter;
    this.tutorAName = tutorAName;
    this.titleA = titleA;
    this.idcardNo = idcardNo;
    this.specAName = specAName;
    this.acLoad = acLoad;
    this.gradeNo = gradeNo;
    this.mobile = mobile;
    this.email = email;
  }
  
  public TutorListForCenter(String tutorNo, String tutorCenter, String tutorAName, String titleA, String elementForGenarateConstactor)
  {
    this.tutorNo = tutorNo;
    this.tutorCenter = tutorCenter;
    this.tutorAName = tutorAName;
    this.tutorUserId = (tutorCenter + "/" + tutorNo);
    this.titleA = titleA;
  }
  
  public TutorListForCenter(String tutorNo, String tutorCenter, String tutorAName, String titleA, Double temp)
  {
    this.tutorNo = tutorNo;
    this.tutorCenter = tutorCenter;
    this.tutorAName = tutorAName;
    this.tutorUserId = (tutorCenter + "/" + tutorNo);
    this.titleA = titleA;
  }
  
  public TutorListForCenter(String tutorNo, String tutorCenter, String tutorAName, String titleA, Double temp, String idcardNo)
  {
    this.tutorNo = tutorNo;
    this.tutorCenter = tutorCenter;
    this.tutorAName = tutorAName;
    this.tutorUserId = (tutorCenter + "/" + tutorNo);
    this.titleA = titleA;
    this.idcardNo = idcardNo;
  }
  
  public TutorListForCenter(String tutorNo, String tutorCenter, String tutorAName, Double temp)
  {
    this.tutorNo = tutorNo;
    this.tutorCenter = tutorCenter;
    this.tutorAName = tutorAName;
    this.tutorUserId = (tutorCenter + "/" + tutorNo);
  }
  
  public String getEmail()
  {
    return this.email;
  }
  
  public void setEmail(String email)
  {
    this.email = email;
  }
  
  public String getMobile()
  {
    return this.mobile;
  }
  
  public void setMobile(String mobile)
  {
    this.mobile = mobile;
  }
  
  public String getIdcardNo()
  {
    return this.idcardNo;
  }
  
  public void setIdcardNo(String idcardNo)
  {
    this.idcardNo = idcardNo;
  }
  
  public String getSpecAName()
  {
    return this.specAName;
  }
  
  public void setSpecAName(String specAName)
  {
    this.specAName = specAName;
  }
  
  public Double getAcLoad()
  {
    return this.acLoad;
  }
  
  public void setAcLoad(Double acLoad)
  {
    this.acLoad = acLoad;
  }
  
  public String getGradeNo()
  {
    return this.gradeNo;
  }
  
  public void setGradeNo(String gradeNo)
  {
    this.gradeNo = gradeNo;
  }
  
  public String getGradeName()
  {
    String grade = "غير محدد";
    if ((this.gradeNo != null) && (!this.gradeNo.equals(""))) {
      switch (Integer.parseInt(this.gradeNo))
      {
      case 1: 
        grade = "عضو هيئة تدريس";
        break;
      case 2: 
        grade = "محاضر";
        break;
      case 3: 
        grade = "استاذ مساعد";
        break;
      case 4: 
        grade = "استاذ مشارك";
        break;
      case 5: 
        grade = "استاذ ";
      }
    }
    return grade;
  }
  
  public TutorListForCenter(String tutorNo, String tutorAName)
  {
    this.tutorNo = tutorNo;
    this.tutorAName = tutorAName;
    this.tutorUserId = tutorNo;
  }
  
  public TutorListForCenter(String tutorNo, String tutorCenter, String tutorAName)
  {
    this.tutorNo = tutorNo;
    this.tutorCenter = tutorCenter;
    this.tutorAName = tutorAName;
    this.tutorUserId = (tutorCenter + "/" + tutorNo);
  }
  
  public TutorListForCenter(String tutorNo, String tutorCenter, String tutorAName, String status)
  {
    this.tutorNo = tutorNo;
    this.tutorCenter = tutorCenter;
    this.tutorStatus = status;
    this.tutorAName = tutorAName;
    this.tutorUserId = (tutorCenter + "/" + tutorNo);
  }
  
  public String getTutorStatus()
  {
    return this.tutorStatus;
  }
  
  public void setTutorStatus(String tutorStatus)
  {
    this.tutorStatus = tutorStatus;
  }
  
  public String getTutorCenter()
  {
    return this.tutorCenter;
  }
  
  public void setTutorCenter(String tutorCenter)
  {
    this.tutorCenter = tutorCenter;
  }
  
  public String getTutorNo()
  {
    return this.tutorNo;
  }
  
  public void setTutorNo(String tutorNo)
  {
    this.tutorNo = tutorNo;
  }
  
  public String getTutorUserId()
  {
    return this.tutorUserId;
  }
  
  public void setTutorUserId(String tutorUserId)
  {
    this.tutorUserId = tutorUserId;
  }
  
  public String getTutorAName()
  {
    return this.titleA + this.tutorAName;
  }
  
  public void setTutorAName(String tutorAName)
  {
    this.tutorAName = tutorAName;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.struct.TutorListForCenter
 * JD-Core Version:    0.7.0.1
 */