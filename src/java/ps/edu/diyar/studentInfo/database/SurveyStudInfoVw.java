package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;
import ps.edu.diyar.common.tools.DateTool;

public class SurveyStudInfoVw
  implements Serializable
{
  private String studId;
  private String firstName;
  private String secondName;
  private String thirdName;
  private String familyName;
  private String gender;
  private String idcardType;
  private String idcardNo;
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
  private String emergencyAddress;
  private String emergencyTel;
  private String schoolAName;
  private String statusAName;
  private String email;
  private String mobile;
  private String birthCountry;
  private String birthLocality;
  private String birthGovernate;
  private Date birthDate;
  private String specAName;
  
  public SurveyStudInfoVw(String studId, String firstName, String secondName, String thirdName, String familyName, String gender, String idcardType, String idcardNo, String perBoxNo, String perStreet, String perCountry, String perGovernate, String perLocality, String perTel, String perMobile, String perEmail, String currBoxNo, String currStreet, String currCountry, String currGovernate, String currLocality, String currTel, String currMobile, String currEmail, String emergencyAddress, String emergencyTel, String schoolAName, String statusAName, String email, String mobile)
  {
    this.studId = studId;
    this.firstName = firstName;
    this.secondName = secondName;
    this.thirdName = thirdName;
    this.familyName = familyName;
    this.gender = gender;
    this.idcardType = idcardType;
    this.idcardNo = idcardNo;
    this.perBoxNo = perBoxNo;
    this.perStreet = perStreet;
    this.perCountry = perCountry;
    this.perGovernate = perGovernate;
    this.perLocality = perLocality;
    this.perTel = perTel;
    this.perMobile = perMobile;
    this.perEmail = perEmail;
    this.currBoxNo = currBoxNo;
    this.currStreet = currStreet;
    this.currCountry = currCountry;
    this.currGovernate = currGovernate;
    this.currLocality = currLocality;
    this.currTel = currTel;
    this.currMobile = currMobile;
    this.currEmail = currEmail;
    this.emergencyAddress = emergencyAddress;
    this.emergencyTel = emergencyTel;
    this.schoolAName = schoolAName;
    this.statusAName = statusAName;
    this.email = email;
    this.mobile = mobile;
  }
  
  public SurveyStudInfoVw() {}
  
  public SurveyStudInfoVw(String studId, String firstName, String secondName, String thirdName, String familyName, String gender, String idcardType, String idcardNo, String emergencyAddress, String emergencyTel, String schoolAName, String statusAName)
  {
    this.studId = studId;
    this.firstName = firstName;
    this.secondName = secondName;
    this.thirdName = thirdName;
    this.familyName = familyName;
    this.gender = gender;
    this.idcardType = idcardType;
    this.idcardNo = idcardNo;
    this.emergencyAddress = emergencyAddress;
    this.emergencyTel = emergencyTel;
    this.schoolAName = schoolAName;
    this.statusAName = statusAName;
  }
  
  public String getSpecAName()
  {
    return this.specAName;
  }
  
  public void setSpecAName(String specAName)
  {
    this.specAName = specAName;
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
  
  public Date getBirthDate()
  {
    return this.birthDate;
  }
  
  public String getBirthDateFormatted()
  {
    return DateTool.decorateYYYY_MM_DD(this.birthDate);
  }
  
  public void setBirthDate(Date birthDate)
  {
    this.birthDate = birthDate;
  }
  
  public String getStudId()
  {
    return this.studId;
  }
  
  public void setStudId(String studId)
  {
    this.studId = studId;
  }
  
  public String getFirstName()
  {
    return this.firstName;
  }
  
  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }
  
  public String getSecondName()
  {
    return this.secondName;
  }
  
  public void setSecondName(String secondName)
  {
    this.secondName = secondName;
  }
  
  public String getThirdName()
  {
    return this.thirdName;
  }
  
  public void setThirdName(String thirdName)
  {
    this.thirdName = thirdName;
  }
  
  public String getFamilyName()
  {
    return this.familyName;
  }
  
  public void setFamilyName(String familyName)
  {
    this.familyName = familyName;
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
  
  public String getEmergencyAddress()
  {
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
  
  public String getSchoolAName()
  {
    return this.schoolAName;
  }
  
  public void setSchoolAName(String schoolAName)
  {
    this.schoolAName = schoolAName;
  }
  
  public String getStatusAName()
  {
    return this.statusAName;
  }
  
  public void setStatusAName(String statusAName)
  {
    this.statusAName = statusAName;
  }
  
  public String getEmail()
  {
    return this.email;
  }
  
  public void setEmail(String email)
  {
    this.email = email;
  }
  
  public String getMobile()
  {
    return this.mobile;
  }
  
  public void setMobile(String mobile)
  {
    this.mobile = mobile;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).toString();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.SurveyStudInfoVw
 * JD-Core Version:    0.7.0.1
 */