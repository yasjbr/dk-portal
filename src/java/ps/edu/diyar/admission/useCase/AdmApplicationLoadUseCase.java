package ps.edu.diyar.admission.useCase;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import ps.edu.diyar.admission.component.AdmComponent;
import ps.edu.diyar.admission.database.PrtlAdmApplication;
import ps.edu.diyar.admission.database.PrtlAdmEducation;
import ps.edu.diyar.admission.database.PrtlAdmEducationPK;
import ps.edu.diyar.admission.database.PrtlAdmLanguage;
import ps.edu.diyar.admission.database.PrtlAdmLanguagePK;
import ps.edu.diyar.admission.database.struct.AdmInfoHolder;
import ps.edu.diyar.admission.forms.AdmApplicationForm;
import ps.edu.diyar.common.component.FormCmp;
import ps.edu.diyar.common.useCase.ComponentUseCase;

public class AdmApplicationLoadUseCase
  implements ComponentUseCase
{
  private static Logger logger = Logger.getLogger(AdmApplicationLoadUseCase.class);
  
  public Collection execute(Collection input, HttpServletRequest request)
    throws HibernateException
  {
    List returnList = null;
    
    AdmApplicationForm admApplicationForm = (AdmApplicationForm)input.iterator().next();
    try
    {
      AdmInfoHolder admInfoHolder = (AdmInfoHolder)request.getSession(true).getAttribute("admInfo");
      admApplicationForm.setEditOpperation(true);
      AdmComponent cmp = new AdmComponent();
      
      ArrayList inputData = new ArrayList();
      Collection retList = cmp.getAdmApplicationLoadData(admInfoHolder.getAppNo(), admInfoHolder.getAdmTermNo());
      if ((retList != null) && (retList.size() > 0))
      {
        PrtlAdmApplication prtlAdmApplication = (PrtlAdmApplication)retList.iterator().next();
        loadPrtlAdmAppData(prtlAdmApplication, admApplicationForm);
        loadAdmEduInfo(admApplicationForm, admInfoHolder.getAppNo());
        loadAdmLangInfo(admApplicationForm, admInfoHolder.getAppNo());
        
        inputData.add(prtlAdmApplication.getGender());
        if ((prtlAdmApplication.getAppStatus() != null) && (!prtlAdmApplication.getAppStatus().equals("")) && (!prtlAdmApplication.getAppStatus().equals("0")))
        {
          request.setAttribute("appAprove", "true");
          List statList = cmp.getAdmStatus(prtlAdmApplication.getAdmStatus());
          if ((statList != null) && (statList.size() > 0)) {
            request.setAttribute("admStatus", statList);
          }
        }
      }
      else
      {
        admApplicationForm.setGender("M");
        inputData.add("M");
      }
      inputData.add(admApplicationForm.getCollegeNo());
      inputData.add(admApplicationForm.getPerCountry());
      inputData.add(admApplicationForm.getCurrCountry());
      inputData.add(admApplicationForm.getBirthCountry());
      inputData.add(admApplicationForm.getSchoolCountry());
      inputData.add(admApplicationForm.getEduUcCountry_1());
      inputData.add(admApplicationForm.getEduUcCountry_2());
      inputData.add(admApplicationForm.getEduUcCountry_3());
      inputData.add(admApplicationForm.getPerGovernate());
      inputData.add(admApplicationForm.getCurrGovernate());
      inputData.add(admApplicationForm.getBirthGovernate());
      inputData.add(admApplicationForm.getSchoolGovernate());
      inputData.add(admApplicationForm.getEduUcGovernate_1());
      inputData.add(admApplicationForm.getEduUcGovernate_2());
      inputData.add(admApplicationForm.getEduUcGovernate_3());
      new FillSelectedDataUseCase().execute(inputData, request);
    }
    catch (Exception e)
    {
      logger.error("*** AdmApplicationLoadUseCase.execute has ComponentException detials :" + e.toString());
      System.err.println("*** AdmApplicationLoadUseCase.execute has ComponentException detials :" + e.toString());
    }
    return returnList;
  }
  
  private void loadPrtlAdmAppData(PrtlAdmApplication prtlAdmApp, AdmApplicationForm admApplicationForm)
  {
    admApplicationForm.setAdmStatus(prtlAdmApp.getAdmStatus());
    admApplicationForm.setAppNo(prtlAdmApp.getAppNo());
    admApplicationForm.setAppStatus(prtlAdmApp.getAppStatus());
    admApplicationForm.setAppStudentCat(prtlAdmApp.getAppStudentCat());
    admApplicationForm.setFirstName(prtlAdmApp.getFirstName());
    admApplicationForm.setSecondName(prtlAdmApp.getSecondName());
    admApplicationForm.setThirdName(prtlAdmApp.getThirdName());
    admApplicationForm.setFamilyName(prtlAdmApp.getFamilyName());
    admApplicationForm.setFirstNameE(prtlAdmApp.getFirstNameE());
    admApplicationForm.setSecondNameE(prtlAdmApp.getSecondNameE());
    admApplicationForm.setThirdNameE(prtlAdmApp.getThirdNameE());
    admApplicationForm.setFamilyNameE(prtlAdmApp.getFamilyNameE());
    admApplicationForm.setGender(prtlAdmApp.getGender());
    admApplicationForm.setIdcardType(prtlAdmApp.getIdcardType());
    admApplicationForm.setIdcardNo(prtlAdmApp.getIdcardNo());
    admApplicationForm.setFatherName(prtlAdmApp.getFatherName());
    admApplicationForm.setFatherCert(prtlAdmApp.getFatherCert());
    admApplicationForm.setFatherJob(prtlAdmApp.getFatherJob());
    admApplicationForm.setMotherName(prtlAdmApp.getMotherName());
    admApplicationForm.setMotherCert(prtlAdmApp.getMotherCert());
    admApplicationForm.setMotherJob(prtlAdmApp.getMotherJob());
    admApplicationForm.setPerBoxNo(prtlAdmApp.getPerBoxNo());
    admApplicationForm.setPerStreet(prtlAdmApp.getPerStreet());
    admApplicationForm.setPerCountry(prtlAdmApp.getPerCountry());
    admApplicationForm.setPerGovernate(prtlAdmApp.getPerGovernate());
    admApplicationForm.setPerLocality(prtlAdmApp.getPerLocality());
    admApplicationForm.setPerTel(prtlAdmApp.getPerTel());
    admApplicationForm.setPerMobile(prtlAdmApp.getPerMobile());
    admApplicationForm.setPerEmail(prtlAdmApp.getPerEmail());
    admApplicationForm.setCurrBoxNo(prtlAdmApp.getCurrBoxNo());
    admApplicationForm.setCurrStreet(prtlAdmApp.getCurrStreet());
    admApplicationForm.setCurrCountry(prtlAdmApp.getCurrCountry());
    admApplicationForm.setCurrGovernate(prtlAdmApp.getCurrGovernate());
    admApplicationForm.setCurrLocality(prtlAdmApp.getCurrLocality());
    admApplicationForm.setCurrTel(prtlAdmApp.getCurrTel());
    admApplicationForm.setCurrMobile(prtlAdmApp.getCurrMobile());
    admApplicationForm.setCurrEmail(prtlAdmApp.getCurrEmail());
    admApplicationForm.setBirthCountry(prtlAdmApp.getBirthCountry());
    admApplicationForm.setBirthLocality(prtlAdmApp.getBirthLocality());
    admApplicationForm.setBirthGovernate(prtlAdmApp.getBirthGovernate());
    admApplicationForm.setBirthDate(FormCmp.convertDateToString(prtlAdmApp.getBirthDate()));
    admApplicationForm.setMaritalStatus(prtlAdmApp.getMaritalStatus());
    admApplicationForm.setNoOfChildrens(prtlAdmApp.getNoOfChildrens() + "");
    admApplicationForm.setNationality(prtlAdmApp.getNationality());
    admApplicationForm.setHealthStatus(prtlAdmApp.getHealthStatus());
    admApplicationForm.setEmergencyAddress(prtlAdmApp.getEmergencyAddress());
    admApplicationForm.setEmergencyTel(prtlAdmApp.getEmergencyTel());
    admApplicationForm.setHealthSituation(prtlAdmApp.getHealthSituation());
    admApplicationForm.setSchoolNo(prtlAdmApp.getSchoolNo());
    admApplicationForm.setSchoolBoxNo(prtlAdmApp.getSchoolBoxNo());
    admApplicationForm.setSchoolStreet(prtlAdmApp.getSchoolStreet());
    admApplicationForm.setSchoolCountry(prtlAdmApp.getSchoolCountry());
    admApplicationForm.setSchoolGovernate(prtlAdmApp.getSchoolGovernate());
    admApplicationForm.setSchoolLocality(prtlAdmApp.getSchoolLocality());
    admApplicationForm.setSchoolType(prtlAdmApp.getSchoolType());
    admApplicationForm.setTawOrigin(prtlAdmApp.getTawOrigin());
    admApplicationForm.setTawYear(prtlAdmApp.getTawYear());
    if (prtlAdmApp.getTawAvg().doubleValue() != 0.0D) {
      admApplicationForm.setTawAvg(prtlAdmApp.getTawAvg() + "");
    }
    admApplicationForm.setTawSeat(prtlAdmApp.getTawSeat());
    admApplicationForm.setTawBranch(prtlAdmApp.getTawBranch());
    if (prtlAdmApp.getEnglishMark().intValue() != 0) {
      admApplicationForm.setEnglishMark(prtlAdmApp.getEnglishMark() + "");
    }
    admApplicationForm.setCollegeNo(prtlAdmApp.getCollegeNo());
    admApplicationForm.setSpecNo(prtlAdmApp.getSpecNo());
    admApplicationForm.setCollegeNoOther(prtlAdmApp.getCollegeNoOther());
    admApplicationForm.setSpecNoOther(prtlAdmApp.getSpecNoOther());
  }
  
  private void loadAdmEduInfo(AdmApplicationForm admApplicationForm, String appNo)
  {
    AdmComponent cmp = new AdmComponent();
    
    List retList = cmp.getAdmEduInfo(appNo);
    if ((retList == null) || (retList.size() == 0)) {
      return;
    }
    Iterator itr = retList.iterator();
    if (itr.hasNext())
    {
      PrtlAdmEducation prtlAdmEdu_1 = (PrtlAdmEducation)itr.next();
      
      admApplicationForm.setEduUcNo_1(prtlAdmEdu_1.getComp_id().getUcNo());
      admApplicationForm.setAppNo(appNo);
      admApplicationForm.setEduStartDate_1(FormCmp.convertDateToString(prtlAdmEdu_1.getComp_id().getEduStartDate()));
      admApplicationForm.setEduEndDate_1(FormCmp.convertDateToString(prtlAdmEdu_1.getEduEndDate()));
      admApplicationForm.setEduSpecTypeNo_1(prtlAdmEdu_1.getSpecTypeNo());
      admApplicationForm.setRsdSpecNo_1(prtlAdmEdu_1.getSpecNo());
      admApplicationForm.setEduGradeDate_1(FormCmp.convertDateToString(prtlAdmEdu_1.getEduGradeDate()));
      admApplicationForm.setEduUcCountry_1(prtlAdmEdu_1.getUcCountry());
      admApplicationForm.setEduUcGovernate_1(prtlAdmEdu_1.getUcGovernate());
      admApplicationForm.setEduUcLocality_1(prtlAdmEdu_1.getUcLocality());
    }
    if (itr.hasNext())
    {
      PrtlAdmEducation prtlAdmEdu_2 = (PrtlAdmEducation)itr.next();
      
      admApplicationForm.setEduUcNo_2(prtlAdmEdu_2.getComp_id().getUcNo());
      admApplicationForm.setAppNo(appNo);
      admApplicationForm.setEduStartDate_2(FormCmp.convertDateToString(prtlAdmEdu_2.getComp_id().getEduStartDate()));
      admApplicationForm.setEduEndDate_2(FormCmp.convertDateToString(prtlAdmEdu_2.getEduEndDate()));
      admApplicationForm.setEduSpecTypeNo_2(prtlAdmEdu_2.getSpecTypeNo());
      admApplicationForm.setRsdSpecNo_2(prtlAdmEdu_2.getSpecNo());
      admApplicationForm.setEduGradeDate_2(FormCmp.convertDateToString(prtlAdmEdu_2.getEduGradeDate()));
      admApplicationForm.setEduUcCountry_2(prtlAdmEdu_2.getUcCountry());
      admApplicationForm.setEduUcGovernate_2(prtlAdmEdu_2.getUcGovernate());
      admApplicationForm.setEduUcLocality_2(prtlAdmEdu_2.getUcLocality());
    }
    if (itr.hasNext())
    {
      PrtlAdmEducation prtlAdmEdu_3 = (PrtlAdmEducation)itr.next();
      
      admApplicationForm.setEduUcNo_3(prtlAdmEdu_3.getComp_id().getUcNo());
      admApplicationForm.setAppNo(appNo);
      admApplicationForm.setEduStartDate_3(FormCmp.convertDateToString(prtlAdmEdu_3.getComp_id().getEduStartDate()));
      admApplicationForm.setEduEndDate_3(FormCmp.convertDateToString(prtlAdmEdu_3.getEduEndDate()));
      admApplicationForm.setEduSpecTypeNo_3(prtlAdmEdu_3.getSpecTypeNo());
      admApplicationForm.setRsdSpecNo_3(prtlAdmEdu_3.getSpecNo());
      admApplicationForm.setEduGradeDate_3(FormCmp.convertDateToString(prtlAdmEdu_3.getEduGradeDate()));
      admApplicationForm.setEduUcCountry_3(prtlAdmEdu_3.getUcCountry());
      admApplicationForm.setEduUcGovernate_3(prtlAdmEdu_3.getUcGovernate());
      admApplicationForm.setEduUcLocality_3(prtlAdmEdu_3.getUcLocality());
    }
  }
  
  private void loadAdmLangInfo(AdmApplicationForm admApplicationForm, String appNo)
  {
    AdmComponent cmp = new AdmComponent();
    
    List retList = cmp.getAdmLangInfo(appNo);
    if ((retList == null) || (retList.size() == 0)) {
      return;
    }
    Iterator itr = retList.iterator();
    if (itr.hasNext())
    {
      PrtlAdmLanguage prtlAdmLang_1 = (PrtlAdmLanguage)itr.next();
      admApplicationForm.setAppNo(appNo);
      admApplicationForm.setLngLangNo_1(prtlAdmLang_1.getComp_id().getLangNo());
      admApplicationForm.setLngReadLevelNo_1(prtlAdmLang_1.getReadLevelNo());
      admApplicationForm.setLngWriteLevelNo_1(prtlAdmLang_1.getWriteLevelNo());
      admApplicationForm.setLngSpeakLevelNo_1(prtlAdmLang_1.getSpeakLevelNo());
    }
    if (itr.hasNext())
    {
      PrtlAdmLanguage prtlAdmLang_2 = (PrtlAdmLanguage)itr.next();
      admApplicationForm.setAppNo(appNo);
      admApplicationForm.setLngLangNo_2(prtlAdmLang_2.getComp_id().getLangNo());
      admApplicationForm.setLngReadLevelNo_2(prtlAdmLang_2.getReadLevelNo());
      admApplicationForm.setLngWriteLevelNo_2(prtlAdmLang_2.getWriteLevelNo());
      admApplicationForm.setLngSpeakLevelNo_2(prtlAdmLang_2.getSpeakLevelNo());
    }
    if (itr.hasNext())
    {
      PrtlAdmLanguage prtlAdmLang_3 = (PrtlAdmLanguage)itr.next();
      admApplicationForm.setAppNo(appNo);
      admApplicationForm.setLngLangNo_3(prtlAdmLang_3.getComp_id().getLangNo());
      admApplicationForm.setLngReadLevelNo_3(prtlAdmLang_3.getReadLevelNo());
      admApplicationForm.setLngWriteLevelNo_3(prtlAdmLang_3.getWriteLevelNo());
      admApplicationForm.setLngSpeakLevelNo_3(prtlAdmLang_3.getSpeakLevelNo());
    }
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.admission.useCase.AdmApplicationLoadUseCase
 * JD-Core Version:    0.7.0.1
 */