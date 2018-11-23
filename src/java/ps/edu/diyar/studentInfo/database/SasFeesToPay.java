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
public class SasFeesToPay {

    private SasFeesToPayPK comp_id;
   
    private Double feesToPay;
     


    public SasFeesToPay() {
    }

    public SasFeesToPay(SasFeesToPayPK comp_id, Double feesToPay) {
        this.comp_id = comp_id;
        this.feesToPay = feesToPay;
         
    }

    public SasFeesToPayPK getComp_id() {
        return comp_id;
    }

    public void setComp_id(SasFeesToPayPK comp_id) {
        this.comp_id = comp_id;
    }

    public Double getFeesToPay() {
        return feesToPay;
    }

    public void setFeesToPay(Double feesToPay) {
        this.feesToPay = feesToPay;
    }

    

    public String toString() {
        return new ToStringBuilder(this).append("comp_id", getComp_id()).toString();
    }

    public boolean equals(Object other) {
        if (!(other instanceof SasFeesToPay)) {
            return false;
        }
        SasFeesToPay castOther = (SasFeesToPay) other;
        return new EqualsBuilder().append(getComp_id(), castOther.getComp_id()).isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder().append(getComp_id()).toHashCode();
    }

}
