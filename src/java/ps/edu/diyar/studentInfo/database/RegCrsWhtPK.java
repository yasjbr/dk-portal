package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RegCrsWhtPK
  implements Serializable
{
   
  private String termNo;
  private String crsNo;
  
  public RegCrsWhtPK(  String termNo, String crsNo)
  {
    
    this.termNo = termNo;
    this.crsNo = crsNo;
  }
  
  public RegCrsWhtPK() {}
  
  
  
  public String getTermNo()
  {
    return this.termNo;
  }
  
  public void setTermNo(String termNo)
  {
    this.termNo = termNo;
  }
  
  public String getCrsNo()
  {
    return this.crsNo;
  }
  
  public void setCrsNo(String crsNo)
  {
    this.crsNo = crsNo;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("termNo", getTermNo()).append("crsNo", getCrsNo()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof RegCrsWhtPK)) {
      return false;
    }
    RegCrsWhtPK castOther = (RegCrsWhtPK)other;
    return new EqualsBuilder().append(getTermNo(), castOther.getTermNo()).append(getCrsNo(), castOther.getCrsNo()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getTermNo()).append(getCrsNo()).toHashCode();
  }
}


 