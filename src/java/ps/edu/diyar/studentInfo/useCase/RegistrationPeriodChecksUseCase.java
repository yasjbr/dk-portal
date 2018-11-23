package ps.edu.diyar.studentInfo.useCase;

import java.io.PrintStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ps.edu.diyar.common.component.DataAccessObjectImpl;
import ps.edu.diyar.common.useCase.ComponentUseCase;

public class RegistrationPeriodChecksUseCase
  implements ComponentUseCase
{
  Logger logger = Logger.getLogger(RegistrationPeriodChecksUseCase.class);
  
  public Collection execute(Collection input, HttpServletRequest request)
    throws HibernateException
  {
    Iterator iter = input.iterator();
    String studId = (String)iter.next();
    String regTerm = (String)iter.next();
    String calItem = (String)iter.next();
    
    
     System.out.println("calItem ................ " + calItem);
     
     
    ArrayList retList = new ArrayList();
    DataAccessObjectImpl cmp = new DataAccessObjectImpl();
    
    String message = null;
    Session session = null;
    Transaction tx = null;
    String retValue = "";
    try
    {
      session = cmp.getSession();
      tx = session.beginTransaction();
      Connection con = session.connection();
      
      CallableStatement cs = con.prepareCall("{? = call prtl_registration.check_all(?,?,?)}");
      cs.registerOutParameter(1, 12);
      
      cs.setString(2, studId.trim());
      cs.setString(3, regTerm.trim());
      cs.setString(4, calItem.trim());
      cs.execute();
      retValue = cs.getString(1);
       System.out.println("retValue .. 0.. 0.....8 " + retValue);
      tx.commit();
    }
    catch (Exception e)
    {
      System.err.println("Error in RegistrationPeriodChecksUseCase.execute:" + e);
    }
    finally
    {
      try
      {
        cmp.releaseSession(session);
      }
      catch (Exception e)
      {
        System.err.println(" error in colse Session  in RegistrationPeriodChecksUseCase.colseSession :" + e);
      }
      if (retValue == null) {
        retValue = "Error Occurred ,.Please Call Administrator Portal...";
      }
      retList.add(retValue);
    }
    return retList;
  }
}



/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\

 * Qualified Name:     ps.edu.diyar.studentInfo.useCase.RegistrationPeriodChecksUseCase

 * JD-Core Version:    0.7.0.1

 */