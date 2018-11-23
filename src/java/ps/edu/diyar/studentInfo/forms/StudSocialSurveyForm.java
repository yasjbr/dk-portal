package ps.edu.diyar.studentInfo.forms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import ps.edu.diyar.common.component.FormCmp;
import ps.edu.diyar.studentInfo.database.struct.StudentInfoHolder;
import ps.edu.diyar.studentInfo.useCase.ViewStudSocialSurveyUseCase;

public class StudSocialSurveyForm
  extends ActionForm
{
  private String studId;
  private String perCountry;
  private String perGovernate;
  private String perLocality;
  private String currCountry;
  private String currGovernate;
  private String currLocality;
  private String birthCountry;
  private String birthLocality;
  private String birthGovernate;
  private String fatherAName;
  private String fatherIdCardType;
  private String fatherIdCard;
  private String fatherDob;
  private String fatherAcademicLevel;
  private String motherAName;
  private String motherIdCardType;
  private String motherIdCard;
  private String motherDob;
  private String motherAcademicLevel;
  private String familyCountAll;
  private String familyCountUnder18;
  private String brothersCount;
  private String sistersCount;
  private String otherMaleCount;
  private String otherFemaleCount;
  private String wifeOneAName;
  private String wifeOneDob;
  private String wifeOneIdCardType;
  private String wifeOneIdCard;
  private String wifeOneAcadmicLevel;
  private String childrenCount;
  private String otherAcademicExpensive;
  private String otherAcademicCost;
  private String haveOtherWork;
  private String otherWork;
  private String otherWorkCrossIncome;
  private String familyIncome;
  private String familyUnemployed;
  private String unemployedResons;
  private String[] payer;
  private String otherPayer;
  private boolean isEdit = false;
  
  public String[] getPayer()
  {
    return this.payer;
  }
  
  public void setPayer(String[] payer)
  {
    this.payer = payer;
  }
  
  public String getOtherPayer()
  {
    return FormCmp.getArabicText(this.isEdit, this.otherPayer);
  }
  
  public void setOtherPayer(String otherPayer)
  {
    this.otherPayer = otherPayer;
  }
  
  public String getOtherWorkCrossIncome()
  {
    return this.otherWorkCrossIncome;
  }
  
  public void setOtherWorkCrossIncome(String otherWorkCrossIncome)
  {
    this.otherWorkCrossIncome = otherWorkCrossIncome;
  }
  
  public String getHaveOtherWork()
  {
    return this.haveOtherWork;
  }
  
  public void setHaveOtherWork(String haveOtherWork)
  {
    this.haveOtherWork = haveOtherWork;
  }
  
  public String getOtherWork()
  {
    return FormCmp.getArabicText(this.isEdit, this.otherWork);
  }
  
  public void setOtherWork(String otherWork)
  {
    this.otherWork = otherWork;
  }
  
  public String getFamilyIncome()
  {
    return this.familyIncome;
  }
  
  public void setFamilyIncome(String familyIncome)
  {
    this.familyIncome = familyIncome;
  }
  
  public String getFamilyUnemployed()
  {
    return this.familyUnemployed;
  }
  
  public void setFamilyUnemployed(String familyUnemployed)
  {
    this.familyUnemployed = familyUnemployed;
  }
  
  public String getUnemployedResons()
  {
    return FormCmp.getArabicText(this.isEdit, this.unemployedResons);
  }
  
  public void setUnemployedResons(String unemployedResons)
  {
    this.unemployedResons = unemployedResons;
  }
  
  public String getOtherAcademicExpensive()
  {
    return FormCmp.getArabicText(this.isEdit, this.otherAcademicExpensive);
  }
  
  public void setOtherAcademicExpensive(String otherAcademicExpensive)
  {
    this.otherAcademicExpensive = otherAcademicExpensive;
  }
  
  public String getOtherAcademicCost()
  {
    return this.otherAcademicCost;
  }
  
  public void setOtherAcademicCost(String otherAcademicCost)
  {
    this.otherAcademicCost = otherAcademicCost;
  }
  
  public boolean isEdit()
  {
    return this.isEdit;
  }
  
  public void setEdit(boolean edit)
  {
    this.isEdit = edit;
  }
  
  public String getChildrenCount()
  {
    return this.childrenCount;
  }
  
  public void setChildrenCount(String childrenCount)
  {
    this.childrenCount = childrenCount;
  }
  
  public String getMotherAcademicLevel()
  {
    return this.motherAcademicLevel;
  }
  
  public void setMotherAcademicLevel(String motherAcademicLevel)
  {
    this.motherAcademicLevel = motherAcademicLevel;
  }
  
  public String getFamilyCountAll()
  {
    return this.familyCountAll;
  }
  
  public void setFamilyCountAll(String familyCountAll)
  {
    this.familyCountAll = familyCountAll;
  }
  
  public String getFamilyCountUnder18()
  {
    return this.familyCountUnder18;
  }
  
  public void setFamilyCountUnder18(String familyCountUnder18)
  {
    this.familyCountUnder18 = familyCountUnder18;
  }
  
  public String getBrothersCount()
  {
    return this.brothersCount;
  }
  
  public void setBrothersCount(String brothersCount)
  {
    this.brothersCount = brothersCount;
  }
  
  public String getSistersCount()
  {
    return this.sistersCount;
  }
  
  public void setSistersCount(String sistersCount)
  {
    this.sistersCount = sistersCount;
  }
  
  public String getOtherMaleCount()
  {
    return this.otherMaleCount;
  }
  
  public void setOtherMaleCount(String otherMaleCount)
  {
    this.otherMaleCount = otherMaleCount;
  }
  
  public String getOtherFemaleCount()
  {
    return this.otherFemaleCount;
  }
  
  public void setOtherFemaleCount(String otherFemaleCount)
  {
    this.otherFemaleCount = otherFemaleCount;
  }
  
  public String getWifeOneAName()
  {
    return FormCmp.getArabicText(this.isEdit, this.wifeOneAName);
  }
  
  public void setWifeOneAName(String wifeOneAName)
  {
    this.wifeOneAName = wifeOneAName;
  }
  
  public String getWifeOneDob()
  {
    return this.wifeOneDob;
  }
  
  public void setWifeOneDob(String wifeOneDob)
  {
    this.wifeOneDob = wifeOneDob;
  }
  
  public String getWifeOneIdCardType()
  {
    return this.wifeOneIdCardType;
  }
  
  public void setWifeOneIdCardType(String wifeOneIdCardType)
  {
    this.wifeOneIdCardType = wifeOneIdCardType;
  }
  
  public String getWifeOneIdCard()
  {
    return this.wifeOneIdCard;
  }
  
  public void setWifeOneIdCard(String wifeOneIdCard)
  {
    this.wifeOneIdCard = wifeOneIdCard;
  }
  
  public String getWifeOneAcadmicLevel()
  {
    return this.wifeOneAcadmicLevel;
  }
  
  public void setWifeOneAcadmicLevel(String wifeOneAcadmicLevel)
  {
    this.wifeOneAcadmicLevel = wifeOneAcadmicLevel;
  }
  
  public String getFatherAName()
  {
    return FormCmp.getArabicText(this.isEdit, this.fatherAName);
  }
  
  public void setFatherAName(String fatherAName)
  {
    this.fatherAName = fatherAName;
  }
  
  public String getFatherIdCardType()
  {
    return this.fatherIdCardType;
  }
  
  public void setFatherIdCardType(String fatherIdCardType)
  {
    this.fatherIdCardType = fatherIdCardType;
  }
  
  public String getFatherIdCard()
  {
    return this.fatherIdCard;
  }
  
  public void setFatherIdCard(String fatherIdCard)
  {
    this.fatherIdCard = fatherIdCard;
  }
  
  public String getFatherDob()
  {
    return this.fatherDob;
  }
  
  public void setFatherDob(String fatherDob)
  {
    this.fatherDob = fatherDob;
  }
  
  public String getFatherAcademicLevel()
  {
    return this.fatherAcademicLevel;
  }
  
  public void setFatherAcademicLevel(String fatherAcademicLevel)
  {
    this.fatherAcademicLevel = fatherAcademicLevel;
  }
  
  public String getMotherAName()
  {
    return FormCmp.getArabicText(this.isEdit, this.motherAName);
  }
  
  public void setMotherAName(String motherAName)
  {
    this.motherAName = motherAName;
  }
  
  public String getMotherIdCardType()
  {
    return this.motherIdCardType;
  }
  
  public void setMotherIdCardType(String motherIdCardType)
  {
    this.motherIdCardType = motherIdCardType;
  }
  
  public String getMotherIdCard()
  {
    return this.motherIdCard;
  }
  
  public void setMotherIdCard(String motherIdCard)
  {
    this.motherIdCard = motherIdCard;
  }
  
  public String getMotherDob()
  {
    return this.motherDob;
  }
  
  public void setMotherDob(String motherDob)
  {
    this.motherDob = motherDob;
  }
  
  public String getBirthCountry()
  {
    return this.birthCountry;
  }
  
  public void setBirthCountry(String birthCountry)
  {
    this.birthCountry = birthCountry;
  }
  
  public String getBirthLocality()
  {
    return this.birthLocality;
  }
  
  public void setBirthLocality(String birthLocality)
  {
    this.birthLocality = birthLocality;
  }
  
  public String getBirthGovernate()
  {
    return this.birthGovernate;
  }
  
  public void setBirthGovernate(String birthGovernate)
  {
    this.birthGovernate = birthGovernate;
  }
  
  public String getStudId()
  {
    return this.studId;
  }
  
  public void setStudId(String studId)
  {
    this.studId = studId;
  }
  
  public String getPerCountry()
  {
    return this.perCountry;
  }
  
  public void setPerCountry(String perCountry)
  {
    this.perCountry = perCountry;
  }
  
  public String getPerGovernate()
  {
    return this.perGovernate;
  }
  
  public void setPerGovernate(String perGovernate)
  {
    this.perGovernate = perGovernate;
  }
  
  public String getPerLocality()
  {
    return this.perLocality;
  }
  
  public void setPerLocality(String perLocality)
  {
    this.perLocality = perLocality;
  }
  
  public String getCurrCountry()
  {
    return this.currCountry;
  }
  
  public void setCurrCountry(String currCountry)
  {
    this.currCountry = currCountry;
  }
  
  public String getCurrGovernate()
  {
    return this.currGovernate;
  }
  
  public void setCurrGovernate(String currGovernate)
  {
    this.currGovernate = currGovernate;
  }
  
  public String getCurrLocality()
  {
    return this.currLocality;
  }
  
  public void setCurrLocality(String currLocality)
  {
    this.currLocality = currLocality;
  }
  
  public ActionErrors validate(ActionMapping mapping, HttpServletRequest req)
  {
    ActionErrors errors = new ActionErrors();
    if ((this.familyCountAll != null) && (!this.familyCountAll.trim().equals("")) && (!FormCmp.isInteger(this.familyCountAll))) {
      errors.add("errorPartTwo", new ActionMessage("errors.familyCountAll.format"));
    }
    if ((this.familyCountUnder18 != null) && (!this.familyCountUnder18.trim().equals("")) && (!FormCmp.isInteger(this.familyCountUnder18))) {
      errors.add("errorPartTwo", new ActionMessage("errors.familyCountUnder18.format"));
    }
    if ((this.brothersCount != null) && (!this.brothersCount.trim().equals("")) && (!FormCmp.isInteger(this.brothersCount))) {
      errors.add("errorPartTwo", new ActionMessage("errors.brothersCount.format"));
    }
    if ((this.sistersCount != null) && (!this.sistersCount.trim().equals("")) && (!FormCmp.isInteger(this.sistersCount))) {
      errors.add("errorPartTwo", new ActionMessage("errors.sistersCount.format"));
    }
    if ((this.otherMaleCount != null) && (!this.otherMaleCount.trim().equals("")) && (!FormCmp.isInteger(this.otherMaleCount))) {
      errors.add("errorPartTwo", new ActionMessage("errors.otherMaleCount.format"));
    }
    if ((this.otherFemaleCount != null) && (!this.otherFemaleCount.trim().equals("")) && (!FormCmp.isInteger(this.otherFemaleCount))) {
      errors.add("errorPartTwo", new ActionMessage("errors.otherFemaleCount.format"));
    }
    if ((this.fatherIdCard != null) && (!this.fatherIdCard.trim().equals("")) && (!FormCmp.validCardId(this.fatherIdCard))) {
      errors.add("errorPartTwo", new ActionMessage("errors.fatherIdCard.format"));
    }
    if ((this.motherIdCard != null) && (!this.motherIdCard.trim().equals("")) && (!FormCmp.validCardId(this.motherIdCard))) {
      errors.add("errorPartTwo", new ActionMessage("errors.motherIdCard.format"));
    }
    if ((this.wifeOneIdCard != null) && (!this.wifeOneIdCard.trim().equals("")) && (!FormCmp.validCardId(this.wifeOneIdCard))) {
      errors.add("errorPartTwo", new ActionMessage("errors.wifeOneIdCard.format"));
    }
    if ((this.otherAcademicCost != null) && (!this.otherAcademicCost.trim().equals("")) && (!FormCmp.isDouble(this.otherAcademicCost))) {
      errors.add("errorPartThree", new ActionMessage("errors.otherAcademicCost.format"));
    }
    if ((this.otherWorkCrossIncome != null) && (!this.otherWorkCrossIncome.trim().equals("")) && (!FormCmp.isDouble(this.otherWorkCrossIncome))) {
      errors.add("errorPartFour", new ActionMessage("errors.otherWorkCrossIncome.format"));
    }
    if ((errors != null) && (errors.size() > 0))
    {
      StudentInfoHolder studInfo = (StudentInfoHolder)((List)req.getSession().getAttribute("studentInfo")).get(0);
      
      ArrayList inpt = new ArrayList();
      inpt.add(studInfo.getStudentId());
      inpt.add(studInfo.getSystemCurrentTermNo());
      inpt.add(this);
      inpt.add(new Boolean(false));
      Collection retList = new ViewStudSocialSurveyUseCase().execute(inpt, req);
      if ((retList != null) && (retList.size() > 0)) {
        req.setAttribute("studInfoData", retList);
      }
      setEdit(false);
    }
    return errors;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.forms.StudSocialSurveyForm
 * JD-Core Version:    0.7.0.1
 */