package ps.edu.diyar.studentInfo.forms;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import ps.edu.diyar.common.component.FormCmp;

public class SrvyHousingForm
  extends ActionForm
{
  private String livePlace;
  private String liveRentCost;
  private String isLiveShare;
  private String liveHouseType;
  private String liveIsOld;
  private String liveNoRoom;
  private String liveHouseCost;
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
  private String bldngNo;
  private String bldngType;
  private String bldngCount;
  private String bldngUsage;
  private String bldngPlace;
  private String carNo;
  private String carType;
  private String carYear;
  private String carCount;
  private String landCount;
  private String landType;
  private String landArea;
  private String landUsage;
  private String landPalce;
  private String tblId;
  private String tblOprType;
  private boolean editOpperation = false;
  
  public String getLandCount()
  {
    return this.landCount;
  }
  
  public void setLandCount(String landCount)
  {
    this.landCount = landCount;
  }
  
  public String getLandType()
  {
    return FormCmp.getArabicText(this.editOpperation, this.landType);
  }
  
  public void setLandType(String landType)
  {
    this.landType = landType;
  }
  
  public String getLandArea()
  {
    return this.landArea;
  }
  
  public void setLandArea(String landArea)
  {
    this.landArea = landArea;
  }
  
  public String getLandUsage()
  {
    return FormCmp.getArabicText(this.editOpperation, this.landUsage);
  }
  
  public void setLandUsage(String landUsage)
  {
    this.landUsage = landUsage;
  }
  
  public String getLandPalce()
  {
    return FormCmp.getArabicText(this.editOpperation, this.landPalce);
  }
  
  public void setLandPalce(String landPalce)
  {
    this.landPalce = landPalce;
  }
  
  public String getTblId()
  {
    return this.tblId;
  }
  
  public void setTblId(String tblId)
  {
    this.tblId = tblId;
  }
  
  public String getTblOprType()
  {
    return this.tblOprType;
  }
  
  public void setTblOprType(String tblOprType)
  {
    this.tblOprType = tblOprType;
  }
  
  public String getBldngNo()
  {
    return this.bldngNo;
  }
  
  public void setBldngNo(String bldngNo)
  {
    this.bldngNo = bldngNo;
  }
  
  public String getBldngType()
  {
    return this.bldngType;
  }
  
  public void setBldngType(String bldngType)
  {
    this.bldngType = bldngType;
  }
  
  public String getBldngCount()
  {
    return this.bldngCount;
  }
  
  public void setBldngCount(String bldngCount)
  {
    this.bldngCount = bldngCount;
  }
  
  public String getBldngUsage()
  {
    return FormCmp.getArabicText(this.editOpperation, this.bldngUsage);
  }
  
  public void setBldngUsage(String bldngUsage)
  {
    this.bldngUsage = bldngUsage;
  }
  
  public String getBldngPlace()
  {
    return FormCmp.getArabicText(this.editOpperation, this.bldngPlace);
  }
  
  public void setBldngPlace(String bldngPlace)
  {
    this.bldngPlace = bldngPlace;
  }
  
  public String getCarNo()
  {
    return this.carNo;
  }
  
  public void setCarNo(String carNo)
  {
    this.carNo = carNo;
  }
  
  public String getCarType()
  {
    return FormCmp.getArabicText(this.editOpperation, this.carType);
  }
  
  public void setCarType(String carType)
  {
    this.carType = carType;
  }
  
  public String getCarYear()
  {
    return this.carYear;
  }
  
  public void setCarYear(String carYear)
  {
    this.carYear = carYear;
  }
  
  public String getCarCount()
  {
    return this.carCount;
  }
  
  public void setCarCount(String carCount)
  {
    this.carCount = carCount;
  }
  
  public String getLivePlace()
  {
    return this.livePlace;
  }
  
  public void setLivePlace(String livePlace)
  {
    this.livePlace = livePlace;
  }
  
  public String getLiveRentCost()
  {
    return this.liveRentCost;
  }
  
  public void setLiveRentCost(String liveRentCost)
  {
    this.liveRentCost = liveRentCost;
  }
  
  public String getIsLiveShare()
  {
    return this.isLiveShare;
  }
  
  public void setIsLiveShare(String liveShare)
  {
    this.isLiveShare = liveShare;
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
  
  public String getLiveNoRoom()
  {
    return this.liveNoRoom;
  }
  
  public void setLiveNoRoom(String liveNoRoom)
  {
    this.liveNoRoom = liveNoRoom;
  }
  
  public String getLiveHouseCost()
  {
    return this.liveHouseCost;
  }
  
  public void setLiveHouseCost(String liveHouseCost)
  {
    this.liveHouseCost = liveHouseCost;
  }
  
  public String getLiveOwnerName()
  {
    return FormCmp.getArabicText(this.editOpperation, this.liveOwnerName);
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
    return FormCmp.getArabicText(this.editOpperation, this.liveHouseTown);
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
    return FormCmp.getArabicText(this.editOpperation, this.liveHouseStreet);
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
  
  public boolean isEditOpperation()
  {
    return this.editOpperation;
  }
  
  public void setEditOpperation(boolean editOpperation)
  {
    this.editOpperation = editOpperation;
  }
  
  public ActionErrors validate(ActionMapping mapping, HttpServletRequest req)
  {
    ActionErrors errors = new ActionErrors();
    



    return errors;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.forms.SrvyHousingForm
 * JD-Core Version:    0.7.0.1
 */