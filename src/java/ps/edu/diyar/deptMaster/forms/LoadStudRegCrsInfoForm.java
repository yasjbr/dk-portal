package ps.edu.diyar.deptMaster.forms;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class LoadStudRegCrsInfoForm
  extends ActionForm
{
  private String studId;
  
  public String getStudId()
  {
    return this.studId;
  }
  
  public void setStudId(String studId)
  {
    this.studId = studId;
  }
  
  public ActionErrors validate(ActionMapping actionMapping, HttpServletRequest request)
  {
    ActionErrors errors = new ActionErrors();
    if ((this.studId == null) || (this.studId.trim().equals(""))) {
      errors.add("error.studId", new ActionMessage("errors.empty.studId"));
    }
    return errors;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.deptMaster.forms.LoadStudRegCrsInfoForm
 * JD-Core Version:    0.7.0.1
 */