package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class SrvyHousingLandPK
  implements Serializable
{
  private String studId;
  private String termNo;
  private Integer landCount;
  
  public SrvyHousingLandPK(String studId, String termNo, Integer landCount)
  {
    this.studId = studId;
    this.termNo = termNo;
    this.landCount = landCount;
  }
  
  public SrvyHousingLandPK(String studId, String termNo)
  {
    this.studId = studId;
    this.termNo = termNo;
  }
  
  public SrvyHousingLandPK() {}
  
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
  
  public Integer getLandCount()
  {
    return this.landCount;
  }
  
  public void setLandCount(Integer landCount)
  {
    this.landCount = landCount;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("studId", getStudId()).append("termNo", getTermNo()).append("landCount", getLandCount()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof SrvyHousingLandPK)) {
      return false;
    }
    SrvyHousingLandPK castOther = (SrvyHousingLandPK)other;
    return new EqualsBuilder().append(getStudId(), castOther.getStudId()).append(getTermNo(), castOther.getTermNo()).append(getLandCount(), castOther.getLandCount()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getStudId()).append(getTermNo()).append(getLandCount()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.SrvyHousingLandPK
 * JD-Core Version:    0.7.0.1
 */