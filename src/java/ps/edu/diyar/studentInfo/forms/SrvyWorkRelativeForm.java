package ps.edu.diyar.studentInfo.forms;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import ps.edu.diyar.common.component.FormCmp;

public class SrvyWorkRelativeForm
  extends ActionForm
{
  private String wrlIsLiveIn;
  private String wrlRelativeName;
  private String wrlWorkAddress;
  private String wrlPhone;
  private String wrlJob;
  private String wrlCategory;
  private String wrlSalary;
  private String wrlFamilyContribute;
  private String counter;
  private String operType;
  private boolean editOpperation = false;
  
  public String getWrlIsLiveIn()
  {
    return this.wrlIsLiveIn;
  }
  
  public String getWrlPhone()
  {
    return this.wrlPhone;
  }
  
  public void setWrlPhone(String wrlPhone)
  {
    this.wrlPhone = wrlPhone;
  }
  
  public void setWrlIsLiveIn(String wrlIsLiveIn)
  {
    this.wrlIsLiveIn = wrlIsLiveIn;
  }
  
  public String getCounter()
  {
    return this.counter;
  }
  
  public void setCounter(String counter)
  {
    this.counter = counter;
  }
  
  public String getWrlRelativeName()
  {
    return FormCmp.getArabicText(this.editOpperation, this.wrlRelativeName);
  }
  
  public void setWrlRelativeName(String wrlRelativeName)
  {
    this.wrlRelativeName = wrlRelativeName;
  }
  
  public String getWrlWorkAddress()
  {
    return FormCmp.getArabicText(this.editOpperation, this.wrlWorkAddress);
  }
  
  public void setWrlWorkAddress(String wrlWorkAddress)
  {
    this.wrlWorkAddress = wrlWorkAddress;
  }
  
  public String getWrlJob()
  {
    return FormCmp.getArabicText(this.editOpperation, this.wrlJob);
  }
  
  public void setWrlJob(String wrlJob)
  {
    this.wrlJob = wrlJob;
  }
  
  public String getWrlCategory()
  {
    return FormCmp.getArabicText(this.editOpperation, this.wrlCategory);
  }
  
  public void setWrlCategory(String wrlCategory)
  {
    this.wrlCategory = wrlCategory;
  }
  
  public String getWrlSalary()
  {
    return this.wrlSalary;
  }
  
  public void setWrlSalary(String wrlSalary)
  {
    this.wrlSalary = wrlSalary;
  }
  
  public String getWrlFamilyContribute()
  {
    return this.wrlFamilyContribute;
  }
  
  public void setWrlFamilyContribute(String wrlFamilyContribute)
  {
    this.wrlFamilyContribute = wrlFamilyContribute;
  }
  
  public String getOperType()
  {
    return this.operType;
  }
  
  public void setOperType(String operType)
  {
    this.operType = operType;
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
    if ((this.operType != null) && ((this.operType.equals("1")) || (this.operType.equals("2"))))
    {
      if ((this.wrlSalary != null) && (!this.wrlSalary.trim().equals("")) && (!FormCmp.isDouble(this.wrlSalary))) {
        errors.add("wrlSalary", new ActionMessage("errors.wrkSalary.format"));
      }
      if ((this.wrlFamilyContribute != null) && (!this.wrlFamilyContribute.trim().equals("")) && (!FormCmp.isDouble(this.wrlFamilyContribute))) {
        errors.add("wrlFamilyContribute", new ActionMessage("errors.wrlFamilyContribute.format"));
      }
      if ((this.wrlRelativeName == null) || (this.wrlRelativeName.trim().equals(""))) {
        errors.add("wrlRelativeName", new ActionMessage("errors.name.empty"));
      }
      if ((errors != null) && (errors.size() > 0))
      {
        req.setAttribute("liveIn", this.wrlIsLiveIn);
        req.setAttribute("viDvAdd", (getOperType() != null) && (!getOperType().equals("")) ? getOperType() : "1");
      }
    }
    return errors;
  }
  
  public void reset()
  {
    this.wrlRelativeName = "";
    this.wrlWorkAddress = "";
    this.wrlJob = "";
    this.wrlCategory = "";
    this.wrlSalary = "";
    this.wrlFamilyContribute = "";
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.forms.SrvyWorkRelativeForm
 * JD-Core Version:    0.7.0.1
 */