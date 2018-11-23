package ps.edu.diyar.admission.database;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class PrtlAdmEducationPK
  implements Serializable
{
  private String ucNo;
  private String appNo;
  private Date eduStartDate;
  
  public PrtlAdmEducationPK(String ucNo, String appNo, Date eduStartDate)
  {
    this.ucNo = ucNo;
    this.appNo = appNo;
    this.eduStartDate = eduStartDate;
  }
  
  public PrtlAdmEducationPK() {}
  
  public String getUcNo()
  {
    return this.ucNo;
  }
  
  public void setUcNo(String ucNo)
  {
    this.ucNo = ucNo;
  }
  
  public String getAppNo()
  {
    return this.appNo;
  }
  
  public void setAppNo(String appNo)
  {
    this.appNo = appNo;
  }
  
  public Date getEduStartDate()
  {
    return this.eduStartDate;
  }
  
  public void setEduStartDate(Date eduStartDate)
  {
    this.eduStartDate = eduStartDate;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("ucNo", getUcNo()).append("appNo", getAppNo()).append("eduStartDate", getEduStartDate()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof PrtlAdmEducationPK)) {
      return false;
    }
    PrtlAdmEducationPK castOther = (PrtlAdmEducationPK)other;
    return new EqualsBuilder().append(getUcNo(), castOther.getUcNo()).append(getAppNo(), castOther.getAppNo()).append(getEduStartDate(), castOther.getEduStartDate()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getUcNo()).append(getAppNo()).append(getEduStartDate()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.admission.database.PrtlAdmEducationPK
 * JD-Core Version:    0.7.0.1
 */