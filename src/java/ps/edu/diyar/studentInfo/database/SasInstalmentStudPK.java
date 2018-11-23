package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class SasInstalmentStudPK
  implements Serializable
{
  private String studId;
  private String termNo;
  private String instCode;
  
  public SasInstalmentStudPK(String studId, String termNo, String instCode)
  {
    this.studId = studId;
    this.termNo = termNo;
    this.instCode = instCode;
  }
  
  public SasInstalmentStudPK() {}
  
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
  
  public String getInstCode()
  {
    return this.instCode;
  }
  
  public void setInstCode(String instCode)
  {
    this.instCode = instCode;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("studId", getStudId()).append("termNo", getTermNo()).append("instCode", getInstCode()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof SasInstalmentStudPK)) {
      return false;
    }
    SasInstalmentStudPK castOther = (SasInstalmentStudPK)other;
    return new EqualsBuilder().append(getStudId(), castOther.getStudId()).append(getTermNo(), castOther.getTermNo()).append(getInstCode(), castOther.getInstCode()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getStudId()).append(getTermNo()).append(getInstCode()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.SasInstalmentStudPK
 * JD-Core Version:    0.7.0.1
 */