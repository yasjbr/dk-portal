package ps.edu.diyar.login.forms;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class LoginForm
  extends ActionForm
{
  private String password;
  private String userId;
  
  public String getPassword()
  {
    return this.password;
  }
  
  public void setPassword(String password)
  {
    this.password = password;
  }
  
  public void setUserId(String userId)
  {
    this.userId = userId;
  }
  
  public String getUserId()
  {
    return this.userId;
  }
  
  public ActionErrors validate(ActionMapping mapping, HttpServletRequest req)
  {
    ActionErrors errors = new ActionErrors();
    
    String secText = "";
    String imgSecText = "";
    boolean isSecText = false;
    if (req.getSession().getAttribute("captchImageRequired") != null)
    {
      imgSecText = (String)req.getSession().getAttribute("passwordImageData");
      secText = req.getParameter("secText");
      isSecText = true;
    }
    if ((this.userId == null) || (this.password == null) || (secText == null) || (this.userId.trim().equals("")) || (this.password.trim().equals("")) || (!secText.trim().equalsIgnoreCase(imgSecText))) {
      if (!isSecText) {
        errors.add("userIdError", new ActionMessage("errors.userNotExist"));
      } else {
        errors.add("userIdError", new ActionMessage("errors.userNotExistWithSecText"));
      }
    }
    return errors;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.login.forms.LoginForm
 * JD-Core Version:    0.7.0.1
 */