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

public class CheckM2CalenderDatesUseCase
  implements ComponentUseCase
{
  private static Logger logger = Logger.getLogger(CheckM2CalenderDatesUseCase.class);
  
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
      ht = tutorCmp.isM2CalenderOpend(termNo); // returns  MP dates and activeprinting = true and M = true if the marks insertion is now
      
      retList.add(ht.get("M2"));// true if now
      if (((Boolean)ht.get("activePrintingM2")).booleanValue()) {
        request.setAttribute("activePrintingM2", "true");
      }
      if (ht.get("calendarM2") != null) /// the dates of MP
      {
          System.out.println("calenderInfoM2calenderInfoM2calenderInfoM2");
        ArrayList calList = new ArrayList();
        calList.add(ht.get("calendarM2"));
        request.setAttribute("calenderInfoM2", calList); /// put dates in the requuest
      }
       
      return retList; /// returns true if now 
    }
    catch (Exception ce)
    {
      ce =    ce;
      logger.error("Error in Check M2 Calender Dates use case " + ce);ce.printStackTrace();
      return retList;
    }
    finally {}
    //return retList;
  }
}
 