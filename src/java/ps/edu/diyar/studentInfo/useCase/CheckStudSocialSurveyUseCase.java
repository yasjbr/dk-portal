package ps.edu.diyar.studentInfo.useCase;

import java.io.PrintStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.HibernateException;
import ps.edu.diyar.common.component.DataAccessObjectImpl;
import ps.edu.diyar.common.useCase.ComponentUseCase;
import ps.edu.diyar.studentInfo.database.SrvyMaster;
import ps.edu.diyar.studentInfo.database.SrvyMasterPK;

public class CheckStudSocialSurveyUseCase
  implements ComponentUseCase
{
  public Collection execute(Collection input, HttpServletRequest request)
    throws HibernateException
  {
    List returnList = null;
    

    Iterator itr = input.iterator();
    String studId = (String)itr.next();
    String termNo = (String)itr.next();
    try
    {
      DataAccessObjectImpl cmp = new DataAccessObjectImpl();
      
      returnList = cmp.getList("stud.getSrvyMasterInfo", new Object[] { studId, termNo });
      if ((returnList == null) || (returnList.size() == 0)) {
        cmp.insert(new SrvyMaster(new SrvyMasterPK(studId, termNo)));
      }
    }
    catch (Exception e)
    {
      System.err.println("*** CheckStudSocialSurveyUseCase.execute has ComponentException detials :" + e.toString());
    }
    return returnList;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.useCase.CheckStudSocialSurveyUseCase
 * JD-Core Version:    0.7.0.1
 */