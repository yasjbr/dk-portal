package ps.edu.diyar.studentInfo.useCase;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import ps.edu.diyar.common.component.DataAccessObjectImpl;
import ps.edu.diyar.common.exceptions.ComponentException;
import ps.edu.diyar.common.useCase.ComponentUseCase;
import ps.edu.diyar.studentInfo.database.RegSetting;
import ps.edu.diyar.studentInfo.database.RegWarnSetting;
import ps.edu.diyar.studentInfo.database.RegWarnSettingPK;
import ps.edu.diyar.studentInfo.database.struct.RegStudSetting;

public class RegSettingInfoUseCase
  implements ComponentUseCase
{
  private static Logger logger = Logger.getLogger(GetStudRegApproveStatusForCalItmUseCase.class);
  
  public Collection execute(Collection input, HttpServletRequest request)
    throws HibernateException
  {
    Collection retList = null;
    Iterator itr = input.iterator();
    String specType = (String)itr.next();
    Boolean regTermIsIntensive = (Boolean)itr.next();
    String studWarnStatus = (String)itr.next();
    
    RegStudSetting regStudSetting = new RegStudSetting();
    try
    {
      DataAccessObjectImpl cmp = new DataAccessObjectImpl();
      

      List returnList = cmp.getList("stud.getRegSettingInfo");
      if ((returnList != null) && (returnList.size() > 0))
      {
          System.out.println("rs1");
        RegSetting regSetting = (RegSetting)returnList.iterator().next();
        if ((specType != null) && (specType.equals("B")))
        {
              System.out.println("rs2");
          if (!regTermIsIntensive.booleanValue())
          {
                System.out.println("rs3");
            regStudSetting.setMaxCrHrs(regSetting.getTermMaxCrHrsB());
            regStudSetting.setMinCrHrs(regSetting.getTermMinCrHrsB());
          }
          else if (regTermIsIntensive.booleanValue())
          {
                System.out.println("rs4");
            regStudSetting.setMaxCrHrs(regSetting.getSummerMaxCrHrsB());
            regStudSetting.setMinCrHrs(regSetting.getSummerMinCrHrsB());
          }
        }
        else if ((specType != null) && (specType.equals("D")))
        {
          if (!regTermIsIntensive.booleanValue())
          {
                System.out.println("rs5"+regSetting.getTermMaxCrHrsD());
            regStudSetting.setMaxCrHrs(regSetting.getTermMaxCrHrsD());
            regStudSetting.setMinCrHrs(regSetting.getTermMinCrHrsD());
          }
          if (regTermIsIntensive.booleanValue())
          {
               System.out.println("rs6"+regSetting.getTermMaxCrHrsD());
            regStudSetting.setMaxCrHrs(regSetting.getSummerMaxCrHrsD());
            regStudSetting.setMinCrHrs(regSetting.getSummerMinCrHrsD());
          }
        }
        if ((studWarnStatus != null) && (!studWarnStatus.equals("0")) && (!regTermIsIntensive.booleanValue())) {
          regStudSetting.setMaxCrHrs(getMaxMinHrsForWarnStudStatus(specType));
           System.out.println("rs7"+getMaxMinHrsForWarnStudStatus(specType));
        }
        retList = new ArrayList();
        retList.add(regStudSetting);
      }
      return retList;
    }
    catch (ComponentException e)
    {
      logger.error("*** Error in " + getClass().getName() + ".execute has ComponentException detials :" + e.toString());
      System.err.println("*** Error in " + getClass().getName() + ".execute has ComponentException detials :" + e.toString());
    }
    return retList;
  }
  
  private Integer getMaxMinHrsForWarnStudStatus(String specType)
    throws ComponentException
  {
    DataAccessObjectImpl cmp = new DataAccessObjectImpl();
    
    Integer res = null;
    
    List returnList = cmp.getList("stud.getRegWarnSettingInfo");
    if ((returnList != null) && (returnList.size() > 0))
    {
      Iterator itr = returnList.iterator();
      while (itr.hasNext())
      {
           System.out.println("specType " +specType);
        RegWarnSetting regWarnSetting = (RegWarnSetting)itr.next();
        if ((specType != null) && (regWarnSetting.getComp_id().getSpecType().equals(specType))) {
          res = regWarnSetting.getMaxRegHrs();
            System.out.println("resssss " +res);
        }
      }
    }
    return res;
  }
}



/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\

 * Qualified Name:     ps.edu.diyar.studentInfo.useCase.RegSettingInfoUseCase

 * JD-Core Version:    0.7.0.1

 */