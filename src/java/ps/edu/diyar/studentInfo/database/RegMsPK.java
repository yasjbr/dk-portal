package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RegMsPK
  implements Serializable
{
  private String specNo;
  private String msNo;
  private String msCrsType;
  
  public RegMsPK(String specNo, String msNo, String msCrsType)
  {
    this.specNo = specNo;
    this.msNo = msNo;
    this.msCrsType = msCrsType;
  }
  
  public RegMsPK() {}
  
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
  
  public String toString()
  {
    return new ToStringBuilder(this).append("specNo", getSpecNo()).append("msNo", getMsNo()).append("msCrsType", getMsCrsType()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof RegMsPK)) {
      return false;
    }
    RegMsPK castOther = (RegMsPK)other;
    return new EqualsBuilder().append(getSpecNo(), castOther.getSpecNo()).append(getMsNo(), castOther.getMsNo()).append(getMsCrsType(), castOther.getMsCrsType()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getSpecNo()).append(getMsNo()).append(getMsCrsType()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.RegMsPK
 * JD-Core Version:    0.7.0.1
 */