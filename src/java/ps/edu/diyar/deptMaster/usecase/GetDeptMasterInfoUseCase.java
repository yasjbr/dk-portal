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
import ps.edu.diyar.deptMaster.database.struct.DeptMasterInfoHolder;
import ps.edu.diyar.studentInfo.component.StudentInfoComponent;

public class GetDeptMasterInfoUseCase
  implements ComponentUseCase
{
  private static Logger logger = Logger.getLogger(GetDeptMasterInfoUseCase.class);
  
  public Collection execute(Collection input, HttpServletRequest request)
    throws HibernateException
  {
    List retList = null;
    
    Iterator iter = input.iterator();
    String userId = (String)iter.next();
    try
    {
        System.out.println("***************************************545454545");
      DataAccessObjectImpl cmp = new DataAccessObjectImpl();
      retList = cmp.getList("deptMstr.getDeptMasterInfo", new Object[] { userId });
      if ((retList != null) && (retList.size() > 0))
      {
        String systemCurrentTerm = new StudentInfoComponent().getCurrentTerm();
        DeptMasterInfoHolder deptMasterInfoHolder = (DeptMasterInfoHolder)retList.get(0);
        deptMasterInfoHolder.setCurrentTermNo(systemCurrentTerm);
        
        retList.clear();
        retList.add(deptMasterInfoHolder);
      }
    }
    catch (ComponentException e)
    {
      logger.error("*** GetDeptMasterInfoUseCase.execute has ComponentException detials :" + e.toString());
      System.err.println("*** GetDeptMasterInfoUseCase.execute has ComponentException detials :" + e.toString());
    }
    return retList;
  }
}



/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\

 * Qualified Name:     ps.edu.diyar.deptMaster.usecase.GetDeptMasterInfoUseCase

 * JD-Core Version:    0.7.0.1

 */