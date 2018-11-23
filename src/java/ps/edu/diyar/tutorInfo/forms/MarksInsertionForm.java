package ps.edu.diyar.tutorInfo.forms;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class MarksInsertionForm
  extends ActionForm
{
  private String classNo;
  private String crsNo;
  private String termNo;
  private String submitValue;
  private String crsMark;
  private String firstMark;
  private String secondMark;
  private String midMark;
  private String practicalMark;
  private String finalMark;
  
  private String marksChecked;
  private String empNo;

    public String getSecondMark() {
        return secondMark;
    }

    public void setSecondMark(String secondMark) {
        this.secondMark = secondMark;
    }

    public String getMidMark() {
        return midMark;
    }

    public void setMidMark(String midMark) {
        this.midMark = midMark;
    }

    public String getPracticalMark() {
        return practicalMark;
    }

    public void setPracticalMark(String practicalMark) {
        this.practicalMark = practicalMark;
    }

    public String getFinalMark() {
        return finalMark;
    }

    public void setFinalMark(String finalMark) {
        this.finalMark = finalMark;
    }

  
  
  
  
  
  
  
    public String getFirstMark() {
        return firstMark;
    }

    public void setFirstMark(String firstMark) {
        this.firstMark = firstMark;
    }
  
  
  
  
  
  public String getMarksChecked()
  {
    return this.marksChecked;
  }
  
  public void setMarksChecked(String marksChecked)
  {
    this.marksChecked = marksChecked;
  }
  
  public String getSubmitValue()
  {
    return this.submitValue;
  }
  
  public void setSubmitValue(String submitValue)
  {
    this.submitValue = submitValue;
  }
  
  public String getClassNo()
  {
    return this.classNo;
  }
  
  public void setClassNo(String classNo)
  {
    this.classNo = classNo;
  }
  
  public String getCrsNo()
  {
    return this.crsNo;
  }
  
  public void setCrsNo(String crsNo)
  {
    this.crsNo = crsNo;
  }
  
  public String getTermNo()
  {
    return this.termNo;
  }
  
  public void setTermNo(String termNo)
  {
    this.termNo = termNo;
  }
  
  public String getCrsMark()
  {
    return this.crsMark;
  }
  
  public void setCrsMark(String crsMark)
  {
    this.crsMark = crsMark;
  }
  
  public String getEmpNo()
  {
    return this.empNo;
  }
  
  public void setEmpNo(String empNo)
  {
    this.empNo = empNo;
  }
  
  public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
  {
    ActionErrors errors = new ActionErrors();
    return errors;
  }
  
  public void reset(ActionMapping actionMapping, HttpServletRequest httpServletRequest) {}
}



/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\

 * Qualified Name:     ps.edu.diyar.tutorInfo.forms.MarksInsertionForm

 * JD-Core Version:    0.7.0.1

 */