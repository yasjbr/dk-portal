package ps.edu.diyar.studentInfo.useCase;

import java.io.PrintStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.HibernateException;
import ps.edu.diyar.common.component.DataAccessObjectImpl;
import ps.edu.diyar.common.useCase.ComponentUseCase;

public class ViewStudSocialSrvHousingInfoUseCase
  implements ComponentUseCase
{
  public Collection execute(Collection input, HttpServletRequest request)
    throws HibernateException
  {
    List retList = null;
    Iterator itr = input.iterator();
    String studId = (String)itr.next();
    String termNo = (String)itr.next();
    try
    {
      DataAccessObjectImpl cmp = new DataAccessObjectImpl();
      retList = cmp.getList("stud.getStudSocialSrvHousingInfo", new Object[] { studId, termNo });
      if ((retList != null) && (retList.size() > 0))
      {
        Collection retListBldng = cmp.getList("stud.getStudSocialSrvHousingBuildingInfo", new Object[] { studId, termNo });
        if ((retListBldng != null) && (retListBldng.size() > 0)) {
          request.setAttribute("retListBldng", retListBldng);
        }
        Collection retListLand = cmp.getList("stud.getStudSocialSrvHousingLandInfo", new Object[] { studId, termNo });
        if ((retListLand != null) && (retListLand.size() > 0)) {
          request.setAttribute("retListLand", retListLand);
        }
        Collection retListCar = cmp.getList("stud.getStudSocialSrvHousingCarInfo", new Object[] { studId, termNo });
        if ((retListCar != null) && (retListCar.size() > 0)) {
          request.setAttribute("retListCar", retListCar);
        }
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
      System.err.println("Error in ViewStudSocialSrvHousingInfoUseCase.execute:" + e);
    }
    return retList;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.useCase.ViewStudSocialSrvHousingInfoUseCase
 * JD-Core Version:    0.7.0.1
 */