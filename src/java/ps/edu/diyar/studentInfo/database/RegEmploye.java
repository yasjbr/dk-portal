package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RegEmploye
  implements Serializable
{
  private String empNo;
  private String firstName;
  private String secondName;
  private String thirdName;
  private String familyName;
  private String firsNameL;
  private String secondNameL;
  private String thirdNameL;
  private String familyNameL;
  private String idCard;
  private Date birthDate;
  private String gender;
  private Date workingStartDate;
  private Integer childCount;
  private String perAddress;
  private String currAddress;
  private String resType;
  private String workingPlace;
  private Integer pracYearlyExper;
  private Integer accYearlyExper;
  private String graduateYear;
  private String userId;
  private Date timeStamp;
  private String notes;
  private String isActive;
  private RegHealthStatu regHealthStatu;
  private RegEmpPosition regEmpPosition;
  private RegEmpJobTyp regEmpJobTyp;
  private RegCertTypes regCertTyp;
  private RegUnivColg regUnivColg;
  private RegMaritalStatus regMaritalStatu;
  private RegCountry regCountryByCntryGraduate;
  private RegCountry regCountryByNatiNo;
  private RegGovernate regGovernate;
  private RegDept regDept;
  private RegAcademicRank regAcademicRank;
  private RegEmpTyp regEmpTyp;
  private Set regClasss;
  
  public RegEmploye(String empNo, String firstName, String secondName, String thirdName, String familyName, String firsNameL, String secondNameL, String thirdNameL, String familyNameL, String idCard, Date birthDate, String gender, Date workingStartDate, Integer childCount, String perAddress, String currAddress, String resType, String workingPlace, Integer pracYearlyExper, Integer accYearlyExper, String graduateYear, String userId, Date timeStamp, String notes, String isActive, RegHealthStatu regHealthStatu, RegEmpPosition regEmpPosition, RegEmpJobTyp regEmpJobTyp, RegCertTypes regCertTyp, RegUnivColg regUnivColg, RegMaritalStatus regMaritalStatu, RegCountry regCountryByCntryGraduate, RegCountry regCountryByNatiNo, RegGovernate regGovernate, RegDept regDept, RegAcademicRank regAcademicRank, RegEmpTyp regEmpTyp, Set regClasss)
  {
    this.empNo = empNo;
    this.firstName = firstName;
    this.secondName = secondName;
    this.thirdName = thirdName;
    this.familyName = familyName;
    this.firsNameL = firsNameL;
    this.secondNameL = secondNameL;
    this.thirdNameL = thirdNameL;
    this.familyNameL = familyNameL;
    this.idCard = idCard;
    this.birthDate = birthDate;
    this.gender = gender;
    this.workingStartDate = workingStartDate;
    this.childCount = childCount;
    this.perAddress = perAddress;
    this.currAddress = currAddress;
    this.resType = resType;
    this.workingPlace = workingPlace;
    this.pracYearlyExper = pracYearlyExper;
    this.accYearlyExper = accYearlyExper;
    this.graduateYear = graduateYear;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.notes = notes;
    this.isActive = isActive;
    this.regHealthStatu = regHealthStatu;
    this.regEmpPosition = regEmpPosition;
    this.regEmpJobTyp = regEmpJobTyp;
    this.regCertTyp = regCertTyp;
    this.regUnivColg = regUnivColg;
    this.regMaritalStatu = regMaritalStatu;
    this.regCountryByCntryGraduate = regCountryByCntryGraduate;
    this.regCountryByNatiNo = regCountryByNatiNo;
    this.regGovernate = regGovernate;
    this.regDept = regDept;
    this.regAcademicRank = regAcademicRank;
    this.regEmpTyp = regEmpTyp;
    this.regClasss = regClasss;
  }
  
  public RegEmploye() {}
  
  public RegEmploye(String empNo, String firstName, String secondName, String thirdName, String familyName, String firsNameL, String secondNameL, String thirdNameL, String familyNameL, String idCard, String gender, Date workingStartDate, String userId, Date timeStamp, String isActive, RegHealthStatu regHealthStatu, RegEmpPosition regEmpPosition, RegEmpJobTyp regEmpJobTyp, RegCertTypes regCertTyp, RegUnivColg regUnivColg, RegMaritalStatus regMaritalStatu, RegCountry regCountryByCntryGraduate, RegCountry regCountryByNatiNo, RegGovernate regGovernate, RegDept regDept, RegAcademicRank regAcademicRank, RegEmpTyp regEmpTyp, Set regClasss)
  {
    this.empNo = empNo;
    this.firstName = firstName;
    this.secondName = secondName;
    this.thirdName = thirdName;
    this.familyName = familyName;
    this.firsNameL = firsNameL;
    this.secondNameL = secondNameL;
    this.thirdNameL = thirdNameL;
    this.familyNameL = familyNameL;
    this.idCard = idCard;
    this.gender = gender;
    this.workingStartDate = workingStartDate;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
    this.regHealthStatu = regHealthStatu;
    this.regEmpPosition = regEmpPosition;
    this.regEmpJobTyp = regEmpJobTyp;
    this.regCertTyp = regCertTyp;
    this.regUnivColg = regUnivColg;
    this.regMaritalStatu = regMaritalStatu;
    this.regCountryByCntryGraduate = regCountryByCntryGraduate;
    this.regCountryByNatiNo = regCountryByNatiNo;
    this.regGovernate = regGovernate;
    this.regDept = regDept;
    this.regAcademicRank = regAcademicRank;
    this.regEmpTyp = regEmpTyp;
    this.regClasss = regClasss;
  }
  
  public String getEmpNo()
  {
    return this.empNo;
  }
  
  public void setEmpNo(String empNo)
  {
    this.empNo = empNo;
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
  
  public String getFirsNameL()
  {
    return this.firsNameL;
  }
  
  public void setFirsNameL(String firsNameL)
  {
    this.firsNameL = firsNameL;
  }
  
  public String getSecondNameL()
  {
    return this.secondNameL;
  }
  
  public void setSecondNameL(String secondNameL)
  {
    this.secondNameL = secondNameL;
  }
  
  public String getThirdNameL()
  {
    return this.thirdNameL;
  }
  
  public void setThirdNameL(String thirdNameL)
  {
    this.thirdNameL = thirdNameL;
  }
  
  public String getFamilyNameL()
  {
    return this.familyNameL;
  }
  
  public void setFamilyNameL(String familyNameL)
  {
    this.familyNameL = familyNameL;
  }
  
  public String getIdCard()
  {
    return this.idCard;
  }
  
  public void setIdCard(String idCard)
  {
    this.idCard = idCard;
  }
  
  public Date getBirthDate()
  {
    return this.birthDate;
  }
  
  public void setBirthDate(Date birthDate)
  {
    this.birthDate = birthDate;
  }
  
  public String getGender()
  {
    return this.gender;
  }
  
  public void setGender(String gender)
  {
    this.gender = gender;
  }
  
  public Date getWorkingStartDate()
  {
    return this.workingStartDate;
  }
  
  public void setWorkingStartDate(Date workingStartDate)
  {
    this.workingStartDate = workingStartDate;
  }
  
  public Integer getChildCount()
  {
    return this.childCount;
  }
  
  public void setChildCount(Integer childCount)
  {
    this.childCount = childCount;
  }
  
  public String getPerAddress()
  {
    return this.perAddress;
  }
  
  public void setPerAddress(String perAddress)
  {
    this.perAddress = perAddress;
  }
  
  public String getCurrAddress()
  {
    return this.currAddress;
  }
  
  public void setCurrAddress(String currAddress)
  {
    this.currAddress = currAddress;
  }
  
  public String getResType()
  {
    return this.resType;
  }
  
  public void setResType(String resType)
  {
    this.resType = resType;
  }
  
  public String getWorkingPlace()
  {
    return this.workingPlace;
  }
  
  public void setWorkingPlace(String workingPlace)
  {
    this.workingPlace = workingPlace;
  }
  
  public Integer getPracYearlyExper()
  {
    return this.pracYearlyExper;
  }
  
  public void setPracYearlyExper(Integer pracYearlyExper)
  {
    this.pracYearlyExper = pracYearlyExper;
  }
  
  public Integer getAccYearlyExper()
  {
    return this.accYearlyExper;
  }
  
  public void setAccYearlyExper(Integer accYearlyExper)
  {
    this.accYearlyExper = accYearlyExper;
  }
  
  public String getGraduateYear()
  {
    return this.graduateYear;
  }
  
  public void setGraduateYear(String graduateYear)
  {
    this.graduateYear = graduateYear;
  }
  
  public String getUserId()
  {
    return this.userId;
  }
  
  public void setUserId(String userId)
  {
    this.userId = userId;
  }
  
  public Date getTimeStamp()
  {
    return this.timeStamp;
  }
  
  public void setTimeStamp(Date timeStamp)
  {
    this.timeStamp = timeStamp;
  }
  
  public String getNotes()
  {
    return this.notes;
  }
  
  public void setNotes(String notes)
  {
    this.notes = notes;
  }
  
  public String getIsActive()
  {
    return this.isActive;
  }
  
  public void setIsActive(String isActive)
  {
    this.isActive = isActive;
  }
  
  public RegHealthStatu getRegHealthStatu()
  {
    return this.regHealthStatu;
  }
  
  public void setRegHealthStatu(RegHealthStatu regHealthStatu)
  {
    this.regHealthStatu = regHealthStatu;
  }
  
  public RegEmpPosition getRegEmpPosition()
  {
    return this.regEmpPosition;
  }
  
  public void setRegEmpPosition(RegEmpPosition regEmpPosition)
  {
    this.regEmpPosition = regEmpPosition;
  }
  
  public RegEmpJobTyp getRegEmpJobTyp()
  {
    return this.regEmpJobTyp;
  }
  
  public void setRegEmpJobTyp(RegEmpJobTyp regEmpJobTyp)
  {
    this.regEmpJobTyp = regEmpJobTyp;
  }
  
  public RegCertTypes getRegCertTyp()
  {
    return this.regCertTyp;
  }
  
  public void setRegCertTyp(RegCertTypes regCertTyp)
  {
    this.regCertTyp = regCertTyp;
  }
  
  public RegUnivColg getRegUnivColg()
  {
    return this.regUnivColg;
  }
  
  public void setRegUnivColg(RegUnivColg regUnivColg)
  {
    this.regUnivColg = regUnivColg;
  }
  
  public RegMaritalStatus getRegMaritalStatu()
  {
    return this.regMaritalStatu;
  }
  
  public void setRegMaritalStatu(RegMaritalStatus regMaritalStatu)
  {
    this.regMaritalStatu = regMaritalStatu;
  }
  
  public RegCountry getRegCountryByCntryGraduate()
  {
    return this.regCountryByCntryGraduate;
  }
  
  public void setRegCountryByCntryGraduate(RegCountry regCountryByCntryGraduate)
  {
    this.regCountryByCntryGraduate = regCountryByCntryGraduate;
  }
  
  public RegCountry getRegCountryByNatiNo()
  {
    return this.regCountryByNatiNo;
  }
  
  public void setRegCountryByNatiNo(RegCountry regCountryByNatiNo)
  {
    this.regCountryByNatiNo = regCountryByNatiNo;
  }
  
  public RegGovernate getRegGovernate()
  {
    return this.regGovernate;
  }
  
  public void setRegGovernate(RegGovernate regGovernate)
  {
    this.regGovernate = regGovernate;
  }
  
  public RegDept getRegDept()
  {
    return this.regDept;
  }
  
  public void setRegDept(RegDept regDept)
  {
    this.regDept = regDept;
  }
  
  public RegAcademicRank getRegAcademicRank()
  {
    return this.regAcademicRank;
  }
  
  public void setRegAcademicRank(RegAcademicRank regAcademicRank)
  {
    this.regAcademicRank = regAcademicRank;
  }
  
  public RegEmpTyp getRegEmpTyp()
  {
    return this.regEmpTyp;
  }
  
  public void setRegEmpTyp(RegEmpTyp regEmpTyp)
  {
    this.regEmpTyp = regEmpTyp;
  }
  
  public Set getRegClasss()
  {
    return this.regClasss;
  }
  
  public void setRegClasss(Set regClasss)
  {
    this.regClasss = regClasss;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("empNo", getEmpNo()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof RegEmploye)) {
      return false;
    }
    RegEmploye castOther = (RegEmploye)other;
    return new EqualsBuilder().append(getEmpNo(), castOther.getEmpNo()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getEmpNo()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.RegEmploye
 * JD-Core Version:    0.7.0.1
 */