package ps.edu.diyar.common.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import ps.edu.diyar.login.database.struct.UserInfo;

public class AuditInfo
{
  private HttpServletRequest request;
  
  public AuditInfo(HttpServletRequest request)
  {
    this.request = request;
  }
  
  public String getRemoteIp()
  {
    return this.request.getRemoteHost();
  }
  
  public UserInfo getUserLoginInfo()
  {
    return (UserInfo)this.request.getSession().getAttribute("userInfo");
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.common.component.AuditInfo
 * JD-Core Version:    0.7.0.1
 */