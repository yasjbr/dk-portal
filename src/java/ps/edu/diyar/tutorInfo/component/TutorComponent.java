package ps.edu.diyar.tutorInfo.component;

import java.io.PrintStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import org.apache.batik.dom.util.HashTable;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ps.edu.diyar.common.component.DataAccessObjectImpl;
import ps.edu.diyar.common.component.DgfComponentH3;
import ps.edu.diyar.common.exceptions.ComponentException;
import ps.edu.diyar.tutorInfo.database.PrtlTutorMarkApprovment;
import ps.edu.diyar.tutorInfo.database.PrtlTutorMarkApprovmentPK;
import ps.edu.diyar.tutorInfo.database.PrtlTutorStudMark;
import ps.edu.diyar.tutorInfo.database.PrtlTutorStudMarkPK;

public class TutorComponent
  extends DgfComponentH3
{
  private static Logger logger = Logger.getLogger(TutorComponent.class);
  
  public List getTutorTermsList(String tutorId)
  {
    List retList = null;
    try
    {
      retList = super.getList("Portal.getTutorTermsList", new Object[] { tutorId });
    }
    catch (ComponentException e)
    {
      System.out.println("Error in in Current Term/Tutor Info Comp" + e);
    }
    return retList;
  }
  
  public HashTable isCalenderOpend(String termNo)
    throws ComponentException
  {
    HashTable result = new HashTable();
    
    result.put("M", new Boolean(false));
    result.put("activePrinting", new Boolean(false));
    Date sysDate = new Date();
    try
    {
      List examsInfo = super.getList("tutorInfo.getCourseExamsInfo", new Object[] { termNo, sysDate, sysDate }); // if MP is now
      if ((examsInfo != null) && (examsInfo.size() > 0))
      {
        Iterator iter = examsInfo.iterator();
        if (iter.hasNext())
        {
          result.put("M", new Boolean(true));
          result.put("activePrinting", new Boolean(true));
          result.put("calendar", iter.next());
        }
      }
    }
    catch (ComponentException e)
    {
      System.err.println("Error in TutorComponent.isCalenderOpend :" + e);
    }
    return result;
  }
  
   public HashTable isM1CalenderOpend(String termNo)
    throws ComponentException
  {
    HashTable result = new HashTable();
      System.out.println("isM1CalenderOpend stareted");
    result.put("M1", new Boolean(false));
    result.put("activePrintingM1", new Boolean(false));
    Date sysDate = new Date();
    try
    {
      List examsInfo = super.getList("tutorInfo.getM1CourseExamsInfo", new Object[] { termNo, sysDate, sysDate }); // if MP is now
      if ((examsInfo != null) && (examsInfo.size() > 0))
      {
        Iterator iter = examsInfo.iterator();
        if (iter.hasNext())
        {
            System.out.println("put m1 calendar in request");
          result.put("M1", new Boolean(true));
          result.put("activePrintingM1", new Boolean(true));
          result.put("calendarM1", iter.next());
        }
      }
    }
    catch (ComponentException e)
    {
      System.err.println("Error in TutorComponent.isM1CalenderOpend :" + e);
    }
    return result;
  }
   
   public HashTable isM2CalenderOpend(String termNo)
    throws ComponentException
  {
    HashTable result = new HashTable();
      System.out.println("isM2CalenderOpend stareted");
    result.put("M2", new Boolean(false));
    result.put("activePrintingM2", new Boolean(false));
    Date sysDate = new Date();
    try
    {
      List examsInfo = super.getList("tutorInfo.getM2CourseExamsInfo", new Object[] { termNo, sysDate, sysDate }); // if MP is now
      if ((examsInfo != null) && (examsInfo.size() > 0))
      {
        Iterator iter = examsInfo.iterator();
        if (iter.hasNext())
        {
            System.out.println("put m2 calendar in request");
          result.put("M2", new Boolean(true));
          result.put("activePrintingM2", new Boolean(true));
          result.put("calendarM2", iter.next());
        }
      }
    }
    catch (ComponentException e)
    {
      System.err.println("Error in TutorComponent.isM2CalenderOpend :" + e);
    }
    return result;
  }
   
    public HashTable isMMidCalenderOpend(String termNo)
    throws ComponentException
  {
    HashTable result = new HashTable();
      System.out.println("isMMidCalenderOpend stareted");
    result.put("MMid", new Boolean(false));
    result.put("activePrintingMMid", new Boolean(false));
    Date sysDate = new Date();
    try
    {
      List examsInfo = super.getList("tutorInfo.getMMidCourseExamsInfo", new Object[] { termNo, sysDate, sysDate }); // if MP is now
      if ((examsInfo != null) && (examsInfo.size() > 0))
      {
        Iterator iter = examsInfo.iterator();
        if (iter.hasNext())
        {
            System.out.println("put MMid calendar in request");
          result.put("MMid", new Boolean(true));
          result.put("activePrintingMMid", new Boolean(true));
          result.put("calendarMMid", iter.next());
        }
      }
    }
    catch (ComponentException e)
    {
      System.err.println("Error in TutorComponent.isMMidCalenderOpend :" + e);
    }
    return result;
  }
   
     public HashTable isMPracticalCalenderOpend(String termNo)
    throws ComponentException
  {
    HashTable result = new HashTable();
      System.out.println("isMPracticalCalenderOpend stareted");
    result.put("MPractical", new Boolean(false));
    result.put("activePrintingMPractical", new Boolean(false));
    Date sysDate = new Date();
    try
    {
      List examsInfo = super.getList("tutorInfo.getMPracticalCourseExamsInfo", new Object[] { termNo, sysDate, sysDate }); // if MP is now
      if ((examsInfo != null) && (examsInfo.size() > 0))
      {
        Iterator iter = examsInfo.iterator();
        if (iter.hasNext())
        {
            System.out.println("put MPractical calendar in request");
          result.put("MPractical", new Boolean(true));
          result.put("activePrintingMPractical", new Boolean(true));
          result.put("calendarMPractical", iter.next());
        }
      }
    }
    catch (ComponentException e)
    {
      System.err.println("Error in TutorComponent.isMPracticalCalenderOpend :" + e);
    }
    return result;
  }
    public HashTable isMFinCalenderOpend(String termNo)
    throws ComponentException
  {
    HashTable result = new HashTable();
      System.out.println("isMFinCalenderOpend stareted");
    result.put("MFin", new Boolean(false));
    result.put("activePrintingMFin", new Boolean(false));
    Date sysDate = new Date();
    try
    {
      List examsInfo = super.getList("tutorInfo.getMFinCourseExamsInfo", new Object[] { termNo, sysDate, sysDate }); // if MP is now
      if ((examsInfo != null) && (examsInfo.size() > 0))
      {
        Iterator iter = examsInfo.iterator();
        if (iter.hasNext())
        {
            System.out.println("put MFin calendar in request");
          result.put("MFin", new Boolean(true));
          result.put("activePrintingMFin", new Boolean(true));
          result.put("calendarMFin", iter.next());
        }
      }
    }
    catch (ComponentException e)
    {
      System.err.println("Error in TutorComponent.isMFinalCalenderOpend :" + e);
    }
    return result;
  }
   
  public List saveStudentsMarks(Vector vtrStudensMarks)
    throws ComponentException
  {
    List retList = null;
    Session session = null;
    Transaction tx = null;
    boolean isMarkExist = false;
    boolean isClassMidOpen = false;
     boolean isM1ClassMidOpen = false;
      boolean isM2ClassMidOpen = false;
       boolean isMMidClassMidOpen = false;
        boolean isMFinClassMidOpen = false;
         boolean isMPracticalClassMidOpen = false;
    boolean isClassApproved = false;
    boolean isClassApprovedForFinal = false;
    PrtlTutorMarkApprovment tempTutorClassApprovment = null;
    
    PrtlTutorStudMark prtlTutorStudMark = new PrtlTutorStudMark();
    PrtlTutorMarkApprovmentPK prtlTutorClassPK = new PrtlTutorMarkApprovmentPK();
    PrtlTutorStudMark temp = new PrtlTutorStudMark();
    
    prtlTutorStudMark = (PrtlTutorStudMark)vtrStudensMarks.elementAt(0);
    
    prtlTutorClassPK.setTermNo(prtlTutorStudMark.getComp_id().getTermNo());
    prtlTutorClassPK.setClassNo(prtlTutorStudMark.getClassNo() + "");
    prtlTutorClassPK.setCrsNo(prtlTutorStudMark.getComp_id().getCrsNo());
    
    HashTable examsStatus = isCalenderOpend(prtlTutorClassPK.getTermNo());
    
    //
    HashTable examsM1Status = isM1CalenderOpend(prtlTutorClassPK.getTermNo());
     HashTable examsM2Status = isM2CalenderOpend(prtlTutorClassPK.getTermNo());
      HashTable examsMMidStatus = isMMidCalenderOpend(prtlTutorClassPK.getTermNo());
       HashTable examsMFinStatus = isMFinCalenderOpend(prtlTutorClassPK.getTermNo());
    
    
     if (((Boolean)examsM1Status.get("M1")).booleanValue())//entry is now for first
    {
       isM1ClassMidOpen = true;  
     }
     
     if (((Boolean)examsM2Status.get("M2")).booleanValue())//entry is now for first
    {
       isM2ClassMidOpen = true;  
     }
     if (((Boolean)examsMMidStatus.get("MMid")).booleanValue())//entry is now for first
    {
       isMMidClassMidOpen = true;  
     }
     if (((Boolean)examsMFinStatus.get("MFin")).booleanValue())//entry is now for first
    {
       isMFinClassMidOpen = true;  
     }
     
     
      if (((Boolean)examsStatus.get("M")).booleanValue())//entry is now for marks
    {
         isClassMidOpen = true;  
      }
     
      if(isClassMidOpen ||isM1ClassMidOpen || isM2ClassMidOpen||isMMidClassMidOpen||isMFinClassMidOpen ){
         tempTutorClassApprovment = isStudentMarksApprovedData(prtlTutorClassPK);
      isClassApproved = (tempTutorClassApprovment != null) && (tempTutorClassApprovment.getApprove().equalsIgnoreCase("Y"));
      if (isClassApproved)
      {
        retList = new ArrayList();
        retList.add("approved");
        return retList;
      } 
      }
     
      
    /*  
    if (((Boolean)examsStatus.get("M")).booleanValue())//entry is now for marks
    {
      isClassMidOpen = true;
      tempTutorClassApprovment = isStudentMarksApprovedData(prtlTutorClassPK);
      isClassApproved = (tempTutorClassApprovment != null) && (tempTutorClassApprovment.getApprove().equalsIgnoreCase("Y"));
      if (isClassApproved)
      {
        retList = new ArrayList();
        retList.add("approved");
        return retList;
      }
    }
      */
    if (!isClassApproved)
    {
      try
      {
        session = getSession();
        tx = session.beginTransaction();
        for (int i = 0; i < vtrStudensMarks.size(); i++)
        {
          temp = (PrtlTutorStudMark)vtrStudensMarks.elementAt(i);
          Object obj = getMarksInsertedBefor(temp.getComp_id());
          if (obj != null)
          {
            prtlTutorStudMark = (PrtlTutorStudMark)obj;
            isMarkExist = true;
          }
          else
          {
            prtlTutorStudMark = new PrtlTutorStudMark();
            isMarkExist = false;
          }
          prtlTutorStudMark.setComp_id(temp.getComp_id());
          prtlTutorStudMark.setClassNo(temp.getClassNo());
          prtlTutorStudMark.setTimeStamp(temp.getTimeStamp());
          prtlTutorStudMark.setUserId(temp.getUserId());
          
          /// if (isClassMidOpen) { //removed to save mark even if calendar is closed 
             prtlTutorStudMark.setFinalMark(temp.getFinalMark()); 
             
        /// }   
          //
           if (isM1ClassMidOpen) {           
            prtlTutorStudMark.setFirstMark(temp.getFirstMark());         
          }
           
            if (isM2ClassMidOpen) {           
            prtlTutorStudMark.setSecondMark(temp.getSecondMark());         
          }
            
             if (isMMidClassMidOpen) {           
            prtlTutorStudMark.setMidMark(temp.getMidMark());         
          }
             
              if (isMFinClassMidOpen) {           
            prtlTutorStudMark.setFinMark(temp.getFinMark());         
          }
             
           //  short totalMArks =(short) (temp.getFirstMark() );
             //    prtlTutorStudMark.setFinalMark(  totalMArks);  
           
            ///
          if (isMarkExist) {
            session.update(prtlTutorStudMark);
          } else {
            session.save(prtlTutorStudMark);
          }
        }
        tx.commit();
      }
      catch (SQLException sqle)
      {
        if (tx != null) {
          tx.rollback();
        }
        retList = new ArrayList();
        retList.add(sqle.getMessage());
        if (logger.isDebugEnabled()) {
          logger.debug("Error in data base" + sqle);
        }
        sqle.printStackTrace();
      }
      catch (HibernateException he)
      {
        if (tx != null) {
          tx.rollback();
        }
        retList = new ArrayList();
        retList.add(he.getMessage());
        if (logger.isDebugEnabled()) {
          logger.debug("Error in data Hibernate" + he);
        }
        he.printStackTrace();
      }
      finally
      {
        if (session != null) {
          try
          {
            releaseSession(session);
          }
          catch (Exception e)
          {
            retList = new ArrayList();
            retList.add(e.getMessage());
            e.printStackTrace();
            if (logger.isDebugEnabled()) {
              logger.debug("Error closing the session" + e);
            }
          }
        }
      }
    }
    else
    {
      retList = new ArrayList();
      retList.add("approved");
      if (logger.isDebugEnabled()) {
        logger.debug("Try To make changes on approved Class Marks");
      }
    }
    return retList;
  }
  
  public PrtlTutorMarkApprovment isStudentMarksApprovedData(PrtlTutorMarkApprovmentPK prtlTutorClassPK)
    throws ComponentException
  {
    PrtlTutorMarkApprovment prtlTutorClassApprovment = null;
    try
    {
      List retList = super.getList("portal.TutorStudentsMarksApprovedData", new Object[] { prtlTutorClassPK.getTermNo(), prtlTutorClassPK.getCrsNo(), prtlTutorClassPK.getClassNo() });
      if ((retList != null) && (retList.size() > 0)) {
        prtlTutorClassApprovment = (PrtlTutorMarkApprovment)retList.iterator().next();
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
      if (logger.isDebugEnabled()) {
        logger.debug("Error in isStudentMarksApprovedData method" + e);
      }
    }
    return prtlTutorClassApprovment;
  }
  
  public PrtlTutorStudMark getMarksInsertedBefor(PrtlTutorStudMarkPK prtlStudMatksPK)
    throws ComponentException
  {
    List retList = null;
    PrtlTutorStudMark ptsm = null;
    try
    {
      retList = super.getList("portal.TutorStudentsMarksExist", new Object[] { prtlStudMatksPK.getTermNo(), prtlStudMatksPK.getCrsNo(), prtlStudMatksPK.getStudId() });
      if ((retList != null) && (retList.size() != 0)) {
        ptsm = (PrtlTutorStudMark)retList.get(0);
      }
      return ptsm;
    }
    catch (ComponentException e)
    {
      e = 
      






        e;e.printStackTrace();
      if (logger.isDebugEnabled()) {
        logger.debug("Error in getMarksInsertedBefor method" + e);
      }
      return ptsm;
    }
    finally {}
    //return ptsm;
  }
  
  public List saveAndCommitStudentsMarks(Object[] parameters)
    throws ComponentException
  {
    List retList = null;
    Session session = null;
    Transaction tx = null;
    DataAccessObjectImpl dataAccessObjectImpl = new DataAccessObjectImpl();
    
    Vector vtrStudensMarks = (Vector)parameters[0];
    PrtlTutorMarkApprovment prtlTutorClassApprovment = (PrtlTutorMarkApprovment)parameters[1];
    PrtlTutorMarkApprovmentPK prtlTutorClassPK = prtlTutorClassApprovment.getComp_id();
    PrtlTutorMarkApprovment tempTutorClassApprovment = null;
    
    PrtlTutorStudMark prtlTutorStudMark = new PrtlTutorStudMark();
    PrtlTutorStudMark temp = new PrtlTutorStudMark();
    boolean isMarkExist = false;
    boolean isClassOpen = false;
    boolean isClassApproved = false;
    
    HashTable examsStatus = isCalenderOpend(prtlTutorClassPK.getTermNo());
    if (((Boolean)examsStatus.get("M")).booleanValue())
    {
      isClassOpen = true;
      tempTutorClassApprovment = isStudentMarksApprovedData(prtlTutorClassApprovment.getComp_id());
      
      isClassApproved = (tempTutorClassApprovment != null) && (tempTutorClassApprovment.getApprove().equalsIgnoreCase("Y"));
      if (isClassApproved)
      {
        retList = new ArrayList();
        retList.add("approved");
        return retList;
      }
    }
    if (!isClassApproved)
    {
      try
      {
        session = getSession();
        tx = session.beginTransaction();
        for (int i = 0; i < vtrStudensMarks.size(); i++)
        {
          temp = (PrtlTutorStudMark)vtrStudensMarks.elementAt(i);
          Object obj = getMarksInsertedBefor(temp.getComp_id());
          if (obj != null)
          {
            prtlTutorStudMark = (PrtlTutorStudMark)obj;
            isMarkExist = true;
          }
          else
          {
            prtlTutorStudMark = new PrtlTutorStudMark();
            isMarkExist = false;
          }
          prtlTutorStudMark.setComp_id(temp.getComp_id());
          prtlTutorStudMark.setClassNo(temp.getClassNo());
          prtlTutorStudMark.setTimeStamp(temp.getTimeStamp());
          prtlTutorStudMark.setUserId(temp.getUserId());
          if (isClassOpen) {
            prtlTutorStudMark.setFinalMark(temp.getFinalMark());
          }
          if ((isMarkExist) && (!isClassApproved)) {
            session.update(prtlTutorStudMark);
          } else if (!isClassApproved) {
            session.save(prtlTutorStudMark);
          }
        }
        if (isClassOpen) {
          if (tempTutorClassApprovment == null) {
            session.save(prtlTutorClassApprovment);
          } else {
            session.update(prtlTutorClassApprovment);
          }
        }
        tx.commit();
      }
      catch (Exception sqle)
      {
        if (tx != null) {
          tx.rollback();
        }
        retList = new ArrayList();
        retList.add(sqle.getMessage());
        if (logger.isDebugEnabled()) {
          logger.debug("Error in data base" + sqle);
        }
        sqle.printStackTrace();
      }
      finally
      {
        if (session != null) {
          try
          {
            dataAccessObjectImpl.releaseSession(session);
          }
          catch (Exception e)
          {
            retList = new ArrayList();
            retList.add(e.getMessage());
            e.printStackTrace();
            if (logger.isDebugEnabled()) {
              logger.debug("Error closing the session" + e);
            }
          }
        }
      }
    }
    else
    {
      retList = new ArrayList();
      retList.add("approved");
      if (logger.isDebugEnabled()) {
        logger.debug("Try To make changes on approved Class Marks");
      }
    }
    return retList;
  }
}



/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\

 * Qualified Name:     ps.edu.diyar.tutorInfo.component.TutorComponent

 * JD-Core Version:    0.7.0.1

 */