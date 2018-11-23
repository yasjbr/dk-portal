package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class SrvyLoanPersonalPK
  implements Serializable
{
  private String studId;
  private String termNo;
  private Integer prsnCounter;
  
  public SrvyLoanPersonalPK(String studId, String termNo, Integer prsnCounter)
  {
    this.studId = studId;
    this.termNo = termNo;
    this.prsnCounter = prsnCounter;
  }
  
  public SrvyLoanPersonalPK(String studId, String termNo)
  {
    this.studId = studId;
    this.termNo = termNo;
  }
  
  public SrvyLoanPersonalPK() {}
  
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
  
  public Integer getPrsnCounter()
  {
    return this.prsnCounter;
  }
  
  public void setPrsnCounter(Integer prsnCounter)
  {
    this.prsnCounter = prsnCounter;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("studId", getStudId()).append("termNo", getTermNo()).append("prsnCounter", getPrsnCounter()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof SrvyLoanPersonalPK)) {
      return false;
    }
    SrvyLoanPersonalPK castOther = (SrvyLoanPersonalPK)other;
    return new EqualsBuilder().append(getStudId(), castOther.getStudId()).append(getTermNo(), castOther.getTermNo()).append(getPrsnCounter(), castOther.getPrsnCounter()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getStudId()).append(getTermNo()).append(getPrsnCounter()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.SrvyLoanPersonalPK
 * JD-Core Version:    0.7.0.1
 */