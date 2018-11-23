 package ps.edu.diyar.common.component;

        import java.io.Serializable;
        import java.sql.SQLException;
        import java.util.ArrayList;
        import java.util.Collection;
        import java.util.List;
        import org.apache.log4j.Logger;
        import org.hibernate.HibernateException;
        import org.hibernate.Query;
import org.hibernate.SQLQuery;
        import org.hibernate.Session;
        import org.hibernate.Transaction;
        import ps.edu.diyar.common.component.DataAccessObject;
        import ps.edu.diyar.common.component.DgfComponentH3;
        import ps.edu.diyar.common.exceptions.ComponentException;
import ps.edu.diyar.studentInfo.database.RegStud;

public class DataAccessObjectImpl
        extends DgfComponentH3
        implements DataAccessObject {
    private static Logger logger = Logger.getLogger((Class)DataAccessObjectImpl.class);


    public Object insert(Object valueObject) throws ComponentException {
        Session session = null;
        int errorType = 0;
        String message = null;
        ArrayList<Serializable> retList = new ArrayList<Serializable>();
        Serializable pkObject = null;
        try {
            session = this.getSession();
            pkObject = session.save(valueObject);
            retList.add(pkObject);
        }
        catch (HibernateException hbe) {
            errorType = 3;
            message = hbe.getMessage();
            return message;
        }
        catch (SQLException sqle) {
            errorType = 2;
            message = sqle.getMessage();
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
                    errorType = 5;
                    message = e.getMessage();
                }
            }
            if (errorType != 0 && message != null) {
                ComponentException componentException = new ComponentException(2, "DataAccessObjectImpl.insert", message);
                if (logger.isDebugEnabled()) {
                    logger.error((Object)componentException.toString());
                }
                throw componentException;
            }
        }
        return pkObject;
    }


    public void insertOrUpdate(Object valueObject) throws ComponentException {
        Session session = null;
        int errorType = 0;
        String message = null;
        try {
            session = this.getSession();
            session.saveOrUpdate(valueObject);
        }
        catch (HibernateException hbe) {
            errorType = 3;
            message = hbe.getMessage();
        }
        catch (SQLException sqle) {
            errorType = 2;
            message = sqle.getMessage();
        }
        catch (Exception e) {
            errorType = 1;
            message = e.getMessage();
        }
        finally {
            if (session != null) {
                try {
                    this.releaseSession(session);
                }
                catch (Exception e) {
                    errorType = 5;
                    message = e.getMessage();
                }
            }
            if (errorType != 0 && message != null) {
                ComponentException componentException = new ComponentException(2, "DataAccessObjectImpl.insertOrUpdate", message);
                if (logger.isDebugEnabled()) {
                    logger.error((Object)componentException.toString());
                }
                throw componentException;
            }
        }
    }

    public void insertOrUpdate(Collection data) throws ComponentException {
        Session session = null;
        int errorType = 0;
        String message = null;
        try {
            session = this.getSession();
            for (Object obj : data) {
                session.saveOrUpdate(obj);
            }
        }
        catch (HibernateException hbe) {
            errorType = 3;
            message = hbe.getMessage();
        }
        catch (SQLException sqle) {
            errorType = 2;
            message = sqle.getMessage();
        }
        catch (Exception e) {
            errorType = 1;
            message = e.getMessage();
        }
        finally {
            if (session != null) {
                try {
                    this.releaseSession(session);
                }
                catch (Exception e) {
                    errorType = 5;
                    message = e.getMessage();
                }
            }
            if (errorType != 0 && message != null) {
                ComponentException componentException = new ComponentException(2, "DataAccessObjectImpl.insertOrUpdate", message);
                if (logger.isDebugEnabled()) {
                    logger.error((Object)componentException.toString());
                }
                throw componentException;
            }
        }
    }

    public void insert(Collection data) throws ComponentException {
        Session session = null;
        int errorType = 0;
        String message = null;
        try {
            session = this.getSession();
            for (Object obj : data) {
                session.save(obj);
            }
        }
        catch (HibernateException hbe) {
            errorType = 3;
            message = hbe.getMessage();
        }
        catch (SQLException sqle) {
            errorType = 2;
            message = sqle.getMessage();
        }
        catch (Exception e) {
            errorType = 1;
            message = e.getMessage();
        }
        finally {
            if (session != null) {
                try {
                    this.releaseSession(session);
                }
                catch (Exception e) {
                    errorType = 5;
                    message = e.getMessage();
                }
            }
            if (errorType != 0 && message != null) {
                ComponentException componentException = new ComponentException(2, "DataAccessObjectImpl.insert", message);
                if (logger.isDebugEnabled()) {
                    logger.error((Object)componentException.toString());
                }
                throw componentException;
            }
        }
    }


    public void delete(Object valueObject) throws ComponentException {
        Session session = null;
        int errorType = 0;
        String message = null;
        try {
            session = this.getSession();
            session.delete(valueObject);
        }
        catch (HibernateException hbe) {
            errorType = 3;
            message = hbe.getMessage();
        }
        catch (SQLException sqle) {
            errorType = 2;
            message = sqle.getMessage();
        }
        catch (Exception e) {
            errorType = 1;
            message = e.getMessage();
        }
        finally {
            if (session != null) {
                try {
                    this.releaseSession(session);
                }
                catch (Exception e) {
                    errorType = 5;
                    message = e.getMessage();
                }
            }
            if (errorType != 0 && message != null) {
                ComponentException componentException = new ComponentException(2, "DataAccessObjectImpl.delete", message);
                if (logger.isDebugEnabled()) {
                    logger.error((Object)componentException.toString());
                }
                throw componentException;
            }
        }
    }

    public int deleteByHqlQuery(String query, Object[] params)
            throws ComponentException
    {
        Session session = null;
        int errorType = 0;
        String message = null;

        int updatedEntities = 0;
        try
        {
            session = getSession();
            Query q = session.createQuery(query);
            for (int i = 0; i < params.length; i++) {
                q.setParameter(i, params[i]);
            }
            updatedEntities = q.executeUpdate();
        }
        catch (HibernateException hbe)
        {
            ComponentException componentException;
            errorType = 3;message = hbe.getMessage();
        }
        catch (SQLException sqle)
        {
            ComponentException componentException;
            errorType = 2;message = sqle.getMessage();
        }
        catch (Exception e)
        {
            ComponentException componentException;
            errorType = 1;message = e.getMessage();
        }
        finally
        {
            ComponentException componentException;
            if (session != null) {
                try
                {
                    releaseSession(session);
                }
                catch (Exception e)
                {
                    errorType = 5;message = e.getMessage();
                }
            }
            if ((errorType != 0) && (message != null))
            {
                  componentException = new ComponentException(2, "DataAccessObjectImpl.deleteByHqlQuery", message);
                if (logger.isDebugEnabled()) {
                    logger.error(componentException.toString());
                }
                throw componentException;
            }
        }
        return updatedEntities;
    }


    public void update(Object valueObject) throws ComponentException {
        Session session = null;
        int errorType = 0;
        String message = null;
        try {
            session = this.getSession();
            session.update(valueObject);
        }
        catch (HibernateException hbe) {
            errorType = 3;
            message = hbe.getMessage();
        }
        catch (SQLException sqle) {
            errorType = 2;
            message = sqle.getMessage();
        }
        catch (Exception e) {
            errorType = 1;
            message = e.getMessage();
        }
        finally {
            if (session != null) {
                try {
                    this.releaseSession(session);
                }
                catch (Exception e) {
                    errorType = 5;
                    message = e.getMessage();
                }
            }
            if (errorType != 0 && message != null) {
                ComponentException componentException = new ComponentException(2, "DataAccessObjectImpl.update", message);
                if (logger.isDebugEnabled()) {
                    logger.error((Object)componentException.toString());
                }
                throw componentException;
            }
        }
    }

    public Collection getFromDynamicQuery(String query)
            throws ComponentException
    {
        Session session = null;
        int errorType = 0;
        String message = null;
       // String yQuery ="select crs_no from  reg_stud ";
        try
        {
            session = getSession();
             Query q = session.createQuery(query);
                
         // Query q = session.createQuery(yQuery);
       //  q.addEntity(RegStud.class);
        // List<RegStud> rs = q.list();
            ComponentException componentException;
          //  return rs;
            return q.list();
        }
        catch (HibernateException hbe)
        {
            errorType = 3;message = hbe.getMessage();
        }
        catch (SQLException sqle)
        {
            ComponentException componentException;
            errorType = 2;message = sqle.getMessage();
        }
        catch (Exception e)
        {
            ComponentException componentException;
            errorType = 1;message = e.getMessage();
        }
        finally
        {
            ComponentException componentException;
            if (session != null) {
                try
                {
                    releaseSession(session);
                }
                catch (Exception e)
                {
                    errorType = 5;message = e.getMessage();
                }
            }
            if (errorType != 0 && message != null) {
                 componentException = new ComponentException(2, "DataAccessObjectImpl.getFromDynamicQuery", message);
                if (logger.isDebugEnabled()) {
                    logger.error((Object)componentException.toString());
                }
                throw componentException;
            }
        }
        return null;
    }




    public Collection getFromDynamicQuery(String query, int firstResult, int maxResult)
            throws ComponentException
    {
        Session session = null;
        int errorType = 0;
        String message = null;
        try
        {
            session = getSession();
            Query q = session.createQuery(query);
            q.setFirstResult(firstResult);
            q.setMaxResults(maxResult);
            ComponentException componentException;
            return q.list();
        }
        catch (HibernateException hbe)
        {
            errorType = 3;message = hbe.getMessage();
        }
        catch (SQLException sqle)
        {
            ComponentException componentException;
            errorType = 2;message = sqle.getMessage();
        }
        catch (Exception e)
        {
            ComponentException componentException;
            errorType = 1;message = e.getMessage();
        }
        finally
        {
            ComponentException componentException;
            if (session != null) {
                try
                {
                    releaseSession(session);
                }
                catch (Exception e)
                {
                    errorType = 5;message = e.getMessage();
                }
            }
            if ((errorType != 0) && (message != null))
            {
                  componentException = new ComponentException(2, "DataAccessObjectImpl.getFromDynamicQuery(q,f,m)", message);
                if (logger.isDebugEnabled()) {
                    logger.error(componentException.toString());
                }
                throw componentException;
            }
        }
        return null;
    }

    public Collection getFromDynamicQuery(String query, Object[] queryParams, int firstResult, int maxResult)
            throws ComponentException
    {
        Session session = null;
        int errorType = 0;
        String message = null;
        try
        {
            session = getSession();
            Query q = session.createQuery(query);
            for (int j = 0; (queryParams != null) && (j < queryParams.length); j++) {
                q.setParameter(j, queryParams[j]);
            }
            q.setFirstResult(firstResult);
            q.setMaxResults(maxResult);
            ComponentException componentException;
            return q.list();
        }
        catch (HibernateException hbe)
        {
            errorType = 3;message = hbe.getMessage();
        }
        catch (SQLException sqle)
        {
            ComponentException componentException;
            errorType = 2;message = sqle.getMessage();
        }
        catch (Exception e)
        {
            ComponentException componentException;
            errorType = 1;message = e.getMessage();
        }
        finally
        {
            ComponentException componentException;
            if (session != null) {
                try
                {
                    releaseSession(session);
                }
                catch (Exception e)
                {
                    errorType = 5;message = e.getMessage();
                }
            }
            if ((errorType != 0) && (message != null))
            {
                  componentException = new ComponentException(2, "DataAccessObjectImpl.getFromDynamicQuery(q,f,m)", message);
                if (logger.isDebugEnabled()) {
                    logger.error(componentException.toString());
                }
                throw componentException;
            }
        }
        return null;
    }

    public Collection getFromDynamicQuery(String query, Object[] queryParams)
            throws ComponentException
    {
        Session session = null;
        int errorType = 0;
        String message = null;
        try
        {
            session = getSession();
            Query q = session.createQuery(query);
            for (int j = 0; (queryParams != null) && (j < queryParams.length); j++) {
                q.setParameter(j, queryParams[j]);
            }
            ComponentException componentException;
            return q.list();
        }
        catch (HibernateException hbe)
        {
            errorType = 3;message = hbe.getMessage();
        }
        catch (SQLException sqle)
        {
            ComponentException componentException;
            errorType = 2;message = sqle.getMessage();
        }
        catch (Exception e)
        {
            ComponentException componentException;
            errorType = 1;message = e.getMessage();
        }
        finally
        {
            ComponentException componentException;
            if (session != null) {
                try
                {
                    releaseSession(session);
                }
                catch (Exception e)
                {
                    errorType = 5;message = e.getMessage();
                }
            }
            if ((errorType != 0) && (message != null))
            {
                  componentException = new ComponentException(2, "DataAccessObjectImpl.getFromDynamicQuery(q,f,m)", message);
                if (logger.isDebugEnabled()) {
                    logger.error(componentException.toString());
                }
                throw componentException;
            }
        }
        return null;
    }

    public Object load(Object object, Object objectKey) throws ComponentException {
        int errorType = 0;
        String message = null;
        Object retObject = null;
        Session session = null;
        try {
            session = this.getSession();
            retObject = session.load(object.getClass(), (Serializable)objectKey);
        }
        catch (HibernateException hbe) {
            errorType = 3;
            message = hbe.getMessage();
            return message;
        }
        catch (SQLException sqle) {
            errorType = 2;
            message = sqle.getMessage();
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
                    errorType = 5;
                    message = e.getMessage();
                }
            }
            if (errorType != 0 && message != null) {
                ComponentException componentException = new ComponentException(2, "DataAccessObjectImpl.load", message);
                if (logger.isDebugEnabled()) {
                    logger.error((Object)componentException.toString());
                }
                throw componentException;
            }
        }
        return retObject;
    }

    public List getList(String namedQuery)
            throws ComponentException
    {
        int errorType = 0;
        String message = null;

        List objList = null;
        Session session = null;
        try
        {
            session = getSession();
            Query q = session.getNamedQuery(namedQuery);
            objList = q.list();
        }
        catch (HibernateException hbe)
        {
            ComponentException componentException;
            errorType = 3;message = hbe.getMessage();
        }
        catch (SQLException sqle)
        {
            ComponentException componentException;
            errorType = 2;message = sqle.getMessage();
        }
        catch (Exception e)
        {
            ComponentException componentException;
            errorType = 1;message = e.getMessage();
        }
        finally
        {
            ComponentException componentException;
            if (session != null) {
                try
                {
                    releaseSession(session);
                }
                catch (Exception e)
                {
                    errorType = 5;message = e.getMessage();
                }
            }
            if ((errorType != 0) && (message != null))
            {
                 componentException = new ComponentException(2, "DataAccessObjectImpl.getList", message);
                if (logger.isDebugEnabled()) {
                    logger.error(componentException.toString());
                }
                throw componentException;
            }
        }
        return objList;
    }


    public Integer executeHqlQuery(String namedQuery, Object[] queryParams)
            throws ComponentException
    {
        Session session = null;
        int errorType = 0;
        String message = null;
        Integer rowNum = null;
        Transaction tx = null;
        StringBuffer thisString = new StringBuffer(100);
        for (int i = 0; i < queryParams.length; i++)
        {
            String strParam = queryParams[i].toString();
            thisString.append("," + strParam);
        }
        try
        {
            session = getSession();
            Query query = session.getNamedQuery(namedQuery);
            for (int j = 0; j < queryParams.length; j++) {
                query.setParameter(j, queryParams[j]);
            }
            tx = session.beginTransaction();
            rowNum = Integer.valueOf(query.executeUpdate());
            tx.commit();
        }
        catch (HibernateException hbe)
        {
            ComponentException componentException;
            if (tx != null) {
                tx.rollback();
            }
            errorType = 3;message = hbe.getMessage();
        }
        catch (SQLException sqle)
        {
            ComponentException componentException;
            if (tx != null) {
                tx.rollback();
            }
            errorType = 2;message = sqle.getMessage();
        }
        catch (Exception e)
        {
            ComponentException componentException;
            if (tx != null) {
                tx.rollback();
            }
            errorType = 1;message = e.getMessage();
        }
        finally
        {
            ComponentException componentException;
            if (session != null) {
                try
                {
                    releaseSession(session);
                }
                catch (Exception e)
                {
                    errorType = 5;message = e.getMessage();
                }
            }
            if ((errorType != 0) && (message != null))
            {
                  componentException = new ComponentException(2, "DataAccessObjectImpl.executeQuery", message);
                if (logger.isDebugEnabled()) {
                    logger.error(componentException.toString());
                }
                throw componentException;
            }
        }
        return rowNum;
    }
}

