package ps.edu.diyar.deptMaster.database;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

public class PrtlDeptMasterInfoVw
  implements Serializable
{
  private PrtlDeptMasterInfoVwPK comp_id;
  private String empAName;
  private String empLName;
  private String empType;
  private String empTypeDesc;
  private String jobType;
  private String jobTypeDesc;
  private String accRank;
  private String accRankDesc;
  private String deptDesc;
  private String isActive;
  private String hasClass;
  
  public PrtlDeptMasterInfoVwPK getComp_id()
  {
    return this.comp_id;
  }
  
  public void setComp_id(PrtlDeptMasterInfoVwPK comp_id)
  {
    this.comp_id = comp_id;
  }
  
  public String getEmpAName()
  {
    return this.empAName;
  }
  
  public void setEmpAName(String empAName)
  {
    this.empAName = empAName;
  }
  
  public String getEmpLName()
  {
    return this.empLName;
  }
  
  public void setEmpLName(String empLName)
  {
    this.empLName = empLName;
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
  
  public String getIsActive()
  {
    return this.isActive;
  }
  
  public void setIsActive(String isActive)
  {
    this.isActive = isActive;
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
 * Qualified Name:     ps.edu.diyar.deptMaster.database.PrtlDeptMasterInfoVw
 * JD-Core Version:    0.7.0.1
 */