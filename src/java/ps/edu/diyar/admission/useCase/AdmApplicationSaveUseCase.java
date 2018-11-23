package ps.edu.diyar.admission.useCase;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
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
import ps.edu.diyar.common.component.DataAccessObjectImpl;
import ps.edu.diyar.common.component.FormCmp;
import ps.edu.diyar.common.exceptions.ComponentException;
import ps.edu.diyar.common.useCase.ComponentUseCase;

public class AdmApplicationSaveUseCase
  implements ComponentUseCase
{
  private static Logger logger = Logger.getLogger(AdmApplicationSaveUseCase.class);
  
  public Collection execute(Collection input, HttpServletRequest request)
    throws HibernateException
  {
    List retList = null;
    
    Iterator iter = input.iterator();
    AdmApplicationForm inForm = (AdmApplicationForm)iter.next();
    try
    {
      DataAccessObjectImpl cmp = new DataAccessObjectImpl();
      AdmComponent admComponent = new AdmComponent();
      AdmInfoHolder admInfoHolder = (AdmInfoHolder)request.getSession(true).getAttribute("admInfo");
      boolean operation_update = false;
      
      String appNo = admInfoHolder.getAppNo();
      String admTermNo = admInfoHolder.getAdmTermNo();
      

      List resultChkList = admComponent.checkAppNoInPrvTerm(appNo, admTermNo);
      if ((resultChkList != null) && (resultChkList.size() > 0))
      {
        request.setAttribute("errorMsg", "تم تقديم هذا الطلب في الفصول السابقة");
        throw new Exception("This AppNo in Prv Term");
      }
      PrtlAdmApplication prtlAdmApp = new PrtlAdmApplication();
      prtlAdmApp.setAppNo(appNo);
      prtlAdmApp.setTermNo(admTermNo);
      

      Collection resultList = admComponent.getAdmApplicationLoadData(appNo, admTermNo);
      if ((resultList != null) && (resultList.size() > 0))
      {
        prtlAdmApp = (PrtlAdmApplication)resultList.iterator().next();
        operation_update = true;
      }
      fillPrtlAdmAppData(prtlAdmApp, inForm);
      if (operation_update) {
        cmp.update(prtlAdmApp);
      } else {
        cmp.insert(prtlAdmApp);
      }
      saveEduInfo(inForm, appNo, cmp);
      saveLangInfo(inForm, appNo, cmp);
    }
    catch (Exception e)
    {
      retList = new ArrayList();
      retList.add(e);
      logger.error("*** AdmApplicationSaveUseCase.execute has ComponentException detials :" + e.toString());
      System.err.println("*** AdmApplicationSaveUseCase.execute has ComponentException detials :" + e.toString());
    }
    return retList;
  }
  
  private void fillPrtlAdmAppData(PrtlAdmApplication prtlAdmApp, AdmApplicationForm inForm)
  {
    prtlAdmApp.setAppStatus(inForm.getAppStatus());
    if ((inForm.getAdmStatus() != null) && (!inForm.getAdmStatus().equals(""))) {
      prtlAdmApp.setAdmStatus(inForm.getAdmStatus());
    } else {
      prtlAdmApp.setAdmStatus("0");
    }
    prtlAdmApp.setAppStudentCat(inForm.getAppStudentCat());
    prtlAdmApp.setFirstName(inForm.getFirstName());
    prtlAdmApp.setSecondName(inForm.getSecondName());
    prtlAdmApp.setThirdName(inForm.getThirdName());
    prtlAdmApp.setFamilyName(inForm.getFamilyName());
    prtlAdmApp.setFirstNameE(inForm.getFirstNameE());
    prtlAdmApp.setSecondNameE(inForm.getSecondNameE());
    prtlAdmApp.setThirdNameE(inForm.getThirdNameE());
    prtlAdmApp.setFamilyNameE(inForm.getFamilyNameE());
    prtlAdmApp.setGender(inForm.getGender());
    if (FormCmp.isSelected(inForm.getIdcardType())) {
      prtlAdmApp.setIdcardType(inForm.getIdcardType());
    }
    prtlAdmApp.setIdcardNo(inForm.getIdcardNo());
    prtlAdmApp.setFatherName(inForm.getFatherName());
    if (FormCmp.isSelected(inForm.getFatherCert())) {
      prtlAdmApp.setFatherCert(inForm.getFatherCert());
    }
    if (FormCmp.isSelected(inForm.getFatherJob())) {
      prtlAdmApp.setFatherJob(inForm.getFatherJob());
    }
    prtlAdmApp.setMotherName(inForm.getMotherName());
    if (FormCmp.isSelected(inForm.getMotherCert())) {
      prtlAdmApp.setMotherCert(inForm.getMotherCert());
    }
    if (FormCmp.isSelected(inForm.getMotherJob())) {
      prtlAdmApp.setMotherJob(inForm.getMotherJob());
    }
    prtlAdmApp.setPerBoxNo(inForm.getPerBoxNo());
    prtlAdmApp.setPerStreet(inForm.getPerStreet());
    if (FormCmp.isSelected(inForm.getPerCountry())) {
      prtlAdmApp.setPerCountry(inForm.getPerCountry());
    }
    if (FormCmp.isSelected(inForm.getPerGovernate())) {
      prtlAdmApp.setPerGovernate(inForm.getPerGovernate());
    }
    if (FormCmp.isSelected(inForm.getPerLocality())) {
      prtlAdmApp.setPerLocality(inForm.getPerLocality());
    }
    prtlAdmApp.setPerTel(inForm.getPerTel());
    prtlAdmApp.setPerMobile(inForm.getPerMobile());
    prtlAdmApp.setPerEmail(inForm.getPerEmail());
    prtlAdmApp.setCurrBoxNo(inForm.getCurrBoxNo());
    prtlAdmApp.setCurrStreet(inForm.getCurrStreet());
    if (FormCmp.isSelected(inForm.getCurrCountry())) {
      prtlAdmApp.setCurrCountry(inForm.getCurrCountry());
    }
    if (FormCmp.isSelected(inForm.getCurrGovernate())) {
      prtlAdmApp.setCurrGovernate(inForm.getCurrGovernate());
    }
    if (FormCmp.isSelected(inForm.getCurrLocality())) {
      prtlAdmApp.setCurrLocality(inForm.getCurrLocality());
    }
    prtlAdmApp.setCurrTel(inForm.getCurrTel());
    prtlAdmApp.setCurrMobile(inForm.getCurrMobile());
    prtlAdmApp.setCurrEmail(inForm.getCurrEmail());
    if (FormCmp.isSelected(inForm.getBirthCountry())) {
      prtlAdmApp.setBirthCountry(inForm.getBirthCountry());
    }
    if (FormCmp.isSelected(inForm.getBirthLocality())) {
      prtlAdmApp.setBirthLocality(inForm.getBirthLocality());
    }
    if (FormCmp.isSelected(inForm.getBirthGovernate())) {
      prtlAdmApp.setBirthGovernate(inForm.getBirthGovernate());
    }
    prtlAdmApp.setBirthDate(FormCmp.convertStringToDate(inForm.getBirthDate()));
    if (FormCmp.isSelected(inForm.getMaritalStatus())) {
      prtlAdmApp.setMaritalStatus(inForm.getMaritalStatus());
    }
    if ((inForm.getNoOfChildrens() != null) && (!inForm.getNoOfChildrens().equals("")) && (!inForm.getMaritalStatus().equals("1"))) {
      prtlAdmApp.setNoOfChildrens(new Integer(inForm.getNoOfChildrens()));
    } else {
      prtlAdmApp.setNoOfChildrens(new Integer(0));
    }
    if (FormCmp.isSelected(inForm.getNationality())) {
      prtlAdmApp.setNationality(inForm.getNationality());
    }
    if (FormCmp.isSelected(inForm.getHealthStatus())) {
      prtlAdmApp.setHealthStatus(inForm.getHealthStatus());
    }
    prtlAdmApp.setEmergencyAddress(inForm.getEmergencyAddress());
    prtlAdmApp.setEmergencyTel(inForm.getEmergencyTel());
    prtlAdmApp.setHealthSituation(inForm.getHealthSituation());
    if (FormCmp.isSelected(inForm.getSchoolNo())) {
      prtlAdmApp.setSchoolNo(inForm.getSchoolNo());
    }
    prtlAdmApp.setSchoolBoxNo(inForm.getSchoolBoxNo());
    prtlAdmApp.setSchoolStreet(inForm.getSchoolStreet());
    if (FormCmp.isSelected(inForm.getSchoolCountry())) {
      prtlAdmApp.setSchoolCountry(inForm.getSchoolCountry());
    }
    if (FormCmp.isSelected(inForm.getSchoolGovernate())) {
      prtlAdmApp.setSchoolGovernate(inForm.getSchoolGovernate());
    }
    if (FormCmp.isSelected(inForm.getSchoolLocality())) {
      prtlAdmApp.setSchoolLocality(inForm.getSchoolLocality());
    }
    prtlAdmApp.setSchoolType(inForm.getSchoolType());
    if (FormCmp.isSelected(inForm.getTawOrigin())) {
      prtlAdmApp.setTawOrigin(inForm.getTawOrigin());
    }
    prtlAdmApp.setTawYear(inForm.getTawYear());
    if ((inForm.getTawAvg() != null) && (!inForm.getTawAvg().equals(""))) {
      prtlAdmApp.setTawAvg(new Double(inForm.getTawAvg()));
    } else {
      prtlAdmApp.setTawAvg(new Double(0.0D));
    }
    prtlAdmApp.setTawSeat(inForm.getTawSeat());
    if (FormCmp.isSelected(inForm.getTawBranch())) {
      prtlAdmApp.setTawBranch(inForm.getTawBranch());
    }
    if ((inForm.getEnglishMark() != null) && (!inForm.getEnglishMark().equals(""))) {
      prtlAdmApp.setEnglishMark(new Integer(inForm.getEnglishMark()));
    } else {
      prtlAdmApp.setEnglishMark(new Integer(0));
    }
    if (FormCmp.isSelected(inForm.getCollegeNo())) {
      prtlAdmApp.setCollegeNo(inForm.getCollegeNo());
    }
    if (FormCmp.isSelected(inForm.getSpecNo())) {
      prtlAdmApp.setSpecNo(inForm.getSpecNo());
    }
    if (FormCmp.isSelected(inForm.getCollegeNoOther())) {
      prtlAdmApp.setCollegeNoOther(inForm.getCollegeNoOther());
    }
    if (FormCmp.isSelected(inForm.getSpecNoOther())) {
      prtlAdmApp.setSpecNoOther(inForm.getSpecNoOther());
    }
    prtlAdmApp.setTimeStamp(new Date());
  }
  
  private void saveEduInfo(AdmApplicationForm inForm, String appNo, DataAccessObjectImpl cmp)
    throws ComponentException
  {
    if (isSelected(inForm.getEduUcNo_1()))
    {
      PrtlAdmEducation prtlAdmEdu_1 = new PrtlAdmEducation();
      PrtlAdmEducationPK prtlAdmEduPK_1 = new PrtlAdmEducationPK();
      prtlAdmEduPK_1.setUcNo(inForm.getEduUcNo_1());
      prtlAdmEduPK_1.setAppNo(appNo);
      prtlAdmEduPK_1.setEduStartDate(FormCmp.convertStringToDate(inForm.getEduStartDate_1()));
      prtlAdmEdu_1.setComp_id(prtlAdmEduPK_1);
      prtlAdmEdu_1.setEduEndDate(FormCmp.convertStringToDate(inForm.getEduEndDate_1()));
      prtlAdmEdu_1.setSpecTypeNo(inForm.getEduSpecTypeNo_1());
      prtlAdmEdu_1.setSpecNo(inForm.getRsdSpecNo_1());
      prtlAdmEdu_1.setEduGradeDate(FormCmp.convertStringToDate(inForm.getEduGradeDate_1()));
      prtlAdmEdu_1.setUcCountry(inForm.getEduUcCountry_1());
      prtlAdmEdu_1.setUcGovernate(inForm.getEduUcGovernate_1());
      prtlAdmEdu_1.setUcLocality(inForm.getEduUcLocality_1());
      prtlAdmEdu_1.setTimeStamp(new Date());
      cmp.insertOrUpdate(prtlAdmEdu_1);
    }
    if (isSelected(inForm.getEduUcNo_2()))
    {
      PrtlAdmEducation prtlAdmEdu_2 = new PrtlAdmEducation();
      PrtlAdmEducationPK prtlAdmEduPK_2 = new PrtlAdmEducationPK();
      prtlAdmEduPK_2.setUcNo(inForm.getEduUcNo_2());
      prtlAdmEduPK_2.setAppNo(appNo);
      prtlAdmEduPK_2.setEduStartDate(FormCmp.convertStringToDate(inForm.getEduStartDate_2()));
      prtlAdmEdu_2.setComp_id(prtlAdmEduPK_2);
      prtlAdmEdu_2.setEduEndDate(FormCmp.convertStringToDate(inForm.getEduEndDate_2()));
      prtlAdmEdu_2.setSpecTypeNo(inForm.getEduSpecTypeNo_2());
      prtlAdmEdu_2.setSpecNo(inForm.getRsdSpecNo_2());
      prtlAdmEdu_2.setEduGradeDate(FormCmp.convertStringToDate(inForm.getEduGradeDate_2()));
      prtlAdmEdu_2.setUcCountry(inForm.getEduUcCountry_2());
      prtlAdmEdu_2.setUcGovernate(inForm.getEduUcGovernate_2());
      prtlAdmEdu_2.setUcLocality(inForm.getEduUcLocality_2());
      prtlAdmEdu_2.setTimeStamp(new Date());
      
      cmp.insertOrUpdate(prtlAdmEdu_2);
    }
    if (isSelected(inForm.getEduUcNo_3()))
    {
      PrtlAdmEducation prtlAdmEdu_3 = new PrtlAdmEducation();
      PrtlAdmEducationPK prtlAdmEduPK_3 = new PrtlAdmEducationPK();
      prtlAdmEduPK_3.setUcNo(inForm.getEduUcNo_3());
      prtlAdmEduPK_3.setAppNo(appNo);
      prtlAdmEduPK_3.setEduStartDate(FormCmp.convertStringToDate(inForm.getEduStartDate_3()));
      prtlAdmEdu_3.setComp_id(prtlAdmEduPK_3);
      prtlAdmEdu_3.setEduEndDate(FormCmp.convertStringToDate(inForm.getEduEndDate_3()));
      prtlAdmEdu_3.setSpecTypeNo(inForm.getEduSpecTypeNo_3());
      prtlAdmEdu_3.setSpecNo(inForm.getRsdSpecNo_3());
      prtlAdmEdu_3.setEduGradeDate(FormCmp.convertStringToDate(inForm.getEduGradeDate_3()));
      prtlAdmEdu_3.setUcCountry(inForm.getEduUcCountry_3());
      prtlAdmEdu_3.setUcGovernate(inForm.getEduUcGovernate_3());
      prtlAdmEdu_3.setUcLocality(inForm.getEduUcLocality_3());
      prtlAdmEdu_3.setTimeStamp(new Date());
      
      cmp.insertOrUpdate(prtlAdmEdu_3);
    }
  }
  
  private void saveLangInfo(AdmApplicationForm inForm, String appNo, DataAccessObjectImpl cmp)
    throws ComponentException
  {
    if (isSelected(inForm.getLngLangNo_1()))
    {
      PrtlAdmLanguage prtlAdmLang_1 = new PrtlAdmLanguage();
      PrtlAdmLanguagePK prtlAdmLangPK_1 = new PrtlAdmLanguagePK();
      prtlAdmLangPK_1.setAppNo(appNo);
      prtlAdmLangPK_1.setLangNo(inForm.getLngLangNo_1());
      prtlAdmLang_1.setComp_id(prtlAdmLangPK_1);
      if (FormCmp.isSelected(inForm.getLngReadLevelNo_1())) {
        prtlAdmLang_1.setReadLevelNo(inForm.getLngReadLevelNo_1());
      }
      if (FormCmp.isSelected(inForm.getLngWriteLevelNo_1())) {
        prtlAdmLang_1.setWriteLevelNo(inForm.getLngWriteLevelNo_1());
      }
      if (FormCmp.isSelected(inForm.getLngSpeakLevelNo_1())) {
        prtlAdmLang_1.setSpeakLevelNo(inForm.getLngSpeakLevelNo_1());
      }
      prtlAdmLang_1.setTimeStamp(new Date());
      cmp.insertOrUpdate(prtlAdmLang_1);
    }
    if (isSelected(inForm.getLngLangNo_2()))
    {
      PrtlAdmLanguage prtlAdmLang_2 = new PrtlAdmLanguage();
      PrtlAdmLanguagePK prtlAdmLangPK_2 = new PrtlAdmLanguagePK();
      prtlAdmLangPK_2.setAppNo(appNo);
      prtlAdmLangPK_2.setLangNo(inForm.getLngLangNo_2());
      prtlAdmLang_2.setComp_id(prtlAdmLangPK_2);
      if (FormCmp.isSelected(inForm.getLngReadLevelNo_2())) {
        prtlAdmLang_2.setReadLevelNo(inForm.getLngReadLevelNo_2());
      }
      if (FormCmp.isSelected(inForm.getLngWriteLevelNo_2())) {
        prtlAdmLang_2.setWriteLevelNo(inForm.getLngWriteLevelNo_2());
      }
      if (FormCmp.isSelected(inForm.getLngSpeakLevelNo_2())) {
        prtlAdmLang_2.setSpeakLevelNo(inForm.getLngSpeakLevelNo_2());
      }
      prtlAdmLang_2.setTimeStamp(new Date());
      cmp.insertOrUpdate(prtlAdmLang_2);
    }
    if (isSelected(inForm.getLngLangNo_3()))
    {
      PrtlAdmLanguage prtlAdmLang_3 = new PrtlAdmLanguage();
      PrtlAdmLanguagePK prtlAdmLangPK_3 = new PrtlAdmLanguagePK();
      prtlAdmLangPK_3.setAppNo(appNo);
      prtlAdmLangPK_3.setLangNo(inForm.getLngLangNo_3());
      prtlAdmLang_3.setComp_id(prtlAdmLangPK_3);
      if (FormCmp.isSelected(inForm.getLngReadLevelNo_3())) {
        prtlAdmLang_3.setReadLevelNo(inForm.getLngReadLevelNo_3());
      }
      if (FormCmp.isSelected(inForm.getLngWriteLevelNo_3())) {
        prtlAdmLang_3.setWriteLevelNo(inForm.getLngWriteLevelNo_3());
      }
      if (FormCmp.isSelected(inForm.getLngSpeakLevelNo_3())) {
        prtlAdmLang_3.setSpeakLevelNo(inForm.getLngSpeakLevelNo_3());
      }
      prtlAdmLang_3.setTimeStamp(new Date());
      cmp.insertOrUpdate(prtlAdmLang_3);
    }
  }
  
  private boolean isSelected(String item)
  {
    boolean res = false;
    if ((item != null) && (!item.equals("")) && (!item.equals("*"))) {
      res = true;
    }
    return res;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.admission.useCase.AdmApplicationSaveUseCase
 * JD-Core Version:    0.7.0.1
 */