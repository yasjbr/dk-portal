package ps.edu.diyar.studentInfo.useCase;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import ps.edu.diyar.common.component.DataAccessObjectImpl;
import ps.edu.diyar.common.component.FormCmp;
import ps.edu.diyar.common.useCase.ComponentUseCase;
import ps.edu.diyar.studentInfo.database.SrvyWorkRelative;
import ps.edu.diyar.studentInfo.database.SrvyWorkRelativePK;

public class SaveStudSrvWorkRelativeUseCase
  implements ComponentUseCase
{
  private static Logger logger = Logger.getLogger(SaveStudSrvWorkRelativeUseCase.class);
  
  public Collection execute(Collection input, HttpServletRequest request)
    throws HibernateException
  {
    Collection retList = null;
    Iterator itr = input.iterator();
    
    String studId = (String)itr.next();
    String termNo = (String)itr.next();
    String wrlIsLiveIn = (String)itr.next();
    String wrlRelativeName = (String)itr.next();
    String wrlWorkAddress = (String)itr.next();
    String wrlPhone = (String)itr.next();
    String wrlJob = (String)itr.next();
    String wrlCategory = (String)itr.next();
    String wrlSalary = (String)itr.next();
    String wrlFamilyContribute = (String)itr.next();
    String counter = (String)itr.next();
    String oprType = (String)itr.next();
    try
    {
      DataAccessObjectImpl cmp = new DataAccessObjectImpl();
      
      SrvyWorkRelativePK objPk = new SrvyWorkRelativePK(studId, termNo);
      SrvyWorkRelative obj = new SrvyWorkRelative(objPk);
      
      obj.setWrlIsLiveIn(wrlIsLiveIn);
      obj.setWrlRelativeName(wrlRelativeName);
      obj.setWrlWorkAddress(wrlWorkAddress);
      obj.setWrlPhone(wrlPhone);
      obj.setWrlJob(wrlJob);
      obj.setWrlCategory(wrlCategory);
      if ((wrlSalary != null) && (!wrlSalary.trim().equals("")) && (FormCmp.isDouble(wrlSalary.trim()))) {
        obj.setWrlSalary(Double.valueOf(Double.parseDouble(wrlSalary)));
      }
      if ((wrlFamilyContribute != null) && (!wrlFamilyContribute.trim().equals("")) && (FormCmp.isDouble(wrlFamilyContribute.trim()))) {
        obj.setWrlFamilyContribute(Double.valueOf(Double.parseDouble(wrlFamilyContribute)));
      }
      if (oprType.equals("1"))
      {
        cmp.insert(obj);
      }
      else if (oprType.equals("2"))
      {
        SrvyWorkRelativePK objPkNew = new SrvyWorkRelativePK(studId, termNo, new Long(counter));
        obj.setComp_id(objPkNew);
        cmp.update(obj);
      }
      else if (oprType.equals("3"))
      {
        SrvyWorkRelativePK objPkNew = new SrvyWorkRelativePK(studId, termNo, new Long(counter));
        obj.setComp_id(objPkNew);
        cmp.delete(obj);
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
 * Qualified Name:     ps.edu.diyar.studentInfo.useCase.SaveStudSrvWorkRelativeUseCase
 * JD-Core Version:    0.7.0.1
 */