package ps.edu.diyar.common.component;

import java.io.InputStream;
import java.io.PrintStream;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import org.hibernate.EmptyInterceptor;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.persister.entity.AbstractEntityPersister;
import ps.edu.diyar.common.exceptions.ComponentException;
import ps.edu.diyar.common.utils.Count;

public class DgfComponentH3
{
  private static SessionFactory sf;
  private static final String PROPERTIES_FILE_NAME = "/app.properties";
  private static Properties dgfProperties;
  
  static
  {
    try
    {
      dgfProperties = new Properties();
      
      Class thisClass = Class.forName("ps.edu.diyar.common.component.DgfComponentH3");
      InputStream is = thisClass.getResourceAsStream("/app.properties");
      dgfProperties.load(is);
      
      Configuration cfg = new Configuration();
      

      Enumeration enumer = dgfProperties.keys();
      while (enumer.hasMoreElements())
      {
        String mappingFile = dgfProperties.getProperty(enumer.nextElement().toString());
        
        InputStream mappingIs = thisClass.getResourceAsStream(mappingFile);
        try
        {
          cfg.addInputStream(mappingIs);
          System.out.println("cfg added to the system ");
        }
        catch (MappingException mpe)
        {
          String errKey = "DgfComponent.CannotMapXMLFile.err";
          Object[] params = { mappingFile };
          mpe.printStackTrace();
        }
      }
      sf = cfg.buildSessionFactory();
    }
    catch (Exception e)
    {
      e.printStackTrace();
      String errKey = "DgfComponent.UnexpectedError.err";
      System.err.println("Error in build session factory :" + e);
    }
  }
  
  public static String getProperty(String propertyKey)
  {
    return dgfProperties.getProperty(propertyKey);
  }
  
  public static void setProperty(String propertyKey, String propertyValue)
  {
    dgfProperties.setProperty(propertyKey, propertyValue);
  }
  
  public Session getSession()
    throws SQLException, HibernateException
  {
    Session session = null;
    synchronized (sf)
    {
      session = sf.openSession();
    }
    return session;
  }
  
  public void releaseSession(Session session)
    throws SQLException, HibernateException
  {
    try
    {
      session.flush();
      session.connection().commit();
    }
    finally
    {
      session.close();
    }
  }
  
