package ps.edu.diyar.studentInfo.useCase;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import ps.edu.diyar.common.component.DataAccessObjectImpl;
import ps.edu.diyar.common.useCase.ComponentUseCase;
import ps.edu.diyar.studentInfo.database.SrvyStrategic;
import ps.edu.diyar.studentInfo.database.SrvyStrategicPK;

public class SaveStudSocialSrvStrategicInfoUseCase
  implements ComponentUseCase
{
  private static Logger logger = Logger.getLogger(SaveStudSrvyAcadDtlUseCase.class);
  
  public Collection execute(Collection input, HttpServletRequest request)
    throws HibernateException
  {
    Collection retList = null;
    Iterator itr = input.iterator();
    
    String studId = (String)itr.next();
    String termNo = (String)itr.next();
    String stgcHasLoan = (String)itr.next();
    String stgcSource = (String)itr.next();
    String stgcFamily = (String)itr.next();
    String stgcOutsideHelp = (String)itr.next();
    String stgcAffairs = (String)itr.next();
    String stgcCaseNo = (String)itr.next();
    String stgcUnrwa = (String)itr.next();
    String stgcUnrwaNo = (String)itr.next();
    String stgcOther = (String)itr.next();
    try
    {
      DataAccessObjectImpl cmp = new DataAccessObjectImpl();
      
      SrvyStrategicPK objPk = new SrvyStrategicPK(studId, termNo);
      SrvyStrategic obj = new SrvyStrategic(objPk);
      
      obj.setStgcHasLoan(stgcHasLoan);
      obj.setStgcSource(stgcSource);
      obj.setStgcFamily(stgcFamily);
      obj.setStgcOutsideHelp(stgcOutsideHelp);
      obj.setStgcAffairs(stgcAffairs);
      obj.setStgcCaseNo(stgcCaseNo);
      obj.setStgcUnrwa(stgcUnrwa);
      obj.setStgcUnrwaNo(stgcUnrwaNo);
      obj.setStgcOther(stgcOther);
      
      cmp.insertOrUpdate(obj);
    }
    catch (Exception e)
    {
      logger.error("*** Error in " + getClass().getName() + ".execute has ComponentException detials :" + e.toString());
      System.err.println("*** Error in " + getClass().getName() + ".execute has ComponentException detials :" + e.toString());
      retList = new ArrayList();
      retList.add(e);
    }
    return retList;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.useCase.SaveStudSocialSrvStrategicInfoUseCase
 * JD-Core Version:    0.7.0.1
 */