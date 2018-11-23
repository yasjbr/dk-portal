package ps.edu.diyar.tutorInfo.useCase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import ps.edu.diyar.common.component.DataAccessObjectImpl;
import ps.edu.diyar.common.useCase.ComponentUseCase;

public class IsClassMarksApprovedUseCase
  implements ComponentUseCase
{
  private static Logger logger = Logger.getLogger(IsClassMarksApprovedUseCase.class);
  
  public Collection execute(Collection input, HttpServletRequest request)
    throws HibernateException
  {
    List retList = new ArrayList();
    
    Iterator iter = input.iterator();
    String termNo = (String)iter.next();
    String crsNo = (String)iter.next();
    String classNo = (String)iter.next();
    try
    {
      retList = new DataAccessObjectImpl().getList("tutor.IsClassMarksApproved", new Object[] { termNo, crsNo, classNo });
      
      return retList;
    }
    catch (Exception ce)
    {
      ce =    ce;
      logger.error("Error in IsClassMarksApproved UseCase " + ce);ce.printStackTrace();return retList;
    }
    finally {}
    //return retList;
  }
}


 