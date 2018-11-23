package ps.edu.diyar.admission.database;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class AdmAppsExceptionPK
  implements Serializable
{
  private String applId;
  private byte expId;
  
  public AdmAppsExceptionPK(String applId, byte expId)
  {
    this.applId = applId;
    this.expId = expId;
  }
  
  public AdmAppsExceptionPK() {}
  
  public String getApplId()
  {
    return this.applId;
  }
  
  public void setApplId(String applId)
  {
    this.applId = applId;
  }
  
  public byte getExpId()
  {
    return this.expId;
  }
  
  public void setExpId(byte expId)
  {
    this.expId = expId;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("applId", getApplId()).append("expId", getExpId()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof AdmAppsExceptionPK)) {
      return false;
    }
    AdmAppsExceptionPK castOther = (AdmAppsExceptionPK)other;
    return new EqualsBuilder().append(getApplId(), castOther.getApplId()).append(getExpId(), castOther.getExpId()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getApplId()).append(getExpId()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.admission.database.AdmAppsExceptionPK
 * JD-Core Version:    0.7.0.1
 */