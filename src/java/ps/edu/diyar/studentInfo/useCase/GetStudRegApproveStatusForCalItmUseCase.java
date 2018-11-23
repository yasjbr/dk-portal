package ps.edu.diyar.studentInfo.useCase;

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

public class GetStudRegApproveStatusForCalItmUseCase
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
    String calItem = (String)iter.next();
    try
    {
      DataAccessObjectImpl cmp = new DataAccessObjectImpl();
      retList = cmp.getList("stud.getStudRegApproveStatusForCalItm", new Object[] { studId, regTerm, calItem });
    }
    catch (ComponentException e)
    {
      logger.error("*** Error in " + getClass().getName() + ".execute has ComponentException detials :" + e.toString());
      System.err.println("*** Error in " + getClass().getName() + ".execute has ComponentException detials :" + e.toString());
    }
    return retList;
  }
}


  