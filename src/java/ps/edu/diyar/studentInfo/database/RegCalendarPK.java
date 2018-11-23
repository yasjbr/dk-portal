package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RegCalendarPK
  implements Serializable
{
  private String termNo;
  private String calendarItem;
  
  public RegCalendarPK(String termNo, String calendarItem)
  {
    this.termNo = termNo;
    this.calendarItem = calendarItem;
  }
  
  public RegCalendarPK() {}
  
  public String getTermNo()
  {
    return this.termNo;
  }
  
  public void setTermNo(String termNo)
  {
    this.termNo = termNo;
  }
  
  public String getCalendarItem()
  {
    return this.calendarItem;
  }
  
  public void setCalendarItem(String calendarItem)
  {
    this.calendarItem = calendarItem;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("termNo", getTermNo()).append("calendarItem", getCalendarItem()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof RegCalendarPK)) {
      return false;
    }
    RegCalendarPK castOther = (RegCalendarPK)other;
    return new EqualsBuilder().append(getTermNo(), castOther.getTermNo()).append(getCalendarItem(), castOther.getCalendarItem()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getTermNo()).append(getCalendarItem()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.RegCalendarPK
 * JD-Core Version:    0.7.0.1
 */