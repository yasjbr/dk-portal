/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ps.edu.diyar.studentInfo.database;

import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 *
 * @author Yaseen Jaber
 */
public class PrtlStudFtermCardDtl {

    private PrtlStudFtermCardDtlPK comp_id;
    private Double smDbAmt;
    private Double smDbBaseAmt;
    private Double counter;
    private Double crncyCode;
    private Double crncyRate;
    private String userId;
    private Date timeStamp;
    private String notes;
 
    
     private Double feesToPay;
     
    public PrtlStudFtermCardDtl() {
    }

    public PrtlStudFtermCardDtl(PrtlStudFtermCardDtlPK comp_id, String notes, Date timeStamp, String userId, Double crncyRate, Double crncyCode, Double counter, Double smDbAmt, Double smDbBaseAmt,Double feesToPay) {
        this.comp_id = comp_id;
        this.smDbAmt = smDbAmt;
        this.smDbBaseAmt = smDbBaseAmt;
        this.counter = counter;
        this.crncyCode = crncyCode;
        this.crncyRate = crncyRate;
        this.userId = userId;
        this.timeStamp = timeStamp;
        this.notes = notes;
        this.feesToPay = feesToPay;
    }

    public PrtlStudFtermCardDtlPK getComp_id() {
        return comp_id;
    }

    public void setComp_id(PrtlStudFtermCardDtlPK comp_id) {
        this.comp_id = comp_id;
    }

    public Double getCounter() {
        return counter;
    }

    public void setCounter(Double counter) {
        this.counter = counter;
    }

    public Double getCrncyCode() {
        return crncyCode;
    }

    public void setCrncyCode(Double crncyCode) {
        this.crncyCode = crncyCode;
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

    public Double getSmDbAmt() {
        return smDbAmt;
    }

    public void setSmDbAmt(Double smDbAmt) {
        this.smDbAmt = smDbAmt;
    }

    public Double getSmDbBaseAmt() {
        return smDbBaseAmt;
    }

    public Double getFeesToPay() {
        return feesToPay;
    }

    public void setFeesToPay(Double feesToPay) {
        this.feesToPay = feesToPay;
    }

    
    
    
    public void setSmDbBaseAmt(Double smDbBaseAmt) {
        this.smDbBaseAmt = smDbBaseAmt;
    }

    public String toString() {
        return new ToStringBuilder(this).append("comp_id", getComp_id()).toString();
    }

    public boolean equals(Object other) {
        if (!(other instanceof PrtlStudFtermCardDtl)) {
            return false;
        }
        PrtlStudFtermCardDtl castOther = (PrtlStudFtermCardDtl) other;
        return new EqualsBuilder().append(getComp_id(), castOther.getComp_id()).isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder().append(getComp_id()).toHashCode();
    }

}
