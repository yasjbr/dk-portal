package ps.edu.diyar.studentInfo.useCase;

import java.io.PrintStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import ps.edu.diyar.common.component.DataAccessObjectImpl;
import ps.edu.diyar.common.useCase.ComponentUseCase;
import ps.edu.diyar.studentInfo.component.StudentInfoComponent;
import ps.edu.diyar.studentInfo.database.struct.StudentInfoHolder;

public class GetStudentInfoUseCase
  implements ComponentUseCase
{
  private static Logger logger = Logger.getLogger(GetStudentInfoUseCase.class);
  
  public Collection execute(Collection input, HttpServletRequest request)
    throws HibernateException
  {
    String studId = (String)input.iterator().next();
    
    List retList = null;
    try
    {
      List maxTermList = null;
      List maxFinTermList=null;
      
      
      
      
      maxTermList = new DataAccessObjectImpl().getList("stud.getStudentSpecilaizingTermNo", new Object[] { studId });
      if ((maxTermList != null) && ((String)maxTermList.get(0) != null))
      {
        String specTermNo = (String)maxTermList.get(0);
          System.out.println("specTermNo"+specTermNo);
        retList = new DataAccessObjectImpl().getList("stud.getStudentInfo", new Object[] { studId, specTermNo });
      }
      maxTermList = new DataAccessObjectImpl().getList("stud.getStudentLastTermNo", new Object[] { studId });
      if ((maxTermList != null) && ((String)maxTermList.get(0) != null))
      {
        String lastTerm = (String)maxTermList.get(0);
        StudentInfoHolder stdInfo = (StudentInfoHolder)retList.get(0);
        
        ///stdInfo.setCurrentTermNo(lastTerm);
        stdInfo.setCurrentTermNo(lastTerm);
        
         System.out.println("lastTerm..............1    "+lastTerm);
        retList.clear();
        retList.add(stdInfo);
      }
      
      
       /////
       String crsRegTerm = new StudentInfoComponent().getCrsRegTerm();
    
       System.out.println("crsRegTerm..............1"+crsRegTerm);
      
      //////
       maxFinTermList = new DataAccessObjectImpl().getList("stud.getStudentLastFinancialTermNo", new Object[] { studId ,crsRegTerm});
      if ((maxFinTermList != null) && ((String)maxFinTermList.get(0) != null))
      {
          
          String finMaxTermNo = (String)maxFinTermList.get(0);
           StudentInfoHolder stdInfo = (StudentInfoHolder)retList.get(0);
            stdInfo.setFinMaxTermNo(finMaxTermNo);
          System.out.println("finMaxTermNo"+finMaxTermNo);
           retList.clear();
        retList.add(stdInfo);
          
      }
      
      String systemCurrentTerm = new StudentInfoComponent().getCurrentTerm();
      StudentInfoHolder stdInfo = (StudentInfoHolder)retList.get(0);
       System.out.println("systemCurrentTerm..............1"+systemCurrentTerm);
      stdInfo.setSystemCurrentTermNo(systemCurrentTerm);
      
      
     
      retList.clear();
      retList.add(stdInfo);
    }
    catch (Exception e)
    {
      logger.error("*** GetStudentInfoUseCase.execute has ComponentException detials :" + e.toString());
      System.err.println("*** GetStudentInfoUseCase.execute has ComponentException detials :" + e.toString());
    }
    return retList;
  }
}



/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\

 * Qualified Name:     ps.edu.diyar.studentInfo.useCase.GetStudentInfoUseCase

 * JD-Core Version:    0.7.0.1

 */