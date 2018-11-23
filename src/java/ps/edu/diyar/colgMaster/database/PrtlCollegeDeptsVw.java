package ps.edu.diyar.colgMaster.database;

public class PrtlCollegeDeptsVw
{
  private PrtlCollegeDeptsVwPK comp_id;
  private String collegeDesc;
  private String deptDesc;
  private String isActive;
  
  public PrtlCollegeDeptsVwPK getComp_id()
  {
    return this.comp_id;
  }
  
  public void setComp_id(PrtlCollegeDeptsVwPK comp_id)
  {
    this.comp_id = comp_id;
  }
  
  public String getCollegeDesc()
  {
    return this.collegeDesc;
  }
  
  public void setCollegeDesc(String collegeDesc)
  {
    this.collegeDesc = collegeDesc;
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
  
  public void setIsActive(String active)
  {
    this.isActive = active;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.colgMaster.database.PrtlCollegeDeptsVw
 * JD-Core Version:    0.7.0.1
 */