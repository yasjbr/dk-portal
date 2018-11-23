package ps.edu.diyar.deptMaster.database.struct;

public class DeptMasterInfoHolder
{
  private String empNo;
  private String deptNo;
  private String empAName;
  private String accRank;
  private String accRankDesc;
  private String deptDesc;
  private String currentTermNo;
  private String hasClass;
  
  public DeptMasterInfoHolder() {}
  
  public DeptMasterInfoHolder(String empNo, String deptNo, String empAName, String accRank, String accRankDesc, String deptDesc)
  {
    this.empNo = empNo;
    this.deptNo = deptNo;
    this.empAName = empAName;
    this.accRank = accRank;
    this.accRankDesc = accRankDesc;
    this.deptDesc = deptDesc;
  }
  
  public DeptMasterInfoHolder(String empNo, String deptNo, String empAName, String accRank, String accRankDesc, String deptDesc, String hasClass)
  {
    this.empNo = empNo;
    this.deptNo = deptNo;
    this.empAName = empAName;
    this.accRank = accRank;
    this.accRankDesc = accRankDesc;
    this.deptDesc = deptDesc;
    this.hasClass = hasClass;
  }
  
  public String getEmpNo()
  {
    return this.empNo;
  }
  
  public void setEmpNo(String empNo)
  {
    this.empNo = empNo;
  }
  
  public String getDeptNo()
  {
    return this.deptNo;
  }
  
  public void setDeptNo(String deptNo)
  {
    this.deptNo = deptNo;
  }
  
  public String getEmpAName()
  {
    return this.empAName;
  }
  
  public void setEmpAName(String empAName)
  {
    this.empAName = empAName;
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
  
  public String getCurrentTermNo()
  {
    return this.currentTermNo;
  }
  
  public void setCurrentTermNo(String currentTermNo)
  {
    this.currentTermNo = currentTermNo;
  }
  
  public String getHasClass()
  {
    return this.hasClass;
  }
  
  public void setHasClass(String hasClass)
  {
    this.hasClass = hasClass;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.deptMaster.database.struct.DeptMasterInfoHolder
 * JD-Core Version:    0.7.0.1
 */