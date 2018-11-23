package ps.edu.diyar.studentInfo.database;

import java.util.Date;

public class PrtlRepInstallmentStudVw
{
  private PrtlRepInstallmentStudVwPK comp_id;
  private Integer instRownum;
  private Double dbAmt;
  private Double firstPay;
  private Double instValue;
  private Date dueDate;
  
  public PrtlRepInstallmentStudVwPK getComp_id()
  {
    return this.comp_id;
  }
  
  public void setComp_id(PrtlRepInstallmentStudVwPK comp_id)
  {
    this.comp_id = comp_id;
  }
  
  public Integer getInstRownum()
  {
    return this.instRownum;
  }
  
  public void setInstRownum(Integer instRownum)
  {
    this.instRownum = instRownum;
  }
  
  public Double getDbAmt()
  {
    return this.dbAmt;
  }
  
  public void setDbAmt(Double dbAmt)
  {
    this.dbAmt = dbAmt;
  }
  
  public Double getFirstPay()
  {
    return this.firstPay;
  }
  
  public void setFirstPay(Double firstPay)
  {
    this.firstPay = firstPay;
  }
  
  public Double getInstValue()
  {
    return this.instValue;
  }
  
  public void setInstValue(Double instValue)
  {
    this.instValue = instValue;
  }
  
  public Date getDueDate()
  {
    return this.dueDate;
  }
  
  public void setDueDate(Date dueDate)
  {
    this.dueDate = dueDate;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.PrtlRepInstallmentStudVw
 * JD-Core Version:    0.7.0.1
 */