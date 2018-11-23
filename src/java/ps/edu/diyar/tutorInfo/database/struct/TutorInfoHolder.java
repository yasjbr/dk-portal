package ps.edu.diyar.tutorInfo.database.struct;

public class TutorInfoHolder
{
  private String empNo;
  private String tutorAName;
  private String tutorLName;
  private String accRankDesc;
  private String deptAName;
  private String deptNo;
  private String currentTermNo;
  private String isMasterDept;
  
  public TutorInfoHolder() {}
  
  public TutorInfoHolder(String empNo, String tutorAName, String accRankDesc, String deptAName)
  {
    this.empNo = empNo;
    this.tutorAName = tutorAName;
    this.accRankDesc = accRankDesc;
    this.deptAName = deptAName;
  }
  
  public TutorInfoHolder(String empNo, String tutorAName, String accRankDesc, String deptAName, String deptNo)
  {
    this.empNo = empNo;
    this.tutorAName = tutorAName;
    this.accRankDesc = accRankDesc;
    this.deptAName = deptAName;
    this.deptNo = deptNo;
  }
  
  public TutorInfoHolder(String empNo, String tutorAName, String tutorLName, String accRankDesc, String deptAName, String deptNo)
  {
    this.empNo = empNo;
    this.tutorAName = tutorAName;
    this.tutorLName = tutorLName;
    this.accRankDesc = accRankDesc;
    this.deptAName = deptAName;
    this.deptNo = deptNo;
  }
  
  public TutorInfoHolder(String empNo, String tutorAName, String tutorLName, String accRankDesc, String deptAName, String deptNo, String isMasterDept)
  {
    this.empNo = empNo;
    this.tutorAName = tutorAName;
    this.tutorLName = tutorLName;
    this.accRankDesc = accRankDesc;
    this.deptAName = deptAName;
    this.deptNo = deptNo;
    this.isMasterDept = isMasterDept;
  }
  
  public String getTutorLName()
  {
    return this.tutorLName;
  }
  
  public void setTutorLName(String tutorLName)
  {
    this.tutorLName = tutorLName;
  }
  
  public String getDeptNo()
  {
    return this.deptNo;
  }
  
  public void setDeptNo(String deptNo)
  {
    this.deptNo = deptNo;
  }
  
  public String getCurrentTermNo()
  {
    return this.currentTermNo;
  }
  
  public void setCurrentTermNo(String currentTermNo)
  {
    this.currentTermNo = currentTermNo;
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
  
  public String getAccRankDesc()
  {
    return this.accRankDesc;
  }
  
  public void setAccRankDesc(String accRankDesc)
  {
    this.accRankDesc = accRankDesc;
  }
  
  public String getDeptAName()
  {
    return this.deptAName;
  }
  
  public void setDeptAName(String deptAName)
  {
    this.deptAName = deptAName;
  }
  
  public String getIsMasterDept()
  {
    return this.isMasterDept;
  }
  
  public void setIsMasterDept(String masterDept)
  {
    this.isMasterDept = masterDept;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.tutorInfo.database.struct.TutorInfoHolder
 * JD-Core Version:    0.7.0.1
 */