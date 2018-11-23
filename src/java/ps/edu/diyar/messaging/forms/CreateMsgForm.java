package ps.edu.diyar.messaging.forms;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

public class CreateMsgForm
  extends ActionForm
{
  private String messageBody;
  private String recieverId;
  private String subject;
  private String recieverName;
  private String messageExtraInfo;
  private FormFile theFile;
  private String crsNo;
  private String crsClass;
  private boolean isEdit = false;
  
  public String getCrsNo()
  {
    return this.crsNo;
  }
  
  public void setCrsNo(String crsNo)
  {
    this.crsNo = crsNo;
  }
  
  public String getCrsClass()
  {
    return this.crsClass;
  }
  
  public void setCrsClass(String crsClass)
  {
    this.crsClass = crsClass;
  }
  
  public FormFile getTheFile()
  {
    return this.theFile;
  }
  
  public void setTheFile(FormFile theFile)
  {
    this.theFile = theFile;
  }
  
  public String getMessageBody()
  {
    try
    {
      if (!this.isEdit) {
        this.messageBody = new String(this.messageBody.getBytes("ISO8859_1"), "utf8");
      }
    }
    catch (Exception e) {}
    return this.messageBody;
  }
  
  public void setMessageBody(String messageBody)
  {
    this.messageBody = messageBody;
  }
  
  public String getRecieverId()
  {
    return this.recieverId;
  }
  
  public void setRecieverId(String recieverId)
  {
    this.recieverId = recieverId;
  }
  
  public String getRecieverName()
  {
    try
    {
      if (!this.isEdit) {
        this.recieverName = new String(this.recieverName.getBytes("ISO8859_1"), "utf8");
      }
    }
    catch (Exception e) {}
    return this.recieverName;
  }
  
  public void setRecieverName(String recieverName)
  {
    this.recieverName = recieverName;
  }
  
  public String getSubject()
  {
    try
    {
      if (!this.isEdit) {
        this.subject = new String(this.subject.getBytes("ISO8859_1"), "utf8");
      }
    }
    catch (Exception e) {}
    return this.subject;
  }
  
  public String getSubjectWrapper()
  {
    String subjectTxt = this.subject;
    try
    {
      if (!this.isEdit) {
        subjectTxt = new String(subjectTxt.getBytes("ISO8859_1"), "utf8");
      }
    }
    catch (Exception e) {}
    return subjectTxt;
  }
  
  public void setSubject(String subject)
  {
    this.subject = subject;
  }
  
  public boolean isEdit()
  {
    return this.isEdit;
  }
  
  public void setEdit(boolean edit)
  {
    this.isEdit = edit;
  }
  
  public String getMessageExtraInfo()
  {
    return this.messageExtraInfo;
  }
  
  public void setMessageExtraInfo(String messageExtraInfo)
  {
    this.messageExtraInfo = messageExtraInfo;
  }
  
  public ActionErrors validate(ActionMapping actionMapping, HttpServletRequest request)
  {
    ActionErrors errors = new ActionErrors();
    if ((this.subject == null) || (this.subject.trim().equals(""))) {
      errors.add("emptySubject", new ActionMessage("errors.emptySubject"));
    }
    if ((this.messageBody == null) || (this.messageBody.trim().equals(""))) {
      errors.add("emptyMessageBody", new ActionMessage("errors.emptyMessageBody"));
    }
    if (this.theFile != null) {
      if (this.theFile.getFileSize() > 2097152) {
        errors.add("wrongFileInfo", new ActionMessage("errors.maxLengthExceeded"));
      }
    }
    return errors;
  }
  
  public void reset(ActionMapping actionMapping, HttpServletRequest httpServletRequest) {}
}



/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\

 * Qualified Name:     ps.edu.diyar.messaging.forms.CreateMsgForm

 * JD-Core Version:    0.7.0.1

 */