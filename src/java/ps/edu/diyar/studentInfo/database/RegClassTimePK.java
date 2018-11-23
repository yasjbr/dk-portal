package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RegClassTimePK
  implements Serializable
{
  private Integer counter;
  private String classNo;
  private String crsNo;
  private String termNo;
  
  public RegClassTimePK(Integer counter, String classNo, String crsNo, String termNo)
  {
    this.counter = counter;
    this.classNo = classNo;
    this.crsNo = crsNo;
    this.termNo = termNo;
  }
  
  public RegClassTimePK() {}
  
  public Integer getCounter()
  {
    return this.counter;
  }
  
  public void setCounter(Integer counter)
  {
    this.counter = counter;
  }
  
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
    return new ToStringBuilder(this).append("counter", getCounter()).append("classNo", getClassNo()).append("crsNo", getCrsNo()).append("termNo", getTermNo()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof RegClassTimePK)) {
      return false;
    }
    RegClassTimePK castOther = (RegClassTimePK)other;
    return new EqualsBuilder().append(getCounter(), castOther.getCounter()).append(getClassNo(), castOther.getClassNo()).append(getCrsNo(), castOther.getCrsNo()).append(getTermNo(), castOther.getTermNo()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getCounter()).append(getClassNo()).append(getCrsNo()).append(getTermNo()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.RegClassTimePK
 * JD-Core Version:    0.7.0.1
 */