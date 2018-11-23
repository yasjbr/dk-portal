package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RegEmpPositionPK
  implements Serializable
{
  private String masterPosNo;
  private String posNo;
  
  public RegEmpPositionPK(String masterPosNo, String posNo)
  {
    this.masterPosNo = masterPosNo;
    this.posNo = posNo;
  }
  
  public RegEmpPositionPK() {}
  
  public String getMasterPosNo()
  {
    return this.masterPosNo;
  }
  
  public void setMasterPosNo(String masterPosNo)
  {
    this.masterPosNo = masterPosNo;
  }
  
  public String getPosNo()
  {
    return this.posNo;
  }
  
  public void setPosNo(String posNo)
  {
    this.posNo = posNo;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("masterPosNo", getMasterPosNo()).append("posNo", getPosNo()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof RegEmpPositionPK)) {
      return false;
    }
    RegEmpPositionPK castOther = (RegEmpPositionPK)other;
    return new EqualsBuilder().append(getMasterPosNo(), castOther.getMasterPosNo()).append(getPosNo(), castOther.getPosNo()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getMasterPosNo()).append(getPosNo()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.RegEmpPositionPK
 * JD-Core Version:    0.7.0.1
 */