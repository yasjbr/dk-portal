package ps.edu.diyar.studentInfo.useCase;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import ps.edu.diyar.common.component.DataAccessObjectImpl;
import ps.edu.diyar.common.tools.DateTool;
import ps.edu.diyar.common.useCase.ComponentUseCase;
import ps.edu.diyar.studentInfo.database.SrvyAcademicDetail;
import ps.edu.diyar.studentInfo.database.SrvyAcademicDetailPK;

public class SaveStudSrvyAcadDtlUseCase
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
    String relativeType = (String)itr.next();
    String relativeAName = (String)itr.next();
    String enroleDate = (String)itr.next();
    String countryNo = (String)itr.next();
    String collegeNo = (String)itr.next();
    String yearlyCost = (String)itr.next();
    String donarAName = (String)itr.next();
    String relativeStudNo = (String)itr.next();
    String schoolNo = (String)itr.next();
    String schoolType = (String)itr.next();
    String academicSeq = (String)itr.next();
    String oprType = (String)itr.next();
    try
    {
      DataAccessObjectImpl cmp = new DataAccessObjectImpl();
      
      SrvyAcademicDetailPK objPk = new SrvyAcademicDetailPK(studId, termNo, relativeType, "");
      SrvyAcademicDetail obj = new SrvyAcademicDetail(objPk);
      
      obj.setRelativeAName(relativeAName);
      if ((enroleDate != null) && (!enroleDate.trim().equals(""))) {
        obj.setEnroleDate(DateTool.convertStringToDate_dd_mm_yyyy(enroleDate));
      }
      obj.setCountryNo(countryNo);
      obj.setCollegeNo(collegeNo);
      if ((yearlyCost != null) && (!yearlyCost.trim().equals(""))) {
        obj.setYearlyCost(Double.valueOf(Double.parseDouble(yearlyCost)));
      }
      obj.setDonarAName(donarAName);
      obj.setRelativeStudNo(relativeStudNo);
      obj.setSchoolNo(schoolNo);
      obj.setSchoolType(schoolType);
      if (oprType.equals("1"))
      {
        cmp.insert(obj);
      }
      else if (oprType.equals("2"))
      {
        SrvyAcademicDetailPK objPkNew = new SrvyAcademicDetailPK(studId, termNo, relativeType, academicSeq);
        obj.setComp_id(objPkNew);
        cmp.update(obj);
      }
      else if (oprType.equals("3"))
      {
        SrvyAcademicDetailPK objPkNew = new SrvyAcademicDetailPK(studId, termNo, relativeType, academicSeq);
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
 * Qualified Name:     ps.edu.diyar.studentInfo.useCase.SaveStudSrvyAcadDtlUseCase
 * JD-Core Version:    0.7.0.1
 */