package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class SrvyLoan
  implements Serializable
{
  private SrvyLoanPK comp_id;
  private String applyLoan;
  private String applyReason;
  private String takeLoan;
  private String loanType;
  private String loanPeriod;
  private Integer loanTermCount;
  private String hasFamilyLoan;
  
  public SrvyLoan(SrvyLoanPK comp_id, String applyLoan, String applyReason, String takeLoan, String loanType, String loanPeriod, Integer loanTermCount, String hasFamilyLoan)
  {
    this.comp_id = comp_id;
    this.applyLoan = applyLoan;
    this.applyReason = applyReason;
    this.takeLoan = takeLoan;
    this.loanType = loanType;
    this.loanPeriod = loanPeriod;
    this.loanTermCount = loanTermCount;
    this.hasFamilyLoan = hasFamilyLoan;
  }
  
  public SrvyLoan() {}
  
  public SrvyLoan(SrvyLoanPK comp_id)
  {
    this.comp_id = comp_id;
  }
  
  public SrvyLoanPK getComp_id()
  {
    return this.comp_id;
  }
  
  public void setComp_id(SrvyLoanPK comp_id)
  {
    this.comp_id = comp_id;
  }
  
  public String getApplyLoan()
  {
    return this.applyLoan;
  }
  
  public void setApplyLoan(String applyLoan)
  {
    this.applyLoan = applyLoan;
  }
  
  public String getApplyReason()
  {
    return this.applyReason;
  }
  
  public void setApplyReason(String applyReason)
  {
    this.applyReason = applyReason;
  }
  
  public String getTakeLoan()
  {
    return this.takeLoan;
  }
  
  public void setTakeLoan(String takeLoan)
  {
    this.takeLoan = takeLoan;
  }
  
  public String getLoanType()
  {
    return this.loanType;
  }
  
  public void setLoanType(String loanType)
  {
    this.loanType = loanType;
  }
  
  public String getLoanPeriod()
  {
    return this.loanPeriod;
  }
  
  public void setLoanPeriod(String loanPeriod)
  {
    this.loanPeriod = loanPeriod;
  }
  
  public Integer getLoanTermCount()
  {
    return this.loanTermCount;
  }
  
  public void setLoanTermCount(Integer loanTermCount)
  {
    this.loanTermCount = loanTermCount;
  }
  
  public String getHasFamilyLoan()
  {
    return this.hasFamilyLoan;
  }
  
  public void setHasFamilyLoan(String hasFamilyLoan)
  {
    this.hasFamilyLoan = hasFamilyLoan;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("comp_id", getComp_id()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof SrvyLoan)) {
      return false;
    }
    SrvyLoan castOther = (SrvyLoan)other;
    return new EqualsBuilder().append(getComp_id(), castOther.getComp_id()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getComp_id()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.SrvyLoan
 * JD-Core Version:    0.7.0.1
 */