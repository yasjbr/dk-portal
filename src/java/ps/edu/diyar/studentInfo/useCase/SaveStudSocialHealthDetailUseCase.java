package ps.edu.diyar.studentInfo.useCase;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.apache.struts.upload.FormFile;
import org.hibernate.HibernateException;
import ps.edu.diyar.common.component.FormCmp;
import ps.edu.diyar.common.useCase.ComponentUseCase;
import ps.edu.diyar.studentInfo.component.StudentInfoComponent;
import ps.edu.diyar.studentInfo.database.SrvyHealthDetail;
import ps.edu.diyar.studentInfo.database.SrvyHealthDetailPK;

public class SaveStudSocialHealthDetailUseCase
  implements ComponentUseCase
{
  private static Logger logger = Logger.getLogger(SaveStudSocialHealthDetailUseCase.class);
  
  public Collection execute(Collection input, HttpServletRequest request)
    throws HibernateException
  {
    Collection retList = null;
    Iterator itr = input.iterator();
    
    String studId = (String)itr.next();
    String termNo = (String)itr.next();
    String familyHasInsurance = (String)itr.next();
    String insFamilyMembers = (String)itr.next();
    String insuranceType = (String)itr.next();
    String familyHasJerusalem = (String)itr.next();
    String jerFamilyMembers = (String)itr.next();
    String isFamilyHasChronic = (String)itr.next();
    String chronicName = (String)itr.next();
    FormFile medicalReport = (FormFile)itr.next();
    String patientName = (String)itr.next();
    String patientAge = (String)itr.next();
    String patientRelative = (String)itr.next();
    String hasDisabilities = (String)itr.next();
    String disabilitiesCount = (String)itr.next();
    String disabilitiesDesc = (String)itr.next();
    try
    {
      StudentInfoComponent cmp = new StudentInfoComponent();
      
      SrvyHealthDetailPK objPk = new SrvyHealthDetailPK(studId, termNo);
      SrvyHealthDetail obj = new SrvyHealthDetail(objPk);
      
      obj.setFamilyHasInsurance(familyHasInsurance);
      if ((familyHasInsurance != null) && (familyHasInsurance.trim().equals("Y")))
      {
        if ((insFamilyMembers != null) && (!insFamilyMembers.trim().equals("")) && (FormCmp.isInteger(insFamilyMembers.trim()))) {
          obj.setInsFamilyMembers(new Integer(insFamilyMembers.trim()));
        }
        obj.setInsuranceType(insuranceType);
      }
      obj.setFamilyHasJerusalem(familyHasJerusalem);
      if ((familyHasJerusalem != null) && (familyHasJerusalem.trim().equals("Y"))) {
        if ((jerFamilyMembers != null) && (!jerFamilyMembers.trim().equals("")) && (FormCmp.isInteger(jerFamilyMembers.trim()))) {
          obj.setJerFamilyMembers(new Integer(jerFamilyMembers.trim()));
        }
      }
      obj.setIsFamilyHasChronic(isFamilyHasChronic);
      if ((isFamilyHasChronic != null) && (isFamilyHasChronic.trim().equals("Y")))
      {
        obj.setChronicName(chronicName);
        
        obj.setPatientName(patientName);
        if ((patientAge != null) && (!patientAge.trim().equals("")) && (FormCmp.isInteger(patientAge.trim()))) {
          obj.setPatientAge(new Integer(patientAge.trim()));
        }
        obj.setPatientRelative(patientRelative);
      }
      obj.setHasDisabilities(hasDisabilities);
      if ((disabilitiesCount != null) && (disabilitiesCount.trim().equals("Y")))
      {
        if ((disabilitiesCount != null) && (!disabilitiesCount.trim().equals("")) && (FormCmp.isInteger(disabilitiesCount.trim()))) {
          obj.setDisabilitiesCount(new Integer(disabilitiesCount.trim()));
        }
        obj.setDisabilitiesDesc(disabilitiesDesc);
      }
      cmp.saveStudSocialHealthDetail(obj, medicalReport);
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
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.useCase.SaveStudSocialHealthDetailUseCase
 * JD-Core Version:    0.7.0.1
 */