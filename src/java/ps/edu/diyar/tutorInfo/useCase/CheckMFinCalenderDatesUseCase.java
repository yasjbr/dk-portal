package ps.edu.diyar.tutorInfo.useCase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import org.apache.batik.dom.util.HashTable;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import ps.edu.diyar.common.useCase.ComponentUseCase;
import ps.edu.diyar.tutorInfo.component.TutorComponent;

public class CheckMFinCalenderDatesUseCase
  implements ComponentUseCase
{
  private static Logger logger = Logger.getLogger(CheckMFinCalenderDatesUseCase.class);
  
  public Collection execute(Collection input, HttpServletRequest request)
    throws HibernateException
  {
    ArrayList retList = new ArrayList();  
    HashTable ht = new HashTable();
    
    Iterator itr = input.iterator();
    
    String termNo = (String)itr.next();
    try
    {
      TutorComponent tutorCmp = new TutorComponent();
      ht = tutorCmp.isMFinCalenderOpend(termNo); // returns  MP dates and activeprinting = true and M = true if the marks insertion is now
      
      retList.add(ht.get("MFin"));// true if now
      if (((Boolean)ht.get("activePrintingMFin")).booleanValue()) {
        request.setAttribute("activePrintingMFin", "true");
      }
      if (ht.get("calendarMFin") != null) /// the dates of MP
      {
          System.out.println("calenderInfoMFcalenderInfoMFcalenderInfoMF");
        ArrayList calList = new ArrayList();
        calList.add(ht.get("calendarMFin"));
        request.setAttribute("calenderInfoMFin", calList); /// put dates in the requuest
      }
       
      return retList; /// returns true if now 
    }
    catch (Exception ce)
    {
      ce =    ce;
      logger.error("Error in Check MFinal Calender Dates use case " + ce);ce.printStackTrace();
      return retList;
    }
    finally {}
    //return retList;
  }
}
 