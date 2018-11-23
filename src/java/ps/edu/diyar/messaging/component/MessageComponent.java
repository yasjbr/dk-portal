/*
 * Decompiled with CFR 0_102.
 * 
 * Could not load the following classes:
 *  oracle.sql.BLOB
 *  oracle.sql.CLOB
 *  org.apache.log4j.Logger
 *  org.apache.struts.upload.FormFile
 *  org.hibernate.Hibernate
 *  org.hibernate.HibernateException
 *  org.hibernate.LockMode
 *  org.hibernate.Query
 *  org.hibernate.Session
 *  org.hibernate.Transaction
 *  org.hibernate.lob.SerializableBlob
 *  org.hibernate.lob.SerializableClob
 *  ps.edu.diyar.common.component.DataAccessObjectImpl
 *  ps.edu.diyar.common.component.DgfComponentH3
 *  ps.edu.diyar.common.component.SequencesCmp
 *  ps.edu.diyar.common.exceptions.ComponentException
 *  ps.edu.diyar.messaging.database.PrtlMessageAttachment
 *  ps.edu.diyar.messaging.database.PrtlMessageAttachmentPK
 *  ps.edu.diyar.messaging.database.PrtlMessageContent
 *  ps.edu.diyar.messaging.database.PrtlMessageRecipient
 *  ps.edu.diyar.messaging.database.PrtlMessageRecipientPK
 */
package ps.edu.diyar.messaging.component;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.io.Writer;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import oracle.sql.BLOB;
import oracle.sql.CLOB;
import org.apache.log4j.Logger;
import org.apache.struts.upload.FormFile;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.lob.SerializableBlob;
import org.hibernate.lob.SerializableClob;
import ps.edu.diyar.common.component.DataAccessObjectImpl;
import ps.edu.diyar.common.component.DgfComponentH3;
import ps.edu.diyar.common.component.SequencesCmp;
import ps.edu.diyar.common.exceptions.ComponentException;
import ps.edu.diyar.messaging.database.PrtlMessageAttachment;
import ps.edu.diyar.messaging.database.PrtlMessageAttachmentPK;
import ps.edu.diyar.messaging.database.PrtlMessageContent;
import ps.edu.diyar.messaging.database.PrtlMessageRecipient;
import ps.edu.diyar.messaging.database.PrtlMessageRecipientPK;

