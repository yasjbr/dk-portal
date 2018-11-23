package ps.edu.diyar.deptMaster.usecase;

import java.io.PrintStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import ps.edu.diyar.common.component.DataAccessObjectImpl;
import ps.edu.diyar.common.exceptions.ComponentException;
import ps.edu.diyar.common.useCase.ComponentUseCase;

public class TutCrsListUseCase
  implements ComponentUseCase
{
  private static Logger logger = Logger.getLogger(TutCrsListUseCase.class);
  
  public Collection execute(Collection input, HttpServletRequest request)
    throws HibernateException
  {
    List retList = null;
    
    Iterator iter = input.iterator();
    String dptNo = (String)iter.next();
    String termNo = (String)iter.next();
    String tutNo = (String)iter.next();
    try
    {
      DataAccessObjectImpl cmp = new DataAccessObjectImpl();
      retList = cmp.getList("dptMstr.getTutCrsList", new Object[] { termNo, tutNo, dptNo });
      

      List resultList = cmp.getList("tutor.getTutorInfo", new Object[] { tutNo });
      if ((resultList != null) && (resultList.size() > 0)) {
        request.setAttribute("tutInfo", resultList);
      }
    }
    catch (ComponentException e)
    {
      logger.error("*** Error in " + getClass().getName() + ".execute has ComponentException detials :" + e.toString());
      System.err.println("*** Error in " + getClass().getName() + ".execute has ComponentException detials :" + e.toString());
    }
    return retList;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.deptMaster.usecase.TutCrsListUseCase
 * JD-Core Version:    0.7.0.1
 */