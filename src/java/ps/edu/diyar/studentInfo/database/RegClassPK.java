package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RegClassPK
  implements Serializable
{
  private String classNo;
  private String crsNo;
  private String termNo;
  
  public RegClassPK(String classNo, String crsNo, String termNo)
  {
    this.classNo = classNo;
    this.crsNo = crsNo;
    this.termNo = termNo;
  }
  
  public RegClassPK() {}
  
  public String getClassNo()
  {
    return this.classNo;
  }
  
  public void setClassNo(String classNo)
  {
    this.classNo = classNo;
  }
  
  public String getCrsNo()
  {
    return this.crsNo;
  }
  
  public void setCrsNo(String crsNo)
  {
    this.crsNo = crsNo;
  }
  
  public String getTermNo()
  {
    return this.termNo;
  }
  
  public void setTermNo(String termNo)
  {
    this.termNo = termNo;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("classNo", getClassNo()).append("crsNo", getCrsNo()).append("termNo", getTermNo()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof RegClassPK)) {
      return false;
    }
    RegClassPK castOther = (RegClassPK)other;
    return new EqualsBuilder().append(getClassNo(), castOther.getClassNo()).append(getCrsNo(), castOther.getCrsNo()).append(getTermNo(), castOther.getTermNo()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getClassNo()).append(getCrsNo()).append(getTermNo()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.RegClassPK
 * JD-Core Version:    0.7.0.1
 */