package ps.edu.diyar.admission.database;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class AdmAppsCriteriaPK
  implements Serializable
{
  private String applId;
  private short crtYear;
  private String specNo;
  private byte crtId;
  
  public AdmAppsCriteriaPK(String applId, short crtYear, String specNo, byte crtId)
  {
    this.applId = applId;
    this.crtYear = crtYear;
    this.specNo = specNo;
    this.crtId = crtId;
  }
  
  public AdmAppsCriteriaPK() {}
  
  public String getApplId()
  {
    return this.applId;
  }
  
  public void setApplId(String applId)
  {
    this.applId = applId;
  }
  
  public short getCrtYear()
  {
    return this.crtYear;
  }
  
  public void setCrtYear(short crtYear)
  {
    this.crtYear = crtYear;
  }
  
  public String getSpecNo()
  {
    return this.specNo;
  }
  
  public void setSpecNo(String specNo)
  {
    this.specNo = specNo;
  }
  
  public byte getCrtId()
  {
    return this.crtId;
  }
  
  public void setCrtId(byte crtId)
  {
    this.crtId = crtId;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("applId", getApplId()).append("crtYear", getCrtYear()).append("specNo", getSpecNo()).append("crtId", getCrtId()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof AdmAppsCriteriaPK)) {
      return false;
    }
    AdmAppsCriteriaPK castOther = (AdmAppsCriteriaPK)other;
    return new EqualsBuilder().append(getApplId(), castOther.getApplId()).append(getCrtYear(), castOther.getCrtYear()).append(getSpecNo(), castOther.getSpecNo()).append(getCrtId(), castOther.getCrtId()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getApplId()).append(getCrtYear()).append(getSpecNo()).append(getCrtId()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.admission.database.AdmAppsCriteriaPK
 * JD-Core Version:    0.7.0.1
 */