package ps.edu.diyar.admission.database;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class PrtlAdmApplication
  implements Serializable
{
  private String appNo;
  private String termNo;
  private String appStudentCat;
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
  private Date birthDate;
  private String maritalStatus;
  private Integer noOfChildrens;
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
  private Double tawAvg;
  private String tawSeat;
  private String tawBranch;
  private String appStatus;
  private String collegeNo;
  private String specNo;
  private String collegeNoOther;
  private String specNoOther;
  private String admStatus;
  private Integer englishMark;
  private Date timeStamp;
  
  public PrtlAdmApplication(String appNo, String termNo, String appStudentCat, String firstName, String secondName, String thirdName, String familyName, String firstNameE, String secondNameE, String thirdNameE, String familyNameE, String gender, String idcardType, String idcardNo, String fatherName, String fatherCert, String fatherJob, String motherName, String motherCert, String motherJob, String perBoxNo, String perStreet, String perCountry, String perGovernate, String perLocality, String perTel, String perMobile, String perEmail, String currBoxNo, String currStreet, String currCountry, String currGovernate, String currLocality, String currTel, String currMobile, String currEmail, String birthCountry, String birthLocality, String birthGovernate, Date birthDate, String maritalStatus, Integer noOfChildrens, String nationality, String healthStatus, String emergencyAddress, String emergencyTel, String healthSituation, String schoolNo, String schoolBoxNo, String schoolStreet, String schoolCountry, String schoolGovernate, String schoolLocality, String schoolType, String tawOrigin, String tawYear, Double tawAvg, String tawSeat, String tawBranch, String appStatus, String collegeNo, String specNo, String admStatus, Integer englishMark, Date timeStamp)
  {
    this.appNo = appNo;
    this.termNo = termNo;
    this.appStudentCat = appStudentCat;
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
    this.fatherName = fatherName;
    this.fatherCert = fatherCert;
    this.fatherJob = fatherJob;
    this.motherName = motherName;
    this.motherCert = motherCert;
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
    this.birthCountry = birthCountry;
    this.birthLocality = birthLocality;
    this.birthGovernate = birthGovernate;
    this.birthDate = birthDate;
    this.maritalStatus = maritalStatus;
    this.noOfChildrens = noOfChildrens;
    this.nationality = nationality;
    this.healthStatus = healthStatus;
    this.emergencyAddress = emergencyAddress;
    this.emergencyTel = emergencyTel;
    this.healthSituation = healthSituation;
    this.schoolNo = schoolNo;
    this.schoolBoxNo = schoolBoxNo;
    this.schoolStreet = schoolStreet;
    this.schoolCountry = schoolCountry;
    this.schoolGovernate = schoolGovernate;
    this.schoolLocality = schoolLocality;
    this.schoolType = schoolType;
    this.tawOrigin = tawOrigin;
    this.tawYear = tawYear;
    this.tawAvg = tawAvg;
    this.tawSeat = tawSeat;
    this.tawBranch = tawBranch;
    this.appStatus = appStatus;
    this.collegeNo = collegeNo;
    this.specNo = specNo;
    this.admStatus = admStatus;
    this.englishMark = englishMark;
    this.timeStamp = timeStamp;
  }
  
  public PrtlAdmApplication() {}
  
  public PrtlAdmApplication(String appNo, String termNo, String appStudentCat, String firstName, String secondName, String thirdName, String familyName, String firstNameE, String secondNameE, String thirdNameE, String familyNameE, String gender, String idcardType, String idcardNo, String fatherName, String motherName, String birthCountry, String birthLocality, Date birthDate, String maritalStatus, String nationality, String healthStatus, String emergencyAddress, String emergencyTel, String schoolNo, String schoolType, String tawOrigin, String tawYear, String tawBranch, String appStatus, String collegeNo, String specNo, String admStatus, Date timeStamp)
  {
    this.appNo = appNo;
    this.termNo = termNo;
    this.appStudentCat = appStudentCat;
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
    this.fatherName = fatherName;
    this.motherName = motherName;
    this.birthCountry = birthCountry;
    this.birthLocality = birthLocality;
    this.birthDate = birthDate;
    this.maritalStatus = maritalStatus;
    this.nationality = nationality;
    this.healthStatus = healthStatus;
    this.emergencyAddress = emergencyAddress;
    this.emergencyTel = emergencyTel;
    this.schoolNo = schoolNo;
    this.schoolType = schoolType;
    this.tawOrigin = tawOrigin;
    this.tawYear = tawYear;
    this.tawBranch = tawBranch;
    this.appStatus = appStatus;
    this.collegeNo = collegeNo;
    this.specNo = specNo;
    this.admStatus = admStatus;
    this.timeStamp = timeStamp;
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
  
  public String getAppNo()
  {
    return this.appNo;
  }
  
  public void setAppNo(String appNo)
  {
    this.appNo = appNo;
  }
  
  public String getTermNo()
  {
    return this.termNo;
  }
  
  public void setTermNo(String termNo)
  {
    this.termNo = termNo;
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
  
  public String getFatherName()
  {
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
  
  public Integer getNoOfChildrens()
  {
    return this.noOfChildrens;
  }
  
  public void setNoOfChildrens(Integer noOfChildrens)
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
    return this.healthSituation;
  }
  
  public void setHealthSituation(String healthSituation)
  {
    this.healthSituation = healthSituation;
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
  
  public String getTawBranch()
  {
    return this.tawBranch;
  }
  
  public void setTawBranch(String tawBranch)
  {
    this.tawBranch = tawBranch;
  }
  
  public String getAppStatus()
  {
    return this.appStatus;
  }
  
  public void setAppStatus(String appStatus)
  {
    this.appStatus = appStatus;
  }
  
  public String getCollegeNo()
  {
    return this.collegeNo;
  }
  
  public void setCollegeNo(String collegeNo)
  {
    this.collegeNo = collegeNo;
  }
  
  public String getSpecNo()
  {
    return this.specNo;
  }
  
  public void setSpecNo(String specNo)
  {
    this.specNo = specNo;
  }
  
  public String getAdmStatus()
  {
    return this.admStatus;
  }
  
  public void setAdmStatus(String admStatus)
  {
    this.admStatus = admStatus;
  }
  
  public Integer getEnglishMark()
  {
    return this.englishMark;
  }
  
  public void setEnglishMark(Integer englishMark)
  {
    this.englishMark = englishMark;
  }
  
  public Date getTimeStamp()
  {
    return this.timeStamp;
  }
  
  public void setTimeStamp(Date timeStamp)
  {
    this.timeStamp = timeStamp;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("appNo", getAppNo()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof PrtlAdmApplication)) {
      return false;
    }
    PrtlAdmApplication castOther = (PrtlAdmApplication)other;
    return new EqualsBuilder().append(getAppNo(), castOther.getAppNo()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getAppNo()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.admission.database.PrtlAdmApplication
 * JD-Core Version:    0.7.0.1
 */