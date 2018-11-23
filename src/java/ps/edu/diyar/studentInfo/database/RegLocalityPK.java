package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RegLocalityPK
  implements Serializable
{
  private String countryNo;
  private String govNo;
  private String localityNo;
  
  public RegLocalityPK(String countryNo, String govNo, String localityNo)
  {
    this.countryNo = countryNo;
    this.govNo = govNo;
    this.localityNo = localityNo;
  }
  
  public RegLocalityPK() {}
  
  public String getCountryNo()
  {
    return this.countryNo;
  }
  
  public void setCountryNo(String countryNo)
  {
    this.countryNo = countryNo;
  }
  
  public String getGovNo()
  {
    return this.govNo;
  }
  
  public void setGovNo(String govNo)
  {
    this.govNo = govNo;
  }
  
  public String getLocalityNo()
  {
    return this.localityNo;
  }
  
  public void setLocalityNo(String localityNo)
  {
    this.localityNo = localityNo;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("countryNo", getCountryNo()).append("govNo", getGovNo()).append("localityNo", getLocalityNo()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof RegLocalityPK)) {
      return false;
    }
    RegLocalityPK castOther = (RegLocalityPK)other;
    return new EqualsBuilder().append(getCountryNo(), castOther.getCountryNo()).append(getGovNo(), castOther.getGovNo()).append(getLocalityNo(), castOther.getLocalityNo()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getCountryNo()).append(getGovNo()).append(getLocalityNo()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.RegLocalityPK
 * JD-Core Version:    0.7.0.1
 */