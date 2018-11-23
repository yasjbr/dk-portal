package ps.edu.diyar.admission.useCase;

import java.io.PrintStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import ps.edu.diyar.common.component.DataAccessObjectImpl;
import ps.edu.diyar.common.useCase.ComponentUseCase;

public class GetLocalityListUseCase
  implements ComponentUseCase
{
  private static Logger logger = Logger.getLogger(GetLocalityListUseCase.class);
  
  public Collection execute(Collection input, HttpServletRequest request)
    throws HibernateException
  {
    List retList = null;
    
    Iterator itr = input.iterator();
    

    String govNo = (String)itr.next();
    String countryNo = (String)itr.next();
    try
    {
      DataAccessObjectImpl cmp = new DataAccessObjectImpl();
      
      retList = cmp.getList("adm.getLocalityList", new Object[] { countryNo, govNo });
    }
    catch (Exception e)
    {
      logger.error("*** GetLocalityListUseCase.execute has ComponentException detials :" + e.toString());
      System.err.println("*** GetLocalityListUseCase.execute has ComponentException detials :" + e.toString());
    }
    return retList;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.admission.useCase.GetLocalityListUseCase
 * JD-Core Version:    0.7.0.1
 */