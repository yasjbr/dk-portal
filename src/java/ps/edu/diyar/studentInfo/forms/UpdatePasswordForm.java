package ps.edu.diyar.studentInfo.forms;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class UpdatePasswordForm
  extends ActionForm
{
  private String oldPassword;
  private String newPassword;
  private String newPassword2;
  private String email;
  private String mobile;
  private String smsReg;
  
  public ActionErrors validate(ActionMapping mapping, HttpServletRequest req)
  {
    ActionErrors errors = new ActionErrors();
    
    Pattern emailPattern = Pattern.compile("^[a-zA-Z][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$");
    Matcher email1Match = emailPattern.matcher(this.email);
    
    Pattern mobilePattern = Pattern.compile("0599\\d{6}");
    Matcher mobileMatch = mobilePattern.matcher(this.mobile);
    if (((this.oldPassword == null) || (this.oldPassword.trim().equals(""))) && (((this.newPassword != null) && (!this.newPassword.trim().equals(""))) || ((this.newPassword2 != null) && (!this.newPassword2.trim().equals(""))))) {
      errors.add("wrongOldPassword", new ActionMessage("errors.oldPasswordMissed"));
    }
    if ((this.oldPassword != null) && (!this.oldPassword.trim().equals("")) && ((this.newPassword == null) || (this.newPassword2 == null) || (this.newPassword.trim().equals("")) || (this.newPassword2.trim().equals("")))) {
      errors.add("wrongNewPassword", new ActionMessage("errors.newPasswordMissed"));
    }
    if ((this.oldPassword != null) && (this.newPassword != null) && (this.newPassword2 != null) && (!this.oldPassword.trim().equals("")) && (!this.newPassword.trim().equals("")) && (!this.newPassword2.trim().equals(""))) {
      if (!this.newPassword.equals(this.newPassword2)) {
        errors.add("wrongNewPassword", new ActionMessage("errors.newPasswordMismatch"));
      } else if ((this.newPassword.length() < 6) || (this.newPassword.length() > 18)) {
        errors.add("wrongNewPassword", new ActionMessage("errors.wrongPasswordLength"));
      }
    }
    if ((this.email != null) && (!this.email.equals("")) && (!email1Match.matches())) {
      errors.add("wrongEmail", new ActionMessage("errors.wrongEmailFormat"));
    }
    if (this.smsReg == null)
    {
      this.smsReg = "N";
    }
    else if (this.smsReg.equals("on"))
    {
      this.smsReg = "Y";
      if (!mobileMatch.matches()) {
        errors.add("wrongPhone", new ActionMessage("errors.wrongPhoneFormat"));
      }
    }
    else
    {
      this.smsReg = "N";
    }
    return errors;
  }
  
  public String getSmsReg()
  {
    return this.smsReg;
  }
  
  public void setSmsReg(String smsReg)
  {
    this.smsReg = smsReg;
  }
  
  public String getEmail()
  {
    return this.email;
  }
  
  public void setEmail(String email)
  {
    this.email = email;
  }
  
  public String getMobile()
  {
    return this.mobile;
  }
  
  public void setMobile(String mobile)
  {
    this.mobile = mobile;
  }
  
  public String getOldPassword()
  {
    return this.oldPassword;
  }
  
  public void setOldPassword(String oldPassword)
  {
    this.oldPassword = oldPassword;
  }
  
  public void setNewPassword(String newPassword)
  {
    this.newPassword = newPassword;
  }
  
  public String getNewPassword()
  {
    return this.newPassword;
  }
  
  public void setNewPassword2(String newPassword2)
  {
    this.newPassword2 = newPassword2;
  }
  
  public String getNewPassword2()
  {
    return this.newPassword2;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.forms.UpdatePasswordForm
 * JD-Core Version:    0.7.0.1
 */