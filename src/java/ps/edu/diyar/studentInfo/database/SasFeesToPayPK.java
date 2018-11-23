package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 *
 * @author Yaseen Jaber
 */
public class SasFeesToPayPK implements Serializable 
{
   private String studId;
   private String termNo; 
    private String finCode;

    public SasFeesToPayPK(String studId, String termNo, String finCode) {
        this.studId = studId;
        this.termNo = termNo;
        this.finCode = finCode;
    }

    public SasFeesToPayPK() {
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

    

    
     public boolean equals(Object other)
  {
    if (!(other instanceof SasFeesToPayPK)) {
      return false;
    }
    SasFeesToPayPK castOther = (SasFeesToPayPK)other;
    return new EqualsBuilder().append(getStudId(), castOther.getStudId()).append(getTermNo(), castOther.getTermNo()).append(getFinCode(), castOther.getFinCode()).isEquals();
  }
    
    public int hashCode()
  {
    return new HashCodeBuilder().append(getStudId()).append(getTermNo()).append(getFinCode()).toHashCode();
  }
    
    
      public String toString()
  {
    return new ToStringBuilder(this).append("studId", getStudId()).append("termNo", getTermNo()).append("finCode", getFinCode()).toString();
  }
    
    
    
    
    
    
    
    
}
