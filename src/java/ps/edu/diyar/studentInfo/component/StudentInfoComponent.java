/*
 * Decompiled with CFR 0_102.
 * 
 * Could not load the following classes:
 *  oracle.sql.BLOB
 *  org.apache.struts.upload.FormFile
 *  org.hibernate.Hibernate
 *  org.hibernate.LockMode
 *  org.hibernate.Session
 *  org.hibernate.Transaction
 *  org.hibernate.lob.SerializableBlob
 *  ps.edu.diyar.common.component.DataAccessObjectImpl
 *  ps.edu.diyar.common.component.DgfComponentH3
 *  ps.edu.diyar.common.exceptions.ComponentException
 *  ps.edu.diyar.studentInfo.database.PrtlSetup
 *  ps.edu.diyar.studentInfo.database.SrvyHealthDetail
 *  ps.edu.diyar.studentInfo.database.SrvyTuition
 *  ps.edu.diyar.studentInfo.database.SrvyTuitionPK
 */
package ps.edu.diyar.studentInfo.component;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import oracle.sql.BLOB;
import org.apache.struts.upload.FormFile;
import org.hibernate.Hibernate;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.lob.SerializableBlob;
import ps.edu.diyar.common.component.DataAccessObjectImpl;
import ps.edu.diyar.common.component.DgfComponentH3;
import ps.edu.diyar.common.exceptions.ComponentException;
import ps.edu.diyar.studentInfo.database.PrtlSetup;
import ps.edu.diyar.studentInfo.database.SrvyHealthDetail;
import ps.edu.diyar.studentInfo.database.SrvyTuition;
import ps.edu.diyar.studentInfo.database.SrvyTuitionPK;

