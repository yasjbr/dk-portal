package ps.edu.diyar.studentInfo.useCase;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import ps.edu.diyar.common.component.DataAccessObjectImpl;
import ps.edu.diyar.common.component.FormCmp;
import ps.edu.diyar.common.useCase.ComponentUseCase;
import ps.edu.diyar.studentInfo.database.SrvyHousing;
import ps.edu.diyar.studentInfo.database.SrvyHousingBuilding;
import ps.edu.diyar.studentInfo.database.SrvyHousingBuildingPK;
import ps.edu.diyar.studentInfo.database.SrvyHousingCar;
import ps.edu.diyar.studentInfo.database.SrvyHousingCarPK;
import ps.edu.diyar.studentInfo.database.SrvyHousingLand;
import ps.edu.diyar.studentInfo.database.SrvyHousingLandPK;
import ps.edu.diyar.studentInfo.database.SrvyHousingPK;

public class SaveStudSocialSrvHousingInfoUseCase
  implements ComponentUseCase
{
  private static Logger logger = Logger.getLogger(SaveStudSocialSrvHousingInfoUseCase.class);
  
  public Collection execute(Collection input, HttpServletRequest request)
    throws HibernateException
  {
    Collection retList = null;
    Iterator itr = input.iterator();
    
    String studId = (String)itr.next();
    String termNo = (String)itr.next();
    String livePlace = (String)itr.next();
    String liveRentCost = (String)itr.next();
    String isLiveShare = (String)itr.next();
    String liveHouseType = (String)itr.next();
    String liveIsOld = (String)itr.next();
    String liveNoRoom = (String)itr.next();
    String liveHouseCost = (String)itr.next();
    String liveOwnerName = (String)itr.next();
    String liveOwnerPhone = (String)itr.next();
    String liveHouseDistrict = (String)itr.next();
    String liveHouseTown = (String)itr.next();
    String liveHousePob = (String)itr.next();
    String liveHouseStreet = (String)itr.next();
    String liveHousePhone = (String)itr.next();
    String hasFamilyBuilding = (String)itr.next();
    String hasFamilyLand = (String)itr.next();
    String hasFamilyCar = (String)itr.next();
    

    String bldngNo = (String)itr.next();
    String bldngType = (String)itr.next();
    String bldngCount = (String)itr.next();
    String bldngUsage = (String)itr.next();
    String bldngPlace = (String)itr.next();
    
    String carNo = (String)itr.next();
    String carType = (String)itr.next();
    String carYear = (String)itr.next();
    String carCount = (String)itr.next();
    
    String landCount = (String)itr.next();
    String landType = (String)itr.next();
    String landArea = (String)itr.next();
    String landUsage = (String)itr.next();
    String landPalce = (String)itr.next();
    
    String tblId = (String)itr.next();
    String tblOprType = (String)itr.next();
    try
    {
      DataAccessObjectImpl cmp = new DataAccessObjectImpl();
      
      SrvyHousingPK objPk = new SrvyHousingPK(studId, termNo);
      SrvyHousing obj = new SrvyHousing(objPk);
      obj.setLivePlace(livePlace);
      if ((liveRentCost != null) && (!liveRentCost.trim().equals("")) && (FormCmp.isDouble(liveRentCost))) {
        obj.setLiveRentCost(new Double(liveRentCost));
      }
      obj.setIsLiveShare(isLiveShare);
      obj.setLiveHouseType(liveHouseType);
      obj.setLiveIsOld(liveIsOld);
      if ((liveNoRoom != null) && (!liveNoRoom.trim().equals("")) && (FormCmp.isDouble(liveNoRoom))) {
        obj.setLiveNoRoom(new Integer(liveNoRoom));
      }
      if ((liveHouseCost != null) && (!liveHouseCost.trim().equals("")) && (FormCmp.isDouble(liveHouseCost))) {
        obj.setLiveHouseCost(new Double(liveHouseCost));
      }
      obj.setLiveOwnerName(liveOwnerName);
      obj.setLiveOwnerPhone(liveOwnerPhone);
      obj.setLiveHouseDistrict(liveHouseDistrict);
      obj.setLiveHouseTown(liveHouseTown);
      obj.setLiveHousePob(liveHousePob);
      obj.setLiveHouseStreet(liveHouseStreet);
      obj.setLiveHousePhone(liveHousePhone);
      obj.setHasFamilyBuilding(hasFamilyBuilding);
      obj.setHasFamilyLand(hasFamilyLand);
      obj.setHasFamilyCar(hasFamilyCar);
      
      cmp.insertOrUpdate(obj);
      if ((hasFamilyBuilding != null) && (!hasFamilyBuilding.trim().equals("Y"))) {
        cmp.updateSqlQuery("  delete FROM srvy_housing_building  \n  where \n  stud_id='" + studId + "'\n" + "  and term_no='" + termNo + "'");
      }
      if ((hasFamilyLand != null) && (!hasFamilyLand.trim().equals("Y"))) {
        cmp.updateSqlQuery("  delete FROM SRVY_HOUSING_LAND  \n  where \n  stud_id='" + studId + "'\n" + "  and term_no='" + termNo + "'");
      }
      if ((hasFamilyCar != null) && (!hasFamilyCar.trim().equals("Y"))) {
        cmp.updateSqlQuery("  delete FROM SRVY_HOUSING_CAR  \n  where \n  stud_id='" + studId + "'\n" + "  and term_no='" + termNo + "'");
      }
      if ((tblId != null) && (tblId.trim().equals("bldng")))
      {
        SrvyHousingBuildingPK bldngObjPk = new SrvyHousingBuildingPK(studId, termNo);
        SrvyHousingBuilding bldngObj = new SrvyHousingBuilding(bldngObjPk);
        bldngObj.setBldngType(bldngType);
        if ((bldngCount != null) && (!bldngCount.trim().equals("")) && (FormCmp.isInteger(bldngCount))) {
          bldngObj.setBldngCount(new Integer(bldngCount));
        }
        bldngObj.setBldngUsage(bldngUsage);
        bldngObj.setBldngPlace(bldngPlace);
        if ((tblOprType != null) && (tblOprType.equals("I")))
        {
          cmp.insert(bldngObj);
        }
        else if ((tblOprType != null) && (tblOprType.equals("U")))
        {
          bldngObj.setComp_id(new SrvyHousingBuildingPK(studId, termNo, new Integer(bldngNo)));
          cmp.update(bldngObj);
        }
        else if ((tblOprType != null) && (tblOprType.equals("D")))
        {
          bldngObj.setComp_id(new SrvyHousingBuildingPK(studId, termNo, new Integer(bldngNo)));
          cmp.delete(bldngObj);
        }
      }
      else if ((tblId != null) && (tblId.trim().equals("car")))
      {
        SrvyHousingCarPK carObjPK = new SrvyHousingCarPK(studId, termNo);
        SrvyHousingCar carObj = new SrvyHousingCar(carObjPK);
        carObj.setCarType(carType);
        carObj.setCarYear(carYear);
        if ((carCount != null) && (!carCount.trim().equals("")) && (FormCmp.isInteger(carCount))) {
          carObj.setCarCount(new Integer(carCount));
        }
        if ((tblOprType != null) && (tblOprType.equals("I")))
        {
          cmp.insert(carObj);
        }
        else if ((tblOprType != null) && (tblOprType.equals("U")))
        {
          carObj.setComp_id(new SrvyHousingCarPK(studId, termNo, new Integer(carNo)));
          cmp.update(carObj);
        }
        else if ((tblOprType != null) && (tblOprType.equals("D")))
        {
          carObj.setComp_id(new SrvyHousingCarPK(studId, termNo, new Integer(carNo)));
          cmp.delete(carObj);
        }
      }
      else if ((tblId != null) && (tblId.trim().equals("land")))
      {
        SrvyHousingLandPK landObjPK = new SrvyHousingLandPK(studId, termNo);
        SrvyHousingLand landObj = new SrvyHousingLand(landObjPK);
        landObj.setLandType(landType);
        if ((landArea != null) && (!landArea.trim().equals("")) && (FormCmp.isDouble(landArea))) {
          landObj.setLandArea(new Double(landArea));
        }
        landObj.setLandUsage(landUsage);
        landObj.setLandPalce(landPalce);
        if ((tblOprType != null) && (tblOprType.equals("I")))
        {
          cmp.insert(landObj);
        }
        else if ((tblOprType != null) && (tblOprType.equals("U")))
        {
          landObj.setComp_id(new SrvyHousingLandPK(studId, termNo, new Integer(landCount)));
          cmp.update(landObj);
        }
        else if ((tblOprType != null) && (tblOprType.equals("D")))
        {
          landObj.setComp_id(new SrvyHousingLandPK(studId, termNo, new Integer(landCount)));
          cmp.delete(landObj);
        }
      }
    }
    catch (Exception e)
    {
      logger.error("*** Error in " + getClass().getName() + ".execute has ComponentException detials :" + e.toString());
      System.err.println("*** Error in " + getClass().getName() + ".execute has ComponentException detials :" + e.toString());
      retList = new ArrayList();
      retList.add(e);
    }
    return retList;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.useCase.SaveStudSocialSrvHousingInfoUseCase
 * JD-Core Version:    0.7.0.1
 */