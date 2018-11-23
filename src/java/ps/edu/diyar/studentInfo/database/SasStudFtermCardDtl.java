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
public class SasStudFtermCardDtl {

    private SasStudFtermCardDtlPK comp_id;
    private String finName;
    private Double smDbAmt;
    private Double smDbBaseAmt;


    public SasStudFtermCardDtl() {
    }

    public SasStudFtermCardDtl(SasStudFtermCardDtlPK comp_id, String finName, Double smDbAmt, Double smDbBaseAmt) {
        this.comp_id = comp_id;
        this.finName = finName;
        this.smDbAmt = smDbAmt;
        this.smDbBaseAmt = smDbBaseAmt;
    }

    public SasStudFtermCardDtlPK getComp_id() {
        return comp_id;
    }

    public void setComp_id(SasStudFtermCardDtlPK comp_id) {
        this.comp_id = comp_id;
    }

    public String getFinName() {
        return finName;
    }

    public void setFinName(String finName) {
        this.finName = finName;
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

    public void setSmDbBaseAmt(Double smDbBaseAmt) {
        this.smDbBaseAmt = smDbBaseAmt;
    }

    public String toString() {
        return new ToStringBuilder(this).append("comp_id", getComp_id()).toString();
    }

    public boolean equals(Object other) {
        if (!(other instanceof SasStudFtermCardDtl)) {
            return false;
        }
        SasStudFtermCardDtl castOther = (SasStudFtermCardDtl) other;
        return new EqualsBuilder().append(getComp_id(), castOther.getComp_id()).isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder().append(getComp_id()).toHashCode();
    }

}
