package ps.edu.diyar.common.utils;

import java.io.Serializable;

public class Count
  implements Serializable
{
  private long count;
  
  public Count() {}
  
  public Count(Integer count)
  {
    this.count = count.intValue();
  }
  
  public Count(long count)
  {
    this.count = count;
  }
  
  public long getCount()
  {
    return this.count;
  }
  
  public void setCount(long count)
  {
    this.count = count;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.common.utils.Count
 * JD-Core Version:    0.7.0.1
 */