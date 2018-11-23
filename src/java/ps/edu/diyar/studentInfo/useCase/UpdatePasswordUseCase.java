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

public class UpdatePasswordUseCase
        implements ComponentUseCase {
    public Collection execute(Collection input, HttpServletRequest request) throws HibernateException {
        List retList = null;
        try {
            retList = this.updateUserPassword(input);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in the update password use case" + e);
        }
        return retList;
    }

    private List updateUserPassword(Collection input) throws ComponentException {
        ArrayList<ApplicationException> retList = null;
        Session session = null;
        DataAccessObjectImpl dataAccessObjectImpl = null;
        Transaction tx = null;
        try {
            dataAccessObjectImpl = new DataAccessObjectImpl();
            session = dataAccessObjectImpl.getSession();
            tx = session.beginTransaction();
            Iterator iterator = input.iterator();
            String userId = (String)iterator.next();
            String smsReg = (String)iterator.next();
            String oldPassword = (String)iterator.next();
            String newPassword = (String)iterator.next();
            String email = (String)iterator.next();
            String mobile = (String)iterator.next();
            String pwdSource = (String)iterator.next();
            PrtlSecUser prtlSecUser = (PrtlSecUser)session.load((Class)PrtlSecUser.class, (Serializable)userId);
            if (!(oldPassword == null || oldPassword.equals("") || newPassword == null || newPassword.equals(""))) {
                String dbPassword = prtlSecUser.getUserPwd();
                if (!dbPassword.equals(oldPassword)) {
                    retList = new ArrayList<ApplicationException>();
                    retList.add(new ApplicationException("Password mismatch"));
                } else {
                    prtlSecUser.setUserPwd(newPassword);
                }
            }
            prtlSecUser.setEmail(email);
            prtlSecUser.setMobile(mobile);
            prtlSecUser.setSmsReg(smsReg);
            prtlSecUser.setPwdSource(pwdSource);
            prtlSecUser.setPwdLastChange(new Date());
            dataAccessObjectImpl.update((Object)prtlSecUser);
            tx.commit();
        }
        catch (Exception he) {
            System.err.println("Error in UpdatePasswordUseCase.updateUserPassword:" + he);
        }
        finally {
            if (session != null) {
                try {
                    dataAccessObjectImpl.releaseSession(session);
                }
                catch (Exception e) {
                    System.err.println("Error in colse session");
                }
            }
        }
        return retList;
    }
}