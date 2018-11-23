package ps.edu.diyar.tutorInfo.component;

import java.io.PrintStream;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import ps.edu.diyar.common.component.DgfComponentH3;
import ps.edu.diyar.common.exceptions.ComponentException;

public class TutorTermScheduleComponent
  extends DgfComponentH3
{
  public List getTutorTermSchedule(Object[] parameters)
  {
    List retList = null;
    try
    {
      retList = super.getList("Portal.getTutorSchedule", parameters);
    }
    catch (ComponentException e)
    {
      System.err.println("Error in Tutor term schedule component " + e);
    }
    return retList;
  }
  
  public List getTutorMarkInsertion(Object[] parameters)
  {
    List retList = null;
    try
    {
      retList = super.getList("Portal.getTutorMarkInsertion", parameters);
    }
    catch (ComponentException e)
    {
      System.err.println("Error in TutorTermScheduleComponent.getTutorMarkInsertion: " + e);
    }
    return retList;
  }
  
  public List getStudentListForMultiCourse(Object[] parameters)
  {
    List retList = null;
    try
    {
      String query = " select distinct new ps.edu.diyar.studentInfo.database.struct.TutorListForCenter  (a.comp_id.studId, a.studName) from ps.edu.diyar.studentInfo.database.RegStudVw a where a.comp_id.termNo= '" + parameters[0].toString() + "' and ( " + parameters[1].toString() + " ) order by a.studName";
      







      Session hbSession = super.getSession();
      retList = hbSession.createQuery(query).list();
      hbSession.close();
    }
    catch (Exception e)
    {
      e.printStackTrace();
      System.out.println("Error in getStudentListForMultiCourse in TutorTermScheduleComponent " + e);
    }
    return retList;
  }
  
  public List getTutorsStudentListForMarksInsertion(Object[] param)
  {
    List retList = null;
    try
    {
      retList = super.getList("Portal.getTutorsStudentListForMarkInsertion", param);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      System.out.println("Error in in Student List For Course" + e);
    }
    return retList;
  }
}
