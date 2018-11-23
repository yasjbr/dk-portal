package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class PrtlRegStudControl
  implements Serializable
{
  private Long counter;
  private String termNo;
  private String studId;
  private String crsNo;
  private String status;
  private Date timeStamp;
  private String userId;
  private String computerIp;
  
  public PrtlRegStudControl(Long counter, String termNo, String studId, String crsNo, String status, Date timeStamp, String userId, String computerIp)
  {
    this.counter = counter;
    this.termNo = termNo;
    this.studId = studId;
    this.crsNo = crsNo;
    this.status = status;
    this.timeStamp = timeStamp;
    this.userId = userId;
    this.computerIp = computerIp;
  }
  
  public PrtlRegStudControl() {}
  
  public PrtlRegStudControl(Long counter, String termNo, String studId, String crsNo, String status, String userId)
  {
    this.counter = counter;
    this.termNo = termNo;
    this.studId = studId;
    this.crsNo = crsNo;
    this.status = status;
    this.userId = userId;
  }
  
  public Long getCounter()
  {
    return this.counter;
  }
  
  public void setCounter(Long counter)
  {
    this.counter = counter;
  }
  
  public String getTermNo()
  {
    return this.termNo;
  }
  
  public void setTermNo(String termNo)
  {
    this.termNo = termNo;
  }
  
  public String getStudId()
  {
    return this.studId;
  }
  
  public void setStudId(String studId)
  {
    this.studId = studId;
  }
  
  public String getCrsNo()
  {
    return this.crsNo;
  }
  
  public void setCrsNo(String crsNo)
  {
    this.crsNo = crsNo;
  }
  
  public String getStatus()
  {
    return this.status;
  }
  
  public void setStatus(String status)
  {
    this.status = status;
  }
  
  public Date getTimeStamp()
  {
    return this.timeStamp;
  }
  
  public void setTimeStamp(Date timeStamp)
  {
    this.timeStamp = timeStamp;
  }
  
  public String getUserId()
  {
    return this.userId;
  }
  
  public void setUserId(String userId)
  {
    this.userId = userId;
  }
  
  public String getComputerIp()
  {
    return this.computerIp;
  }
  
  public void setComputerIp(String computerIp)
  {
    this.computerIp = computerIp;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("counter", getCounter()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof PrtlRegStudControl)) {
      return false;
    }
    PrtlRegStudControl castOther = (PrtlRegStudControl)other;
    return new EqualsBuilder().append(getCounter(), castOther.getCounter()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getCounter()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.PrtlRegStudControl
 * JD-Core Version:    0.7.0.1
 */