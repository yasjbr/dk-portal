package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class SrvyTuitionPK
  implements Serializable
{
  private String studId;
  private String termNo;
  private String tutPayer;
  
  public SrvyTuitionPK(String studId, String termNo, String tutPayer)
  {
    this.studId = studId;
    this.termNo = termNo;
    this.tutPayer = tutPayer;
  }
  
  public String getTutPayer()
  {
    return this.tutPayer;
  }
  
  public void setTutPayer(String tutPayer)
  {
    this.tutPayer = tutPayer;
  }
  
  public SrvyTuitionPK() {}
  
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
    if (!(other instanceof SrvyTuitionPK)) {
      return false;
    }
    SrvyTuitionPK castOther = (SrvyTuitionPK)other;
    return new EqualsBuilder().append(getStudId(), castOther.getStudId()).append(getTermNo(), castOther.getTermNo()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getStudId()).append(getTermNo()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.SrvyTuitionPK
 * JD-Core Version:    0.7.0.1
 */