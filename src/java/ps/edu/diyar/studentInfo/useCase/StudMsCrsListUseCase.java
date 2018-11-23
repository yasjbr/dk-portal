package ps.edu.diyar.studentInfo.useCase;

import java.io.PrintStream;
import java.util.Collection;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import ps.edu.diyar.common.useCase.ComponentUseCase;
import ps.edu.diyar.studentInfo.component.StudentInfoComponent;

public class StudMsCrsListUseCase
  implements ComponentUseCase
{
  private static Logger logger = Logger.getLogger(StudMsCrsListUseCase.class);
  
  public Collection execute(Collection input, HttpServletRequest request)
    throws HibernateException
  {
    Collection retList = null;
    
    Iterator iter = input.iterator();
    
    String studId = (String)iter.next();
    String specNo = (String)iter.next();
    String msNo = (String)iter.next();
      System.out.println("***********    studId" + studId + "specNo"+specNo + "msNo"+msNo+"********************");
    try
    {
      StudentInfoComponent cmp = new StudentInfoComponent();
      retList = cmp.getMsCourseList(msNo, specNo, studId);
    }
    catch (Exception e)
    {
      logger.error("*** Error in " + getClass().getName() + ".execute has ComponentException detials :" + e.toString());
      System.err.println("*** Error in " + getClass().getName() + ".execute has ComponentException detials :" + e.toString());
    }
    return retList;
  }
}



/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\

 * Qualified Name:     ps.edu.diyar.studentInfo.useCase.StudMsCrsListUseCase

 * JD-Core Version:    0.7.0.1

 */