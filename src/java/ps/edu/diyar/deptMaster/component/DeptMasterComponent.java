package ps.edu.diyar.deptMaster.component;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ps.edu.diyar.common.component.DgfComponentH3;
import ps.edu.diyar.studentInfo.database.PrtlRegStudApprove;
import ps.edu.diyar.studentInfo.database.PrtlRegStudApprovePK;

public class DeptMasterComponent
  extends DgfComponentH3
{
  private static Logger logger = Logger.getLogger(DeptMasterComponent.class);
  
  public void unApproveRegStud(String studId, String regTermNo, String calItem)
    throws Exception
  {
    Session session = null;
    Transaction tx = null;
    try
    {
      session = getSession();
      tx = session.beginTransaction();
      
      PrtlRegStudApprovePK objPk = new PrtlRegStudApprovePK(studId, regTermNo, calItem);
      
      PrtlRegStudApprove obj = (PrtlRegStudApprove)session.load(PrtlRegStudApprove.class, objPk);
      if (obj != null)
      {
        obj.setRegApp("N");
        obj.setRegAppDate(null);
      }
      session.update(obj);
      tx.commit(); return;
    }
    catch (Exception he)
    {
      if (logger.isDebugEnabled()) {
        logger.debug("Error in data Hibernate" + he);
      }
      throw new Exception(he.getMessage());
    }
    finally
    {
      if (session != null) {
        try
        {
          releaseSession(session);
        }
        catch (Exception e)
        {
          if (logger.isDebugEnabled()) {
            logger.debug("Error closing the session" + e);
          }
        }
      }
    }
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.deptMaster.component.DeptMasterComponent
 * JD-Core Version:    0.7.0.1
 */