package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class SrvyLoanFamilyPK
  implements Serializable
{
  private String studId;
  private String termNo;
  private Integer fmlyCounter;
  
  public SrvyLoanFamilyPK(String studId, String termNo, Integer fmlyCounter)
  {
    this.studId = studId;
    this.termNo = termNo;
    this.fmlyCounter = fmlyCounter;
  }
  
  public SrvyLoanFamilyPK(String studId, String termNo)
  {
    this.studId = studId;
    this.termNo = termNo;
  }
  
  public SrvyLoanFamilyPK() {}
  
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
  
  public Integer getFmlyCounter()
  {
    return this.fmlyCounter;
  }
  
  public void setFmlyCounter(Integer fmlyCounter)
  {
    this.fmlyCounter = fmlyCounter;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("studId", getStudId()).append("termNo", getTermNo()).append("fmlyCounter", getFmlyCounter()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof SrvyLoanFamilyPK)) {
      return false;
    }
    SrvyLoanFamilyPK castOther = (SrvyLoanFamilyPK)other;
    return new EqualsBuilder().append(getStudId(), castOther.getStudId()).append(getTermNo(), castOther.getTermNo()).append(getFmlyCounter(), castOther.getFmlyCounter()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getStudId()).append(getTermNo()).append(getFmlyCounter()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.SrvyLoanFamilyPK
 * JD-Core Version:    0.7.0.1
 */