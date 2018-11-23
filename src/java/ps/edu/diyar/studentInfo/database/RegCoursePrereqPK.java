package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RegCoursePrereqPK
  implements Serializable
{
  private Integer groupNo;
  private String crsNo;
  private String prereqCrsNo;
  
  public RegCoursePrereqPK(Integer groupNo, String crsNo, String prereqCrsNo)
  {
    this.groupNo = groupNo;
    this.crsNo = crsNo;
    this.prereqCrsNo = prereqCrsNo;
  }
  
  public RegCoursePrereqPK(String crsNo)
  {
    this.crsNo = crsNo;
  }
  
  public RegCoursePrereqPK() {}
  
  public Integer getGroupNo()
  {
    return this.groupNo;
  }
  
  public void setGroupNo(Integer groupNo)
  {
    this.groupNo = groupNo;
  }
  
  public String getCrsNo()
  {
    return this.crsNo;
  }
  
  public void setCrsNo(String crsNo)
  {
    this.crsNo = crsNo;
  }
  
  public String getPrereqCrsNo()
  {
    return this.prereqCrsNo;
  }
  
  public void setPrereqCrsNo(String prereqCrsNo)
  {
    this.prereqCrsNo = prereqCrsNo;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("groupNo", getGroupNo()).append("crsNo", getCrsNo()).append("prereqCrsNo", getPrereqCrsNo()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof RegCoursePrereqPK)) {
      return false;
    }
    RegCoursePrereqPK castOther = (RegCoursePrereqPK)other;
    return new EqualsBuilder().append(getGroupNo(), castOther.getGroupNo()).append(getCrsNo(), castOther.getCrsNo()).append(getPrereqCrsNo(), castOther.getPrereqCrsNo()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getGroupNo()).append(getCrsNo()).append(getPrereqCrsNo()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.RegCoursePrereqPK
 * JD-Core Version:    0.7.0.1
 */