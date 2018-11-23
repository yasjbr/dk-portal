package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class SasStudFtermCardPK
  implements Serializable
{
  private String studId;
  private String termNo;
  
  public SasStudFtermCardPK(String studId, String termNo)
  {
    this.studId = studId;
    this.termNo = termNo;
  }
  
  public SasStudFtermCardPK() {}
  
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
  
  public String toString()
  {
    return new ToStringBuilder(this).append("studId", getStudId()).append("termNo", getTermNo()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof SasStudFtermCardPK)) {
      return false;
    }
    SasStudFtermCardPK castOther = (SasStudFtermCardPK)other;
    return new EqualsBuilder().append(getStudId(), castOther.getStudId()).append(getTermNo(), castOther.getTermNo()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getStudId()).append(getTermNo()).toHashCode();
  }
}

