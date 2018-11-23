package ps.edu.diyar.studentInfo.useCase;

import java.io.PrintStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.HibernateException;
import ps.edu.diyar.common.component.DataAccessObjectImpl;
import ps.edu.diyar.common.useCase.ComponentUseCase;

public class GetCrsInfoUseCase
  implements ComponentUseCase
{
  public Collection execute(Collection input, HttpServletRequest request)
    throws HibernateException
  {
    List termList = null;
    String crsNo = (String)input.iterator().next();
    try
    {
      DataAccessObjectImpl cmp = new DataAccessObjectImpl();
      termList = cmp.getList("portal.getCrsInfo", new Object[] { crsNo });
    }
    catch (Exception e)
    {
      e.printStackTrace();
      System.err.println("Error in GetCrsInfoUseCase.execute:" + e);
    }
    return termList;
  }
}

 