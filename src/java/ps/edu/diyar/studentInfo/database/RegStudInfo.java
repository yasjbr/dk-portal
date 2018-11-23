package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RegStudInfo
  implements Serializable
{
  private String studId;
  private String joinTermNo;
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
  private String birthCountry;
  private String birthLocality;
  private Date birthDate;
  private String maritalStatus;
  private String nationality;
  private String healthStatus;
  private String motherName;
  private String schoolNo;
  private String tawOrigin;
  private String tawYear;
  private Double tawAvg;
  private String tawSeat;
  private String fatherCert;
  private String motherCert;
  private String fatherJob;
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
  private String emergencyAddress;
  private String emergencyTel;
  private String tawBranch;
  private String studStatus;
  private String warnStatus;
  private String finCard;
  private Object studImage;
  private String studJob;
  private Integer noOfChildrens;
  private String emergencyContactName;
  private String birthGovernate;
  
  public RegStudInfo(String studId, String joinTermNo, String firstName, String secondName, String thirdName, String familyName, String firstNameE, String secondNameE, String thirdNameE, String familyNameE, String gender, String idcardType, String idcardNo, String birthCountry, String birthLocality, Date birthDate, String maritalStatus, String nationality, String healthStatus, String motherName, String schoolNo, String tawOrigin, String tawYear, Double tawAvg, String tawSeat, String fatherCert, String motherCert, String fatherJob, String motherJob, String perBoxNo, String perStreet, String perCountry, String perGovernate, String perLocality, String perTel, String perMobile, String perEmail, String currBoxNo, String currStreet, String currCountry, String currGovernate, String currLocality, String currTel, String currMobile, String currEmail, String emergencyAddress, String emergencyTel, String tawBranch, String studStatus, String warnStatus, String finCard, Object studImage, String studJob, Integer noOfChildrens, String emergencyContactName, String birthGovernate)
  {
    this.studId = studId;
    this.joinTermNo = joinTermNo;
    this.firstName = firstName;
    this.secondName = secondName;
    this.thirdName = thirdName;
    this.familyName = familyName;
    this.firstNameE = firstNameE;
    this.secondNameE = secondNameE;
    this.thirdNameE = thirdNameE;
    this.familyNameE = familyNameE;
    this.gender = gender;
    this.idcardType = idcardType;
    this.idcardNo = idcardNo;
    this.birthCountry = birthCountry;
    this.birthLocality = birthLocality;
    this.birthDate = birthDate;
    this.maritalStatus = maritalStatus;
    this.nationality = nationality;
    this.healthStatus = healthStatus;
    this.motherName = motherName;
    this.schoolNo = schoolNo;
    this.tawOrigin = tawOrigin;
    this.tawYear = tawYear;
    this.tawAvg = tawAvg;
    this.tawSeat = tawSeat;
    this.fatherCert = fatherCert;
    this.motherCert = motherCert;
    this.fatherJob = fatherJob;
    this.motherJob = motherJob;
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
    this.tawBranch = tawBranch;
    this.studStatus = studStatus;
    this.warnStatus = warnStatus;
    this.finCard = finCard;
    this.studImage = studImage;
    this.studJob = studJob;
    this.noOfChildrens = noOfChildrens;
    this.emergencyContactName = emergencyContactName;
    this.birthGovernate = birthGovernate;
  }
  
  public RegStudInfo() {}
  
  public RegStudInfo(String studId, String joinTermNo, String firstName, String secondName, String thirdName, String familyName, String firstNameE, String secondNameE, String thirdNameE, String familyNameE, String gender, String idcardType, String idcardNo, String birthCountry, String birthLocality, Date birthDate, String maritalStatus, String nationality, String healthStatus, String motherName, String schoolNo, String tawOrigin, String tawYear, String emergencyAddress, String emergencyTel, String tawBranch, String studStatus, String warnStatus)
  {
    this.studId = studId;
    this.joinTermNo = joinTermNo;
    this.firstName = firstName;
    this.secondName = secondName;
    this.thirdName = thirdName;
    this.familyName = familyName;
    this.firstNameE = firstNameE;
    this.secondNameE = secondNameE;
    this.thirdNameE = thirdNameE;
    this.familyNameE = familyNameE;
    this.gender = gender;
    this.idcardType = idcardType;
    this.idcardNo = idcardNo;
    this.birthCountry = birthCountry;
    this.birthLocality = birthLocality;
    this.birthDate = birthDate;
    this.maritalStatus = maritalStatus;
    this.nationality = nationality;
    this.healthStatus = healthStatus;
    this.motherName = motherName;
    this.schoolNo = schoolNo;
    this.tawOrigin = tawOrigin;
    this.tawYear = tawYear;
    this.emergencyAddress = emergencyAddress;
    this.emergencyTel = emergencyTel;
    this.tawBranch = tawBranch;
    this.studStatus = studStatus;
    this.warnStatus = warnStatus;
  }
  
  public String getStudId()
  {
    return this.studId;
  }
  
  public void setStudId(String studId)
  {
    this.studId = studId;
  }
  
  public String getJoinTermNo()
  {
    return this.joinTermNo;
  }
  
  public void setJoinTermNo(String joinTermNo)
  {
    this.joinTermNo = joinTermNo;
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
  
  public Date getBirthDate()
  {
    return this.birthDate;
  }
  
  public void setBirthDate(Date birthDate)
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
  
  public String getMotherName()
  {
    return this.motherName;
  }
  
  public void setMotherName(String motherName)
  {
    this.motherName = motherName;
  }
  
  public String getSchoolNo()
  {
    return this.schoolNo;
  }
  
  public void setSchoolNo(String schoolNo)
  {
    this.schoolNo = schoolNo;
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
  
  public Double getTawAvg()
  {
    return this.tawAvg;
  }
  
  public void setTawAvg(Double tawAvg)
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
  
  public String getFatherCert()
  {
    return this.fatherCert;
  }
  
  public void setFatherCert(String fatherCert)
  {
    this.fatherCert = fatherCert;
  }
  
  public String getMotherCert()
  {
    return this.motherCert;
  }
  
  public void setMotherCert(String motherCert)
  {
    this.motherCert = motherCert;
  }
  
  public String getFatherJob()
  {
    return this.fatherJob;
  }
  
  public void setFatherJob(String fatherJob)
  {
    this.fatherJob = fatherJob;
  }
  
  public String getMotherJob()
  {
    return this.motherJob;
  }
  
  public void setMotherJob(String motherJob)
  {
    this.motherJob = motherJob;
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
  
  public String getTawBranch()
  {
    return this.tawBranch;
  }
  
  public void setTawBranch(String tawBranch)
  {
    this.tawBranch = tawBranch;
  }
  
  public String getStudStatus()
  {
    return this.studStatus;
  }
  
  public void setStudStatus(String studStatus)
  {
    this.studStatus = studStatus;
  }
  
  public String getWarnStatus()
  {
    return this.warnStatus;
  }
  
  public void setWarnStatus(String warnStatus)
  {
    this.warnStatus = warnStatus;
  }
  
  public String getFinCard()
  {
    return this.finCard;
  }
  
  public void setFinCard(String finCard)
  {
    this.finCard = finCard;
  }
  
  public Object getStudImage()
  {
    return this.studImage;
  }
  
  public void setStudImage(Object studImage)
  {
    this.studImage = studImage;
  }
  
  public String getStudJob()
  {
    return this.studJob;
  }
  
  public void setStudJob(String studJob)
  {
    this.studJob = studJob;
  }
  
  public Integer getNoOfChildrens()
  {
    return this.noOfChildrens;
  }
  
  public void setNoOfChildrens(Integer noOfChildrens)
  {
    this.noOfChildrens = noOfChildrens;
  }
  
  public String getEmergencyContactName()
  {
    return this.emergencyContactName;
  }
  
  public void setEmergencyContactName(String emergencyContactName)
  {
    this.emergencyContactName = emergencyContactName;
  }
  
  public String getBirthGovernate()
  {
    return this.birthGovernate;
  }
  
  public void setBirthGovernate(String birthGovernate)
  {
    this.birthGovernate = birthGovernate;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("studId", getStudId()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof RegStudInfo)) {
      return false;
    }
    RegStudInfo castOther = (RegStudInfo)other;
    return new EqualsBuilder().append(getStudId(), castOther.getStudId()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getStudId()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.RegStudInfo
 * JD-Core Version:    0.7.0.1
 */