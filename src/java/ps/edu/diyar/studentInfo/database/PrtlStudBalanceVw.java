package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;

public class PrtlStudBalanceVw
  implements Serializable
{
  private PrtlStudBalanceVwPK comp_id;
  private Double termBalance;
   private Double crBaseAmt;
  
  public PrtlStudBalanceVw(PrtlStudBalanceVwPK comp_id, Double termBalance,Double crBaseAmt)
  {
    this.comp_id = comp_id;
    this.termBalance = termBalance;
    this.crBaseAmt = crBaseAmt;
  }
  
  public PrtlStudBalanceVw() {}
  
  public PrtlStudBalanceVw(PrtlStudBalanceVwPK comp_id)
  {
    this.comp_id = comp_id;
  }
  
  public PrtlStudBalanceVwPK getComp_id()
  {
    return this.comp_id;
  }
  
  public void setComp_id(PrtlStudBalanceVwPK comp_id)
  {
    this.comp_id = comp_id;
  }
  
  public Double getTermBalance()
  {
    return this.termBalance;
  }
  
  public void setTermBalance(Double termBalance)
  {
    this.termBalance = termBalance;
  }

    public Double getCrBaseAmt() {
        return crBaseAmt;
    }

    public void setCrBaseAmt(Double crBaseAmt) {
        this.crBaseAmt = crBaseAmt;
    }
  
  
  
  
  
  public boolean equals(Object o)
  {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    PrtlStudBalanceVw that = (PrtlStudBalanceVw)o;
    if (this.comp_id != null ? !this.comp_id.equals(that.comp_id) : that.comp_id != null) {
      return false;
    }
    if (this.termBalance != null ? !this.termBalance.equals(that.termBalance) : that.termBalance != null) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int result = this.comp_id != null ? this.comp_id.hashCode() : 0;
    result = 31 * result + (this.termBalance != null ? this.termBalance.hashCode() : 0);
    return result;
  }
  
  public String toString()
  {
    return "PrtlStudBalanceVw{comp_id=" + this.comp_id + ", termBalance=" + this.termBalance + '}';
  }
}



/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\

 * Qualified Name:     ps.edu.diyar.studentInfo.database.PrtlStudBalanceVw

 * JD-Core Version:    0.7.0.1

 */