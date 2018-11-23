package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class SrvyWorkTypeDtlPK
  implements Serializable
{
  private String studId;
  private String termNo;
  private String wrkType;
  private String typeCode;
  
  public SrvyWorkTypeDtlPK(String studId, String termNo, String wrkType, String typeCode)
  {
    this.studId = studId;
    this.termNo = termNo;
    this.wrkType = wrkType;
    this.typeCode = typeCode;
  }
  
  public SrvyWorkTypeDtlPK() {}
  
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
  
  public String getWrkType()
  {
    return this.wrkType;
  }
  
  public void setWrkType(String wrkType)
  {
    this.wrkType = wrkType;
  }
  
  public String getTypeCode()
  {
    return this.typeCode;
  }
  
  public void setTypeCode(String typeCode)
  {
    this.typeCode = typeCode;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("studId", getStudId()).append("termNo", getTermNo()).append("wrkType", getWrkType()).append("typeCode", getTypeCode()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof SrvyWorkTypeDtlPK)) {
      return false;
    }
    SrvyWorkTypeDtlPK castOther = (SrvyWorkTypeDtlPK)other;
    return new EqualsBuilder().append(getStudId(), castOther.getStudId()).append(getTermNo(), castOther.getTermNo()).append(getWrkType(), castOther.getWrkType()).append(getTypeCode(), castOther.getTypeCode()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getStudId()).append(getTermNo()).append(getWrkType()).append(getTypeCode()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.SrvyWorkTypeDtlPK
 * JD-Core Version:    0.7.0.1
 */