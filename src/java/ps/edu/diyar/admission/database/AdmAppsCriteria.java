package ps.edu.diyar.admission.database;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class AdmAppsCriteria
  implements Serializable
{
  private AdmAppsCriteriaPK comp_id;
  private BigDecimal crtPoints;
  private BigDecimal appsCrtPoints;
  private String userId;
  private Date timeStamp;
  private String isActive;
  private String notes;
  
  public AdmAppsCriteria(AdmAppsCriteriaPK comp_id, BigDecimal crtPoints, BigDecimal appsCrtPoints, String userId, Date timeStamp, String isActive, String notes)
  {
    this.comp_id = comp_id;
    this.crtPoints = crtPoints;
    this.appsCrtPoints = appsCrtPoints;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
    this.notes = notes;
  }
  
  public AdmAppsCriteria() {}
  
  public AdmAppsCriteria(AdmAppsCriteriaPK comp_id, String userId, Date timeStamp)
  {
    this.comp_id = comp_id;
    this.userId = userId;
    this.timeStamp = timeStamp;
  }
  
  public AdmAppsCriteriaPK getComp_id()
  {
    return this.comp_id;
  }
  
  public void setComp_id(AdmAppsCriteriaPK comp_id)
  {
    this.comp_id = comp_id;
  }
  
  public BigDecimal getCrtPoints()
  {
    return this.crtPoints;
  }
  
  public void setCrtPoints(BigDecimal crtPoints)
  {
    this.crtPoints = crtPoints;
  }
  
  public BigDecimal getAppsCrtPoints()
  {
    return this.appsCrtPoints;
  }
  
  public void setAppsCrtPoints(BigDecimal appsCrtPoints)
  {
    this.appsCrtPoints = appsCrtPoints;
  }
  
  public String getUserId()
  {
    return this.userId;
  }
  
  public void setUserId(String userId)
  {
    this.userId = userId;
  }
  
  public Date getTimeStamp()
  {
    return this.timeStamp;
  }
  
  public void setTimeStamp(Date timeStamp)
  {
    this.timeStamp = timeStamp;
  }
  
  public String getIsActive()
  {
    return this.isActive;
  }
  
  public void setIsActive(String isActive)
  {
    this.isActive = isActive;
  }
  
  public String getNotes()
  {
    return this.notes;
  }
  
  public void setNotes(String notes)
  {
    this.notes = notes;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("comp_id", getComp_id()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof AdmAppsCriteria)) {
      return false;
    }
    AdmAppsCriteria castOther = (AdmAppsCriteria)other;
    return new EqualsBuilder().append(getComp_id(), castOther.getComp_id()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getComp_id()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.admission.database.AdmAppsCriteria
 * JD-Core Version:    0.7.0.1
 */