public class StudentInfoComponent
        extends DgfComponentH3 {
    
    public String getCurrentTerm() {
        String currentTerm = "";
        try {
            List list = new DataAccessObjectImpl().getList("stud.getCurrentTerm");
            PrtlSetup ps = (PrtlSetup)list.get(0);
            currentTerm = ps.getSetupValue();
        }
        catch (Exception e) {
            System.err.println("Error in in Current Term Student Info Comp" + e);
        }
        return currentTerm;
    }

    
    
    public String getCrsRegTerm() {
        String crsRegTerm = "";
        try {
            List list = new DataAccessObjectImpl().getList("stud.getCrsRegTerm");
            PrtlSetup ps = (PrtlSetup)list.get(0);
            crsRegTerm = ps.getSetupValue();
        }
        catch (Exception e) {
            System.err.println("Error in in crsRegTerm Student Info Comp" + e);
        }
        return crsRegTerm;
    }
    
    public Collection getMsCourseList(String msNo, String specNo, String studId) {
        Collection retList = null;
        try {
          //  String query = " select new ps.edu.diyar.studentInfo.database.struct.MsCoursesList \n(rmct.msCrsType,rmct.msCrsTypeAName, rc.crsNo, rc.crsAName,rc.crHrs, rs.crsMark, rs.crsStatus,rcs.statusAName,rs.comp_id.termNo) \nfrom   ps.edu.diyar.studentInfo.database.RegMsDtl msd,\n       ps.edu.diyar.studentInfo.database.RegStud rs,\n       ps.edu.diyar.studentInfo.database.RegCourse rc,\n       ps.edu.diyar.studentInfo.database.RegCourseStatus rcs,\n       ps.edu.diyar.studentInfo.database.RegMsCrsType rmct\n  where \n      rcs.statusNo"+"(+)"+ "= rs.crsStatus \n  and rc.crsNo = msd.comp_id.crsNo\n  and msd.comp_id.msCrsType = rmct.msCrsType\n  and msd.comp_id.crsNo = rs.comp_id.crsNo(+)\n  and msd.comp_id.msCrsType = rs.msCrsType(+)\n  and msd.comp_id.msNo= '" + msNo + "'\n" + "  and msd.comp_id.specNo= '" + specNo + "'\n" + "  and rs.comp_id.studId(+) = '" + studId + "'\n" + "  \n" + "  order by rs.comp_id.termNo,msd.comp_id.msCrsType   ";
               String query = " select new ps.edu.diyar.studentInfo.database.struct.MsCoursesList \n(comp_id.msCrsType,msd.msCrsTypeAName, comp_id.crsNo, msd.crsAName,msd.crHrs, msd.crsMark, msd.crsStatus,msd.statusAName,msd.comp_id.termNo) \nfrom   ps.edu.diyar.studentInfo.database.RegStudGuide msd\n  where   comp_id.studId = '" + studId + "'\n" + "  \n" + "  order by  comp_id.termNo, comp_id.msCrsType   ";
         
            retList = new DataAccessObjectImpl().getFromDynamicQuery(query);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error StudentInfoComponent" + e);
        }
        return retList;
    }

    public List getBanksDetailsList() {
        List list = null;
        try {
            list = new DataAccessObjectImpl().getList("stud.getBanksDetailsList");
        }
        catch (Exception e) {
            System.err.println("Error in StudentInfoComponent.getBanksDetailsList :" + e);
        }
        return list;
    }

    public List getStudHoursSumReportList(String studId, String termNo) {
        List list = null;
        try {
            list = new DataAccessObjectImpl().getList("stud.getStudHoursSumReportList", new Object[]{studId, termNo});
        }
        catch (Exception e) {
            System.err.println("Error in StudentInfoComponent.getStudHoursSumReportList :" + e);
        }
        return list;
    }

    
    public List getStudHoursFeesToPay(String specNo) {
        List list = null;
        try {
            list = new DataAccessObjectImpl().getList("stud.getStudHoursFeesToPay", new Object[]{specNo});
        }
        catch (Exception e) {
            System.err.println("Error in StudentInfoComponent.getStudHoursFeesToPay :" + e);
        }
        return list;
    }
    
    public List getStudInstallmentReportList(String studId, String termNo) {
        List list = null;
        try {
            list = new DataAccessObjectImpl().getList("stud.getStudInstallmentReportList", new Object[]{studId, termNo});
        }
        catch (Exception e) {
            System.err.println("Error in StudentInfoComponent.getStudInstallmentReportList :" + e);
        }
        return list;
    }

    public List getStudFeesReportList(String studId, String termNo) {
        List list = null;
        try {
            list = new DataAccessObjectImpl().getList("stud.getStudFeesReportList", new Object[]{studId, termNo});
        }
        catch (Exception e) {
            System.err.println("Error in StudentInfoComponent.getStudFeesReportList :" + e);
        }
        return list;
    }

    public List getStudScholarshipReportList(String studId, String termNo) {
        List list = null;
        try {
            list = new DataAccessObjectImpl().getList("stud.getStudScholarshipReportList", new Object[]{studId, termNo});
        }
        catch (Exception e) {
            System.err.println("Error in StudentInfoComponent.getStudScholarshipReportList :" + e);
        }
        return list;
    }

    public String getFeesTotalSymbol(String termNo, String studId) throws ComponentException {
        int errorType = 0;
        String message = null;
        Session session = null;
        Transaction tx = null;
        String retValue = null;
        try {
            session = super.getSession();
            tx = session.beginTransaction();
            Connection con = session.connection();
            CallableStatement cs = con.prepareCall("{? = call PRTL_REGISTRATION.fees_total_symbol(?, ?)}");
            cs.registerOutParameter(1, 12);
            cs.setString(2, studId.trim());
            cs.setString(3, termNo.trim());
            cs.execute();
            retValue = cs.getString(1);
            tx.commit();
        }
        catch (Exception e) {
            errorType = 1;
            message = e.getMessage();
            return message;
        }
        finally {
            if (session != null) {
                try {
                    this.releaseSession(session);
                }
                catch (Exception e) {
                    System.err.println(" error in colse Session  in getFeesTotalSymbol.colseSession :" + e);
                    errorType = 5;
                    message = e.getMessage();
                }
            }
            if (errorType != 0 && message != null) {
                ComponentException componentException = new ComponentException(2, "StudentInfoComponent.getFeesTotalSymbol", message);
                System.err.println(componentException.toString());
                throw componentException;
            }
        }
        return retValue;
    }

    public String getFeesTotalInChar(String termNo, String studId) throws ComponentException {
        int errorType = 0;
        String message = null;
        Session session = null;
        Transaction tx = null;
        String retValue = null;
        try {
            session = super.getSession();
            tx = session.beginTransaction();
            Connection con = session.connection();
            CallableStatement cs = con.prepareCall("{? = call PRTL_REGISTRATION.fees_total_in_char(?, ?)}");
            cs.registerOutParameter(1, 12);
            cs.setString(2, studId.trim());
            cs.setString(3, termNo.trim());
            cs.execute();
            retValue = cs.getString(1);
            tx.commit();
        }
        catch (Exception e) {
            errorType = 1;
            message = e.getMessage();
            return message;
        }
        finally {
            if (session != null) {
                try {
                    this.releaseSession(session);
                }
                catch (Exception e) {
                    System.err.println(" error in colse Session  in getFeesTotalInChar.colseSession :" + e);
                    errorType = 5;
                    message = e.getMessage();
                }
            }
            if (errorType != 0 && message != null) {
                ComponentException componentException = new ComponentException(2, "StudentInfoComponent.getFeesTotalInChar", message);
                System.err.println(componentException.toString());
                throw componentException;
            }
        }
        return retValue;
    }

    public String isStudPaid(String studId) throws ComponentException {
        int errorType = 0;
        String message = null;
        Session session = null;
        Transaction tx = null;
        String retValue = null;
        try {
            session = super.getSession();
            tx = session.beginTransaction();
            Connection con = session.connection();
            CallableStatement cs = con.prepareCall("{? = call PRTL_REGISTRATION.is_stud_paid(?)}");
            cs.registerOutParameter(1, 12);
            cs.setString(2, studId.trim());
            cs.execute();
            retValue = cs.getString(1);
            tx.commit();
        }
        catch (Exception e) {
            errorType = 1;
            message = e.getMessage();
            return message;
        }
        finally {
            if (session != null) {
                try {
                    this.releaseSession(session);
                }
                catch (Exception e) {
                    System.err.println(" error in colse Session  in isStudPaid.colseSession :" + e);
                    errorType = 5;
                    message = e.getMessage();
                }
            }
            if (errorType != 0 && message != null) {
                ComponentException componentException = new ComponentException(2, "StudentInfoComponent.isStudPaid", message);
                System.err.println(componentException.toString());
                throw componentException;
            }
        }
        return retValue;
    }

    public List getStudentFinancialTermsDebt(Object[] parameters) throws ComponentException {
        List termList = null;
        try {
            termList = super.getList("Portal.getSasStudBalanceTemp2", parameters);
        }
        catch (Exception e) {
            System.out.println("Error in getStudentFinancialTermsDebt y101 " + e);
        }
        return termList;
    }

    
    
    
    public List getStudentFeesToPay(Object[] parameters) throws ComponentException {
        List termList = null;
        try {
            termList = super.getList("Portal.getStudentFeesToPay", parameters);
        }
        catch (Exception e) {
            System.out.println("Error in getStudentFeesToPay y101 " + e);
        }
        return termList;
    }
    
    
    public List getStudentFinancialTermsLoan(Object[] parameters) throws ComponentException {
        List termList = null;
        try {
            termList = super.getList("Portal.getSasStudLoan", parameters);
        }
        catch (Exception e) {
            System.out.println("Error in ShowTermSummryComponent " + e);
        }
        return termList;
    }

    public void saveSrvyPayer(String[] payer, String studId, String termNo) {
        try {
            super.updateSqlQuery(" delete FROM srvy_tuition \n where\n    stud_id='" + studId + "'\n" + "    and term_no='" + termNo + "'");
            ArrayList<SrvyTuition> inptDataList = new ArrayList<SrvyTuition>();
            for (int i = 0; payer != null && i < payer.length; ++i) {
                inptDataList.add(new SrvyTuition(new SrvyTuitionPK(studId, termNo, payer[i])));
            }
            new DataAccessObjectImpl().insert(inptDataList);
        }
        catch (Exception e) {
            System.err.println("Error in StudentInfoComponent.saveSrvyPayer:" + e);
        }
    }

    public String[] getPayer(String studId, String termNo) throws ComponentException {
        String[] payer = null;
        try {
            List resultList = super.getList("Portal.getPayer", new Object[]{studId, termNo});
            if (resultList != null && resultList.size() > 0) {
                Iterator itr = resultList.iterator();
                SrvyTuition obj = null;
                payer = new String[resultList.size()];
                int i = 0;
                while (itr.hasNext()) {
                    obj = (SrvyTuition)itr.next();
                    payer[i] = obj.getComp_id().getTutPayer();
                    ++i;
                }
            }
        }
        catch (Exception e) {
            System.out.println("Error in getPayer " + e);
        }
        return payer;
    }

    public void saveStudSocialHealthDetail(SrvyHealthDetail obj, FormFile medicalReport) throws ComponentException {
        Session session = null;
        Transaction tx = null;
        try {
            session = this.getSession();
            tx = session.beginTransaction();
            if (medicalReport != null && medicalReport.getFileSize() > 0) {
                obj.setMedicalReport(Hibernate.createBlob((byte[])new byte[]{0}));
                obj.setMedicalReportType(medicalReport.getContentType());
            }
            session.saveOrUpdate((Object)obj);
            if (medicalReport != null && medicalReport.getFileSize() > 0) {
                session.flush();
                session.refresh((Object)obj, LockMode.UPGRADE);
                SerializableBlob blob = (SerializableBlob)obj.getMedicalReport();
                Blob wrapBlob = blob.getWrappedBlob();
                BLOB bb = (BLOB)wrapBlob;
                OutputStream pw = bb.setBinaryStream(0);
                try {
                    pw.write(medicalReport.getFileData());
                    pw.close();
                }
                catch (IOException e) {
                    System.err.println("Error in StudentInfoComponent.saveStudSocialHealthDetail :" + e);
                    e.printStackTrace();
                }
            }
            tx.commit();
        }
        catch (Exception e) {
            System.err.println("Error in StudentInfoComponent.saveStudSocialHealthDetail:" + e);
            throw new ComponentException(e.getMessage());
        }
        finally {
            if (session != null) {
                try {
                    this.releaseSession(session);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}