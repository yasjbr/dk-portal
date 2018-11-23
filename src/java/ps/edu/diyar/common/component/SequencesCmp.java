/*
 * Decompiled with CFR 0_102.
 * 
 * Could not load the following classes:
 *  org.hibernate.HibernateException
 *  org.hibernate.Session
 *  org.hibernate.Transaction
 *  ps.edu.diyar.common.component.DgfComponentH3
 *  ps.edu.diyar.common.exceptions.ComponentException
 */
package ps.edu.diyar.common.component;

import java.io.PrintStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ps.edu.diyar.common.component.DgfComponentH3;
import ps.edu.diyar.common.exceptions.ComponentException;

public class SequencesCmp
        extends DgfComponentH3 {
    public String getNextValue(String seqName) throws ComponentException {
        int errorType = 0;
        String message = null;
        Session session = null;
        Transaction tx = null;
        String retValue = null;
        try {
            session = this.getSession();
            tx = session.beginTransaction();
            Connection con = session.connection();
            CallableStatement cs = con.prepareCall("{? = call GET_NEXT_VAL (?)}");
            cs.registerOutParameter(1, 12);
            cs.setString(2, seqName.trim());
            cs.execute();
            retValue = cs.getString(1);
            tx.commit();
        }
        catch (SQLException sqle) {
            errorType = 2;
            message = sqle.getMessage();
            return message;
        }
        catch (HibernateException hbe) {
            errorType = 3;
            message = hbe.getMessage();
            return message;
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
                    System.err.println(" error in colse Session  in CallProcedureOrFunction.colseSession :" + e);
                    errorType = 5;
                    message = e.getMessage();
                }
            }
            if (errorType != 0 && message != null) {
                ComponentException componentException = new ComponentException(2, "CallProcedureOrFunction.callProcedure", message);
                System.err.println(componentException.toString());
                throw componentException;
            }
        }
        return retValue;
    }
}