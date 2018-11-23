package ps.edu.diyar.studentInfo.useCase;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import ps.edu.diyar.common.component.DataAccessObjectImpl;
import ps.edu.diyar.common.exceptions.ComponentException;
import ps.edu.diyar.common.useCase.ComponentUseCase;
import ps.edu.diyar.studentInfo.database.PrtlRegStudApprove;

public class GetStudActiveRegCalItemUseCase
  implements ComponentUseCase
{
  private static Logger logger = Logger.getLogger(GetStudRegApproveStatusForCalItmUseCase.class);
  
  public Collection execute(Collection input, HttpServletRequest request)
    throws HibernateException
  {
    List retList = null;
    
    Iterator iter = input.iterator();
    String studId = (String)iter.next();
    String regTerm = (String)iter.next();
    
    String calItem = "";
    try
    {
      List resList = new DataAccessObjectImpl().getList("stud.getStudCalendarItem", new Object[] { studId, regTerm });
      if ((resList != null) && (resList.size() > 0))
      {
        PrtlRegStudApprove prtlRegStudApprove = (PrtlRegStudApprove)resList.iterator().next();
        if ((prtlRegStudApprove.getRegApp() == null) || 
           (prtlRegStudApprove.getRegApp().trim().equals("")) || 
           (!prtlRegStudApprove.getRegApp().equals("Y"))) 
        {
          calItem = "IP";
           System.out.println(" prtlRegStudApprove.getRegApp()" +prtlRegStudApprove.getRegApp());
            System.out.println(" calItem = IP");
        } else {
          calItem = "RP";
           System.out.println(" calItem = RP");
        }
         System.out.println(" came to this ------------");
        calItem = "IP";
        System.out.println(" calItem finally is "+calItem);
      }
      else
      {
        calItem = "IP";
      }
      if ((calItem != null) && (calItem.equals("IP"))) {
           System.out.println(" aso hee e"+calItem);
        calItem = checkDateIpCalItem(regTerm);
         System.out.println(" aso hee e after "+calItem);
        
      }
    }
    catch (ComponentException e)
    {
      logger.error("*** Error in " + getClass().getName() + ".execute has ComponentException detials :" + e.toString());
      System.err.println("*** Error in " + getClass().getName() + ".execute has ComponentException detials :" + e.toString());
    }
    finally
    {
      retList = new ArrayList();
      retList.add(calItem);
    }
    return retList;
  }
  
  private String checkDateIpCalItem(String regTerm)
    throws ComponentException
  {
    String calItem = "IP";
      System.out.println("regTermregTermregTerm "+regTerm);
    List retCalList = new DataAccessObjectImpl().getList("stud.getCheckCalendarItemDate", new Object[] { calItem, regTerm, new Date(), new Date() });
    if ((retCalList != null) && (retCalList.size() > 0)) {
      calItem = "IP";
    } else {
      calItem = "RP";
    }
    return calItem;
  }
}



/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\

 * Qualified Name:     ps.edu.diyar.studentInfo.useCase.GetStudActiveRegCalItemUseCase

 * JD-Core Version:    0.7.0.1

 */