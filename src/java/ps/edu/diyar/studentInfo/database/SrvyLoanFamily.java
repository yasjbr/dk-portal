package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class SrvyLoanFamily
  implements Serializable
{
  private SrvyLoanFamilyPK comp_id;
  private String fmlyLoaner;
  private String fmlyType;
  private Double fmlyAmount;
  private String fmlyPeriod;
  
  public SrvyLoanFamily(SrvyLoanFamilyPK comp_id, String fmlyLoaner, String fmlyType, Double fmlyAmount, String fmlyPeriod)
  {
    this.comp_id = comp_id;
    this.fmlyLoaner = fmlyLoaner;
    this.fmlyType = fmlyType;
    this.fmlyAmount = fmlyAmount;
    this.fmlyPeriod = fmlyPeriod;
  }
  
  public SrvyLoanFamily() {}
  
  public SrvyLoanFamily(SrvyLoanFamilyPK comp_id)
  {
    this.comp_id = comp_id;
  }
  
  public SrvyLoanFamilyPK getComp_id()
  {
    return this.comp_id;
  }
  
  public void setComp_id(SrvyLoanFamilyPK comp_id)
  {
    this.comp_id = comp_id;
  }
  
  public String getFmlyLoaner()
  {
    return this.fmlyLoaner;
  }
  
  public void setFmlyLoaner(String fmlyLoaner)
  {
    this.fmlyLoaner = fmlyLoaner;
  }
  
  public String getFmlyType()
  {
    return this.fmlyType;
  }
  
  public void setFmlyType(String fmlyType)
  {
    this.fmlyType = fmlyType;
  }
  
  public Double getFmlyAmount()
  {
    return this.fmlyAmount;
  }
  
  public void setFmlyAmount(Double fmlyAmount)
  {
    this.fmlyAmount = fmlyAmount;
  }
  
  public String getFmlyPeriod()
  {
    return this.fmlyPeriod;
  }
  
  public void setFmlyPeriod(String fmlyPeriod)
  {
    this.fmlyPeriod = fmlyPeriod;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("comp_id", getComp_id()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof SrvyLoanFamily)) {
      return false;
    }
    SrvyLoanFamily castOther = (SrvyLoanFamily)other;
    return new EqualsBuilder().append(getComp_id(), castOther.getComp_id()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getComp_id()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.SrvyLoanFamily
 * JD-Core Version:    0.7.0.1
 */