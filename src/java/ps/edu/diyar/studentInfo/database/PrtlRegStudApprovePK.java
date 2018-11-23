package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class PrtlRegStudApprovePK
  implements Serializable
{
  private String studId;
  private String termNo;
  private String calendarItem;
  
  public PrtlRegStudApprovePK(String studId, String termNo, String calendarItem)
  {
    this.studId = studId;
    this.termNo = termNo;
    this.calendarItem = calendarItem;
  }
  
  public PrtlRegStudApprovePK() {}
  
  public String getStudId()
  {
    return this.studId;
  }
  
  public void setStudId(String studId)
  {
    this.studId = studId;
  }
  
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
    return new ToStringBuilder(this).append("studId", getStudId()).append("termNo", getTermNo()).append("calendarItem", getCalendarItem()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof PrtlRegStudApprovePK)) {
      return false;
    }
    PrtlRegStudApprovePK castOther = (PrtlRegStudApprovePK)other;
    return new EqualsBuilder().append(getStudId(), castOther.getStudId()).append(getTermNo(), castOther.getTermNo()).append(getCalendarItem(), castOther.getCalendarItem()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getStudId()).append(getTermNo()).append(getCalendarItem()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.PrtlRegStudApprovePK
 * JD-Core Version:    0.7.0.1
 */