package ps.edu.diyar.admission.database;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class PrtlAdmLanguagePK
  implements Serializable
{
  private String appNo;
  private String langNo;
  
  public PrtlAdmLanguagePK(String appNo, String langNo)
  {
    this.appNo = appNo;
    this.langNo = langNo;
  }
  
  public PrtlAdmLanguagePK() {}
  
  public String getAppNo()
  {
    return this.appNo;
  }
  
  public void setAppNo(String appNo)
  {
    this.appNo = appNo;
  }
  
  public String getLangNo()
  {
    return this.langNo;
  }
  
  public void setLangNo(String langNo)
  {
    this.langNo = langNo;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("appNo", getAppNo()).append("langNo", getLangNo()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof PrtlAdmLanguagePK)) {
      return false;
    }
    PrtlAdmLanguagePK castOther = (PrtlAdmLanguagePK)other;
    return new EqualsBuilder().append(getAppNo(), castOther.getAppNo()).append(getLangNo(), castOther.getLangNo()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getAppNo()).append(getLangNo()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.admission.database.PrtlAdmLanguagePK
 * JD-Core Version:    0.7.0.1
 */