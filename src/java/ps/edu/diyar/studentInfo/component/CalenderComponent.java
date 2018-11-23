package ps.edu.diyar.studentInfo.component;

import java.util.List;
import org.apache.log4j.Logger;
import ps.edu.diyar.common.component.DgfComponentH3;
import ps.edu.diyar.common.exceptions.ComponentException;

public class CalenderComponent
  extends DgfComponentH3
{
  private static Logger logger = Logger.getLogger(CalenderComponent.class);
  
  public List getExistCalenderDates(Object[] parameters)
  {
    List retList = null;
    try
    {
      retList = super.getList("Portal.getExistCalenderDates", parameters);
    }
    catch (ComponentException e)
    {
      logger.error(" Error in Calender Component " + e);
    }
    return retList;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.component.CalenderComponent
 * JD-Core Version:    0.7.0.1
 */