package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class SrvyLoanPersonal
  implements Serializable
{
  private SrvyLoanPersonalPK comp_id;
  private String prsnLoaner;
  private Double prsnAmount;
  private Date prsnDate;
  
  public SrvyLoanPersonal(SrvyLoanPersonalPK comp_id, String prsnLoaner, Double prsnAmount, Date prsnDate)
  {
    this.comp_id = comp_id;
    this.prsnLoaner = prsnLoaner;
    this.prsnAmount = prsnAmount;
    this.prsnDate = prsnDate;
  }
  
  public SrvyLoanPersonal() {}
  
  public SrvyLoanPersonal(SrvyLoanPersonalPK comp_id)
  {
    this.comp_id = comp_id;
  }
  
  public SrvyLoanPersonalPK getComp_id()
  {
    return this.comp_id;
  }
  
  public void setComp_id(SrvyLoanPersonalPK comp_id)
  {
    this.comp_id = comp_id;
  }
  
  public String getPrsnLoaner()
  {
    return this.prsnLoaner;
  }
  
  public void setPrsnLoaner(String prsnLoaner)
  {
    this.prsnLoaner = prsnLoaner;
  }
  
  public Double getPrsnAmount()
  {
    return this.prsnAmount;
  }
  
  public void setPrsnAmount(Double prsnAmount)
  {
    this.prsnAmount = prsnAmount;
  }
  
  public Date getPrsnDate()
  {
    return this.prsnDate;
  }
  
  public void setPrsnDate(Date prsnDate)
  {
    this.prsnDate = prsnDate;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("comp_id", getComp_id()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof SrvyLoanPersonal)) {
      return false;
    }
    SrvyLoanPersonal castOther = (SrvyLoanPersonal)other;
    return new EqualsBuilder().append(getComp_id(), castOther.getComp_id()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getComp_id()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.SrvyLoanPersonal
 * JD-Core Version:    0.7.0.1
 */