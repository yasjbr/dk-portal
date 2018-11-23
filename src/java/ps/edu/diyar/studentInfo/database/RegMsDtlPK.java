package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RegMsDtlPK
  implements Serializable
{
  private String specNo;
  private String msNo;
  private String msCrsType;
  private String crsNo;
  
  public RegMsDtlPK(String specNo, String msNo, String msCrsType, String crsNo)
  {
    this.specNo = specNo;
    this.msNo = msNo;
    this.msCrsType = msCrsType;
    this.crsNo = crsNo;
  }
  
  public RegMsDtlPK() {}
  
  public String getSpecNo()
  {
    return this.specNo;
  }
  
  public void setSpecNo(String specNo)
  {
    this.specNo = specNo;
  }
  
  public String getMsNo()
  {
    return this.msNo;
  }
  
  public void setMsNo(String msNo)
  {
    this.msNo = msNo;
  }
  
  public String getMsCrsType()
  {
    return this.msCrsType;
  }
  
  public void setMsCrsType(String msCrsType)
  {
    this.msCrsType = msCrsType;
  }
  
  public String getCrsNo()
  {
    return this.crsNo;
  }
  
  public void setCrsNo(String crsNo)
  {
    this.crsNo = crsNo;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("specNo", getSpecNo()).append("msNo", getMsNo()).append("msCrsType", getMsCrsType()).append("crsNo", getCrsNo()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof RegMsDtlPK)) {
      return false;
    }
    RegMsDtlPK castOther = (RegMsDtlPK)other;
    return new EqualsBuilder().append(getSpecNo(), castOther.getSpecNo()).append(getMsNo(), castOther.getMsNo()).append(getMsCrsType(), castOther.getMsCrsType()).append(getCrsNo(), castOther.getCrsNo()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getSpecNo()).append(getMsNo()).append(getMsCrsType()).append(getCrsNo()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.RegMsDtlPK
 * JD-Core Version:    0.7.0.1
 */