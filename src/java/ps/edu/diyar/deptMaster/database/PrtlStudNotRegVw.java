package ps.edu.diyar.deptMaster.database;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

public class PrtlStudNotRegVw
  implements Serializable
{
  private String studId;
  private String studName;
  private String deptNo;
  private String majorSheetNo;
  
  public PrtlStudNotRegVw(String studId, String studName, String deptNo)
  {
    this.studId = studId;
    this.studName = studName;
    this.deptNo = deptNo;
  }
  
  public String getMajorSheetNo()
  {
    return this.majorSheetNo;
  }
  
  public void setMajorSheetNo(String majorSheetNo)
  {
    this.majorSheetNo = majorSheetNo;
  }
  
  public PrtlStudNotRegVw() {}
  
  public PrtlStudNotRegVw(String studId, String deptNo)
  {
    this.studId = studId;
    this.deptNo = deptNo;
  }
  
  public String getStudId()
  {
    return this.studId;
  }
  
  public void setStudId(String studId)
  {
    this.studId = studId;
  }
  
  public String getStudName()
  {
    return this.studName;
  }
  
  public void setStudName(String studName)
  {
    this.studName = studName;
  }
  
  public String getDeptNo()
  {
    return this.deptNo;
  }
  
  public void setDeptNo(String deptNo)
  {
    this.deptNo = deptNo;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).toString();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.deptMaster.database.PrtlStudNotRegVw
 * JD-Core Version:    0.7.0.1
 */