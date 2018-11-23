package ps.edu.diyar.common.component;

import ps.edu.diyar.common.exceptions.ComponentException;

public abstract interface DataAccessObject
{
  public abstract Object insert(Object paramObject)
    throws ComponentException;
  
  public abstract void insertOrUpdate(Object paramObject)
    throws ComponentException;
  
  public abstract void update(Object paramObject)
    throws ComponentException;
  
  public abstract void delete(Object paramObject)
    throws ComponentException;
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.common.component.DataAccessObject
 * JD-Core Version:    0.7.0.1
 */