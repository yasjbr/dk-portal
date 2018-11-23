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
import ps.edu.diyar.studentInfo.database.SrvyWorkDetail;
import ps.edu.diyar.studentInfo.database.SrvyWorkDetailPK;
import ps.edu.diyar.studentInfo.database.SrvyWorkTypeDtl;
import ps.edu.diyar.studentInfo.database.SrvyWorkTypeDtlPK;

public class SaveStudSocialSrvWorkDtlInfoUseCase
  implements ComponentUseCase
{
  private static Logger logger = Logger.getLogger(SaveStudSocialSrvWorkDtlInfoUseCase.class);
  
  public Collection execute(Collection input, HttpServletRequest request)
    throws HibernateException
  {
    Collection retList = null;
    Iterator itr = input.iterator();
    

    String studId = (String)itr.next();
    String termNo = (String)itr.next();
    String workerType = (String)itr.next();
    String isWork = (String)itr.next();
    String wrkSector = (String)itr.next();
    String wrkOther = (String)itr.next();
    String wrkCompany = (String)itr.next();
    String wrkJob = (String)itr.next();
    String wrkAddress = (String)itr.next();
    String wrkPhone = (String)itr.next();
    String wrkSalary = (String)itr.next();
    String wrkReason = (String)itr.next();
    String wrkType1 = (String)itr.next();
    String wrkType2 = (String)itr.next();
    try
    {
      DataAccessObjectImpl cmp = new DataAccessObjectImpl();
      
      SrvyWorkDetailPK srvyWorkDetailPK = new SrvyWorkDetailPK(studId, termNo, workerType);
      SrvyWorkDetail srvyWorkDetail = new SrvyWorkDetail(srvyWorkDetailPK);
      srvyWorkDetail.setIsWork(isWork);
      
      srvyWorkDetail.setWrkSector(wrkSector);
      srvyWorkDetail.setWrkOther(wrkOther);
      srvyWorkDetail.setWrkCompany(wrkCompany);
      srvyWorkDetail.setWrkJob(wrkJob);
      srvyWorkDetail.setWrkAddress(wrkAddress);
      srvyWorkDetail.setWrkPhone(wrkPhone);
      if ((wrkSalary != null) && (!wrkSalary.trim().equals("*"))) {
        srvyWorkDetail.setWrkSalary(new Double(wrkSalary));
      }
      srvyWorkDetail.setWrkReason(wrkReason);
      
      cmp.insertOrUpdate(srvyWorkDetail);
      try
      {
        cmp.updateSqlQuery("delete  FROM srvy_work_type_dtl a\n  where \n     a.stud_id ='" + studId + "'\n" + "     and a.term_no='" + termNo + "'");
        if ((wrkType1 != null) && (!wrkType1.trim().equals("")) && (!wrkType1.trim().equals("*"))) {
          cmp.insert(new SrvyWorkTypeDtl(new SrvyWorkTypeDtlPK(studId, termNo, workerType, wrkType1)));
        }
        if ((wrkType2 != null) && (!wrkType2.trim().equals("")) && (!wrkType2.trim().equals("*"))) {
          cmp.insert(new SrvyWorkTypeDtl(new SrvyWorkTypeDtlPK(studId, termNo, workerType, wrkType2)));
        }
      }
      catch (Exception e)
      {
        System.err.println("Error in SaveStudSocialSrvWorkDtlInfoUseCase.execute:" + e);
      }
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
 * Qualified Name:     ps.edu.diyar.studentInfo.useCase.SaveStudSocialSrvWorkDtlInfoUseCase
 * JD-Core Version:    0.7.0.1
 */