package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RegDeptPK
  implements Serializable
{
  private String deptNo;
  private String collegeNo;
  
  public RegDeptPK(String deptNo, String collegeNo)
  {
    this.deptNo = deptNo;
    this.collegeNo = collegeNo;
  }
  
  public RegDeptPK() {}
  
  public String getDeptNo()
  {
    return this.deptNo;
  }
  
  public void setDeptNo(String deptNo)
  {
    this.deptNo = deptNo;
  }
  
  public String getCollegeNo()
  {
    return this.collegeNo;
  }
  
  public void setCollegeNo(String collegeNo)
  {
    this.collegeNo = collegeNo;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("deptNo", getDeptNo()).append("collegeNo", getCollegeNo()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof RegDeptPK)) {
      return false;
    }
    RegDeptPK castOther = (RegDeptPK)other;
    return new EqualsBuilder().append(getDeptNo(), castOther.getDeptNo()).append(getCollegeNo(), castOther.getCollegeNo()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getDeptNo()).append(getCollegeNo()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.RegDeptPK
 * JD-Core Version:    0.7.0.1
 */