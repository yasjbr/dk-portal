package ps.edu.diyar.studentInfo.useCase;

import java.io.PrintStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.HibernateException;
import ps.edu.diyar.common.component.DataAccessObjectImpl;
import ps.edu.diyar.common.useCase.ComponentUseCase;

public class ViewStudSrvyAcadDtlUseCase
  implements ComponentUseCase
{
  public Collection execute(Collection input, HttpServletRequest request)
    throws HibernateException
  {
    List returnList = null;
    
    Iterator iter = input.iterator();
    String studId = (String)iter.next();
    String termNo = (String)iter.next();
    String relativeType = (String)iter.next();
    try
    {
      DataAccessObjectImpl cmp = new DataAccessObjectImpl();
      
      returnList = cmp.getList("stud.getSrvyAcademicDetailInfo", new Object[] { studId, termNo, relativeType });
    }
    catch (Exception e)
    {
      System.err.println("*** ViewStudSrvyAcadDtlUseCase.execute has ComponentException detials :" + e.toString());
    }
    return returnList;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.useCase.ViewStudSrvyAcadDtlUseCase
 * JD-Core Version:    0.7.0.1
 */