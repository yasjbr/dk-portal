package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class SrvyHousingCarPK
  implements Serializable
{
  private String studId;
  private String termNo;
  private Integer carNo;
  
  public SrvyHousingCarPK(String studId, String termNo, Integer carNo)
  {
    this.studId = studId;
    this.termNo = termNo;
    this.carNo = carNo;
  }
  
  public SrvyHousingCarPK(String studId, String termNo)
  {
    this.studId = studId;
    this.termNo = termNo;
  }
  
  public SrvyHousingCarPK() {}
  
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
  
  public Integer getCarNo()
  {
    return this.carNo;
  }
  
  public void setCarNo(Integer carNo)
  {
    this.carNo = carNo;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("studId", getStudId()).append("termNo", getTermNo()).append("carNo", getCarNo()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof SrvyHousingCarPK)) {
      return false;
    }
    SrvyHousingCarPK castOther = (SrvyHousingCarPK)other;
    return new EqualsBuilder().append(getStudId(), castOther.getStudId()).append(getTermNo(), castOther.getTermNo()).append(getCarNo(), castOther.getCarNo()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getStudId()).append(getTermNo()).append(getCarNo()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.SrvyHousingCarPK
 * JD-Core Version:    0.7.0.1
 */