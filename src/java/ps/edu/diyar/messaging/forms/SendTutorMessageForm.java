package ps.edu.diyar.messaging.forms;

import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;
import ps.edu.diyar.studentInfo.database.struct.TutorListForCenter;

public class SendTutorMessageForm
  extends ActionForm
{
  private String[] classStudent;
  private String messageBody;
  private String[] recieverStudent = new String[0];
  private String subject;
  private String servirity;
  private FormFile theFile;
  private String center;
  private String tutorName;
  private String submitValue;
  private String program;
  private String status;
  private String existUsers;
  private String selectedUsers;
  private String crsNo;
  private boolean decode = true;
  private String excepLevel;
  private String term;
  private String examType;
  private String searchByCrsNo;
  
  public String getSearchByCrsNo()
  {
    return this.searchByCrsNo;
  }
  
  public void setSearchByCrsNo(String searchByCrsNo)
  {
    this.searchByCrsNo = searchByCrsNo;
  }
  
  public String getExcepLevel()
  {
    return this.excepLevel;
  }
  
  public void setExcepLevel(String excepLevel)
  {
    this.excepLevel = excepLevel;
  }
  
  public String getTerm()
  {
    return this.term;
  }
  
  public void setTerm(String term)
  {
    this.term = term;
  }
  
  public String getExamType()
  {
    return this.examType;
  }
  
  public void setExamType(String examType)
  {
    this.examType = examType;
  }
  
  public String getStatus()
  {
    return this.status;
  }
  
  public void setStatus(String status)
  {
    this.status = status;
  }
  
  public String getSubmitValue()
  {
    return this.submitValue;
  }
  
  public void setSubmitValue(String submitValue)
  {
    this.submitValue = submitValue;
  }
  
  public String getTutorName()
  {
    String temp = "";
    try
    {
      if (this.decode) {
        temp = new String(this.tutorName.getBytes("ISO8859_1"), "utf8");
      }
    }
    catch (Exception e) {}
    return temp;
  }
  
  public void setTutorName(String tutorName)
  {
    this.tutorName = tutorName;
  }
  
  public String getProgram()
  {
    return this.program;
  }
  
  public void setProgram(String program)
  {
    this.program = program;
  }
  
  public String getCenter()
  {
    return this.center;
  }
  
  public void setCenter(String center)
  {
    this.center = center;
  }
  
  public String[] getClassStudent()
  {
    return this.classStudent;
  }
  
  public void setClassStudent(String[] classStudent)
  {
    this.classStudent = classStudent;
  }
  
  public String getServirity()
  {
    return this.servirity;
  }
  
  public void setServirity(String servirity)
  {
    this.servirity = servirity;
  }
  
  public String getMessageBody()
  {
    try
    {
      if (this.decode) {
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
  
  public String[] getRecieverStudent()
  {
    return this.recieverStudent;
  }
  
  public void setRecieverStudent(String[] recieverStudent)
  {
    this.recieverStudent = recieverStudent;
  }
  
  public String getSubject()
  {
    try
    {
      if (this.decode) {
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
      if (this.decode) {
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
  
  public FormFile getTheFile()
  {
    return this.theFile;
  }
  
  public void setTheFile(FormFile theFile)
  {
    this.theFile = theFile;
  }
  
  public String getExistUsers()
  {
    return this.existUsers;
  }
  
  public void setExistUsers(String existUsers)
  {
    this.existUsers = existUsers;
  }
  
  public String getSelectedUsers()
  {
    return this.selectedUsers;
  }
  
  public void setSelectedUsers(String selectedUsers)
  {
    this.selectedUsers = selectedUsers;
  }
  
  public boolean isDecode()
  {
    return this.decode;
  }
  
  public void setDecode(boolean decode)
  {
    this.decode = decode;
  }
  
  public String getCrsNo()
  {
    return this.crsNo;
  }
  
  public void setCrsNo(String crsNo)
  {
    this.crsNo = crsNo;
  }
  
  public ActionErrors validate(ActionMapping actionMapping, HttpServletRequest httpServletRequest)
  {
    ActionErrors errors = new ActionErrors();
    if ((this.submitValue != null) && (this.submitValue.trim().equals("1")))
    {
      if ((this.recieverStudent == null) || (this.recieverStudent.length == 0)) {
        errors.add("emptyRecieverStudent", new ActionMessage("errors.emptyRcieverStudent"));
      }
      if ((this.subject == null) || (this.subject.trim().equals(""))) {
        errors.add("emptySubject", new ActionMessage("errors.emptySubject"));
      }
      if ((this.messageBody == null) || (this.messageBody.trim().equals(""))) {
        errors.add("emptyMessageBody", new ActionMessage("errors.emptyMessageBody"));
      }
      if (this.theFile != null) {
        if (this.theFile.getFileSize() > 10485760) {
          errors.add("wrongFileInfo", new ActionMessage("errors.maxLengthExceeded"));
        }
      }
    }
    if (!errors.isEmpty()) {
      repopulateExistUsersLists(httpServletRequest);
    }
    repopulateSelectedUsersLists(httpServletRequest);
    httpServletRequest.setAttribute("crsNo", this.crsNo);
    if (this.searchByCrsNo != null) {
      httpServletRequest.setAttribute("searchByCrsNo", this.searchByCrsNo);
    }
    String crsNo = httpServletRequest.getParameter("crsNo");
    String classNo = httpServletRequest.getParameter("classNo");
    
    httpServletRequest.setAttribute("classNo", classNo);
    httpServletRequest.setAttribute("crsNo", crsNo);
    

    return errors;
  }
  
  public void reset(ActionMapping actionMapping, HttpServletRequest httpServletRequest) {}
  
  public void repopulateExistUsersLists(HttpServletRequest request)
  {
    try
    {
      ArrayList tutorList = new ArrayList();
      StringTokenizer idStz = new StringTokenizer(this.existUsers, ";");
      String temp = "";
      while (idStz.hasMoreTokens())
      {
        temp = idStz.nextToken();
        TutorListForCenter tutor = new TutorListForCenter();
        tutor.setTutorUserId(temp.substring(0, temp.indexOf("_")));
        try
        {
          tutor.setTutorAName(new String(temp.substring(temp.indexOf("_") + 1).getBytes("ISO8859_1"), "utf8"));
        }
        catch (Exception e) {}
        tutorList.add(tutor);
      }
      request.setAttribute("existUsersList", tutorList);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
  
  public void repopulateSelectedUsersLists(HttpServletRequest request)
  {
    try
    {
      ArrayList selectedTutorList = new ArrayList();
      StringTokenizer idStz = new StringTokenizer(this.selectedUsers, ";");
      String temp = "";
      while (idStz.hasMoreTokens())
      {
        temp = idStz.nextToken();
        TutorListForCenter tutor = new TutorListForCenter();
        tutor.setTutorUserId(temp.substring(0, temp.indexOf("_")));
        try
        {
          tutor.setTutorAName(new String(temp.substring(temp.indexOf("_") + 1).getBytes("ISO8859_1"), "utf8"));
        }
        catch (Exception e) {}
        selectedTutorList.add(tutor);
      }
      request.setAttribute("selectedUsersList", selectedTutorList);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.messaging.forms.SendTutorMessageForm
 * JD-Core Version:    0.7.0.1
 */