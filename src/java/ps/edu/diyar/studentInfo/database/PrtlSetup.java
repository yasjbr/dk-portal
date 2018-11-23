package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class PrtlSetup
  implements Serializable
{
  private String setupKey;
  private String setupValue;
  private String userId;
  private Date timeStamp;
  
  public PrtlSetup(String setupKey, String setupValue, String userId, Date timeStamp)
  {
    this.setupKey = setupKey;
    this.setupValue = setupValue;
    this.userId = userId;
    this.timeStamp = timeStamp;
  }
  
  public PrtlSetup(String setupKey, String setupValue)
  {
    this.setupKey = setupKey;
    this.setupValue = setupValue;
  }
  
  public PrtlSetup() {}
  
  public String getSetupKey()
  {
    return this.setupKey;
  }
  
  public void setSetupKey(String setupKey)
  {
    this.setupKey = setupKey;
  }
  
  public String getSetupValue()
  {
    return this.setupValue;
  }
  
  public void setSetupValue(String setupValue)
  {
    this.setupValue = setupValue;
  }
  
  public String getUserId()
  {
    return this.userId;
  }
  
  public void setUserId(String userId)
  {
    this.userId = userId;
  }
  
  public Date getTimeStamp()
  {
    return this.timeStamp;
  }
  
  public void setTimeStamp(Date timeStamp)
  {
    this.timeStamp = timeStamp;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("setupKey", getSetupKey()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof PrtlSetup)) {
      return false;
    }
    PrtlSetup castOther = (PrtlSetup)other;
    return new EqualsBuilder().append(getSetupKey(), castOther.getSetupKey()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getSetupKey()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.PrtlSetup
 * JD-Core Version:    0.7.0.1
 */