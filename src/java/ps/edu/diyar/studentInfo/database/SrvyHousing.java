package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class SrvyHousing
  implements Serializable
{
  private SrvyHousingPK comp_id;
  private String livePlace;
  private Double liveRentCost;
  private String isLiveShare;
  private String liveHouseType;
  private String liveIsOld;
  private Integer liveNoRoom;
  private Double liveHouseCost;
  private String liveOwnerName;
  private String liveOwnerPhone;
  private String liveHouseDistrict;
  private String liveHouseTown;
  private String liveHousePob;
  private String liveHouseStreet;
  private String liveHousePhone;
  private String hasFamilyBuilding;
  private String hasFamilyLand;
  private String hasFamilyCar;
  
  public SrvyHousing(SrvyHousingPK comp_id, String livePlace, Double liveRentCost, String isLiveShare, String liveHouseType, String liveIsOld, Integer liveNoRoom, Double liveHouseCost, String liveOwnerName, String liveOwnerPhone, String liveHouseDistrict, String liveHouseTown, String liveHousePob, String liveHouseStreet, String liveHousePhone, String hasFamilyBuilding, String hasFamilyLand, String hasFamilyCar)
  {
    this.comp_id = comp_id;
    this.livePlace = livePlace;
    this.liveRentCost = liveRentCost;
    this.isLiveShare = isLiveShare;
    this.liveHouseType = liveHouseType;
    this.liveIsOld = liveIsOld;
    this.liveNoRoom = liveNoRoom;
    this.liveHouseCost = liveHouseCost;
    this.liveOwnerName = liveOwnerName;
    this.liveOwnerPhone = liveOwnerPhone;
    this.liveHouseDistrict = liveHouseDistrict;
    this.liveHouseTown = liveHouseTown;
    this.liveHousePob = liveHousePob;
    this.liveHouseStreet = liveHouseStreet;
    this.liveHousePhone = liveHousePhone;
    this.hasFamilyBuilding = hasFamilyBuilding;
    this.hasFamilyLand = hasFamilyLand;
    this.hasFamilyCar = hasFamilyCar;
  }
  
  public SrvyHousing() {}
  
  public SrvyHousing(SrvyHousingPK comp_id)
  {
    this.comp_id = comp_id;
  }
  
  public SrvyHousingPK getComp_id()
  {
    return this.comp_id;
  }
  
  public void setComp_id(SrvyHousingPK comp_id)
  {
    this.comp_id = comp_id;
  }
  
  public String getLivePlace()
  {
    return this.livePlace;
  }
  
  public void setLivePlace(String livePlace)
  {
    this.livePlace = livePlace;
  }
  
  public Double getLiveRentCost()
  {
    return this.liveRentCost;
  }
  
  public void setLiveRentCost(Double liveRentCost)
  {
    this.liveRentCost = liveRentCost;
  }
  
  public String getIsLiveShare()
  {
    return this.isLiveShare;
  }
  
  public void setIsLiveShare(String isLiveShare)
  {
    this.isLiveShare = isLiveShare;
  }
  
  public String getLiveHouseType()
  {
    return this.liveHouseType;
  }
  
  public void setLiveHouseType(String liveHouseType)
  {
    this.liveHouseType = liveHouseType;
  }
  
  public String getLiveIsOld()
  {
    return this.liveIsOld;
  }
  
  public void setLiveIsOld(String liveIsOld)
  {
    this.liveIsOld = liveIsOld;
  }
  
  public Integer getLiveNoRoom()
  {
    return this.liveNoRoom;
  }
  
  public void setLiveNoRoom(Integer liveNoRoom)
  {
    this.liveNoRoom = liveNoRoom;
  }
  
  public Double getLiveHouseCost()
  {
    return this.liveHouseCost;
  }
  
  public void setLiveHouseCost(Double liveHouseCost)
  {
    this.liveHouseCost = liveHouseCost;
  }
  
  public String getLiveOwnerName()
  {
    return this.liveOwnerName;
  }
  
  public void setLiveOwnerName(String liveOwnerName)
  {
    this.liveOwnerName = liveOwnerName;
  }
  
  public String getLiveOwnerPhone()
  {
    return this.liveOwnerPhone;
  }
  
  public void setLiveOwnerPhone(String liveOwnerPhone)
  {
    this.liveOwnerPhone = liveOwnerPhone;
  }
  
  public String getLiveHouseDistrict()
  {
    return this.liveHouseDistrict;
  }
  
  public void setLiveHouseDistrict(String liveHouseDistrict)
  {
    this.liveHouseDistrict = liveHouseDistrict;
  }
  
  public String getLiveHouseTown()
  {
    return this.liveHouseTown;
  }
  
  public void setLiveHouseTown(String liveHouseTown)
  {
    this.liveHouseTown = liveHouseTown;
  }
  
  public String getLiveHousePob()
  {
    return this.liveHousePob;
  }
  
  public void setLiveHousePob(String liveHousePob)
  {
    this.liveHousePob = liveHousePob;
  }
  
  public String getLiveHouseStreet()
  {
    return this.liveHouseStreet;
  }
  
  public void setLiveHouseStreet(String liveHouseStreet)
  {
    this.liveHouseStreet = liveHouseStreet;
  }
  
  public String getLiveHousePhone()
  {
    return this.liveHousePhone;
  }
  
  public void setLiveHousePhone(String liveHousePhone)
  {
    this.liveHousePhone = liveHousePhone;
  }
  
  public String getHasFamilyBuilding()
  {
    return this.hasFamilyBuilding;
  }
  
  public void setHasFamilyBuilding(String hasFamilyBuilding)
  {
    this.hasFamilyBuilding = hasFamilyBuilding;
  }
  
  public String getHasFamilyLand()
  {
    return this.hasFamilyLand;
  }
  
  public void setHasFamilyLand(String hasFamilyLand)
  {
    this.hasFamilyLand = hasFamilyLand;
  }
  
  public String getHasFamilyCar()
  {
    return this.hasFamilyCar;
  }
  
  public void setHasFamilyCar(String hasFamilyCar)
  {
    this.hasFamilyCar = hasFamilyCar;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("comp_id", getComp_id()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof SrvyHousing)) {
      return false;
    }
    SrvyHousing castOther = (SrvyHousing)other;
    return new EqualsBuilder().append(getComp_id(), castOther.getComp_id()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getComp_id()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.SrvyHousing
 * JD-Core Version:    0.7.0.1
 */