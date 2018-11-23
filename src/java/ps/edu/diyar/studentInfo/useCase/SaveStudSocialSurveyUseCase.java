package ps.edu.diyar.studentInfo.useCase;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import ps.edu.diyar.common.component.DataAccessObjectImpl;
import ps.edu.diyar.common.tools.DateTool;
import ps.edu.diyar.common.useCase.ComponentUseCase;
import ps.edu.diyar.studentInfo.component.StudentInfoComponent;
import ps.edu.diyar.studentInfo.database.SrvyMaster;
import ps.edu.diyar.studentInfo.database.SrvyMasterPK;

public class SaveStudSocialSurveyUseCase
  implements ComponentUseCase
{
  private static Logger logger = Logger.getLogger(SaveStudSocialSurveyUseCase.class);
  
  public Collection execute(Collection input, HttpServletRequest request)
    throws HibernateException
  {
    Collection retList = null;
    Iterator itr = input.iterator();
    
    String studId = (String)itr.next();
    String termNo = (String)itr.next();
    String fatherAName = (String)itr.next();
    String fatherIdCardType = (String)itr.next();
    String fatherIdCard = (String)itr.next();
    String fatherDob = (String)itr.next();
    String fatherAcademicLevel = (String)itr.next();
    String motherAName = (String)itr.next();
    String motherIdCardType = (String)itr.next();
    String motherIdCard = (String)itr.next();
    String motherDob = (String)itr.next();
    String motherAcademicLevel = (String)itr.next();
    String familyCountAll = (String)itr.next();
    String familyCountUnder18 = (String)itr.next();
    String brothersCount = (String)itr.next();
    String sistersCount = (String)itr.next();
    String otherMaleCount = (String)itr.next();
    String otherFemaleCount = (String)itr.next();
    String wifeOneAName = (String)itr.next();
    String wifeOneDob = (String)itr.next();
    String wifeOneIdCardType = (String)itr.next();
    String wifeOneIdCard = (String)itr.next();
    String wifeOneAcadmicLevel = (String)itr.next();
    String childrenCount = (String)itr.next();
    
    String otherAcademicExpensive = (String)itr.next();
    String otherAcademicCost = (String)itr.next();
    
    String haveOtherWork = (String)itr.next();
    String otherWork = (String)itr.next();
    String otherWorkCrossIncome = (String)itr.next();
    String familyIncome = (String)itr.next();
    String familyUnemployed = (String)itr.next();
    String unemployedResons = (String)itr.next();
    String[] payer = (String[])itr.next();
    String otherPayer = (String)itr.next();
    

    String userId = (String)itr.next();
    String ipAddress = (String)itr.next();
    try
    {
      DataAccessObjectImpl cmp = new DataAccessObjectImpl();
      StudentInfoComponent studCmp = new StudentInfoComponent();
      
      SrvyMasterPK srvyMasterPK = new SrvyMasterPK(studId, termNo);
      SrvyMaster srvyMaster = new SrvyMaster(srvyMasterPK);
      srvyMaster.setOtherAcademicExpensive(otherAcademicExpensive);
      setValObj_srvyMaster(srvyMaster, fatherAName, fatherIdCardType, fatherIdCard, fatherDob, fatherAcademicLevel, motherAName, motherIdCardType, motherIdCard, motherDob, motherAcademicLevel, familyCountAll, familyCountUnder18, brothersCount, sistersCount, otherMaleCount, otherFemaleCount, wifeOneAName, wifeOneDob, wifeOneIdCardType, wifeOneIdCard, wifeOneAcadmicLevel, childrenCount, otherAcademicCost, haveOtherWork, otherWork, otherWorkCrossIncome, familyIncome, familyUnemployed, unemployedResons, otherPayer, userId, ipAddress);
      


















      cmp.insertOrUpdate(srvyMaster);
      

      studCmp.saveSrvyPayer(payer, studId, termNo);
    }
    catch (Exception e)
    {
      logger.error("*** Error in " + getClass().getName() + ".execute has ComponentException detials :" + e.toString());
      System.err.println("*** Error in " + getClass().getName() + ".execute has ComponentException detials :" + e.toString());
      retList = new ArrayList();
      retList.add(e);
    }
    return retList;
  }
  
  private SrvyMaster setValObj_srvyMaster(SrvyMaster srvyMaster, String fatherAName, String fatherIdCardType, String fatherIdCard, String fatherDob, String fatherAcademicLevel, String motherAName, String motherIdCardType, String motherIdCard, String motherDob, String motherAcademicLevel, String familyCountAll, String familyCountUnder18, String brothersCount, String sistersCount, String otherMaleCount, String otherFemaleCount, String wifeOneAName, String wifeOneDob, String wifeOneIdCardType, String wifeOneIdCard, String wifeOneAcadmicLevel, String childrenCount, String otherAcademicCost, String haveOtherWork, String otherWork, String otherWorkCrossIncome, String familyIncome, String familyUnemployed, String unemployedResons, String otherPayer, String userId, String ipAddress)
  {
    if ((fatherAName != null) && (!fatherAName.trim().equals(""))) {
      srvyMaster.setFatherAName(fatherAName);
    }
    if ((fatherIdCardType != null) && (!fatherIdCardType.trim().equals(""))) {
      srvyMaster.setFatherIdCardType(fatherIdCardType);
    }
    if ((fatherIdCard != null) && (!fatherIdCard.trim().equals(""))) {
      srvyMaster.setFatherIdCard(fatherIdCard);
    }
    if ((fatherDob != null) && (!fatherDob.trim().equals(""))) {
      srvyMaster.setFatherDob(DateTool.convertStringToDate_dd_mm_yyyy(fatherDob));
    }
    if ((fatherAcademicLevel != null) && (!fatherAcademicLevel.trim().equals(""))) {
      srvyMaster.setFatherAcademicLevel(fatherAcademicLevel);
    }
    if ((motherAName != null) && (!motherAName.trim().equals(""))) {
      srvyMaster.setMotherAName(motherAName);
    }
    if ((motherIdCardType != null) && (!motherIdCardType.trim().equals(""))) {
      srvyMaster.setMotherIdCardType(motherIdCardType);
    }
    if ((motherIdCard != null) && (!motherIdCard.trim().equals(""))) {
      srvyMaster.setMotherIdCard(motherIdCard);
    }
    if ((motherDob != null) && (!motherDob.trim().equals(""))) {
      srvyMaster.setMotherDob(DateTool.convertStringToDate_dd_mm_yyyy(motherDob));
    }
    if ((motherAcademicLevel != null) && (!motherAcademicLevel.trim().equals(""))) {
      srvyMaster.setMotherAcademicLevel(motherAcademicLevel);
    }
    if ((familyCountAll != null) && (!familyCountAll.trim().equals(""))) {
      srvyMaster.setFamilyCountAll(new Integer(familyCountAll));
    }
    if ((familyCountUnder18 != null) && (!familyCountUnder18.trim().equals(""))) {
      srvyMaster.setFamilyCountUnder18(new Integer(familyCountUnder18));
    }
    if ((brothersCount != null) && (!brothersCount.trim().equals(""))) {
      srvyMaster.setBrothersCount(new Integer(brothersCount));
    }
    if ((sistersCount != null) && (!sistersCount.trim().equals(""))) {
      srvyMaster.setSistersCount(new Integer(sistersCount));
    }
    if ((otherMaleCount != null) && (!otherMaleCount.trim().equals(""))) {
      srvyMaster.setOtherMaleCount(new Integer(otherMaleCount));
    }
    if ((otherFemaleCount != null) && (!otherFemaleCount.trim().equals(""))) {
      srvyMaster.setOtherFemaleCount(new Integer(otherFemaleCount));
    }
    if ((wifeOneAName != null) && (!wifeOneAName.trim().equals(""))) {
      srvyMaster.setWifeOneAName(wifeOneAName);
    }
    if ((wifeOneDob != null) && (!wifeOneDob.trim().equals(""))) {
      srvyMaster.setWifeOneDob(DateTool.convertStringToDate_dd_mm_yyyy(wifeOneDob));
    }
    if ((wifeOneIdCardType != null) && (!wifeOneIdCardType.trim().equals(""))) {
      srvyMaster.setWifeOneIdCardType(wifeOneIdCardType);
    }
    if ((wifeOneIdCard != null) && (!wifeOneIdCard.trim().equals(""))) {
      srvyMaster.setWifeOneIdCard(wifeOneIdCard);
    }
    if ((wifeOneAcadmicLevel != null) && (!wifeOneAcadmicLevel.trim().equals(""))) {
      srvyMaster.setWifeOneAcadmicLevel(wifeOneAcadmicLevel);
    }
    if ((childrenCount != null) && (!childrenCount.trim().equals(""))) {
      srvyMaster.setChildrenCount(new Integer(childrenCount));
    }
    if ((otherAcademicCost != null) && (!otherAcademicCost.trim().equals(""))) {
      srvyMaster.setOtherAcademicCost(new Double(otherAcademicCost));
    }
    srvyMaster.setHaveOtherWork(haveOtherWork);
    if ((haveOtherWork != null) && (haveOtherWork.trim().equals("Y")))
    {
      srvyMaster.setOtherWork(otherWork);
      if ((otherWorkCrossIncome != null) && (!otherWorkCrossIncome.trim().equals(""))) {
        srvyMaster.setOtherWorkCrossIncome(new Double(otherWorkCrossIncome));
      }
    }
    srvyMaster.setFamilyIncome(familyIncome);
    if ((familyUnemployed != null) && (!familyUnemployed.trim().equals(""))) {
      srvyMaster.setFamilyUnemployed(new Integer(familyUnemployed));
    }
    srvyMaster.setUnemployedResons(unemployedResons);
    srvyMaster.setOtherPayer(otherPayer);
    if ((userId != null) && (!userId.trim().equals(""))) {
      srvyMaster.setUserId(userId);
    }
    if ((ipAddress != null) && (!ipAddress.trim().equals(""))) {
      srvyMaster.setIpAddress(ipAddress);
    }
    srvyMaster.setTimpeStamp(new Date());
    

    return srvyMaster;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.useCase.SaveStudSocialSurveyUseCase
 * JD-Core Version:    0.7.0.1
 */