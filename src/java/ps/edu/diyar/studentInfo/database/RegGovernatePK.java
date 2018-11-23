package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RegGovernatePK
  implements Serializable
{
  private String countryNo;
  private String govNo;
  
  public RegGovernatePK(String countryNo, String govNo)
  {
    this.countryNo = countryNo;
    this.govNo = govNo;
  }
  
  public RegGovernatePK() {}
  
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
  
  public String toString()
  {
    return new ToStringBuilder(this).append("countryNo", getCountryNo()).append("govNo", getGovNo()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof RegGovernatePK)) {
      return false;
    }
    RegGovernatePK castOther = (RegGovernatePK)other;
    return new EqualsBuilder().append(getCountryNo(), castOther.getCountryNo()).append(getGovNo(), castOther.getGovNo()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getCountryNo()).append(getGovNo()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.RegGovernatePK
 * JD-Core Version:    0.7.0.1
 */