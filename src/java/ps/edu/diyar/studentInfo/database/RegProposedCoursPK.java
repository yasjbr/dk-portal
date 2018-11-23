package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RegProposedCoursPK
  implements Serializable
{
  private String deptNo;
  private String collegeNo;
  private String termNo;
  private String crsNo;
  
  public RegProposedCoursPK(String deptNo, String collegeNo, String termNo, String crsNo)
  {
    this.deptNo = deptNo;
    this.collegeNo = collegeNo;
    this.termNo = termNo;
    this.crsNo = crsNo;
  }
  
  public RegProposedCoursPK() {}
  
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
  
  public String getTermNo()
  {
    return this.termNo;
  }
  
  public void setTermNo(String termNo)
  {
    this.termNo = termNo;
  }
  
  public String getCrsNo()
  {
    return this.crsNo;
  }
  
  public void setCrsNo(String crsNo)
  {
    this.crsNo = crsNo;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("deptNo", getDeptNo()).append("collegeNo", getCollegeNo()).append("termNo", getTermNo()).append("crsNo", getCrsNo()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof RegProposedCoursPK)) {
      return false;
    }
    RegProposedCoursPK castOther = (RegProposedCoursPK)other;
    return new EqualsBuilder().append(getDeptNo(), castOther.getDeptNo()).append(getCollegeNo(), castOther.getCollegeNo()).append(getTermNo(), castOther.getTermNo()).append(getCrsNo(), castOther.getCrsNo()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getDeptNo()).append(getCollegeNo()).append(getTermNo()).append(getCrsNo()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.RegProposedCoursPK
 * JD-Core Version:    0.7.0.1
 */