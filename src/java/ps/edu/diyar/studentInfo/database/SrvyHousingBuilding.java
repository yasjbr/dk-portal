package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class SrvyHousingBuilding
  implements Serializable
{
  private SrvyHousingBuildingPK comp_id;
  private String bldngType;
  private Integer bldngCount;
  private String bldngUsage;
  private String bldngPlace;
  
  public SrvyHousingBuilding(SrvyHousingBuildingPK comp_id, String bldngType, Integer bldngCount, String bldngUsage, String bldngPlace)
  {
    this.comp_id = comp_id;
    this.bldngType = bldngType;
    this.bldngCount = bldngCount;
    this.bldngUsage = bldngUsage;
    this.bldngPlace = bldngPlace;
  }
  
  public SrvyHousingBuilding() {}
  
  public SrvyHousingBuilding(SrvyHousingBuildingPK comp_id)
  {
    this.comp_id = comp_id;
  }
  
  public SrvyHousingBuildingPK getComp_id()
  {
    return this.comp_id;
  }
  
  public void setComp_id(SrvyHousingBuildingPK comp_id)
  {
    this.comp_id = comp_id;
  }
  
  public String getBldngType()
  {
    return this.bldngType;
  }
  
  public void setBldngType(String bldngType)
  {
    this.bldngType = bldngType;
  }
  
  public Integer getBldngCount()
  {
    return this.bldngCount;
  }
  
  public void setBldngCount(Integer bldngCount)
  {
    this.bldngCount = bldngCount;
  }
  
  public String getBldngUsage()
  {
    return this.bldngUsage;
  }
  
  public void setBldngUsage(String bldngUsage)
  {
    this.bldngUsage = bldngUsage;
  }
  
  public String getBldngPlace()
  {
    return this.bldngPlace;
  }
  
  public void setBldngPlace(String bldngPlace)
  {
    this.bldngPlace = bldngPlace;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("comp_id", getComp_id()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof SrvyHousingBuilding)) {
      return false;
    }
    SrvyHousingBuilding castOther = (SrvyHousingBuilding)other;
    return new EqualsBuilder().append(getComp_id(), castOther.getComp_id()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getComp_id()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.SrvyHousingBuilding
 * JD-Core Version:    0.7.0.1
 */