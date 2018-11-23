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

public class CheckCalenderDatesUseCase
  implements ComponentUseCase
{
  private static Logger logger = Logger.getLogger(CheckCalenderDatesUseCase.class);
  
  public Collection execute(Collection input, HttpServletRequest request)
    throws HibernateException
  {
    ArrayList retList = new ArrayList();  
    HashTable ht = new HashTable();
    
    Iterator itr = input.iterator();
    
    String termNo = (String)itr.next();
      System.out.println("teeeeeeeerm "+termNo);
    try
    {
      TutorComponent tutorCmp = new TutorComponent();
      ht = tutorCmp.isCalenderOpend(termNo); // returns  MP dates and activeprinting = true and M = true if the marks insertion is now
      
      retList.add(ht.get("M"));// true if now
      if (((Boolean)ht.get("activePrinting")).booleanValue()) {
        request.setAttribute("activePrinting", "true");
      }
      if (ht.get("calendar") != null) /// the dates of MP
      {
        ArrayList calList = new ArrayList();
        calList.add(ht.get("calendar"));
        request.setAttribute("calenderInfo", calList); /// put dates in the requuest
      }
      Iterator is =retList.iterator();
      while (is.hasNext()){
          System.out.println("ds"+ is.next());
      }
      return retList; /// returns true if now 
    }
    catch (Exception ce)
    {
      ce = 
      





        ce;logger.error("Error in Check Calender Dates use case " + ce);ce.printStackTrace();return retList;
    }
    finally {}
    //return retList;
  }
}
 