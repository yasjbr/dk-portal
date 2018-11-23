package ps.edu.diyar.studentInfo.database;

public class PrtlRepFinancialStudVw
{
  private PrtlRepFinancialStudVwPK comp_id;
  private String finDesc;
  private String crncyCode;
  private Double crncyRate;
  private Double amount;
  private Double amountDisplay;
  private Double baseAmountDisplay;
  
  public PrtlRepFinancialStudVwPK getComp_id()
  {
    return this.comp_id;
  }
  
  public void setComp_id(PrtlRepFinancialStudVwPK comp_id)
  {
    this.comp_id = comp_id;
  }
  
  public String getFinDesc()
  {
    return this.finDesc;
  }
  
  public void setFinDesc(String finDesc)
  {
    this.finDesc = finDesc;
  }
  
  public String getCrncyCode()
  {
    return this.crncyCode;
  }
  
  public void setCrncyCode(String crncyCode)
  {
    this.crncyCode = crncyCode;
  }
  
  public Double getCrncyRate()
  {
    return this.crncyRate;
  }
  
  public void setCrncyRate(Double crncyRate)
  {
    this.crncyRate = crncyRate;
  }
  
  public Double getAmount()
  {
    return this.amount;
  }
  
  public void setAmount(Double amount)
  {
    this.amount = amount;
  }
  
  public Double getAmountDisplay()
  {
    return this.amountDisplay;
  }
  
  public void setAmountDisplay(Double amountDisplay)
  {
    this.amountDisplay = amountDisplay;
  }
  
  public Double getBaseAmountDisplay()
  {
    return this.baseAmountDisplay;
  }
  
  public void setBaseAmountDisplay(Double baseAmountDisplay)
  {
    this.baseAmountDisplay = baseAmountDisplay;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.PrtlRepFinancialStudVw
 * JD-Core Version:    0.7.0.1
 */