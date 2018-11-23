package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class SrvyHousingLand
  implements Serializable
{
  private SrvyHousingLandPK comp_id;
  private String landType;
  private Double landArea;
  private String landUsage;
  private String landPalce;
  
  public SrvyHousingLand(SrvyHousingLandPK comp_id, String landType, Double landArea, String landUsage, String landPalce)
  {
    this.comp_id = comp_id;
    this.landType = landType;
    this.landArea = landArea;
    this.landUsage = landUsage;
    this.landPalce = landPalce;
  }
  
  public SrvyHousingLand() {}
  
  public SrvyHousingLand(SrvyHousingLandPK comp_id)
  {
    this.comp_id = comp_id;
  }
  
  public SrvyHousingLandPK getComp_id()
  {
    return this.comp_id;
  }
  
  public void setComp_id(SrvyHousingLandPK comp_id)
  {
    this.comp_id = comp_id;
  }
  
  public String getLandType()
  {
    return this.landType;
  }
  
  public void setLandType(String landType)
  {
    this.landType = landType;
  }
  
  public Double getLandArea()
  {
    return this.landArea;
  }
  
  public void setLandArea(Double landArea)
  {
    this.landArea = landArea;
  }
  
  public String getLandUsage()
  {
    return this.landUsage;
  }
  
  public void setLandUsage(String landUsage)
  {
    this.landUsage = landUsage;
  }
  
  public String getLandPalce()
  {
    return this.landPalce;
  }
  
  public void setLandPalce(String landPalce)
  {
    this.landPalce = landPalce;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("comp_id", getComp_id()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof SrvyHousingLand)) {
      return false;
    }
    SrvyHousingLand castOther = (SrvyHousingLand)other;
    return new EqualsBuilder().append(getComp_id(), castOther.getComp_id()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getComp_id()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.SrvyHousingLand
 * JD-Core Version:    0.7.0.1
 */