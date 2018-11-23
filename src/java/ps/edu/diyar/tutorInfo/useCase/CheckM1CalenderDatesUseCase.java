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

public class CheckM1CalenderDatesUseCase
  implements ComponentUseCase
{
  private static Logger logger = Logger.getLogger(CheckM1CalenderDatesUseCase.class);
  
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
      ht = tutorCmp.isM1CalenderOpend(termNo); // returns  MP dates and activeprinting = true and M = true if the marks insertion is now
      
      retList.add(ht.get("M1"));// true if now
      if (((Boolean)ht.get("activePrintingM1")).booleanValue()) {
        request.setAttribute("activePrintingM1", "true");
      }
      if (ht.get("calendarM1") != null) /// the dates of MP
      {
          System.out.println("calenderInfoM1calenderInfoM1calenderInfoM1");
        ArrayList calList = new ArrayList();
        calList.add(ht.get("calendarM1"));
        request.setAttribute("calenderInfoM1", calList); /// put dates in the requuest
      }
       
      return retList; /// returns true if now 
    }
    catch (Exception ce)
    {
      ce =    ce;
      logger.error("Error in Check M1 Calender Dates use case " + ce);ce.printStackTrace();
      return retList;
    }
    finally {}
    //return retList;
  }
}
 