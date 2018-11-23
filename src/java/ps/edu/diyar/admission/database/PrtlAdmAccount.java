package ps.edu.diyar.admission.database;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class PrtlAdmAccount
  implements Serializable
{
  private String accNo;
  private String accPasswd;
  private String accIsActive;
  private Date timeStamp;
  private String userId;
  
  public PrtlAdmAccount(String accNo, String accPasswd, String accIsActive, Date timeStamp, String userId)
  {
    this.accNo = accNo;
    this.accPasswd = accPasswd;
    this.accIsActive = accIsActive;
    this.timeStamp = timeStamp;
    this.userId = userId;
  }
  
  public PrtlAdmAccount() {}
  
  public String getAccNo()
  {
    return this.accNo;
  }
  
  public void setAccNo(String accNo)
  {
    this.accNo = accNo;
  }
  
  public String getAccPasswd()
  {
    return this.accPasswd;
  }
  
  public void setAccPasswd(String accPasswd)
  {
    this.accPasswd = accPasswd;
  }
  
  public String getAccIsActive()
  {
    return this.accIsActive;
  }
  
  public void setAccIsActive(String accIsActive)
  {
    this.accIsActive = accIsActive;
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
  
  public String toString()
  {
    return new ToStringBuilder(this).append("accNo", getAccNo()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof PrtlAdmAccount)) {
      return false;
    }
    PrtlAdmAccount castOther = (PrtlAdmAccount)other;
    return new EqualsBuilder().append(getAccNo(), castOther.getAccNo()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getAccNo()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.admission.database.PrtlAdmAccount
 * JD-Core Version:    0.7.0.1
 */