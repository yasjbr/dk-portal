package ps.edu.diyar.tutorInfo.useCase;

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
import ps.edu.diyar.common.exceptions.ComponentException;
import ps.edu.diyar.common.useCase.ComponentUseCase;
import ps.edu.diyar.tutorInfo.component.TutorComponent;
import ps.edu.diyar.tutorInfo.database.PrtlTutorStudMark;
import ps.edu.diyar.tutorInfo.database.PrtlTutorStudMarkPK;

public class TutorMarkInsertionUseCase
  implements ComponentUseCase
{
  private static Logger logger = Logger.getLogger(TutorMarkInsertionUseCase.class);
  
  public Collection execute(Collection input, HttpServletRequest request)
    throws HibernateException
  {
    List retList = null;
    Vector vtrMarksList = new Vector();
    int totalMarks;
    PrtlTutorStudMark prtlTutorStudMark = new PrtlTutorStudMark();
    PrtlTutorStudMarkPK regStudPK = new PrtlTutorStudMarkPK();
    
    Iterator iter = input.iterator();
    
    String classNo = (String)iter.next();
    String crsNo = (String)iter.next();
    String termNo = (String)iter.next();
    String userId = (String)iter.next();
    
    int count = 1;
    while (request.getParameterMap().containsKey("studId" + count))
    {
        System.out.println("marks are there ");
      totalMarks=0;
      regStudPK = new PrtlTutorStudMarkPK();
      regStudPK.setCrsNo(crsNo);
      regStudPK.setTermNo(termNo);
      regStudPK.setStudId(request.getParameter("studId" + count));
      
      prtlTutorStudMark = new PrtlTutorStudMark();
      
      prtlTutorStudMark.setComp_id(regStudPK);
      prtlTutorStudMark.setClassNo(classNo);
      
      if ((request.getParameter("m" + count) != null) && (request.getParameter("m" + count).length() != 0)) {
        prtlTutorStudMark.setFinalMark(new Short(request.getParameter("m" + count)));
          System.out.println("final mark is inserted "+request.getParameter("m" + count));
      }
      
      
      if ((request.getParameter("f" + count) != null) && (request.getParameter("f" + count).length() != 0)) {
        prtlTutorStudMark.setFirstMark(new Short(request.getParameter("f" + count)));
       totalMarks  = totalMarks+  new Short((request.getParameter("f" + count)));
      }
      
      
       if ((request.getParameter("s" + count) != null) && (request.getParameter("s" + count).length() != 0)) {
        prtlTutorStudMark.setSecondMark(new Short(request.getParameter("s" + count))); 
          totalMarks  = totalMarks+  new Short((request.getParameter("s" + count)));
      }
       
       
        if ((request.getParameter("md" + count) != null) && (request.getParameter("md" + count).length() != 0)) {
        prtlTutorStudMark.setMidMark(new Short(request.getParameter("md" + count)));
         totalMarks  = totalMarks+  new Short((request.getParameter("md" + count)));
      }
        
        
         if ((request.getParameter("fn" + count) != null) && (request.getParameter("fn" + count).length() != 0)) {
        prtlTutorStudMark.setFinMark(new Short(request.getParameter("fn" + count)));
        totalMarks  = totalMarks+  new Short((request.getParameter("fn" + count)));
      }
       
      if    (totalMarks !=0){
          prtlTutorStudMark.setFinalMark( (short) totalMarks);
          System.out.println("total marks ////////////////////////////");
      }
     
         
      prtlTutorStudMark.setUserId(userId);
      prtlTutorStudMark.setTimeStamp(new Date());
      
      vtrMarksList.add(prtlTutorStudMark);
      
      count++;
    }
    TutorComponent tutorCmp = new TutorComponent();
    try
    {
      retList = tutorCmp.saveStudentsMarks(vtrMarksList);     
      return retList;
    }
    catch (ComponentException ce)
    {
      ce = ce;
      System.out.println("Component Exception was throws in TutorMarkInsertionUseCase use case " + ce);
      logger.error("Component Exception was throws in TutorMarkInsertionUseCase use case " + ce);
      retList = new ArrayList();
      retList.add(ce.getMessage());
      return retList;
    }
    finally {}
    //return retList;
  }
}


 