  public List getList(String namedQuery)
    throws ComponentException
  {
    List objList = null;
    Session session = null;
    int errorType = 0;
    String message = null;
    try
    {
      session = getSession();
      Query q = session.getNamedQuery(namedQuery);
      objList = q.list();
    }
    catch (SQLException sqle)
    {
      ComponentException componentException;
      errorType = 2;message = sqle.getMessage();
    }
    catch (HibernateException hbe)
    {
      ComponentException componentException;
      errorType = 3;message = hbe.getMessage();
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
         componentException = new ComponentException(2, "DgfComponentH3.getList", message);
        System.err.println(componentException.toString());
        throw componentException;
      }
    }
    return objList;
  }
  
  public List getList(String namedQuery, Object[] queryParams)
    throws ComponentException
  {
    List objList = null;
    StringBuffer thisString = new StringBuffer(100);
    int errorType = 0;
    String message = null;
    for (int i = 0; i < queryParams.length; i++)
    {
      String strParam = queryParams[i].toString();
      thisString.append("," + strParam);
    }
    String query = namedQuery + thisString.toString();
    Session session = null;
    try
    {
      session = getSession();
      Query q = session.getNamedQuery(namedQuery);
      for (int j = 0; j < queryParams.length; j++) {
        q.setParameter(j, queryParams[j]);
      }
      objList = q.list();
    }
    catch (SQLException sqle)
    {
      ComponentException componentException;
      errorType = 2;message = sqle.getMessage();
    }
    catch (HibernateException hbe)
    {
      ComponentException componentException;
      errorType = 3;message = hbe.getMessage();
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
         componentException = new ComponentException(2, "DgfComponentH3.getList", message);
        System.err.println(componentException.toString());
        throw componentException;
      }
    }
    return objList;
  }
  
  public List getList(String namedQuery, int maxCount, Object[] queryParams)
    throws ComponentException
  {
    List objList = null;
    Integer intMaxCount = new Integer(maxCount);
    StringBuffer thisString = new StringBuffer(100);
    int errorType = 0;
    String message = null;
    for (int i = 0; i < queryParams.length; i++)
    {
      String strParam = queryParams[i].toString();
      thisString.append("," + strParam);
    }
    String queryString = namedQuery + thisString.toString();
    String query = queryString + "," + maxCount;
    
    Session session = null;
    try
    {
      session = getSession();
      Query q = session.getNamedQuery(namedQuery);
      for (int j = 0; j < queryParams.length; j++) {
        q.setParameter(j, queryParams[j]);
      }
      q.setMaxResults(maxCount);
      
      objList = q.list();
    }
    catch (SQLException sqle)
    {
      ComponentException componentException;
      errorType = 2;message = sqle.getMessage();
    }
    catch (HibernateException hbe)
    {
      ComponentException componentException;
      errorType = 3;message = hbe.getMessage();
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
         componentException = new ComponentException(2, "DgfComponentH3.getList", message);
        System.err.println(componentException.toString());
        throw componentException;
      }
    }
    return objList;
  }
  
  public List getList(String namedQuery, int firstRow, int maxCount, Object[] queryParams)
    throws ComponentException
  {
    List objList = null;
    Integer intFirstRow = new Integer(firstRow);
    Integer intMaxCount = new Integer(maxCount);
    StringBuffer thisString = new StringBuffer(100);
    int errorType = 0;
    String message = null;
    for (int i = 0; i < queryParams.length; i++)
    {
      String strParam = queryParams[i].toString();
      thisString.append("," + strParam);
    }
    String queryString = namedQuery + thisString.toString();
    String query = queryString + "," + maxCount;
    
    Session session = null;
    try
    {
      session = getSession();
      Query q = session.getNamedQuery(namedQuery);
      for (int j = 0; j < queryParams.length; j++) {
        q.setParameter(j, queryParams[j]);
      }
      q.setFirstResult(firstRow);
      q.setMaxResults(10);
      
      objList = q.list();
    }
    catch (SQLException sqle)
    {
      ComponentException componentException;
      errorType = 2;message = sqle.getMessage();
    }
    catch (HibernateException hbe)
    {
      ComponentException componentException;
      errorType = 3;message = hbe.getMessage();
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
         componentException = new ComponentException(2, "DgfComponentH3.getList", message);
        System.err.println(componentException.toString());
        throw componentException;
      }
    }
    return objList;
  }
  
  public List getList(String query, int firstRow, int maxCount)
    throws ComponentException
  {
    List objList = null;
    Integer intFirstRow = new Integer(firstRow);
    Integer intMaxCount = new Integer(maxCount);
    int errorType = 0;
    String message = null;
    
    Session session = null;
    try
    {
      session = getSession();
      Query q = session.createQuery(query);
      
      q.setFirstResult(firstRow);
      q.setMaxResults(10);
      
      objList = q.list();
    }
    catch (SQLException sqle)
    {
      ComponentException componentException;
      errorType = 2;message = sqle.getMessage();
    }
    catch (HibernateException hbe)
    {
      ComponentException componentException;
      errorType = 3;message = hbe.getMessage();
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
         componentException = new ComponentException(2, "DgfComponentH3.getList", message);
        System.err.println(componentException.toString());
        throw componentException;
      }
    }
    return objList;
  }
  
  public List getFilteredList(String namedQuery, int firstRow, int maxCount, Object[] queryParams)
    throws ComponentException
  {
    List objList = null;
    Integer intFirstRow = new Integer(firstRow);
    Integer intMaxCount = new Integer(maxCount);
    StringBuffer thisString = new StringBuffer(100);
    int errorType = 0;
    String message = null;
    for (int i = 0; i < queryParams.length; i++)
    {
      String strParam = queryParams[i].toString();
      thisString.append("," + strParam);
    }
    String queryString = namedQuery + thisString.toString();
    String query = queryString + "," + maxCount;
    
    Session session = null;
    try
    {
      session = getSession();
      Query q = session.getNamedQuery(namedQuery);
      for (int j = 0; j < queryParams.length; j++) {
        q.setParameter(j, queryParams[j]);
      }
      q.setFirstResult(firstRow);
      q.setMaxResults(maxCount);
      
      objList = q.list();
    }
    catch (SQLException sqle)
    {
      ComponentException componentException;
      errorType = 2;message = sqle.getMessage();
    }
    catch (HibernateException hbe)
    {
      ComponentException componentException;
      errorType = 3;message = hbe.getMessage();
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
         componentException = new ComponentException(2, "DgfComponentH3.getFilteredList", message);
        System.err.println(componentException.toString());
        throw componentException;
      }
    }
    return objList;
  }
  
  public Count getCount(String namedQuery)
    throws ComponentException
  {
    Count cnt = null;
    
    Session session = null;
    int errorType = 0;
    String message = null;
    try
    {
      session = getSession();
      Query q = session.getNamedQuery(namedQuery);
      Iterator results = q.iterate();
      if (results.hasNext())
      {
        Long count = (Long)results.next();
        cnt = new Count();
        cnt.setCount(count.longValue());
        ComponentException componentException;
        return cnt;
      }
    }
    catch (SQLException sqle)
    {
      ComponentException componentException;
      errorType = 2;message = sqle.getMessage();
    }
    catch (HibernateException hbe)
    {
      ComponentException componentException;
      errorType = 3;message = hbe.getMessage();
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
         componentException = new ComponentException(2, "DgfComponentH3.getCount", message);
        System.err.println(componentException.toString());
        throw componentException;
      }
    }
    return cnt;
  }
  
  public Count getCount(String namedQuery, Object[] queryParams)
    throws ComponentException
  {
    Count cnt = null;
    StringBuffer thisString = new StringBuffer(100);
    int errorType = 0;
    String message = null;
    for (int i = 0; i < queryParams.length; i++)
    {
      String strParam = queryParams[i].toString();
      thisString.append("," + strParam);
    }
    String query = namedQuery + thisString.toString();
    
    Session session = null;
    try
    {
      session = getSession();
      Query q = session.getNamedQuery(namedQuery);
      for (int j = 0; j < queryParams.length; j++) {
        q.setParameter(j, queryParams[j]);
      }
      Iterator results = q.iterate();
      if (results.hasNext())
      {
        Long count = (Long)results.next();
        cnt = new Count();
        cnt.setCount(count.intValue());
        ComponentException componentException;
        return cnt;
      }
    }
    catch (SQLException sqle)
    {
      ComponentException componentException;
      errorType = 2;message = sqle.getMessage();
    }
    catch (HibernateException hbe)
    {
      ComponentException componentException;
      errorType = 3;message = hbe.getMessage();
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
         componentException = new ComponentException(2, "DgfComponentH3.getFilteredList", message);
        System.err.println(componentException.toString());
        throw componentException;
      }
    }
    return cnt;
  }
  
  protected String convertToString(List l)
  {
    StringBuffer sb = new StringBuffer();
    Iterator itrLocal = l.iterator();
    while (itrLocal.hasNext())
    {
      sb.append("'").append(itrLocal.next().toString()).append("'");
      if (itrLocal.hasNext()) {
        sb.append(",");
      }
    }
    return sb.toString();
  }
  
  public static String convertToString(Clob content)
    throws SQLException
  {
    String contentAsString = null;
    if (content != null) {
      contentAsString = content.getSubString(1L, (int)content.length());
    }
    return contentAsString;
  }
  
  public int updateSqlQuery(String queryString)
    throws SQLException, HibernateException, Exception
  {
    int updatedRowsCount = -1;
    
    Session hibernateSession = null;
    hibernateSession = getSession();
    Connection connection = hibernateSession.connection();
    PreparedStatement stmt = connection.prepareStatement(queryString);
    updatedRowsCount = stmt.executeUpdate();
    connection.commit();
    stmt.close();
    

    return updatedRowsCount;
  }
  
  public Session getSession(Connection conn)
    throws SQLException, HibernateException
  {
    Session session = null;
    synchronized (sf)
    {
      session = sf.openSession(conn);
    }
    return session;
  }
  
  public Session getSession(EmptyInterceptor interceptor)
    throws SQLException, HibernateException
  {
    Session session = null;
    synchronized (sf)
    {
      session = sf.openSession(interceptor);
    }
    return session;
  }
  
  public String getTableName(String className)
  {
    String tableName = "";
    ClassMetadata hibernateMetadata = null;
    synchronized (sf)
    {
      hibernateMetadata = sf.getClassMetadata(className);
    }
    if ((hibernateMetadata != null) && ((hibernateMetadata instanceof AbstractEntityPersister)))
    {
      AbstractEntityPersister persister = (AbstractEntityPersister)hibernateMetadata;
      tableName = persister.getTableName().toUpperCase();
    }
    return tableName;
  }
}



/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\

 * Qualified Name:     ps.edu.diyar.common.component.DgfComponentH3

 * JD-Core Version:    0.7.0.1

 */