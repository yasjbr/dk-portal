package ps.edu.diyar.login.database.struct;

import java.util.Date;

public class UserInfo
{
  private String userId;
  private Integer roleid;
  private String email;
  private String screenName;
  private Date lastVisitDate;
  private String mobile;
  private String roleCat;
  
  public UserInfo() {}
  
  public UserInfo(String userId, Integer roleid, String email, String screenName, Date lastVisitDate, String mobile, String roleCat)
  {
    this.userId = userId;
    this.roleid = roleid;
    this.email = email;
    this.screenName = screenName;
    this.lastVisitDate = lastVisitDate;
    this.mobile = mobile;
    this.roleCat = roleCat;
  }
  
  public String getRoleCat()
  {
    return this.roleCat;
  }
  
  public void setRoleCat(String roleCat)
  {
    this.roleCat = roleCat;
  }
  
  public String getUserId()
  {
    return this.userId;
  }
  
  public void setUserId(String userId)
  {
    this.userId = userId;
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
  
  public String getMobile()
  {
    return this.mobile;
  }
  
  public void setMobile(String mobile)
  {
    this.mobile = mobile;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.login.database.struct.UserInfo
 * JD-Core Version:    0.7.0.1
 */