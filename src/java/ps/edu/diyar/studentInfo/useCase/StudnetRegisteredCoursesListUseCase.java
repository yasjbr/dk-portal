package ps.edu.diyar.studentInfo.useCase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import ps.edu.diyar.common.component.DataAccessObjectImpl;
import ps.edu.diyar.common.useCase.ComponentUseCase;
import ps.edu.diyar.studentInfo.database.struct.MsCoursesList;

public class StudnetRegisteredCoursesListUseCase
  implements ComponentUseCase
{
  Logger logger = Logger.getLogger(StudnetRegisteredCoursesListUseCase.class);
  
  public Collection execute(Collection input, HttpServletRequest request)
    throws HibernateException
  {
    List retList = new ArrayList();
    try
    {
      Iterator iter = input.iterator();
      String studId = (String)iter.next();
      String regTerm = (String)iter.next();
      
      DataAccessObjectImpl cmp = new DataAccessObjectImpl();
      List resultList = cmp.getList("Portal.getStudRegisteredCrs", new Object[] { studId, regTerm });
      Iterator itr;
      int i;
      if ((resultList != null) && (resultList.size() > 0))
      {
        itr = resultList.iterator();
        MsCoursesList msCoursesList = (MsCoursesList)itr.next();
        msCoursesList.setBegEndTime(msCoursesList.getBegTime() + " - " + msCoursesList.getEndTime());
        retList.add(msCoursesList);
        for (i = 1; itr.hasNext();)
        {
          MsCoursesList nxtObj = (MsCoursesList)itr.next();
          MsCoursesList crrntObj = (MsCoursesList)retList.get(i - 1);
          
          nxtObj.setBegEndTime(nxtObj.getBegTime() + " - " + nxtObj.getEndTime());
          if ((nxtObj.getClass() != null) && (crrntObj.getClass() != null) && (nxtObj.getClass().equals(crrntObj.getClass())) && (crrntObj.getCrsNo() != null) && (crrntObj.getCrsNo() != null) && (nxtObj.getCrsNo().equals(crrntObj.getCrsNo())))
          {
            nxtObj.setBegEndTime(crrntObj.getBegEndTime() + " | " + nxtObj.getBegEndTime());
            nxtObj.setDayAName(crrntObj.getDayAName() + " | " + nxtObj.getDayAName());
            
            retList.remove(i - 1);
          }
          else
          {
            i++;
          }
          retList.add(nxtObj);
        }
      }
      return retList;
    }
    catch (Exception e)
    {
      e = 
      






        e;this.logger.error("Error Occurered in StudnetRegisteredCoursesListUseCase: " + e, e);retList.clear();e.printStackTrace();return retList;
    }
    finally {}
    //return retList;
  }
}



/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\

 * Qualified Name:     ps.edu.diyar.studentInfo.useCase.StudnetRegisteredCoursesListUseCase

 * JD-Core Version:    0.7.0.1

 */