package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class SrvyWorkRelative
  implements Serializable
{
  private SrvyWorkRelativePK comp_id;
  private String wrlIsLiveIn;
  private String wrlRelativeName;
  private String wrlWorkAddress;
  private String wrlJob;
  private String wrlCategory;
  private Double wrlSalary;
  private Double wrlFamilyContribute;
  private String wrlPhone;
  
  public SrvyWorkRelative(SrvyWorkRelativePK comp_id, String wrlIsLiveIn, String wrlRelativeName, String wrlWorkAddress, String wrlJob, String wrlCategory, Double wrlSalary, Double wrlFamilyContribute)
  {
    this.comp_id = comp_id;
    this.wrlIsLiveIn = wrlIsLiveIn;
    this.wrlRelativeName = wrlRelativeName;
    this.wrlWorkAddress = wrlWorkAddress;
    this.wrlJob = wrlJob;
    this.wrlCategory = wrlCategory;
    this.wrlSalary = wrlSalary;
    this.wrlFamilyContribute = wrlFamilyContribute;
  }
  
  public SrvyWorkRelative() {}
  
  public SrvyWorkRelative(SrvyWorkRelativePK comp_id)
  {
    this.comp_id = comp_id;
  }
  
  public String getWrlPhone()
  {
    return this.wrlPhone;
  }
  
  public void setWrlPhone(String wrlPhone)
  {
    this.wrlPhone = wrlPhone;
  }
  
  public SrvyWorkRelativePK getComp_id()
  {
    return this.comp_id;
  }
  
  public void setComp_id(SrvyWorkRelativePK comp_id)
  {
    this.comp_id = comp_id;
  }
  
  public String getWrlIsLiveIn()
  {
    return this.wrlIsLiveIn;
  }
  
  public void setWrlIsLiveIn(String wrlIsLiveIn)
  {
    this.wrlIsLiveIn = wrlIsLiveIn;
  }
  
  public String getWrlRelativeName()
  {
    return this.wrlRelativeName;
  }
  
  public void setWrlRelativeName(String wrlRelativeName)
  {
    this.wrlRelativeName = wrlRelativeName;
  }
  
  public String getWrlWorkAddress()
  {
    return this.wrlWorkAddress;
  }
  
  public void setWrlWorkAddress(String wrlWorkAddress)
  {
    this.wrlWorkAddress = wrlWorkAddress;
  }
  
  public String getWrlJob()
  {
    return this.wrlJob;
  }
  
  public void setWrlJob(String wrlJob)
  {
    this.wrlJob = wrlJob;
  }
  
  public String getWrlCategory()
  {
    return this.wrlCategory;
  }
  
  public void setWrlCategory(String wrlCategory)
  {
    this.wrlCategory = wrlCategory;
  }
  
  public Double getWrlSalary()
  {
    return this.wrlSalary;
  }
  
  public void setWrlSalary(Double wrlSalary)
  {
    this.wrlSalary = wrlSalary;
  }
  
  public Double getWrlFamilyContribute()
  {
    return this.wrlFamilyContribute;
  }
  
  public void setWrlFamilyContribute(Double wrlFamilyContribute)
  {
    this.wrlFamilyContribute = wrlFamilyContribute;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("comp_id", getComp_id()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof SrvyWorkRelative)) {
      return false;
    }
    SrvyWorkRelative castOther = (SrvyWorkRelative)other;
    return new EqualsBuilder().append(getComp_id(), castOther.getComp_id()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getComp_id()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.SrvyWorkRelative
 * JD-Core Version:    0.7.0.1
 */