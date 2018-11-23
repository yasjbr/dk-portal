package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RegWarnSettingPK
  implements Serializable
{
  private String specType;
  private String termNo;
  
  public RegWarnSettingPK(String specType, String termNo)
  {
    this.specType = specType;
    this.termNo = termNo;
  }
  
  public RegWarnSettingPK() {}
  
  public String getSpecType()
  {
    return this.specType;
  }
  
  public void setSpecType(String specType)
  {
    this.specType = specType;
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
    return new ToStringBuilder(this).append("specType", getSpecType()).append("termNo", getTermNo()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof RegWarnSettingPK)) {
      return false;
    }
    RegWarnSettingPK castOther = (RegWarnSettingPK)other;
    return new EqualsBuilder().append(getSpecType(), castOther.getSpecType()).append(getTermNo(), castOther.getTermNo()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getSpecType()).append(getTermNo()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.RegWarnSettingPK
 * JD-Core Version:    0.7.0.1
 */