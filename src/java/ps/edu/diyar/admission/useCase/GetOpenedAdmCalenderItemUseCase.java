package ps.edu.diyar.admission.useCase;

import java.io.PrintStream;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import ps.edu.diyar.common.component.DataAccessObjectImpl;
import ps.edu.diyar.common.useCase.ComponentUseCase;

public class GetOpenedAdmCalenderItemUseCase
  implements ComponentUseCase
{
  private static Logger logger = Logger.getLogger(GetOpenedAdmCalenderItemUseCase.class);
  
  public Collection execute(Collection input, HttpServletRequest request)
    throws HibernateException
  {
    List retList = null;
    try
    {
      DataAccessObjectImpl cmp = new DataAccessObjectImpl();
      
      Date date = new Date();
      retList = cmp.getList("adm.getOpenedAdmCalenderItem", new Object[] { date, date });
    }
    catch (Exception e)
    {
      logger.error("*** GetOpenedAdmCalenderItemUseCase.execute has ComponentException detials :" + e.toString());
      System.err.println("*** GetOpenedAdmCalenderItemUseCase.execute has ComponentException detials :" + e.toString());
    }
    return retList;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.admission.useCase.GetOpenedAdmCalenderItemUseCase
 * JD-Core Version:    0.7.0.1
 */