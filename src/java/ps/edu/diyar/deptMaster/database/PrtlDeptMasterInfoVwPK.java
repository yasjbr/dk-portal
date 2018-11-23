package ps.edu.diyar.deptMaster.database;

import java.io.Serializable;

public class PrtlDeptMasterInfoVwPK
  implements Serializable
{
  private String empNo;
  private String deptNo;
  
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
  
  public boolean equals(Object o)
  {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    PrtlDeptMasterInfoVwPK that = (PrtlDeptMasterInfoVwPK)o;
    if (this.deptNo != null ? !this.deptNo.equals(that.deptNo) : that.deptNo != null) {
      return false;
    }
    if (this.empNo != null ? !this.empNo.equals(that.empNo) : that.empNo != null) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int result = this.empNo != null ? this.empNo.hashCode() : 0;
    result = 31 * result + (this.deptNo != null ? this.deptNo.hashCode() : 0);
    return result;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.deptMaster.database.PrtlDeptMasterInfoVwPK
 * JD-Core Version:    0.7.0.1
 */