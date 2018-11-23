package ps.edu.diyar.studentInfo.useCase;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import ps.edu.diyar.common.useCase.ComponentUseCase;
import ps.edu.diyar.tutorInfo.component.TutorComponent;
import ps.edu.diyar.tutorInfo.database.PrtlTutorMarkApprovment;
import ps.edu.diyar.tutorInfo.database.PrtlTutorMarkApprovmentPK;
import ps.edu.diyar.tutorInfo.database.PrtlTutorStudMark;
import ps.edu.diyar.tutorInfo.database.PrtlTutorStudMarkPK;

public class TutorMarkCommitUseCase
  implements ComponentUseCase
{
  private static Logger logger = Logger.getLogger(TutorMarkCommitUseCase.class);
  
  public Collection execute(Collection input, HttpServletRequest request)
    throws HibernateException
  {
    List retList = null;
    Vector vtrMarksList = new Vector();
    PrtlTutorStudMark prtlTutorStudMark = new PrtlTutorStudMark();
    PrtlTutorStudMarkPK regStudPK = new PrtlTutorStudMarkPK();
    
    Iterator iter = input.iterator();
    
    String classNo = (String)iter.next();
    String crsNo = (String)iter.next();
    String termNo = (String)iter.next();
    String userId = (String)iter.next();
    String tutorId = (String)iter.next();
    String auditUserId = (String)iter.next();
    String auditIpAddress = (String)iter.next();
    


    int count = 1;
    try
    {
      while (request.getParameterMap().containsKey("studId" + count))
      {
        regStudPK = new PrtlTutorStudMarkPK();
        regStudPK.setCrsNo(crsNo);
        regStudPK.setTermNo(termNo);
        regStudPK.setStudId(request.getParameter("studId" + count));
        

        prtlTutorStudMark = new PrtlTutorStudMark();
        
        prtlTutorStudMark.setComp_id(regStudPK);
        prtlTutorStudMark.setClassNo(classNo);
        if ((request.getParameter("m" + count) != null) && (request.getParameter("m" + count).trim().length() != 0)) {
          prtlTutorStudMark.setFinalMark(new Short(request.getParameter("m" + count).trim()));
        }
        
        
        
        //////
        if ((request.getParameter("f" + count) != null) && (request.getParameter("f" + count).trim().length() != 0)) {
          prtlTutorStudMark.setFirstMark(new Short(request.getParameter("f" + count).trim()));
        }
        ////
        prtlTutorStudMark.setUserId(userId);
        

        prtlTutorStudMark.setTimeStamp(new Date());
        
        vtrMarksList.add(prtlTutorStudMark);
        
        count++;
      }
      PrtlTutorMarkApprovment prtlTutorClassApprovment = new PrtlTutorMarkApprovment();
      
      PrtlTutorMarkApprovmentPK prtlTutorClassPK = new PrtlTutorMarkApprovmentPK();
      prtlTutorClassPK.setClassNo(classNo);
      prtlTutorClassPK.setCrsNo(crsNo);
      prtlTutorClassPK.setTermNo(termNo);
      
      prtlTutorClassApprovment.setComp_id(prtlTutorClassPK);
      prtlTutorClassApprovment.setTimeStamp(new Date());
      prtlTutorClassApprovment.setTutorNo(tutorId);
      prtlTutorClassApprovment.setUserId(userId);
      prtlTutorClassApprovment.setApprove("Y");
      prtlTutorClassApprovment.setComputerIp(request.getRemoteHost());
      

      TutorComponent tutorCmp = new TutorComponent();
      
      retList = tutorCmp.saveAndCommitStudentsMarks(new Object[] { vtrMarksList, prtlTutorClassApprovment });
      return retList;
    }
    catch (Exception ce)
    {
      ce =   ce;
      System.out.println("Component Exception was throws in TutorMarkCommitUseCase use case " + ce);logger.error("Component Exception was throws in TutorMarkCommitUseCase use case " + ce);retList = new ArrayList();retList.add(ce.getMessage());return retList;
    }
    finally {}
    //return retList;
  }
}



/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\

 * Qualified Name:     ps.edu.diyar.studentInfo.useCase.TutorMarkCommitUseCase

 * JD-Core Version:    0.7.0.1

 */