package ps.edu.diyar.studentInfo.database.struct;

import java.io.Serializable;

public class StudentInfoHolder
  implements Serializable
{
  private String studentId;
  private String studentName;
  private String colgName;
  private String specName;
  private String majorSheet;
  private String currentTermNo;
  private String systemCurrentTermNo;
  private String finMaxTermNo;
  private String levelNo;
  private String studStatusName;
  private String cumHTran;
  private String cumHPassed;
  private String graduateStatus;
  private String warningName;
  private String isGraduate;
  private String specializationNo;
  private String tawjehiBranchName;
  private String joinTermNo;
  private String cumAvg;
  private String studStatus;
  private String finCard;
  private String specTypeNo;
  private String deptNo;
  private String warnStatus;
  
  public StudentInfoHolder(String studentId, String studentName, String colgName, String specName, String majorSheet, String currentTermNo, String specializationNo, String joinTermNo)
  {
    this.studentId = studentId;
    this.studentName = studentName;
    this.colgName = colgName;
    this.specName = specName;
    this.majorSheet = majorSheet;
    this.currentTermNo = currentTermNo;
    this.specializationNo = specializationNo;
    this.joinTermNo = joinTermNo;
  }
  
  public StudentInfoHolder(String studentId, String firstName, String secondName, String thirdName, String familyName, String colgName, String specName, String majorSheet, String currentTermNo, String specializationNo, String joinTermNo)
  {
    this.studentId = studentId;
    this.studentName = (firstName + " " + secondName + " " + thirdName + " " + familyName);
    this.colgName = colgName;
    this.specName = specName;
    this.majorSheet = majorSheet;
    this.currentTermNo = currentTermNo;
    this.specializationNo = specializationNo;
    this.joinTermNo = joinTermNo;
  }
  
  public StudentInfoHolder(String studentId, String studentName, String colgName, String specName, String majorSheet, String currentTermNo, String specializationNo)
  {
    this.studentId = studentId;
    this.studentName = studentName;
    this.colgName = colgName;
    this.specName = specName;
    this.majorSheet = majorSheet;
    this.currentTermNo = currentTermNo;
    this.specializationNo = specializationNo;
  }
  
  public StudentInfoHolder(String studentId, String firstName, String secondName, String thirdName, String familyName, String colgName, String specName, String majorSheet, String currentTermNo, String specializationNo, String joinTermNo, String specTypeNo)
  {
    this.studentId = studentId;
    this.studentName = (firstName + " " + secondName + " " + thirdName + " " + familyName);
    this.colgName = colgName;
    this.specName = specName;
    this.majorSheet = majorSheet;
    this.currentTermNo = currentTermNo;
    this.specializationNo = specializationNo;
    this.joinTermNo = joinTermNo;
    this.specTypeNo = specTypeNo;
  }
  
  public StudentInfoHolder(String studentId, String firstName, String secondName, String thirdName, String familyName, String colgName, String specName, String majorSheet, String currentTermNo, String specializationNo, String joinTermNo, String specTypeNo, String deptNo)
  {
    this.studentId = studentId;
    this.studentName = (firstName + " " + secondName + " " + thirdName + " " + familyName);
    this.colgName = colgName;
    this.specName = specName;
    this.majorSheet = majorSheet;
    this.currentTermNo = currentTermNo;
    this.specializationNo = specializationNo;
    this.joinTermNo = joinTermNo;
    this.specTypeNo = specTypeNo;
    this.deptNo = deptNo;
  }
  
  public StudentInfoHolder(String studentId, String firstName, String secondName, String thirdName, String familyName, String colgName, String specName, String majorSheet, String currentTermNo, String specializationNo, String joinTermNo, String specTypeNo, String deptNo, String warnStatus)
  {
    this.studentId = studentId;
    this.studentName = (firstName + " " + secondName + " " + thirdName + " " + familyName);
    this.colgName = colgName;
    this.specName = specName;
    this.majorSheet = majorSheet;
    this.currentTermNo = currentTermNo;
    this.specializationNo = specializationNo;
    this.joinTermNo = joinTermNo;
    this.specTypeNo = specTypeNo;
    this.deptNo = deptNo;
    this.warnStatus = warnStatus;
  }

    public String getFinMaxTermNo() {
        return finMaxTermNo;
    }

    public void setFinMaxTermNo(String finMaxTermNo) {
        this.finMaxTermNo = finMaxTermNo;
    }
  
  
  
  
  public String getDeptNo()
  {
    return this.deptNo;
  }
  
  public void setDeptNo(String deptNo)
  {
    this.deptNo = deptNo;
  }
  
  public String getSpecTypeNo()
  {
    return this.specTypeNo;
  }
  
  public void setSpecTypeNo(String specTypeNo)
  {
    this.specTypeNo = specTypeNo;
  }
  
  public String getSystemCurrentTermNo()
  {
    return this.systemCurrentTermNo;
  }
  
  public void setSystemCurrentTermNo(String systemCurrentTermNo)
  {
    this.systemCurrentTermNo = systemCurrentTermNo;
  }
  
  public StudentInfoHolder() {}
  
  public String getStudStatus()
  {
    return this.studStatus;
  }
  
  public void setStudStatus(String studStatus)
  {
    this.studStatus = studStatus;
  }
  
  public String getCumAvg()
  {
    return this.cumAvg;
  }
  
  public void setCumAvg(String cumAvg)
  {
    this.cumAvg = cumAvg;
  }
  
  public String getJoinTermNo()
  {
    return this.joinTermNo;
  }
  
  public void setJoinTermNo(String joinTermNo)
  {
    this.joinTermNo = joinTermNo;
  }
  
  public String getStudentId()
  {
    if (this.studentId == null) {
      this.studentId = "-";
    }
    return this.studentId;
  }
  
  public void setStudentId(String studentId)
  {
    this.studentId = studentId;
  }
  
  public void setStudentName(String studentName)
  {
    this.studentName = studentName;
  }
  
  public String getStudentName()
  {
    if (this.studentName == null) {
      this.studentName = "-";
    }
    return this.studentName;
  }
  
  public void setProgramName(String colgName)
  {
    this.colgName = colgName;
  }
  
  public String getProgramName()
  {
    if (this.colgName == null) {
      this.colgName = "-";
    }
    return this.colgName;
  }
  
  public void setSpecialization(String specName)
  {
    this.specName = specName;
  }
  
  public String getSpecialization()
  {
    if (this.specName == null) {
      this.specName = "-";
    }
    return this.specName;
  }
  
  public void setMajorSheet(String majorSheet)
  {
    this.majorSheet = majorSheet;
  }
  
  public String getMajorSheet()
  {
    if (this.majorSheet == null) {
      this.majorSheet = "-";
    }
    return this.majorSheet;
  }
  
  public void setCurrentTermNo(String currentTermNo)
  {
    this.currentTermNo = currentTermNo;
  }
  
  public String getCurrentTermNo()
  {
    return this.currentTermNo;
  }
  
  public void setLevelNo(String levelNo)
  {
    this.levelNo = levelNo;
  }
  
  public String getLevelNo()
  {
    return this.levelNo;
  }
  
  public void setStudStatusName(String studStatusName)
  {
    this.studStatusName = studStatusName;
  }
  
  public String getStudStatusName()
  {
    return this.studStatusName;
  }
  
  public void setCumHTran(String cumHTran)
  {
    this.cumHTran = cumHTran;
  }
  
  public String getCumHTran()
  {
    return this.cumHTran;
  }
  
  public void setCumHPassed(String cumHPassed)
  {
    this.cumHPassed = cumHPassed;
  }
  
  public String getCumHPassed()
  {
    return this.cumHPassed;
  }
  
  public void setGraduateStatus(String graduateStatus)
  {
    this.graduateStatus = graduateStatus;
  }
  
  public String getGraduateStatus()
  {
    return this.graduateStatus;
  }
  
  public void setWarningName(String warningName)
  {
    this.warningName = warningName;
  }
  
  public String getWarningName()
  {
    return this.warningName;
  }
  
  public void setIsGraduate(String isGraduate)
  {
    this.isGraduate = isGraduate;
  }
  
  public String getIsGraduate()
  {
    if ((this.graduateStatus == null) || (this.graduateStatus.equals("")) || (this.graduateStatus.equalsIgnoreCase("n"))) {
      this.isGraduate = "لا";
    } else if (this.graduateStatus.equalsIgnoreCase("y")) {
      this.isGraduate = "نعم";
    }
    return this.isGraduate;
  }
  
  public void setSpecializationNo(String specializationNo)
  {
    this.specializationNo = specializationNo;
  }
  
  public String getSpecializationNo()
  {
    return this.specializationNo;
  }
  
  public String getTawjehiBranchName()
  {
    return this.tawjehiBranchName;
  }
  
  public void setTawjehiBranchName(String tawjehiBranchName)
  {
    this.tawjehiBranchName = tawjehiBranchName;
  }
  
  public String getFinCard()
  {
    return this.finCard;
  }
  
  public void setFinCard(String finCard)
  {
    this.finCard = finCard;
  }
  
  public String getWarnStatus()
  {
    return this.warnStatus;
  }
  
  public void setWarnStatus(String warnStatus)
  {
    this.warnStatus = warnStatus;
  }
}



/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\

 * Qualified Name:     ps.edu.diyar.studentInfo.database.struct.StudentInfoHolder

 * JD-Core Version:    0.7.0.1

 */