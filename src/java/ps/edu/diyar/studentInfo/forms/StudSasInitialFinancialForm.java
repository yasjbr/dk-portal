package ps.edu.diyar.studentInfo.forms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import ps.edu.diyar.common.component.FormCmp;
import ps.edu.diyar.studentInfo.database.struct.StudentInfoHolder;
import ps.edu.diyar.studentInfo.useCase.ViewStudSocialSurveyUseCase;

public class StudSasInitialFinancialForm
        extends ActionForm {

    private Double counter;
    private String studId;
    private String termNo;
    private String finCode;
    private Double smDbAmt;
    private Double crncyCode;
    private Double smDbBaseAmt;
    private Double crncyRate;
    private String userId;
    private Date timeStamp;
    private String notes;
    
     private String hours;

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

     
     
     
     
     
    public Double getCounter() {
        return counter;
    }

    public void setCounter(Double counter) {
        this.counter = counter;
    }

    public String getStudId() {
        return studId;
    }

    public void setStudId(String studId) {
        this.studId = studId;
    }

    public String getTermNo() {
        return termNo;
    }

    public void setTermNo(String termNo) {
        this.termNo = termNo;
    }

    public String getFinCode() {
        return finCode;
    }

    public void setFinCode(String finCode) {
        this.finCode = finCode;
    }

    public Double getSmDbAmt() {
        return smDbAmt;
    }

    public void setSmDbAmt(Double smDbAmt) {
        this.smDbAmt = smDbAmt;
    }

    public Double getCrncyCode() {
        return crncyCode;
    }

    public void setCrncyCode(Double crncyCode) {
        this.crncyCode = crncyCode;
    }

    public Double getSmDbBaseAmt() {
        return smDbBaseAmt;
    }

    public void setSmDbBaseAmt(Double smDbBaseAmt) {
        this.smDbBaseAmt = smDbBaseAmt;
    }

    public Double getCrncyRate() {
        return crncyRate;
    }

    public void setCrncyRate(Double crncyRate) {
        this.crncyRate = crncyRate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
    
    


    public ActionErrors validate(ActionMapping mapping, HttpServletRequest req) {
        ActionErrors errors = new ActionErrors();
         System.out.println("-------hours"+this.hours);
         if ((this.hours == null) || (this.hours.trim().equals(""))) {
        System.out.println("-------hours"+this.hours);
      errors.add("emptySubject", new ActionMessage("errors.emptySubject"));
          errors.add("error.errorOccuered", new ActionMessage("portal.error.internalMessage",  "7 "));
    }  
        
        return errors;
    }
}

 