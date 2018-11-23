package ps.edu.diyar.deptMaster.usecase;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import ps.edu.diyar.common.useCase.ComponentUseCase;
import ps.edu.diyar.deptMaster.component.DeptMasterComponent;

public class UnApproveRegStudUseCase
  implements ComponentUseCase
{
  private static Logger logger = Logger.getLogger(UnApproveRegStudUseCase.class);
  
  public Collection execute(Collection input, HttpServletRequest request)
    throws HibernateException
  {
    List retList = null;
    
    Iterator iter = input.iterator();
    String studId = (String)iter.next();
    String regTermNo = (String)iter.next();
    String calItem = (String)iter.next();
    try
    {
      new DeptMasterComponent().unApproveRegStud(studId, regTermNo, calItem);
    }
    catch (Exception e)
    {
      logger.error("*** UnApproveRegStudUseCase.execute has ComponentException detials :" + e.toString());
      System.err.println("*** UnApproveRegStudUseCase.execute has ComponentException detials :" + e.toString());
      retList = new ArrayList();
      retList.add(e.getMessage());
    }
    return retList;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.deptMaster.usecase.UnApproveRegStudUseCase
 * JD-Core Version:    0.7.0.1
 */