package ps.edu.diyar.studentInfo.forms;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import ps.edu.diyar.common.component.FormCmp;

public class SrvyWorkDetailForm
  extends ActionForm
{
  private String workerType;
  private String isWork;
  private String wrkSector;
  private String wrkOther;
  private String wrkCompany;
  private String wrkJob;
  private String wrkType1;
  private String wrkType2;
  private String wrkAddress;
  private String wrkPhone;
  private String wrkSalary;
  private String wrkReason;
  private boolean editOpperation = false;
  
  public String getWrkType1()
  {
    return this.wrkType1;
  }
  
  public void setWrkType1(String wrkType1)
  {
    this.wrkType1 = wrkType1;
  }
  
  public String getWrkType2()
  {
    return this.wrkType2;
  }
  
  public void setWrkType2(String wrkType2)
  {
    this.wrkType2 = wrkType2;
  }
  
  public String getWorkerType()
  {
    return this.workerType;
  }
  
  public void setWorkerType(String workerType)
  {
    this.workerType = workerType;
  }
  
  public String getIsWork()
  {
    return this.isWork;
  }
  
  public void setIsWork(String work)
  {
    this.isWork = work;
  }
  
  public String getWrkSector()
  {
    return FormCmp.getArabicText(this.editOpperation, this.wrkSector);
  }
  
  public void setWrkSector(String wrkSector)
  {
    this.wrkSector = wrkSector;
  }
  
  public String getWrkOther()
  {
    return FormCmp.getArabicText(this.editOpperation, this.wrkOther);
  }
  
  public void setWrkOther(String wrkOther)
  {
    this.wrkOther = wrkOther;
  }
  
  public String getWrkCompany()
  {
    return FormCmp.getArabicText(this.editOpperation, this.wrkCompany);
  }
  
  public void setWrkCompany(String wrkCompany)
  {
    this.wrkCompany = wrkCompany;
  }
  
  public String getWrkJob()
  {
    return FormCmp.getArabicText(this.editOpperation, this.wrkJob);
  }
  
  public void setWrkJob(String wrkJob)
  {
    this.wrkJob = wrkJob;
  }
  
  public String getWrkAddress()
  {
    return FormCmp.getArabicText(this.editOpperation, this.wrkAddress);
  }
  
  public void setWrkAddress(String wrkAddress)
  {
    this.wrkAddress = wrkAddress;
  }
  
  public String getWrkPhone()
  {
    return this.wrkPhone;
  }
  
  public void setWrkPhone(String wrkPhone)
  {
    this.wrkPhone = wrkPhone;
  }
  
  public String getWrkSalary()
  {
    return this.wrkSalary;
  }
  
  public void setWrkSalary(String wrkSalary)
  {
    this.wrkSalary = wrkSalary;
  }
  
  public String getWrkReason()
  {
    return FormCmp.getArabicText(this.editOpperation, this.wrkReason);
  }
  
  public void setWrkReason(String wrkReason)
  {
    this.wrkReason = wrkReason;
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
    if ((this.wrkSalary != null) && (!FormCmp.isDouble(this.wrkSalary))) {
      errors.add("errorPartFour", new ActionMessage("errors.wrkSalary.format"));
    }
    return errors;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.forms.SrvyWorkDetailForm
 * JD-Core Version:    0.7.0.1
 */