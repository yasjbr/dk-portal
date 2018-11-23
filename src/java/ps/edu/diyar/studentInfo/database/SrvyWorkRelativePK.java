package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class SrvyWorkRelativePK
  implements Serializable
{
  private String studId;
  private String termNo;
  private Long counter;
  
  public SrvyWorkRelativePK(String studId, String termNo, Long counter)
  {
    this.studId = studId;
    this.termNo = termNo;
    this.counter = counter;
  }
  
  public SrvyWorkRelativePK(String studId, String termNo)
  {
    this.studId = studId;
    this.termNo = termNo;
    this.counter = this.counter;
  }
  
  public SrvyWorkRelativePK() {}
  
  public String getStudId()
  {
    return this.studId;
  }
  
  public void setStudId(String studId)
  {
    this.studId = studId;
  }
  
  public String getTermNo()
  {
    return this.termNo;
  }
  
  public void setTermNo(String termNo)
  {
    this.termNo = termNo;
  }
  
  public Long getCounter()
  {
    return this.counter;
  }
  
  public void setCounter(Long counter)
  {
    this.counter = counter;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("studId", getStudId()).append("termNo", getTermNo()).append("counter", getCounter()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof SrvyWorkRelativePK)) {
      return false;
    }
    SrvyWorkRelativePK castOther = (SrvyWorkRelativePK)other;
    return new EqualsBuilder().append(getStudId(), castOther.getStudId()).append(getTermNo(), castOther.getTermNo()).append(getCounter(), castOther.getCounter()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getStudId()).append(getTermNo()).append(getCounter()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.SrvyWorkRelativePK
 * JD-Core Version:    0.7.0.1
 */