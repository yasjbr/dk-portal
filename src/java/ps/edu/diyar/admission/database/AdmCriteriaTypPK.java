package ps.edu.diyar.admission.database;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class AdmCriteriaTypPK
  implements Serializable
{
  private String specNo;
  private short crtYear;
  private byte crtId;
  
  public AdmCriteriaTypPK(String specNo, short crtYear, byte crtId)
  {
    this.specNo = specNo;
    this.crtYear = crtYear;
    this.crtId = crtId;
  }
  
  public AdmCriteriaTypPK() {}
  
  public String getSpecNo()
  {
    return this.specNo;
  }
  
  public void setSpecNo(String specNo)
  {
    this.specNo = specNo;
  }
  
  public short getCrtYear()
  {
    return this.crtYear;
  }
  
  public void setCrtYear(short crtYear)
  {
    this.crtYear = crtYear;
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
    return new ToStringBuilder(this).append("specNo", getSpecNo()).append("crtYear", getCrtYear()).append("crtId", getCrtId()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof AdmCriteriaTypPK)) {
      return false;
    }
    AdmCriteriaTypPK castOther = (AdmCriteriaTypPK)other;
    return new EqualsBuilder().append(getSpecNo(), castOther.getSpecNo()).append(getCrtYear(), castOther.getCrtYear()).append(getCrtId(), castOther.getCrtId()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getSpecNo()).append(getCrtYear()).append(getCrtId()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.admission.database.AdmCriteriaTypPK
 * JD-Core Version:    0.7.0.1
 */