public class MessageComponent
        extends DgfComponentH3 {
    private static Logger logger = Logger.getLogger((Class)MessageComponent.class);

    public Long saveMessage(String messageBody, String subject, String hasAttachment, String seed, String servirity, String senderId, String termNo, String crsNo, String crsClass, String extraInfo, String remoteIp,String deleted,String deleteDate) throws ComponentException {
        Session session = null;
        Transaction tx = null;
        Long msgId = null;
        try {
            session = this.getSession();
            tx = session.beginTransaction();
            PrtlMessageContent prtlMessageContent = new PrtlMessageContent();
            prtlMessageContent.setMsgBody(Hibernate.createClob((String)" "));
            prtlMessageContent.setMsgTitle(subject);
            prtlMessageContent.setMsgType("");
            prtlMessageContent.setServirity(servirity);
            prtlMessageContent.setSenderId(senderId);
            prtlMessageContent.setTermNo(termNo);
            prtlMessageContent.setCrsNo(crsNo);
            prtlMessageContent.setClassNo(crsClass);
            prtlMessageContent.setExtraInfo(extraInfo);
            prtlMessageContent.setTimeStamp(new Date());
            prtlMessageContent.setComputerIp(remoteIp);
             prtlMessageContent.setDeleted(deleted);
              prtlMessageContent.setDeleteDate(deleteDate);
            if (hasAttachment.equals("Y")) {
                prtlMessageContent.setSeed(seed);
                prtlMessageContent.setHasAttachment("Y");
            } else {
                prtlMessageContent.setHasAttachment("N");
            }
            msgId = (Long)session.save((Object)prtlMessageContent);
            session.flush();
            session.refresh((Object)prtlMessageContent, LockMode.UPGRADE);
            SerializableClob clob = (SerializableClob)prtlMessageContent.getMsgBody();
            Clob wrapClob = clob.getWrappedClob();
            CLOB cb = (CLOB)wrapClob;
            Writer pw = cb.setCharacterStream(0);
            try {
                pw.write(messageBody);
                pw.close();
            }
            catch (IOException e2) {
                System.err.println("Error in MessageComponent.saveMessage :" + e2);
                e2.printStackTrace();
            }
            tx.commit();
            if (msgId == null) {
                throw new ComponentException(" unsvaed Message");
            }
            Long e2 = msgId;
            return e2;
        }
        catch (Exception e) {
            System.err.println("Error in MessageComponent.saveMessage:" + e);
            logger.error((Object)("Error in MessageComponent.saveMessage:" + e));
            throw new ComponentException(e.getMessage());
        }
        finally {
            block15 : {
                if (session != null) {
                    try {
                        this.releaseSession(session);
                    }
                    catch (Exception e) {
                        if (!logger.isDebugEnabled()) break block15;
                        logger.debug((Object)("Error closing the session" + e));
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void saveFile(FormFile file, String msgId, String seed) throws ComponentException {
        long fileId = new Long(new SequencesCmp().getNextValue("PRTL_FILE_SEQ"));
        Session session = null;
        if (file.getFileSize() > 0) {
            try {
                PrtlMessageAttachmentPK dbObjPK = new PrtlMessageAttachmentPK(Long.valueOf(fileId), new Long(msgId));
                PrtlMessageAttachment dbObj = new PrtlMessageAttachment();
                dbObj.setComp_id(dbObjPK);
                dbObj.setFileName(file.getFileName());
                dbObj.setFileType(file.getContentType());
                dbObj.setFileSize("" + file.getFileSize());
                dbObj.setFileContent(Hibernate.createBlob((byte[])new byte[]{0}));
                dbObj.setSeed(seed);
                dbObj.setTimeStamp(new Date());
                session = this.getSession();
                session.save((Object)dbObj);
                session.flush();
                session.refresh((Object)dbObj, LockMode.UPGRADE);
                SerializableBlob blob = (SerializableBlob)dbObj.getFileContent();
                Blob wrapBlob = blob.getWrappedBlob();
                BLOB bb = (BLOB)wrapBlob;
                OutputStream pw = bb.setBinaryStream(0);
                try {
                    pw.write(file.getFileData());
                    pw.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                    System.out.println(" *** IOException in Write on BOLB in MessageComponent.saveFile :" + e);
                }
                catch (Exception e) {
                    e.printStackTrace();
                    System.out.println(" *** Exception in Write on BOLB in MessageComponent.saveFile :" + e);
                }
            }
            catch (SQLException sqle) {
                if (logger.isDebugEnabled()) {
                    logger.debug((Object)("Error in data base in file MessageComponent:" + sqle));
                }
                sqle.printStackTrace();
            }
            catch (HibernateException he) {
                if (logger.isDebugEnabled()) {
                    logger.debug((Object)("Error in data Hibernate in file MessageComponent:" + (Object)he));
                }
                he.printStackTrace();
            }
            finally {
                block23 : {
                    if (session != null) {
                        try {
                            this.releaseSession(session);
                        }
                        catch (Exception e) {
                            if (!logger.isDebugEnabled()) break block23;
                            logger.debug((Object)("Error closing the session" + e));
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public void saveMessageRecipient(Long msgId, String recieverId) throws ComponentException {
        PrtlMessageRecipientPK prtlMessageRecipientPK = new PrtlMessageRecipientPK(msgId, recieverId);
        PrtlMessageRecipient prtlMessageRecipient = new PrtlMessageRecipient();
        prtlMessageRecipient.setComp_id(prtlMessageRecipientPK);
        prtlMessageRecipient.setViewed("F");
         prtlMessageRecipient.setDeleted("F");
        DataAccessObjectImpl dataAccessObjectImpl = new DataAccessObjectImpl();
        dataAccessObjectImpl.insert((Object)prtlMessageRecipient);
    }

    public List deleteMsg(Object[] parm) throws ComponentException {
        Session session = null;
        Transaction tx = null;
        List list = null;
        String userId = (String)parm[0];
        String msgs = (String)parm[1];
        try {
            if (msgs.length() > 0) {
                msgs = msgs.toString().substring(0, msgs.toString().lastIndexOf(","));
            }
        }
        catch (Exception e) {
            // empty catch block
        }
        try {
            String queryStr = " delete from ps.edu.diyar.messaging.database.PrtlMessageRecipient msg where  msg.comp_id.msgId in (" + msgs + ")" + " and " + " msg.comp_id.recipientId='" + userId + "'";
            session = this.getSession();
            tx = session.beginTransaction();
            Query query = session.createQuery(queryStr);
            query.executeUpdate();
            tx.commit();
        }
        catch (SQLException sqle) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error((Object)(" Error deleting Msg " + sqle));
        }
        catch (HibernateException hbe) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(" Error deleting Msg in hibernate" + (Object)hbe);
            logger.error((Object)(" Error deleting Msg in hibernate " + (Object)hbe));
        }
        finally {
            if (session != null) {
                try {
                    this.releaseSession(session);
                }
                catch (Exception e) {
                    System.out.println("Error releasing sessions" + e);
                    logger.error((Object)("Error releasing sessions " + e));
                }
            }
        }
        return list;
    }
    
    
     public List vDeleteRecievedMsg(Object[] parm) throws ComponentException {
        Session session = null;
        Transaction tx = null;
        List list = null;
        String userId = (String)parm[0];
        String msgs = (String)parm[1];
        
        try {
            if (msgs.length() > 0) {
                msgs = msgs.toString().substring(0, msgs.toString().lastIndexOf(","));
            }
        }
        catch (Exception e) {
            // empty catch block
        }
        try {
            String queryStr = " update ps.edu.diyar.messaging.database.PrtlMessageRecipient msg set deleted='T',delete_date =:today  where  msg.comp_id.msgId in (" + msgs + ")" + " and " + " msg.comp_id.recipientId='" + userId + "'";
            session = this.getSession();
            tx = session.beginTransaction();
            Query query = session.createQuery(queryStr);
            query.setParameter("today", new Date());
            query.executeUpdate();
            tx.commit();
        }
        catch (SQLException sqle) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error((Object)(" Error deleting Msg " + sqle));
        }
        catch (HibernateException hbe) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(" Error deleting Msg in hibernate" + (Object)hbe);
            logger.error((Object)(" Error deleting Msg in hibernate " + (Object)hbe));
        }
        finally {
            if (session != null) {
                try {
                    this.releaseSession(session);
                }
                catch (Exception e) {
                    System.out.println("Error releasing sessions" + e);
                    logger.error((Object)("Error releasing sessions " + e));
                }
            }
        }
        return list;
    }
   
     
      public List vDeleteSentMsg(Object[] parm) throws ComponentException {
        Session session = null;
        Transaction tx = null;
        List list = null;
        String userId = (String)parm[0];
        String msgs = (String)parm[1];
        
        try {
            if (msgs.length() > 0) {
                msgs = msgs.toString().substring(0, msgs.toString().lastIndexOf(","));
            }
        }
        catch (Exception e) {
            // empty catch block
        }
        try {
            String queryStr = " update ps.edu.diyar.messaging.database.PrtlMessageContent msg set deleted='T',delete_date =:today  where  msg.msgId in (" + msgs + ")" + " and " + " msg.senderId='" + userId + "'";
            session = this.getSession();
            tx = session.beginTransaction();
            Query query = session.createQuery(queryStr);
            query.setParameter("today", new Date());
            query.executeUpdate();
            tx.commit();
        }
        catch (SQLException sqle) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error((Object)(" Error deleting Msg " + sqle));
        }
        catch (HibernateException hbe) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(" Error deleting Msg in hibernate" + (Object)hbe);
            logger.error((Object)(" Error deleting Msg in hibernate " + (Object)hbe));
        }
        finally {
            if (session != null) {
                try {
                    this.releaseSession(session);
                }
                catch (Exception e) {
                    System.out.println("Error releasing sessions" + e);
                    logger.error((Object)("Error releasing sessions " + e));
                }
            }
        }
        return list;
    }
}