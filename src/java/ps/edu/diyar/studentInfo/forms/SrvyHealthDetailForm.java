package ps.edu.diyar.studentInfo.forms;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;
import ps.edu.diyar.common.component.FormCmp;

public class SrvyHealthDetailForm
  extends ActionForm
{
  private String familyHasInsurance;
  private String insFamilyMembers;
  private String insuranceType;
  private String familyHasJerusalem;
  private String jerFamilyMembers;
  private String isFamilyHasChronic;
  private String chronicName;
  private FormFile medicalReport;
  private String patientName;
  private String patientAge;
  private String patientRelative;
  private String hasDisabilities;
  private String disabilitiesCount;
  private String disabilitiesDesc;
  private boolean editOpperation = false;
  
  public boolean isEditOpperation()
  {
    return this.editOpperation;
  }
  
  public void setEditOpperation(boolean editOpperation)
  {
    this.editOpperation = editOpperation;
  }
  
  public String getFamilyHasInsurance()
  {
    return this.familyHasInsurance;
  }
  
  public void setFamilyHasInsurance(String familyHasInsurance)
  {
    this.familyHasInsurance = familyHasInsurance;
  }
  
  public String getInsFamilyMembers()
  {
    return this.insFamilyMembers;
  }
  
  public void setInsFamilyMembers(String insFamilyMembers)
  {
    this.insFamilyMembers = insFamilyMembers;
  }
  
  public String getInsuranceType()
  {
    return this.insuranceType;
  }
  
  public void setInsuranceType(String insuranceType)
  {
    this.insuranceType = insuranceType;
  }
  
  public String getFamilyHasJerusalem()
  {
    return this.familyHasJerusalem;
  }
  
  public void setFamilyHasJerusalem(String familyHasJerusalem)
  {
    this.familyHasJerusalem = familyHasJerusalem;
  }
  
  public String getJerFamilyMembers()
  {
    return this.jerFamilyMembers;
  }
  
  public void setJerFamilyMembers(String jerFamilyMembers)
  {
    this.jerFamilyMembers = jerFamilyMembers;
  }
  
  public String getIsFamilyHasChronic()
  {
    return this.isFamilyHasChronic;
  }
  
  public void setIsFamilyHasChronic(String familyHasChronic)
  {
    this.isFamilyHasChronic = familyHasChronic;
  }
  
  public String getChronicName()
  {
    return FormCmp.getArabicText(this.editOpperation, this.chronicName);
  }
  
  public void setChronicName(String chronicName)
  {
    this.chronicName = chronicName;
  }
  
  public FormFile getMedicalReport()
  {
    return this.medicalReport;
  }
  
  public void setMedicalReport(FormFile medicalReport)
  {
    this.medicalReport = medicalReport;
  }
  
  public String getPatientName()
  {
    return FormCmp.getArabicText(this.editOpperation, this.patientName);
  }
  
  public void setPatientName(String patientName)
  {
    this.patientName = patientName;
  }
  
  public String getPatientAge()
  {
    return this.patientAge;
  }
  
  public void setPatientAge(String patientAge)
  {
    this.patientAge = patientAge;
  }
  
  public String getPatientRelative()
  {
    return FormCmp.getArabicText(this.editOpperation, this.patientRelative);
  }
  
  public void setPatientRelative(String patientRelative)
  {
    this.patientRelative = patientRelative;
  }
  
  public String getHasDisabilities()
  {
    return this.hasDisabilities;
  }
  
  public void setHasDisabilities(String hasDisabilities)
  {
    this.hasDisabilities = hasDisabilities;
  }
  
  public String getDisabilitiesCount()
  {
    return this.disabilitiesCount;
  }
  
  public void setDisabilitiesCount(String disabilitiesCount)
  {
    this.disabilitiesCount = disabilitiesCount;
  }
  
  public String getDisabilitiesDesc()
  {
    return FormCmp.getArabicText(this.editOpperation, this.disabilitiesDesc);
  }
  
  public void setDisabilitiesDesc(String disabilitiesDesc)
  {
    this.disabilitiesDesc = disabilitiesDesc;
  }
  
  public ActionErrors validate(ActionMapping mapping, HttpServletRequest req)
  {
    ActionErrors errors = new ActionErrors();
    if (this.medicalReport != null) {
      if (this.medicalReport.getFileSize() > 10000000) {
        errors.add("wrongFileInfo", new ActionMessage("errors.maxLengthExceeded"));
      }
    }
    return errors;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.forms.SrvyHealthDetailForm
 * JD-Core Version:    0.7.0.1
 */