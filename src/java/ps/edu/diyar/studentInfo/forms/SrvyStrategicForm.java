package ps.edu.diyar.studentInfo.forms;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import ps.edu.diyar.common.component.FormCmp;

public class SrvyStrategicForm
  extends ActionForm
{
  private String stgcHasLoan;
  private String stgcSource;
  private String stgcFamily;
  private String stgcOutsideHelp;
  private String stgcAffairs;
  private String stgcCaseNo;
  private String stgcUnrwa;
  private String stgcUnrwaNo;
  private String stgcOther;
  private boolean editOpperation = false;
  
  public String getStgcHasLoan()
  {
    return this.stgcHasLoan;
  }
  
  public void setStgcHasLoan(String stgcHasLoan)
  {
    this.stgcHasLoan = stgcHasLoan;
  }
  
  public String getStgcSource()
  {
    return FormCmp.getArabicText(this.editOpperation, this.stgcSource);
  }
  
  public void setStgcSource(String stgcSource)
  {
    this.stgcSource = stgcSource;
  }
  
  public String getStgcFamily()
  {
    return this.stgcFamily;
  }
  
  public void setStgcFamily(String stgcFamily)
  {
    this.stgcFamily = stgcFamily;
  }
  
  public String getStgcOutsideHelp()
  {
    return this.stgcOutsideHelp;
  }
  
  public void setStgcOutsideHelp(String stgcOutsideHelp)
  {
    this.stgcOutsideHelp = stgcOutsideHelp;
  }
  
  public String getStgcAffairs()
  {
    return this.stgcAffairs;
  }
  
  public void setStgcAffairs(String stgcAffairs)
  {
    this.stgcAffairs = stgcAffairs;
  }
  
  public String getStgcCaseNo()
  {
    return this.stgcCaseNo;
  }
  
  public void setStgcCaseNo(String stgcCaseNo)
  {
    this.stgcCaseNo = stgcCaseNo;
  }
  
  public String getStgcUnrwa()
  {
    return this.stgcUnrwa;
  }
  
  public void setStgcUnrwa(String stgcUnrwa)
  {
    this.stgcUnrwa = stgcUnrwa;
  }
  
  public String getStgcUnrwaNo()
  {
    return this.stgcUnrwaNo;
  }
  
  public void setStgcUnrwaNo(String stgcUnrwaNo)
  {
    this.stgcUnrwaNo = stgcUnrwaNo;
  }
  
  public String getStgcOther()
  {
    return FormCmp.getArabicText(this.editOpperation, this.stgcOther);
  }
  
  public void setStgcOther(String stgcOther)
  {
    this.stgcOther = stgcOther;
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
 * Qualified Name:     ps.edu.diyar.studentInfo.forms.SrvyStrategicForm
 * JD-Core Version:    0.7.0.1
 */