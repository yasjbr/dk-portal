package ps.edu.diyar.colgMaster.database.struct;

public class ColgMasterInfoHolder
{
  private String empNo;
  private String collegeNo;
  private String deanAName;
  private String deanLName;
  private String accRank;
  private String accRankDesc;
  private String collegeDesc;
  private String currentTermNo;
  
  public ColgMasterInfoHolder() {}
  
  public ColgMasterInfoHolder(String empNo, String collegeNo, String deanAName, String deanLName, String accRank, String accRankDesc, String collegeDesc)
  {
    this.empNo = empNo;
    this.collegeNo = collegeNo;
    this.deanAName = deanAName;
    this.deanLName = deanLName;
    this.accRank = accRank;
    this.accRankDesc = accRankDesc;
    this.collegeDesc = collegeDesc;
  }
  
  public String getEmpNo()
  {
    return this.empNo;
  }
  
  public void setEmpNo(String empNo)
  {
    this.empNo = empNo;
  }
  
  public String getCollegeNo()
  {
    return this.collegeNo;
  }
  
  public void setCollegeNo(String collegeNo)
  {
    this.collegeNo = collegeNo;
  }
  
  public String getDeanAName()
  {
    return this.deanAName;
  }
  
  public void setDeanAName(String deanAName)
  {
    this.deanAName = deanAName;
  }
  
  public String getDeanLName()
  {
    return this.deanLName;
  }
  
  public void setDeanLName(String deanLName)
  {
    this.deanLName = deanLName;
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
  
  public String getCollegeDesc()
  {
    return this.collegeDesc;
  }
  
  public void setCollegeDesc(String collegeDesc)
  {
    this.collegeDesc = collegeDesc;
  }
  
  public String getCurrentTermNo()
  {
    return this.currentTermNo;
  }
  
  public void setCurrentTermNo(String currentTermNo)
  {
    this.currentTermNo = currentTermNo;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.colgMaster.database.struct.ColgMasterInfoHolder
 * JD-Core Version:    0.7.0.1
 */