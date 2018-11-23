package ps.edu.diyar.tutorInfo.database;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

public class PrtlTutorInfoVw
  implements Serializable
{
  private String empNo;
  private String tutorAName;
  private String tutorLName;
  private String empType;
  private String empTypeDesc;
  private String jobType;
  private String jobTypeDesc;
  private String accRank;
  private String accRankDesc;
  private String deptDesc;
  private String deptAName;
  private String isActive;
  private String deptNo;
  private String isMasterDept;
  private String hasClass;
  
  public PrtlTutorInfoVw(String empNo, String tutorAName, String tutorLName, String empType, String empTypeDesc, String jobType, String jobTypeDesc, String accRank, String accRankDesc, String deptDesc, String deptAName, String isActive)
  {
    this.empNo = empNo;
    this.tutorAName = tutorAName;
    this.tutorLName = tutorLName;
    this.empType = empType;
    this.empTypeDesc = empTypeDesc;
    this.jobType = jobType;
    this.jobTypeDesc = jobTypeDesc;
    this.accRank = accRank;
    this.accRankDesc = accRankDesc;
    this.deptDesc = deptDesc;
    this.deptAName = deptAName;
    this.isActive = isActive;
  }
  
  public PrtlTutorInfoVw() {}
  
  public PrtlTutorInfoVw(String empNo, String empType, String empTypeDesc, String jobType, String jobTypeDesc, String accRankDesc, String deptDesc, String deptAName, String isActive)
  {
    this.empNo = empNo;
    this.empType = empType;
    this.empTypeDesc = empTypeDesc;
    this.jobType = jobType;
    this.jobTypeDesc = jobTypeDesc;
    this.accRankDesc = accRankDesc;
    this.deptDesc = deptDesc;
    this.deptAName = deptAName;
    this.isActive = isActive;
  }
  
  public String getDeptNo()
  {
    return this.deptNo;
  }
  
  public void setDeptNo(String deptNo)
  {
    this.deptNo = deptNo;
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
  
  public String getTutorLName()
  {
    return this.tutorLName;
  }
  
  public void setTutorLName(String tutorLName)
  {
    this.tutorLName = tutorLName;
  }
  
  public String getEmpType()
  {
    return this.empType;
  }
  
  public void setEmpType(String empType)
  {
    this.empType = empType;
  }
  
  public String getEmpTypeDesc()
  {
    return this.empTypeDesc;
  }
  
  public void setEmpTypeDesc(String empTypeDesc)
  {
    this.empTypeDesc = empTypeDesc;
  }
  
  public String getJobType()
  {
    return this.jobType;
  }
  
  public void setJobType(String jobType)
  {
    this.jobType = jobType;
  }
  
  public String getJobTypeDesc()
  {
    return this.jobTypeDesc;
  }
  
  public void setJobTypeDesc(String jobTypeDesc)
  {
    this.jobTypeDesc = jobTypeDesc;
  }
  
  public String getAccRank()
  {
    return this.accRank;
  }
  
  public void setAccRank(String accRank)
  {
    this.accRank = accRank;
  }
  
  public String getAccRankDesc()
  {
    return this.accRankDesc;
  }
  
  public void setAccRankDesc(String accRankDesc)
  {
    this.accRankDesc = accRankDesc;
  }
  
  public String getDeptDesc()
  {
    return this.deptDesc;
  }
  
  public void setDeptDesc(String deptDesc)
  {
    this.deptDesc = deptDesc;
  }
  
  public String getDeptAName()
  {
    return this.deptAName;
  }
  
  public void setDeptAName(String deptAName)
  {
    this.deptAName = deptAName;
  }
  
  public String getIsActive()
  {
    return this.isActive;
  }
  
  public void setIsActive(String isActive)
  {
    this.isActive = isActive;
  }
  
  public String getIsMasterDept()
  {
    return this.isMasterDept;
  }
  
  public void setIsMasterDept(String masterDept)
  {
    this.isMasterDept = masterDept;
  }
  
  public String getHasClass()
  {
    return this.hasClass;
  }
  
  public void setHasClass(String hasClass)
  {
    this.hasClass = hasClass;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).toString();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.tutorInfo.database.PrtlTutorInfoVw
 * JD-Core Version:    0.7.0.1
 */