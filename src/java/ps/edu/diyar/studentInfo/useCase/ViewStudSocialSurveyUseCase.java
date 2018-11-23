package ps.edu.diyar.studentInfo.useCase;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.HibernateException;
import ps.edu.diyar.admission.useCase.GetGovernateListUseCase;
import ps.edu.diyar.admission.useCase.GetLocalityListUseCase;
import ps.edu.diyar.common.component.DataAccessObjectImpl;
import ps.edu.diyar.common.tools.DateTool;
import ps.edu.diyar.common.useCase.ComponentUseCase;
import ps.edu.diyar.studentInfo.component.StudentInfoComponent;
import ps.edu.diyar.studentInfo.database.SrvyMaster;
import ps.edu.diyar.studentInfo.database.SurveyStudInfoVw;
import ps.edu.diyar.studentInfo.forms.StudSocialSurveyForm;

public class ViewStudSocialSurveyUseCase
  implements ComponentUseCase
{
  public Collection execute(Collection input, HttpServletRequest request)
    throws HibernateException
  {
    List returnList = null;
    
    boolean fillAllData = true;
    
    Iterator itr = input.iterator();
    String studId = (String)itr.next();
    String termNo = (String)itr.next();
    StudSocialSurveyForm inForm = (StudSocialSurveyForm)itr.next();
    if (itr.hasNext()) {
      fillAllData = ((Boolean)itr.next()).booleanValue();
    }
    try
    {
      DataAccessObjectImpl cmp = new DataAccessObjectImpl();
      StudentInfoComponent studCmp = new StudentInfoComponent();
      
      returnList = cmp.getList("stud.getSurveyStudInfo", new Object[] { studId });
      if ((returnList != null) && (returnList.size() > 0))
      {
        SurveyStudInfoVw studInfo = (SurveyStudInfoVw)returnList.iterator().next();
        
        inForm.setPerCountry(studInfo.getPerCountry());
        inForm.setPerGovernate(studInfo.getPerGovernate());
        inForm.setPerLocality(studInfo.getPerLocality());
        inForm.setCurrCountry(studInfo.getCurrCountry());
        inForm.setCurrGovernate(studInfo.getCurrGovernate());
        inForm.setCurrLocality(studInfo.getCurrLocality());
        inForm.setBirthCountry(studInfo.getBirthCountry());
        inForm.setBirthGovernate(studInfo.getBirthGovernate());
        inForm.setBirthLocality(studInfo.getBirthLocality());
        inForm.setEdit(true);
        



        List countryList = cmp.getList("adm.getCountrylList");
        if ((countryList != null) && (countryList.size() > 0)) {
          request.setAttribute("countryList", countryList);
        }
        if ((studInfo.getPerCountry() != null) && (!studInfo.getPerCountry().equals("")) && (!studInfo.getPerCountry().equals("*")))
        {
          ArrayList perGovernateList = new ArrayList();
          perGovernateList.add(studInfo.getPerCountry());
          Collection perGovernateResList = new GetGovernateListUseCase().execute(perGovernateList, request);
          if ((perGovernateResList != null) && (perGovernateResList.size() > 0)) {
            request.setAttribute("perGovernateList", perGovernateResList);
          }
        }
        if ((studInfo.getCurrCountry() != null) && (!studInfo.getCurrCountry().equals("")) && (!studInfo.getCurrCountry().equals("*")))
        {
          ArrayList currGovernateList = new ArrayList();
          currGovernateList.add(studInfo.getCurrCountry());
          Collection currGovernateResList = new GetGovernateListUseCase().execute(currGovernateList, request);
          if ((currGovernateResList != null) && (currGovernateResList.size() > 0)) {
            request.setAttribute("currGovernateList", currGovernateResList);
          }
        }
        if ((studInfo.getBirthCountry() != null) && (!studInfo.getBirthCountry().equals("")) && (!studInfo.getBirthCountry().equals("*")))
        {
          ArrayList birthGovernateList = new ArrayList();
          birthGovernateList.add(studInfo.getBirthCountry());
          Collection birthGovernateResList = new GetGovernateListUseCase().execute(birthGovernateList, request);
          if ((birthGovernateResList != null) && (birthGovernateResList.size() > 0)) {
            request.setAttribute("birthGovernateList", birthGovernateResList);
          }
        }
        if ((studInfo.getPerCountry() != null) && (!studInfo.getPerCountry().equals("")) && (!studInfo.getPerCountry().equals("*")) && (studInfo.getPerGovernate() != null) && (!studInfo.getPerGovernate().equals("")) && (!studInfo.getPerGovernate().equals("*")))
        {
          ArrayList perLocalityList = new ArrayList();
          perLocalityList.add(studInfo.getPerGovernate());
          perLocalityList.add(studInfo.getPerCountry());
          Collection perLocalityResList = new GetLocalityListUseCase().execute(perLocalityList, request);
          if ((perLocalityResList != null) && (perLocalityResList.size() > 0)) {
            request.setAttribute("perLocalityList", perLocalityResList);
          }
        }
        if ((studInfo.getCurrCountry() != null) && (!studInfo.getCurrCountry().equals("")) && (!studInfo.getCurrCountry().equals("*")) && (studInfo.getCurrGovernate() != null) && (!studInfo.getCurrGovernate().equals("")) && (!studInfo.getCurrGovernate().equals("*")))
        {
          ArrayList currLocalityList = new ArrayList();
          currLocalityList.add(studInfo.getCurrGovernate());
          currLocalityList.add(studInfo.getCurrCountry());
          Collection currLocalityResList = new GetLocalityListUseCase().execute(currLocalityList, request);
          if ((currLocalityResList != null) && (currLocalityResList.size() > 0)) {
            request.setAttribute("currLocalityList", currLocalityResList);
          }
        }
        if ((studInfo.getBirthCountry() != null) && (!studInfo.getBirthCountry().equals("")) && (!studInfo.getBirthCountry().equals("*")) && (studInfo.getBirthGovernate() != null) && (!studInfo.getBirthGovernate().equals("")) && (!studInfo.getBirthGovernate().equals("*")))
        {
          ArrayList birthLocalityList = new ArrayList();
          birthLocalityList.add(studInfo.getBirthGovernate());
          birthLocalityList.add(studInfo.getBirthCountry());
          Collection birthLocalityResList = new GetLocalityListUseCase().execute(birthLocalityList, request);
          if ((birthLocalityResList != null) && (birthLocalityResList.size() > 0)) {
            request.setAttribute("birthLocalityList", birthLocalityResList);
          }
        }
      }
      if (!fillAllData) {
        return returnList;
      }
      Collection resultList = cmp.getList("stud.getSrvyMasterInfo", new Object[] { studId, termNo });
      if ((resultList != null) && (resultList.size() > 0))
      {
        SrvyMaster obj = (SrvyMaster)resultList.iterator().next();
        inForm.setFatherAName(obj.getFatherAName());
        inForm.setFatherIdCardType(obj.getFatherIdCardType());
        inForm.setFatherIdCard(obj.getFatherIdCard());
        if (obj.getFatherDob() != null) {
          inForm.setFatherDob(DateTool.decorateYYYY_MM_DD(obj.getFatherDob()));
        }
        if (obj.getMotherDob() != null) {
          inForm.setMotherDob(DateTool.decorateYYYY_MM_DD(obj.getMotherDob()));
        }
        inForm.setFatherAcademicLevel(obj.getFatherAcademicLevel());
        inForm.setMotherAName(obj.getMotherAName());
        inForm.setMotherIdCardType(obj.getMotherIdCardType());
        inForm.setMotherIdCard(obj.getMotherIdCard());
        inForm.setMotherAcademicLevel(obj.getMotherAcademicLevel());
        if (obj.getFamilyCountAll() != null) {
          inForm.setFamilyCountAll(obj.getFamilyCountAll() + "");
        }
        if (obj.getFamilyCountUnder18() != null) {
          inForm.setFamilyCountUnder18(obj.getFamilyCountUnder18() + "");
        }
        if (obj.getBrothersCount() != null) {
          inForm.setBrothersCount(obj.getBrothersCount() + "");
        }
        if (obj.getSistersCount() != null) {
          inForm.setSistersCount(obj.getSistersCount() + "");
        }
        if (obj.getOtherMaleCount() != null) {
          inForm.setOtherMaleCount(obj.getOtherMaleCount() + "");
        }
        if (obj.getOtherFemaleCount() != null) {
          inForm.setOtherFemaleCount(obj.getOtherFemaleCount() + "");
        }
        if (obj.getWifeOneDob() != null) {
          inForm.setWifeOneDob(DateTool.decorateYYYY_MM_DD(obj.getWifeOneDob()));
        }
        if (obj.getChildrenCount() != null) {
          inForm.setChildrenCount(obj.getChildrenCount() + "");
        }
        if (obj.getOtherAcademicCost() != null) {
          inForm.setOtherAcademicCost(obj.getOtherAcademicCost() + "");
        }
        inForm.setOtherAcademicExpensive(obj.getOtherAcademicExpensive());
        
        inForm.setWifeOneAName(obj.getWifeOneAName());
        inForm.setWifeOneIdCardType(obj.getWifeOneIdCardType());
        inForm.setWifeOneIdCard(obj.getWifeOneIdCard());
        inForm.setWifeOneAcadmicLevel(obj.getWifeOneAcadmicLevel());
        

        inForm.setHaveOtherWork(obj.getHaveOtherWork());
        inForm.setOtherWork(obj.getOtherWork());
        if (obj.getOtherWorkCrossIncome() != null) {
          inForm.setOtherWorkCrossIncome(String.valueOf(obj.getOtherWorkCrossIncome()));
        }
        inForm.setFamilyIncome(obj.getFamilyIncome());
        if (obj.getFamilyUnemployed() != null) {
          inForm.setFamilyUnemployed(String.valueOf(obj.getFamilyUnemployed()));
        }
        inForm.setUnemployedResons(obj.getUnemployedResons());
        inForm.setOtherPayer(obj.getOtherPayer());
        
        String[] payer = studCmp.getPayer(studId, termNo);
        if ((payer != null) && (payer.length > 0)) {
          inForm.setPayer(payer);
        }
      }
    }
    catch (Exception e)
    {
      System.err.println("*** AdmApplicationLoadUseCase.execute has ComponentException detials :" + e.toString());
    }
    return returnList;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.useCase.ViewStudSocialSurveyUseCase
 * JD-Core Version:    0.7.0.1
 */