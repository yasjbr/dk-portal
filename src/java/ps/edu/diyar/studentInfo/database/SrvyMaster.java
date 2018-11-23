package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class SrvyMaster
  implements Serializable
{
  private SrvyMasterPK comp_id;
  private String fatherAName;
  private String fatherIdCardType;
  private String fatherIdCard;
  private Date fatherDob;
  private String fatherAcademicLevel;
  private String motherAName;
  private String motherIdCardType;
  private String motherIdCard;
  private Date motherDob;
  private String motherAcademicLevel;
  private Integer familyCountAll;
  private Integer familyCountUnder18;
  private Integer brothersCount;
  private Integer sistersCount;
  private Integer otherMaleCount;
  private Integer otherFemaleCount;
  private String wifeOneAName;
  private Date wifeOneDob;
  private String wifeOneIdCardType;
  private String wifeOneIdCard;
  private String wifeOneAcadmicLevel;
  private String wifeTwoAName;
  private Date wifeTwoDob;
  private String wifeTwoIdCardType;
  private String wifeTwoIdCard;
  private String wifeTwoAcadmicLevel;
  private Integer childrenCount;
  private String otherAcademicExpensive;
  private Double otherAcademicCost;
  private String userId;
  private Date timpeStamp;
  private String ipAddress;
  private String haveOtherWork;
  private String otherWork;
  private Double otherWorkCrossIncome;
  private String familyIncome;
  private Integer familyUnemployed;
  private String unemployedResons;
  private String otherPayer;
  
  public SrvyMaster(SrvyMasterPK comp_id, String fatherAName, String fatherIdCardType, String fatherIdCard, Date fatherDob, String fatherAcademicLevel, String motherAName, String motherIdCardType, String motherIdCard, Date motherDob, String motherAcademicLevel, Integer familyCountAll, Integer familyCountUnder18, Integer brothersCount, Integer sistersCount, Integer otherMaleCount, Integer otherFemaleCount, String wifeOneAName, Date wifeOneDob, String wifeOneIdCardType, String wifeOneIdCard, String wifeOneAcadmicLevel, String userId, Date timpeStamp, String ipAddress)
  {
    this.comp_id = comp_id;
    this.fatherAName = fatherAName;
    this.fatherIdCardType = fatherIdCardType;
    this.fatherIdCard = fatherIdCard;
    this.fatherDob = fatherDob;
    this.fatherAcademicLevel = fatherAcademicLevel;
    this.motherAName = motherAName;
    this.motherIdCardType = motherIdCardType;
    this.motherIdCard = motherIdCard;
    this.motherDob = motherDob;
    this.motherAcademicLevel = motherAcademicLevel;
    this.familyCountAll = familyCountAll;
    this.brothersCount = brothersCount;
    this.familyCountUnder18 = familyCountUnder18;
    this.sistersCount = sistersCount;
    this.otherMaleCount = otherMaleCount;
    this.otherFemaleCount = otherFemaleCount;
    this.wifeOneAName = wifeOneAName;
    this.wifeOneDob = wifeOneDob;
    this.wifeOneIdCardType = wifeOneIdCardType;
    this.wifeOneIdCard = wifeOneIdCard;
    this.wifeOneAcadmicLevel = wifeOneAcadmicLevel;
    

    this.userId = userId;
    this.timpeStamp = timpeStamp;
    this.ipAddress = ipAddress;
  }
  
  public String getOtherPayer()
  {
    return this.otherPayer;
  }
  
  public void setOtherPayer(String otherPayer)
  {
    this.otherPayer = otherPayer;
  }
  
  public Double getOtherWorkCrossIncome()
  {
    return this.otherWorkCrossIncome;
  }
  
  public void setOtherWorkCrossIncome(Double otherWorkCrossIncome)
  {
    this.otherWorkCrossIncome = otherWorkCrossIncome;
  }
  
  public String getHaveOtherWork()
  {
    return this.haveOtherWork;
  }
  
  public void setHaveOtherWork(String haveOtherWork)
  {
    this.haveOtherWork = haveOtherWork;
  }
  
  public String getOtherWork()
  {
    return this.otherWork;
  }
  
  public void setOtherWork(String otherWork)
  {
    this.otherWork = otherWork;
  }
  
  public String getFamilyIncome()
  {
    return this.familyIncome;
  }
  
  public void setFamilyIncome(String familyIncome)
  {
    this.familyIncome = familyIncome;
  }
  
  public Integer getFamilyUnemployed()
  {
    return this.familyUnemployed;
  }
  
  public void setFamilyUnemployed(Integer familyUnemployed)
  {
    this.familyUnemployed = familyUnemployed;
  }
  
  public String getUnemployedResons()
  {
    return this.unemployedResons;
  }
  
  public void setUnemployedResons(String unemployedResons)
  {
    this.unemployedResons = unemployedResons;
  }
  
  public Integer getChildrenCount()
  {
    return this.childrenCount;
  }
  
  public void setChildrenCount(Integer childrenCount)
  {
    this.childrenCount = childrenCount;
  }
  
  public SrvyMaster() {}
  
  public SrvyMaster(SrvyMasterPK comp_id)
  {
    this.comp_id = comp_id;
  }
  
  public Integer getFamilyCountUnder18()
  {
    return this.familyCountUnder18;
  }
  
  public void setFamilyCountUnder18(Integer familyCountUnder18)
  {
    this.familyCountUnder18 = familyCountUnder18;
  }
  
  public SrvyMasterPK getComp_id()
  {
    return this.comp_id;
  }
  
  public void setComp_id(SrvyMasterPK comp_id)
  {
    this.comp_id = comp_id;
  }
  
  public String getFatherAName()
  {
    return this.fatherAName;
  }
  
  public void setFatherAName(String fatherAName)
  {
    this.fatherAName = fatherAName;
  }
  
  public String getFatherIdCardType()
  {
    return this.fatherIdCardType;
  }
  
  public void setFatherIdCardType(String fatherIdCardType)
  {
    this.fatherIdCardType = fatherIdCardType;
  }
  
  public String getFatherIdCard()
  {
    return this.fatherIdCard;
  }
  
  public void setFatherIdCard(String fatherIdCard)
  {
    this.fatherIdCard = fatherIdCard;
  }
  
  public Date getFatherDob()
  {
    return this.fatherDob;
  }
  
  public void setFatherDob(Date fatherDob)
  {
    this.fatherDob = fatherDob;
  }
  
  public String getFatherAcademicLevel()
  {
    return this.fatherAcademicLevel;
  }
  
  public void setFatherAcademicLevel(String fatherAcademicLevel)
  {
    this.fatherAcademicLevel = fatherAcademicLevel;
  }
  
  public String getMotherAName()
  {
    return this.motherAName;
  }
  
  public void setMotherAName(String motherAName)
  {
    this.motherAName = motherAName;
  }
  
  public String getMotherIdCardType()
  {
    return this.motherIdCardType;
  }
  
  public void setMotherIdCardType(String motherIdCardType)
  {
    this.motherIdCardType = motherIdCardType;
  }
  
  public String getMotherIdCard()
  {
    return this.motherIdCard;
  }
  
  public void setMotherIdCard(String motherIdCard)
  {
    this.motherIdCard = motherIdCard;
  }
  
  public Date getMotherDob()
  {
    return this.motherDob;
  }
  
  public void setMotherDob(Date motherDob)
  {
    this.motherDob = motherDob;
  }
  
  public String getMotherAcademicLevel()
  {
    return this.motherAcademicLevel;
  }
  
  public void setMotherAcademicLevel(String motherAcademicLevel)
  {
    this.motherAcademicLevel = motherAcademicLevel;
  }
  
  public Integer getFamilyCountAll()
  {
    return this.familyCountAll;
  }
  
  public void setFamilyCountAll(Integer familyCountAll)
  {
    this.familyCountAll = familyCountAll;
  }
  
  public Integer getBrothersCount()
  {
    return this.brothersCount;
  }
  
  public void setBrothersCount(Integer brothersCount)
  {
    this.brothersCount = brothersCount;
  }
  
  public Integer getSistersCount()
  {
    return this.sistersCount;
  }
  
  public void setSistersCount(Integer sistersCount)
  {
    this.sistersCount = sistersCount;
  }
  
  public Integer getOtherMaleCount()
  {
    return this.otherMaleCount;
  }
  
  public void setOtherMaleCount(Integer otherMaleCount)
  {
    this.otherMaleCount = otherMaleCount;
  }
  
  public Integer getOtherFemaleCount()
  {
    return this.otherFemaleCount;
  }
  
  public void setOtherFemaleCount(Integer otherFemaleCount)
  {
    this.otherFemaleCount = otherFemaleCount;
  }
  
  public String getWifeOneAName()
  {
    return this.wifeOneAName;
  }
  
  public void setWifeOneAName(String wifeOneAName)
  {
    this.wifeOneAName = wifeOneAName;
  }
  
  public Date getWifeOneDob()
  {
    return this.wifeOneDob;
  }
  
  public void setWifeOneDob(Date wifeOneDob)
  {
    this.wifeOneDob = wifeOneDob;
  }
  
  public String getWifeOneIdCardType()
  {
    return this.wifeOneIdCardType;
  }
  
  public void setWifeOneIdCardType(String wifeOneIdCardType)
  {
    this.wifeOneIdCardType = wifeOneIdCardType;
  }
  
  public String getWifeOneIdCard()
  {
    return this.wifeOneIdCard;
  }
  
  public void setWifeOneIdCard(String wifeOneIdCard)
  {
    this.wifeOneIdCard = wifeOneIdCard;
  }
  
  public String getWifeOneAcadmicLevel()
  {
    return this.wifeOneAcadmicLevel;
  }
  
  public void setWifeOneAcadmicLevel(String wifeOneAcadmicLevel)
  {
    this.wifeOneAcadmicLevel = wifeOneAcadmicLevel;
  }
  
  public String getWifeTwoAName()
  {
    return this.wifeTwoAName;
  }
  
  public void setWifeTwoAName(String wifeTwoAName)
  {
    this.wifeTwoAName = wifeTwoAName;
  }
  
  public Date getWifeTwoDob()
  {
    return this.wifeTwoDob;
  }
  
  public void setWifeTwoDob(Date wifeTwoDob)
  {
    this.wifeTwoDob = wifeTwoDob;
  }
  
  public String getWifeTwoIdCardType()
  {
    return this.wifeTwoIdCardType;
  }
  
  public void setWifeTwoIdCardType(String wifeTwoIdCardType)
  {
    this.wifeTwoIdCardType = wifeTwoIdCardType;
  }
  
  public String getWifeTwoIdCard()
  {
    return this.wifeTwoIdCard;
  }
  
  public void setWifeTwoIdCard(String wifeTwoIdCard)
  {
    this.wifeTwoIdCard = wifeTwoIdCard;
  }
  
  public String getWifeTwoAcadmicLevel()
  {
    return this.wifeTwoAcadmicLevel;
  }
  
  public void setWifeTwoAcadmicLevel(String wifeTwoAcadmicLevel)
  {
    this.wifeTwoAcadmicLevel = wifeTwoAcadmicLevel;
  }
  
  public String getOtherAcademicExpensive()
  {
    return this.otherAcademicExpensive;
  }
  
  public void setOtherAcademicExpensive(String otherAcademicExpensive)
  {
    this.otherAcademicExpensive = otherAcademicExpensive;
  }
  
  public Double getOtherAcademicCost()
  {
    return this.otherAcademicCost;
  }
  
  public void setOtherAcademicCost(Double otherAcademicCost)
  {
    this.otherAcademicCost = otherAcademicCost;
  }
  
  public String getUserId()
  {
    return this.userId;
  }
  
  public void setUserId(String userId)
  {
    this.userId = userId;
  }
  
  public Date getTimpeStamp()
  {
    return this.timpeStamp;
  }
  
  public void setTimpeStamp(Date timpeStamp)
  {
    this.timpeStamp = timpeStamp;
  }
  
  public String getIpAddress()
  {
    return this.ipAddress;
  }
  
  public void setIpAddress(String ipAddress)
  {
    this.ipAddress = ipAddress;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("comp_id", getComp_id()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof SrvyMaster)) {
      return false;
    }
    SrvyMaster castOther = (SrvyMaster)other;
    return new EqualsBuilder().append(getComp_id(), castOther.getComp_id()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getComp_id()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.SrvyMaster
 * JD-Core Version:    0.7.0.1
 */