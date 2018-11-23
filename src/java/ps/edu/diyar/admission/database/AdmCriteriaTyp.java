package ps.edu.diyar.admission.database;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class AdmCriteriaTyp
  implements Serializable
{
  private AdmCriteriaTypPK comp_id;
  private String crtAName;
  private String crtLName;
  private BigDecimal crtPoints;
  private String crtStatus;
  private String userId;
  private Date timeStamp;
  private String isActive;
  private String notes;
  
  public AdmCriteriaTyp(AdmCriteriaTypPK comp_id, String crtAName, String crtLName, BigDecimal crtPoints, String crtStatus, String userId, Date timeStamp, String isActive, String notes)
  {
    this.comp_id = comp_id;
    this.crtAName = crtAName;
    this.crtLName = crtLName;
    this.crtPoints = crtPoints;
    this.crtStatus = crtStatus;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
    this.notes = notes;
  }
  
  public AdmCriteriaTyp() {}
  
  public AdmCriteriaTyp(AdmCriteriaTypPK comp_id, String crtAName, String crtLName, String crtStatus, String userId, Date timeStamp)
  {
    this.comp_id = comp_id;
    this.crtAName = crtAName;
    this.crtLName = crtLName;
    this.crtStatus = crtStatus;
    this.userId = userId;
    this.timeStamp = timeStamp;
  }
  
  public AdmCriteriaTypPK getComp_id()
  {
    return this.comp_id;
  }
  
  public void setComp_id(AdmCriteriaTypPK comp_id)
  {
    this.comp_id = comp_id;
  }
  
  public String getCrtAName()
  {
    return this.crtAName;
  }
  
  public void setCrtAName(String crtAName)
  {
    this.crtAName = crtAName;
  }
  
  public String getCrtLName()
  {
    return this.crtLName;
  }
  
  public void setCrtLName(String crtLName)
  {
    this.crtLName = crtLName;
  }
  
  public BigDecimal getCrtPoints()
  {
    return this.crtPoints;
  }
  
  public void setCrtPoints(BigDecimal crtPoints)
  {
    this.crtPoints = crtPoints;
  }
  
  public String getCrtStatus()
  {
    return this.crtStatus;
  }
  
  public void setCrtStatus(String crtStatus)
  {
    this.crtStatus = crtStatus;
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
    if (!(other instanceof AdmCriteriaTyp)) {
      return false;
    }
    AdmCriteriaTyp castOther = (AdmCriteriaTyp)other;
    return new EqualsBuilder().append(getComp_id(), castOther.getComp_id()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getComp_id()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.admission.database.AdmCriteriaTyp
 * JD-Core Version:    0.7.0.1
 */