package ps.edu.diyar.login.database;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class PrtlSecUser
  implements Serializable
{
  private String userId;
  private String userPwd;
  private String status;
  private Integer roleid;
  private String email;
  private String screenName;
  private Date lastVisitDate;
  private Date creationDate;
  private String mobile;
  private String smsReg;
  private String pwdSource;
  private Date pwdLastChange;
  
  public PrtlSecUser(String userId, String userPwd, String status, Integer roleid, String email, String screenName, Date lastVisitDate, Date creationDate, String mobile, String smsReg, String pwdSource, Date pwdLastChange)
  {
    this.userId = userId;
    this.userPwd = userPwd;
    this.status = status;
    this.roleid = roleid;
    this.email = email;
    this.screenName = screenName;
    this.lastVisitDate = lastVisitDate;
    this.creationDate = creationDate;
    this.mobile = mobile;
    this.smsReg = smsReg;
    this.pwdSource = pwdSource;
    this.pwdLastChange = pwdLastChange;
  }
  
  public PrtlSecUser() {}
  
  public PrtlSecUser(String userId)
  {
    this.userId = userId;
  }
  
  public String getUserId()
  {
    return this.userId;
  }
  
  public void setUserId(String userId)
  {
    this.userId = userId;
  }
  
  public String getUserPwd()
  {
    return this.userPwd;
  }
  
  public void setUserPwd(String userPwd)
  {
    this.userPwd = userPwd;
  }
  
  public String getStatus()
  {
    return this.status;
  }
  
  public void setStatus(String status)
  {
    this.status = status;
  }
  
  public Integer getRoleid()
  {
    return this.roleid;
  }
  
  public void setRoleid(Integer roleid)
  {
    this.roleid = roleid;
  }
  
  public String getEmail()
  {
    return this.email;
  }
  
  public void setEmail(String email)
  {
    this.email = email;
  }
  
  public String getScreenName()
  {
    return this.screenName;
  }
  
  public void setScreenName(String screenName)
  {
    this.screenName = screenName;
  }
  
  public Date getLastVisitDate()
  {
    return this.lastVisitDate;
  }
  
  public void setLastVisitDate(Date lastVisitDate)
  {
    this.lastVisitDate = lastVisitDate;
  }
  
  public Date getCreationDate()
  {
    return this.creationDate;
  }
  
  public void setCreationDate(Date creationDate)
  {
    this.creationDate = creationDate;
  }
  
  public String getMobile()
  {
    return this.mobile;
  }
  
  public void setMobile(String mobile)
  {
    this.mobile = mobile;
  }
  
  public String getSmsReg()
  {
    return this.smsReg;
  }
  
  public void setSmsReg(String smsReg)
  {
    this.smsReg = smsReg;
  }
  
  public String getPwdSource()
  {
    return this.pwdSource;
  }
  
  public void setPwdSource(String pwdSource)
  {
    this.pwdSource = pwdSource;
  }
  
  public Date getPwdLastChange()
  {
    return this.pwdLastChange;
  }
  
  public void setPwdLastChange(Date pwdLastChange)
  {
    this.pwdLastChange = pwdLastChange;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("userId", getUserId()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof PrtlSecUser)) {
      return false;
    }
    PrtlSecUser castOther = (PrtlSecUser)other;
    return new EqualsBuilder().append(getUserId(), castOther.getUserId()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getUserId()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.login.database.PrtlSecUser
 * JD-Core Version:    0.7.0.1
 */