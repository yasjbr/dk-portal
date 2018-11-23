package ps.edu.diyar.studentInfo.useCase;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.HibernateException;
import ps.edu.diyar.common.component.DataAccessObjectImpl;
import ps.edu.diyar.common.component.ServletContextAttribute;
import ps.edu.diyar.common.useCase.ComponentUseCase;
import ps.edu.diyar.studentInfo.database.PrtlSetup;

public class ChkShowPrintPayRepUseCase
  implements ComponentUseCase
{
  public Collection execute(Collection input, HttpServletRequest request)
    throws HibernateException
  {
    List retList = new ArrayList();
    String result = "N";
    String studId = (String)input.iterator().next();
    try
    {
      String shwPayLnk = getDbPrtlSetupValue("shwPayLnk");
      if ((shwPayLnk != null) && (shwPayLnk.equals("Y")))
      {
        ServletContextAttribute servletContAtt = new ServletContextAttribute(request);
        String regTerm = servletContAtt.getCrsRegTerm();
        

        DataAccessObjectImpl cmp = new DataAccessObjectImpl();
        List studentApprovedList = cmp.getList("stud.getStudRegApproveRec", new Object[] { studId, regTerm });
        if ((studentApprovedList != null) && (studentApprovedList.size() > 0)) {
          result = "Y";
        }
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
      System.err.println("Error in ChkShowPrintPayRepUseCase.execute:" + e);
    }
    finally
    {
      retList.add(result);
    }
    return retList;
  }
  
  private String getDbPrtlSetupValue(String keyValue)
  {
    String val = "";
    try
    {
      List retList = new DataAccessObjectImpl().getList("portal.getPrtlSetupValue", new Object[] { keyValue });
      if ((retList != null) && (retList.size() > 0))
      {
        PrtlSetup prtlSetup = (PrtlSetup)retList.iterator().next();
        val = prtlSetup.getSetupValue();
      }
    }
    catch (Exception e)
    {
      System.err.println("Error in ChkShowPrintPayRepUseCase.getPrtlSetupValue:" + e);
      val = "";
    }
    return val;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.useCase.ChkShowPrintPayRepUseCase
 * JD-Core Version:    0.7.0.1
 */