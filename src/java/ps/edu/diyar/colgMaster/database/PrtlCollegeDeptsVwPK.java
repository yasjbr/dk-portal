package ps.edu.diyar.colgMaster.database;

import java.io.Serializable;

public class PrtlCollegeDeptsVwPK
  implements Serializable
{
  private String collegeNo;
  private String deptNo;
  
  public String getCollegeNo()
  {
    return this.collegeNo;
  }
  
  public void setCollegeNo(String collegeNo)
  {
    this.collegeNo = collegeNo;
  }
  
  public String getDeptNo()
  {
    return this.deptNo;
  }
  
  public void setDeptNo(String deptNo)
  {
    this.deptNo = deptNo;
  }
  
  public boolean equals(Object o)
  {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    PrtlCollegeDeptsVwPK that = (PrtlCollegeDeptsVwPK)o;
    if (this.collegeNo != null ? !this.collegeNo.equals(that.collegeNo) : that.collegeNo != null) {
      return false;
    }
    if (this.deptNo != null ? !this.deptNo.equals(that.deptNo) : that.deptNo != null) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int result = this.collegeNo != null ? this.collegeNo.hashCode() : 0;
    result = 31 * result + (this.deptNo != null ? this.deptNo.hashCode() : 0);
    return result;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.colgMaster.database.PrtlCollegeDeptsVwPK
 * JD-Core Version:    0.7.0.1
 */