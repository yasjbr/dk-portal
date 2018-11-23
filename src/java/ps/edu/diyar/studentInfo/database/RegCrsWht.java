package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RegCrsWht
        implements Serializable {

    private RegCrsWhtPK comp_id;
    private String first;
    private String second;
    private String mid;
    private String practical;
    private String finalm;
    private String userId;
    private Date timeStamp;
    private String isActive;
    private String notes;

    public RegCrsWht(RegCrsWhtPK comp_id, String first, String second, String finalm, String practical, String mid, String userId, Date timeStamp, String isActive, String notes) {

        this.first = first;
        this.second = second;
        this.mid = mid;
        this.finalm = finalm;
        this.practical = practical;

        this.userId = userId;
        this.timeStamp = timeStamp;
        this.isActive = isActive;
        this.notes = notes;
    }

    public RegCrsWht() {
    }

    public RegCrsWht(RegCrsWhtPK comp_id, String userId, Date timeStamp, String isActive) {
        this.comp_id = comp_id;
        this.userId = userId;
        this.timeStamp = timeStamp;
        this.isActive = isActive;
    }

    public RegCrsWhtPK getComp_id() {
        return this.comp_id;
    }

    public void setComp_id(RegCrsWhtPK comp_id) {
        this.comp_id = comp_id;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getPractical() {
        return practical;
    }

    public void setPractical(String practical) {
        this.practical = practical;
    }

    public String getFinalm() {
        return finalm;
    }

    public void setFinalm(String finalm) {
        this.finalm = finalm;
    }

    public Date getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getIsActive() {
        return this.isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String toString() {
        return new ToStringBuilder(this).append("comp_id", getComp_id()).toString();
    }

    public boolean equals(Object other) {
        if (!(other instanceof RegCrsWht)) {
            return false;
        }
        RegCrsWht castOther = (RegCrsWht) other;
        return new EqualsBuilder().append(getComp_id(), castOther.getComp_id()).isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder().append(getComp_id()).toHashCode();
    }
}
