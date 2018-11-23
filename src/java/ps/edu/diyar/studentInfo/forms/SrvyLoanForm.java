package ps.edu.diyar.studentInfo.forms;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import ps.edu.diyar.common.component.FormCmp;

public class SrvyLoanForm
  extends ActionForm
{
  private String applyLoan;
  private String applyReason;
  private String takeLoan;
  private String loanType;
  private String loanPeriod;
  private String loanTermCount;
  private String hasFamilyLoan;
  private String fmlyCounter;
  private String fmlyLoaner;
  private String fmlyType;
  private String fmlyAmount;
  private String fmlyPeriod;
  private String prsnCounter;
  private String prsnLoaner;
  private String prsnAmount;
  private String prsnDate;
  private String tblId;
  private String tblOprType;
  private boolean editOpperation = false;
  
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
    return FormCmp.getArabicText(this.editOpperation, this.applyReason);
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
  
  public String getLoanTermCount()
  {
    return this.loanTermCount;
  }
  
  public void setLoanTermCount(String loanTermCount)
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
  
  public String getFmlyCounter()
  {
    return this.fmlyCounter;
  }
  
  public void setFmlyCounter(String fmlyCounter)
  {
    this.fmlyCounter = fmlyCounter;
  }
  
  public String getFmlyLoaner()
  {
    return FormCmp.getArabicText(this.editOpperation, this.fmlyLoaner);
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
  
  public String getFmlyAmount()
  {
    return this.fmlyAmount;
  }
  
  public void setFmlyAmount(String fmlyAmount)
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
  
  public String getPrsnCounter()
  {
    return this.prsnCounter;
  }
  
  public void setPrsnCounter(String prsnCounter)
  {
    this.prsnCounter = prsnCounter;
  }
  
  public String getPrsnLoaner()
  {
    return FormCmp.getArabicText(this.editOpperation, this.prsnLoaner);
  }
  
  public void setPrsnLoaner(String prsnLoaner)
  {
    this.prsnLoaner = prsnLoaner;
  }
  
  public String getPrsnAmount()
  {
    return this.prsnAmount;
  }
  
  public void setPrsnAmount(String prsnAmount)
  {
    this.prsnAmount = prsnAmount;
  }
  
  public String getPrsnDate()
  {
    return this.prsnDate;
  }
  
  public void setPrsnDate(String prsnDate)
  {
    this.prsnDate = prsnDate;
  }
  
  public String getTblId()
  {
    return this.tblId;
  }
  
  public void setTblId(String tblId)
  {
    this.tblId = tblId;
  }
  
  public String getTblOprType()
  {
    return this.tblOprType;
  }
  
  public void setTblOprType(String tblOprType)
  {
    this.tblOprType = tblOprType;
  }
  
  public boolean isEditOpperation()
  {
    return this.editOpperation;
  }
  
  public void setEditOpperation(boolean editOpperation)
  {
    this.editOpperation = editOpperation;
  }
  
  public ActionErrors validate(ActionMapping mapping, HttpServletRequest req)
  {
    ActionErrors errors = new ActionErrors();
    



    return errors;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.forms.SrvyLoanForm
 * JD-Core Version:    0.7.0.1
 */