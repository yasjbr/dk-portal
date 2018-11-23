/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 *
 * @author Yaseen Jaber
 */
public class RegStudGuidePK   implements Serializable
{
  private String termNo;
  private String studId;
  private String msCrsType;
  private String crsNo;

    public String getTermNo() {
        return termNo;
    }

    public void setTermNo(String termNo) {
        this.termNo = termNo;
    }

    public String getStudId() {
        return studId;
    }

    public void setStudId(String studId) {
        this.studId = studId;
    }

    public String getMsCrsType() {
        return msCrsType;
    }

    public void setMsCrsType(String msCrsType) {
        this.msCrsType = msCrsType;
    }

    public String getCrsNo() {
        return crsNo;
    }

    public void setCrsNo(String crsNo) {
        this.crsNo = crsNo;
    }

    public RegStudGuidePK(String termNo, String studId, String msCrsType, String crsNo) {
        this.termNo = termNo;
        this.studId = studId;
        this.msCrsType = msCrsType;
        this.crsNo = crsNo;
    }

    public RegStudGuidePK() {
    }

    public int hashCode()
  {
    return new HashCodeBuilder().append(getCrsNo()).append(getMsCrsType()).append(getStudId()).append(getTermNo()).toHashCode();
  }

  public boolean equals(Object other)
  {
    if (!(other instanceof RegMsDtlPK)) {
      return false;
    }
    RegStudGuidePK castOther = (RegStudGuidePK)other;
    return new EqualsBuilder().append(getStudId(), castOther.getStudId()).append(getTermNo(), castOther.getTermNo()).append(getMsCrsType(), castOther.getMsCrsType()).append(getCrsNo(), castOther.getCrsNo()).isEquals();
  }

    
  
    
      public String toString()
  {
    return new ToStringBuilder(this).append("studId", getStudId()).append("termNo", getTermNo()).append("msCrsType", getMsCrsType()).append("crsNo", getCrsNo()).toString();
  }
}
