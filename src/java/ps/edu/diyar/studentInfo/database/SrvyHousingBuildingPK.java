package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class SrvyHousingBuildingPK
  implements Serializable
{
  private String studId;
  private String termNo;
  private Integer bldngNo;
  
  public SrvyHousingBuildingPK(String studId, String termNo, Integer bldngNo)
  {
    this.studId = studId;
    this.termNo = termNo;
    this.bldngNo = bldngNo;
  }
  
  public SrvyHousingBuildingPK(String studId, String termNo)
  {
    this.studId = studId;
    this.termNo = termNo;
  }
  
  public SrvyHousingBuildingPK() {}
  
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
  
  public Integer getBldngNo()
  {
    return this.bldngNo;
  }
  
  public void setBldngNo(Integer bldngNo)
  {
    this.bldngNo = bldngNo;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("studId", getStudId()).append("termNo", getTermNo()).append("bldngNo", getBldngNo()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof SrvyHousingBuildingPK)) {
      return false;
    }
    SrvyHousingBuildingPK castOther = (SrvyHousingBuildingPK)other;
    return new EqualsBuilder().append(getStudId(), castOther.getStudId()).append(getTermNo(), castOther.getTermNo()).append(getBldngNo(), castOther.getBldngNo()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getStudId()).append(getTermNo()).append(getBldngNo()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.SrvyHousingBuildingPK
 * JD-Core Version:    0.7.0.1
 */