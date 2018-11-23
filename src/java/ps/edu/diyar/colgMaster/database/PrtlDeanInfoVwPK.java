package ps.edu.diyar.colgMaster.database;

import java.io.Serializable;

public class PrtlDeanInfoVwPK
  implements Serializable
{
  private String empNo;
  private String collegeNo;
  
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
  
  public boolean equals(Object o)
  {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    PrtlDeanInfoVwPK that = (PrtlDeanInfoVwPK)o;
    if (this.collegeNo != null ? !this.collegeNo.equals(that.collegeNo) : that.collegeNo != null) {
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
    result = 31 * result + (this.collegeNo != null ? this.collegeNo.hashCode() : 0);
    return result;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.colgMaster.database.PrtlDeanInfoVwPK
 * JD-Core Version:    0.7.0.1
 */