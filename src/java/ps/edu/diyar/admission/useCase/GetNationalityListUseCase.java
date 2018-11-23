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

public class GetNationalityListUseCase
  implements ComponentUseCase
{
  private static Logger logger = Logger.getLogger(GetNationalityListUseCase.class);
  
  public Collection execute(Collection input, HttpServletRequest request)
    throws HibernateException
  {
    List retList = null;
    
    String gender = (String)input.iterator().next();
    try
    {
      DataAccessObjectImpl cmp = new DataAccessObjectImpl();
      if ((gender != null) && (gender.equals("M"))) {
        retList = cmp.getList("adm.getNationalityForGenderMList");
      } else if ((gender != null) && (gender.equals("F"))) {
        retList = cmp.getList("adm.getNationalityForGenderFList");
      }
    }
    catch (Exception e)
    {
      logger.error("*** GetNationalityListUseCase.execute has ComponentException detials :" + e.toString());
      System.err.println("*** GetNationalityListUseCase.execute has ComponentException detials :" + e.toString());
    }
    return retList;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.admission.useCase.GetNationalityListUseCase
 * JD-Core Version:    0.7.0.1
 */