package ps.edu.diyar.admission.forms;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import ps.edu.diyar.admission.useCase.AdmApplicationLoadDataUseCase;
import ps.edu.diyar.admission.useCase.FillSelectedDataUseCase;
import ps.edu.diyar.common.component.FormCmp;

public class AdmApplicationForm
  extends ActionForm
{
  private String appNo;
  private String appStatus;
  private String appStudentCat;
  private String admStatus;
  private String firstName;
  private String secondName;
  private String thirdName;
  private String familyName;
  private String firstNameE;
  private String secondNameE;
  private String thirdNameE;
  private String familyNameE;
  private String gender;
  private String idcardType;
  private String idcardNo;
  private String fatherName;
  private String fatherCert;
  private String fatherJob;
  private String motherName;
  private String motherCert;
  private String motherJob;
  private String perBoxNo;
  private String perStreet;
  private String perCountry;
  private String perGovernate;
  private String perLocality;
  private String perTel;
  private String perMobile;
  private String perEmail;
  private String currBoxNo;
  private String currStreet;
  private String currCountry;
  private String currGovernate;
  private String currLocality;
  private String currTel;
  private String currMobile;
  private String currEmail;
  private String birthCountry;
  private String birthLocality;
  private String birthGovernate;
  private String birthDate;
  private String maritalStatus;
  private String noOfChildrens;
  private String nationality;
  private String healthStatus;
  private String emergencyAddress;
  private String emergencyTel;
  private String healthSituation;
  private String schoolNo;
  private String schoolBoxNo;
  private String schoolStreet;
  private String schoolCountry;
  private String schoolGovernate;
  private String schoolLocality;
  private String schoolType;
  private String tawOrigin;
  private String tawYear;
  private String tawAvg;
  private String tawSeat;
  private String tawBranch;
  private String englishMark;
  private String collegeNo;
  private String specNo;
  private String collegeNoOther;
  private String specNoOther;
  private String eduUcNo_1;
  private String eduUcCountry_1;
  private String eduUcGovernate_1;
  private String eduUcLocality_1;
  private String eduStartDate_1;
  private String eduEndDate_1;
  private String eduSpecTypeNo_1;
  private String rsdSpecNo_1;
  private String eduGradeDate_1;
  private String eduUcNo_2;
  private String eduUcCountry_2;
  private String eduUcGovernate_2;
  private String eduUcLocality_2;
  private String eduStartDate_2;
  private String eduEndDate_2;
  private String eduSpecTypeNo_2;
  private String rsdSpecNo_2;
  private String eduGradeDate_2;
  private String eduUcNo_3;
  private String eduUcCountry_3;
  private String eduUcGovernate_3;
  private String eduUcLocality_3;
  private String eduStartDate_3;
  private String eduEndDate_3;
  private String eduSpecTypeNo_3;
  private String rsdSpecNo_3;
  private String eduGradeDate_3;
  private String lngLangNo_1;
  private String lngReadLevelNo_1;
  private String lngWriteLevelNo_1;
  private String lngSpeakLevelNo_1;
  private String lngLangNo_2;
  private String lngReadLevelNo_2;
  private String lngWriteLevelNo_2;
  private String lngSpeakLevelNo_2;
  private String lngLangNo_3;
  private String lngReadLevelNo_3;
  private String lngWriteLevelNo_3;
  private String lngSpeakLevelNo_3;
  private boolean editOpperation = false;
  
  public ActionErrors validate(ActionMapping mapping, HttpServletRequest req)
  {
    ActionErrors errors = new ActionErrors();
    if ((this.appStatus != null) && (this.appStatus.trim().equals("1")))
    {
      if (this.idcardType.equals("1")) {
        if (!FormCmp.validCardId(this.idcardNo)) {
          errors.add("errors.adm.idcardNo", new ActionMessage("errors.adm.idcardNo"));
        }
      }
      if ((this.noOfChildrens != null) && (!this.noOfChildrens.equals(""))) {
        try
        {
          Integer.parseInt(this.noOfChildrens);
        }
        catch (Exception e)
        {
          errors.add("errors.adm.noOfChildrens", new ActionMessage("errors.adm.noOfChildrens"));
        }
      }
      if ((this.tawAvg != null) && (!this.tawAvg.equals(""))) {
        try
        {
          Double.parseDouble(this.tawAvg);
        }
        catch (Exception e)
        {
          errors.add("errors.adm.tawAvg", new ActionMessage("errors.adm.tawAvg"));
        }
      }
      if ((this.englishMark != null) && (!this.englishMark.equals(""))) {
        try
        {
          Integer.parseInt(this.englishMark);
        }
        catch (Exception e)
        {
          errors.add("errors.adm.englishMark", new ActionMessage("errors.adm.englishMark"));
        }
      }
      if ((this.tawYear != null) && (!this.tawYear.equals(""))) {
        try
        {
          Integer.parseInt(this.tawYear);
        }
        catch (Exception e)
        {
          errors.add("errors.adm.tawYear", new ActionMessage("errors.adm.tawYear"));
        }
      }
      if ((errors != null) && (errors.size() > 0))
      {
        new AdmApplicationLoadDataUseCase().execute(null, req);
        
        ArrayList inpt = new ArrayList();
        inpt.add(getGender());
        inpt.add(getCollegeNo());
        inpt.add(getPerCountry());
        inpt.add(getCurrCountry());
        inpt.add(getBirthCountry());
        inpt.add(getSchoolCountry());
        inpt.add(getEduUcCountry_1());
        inpt.add(getEduUcCountry_2());
        inpt.add(getEduUcCountry_3());
        inpt.add(getPerGovernate());
        inpt.add(getCurrGovernate());
        inpt.add(getBirthGovernate());
        inpt.add(getSchoolGovernate());
        inpt.add(getEduUcGovernate_1());
        inpt.add(getEduUcGovernate_2());
        inpt.add(getEduUcGovernate_3());
        new FillSelectedDataUseCase().execute(inpt, req);
      }
    }
    return errors;
  }
  
  public String getCollegeNoOther()
  {
    return this.collegeNoOther;
  }
  
  public void setCollegeNoOther(String collegeNoOther)
  {
    this.collegeNoOther = collegeNoOther;
  }
  
  public String getSpecNoOther()
  {
    return this.specNoOther;
  }
  
  public void setSpecNoOther(String specNoOther)
  {
    this.specNoOther = specNoOther;
  }
  
  public String getAdmStatus()
  {
    return this.admStatus;
  }
  
  public void setAdmStatus(String admStatus)
  {
    this.admStatus = admStatus;
  }
  
  public String getAppNo()
  {
    return this.appNo;
  }
  
  public void setAppNo(String appNo)
  {
    this.appNo = appNo;
  }
  
  public String getAppStatus()
  {
    return this.appStatus;
  }
  
  public void setAppStatus(String appStatus)
  {
    this.appStatus = appStatus;
  }
  
  public String getEduUcNo_1()
  {
    return this.eduUcNo_1;
  }
  
  public void setEduUcNo_1(String eduUcNo_1)
  {
    this.eduUcNo_1 = eduUcNo_1;
  }
  
  public String getEduUcCountry_1()
  {
    return this.eduUcCountry_1;
  }
  
  public void setEduUcCountry_1(String eduUcCountry_1)
  {
    this.eduUcCountry_1 = eduUcCountry_1;
  }
  
  public String getEduUcGovernate_1()
  {
    return this.eduUcGovernate_1;
  }
  
  public void setEduUcGovernate_1(String eduUcGovernate_1)
  {
    this.eduUcGovernate_1 = eduUcGovernate_1;
  }
  
  public String getEduUcLocality_1()
  {
    return this.eduUcLocality_1;
  }
  
  public void setEduUcLocality_1(String eduUcLocality_1)
  {
    this.eduUcLocality_1 = eduUcLocality_1;
  }
  
  public String getEduStartDate_1()
  {
    return this.eduStartDate_1;
  }
  
  public void setEduStartDate_1(String eduStartDate_1)
  {
    this.eduStartDate_1 = eduStartDate_1;
  }
  
  public String getEduEndDate_1()
  {
    return this.eduEndDate_1;
  }
  
  public void setEduEndDate_1(String eduEndDate_1)
  {
    this.eduEndDate_1 = eduEndDate_1;
  }
  
  public String getEduSpecTypeNo_1()
  {
    return this.eduSpecTypeNo_1;
  }
  
  public void setEduSpecTypeNo_1(String eduSpecTypeNo_1)
  {
    this.eduSpecTypeNo_1 = eduSpecTypeNo_1;
  }
  
  public String getRsdSpecNo_1()
  {
    return this.rsdSpecNo_1;
  }
  
  public void setRsdSpecNo_1(String rsdSpecNo_1)
  {
    this.rsdSpecNo_1 = rsdSpecNo_1;
  }
  
  public String getEduGradeDate_1()
  {
    return this.eduGradeDate_1;
  }
  
  public void setEduGradeDate_1(String eduGradeDate_1)
  {
    this.eduGradeDate_1 = eduGradeDate_1;
  }
  
  public String getEduUcNo_2()
  {
    return this.eduUcNo_2;
  }
  
  public void setEduUcNo_2(String eduUcNo_2)
  {
    this.eduUcNo_2 = eduUcNo_2;
  }
  
  public String getEduUcCountry_2()
  {
    return this.eduUcCountry_2;
  }
  
  public void setEduUcCountry_2(String eduUcCountry_2)
  {
    this.eduUcCountry_2 = eduUcCountry_2;
  }
  
  public String getEduUcGovernate_2()
  {
    return this.eduUcGovernate_2;
  }
  
  public void setEduUcGovernate_2(String eduUcGovernate_2)
  {
    this.eduUcGovernate_2 = eduUcGovernate_2;
  }
  
  public String getEduUcLocality_2()
  {
    return this.eduUcLocality_2;
  }
  
  public void setEduUcLocality_2(String eduUcLocality_2)
  {
    this.eduUcLocality_2 = eduUcLocality_2;
  }
  
  public String getEduStartDate_2()
  {
    return this.eduStartDate_2;
  }
  
  public void setEduStartDate_2(String eduStartDate_2)
  {
    this.eduStartDate_2 = eduStartDate_2;
  }
  
  public String getEduEndDate_2()
  {
    return this.eduEndDate_2;
  }
  
  public void setEduEndDate_2(String eduEndDate_2)
  {
    this.eduEndDate_2 = eduEndDate_2;
  }
  
  public String getEduSpecTypeNo_2()
  {
    return this.eduSpecTypeNo_2;
  }
  
  public void setEduSpecTypeNo_2(String eduSpecTypeNo_2)
  {
    this.eduSpecTypeNo_2 = eduSpecTypeNo_2;
  }
  
  public String getRsdSpecNo_2()
  {
    return this.rsdSpecNo_2;
  }
  
  public void setRsdSpecNo_2(String rsdSpecNo_2)
  {
    this.rsdSpecNo_2 = rsdSpecNo_2;
  }
  
  public String getEduGradeDate_2()
  {
    return this.eduGradeDate_2;
  }
  
  public void setEduGradeDate_2(String eduGradeDate_2)
  {
    this.eduGradeDate_2 = eduGradeDate_2;
  }
  
  public String getEduUcNo_3()
  {
    return this.eduUcNo_3;
  }
  
  public void setEduUcNo_3(String eduUcNo_3)
  {
    this.eduUcNo_3 = eduUcNo_3;
  }
  
  public String getEduUcCountry_3()
  {
    return this.eduUcCountry_3;
  }
  
  public void setEduUcCountry_3(String eduUcCountry_3)
  {
    this.eduUcCountry_3 = eduUcCountry_3;
  }
  
  public String getEduUcGovernate_3()
  {
    return this.eduUcGovernate_3;
  }
  
  public void setEduUcGovernate_3(String eduUcGovernate_3)
  {
    this.eduUcGovernate_3 = eduUcGovernate_3;
  }
  
  public String getEduUcLocality_3()
  {
    return this.eduUcLocality_3;
  }
  
  public void setEduUcLocality_3(String eduUcLocality_3)
  {
    this.eduUcLocality_3 = eduUcLocality_3;
  }
  
  public String getEduStartDate_3()
  {
    return this.eduStartDate_3;
  }
  
  public void setEduStartDate_3(String eduStartDate_3)
  {
    this.eduStartDate_3 = eduStartDate_3;
  }
  
  public String getEduEndDate_3()
  {
    return this.eduEndDate_3;
  }
  
  public void setEduEndDate_3(String eduEndDate_3)
  {
    this.eduEndDate_3 = eduEndDate_3;
  }
  
  public String getEduSpecTypeNo_3()
  {
    return this.eduSpecTypeNo_3;
  }
  
  public void setEduSpecTypeNo_3(String eduSpecTypeNo_3)
  {
    this.eduSpecTypeNo_3 = eduSpecTypeNo_3;
  }
  
  public String getRsdSpecNo_3()
  {
    return this.rsdSpecNo_3;
  }
  
  public void setRsdSpecNo_3(String rsdSpecNo_3)
  {
    this.rsdSpecNo_3 = rsdSpecNo_3;
  }
  
  public String getEduGradeDate_3()
  {
    return this.eduGradeDate_3;
  }
  
  public void setEduGradeDate_3(String eduGradeDate_3)
  {
    this.eduGradeDate_3 = eduGradeDate_3;
  }
  
  public String getLngLangNo_1()
  {
    return this.lngLangNo_1;
  }
  
  public void setLngLangNo_1(String lngLangNo_1)
  {
    this.lngLangNo_1 = lngLangNo_1;
  }
  
  public String getLngReadLevelNo_1()
  {
    return this.lngReadLevelNo_1;
  }
  
  public void setLngReadLevelNo_1(String lngReadLevelNo_1)
  {
    this.lngReadLevelNo_1 = lngReadLevelNo_1;
  }
  
  public String getLngWriteLevelNo_1()
  {
    return this.lngWriteLevelNo_1;
  }
  
  public void setLngWriteLevelNo_1(String lngWriteLevelNo_1)
  {
    this.lngWriteLevelNo_1 = lngWriteLevelNo_1;
  }
  
  public String getLngSpeakLevelNo_1()
  {
    return this.lngSpeakLevelNo_1;
  }
  
  public void setLngSpeakLevelNo_1(String lngSpeakLevelNo_1)
  {
    this.lngSpeakLevelNo_1 = lngSpeakLevelNo_1;
  }
  
  public String getLngLangNo_2()
  {
    return this.lngLangNo_2;
  }
  
  public void setLngLangNo_2(String lngLangNo_2)
  {
    this.lngLangNo_2 = lngLangNo_2;
  }
  
  public String getLngReadLevelNo_2()
  {
    return this.lngReadLevelNo_2;
  }
  
  public void setLngReadLevelNo_2(String lngReadLevelNo_2)
  {
    this.lngReadLevelNo_2 = lngReadLevelNo_2;
  }
  
  public String getLngWriteLevelNo_2()
  {
    return this.lngWriteLevelNo_2;
  }
  
  public void setLngWriteLevelNo_2(String lngWriteLevelNo_2)
  {
    this.lngWriteLevelNo_2 = lngWriteLevelNo_2;
  }
  
  public String getLngSpeakLevelNo_2()
  {
    return this.lngSpeakLevelNo_2;
  }
  
  public void setLngSpeakLevelNo_2(String lngSpeakLevelNo_2)
  {
    this.lngSpeakLevelNo_2 = lngSpeakLevelNo_2;
  }
  
  public String getLngLangNo_3()
  {
    return this.lngLangNo_3;
  }
  
  public void setLngLangNo_3(String lngLangNo_3)
  {
    this.lngLangNo_3 = lngLangNo_3;
  }
  
  public String getLngReadLevelNo_3()
  {
    return this.lngReadLevelNo_3;
  }
  
  public void setLngReadLevelNo_3(String lngReadLevelNo_3)
  {
    this.lngReadLevelNo_3 = lngReadLevelNo_3;
  }
  
  public String getLngWriteLevelNo_3()
  {
    return this.lngWriteLevelNo_3;
  }
  
  public void setLngWriteLevelNo_3(String lngWriteLevelNo_3)
  {
    this.lngWriteLevelNo_3 = lngWriteLevelNo_3;
  }
  
  public String getLngSpeakLevelNo_3()
  {
    return this.lngSpeakLevelNo_3;
  }
  
  public void setLngSpeakLevelNo_3(String lngSpeakLevelNo_3)
  {
    this.lngSpeakLevelNo_3 = lngSpeakLevelNo_3;
  }
  
  public String getSpecNo()
  {
    return this.specNo;
  }
  
  public void setSpecNo(String specNo)
  {
    this.specNo = specNo;
  }
  
  public String getCollegeNo()
  {
    return this.collegeNo;
  }
  
  public void setCollegeNo(String collegeNo)
  {
    this.collegeNo = collegeNo;
  }
  
  public String getSchoolNo()
  {
    return this.schoolNo;
  }
  
  public void setSchoolNo(String schoolNo)
  {
    this.schoolNo = schoolNo;
  }
  
  public String getSchoolBoxNo()
  {
    return this.schoolBoxNo;
  }
  
  public void setSchoolBoxNo(String schoolBoxNo)
  {
    this.schoolBoxNo = schoolBoxNo;
  }
  
  public String getSchoolStreet()
  {
    this.schoolStreet = FormCmp.getArabicText(this.editOpperation, this.schoolStreet);
    return this.schoolStreet;
  }
  
  public void setSchoolStreet(String schoolStreet)
  {
    this.schoolStreet = schoolStreet;
  }
  
  public String getSchoolCountry()
  {
    return this.schoolCountry;
  }
  
  public void setSchoolCountry(String schoolCountry)
  {
    this.schoolCountry = schoolCountry;
  }
  
  public String getSchoolGovernate()
  {
    return this.schoolGovernate;
  }
  
  public void setSchoolGovernate(String schoolGovernate)
  {
    this.schoolGovernate = schoolGovernate;
  }
  
  public String getSchoolLocality()
  {
    return this.schoolLocality;
  }
  
  public void setSchoolLocality(String schoolLocality)
  {
    this.schoolLocality = schoolLocality;
  }
  
  public String getSchoolType()
  {
    return this.schoolType;
  }
  
  public void setSchoolType(String schoolType)
  {
    this.schoolType = schoolType;
  }
  
  public String getTawOrigin()
  {
    return this.tawOrigin;
  }
  
  public void setTawOrigin(String tawOrigin)
  {
    this.tawOrigin = tawOrigin;
  }
  
  public String getTawYear()
  {
    return this.tawYear;
  }
  
  public void setTawYear(String tawYear)
  {
    this.tawYear = tawYear;
  }
  
  public String getTawAvg()
  {
    return this.tawAvg;
  }
  
  public void setTawAvg(String tawAvg)
  {
    this.tawAvg = tawAvg;
  }
  
  public String getTawSeat()
  {
    return this.tawSeat;
  }
  
  public void setTawSeat(String tawSeat)
  {
    this.tawSeat = tawSeat;
  }
  
  public String getTawBranch()
  {
    return this.tawBranch;
  }
  
  public void setTawBranch(String tawBranch)
  {
    this.tawBranch = tawBranch;
  }
  
  public String getEnglishMark()
  {
    return this.englishMark;
  }
  
  public void setEnglishMark(String englishMark)
  {
    this.englishMark = englishMark;
  }
  
  public String getBirthDate()
  {
    return this.birthDate;
  }
  
  public void setBirthDate(String birthDate)
  {
    this.birthDate = birthDate;
  }
  
  public String getMaritalStatus()
  {
    return this.maritalStatus;
  }
  
  public void setMaritalStatus(String maritalStatus)
  {
    this.maritalStatus = maritalStatus;
  }
  
  public String getNoOfChildrens()
  {
    return this.noOfChildrens;
  }
  
  public void setNoOfChildrens(String noOfChildrens)
  {
    this.noOfChildrens = noOfChildrens;
  }
  
  public String getNationality()
  {
    return this.nationality;
  }
  
  public void setNationality(String nationality)
  {
    this.nationality = nationality;
  }
  
  public String getHealthStatus()
  {
    return this.healthStatus;
  }
  
  public void setHealthStatus(String healthStatus)
  {
    this.healthStatus = healthStatus;
  }
  
  public String getEmergencyAddress()
  {
    this.emergencyAddress = FormCmp.getArabicText(this.editOpperation, this.emergencyAddress);
    return this.emergencyAddress;
  }
  
  public void setEmergencyAddress(String emergencyAddress)
  {
    this.emergencyAddress = emergencyAddress;
  }
  
  public String getEmergencyTel()
  {
    return this.emergencyTel;
  }
  
  public void setEmergencyTel(String emergencyTel)
  {
    this.emergencyTel = emergencyTel;
  }
  
  public String getHealthSituation()
  {
    this.healthSituation = FormCmp.getArabicText(this.editOpperation, this.healthSituation);
    return this.healthSituation;
  }
  
  public void setHealthSituation(String healthSituation)
  {
    this.healthSituation = healthSituation;
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
  
  public String getCurrBoxNo()
  {
    return this.currBoxNo;
  }
  
  public void setCurrBoxNo(String currBoxNo)
  {
    this.currBoxNo = currBoxNo;
  }
  
  public String getCurrStreet()
  {
    this.currStreet = FormCmp.getArabicText(this.editOpperation, this.currStreet);
    return this.currStreet;
  }
  
  public void setCurrStreet(String currStreet)
  {
    this.currStreet = currStreet;
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
  
  public String getCurrTel()
  {
    return this.currTel;
  }
  
  public void setCurrTel(String currTel)
  {
    this.currTel = currTel;
  }
  
  public String getCurrMobile()
  {
    return this.currMobile;
  }
  
  public void setCurrMobile(String currMobile)
  {
    this.currMobile = currMobile;
  }
  
  public String getCurrEmail()
  {
    return this.currEmail;
  }
  
  public void setCurrEmail(String currEmail)
  {
    this.currEmail = currEmail;
  }
  
  public String getPerBoxNo()
  {
    return this.perBoxNo;
  }
  
  public void setPerBoxNo(String perBoxNo)
  {
    this.perBoxNo = perBoxNo;
  }
  
  public String getPerStreet()
  {
    this.perStreet = FormCmp.getArabicText(this.editOpperation, this.perStreet);
    return this.perStreet;
  }
  
  public void setPerStreet(String perStreet)
  {
    this.perStreet = perStreet;
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
  
  public String getPerTel()
  {
    return this.perTel;
  }
  
  public void setPerTel(String perTel)
  {
    this.perTel = perTel;
  }
  
  public String getPerMobile()
  {
    return this.perMobile;
  }
  
  public void setPerMobile(String perMobile)
  {
    this.perMobile = perMobile;
  }
  
  public String getPerEmail()
  {
    return this.perEmail;
  }
  
  public void setPerEmail(String perEmail)
  {
    this.perEmail = perEmail;
  }
  
  public String getFatherName()
  {
    this.fatherName = FormCmp.getArabicText(this.editOpperation, this.fatherName);
    return this.fatherName;
  }
  
  public void setFatherName(String fatherName)
  {
    this.fatherName = fatherName;
  }
  
  public String getFatherCert()
  {
    return this.fatherCert;
  }
  
  public void setFatherCert(String fatherCert)
  {
    this.fatherCert = fatherCert;
  }
  
  public String getFatherJob()
  {
    return this.fatherJob;
  }
  
  public void setFatherJob(String fatherJob)
  {
    this.fatherJob = fatherJob;
  }
  
  public String getMotherName()
  {
    this.motherName = FormCmp.getArabicText(this.editOpperation, this.motherName);
    return this.motherName;
  }
  
  public void setMotherName(String motherName)
  {
    this.motherName = motherName;
  }
  
  public String getMotherCert()
  {
    return this.motherCert;
  }
  
  public void setMotherCert(String motherCert)
  {
    this.motherCert = motherCert;
  }
  
  public String getMotherJob()
  {
    return this.motherJob;
  }
  
  public void setMotherJob(String motherJob)
  {
    this.motherJob = motherJob;
  }
  
  public String getAppStudentCat()
  {
    return this.appStudentCat;
  }
  
  public void setAppStudentCat(String appStudentCat)
  {
    this.appStudentCat = appStudentCat;
  }
  
  public String getFirstName()
  {
    this.firstName = FormCmp.getArabicText(this.editOpperation, this.firstName);
    
    return this.firstName;
  }
  
  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }
  
  public String getSecondName()
  {
    this.secondName = FormCmp.getArabicText(this.editOpperation, this.secondName);
    
    return this.secondName;
  }
  
  public void setSecondName(String secondName)
  {
    this.secondName = secondName;
  }
  
  public String getThirdName()
  {
    this.thirdName = FormCmp.getArabicText(this.editOpperation, this.thirdName);
    
    return this.thirdName;
  }
  
  public void setThirdName(String thirdName)
  {
    this.thirdName = thirdName;
  }
  
  public String getFamilyName()
  {
    this.familyName = FormCmp.getArabicText(this.editOpperation, this.familyName);
    
    return this.familyName;
  }
  
  public void setFamilyName(String familyName)
  {
    this.familyName = familyName;
  }
  
  public String getFirstNameE()
  {
    return this.firstNameE;
  }
  
  public void setFirstNameE(String firstNameE)
  {
    this.firstNameE = firstNameE;
  }
  
  public String getSecondNameE()
  {
    return this.secondNameE;
  }
  
  public void setSecondNameE(String secondNameE)
  {
    this.secondNameE = secondNameE;
  }
  
  public String getThirdNameE()
  {
    return this.thirdNameE;
  }
  
  public void setThirdNameE(String thirdNameE)
  {
    this.thirdNameE = thirdNameE;
  }
  
  public String getFamilyNameE()
  {
    return this.familyNameE;
  }
  
  public void setFamilyNameE(String familyNameE)
  {
    this.familyNameE = familyNameE;
  }
  
  public String getGender()
  {
    return this.gender;
  }
  
  public void setGender(String gender)
  {
    this.gender = gender;
  }
  
  public String getIdcardType()
  {
    return this.idcardType;
  }
  
  public void setIdcardType(String idcardType)
  {
    this.idcardType = idcardType;
  }
  
  public String getIdcardNo()
  {
    return this.idcardNo;
  }
  
  public void setIdcardNo(String idcardNo)
  {
    this.idcardNo = idcardNo;
  }
  
  public boolean isEditOpperation()
  {
    return this.editOpperation;
  }
  
  public void setEditOpperation(boolean editOpperation)
  {
    this.editOpperation = editOpperation;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.admission.forms.AdmApplicationForm
 * JD-Core Version:    0.7.0.1
 */