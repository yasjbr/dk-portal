package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import java.sql.Blob;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class SrvyHealthDetail
  implements Serializable
{
  private SrvyHealthDetailPK comp_id;
  private String familyHasInsurance;
  private Integer insFamilyMembers;
  private String insuranceType;
  private String familyHasJerusalem;
  private Integer jerFamilyMembers;
  private String isFamilyHasChronic;
  private String chronicName;
  private Blob medicalReport;
  private String medicalReportType;
  private String patientName;
  private Integer patientAge;
  private String patientRelative;
  private String hasDisabilities;
  private Integer disabilitiesCount;
  private String disabilitiesDesc;
  
  public SrvyHealthDetail(SrvyHealthDetailPK comp_id, String familyHasInsurance, Integer insFamilyMembers, String insuranceType, String familyHasJerusalem, Integer jerFamilyMembers, String isFamilyHasChronic, String chronicName, Blob medicalReport, String patientName, Integer patientAge, String patientRelative, String hasDisabilities, Integer disabilitiesCount, String disabilitiesDesc)
  {
    this.comp_id = comp_id;
    this.familyHasInsurance = familyHasInsurance;
    this.insFamilyMembers = insFamilyMembers;
    this.insuranceType = insuranceType;
    this.familyHasJerusalem = familyHasJerusalem;
    this.jerFamilyMembers = jerFamilyMembers;
    this.isFamilyHasChronic = isFamilyHasChronic;
    this.chronicName = chronicName;
    this.medicalReport = medicalReport;
    this.patientName = patientName;
    this.patientAge = patientAge;
    this.patientRelative = patientRelative;
    this.hasDisabilities = hasDisabilities;
    this.disabilitiesCount = disabilitiesCount;
    this.disabilitiesDesc = disabilitiesDesc;
  }
  
  public String getMedicalReportType()
  {
    return this.medicalReportType;
  }
  
  public void setMedicalReportType(String medicalReportType)
  {
    this.medicalReportType = medicalReportType;
  }
  
  public SrvyHealthDetail() {}
  
  public SrvyHealthDetail(SrvyHealthDetailPK comp_id)
  {
    this.comp_id = comp_id;
  }
  
  public SrvyHealthDetailPK getComp_id()
  {
    return this.comp_id;
  }
  
  public void setComp_id(SrvyHealthDetailPK comp_id)
  {
    this.comp_id = comp_id;
  }
  
  public String getFamilyHasInsurance()
  {
    return this.familyHasInsurance;
  }
  
  public void setFamilyHasInsurance(String familyHasInsurance)
  {
    this.familyHasInsurance = familyHasInsurance;
  }
  
  public Integer getInsFamilyMembers()
  {
    return this.insFamilyMembers;
  }
  
  public void setInsFamilyMembers(Integer insFamilyMembers)
  {
    this.insFamilyMembers = insFamilyMembers;
  }
  
  public String getInsuranceType()
  {
    return this.insuranceType;
  }
  
  public void setInsuranceType(String insuranceType)
  {
    this.insuranceType = insuranceType;
  }
  
  public String getFamilyHasJerusalem()
  {
    return this.familyHasJerusalem;
  }
  
  public void setFamilyHasJerusalem(String familyHasJerusalem)
  {
    this.familyHasJerusalem = familyHasJerusalem;
  }
  
  public Integer getJerFamilyMembers()
  {
    return this.jerFamilyMembers;
  }
  
  public void setJerFamilyMembers(Integer jerFamilyMembers)
  {
    this.jerFamilyMembers = jerFamilyMembers;
  }
  
  public String getIsFamilyHasChronic()
  {
    return this.isFamilyHasChronic;
  }
  
  public void setIsFamilyHasChronic(String isFamilyHasChronic)
  {
    this.isFamilyHasChronic = isFamilyHasChronic;
  }
  
  public String getChronicName()
  {
    return this.chronicName;
  }
  
  public void setChronicName(String chronicName)
  {
    this.chronicName = chronicName;
  }
  
  public Blob getMedicalReport()
  {
    return this.medicalReport;
  }
  
  public void setMedicalReport(Blob medicalReport)
  {
    this.medicalReport = medicalReport;
  }
  
  public String getPatientName()
  {
    return this.patientName;
  }
  
  public void setPatientName(String patientName)
  {
    this.patientName = patientName;
  }
  
  public Integer getPatientAge()
  {
    return this.patientAge;
  }
  
  public void setPatientAge(Integer patientAge)
  {
    this.patientAge = patientAge;
  }
  
  public String getPatientRelative()
  {
    return this.patientRelative;
  }
  
  public void setPatientRelative(String patientRelative)
  {
    this.patientRelative = patientRelative;
  }
  
  public String getHasDisabilities()
  {
    return this.hasDisabilities;
  }
  
  public void setHasDisabilities(String hasDisabilities)
  {
    this.hasDisabilities = hasDisabilities;
  }
  
  public Integer getDisabilitiesCount()
  {
    return this.disabilitiesCount;
  }
  
  public void setDisabilitiesCount(Integer disabilitiesCount)
  {
    this.disabilitiesCount = disabilitiesCount;
  }
  
  public String getDisabilitiesDesc()
  {
    return this.disabilitiesDesc;
  }
  
  public void setDisabilitiesDesc(String disabilitiesDesc)
  {
    this.disabilitiesDesc = disabilitiesDesc;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("comp_id", getComp_id()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof SrvyHealthDetail)) {
      return false;
    }
    SrvyHealthDetail castOther = (SrvyHealthDetail)other;
    return new EqualsBuilder().append(getComp_id(), castOther.getComp_id()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getComp_id()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.SrvyHealthDetail
 * JD-Core Version:    0.7.0.1
 */