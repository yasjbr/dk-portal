package ps.edu.diyar.admission.forms;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class AdmLoginForm
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
    if ((this.userId == null) || (this.password == null) || (this.userId.trim().equals("")) || (this.password.trim().equals(""))) {
      errors.add("userIdError", new ActionMessage("errors.userNotExist"));
    }
    return errors;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.admission.forms.AdmLoginForm
 * JD-Core Version:    0.7.0.1
 */