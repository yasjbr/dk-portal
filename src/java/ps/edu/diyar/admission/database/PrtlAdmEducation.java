package ps.edu.diyar.admission.database;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class PrtlAdmEducation
  implements Serializable
{
  private PrtlAdmEducationPK comp_id;
  private Date eduEndDate;
  private String specTypeNo;
  private String specNo;
  private Date eduGradeDate;
  private String ucCountry;
  private String ucGovernate;
  private String ucLocality;
  private Date timeStamp;
  
  public PrtlAdmEducation(PrtlAdmEducationPK comp_id, Date eduEndDate, String specTypeNo, String specNo, Date eduGradeDate, String ucCountry, String ucGovernate, String ucLocality, Date timeStamp)
  {
    this.comp_id = comp_id;
    this.eduEndDate = eduEndDate;
    this.specTypeNo = specTypeNo;
    this.specNo = specNo;
    this.eduGradeDate = eduGradeDate;
    this.ucCountry = ucCountry;
    this.ucGovernate = ucGovernate;
    this.ucLocality = ucLocality;
    this.timeStamp = timeStamp;
  }
  
  public PrtlAdmEducation() {}
  
  public PrtlAdmEducation(PrtlAdmEducationPK comp_id, Date eduEndDate, String specTypeNo, String specNo, Date eduGradeDate, Date timeStamp)
  {
    this.comp_id = comp_id;
    this.eduEndDate = eduEndDate;
    this.specTypeNo = specTypeNo;
    this.specNo = specNo;
    this.eduGradeDate = eduGradeDate;
    this.timeStamp = timeStamp;
  }
  
  public PrtlAdmEducationPK getComp_id()
  {
    return this.comp_id;
  }
  
  public void setComp_id(PrtlAdmEducationPK comp_id)
  {
    this.comp_id = comp_id;
  }
  
  public Date getEduEndDate()
  {
    return this.eduEndDate;
  }
  
  public void setEduEndDate(Date eduEndDate)
  {
    this.eduEndDate = eduEndDate;
  }
  
  public String getSpecTypeNo()
  {
    return this.specTypeNo;
  }
  
  public void setSpecTypeNo(String specTypeNo)
  {
    this.specTypeNo = specTypeNo;
  }
  
  public String getSpecNo()
  {
    return this.specNo;
  }
  
  public void setSpecNo(String specNo)
  {
    this.specNo = specNo;
  }
  
  public Date getEduGradeDate()
  {
    return this.eduGradeDate;
  }
  
  public void setEduGradeDate(Date eduGradeDate)
  {
    this.eduGradeDate = eduGradeDate;
  }
  
  public String getUcCountry()
  {
    return this.ucCountry;
  }
  
  public void setUcCountry(String ucCountry)
  {
    this.ucCountry = ucCountry;
  }
  
  public String getUcGovernate()
  {
    return this.ucGovernate;
  }
  
  public void setUcGovernate(String ucGovernate)
  {
    this.ucGovernate = ucGovernate;
  }
  
  public String getUcLocality()
  {
    return this.ucLocality;
  }
  
  public void setUcLocality(String ucLocality)
  {
    this.ucLocality = ucLocality;
  }
  
  public Date getTimeStamp()
  {
    return this.timeStamp;
  }
  
  public void setTimeStamp(Date timeStamp)
  {
    this.timeStamp = timeStamp;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("comp_id", getComp_id()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof PrtlAdmEducation)) {
      return false;
    }
    PrtlAdmEducation castOther = (PrtlAdmEducation)other;
    return new EqualsBuilder().append(getComp_id(), castOther.getComp_id()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getComp_id()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.admission.database.PrtlAdmEducation
 * JD-Core Version:    0.7.0.1
 */