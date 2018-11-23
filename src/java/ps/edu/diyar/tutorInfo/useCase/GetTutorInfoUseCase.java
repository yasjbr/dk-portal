package ps.edu.diyar.tutorInfo.useCase;

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
import ps.edu.diyar.studentInfo.component.StudentInfoComponent;
import ps.edu.diyar.tutorInfo.database.struct.TutorInfoHolder;

public class GetTutorInfoUseCase
  implements ComponentUseCase
{
  private static Logger logger = Logger.getLogger(GetTutorInfoUseCase.class);
  
  public Collection execute(Collection input, HttpServletRequest request)
    throws HibernateException
  {
    List retList = null;
    
    Iterator iter = input.iterator();
    String userId = (String)iter.next();
    try
    {
      DataAccessObjectImpl cmp = new DataAccessObjectImpl();
      retList = cmp.getList("tutor.getTutorInfo", new Object[] { userId });
      if ((retList != null) && (retList.size() > 0))
      {
        String systemCurrentTerm = new StudentInfoComponent().getCurrentTerm();
        TutorInfoHolder tutorInfoHolder = (TutorInfoHolder)retList.get(0);
        tutorInfoHolder.setCurrentTermNo(systemCurrentTerm);
        
        retList.clear();
        retList.add(tutorInfoHolder);
      }
    }
    catch (ComponentException e)
    {
      logger.error("*** GetTutorInfoUseCase.execute has ComponentException detials :" + e.toString());
      System.err.println("*** GetTutorInfoUseCase.execute has ComponentException detials :" + e.toString());
    }
    return retList;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.tutorInfo.useCase.GetTutorInfoUseCase
 * JD-Core Version:    0.7.0.1
 */