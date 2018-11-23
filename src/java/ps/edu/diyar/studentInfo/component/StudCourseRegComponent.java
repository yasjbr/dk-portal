package ps.edu.diyar.studentInfo.component;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ps.edu.diyar.common.component.DgfComponentH3;
import ps.edu.diyar.common.exceptions.ComponentException;
import ps.edu.diyar.studentInfo.database.PrtlRegStudApprove;
import ps.edu.diyar.studentInfo.database.PrtlRegStudApprovePK;
import ps.edu.diyar.studentInfo.database.PrtlRegStudControl;
import ps.edu.diyar.studentInfo.database.RegCourse;
import ps.edu.diyar.studentInfo.database.RegCoursePrereqPK;
import ps.edu.diyar.studentInfo.database.RegStud;
import ps.edu.diyar.studentInfo.database.RegStudPK;

public class StudCourseRegComponent
        extends DgfComponentH3
{
    private static Logger logger = Logger.getLogger(StudCourseRegComponent.class);

    public String saveCourses(String studId, String termNo, ArrayList courses, PrtlRegStudApprove regAppSave, int prevNewHsum)
            throws Exception
    {
        Session session = null;
        Transaction tx = null;
        StringBuffer messages = new StringBuffer();
        PrtlRegStudApprove dbRegApprove = null;
        try
        {
            session = getSession();
            try
            {
                dbRegApprove = (PrtlRegStudApprove)session.load(PrtlRegStudApprove.class, regAppSave.getComp_id());
                if ((dbRegApprove.getRegApp() != null) && (dbRegApprove.getRegApp().equalsIgnoreCase("Y")))
                {
                    messages.append("لا يمكن التعديل على بيانات التسجيل بعد التثبيت<br>");
                    return messages.toString();
                }
            }
            catch (Exception nfExp)
            {
                dbRegApprove = null;
            }
            tx = session.beginTransaction();


            boolean saveCrs = false;
            boolean noApprove = false;

            RegStud regStud = null;
            String msgCrsPreReq = null;
            Iterator iter = courses.iterator();
            while (iter.hasNext())
            {
               
                regStud = (RegStud)iter.next();
  System.out.println("error y12");
                msgCrsPreReq = chkCrsHasPrerequset(studId, regStud.getComp_id().getCrsNo());
                  System.out.println("error y555"+msgCrsPreReq);
                if ((msgCrsPreReq != null) && (!msgCrsPreReq.trim().equals("")))
                {
                    noApprove = true;
                    saveCrs = false;
                    messages.append(msgCrsPreReq);
                       System.out.println("error y5998");
                }
                else
                {
                    saveCrs = true;
                   
                }
                if (saveCrs)
                {
                      System.out.println("error y54");
                    msgCrsPreReq = chkClassIsFull(termNo, regStud.getCrsClass(), regStud.getComp_id().getCrsNo());
                      System.out.println("error y5133");
                    if ((msgCrsPreReq != null) && (!msgCrsPreReq.trim().equals("")))
                    {
                          System.out.println("error y51");
                        noApprove = true;
                        saveCrs = false;
                        messages.append(msgCrsPreReq);
                    }
                }
                if (saveCrs)
                {
                    regStud.setInGpa("Y");
                    regStud.setIsActive("1");
                    regStud.setCrsStatus("R");
                    session.save(regStud);
                }
            }
            if ((noApprove) && (regAppSave.getRegApp() != null) && (regAppSave.getRegApp().equalsIgnoreCase("Y")))
            {
                regAppSave.setRegApp(null);
                regAppSave.setRegSave("Y");
                if (messages.length() > 0) {
                    messages.append("<br><hr align=\"center\" size=\"1\"></hr>");
                }
                messages.append("ملاحظة هامة: لم يتم تثيت تسجيلك  للاسباب المذكورة أعلاه.<br>");
                messages.append("يرجى معالجة الخطأ ومحالة التثبيت مرة أخرى<br>");
                messages.append("لقد تم حفظ البيانات مع التنويه الى ضرورة التثبيت بعد معالجة الخطأ<br>");
            }
            tx.commit();
            tx = session.beginTransaction();
             System.out.println("error y51");
            if (dbRegApprove != null)
            {
                if (regAppSave.getRegApp() != null)
                {
                    dbRegApprove.setRegApp(regAppSave.getRegApp());
                    dbRegApprove.setRegAppDate(regAppSave.getRegAppDate());
                     System.out.println("error y5");
                }
                if (regAppSave.getRegSave() != null)
                {
                    dbRegApprove.setRegSave(regAppSave.getRegSave());
                    dbRegApprove.setRegSaveDate(regAppSave.getRegSaveDate());
                }
                dbRegApprove.setUserId(regAppSave.getUserId());
                session.update(dbRegApprove);
                 System.out.println("error y4");
            }
            else
            {
                session.save(regAppSave);
                 System.out.println("error y3");
            }
            tx.commit();
            return messages.toString();
        }
        catch (Exception he)
        {
            if (tx != null) {
                tx.rollback();
                 System.out.println("error y2");
            }
            if (logger.isDebugEnabled()) {
                logger.debug("Error in data Hibernate" + he);
                System.out.println("error y1");
            }
            messages.append("حدث خطأ .... يرجى مراجعة قسم القبول و التسجيل");
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
                    if (logger.isDebugEnabled()) {
                        logger.debug("Error closing the session" + e);
                    }
                }
            }
        }
        return messages.toString();
    }

    private String chkCrsHasPrerequset(String studId, String crsNo)
            throws Exception
    {
        Session session = null;
        String msg = "";
        try
        {
            session = getSession();
            Connection con = session.connection();


            CallableStatement cs = con.prepareCall("{? = call PRTL_REGISTRATION.crs_has_prereq(?,?)}");
            cs.registerOutParameter(1, 12);
            cs.setString(2, studId);
            cs.setString(3, crsNo);

            cs.execute();
            String hasPrereq = cs.getString(1);
            RegCourse postCourse= null;
            RegCourse preReqCourse= null;
              System.out.println("error y6"+hasPrereq);
            if ((hasPrereq != null) && (hasPrereq.equals("T")))
            {
                 System.out.println("error y6.999");
                postCourse = (RegCourse)session.load(RegCourse.class, crsNo);
                preReqCourse = (RegCourse)super.getList("stud.getPreReqCourse", new Object[] { crsNo }).iterator().next();
            }
             System.out.println("error yrdd6");
            
           if (hasPrereq.equalsIgnoreCase("T")){
           return "-لم يتم تسجيل المقرر " + postCourse.getCrsAName() + " لعدم اجتياز المتطلب السابق " + preReqCourse.getCrsAName() + "<br/>";
           }
           else
                System.out.println("return null"+hasPrereq);
               return "";
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
                    if (logger.isDebugEnabled()) {
                        logger.debug("Error closing the session" + e);
                    }
                }
            }
        }
    }

    private String chkClassIsFull(String termNo, String classNo, String crsNo)
            throws Exception
    {
        Session session = null;
        String msg = "";
        try
        {
            session = getSession();
            Connection con = session.connection();


            CallableStatement cs = con.prepareCall("{? = call PRTL_REGISTRATION.class_is_full(?,?,?)}");
            cs.registerOutParameter(1, 12);
            cs.setString(2, termNo);
            cs.setString(3, classNo);
            cs.setString(4, crsNo);

            cs.execute();
            String isFull = cs.getString(1);
            RegCourse postCourse= null;
             System.out.println("error h1");
            if ((isFull != null) && (isFull.equals("T"))) {
                 
                postCourse = (RegCourse)session.load(RegCourse.class, crsNo);
                 return "-لم يتم تسجيل المقرر " + postCourse.getCrsAName() + " وذلك لأن الشعبة مغلقة " + "<br/>";
            }
            else return "";
            
           // return "-لم يتم تسجيل المقرر " + postCourse.getCrsAName() + " وذلك لأن الشعبة مغلقة " + "<br/>";
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
                    if (logger.isDebugEnabled()) {
                        logger.debug("Error closing the session" + e);
                    }
                }
            }
        }
    }

    public String deleteCourse(String studId, String termNo, String crsNo, int crsHours, String calendarItem, String userId, String remoteAddr)
            throws ComponentException
    {
        Session session = null;
        Transaction tx = null;
        ArrayList notDeletedCrs = new ArrayList();
        StringBuffer messages = new StringBuffer();
        try
        {
            session = getSession();


            String retValue = "";
            PrtlRegStudApprove dbRegAppp = null;
            try
            {
                dbRegAppp = (PrtlRegStudApprove)session.load(PrtlRegStudApprove.class, new PrtlRegStudApprovePK(studId, termNo, calendarItem));
            }
            catch (ObjectNotFoundException e)
            {
                dbRegAppp = null;
            }
            if ((dbRegAppp == null) || (dbRegAppp.getRegApp() == null) || (!dbRegAppp.getRegApp().equalsIgnoreCase("Y")))
            {
                Connection con = session.connection();
                CallableStatement cs = con.prepareCall("{? = call PRTL_REGISTRATION.crs_has_prereq_on_del(?,?)}");
                cs.registerOutParameter(1, 12);
                cs.setString(2, studId);
                cs.setString(3, crsNo);
                cs.execute();
                retValue = cs.getString(1);
                if (retValue.equalsIgnoreCase("F"))
                {
                    tx = session.beginTransaction();

                    RegStudPK regRcComp_id = new RegStudPK(studId, termNo, crsNo);
                    RegStud regRc = (RegStud)session.load(RegStud.class, regRcComp_id);
                    PrtlRegStudControl prtlRegStudControl = new PrtlRegStudControl();
                    prtlRegStudControl.setTermNo(regRc.getComp_id().getTermNo());
                    prtlRegStudControl.setStudId(regRc.getComp_id().getStudId());
                    prtlRegStudControl.setCrsNo(regRc.getComp_id().getCrsNo());
                    prtlRegStudControl.setStatus("1");
                    prtlRegStudControl.setTimeStamp(new Date());
                    prtlRegStudControl.setUserId(userId);
                    prtlRegStudControl.setComputerIp(remoteAddr);

                    session.delete(regRc);

                    session.save(prtlRegStudControl);


                    tx.commit();
                }
                else
                {
                    notDeletedCrs.add(new RegCoursePrereqPK(crsNo));
                    RegCourse postCourse = (RegCourse)session.load(RegCourse.class, new RegCourse(crsNo));
                    RegCourse preReqCourse = (RegCourse)session.load(RegCourse.class, new RegCourse(retValue));

                    messages.append(" لم يتم حذف المقرر " + postCourse.getCrsAName() + " لأنه متطلب سابق للمقرر " + preReqCourse.getCrsAName() + "<br>");
                }
            }
            return messages.toString();
        }
        catch (SQLException sqle)
        {
            if (tx != null) {
                tx.rollback();
            }
            notDeletedCrs.add(sqle.getMessage());
            if (logger.isDebugEnabled()) {
                logger.debug("Error in data base" + sqle);
            }
            messages.append(sqle.getMessage() + "<br>");
        }
        catch (ObjectNotFoundException on)
        {
            if (tx != null) {
                tx.rollback();
            }
            notDeletedCrs.add(on.getMessage());
            if (logger.isDebugEnabled()) {
                logger.debug("Error in Hibernate" + on);
            }
            messages.append(on.getMessage() + "<br>");
        }
        catch (HibernateException he)
        {
            if (tx != null) {
                tx.rollback();
            }
            notDeletedCrs.add(he.getMessage());
            if (logger.isDebugEnabled()) {
                logger.debug("Error in data Hibernate" + he);
            }
            messages.append(he.getMessage() + "<br>");
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
                    notDeletedCrs.add(e.getMessage());
                    if (logger.isDebugEnabled()) {
                        logger.debug("Error closing the session" + e);
                    }
                    messages.append(e.getMessage() + "<br>");
                }
            }
        }
        return messages.toString();
    }
}
