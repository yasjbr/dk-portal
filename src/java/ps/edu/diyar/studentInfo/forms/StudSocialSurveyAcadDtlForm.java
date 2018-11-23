package ps.edu.diyar.studentInfo.forms;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import ps.edu.diyar.common.component.FormCmp;

public class StudSocialSurveyAcadDtlForm
  extends ActionForm
{
  private String relativeType;
  private String relativeAName;
  private String enroleDate;
  private String countryNo;
  private String collegeNo;
  private String yearlyCost;
  private String donarAName;
  private String relativeStudNo;
  private String schoolNo;
  private String schoolType;
  private String operType;
  private String academicSeq;
  private boolean editOpperation = false;
  
  public String getOperType()
  {
    return this.operType;
  }
  
  public void setOperType(String operType)
  {
    this.operType = operType;
  }
  
  public String getAcademicSeq()
  {
    return this.academicSeq;
  }
  
  public void setAcademicSeq(String academicSeq)
  {
    this.academicSeq = academicSeq;
  }
  
  public boolean isEditOpperation()
  {
    return this.editOpperation;
  }
  
  public void setEditOpperation(boolean editOpperation)
  {
    this.editOpperation = editOpperation;
  }
  
  public String getCountryNo()
  {
    return this.countryNo;
  }
  
  public void setCountryNo(String countryNo)
  {
    this.countryNo = countryNo;
  }
  
  public String getRelativeType()
  {
    return this.relativeType;
  }
  
  public void setRelativeType(String relativeType)
  {
    this.relativeType = relativeType;
  }
  
  public String getRelativeAName()
  {
    return FormCmp.getArabicText(this.editOpperation, this.relativeAName);
  }
  
  public void setRelativeAName(String relativeAName)
  {
    this.relativeAName = relativeAName;
  }
  
  public String getCollegeNo()
  {
    return this.collegeNo;
  }
  
  public void setCollegeNo(String collegeNo)
  {
    this.collegeNo = collegeNo;
  }
  
  public String getEnroleDate()
  {
    return this.enroleDate;
  }
  
  public void setEnroleDate(String enroleDate)
  {
    this.enroleDate = enroleDate;
  }
  
  public String getYearlyCost()
  {
    return this.yearlyCost;
  }
  
  public void setYearlyCost(String yearlyCost)
  {
    this.yearlyCost = yearlyCost;
  }
  
  public String getDonarAName()
  {
    return FormCmp.getArabicText(this.editOpperation, this.donarAName);
  }
  
  public void setDonarAName(String donarAName)
  {
    this.donarAName = donarAName;
  }
  
  public String getRelativeStudNo()
  {
    return this.relativeStudNo;
  }
  
  public void setRelativeStudNo(String relativeStudNo)
  {
    this.relativeStudNo = relativeStudNo;
  }
  
  public String getSchoolNo()
  {
    return this.schoolNo;
  }
  
  public void setSchoolNo(String schoolNo)
  {
    this.schoolNo = schoolNo;
  }
  
  public String getSchoolType()
  {
    return this.schoolType;
  }
  
  public void setSchoolType(String schoolType)
  {
    this.schoolType = schoolType;
  }
  
  public ActionErrors validate(ActionMapping mapping, HttpServletRequest req)
  {
    ActionErrors errors = new ActionErrors();
    if ((this.relativeType != null) && (this.relativeType.equals("1")))
    {
      if ((this.yearlyCost != null) && (!this.yearlyCost.trim().equals("")) && (!FormCmp.isDouble(this.yearlyCost))) {
        errors.add("yearlyCost", new ActionMessage("errors.yearlyCost.format"));
      }
      if ((this.relativeAName == null) || (this.relativeAName.trim().equals(""))) {
        errors.add("relativeAName", new ActionMessage("errors.name.empty"));
      }
    }
    if ((errors != null) && (errors.size() > 0)) {
      req.setAttribute("viDvAdd", (getOperType() != null) && (!getOperType().equals("")) ? getOperType() : "1");
    }
    return errors;
  }
  
  public void reset()
  {
    this.relativeType = "";
    this.relativeAName = "";
    this.enroleDate = "";
    this.countryNo = "";
    this.collegeNo = "";
    this.yearlyCost = "";
    this.donarAName = "";
    this.relativeStudNo = "";
    this.schoolNo = "";
    this.schoolType = "";
    
    this.editOpperation = false;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.forms.StudSocialSurveyAcadDtlForm
 * JD-Core Version:    0.7.0.1
 */