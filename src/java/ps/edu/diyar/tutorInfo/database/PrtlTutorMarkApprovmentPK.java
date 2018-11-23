package ps.edu.diyar.tutorInfo.database;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class PrtlTutorMarkApprovmentPK
  implements Serializable
{
  private String termNo;
  private String crsNo;
  private String classNo;
  
  public PrtlTutorMarkApprovmentPK(String termNo, String crsNo, String classNo)
  {
    this.termNo = termNo;
    this.crsNo = crsNo;
    this.classNo = classNo;
  }
  
  public PrtlTutorMarkApprovmentPK() {}
  
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
  
  public String getClassNo()
  {
    return this.classNo;
  }
  
  public void setClassNo(String classNo)
  {
    this.classNo = classNo;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("termNo", getTermNo()).append("crsNo", getCrsNo()).append("classNo", getClassNo()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof PrtlTutorMarkApprovmentPK)) {
      return false;
    }
    PrtlTutorMarkApprovmentPK castOther = (PrtlTutorMarkApprovmentPK)other;
    return new EqualsBuilder().append(getTermNo(), castOther.getTermNo()).append(getCrsNo(), castOther.getCrsNo()).append(getClassNo(), castOther.getClassNo()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getTermNo()).append(getCrsNo()).append(getClassNo()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.tutorInfo.database.PrtlTutorMarkApprovmentPK
 * JD-Core Version:    0.7.0.1
 */