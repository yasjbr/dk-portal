package ps.edu.diyar.studentInfo.useCase;

import java.io.PrintStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import ps.edu.diyar.common.component.DataAccessObjectImpl;
import ps.edu.diyar.common.useCase.ComponentUseCase;

public class GetTutorOfThisCrsUseCase
  implements ComponentUseCase
{
  private static Logger logger = Logger.getLogger(GetTutorOfThisCrsUseCase.class);
  
  public Collection execute(Collection input, HttpServletRequest request)
    throws HibernateException
  {
    Iterator itr = input.iterator();
    
    String crsNo = (String)itr.next();
    String crsClass = (String)itr.next();
    String termNo = (String)itr.next();
    
    List retList = null;
    try
    {
      retList = new DataAccessObjectImpl().getList("stud.getTutorOfThisCrs", new Object[] { crsNo, crsClass, termNo });
    }
    catch (Exception e)
    {
      logger.error("*** GetTutorOfThisCrsUseCase.execute has ComponentException detials :" + e.toString());
      System.err.println("*** GetTutorOfThisCrsUseCase.execute has ComponentException detials :" + e.toString());
    }
    return retList;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.useCase.GetTutorOfThisCrsUseCase
 * JD-Core Version:    0.7.0.1
 */