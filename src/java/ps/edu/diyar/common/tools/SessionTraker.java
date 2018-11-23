package ps.edu.diyar.common.tools;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionTraker
{
  public static boolean isSessionExist(HttpServletRequest request)
  {
    boolean valid = false;
    if (request.getSession().getAttribute("userLogged") != null) {
      valid = true;
    }
    return valid;
  }
  
  public static boolean isUserAdmLogged(HttpServletRequest request)
  {
    boolean valid = false;
    if (request.getSession().getAttribute("admInfo") != null) {
      valid = true;
    }
    return valid;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.common.tools.SessionTraker
 * JD-Core Version:    0.7.0.1
 */