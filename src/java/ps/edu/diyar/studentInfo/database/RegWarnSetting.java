package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RegWarnSetting
  implements Serializable
{
  private RegWarnSettingPK comp_id;
  private Double cumAvgMin;
  private Double cumAvgMax;
  private Integer maxRegHrs;
  private Double semAvg;
  private Double cumAvg;
  private Double specAvg;
  
  public RegWarnSetting(RegWarnSettingPK comp_id, Double cumAvgMin, Double cumAvgMax, Integer maxRegHrs, Double semAvg, Double cumAvg, Double specAvg)
  {
    this.comp_id = comp_id;
    this.cumAvgMin = cumAvgMin;
    this.cumAvgMax = cumAvgMax;
    this.maxRegHrs = maxRegHrs;
    this.semAvg = semAvg;
    this.cumAvg = cumAvg;
    this.specAvg = specAvg;
  }
  
  public RegWarnSetting() {}
  
  public RegWarnSetting(RegWarnSettingPK comp_id)
  {
    this.comp_id = comp_id;
  }
  
  public RegWarnSettingPK getComp_id()
  {
    return this.comp_id;
  }
  
  public void setComp_id(RegWarnSettingPK comp_id)
  {
    this.comp_id = comp_id;
  }
  
  public Double getCumAvgMin()
  {
    return this.cumAvgMin;
  }
  
  public void setCumAvgMin(Double cumAvgMin)
  {
    this.cumAvgMin = cumAvgMin;
  }
  
  public Double getCumAvgMax()
  {
    return this.cumAvgMax;
  }
  
  public void setCumAvgMax(Double cumAvgMax)
  {
    this.cumAvgMax = cumAvgMax;
  }
  
  public Integer getMaxRegHrs()
  {
    return this.maxRegHrs;
  }
  
  public void setMaxRegHrs(Integer maxRegHrs)
  {
    this.maxRegHrs = maxRegHrs;
  }
  
  public Double getSemAvg()
  {
    return this.semAvg;
  }
  
  public void setSemAvg(Double semAvg)
  {
    this.semAvg = semAvg;
  }
  
  public Double getCumAvg()
  {
    return this.cumAvg;
  }
  
  public void setCumAvg(Double cumAvg)
  {
    this.cumAvg = cumAvg;
  }
  
  public Double getSpecAvg()
  {
    return this.specAvg;
  }
  
  public void setSpecAvg(Double specAvg)
  {
    this.specAvg = specAvg;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("comp_id", getComp_id()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof RegWarnSetting)) {
      return false;
    }
    RegWarnSetting castOther = (RegWarnSetting)other;
    return new EqualsBuilder().append(getComp_id(), castOther.getComp_id()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getComp_id()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.RegWarnSetting
 * JD-Core Version:    0.7.0.1
 */