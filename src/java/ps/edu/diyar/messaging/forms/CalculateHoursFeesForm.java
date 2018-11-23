package ps.edu.diyar.messaging.forms;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

public class CalculateHoursFeesForm
  extends ActionForm
{
  
  private String hours;
  
  private boolean isEdit = false;
  
  
  
   
   
   
   
   
  
  public String getHours()
  {
    try
    {
      if (!this.isEdit) {
        this.hours = new String(this.hours.getBytes("ISO8859_1"), "utf8");
      }
    }
    catch (Exception e) {}
    return this.hours;
  }
  
   
  
  public void setHours(String hours)
  {
      if (this.hours== null){
          this.hours="0";
      }
    this.hours = hours;
  }
  
   
   
   
  
  public ActionErrors validate(ActionMapping actionMapping, HttpServletRequest request)
  {
        System.out.println("-------hours"+this.hours);
    ActionErrors errors = new ActionErrors();
    if ((this.hours == null) || (this.hours.trim().equals(""))) {
        System.out.println("-------hours"+this.hours);
      errors.add("emptySubject", new ActionMessage("errors.emptySubject"));
    }
    
    
     if ((this.hours != null) && (!this.hours.equals(""))) {
        try
        {
          Integer.parseInt(this.hours);
        }
        catch (Exception e)
        {
          errors.add("errors.hours", new ActionMessage("errors.hours"));
        }
      }
     
     
    return errors;
  }
  
  public void reset(ActionMapping actionMapping, HttpServletRequest httpServletRequest) {}
  
  
  
  
 
  
}


 