package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class SrvyWorkDetail
  implements Serializable
{
  private SrvyWorkDetailPK comp_id;
  private String isWork;
  private String wrkSector;
  private String wrkOther;
  private String wrkCompany;
  private String wrkJob;
  private String wrkAddress;
  private String wrkPhone;
  private Double wrkSalary;
  private String wrkReason;
  
  public SrvyWorkDetail(SrvyWorkDetailPK comp_id, String isWork, String wrkSector, String wrkOther, String wrkCompany, String wrkJob, String wrkAddress, String wrkPhone, Double wrkSalary, String wrkReason)
  {
    this.comp_id = comp_id;
    this.isWork = isWork;
    this.wrkSector = wrkSector;
    this.wrkOther = wrkOther;
    this.wrkCompany = wrkCompany;
    this.wrkJob = wrkJob;
    this.wrkAddress = wrkAddress;
    this.wrkPhone = wrkPhone;
    this.wrkSalary = wrkSalary;
    this.wrkReason = wrkReason;
  }
  
  public SrvyWorkDetail() {}
  
  public SrvyWorkDetail(SrvyWorkDetailPK comp_id)
  {
    this.comp_id = comp_id;
  }
  
  public SrvyWorkDetailPK getComp_id()
  {
    return this.comp_id;
  }
  
  public void setComp_id(SrvyWorkDetailPK comp_id)
  {
    this.comp_id = comp_id;
  }
  
  public String getIsWork()
  {
    return this.isWork;
  }
  
  public void setIsWork(String isWork)
  {
    this.isWork = isWork;
  }
  
  public String getWrkSector()
  {
    return this.wrkSector;
  }
  
  public void setWrkSector(String wrkSector)
  {
    this.wrkSector = wrkSector;
  }
  
  public String getWrkOther()
  {
    return this.wrkOther;
  }
  
  public void setWrkOther(String wrkOther)
  {
    this.wrkOther = wrkOther;
  }
  
  public String getWrkCompany()
  {
    return this.wrkCompany;
  }
  
  public void setWrkCompany(String wrkCompany)
  {
    this.wrkCompany = wrkCompany;
  }
  
  public String getWrkJob()
  {
    return this.wrkJob;
  }
  
  public void setWrkJob(String wrkJob)
  {
    this.wrkJob = wrkJob;
  }
  
  public String getWrkAddress()
  {
    return this.wrkAddress;
  }
  
  public void setWrkAddress(String wrkAddress)
  {
    this.wrkAddress = wrkAddress;
  }
  
  public String getWrkPhone()
  {
    return this.wrkPhone;
  }
  
  public void setWrkPhone(String wrkPhone)
  {
    this.wrkPhone = wrkPhone;
  }
  
  public Double getWrkSalary()
  {
    return this.wrkSalary;
  }
  
  public void setWrkSalary(Double wrkSalary)
  {
    this.wrkSalary = wrkSalary;
  }
  
  public String getWrkReason()
  {
    return this.wrkReason;
  }
  
  public void setWrkReason(String wrkReason)
  {
    this.wrkReason = wrkReason;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("comp_id", getComp_id()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof SrvyWorkDetail)) {
      return false;
    }
    SrvyWorkDetail castOther = (SrvyWorkDetail)other;
    return new EqualsBuilder().append(getComp_id(), castOther.getComp_id()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getComp_id()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.SrvyWorkDetail
 * JD-Core Version:    0.7.0.1
 */