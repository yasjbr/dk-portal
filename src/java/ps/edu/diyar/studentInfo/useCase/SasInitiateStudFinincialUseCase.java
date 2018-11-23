package ps.edu.diyar.studentInfo.useCase;

import java.io.PrintStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ps.edu.diyar.common.component.DataAccessObjectImpl;
import ps.edu.diyar.common.exceptions.ApplicationException;
import ps.edu.diyar.common.exceptions.ComponentException;
import ps.edu.diyar.common.useCase.ComponentUseCase;
import ps.edu.diyar.login.database.PrtlSecUser;
import ps.edu.diyar.studentInfo.database.PrtlStudFtermCardDtl;
import ps.edu.diyar.studentInfo.database.PrtlStudFtermCardDtlPK;

public class SasInitiateStudFinincialUseCase
        implements ComponentUseCase {

    public Collection execute(Collection input, HttpServletRequest request) throws HibernateException {
        List retList = null;
        try {
            retList = this.initiateStudFinancial(input);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in the initiate Stud Financial use case" + e);
        }
        return retList;
    }

    private List initiateStudFinancial(Collection input) throws ComponentException {
        ArrayList<ApplicationException> retList = null;
        Session session = null;
        DataAccessObjectImpl dataAccessObjectImpl = null;
        Transaction tx = null;
        try {
            dataAccessObjectImpl = new DataAccessObjectImpl();
            session = dataAccessObjectImpl.getSession();
            tx = session.beginTransaction();

            Iterator iterator = input.iterator();

            String studId = (String) iterator.next();
            String termNo = (String) iterator.next();
            String finCode = (String) iterator.next();
             String feesToPay = (String) iterator.next();

            PrtlStudFtermCardDtlPK pk = new PrtlStudFtermCardDtlPK(studId, termNo, finCode);

            //PrtlStudFtermCardDtl prtlStudFtermCardDtl = (PrtlStudFtermCardDtl) session.load((Class) PrtlStudFtermCardDtl.class, (Serializable) pk);
            
              PrtlStudFtermCardDtl prtlStudFtermCardDtl = new PrtlStudFtermCardDtl();

            prtlStudFtermCardDtl.setComp_id(pk);
            prtlStudFtermCardDtl.setCounter(Double.parseDouble("32"));

            prtlStudFtermCardDtl.setSmDbAmt(Double.parseDouble("0"));
            prtlStudFtermCardDtl.setCrncyCode(Double.parseDouble("2"));
            prtlStudFtermCardDtl.setSmDbBaseAmt(Double.parseDouble("0"));
            prtlStudFtermCardDtl.setCrncyRate(Double.parseDouble("1"));
            prtlStudFtermCardDtl.setUserId(studId);
            prtlStudFtermCardDtl.setTimeStamp(new Date());
            prtlStudFtermCardDtl.setNotes("inserted from the portal to initiate the registraion");
            prtlStudFtermCardDtl.setFeesToPay( Double.parseDouble(feesToPay));
            
            session.save(prtlStudFtermCardDtl);
          //  dataAccessObjectImpl.insert((Object) prtlStudFtermCardDtl);
            tx.commit();
        } catch (Exception he) {
            System.err.println("Error in SasInitiateStudFinincialUseCase.initiateStudFinancial:" + he);
        } finally {
            if (session != null) {
                try {
                    dataAccessObjectImpl.releaseSession(session);
                } catch (Exception e) {
                    System.err.println("Error in colse session");
                }
            }
        }
        return retList;
    }
}
