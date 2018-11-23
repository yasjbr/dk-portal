package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class SrvyAcademicDetail
  implements Serializable
{
  private SrvyAcademicDetailPK comp_id;
  private String relativeAName;
  private Date enroleDate;
  private String collegeNo;
  private Double yearlyCost;
  private String countryNo;
  private String donarAName;
  private String relativeStudNo;
  private String schoolNo;
  private String schoolType;
  
  public SrvyAcademicDetail(SrvyAcademicDetailPK comp_id, String relativeAName, Date enroleDate, String collegeNo, Double yearlyCost, String donarAName, String relativeStudNo, String schoolNo, String schoolType)
  {
    this.comp_id = comp_id;
    this.relativeAName = relativeAName;
    this.enroleDate = enroleDate;
    this.collegeNo = collegeNo;
    this.yearlyCost = yearlyCost;
    this.donarAName = donarAName;
    this.relativeStudNo = relativeStudNo;
    this.schoolNo = schoolNo;
    this.schoolType = schoolType;
  }
  
  public SrvyAcademicDetail() {}
  
  public SrvyAcademicDetail(SrvyAcademicDetailPK comp_id)
  {
    this.comp_id = comp_id;
  }
  
  public String getCountryNo()
  {
    return this.countryNo;
  }
  
  public void setCountryNo(String countryNo)
  {
    this.countryNo = countryNo;
  }
  
  public SrvyAcademicDetailPK getComp_id()
  {
    return this.comp_id;
  }
  
  public void setComp_id(SrvyAcademicDetailPK comp_id)
  {
    this.comp_id = comp_id;
  }
  
  public String getRelativeAName()
  {
    return this.relativeAName;
  }
  
  public void setRelativeAName(String relativeAName)
  {
    this.relativeAName = relativeAName;
  }
  
  public Date getEnroleDate()
  {
    return this.enroleDate;
  }
  
  public void setEnroleDate(Date enroleDate)
  {
    this.enroleDate = enroleDate;
  }
  
  public String getCollegeNo()
  {
    return this.collegeNo;
  }
  
  public void setCollegeNo(String collegeNo)
  {
    this.collegeNo = collegeNo;
  }
  
  public Double getYearlyCost()
  {
    return this.yearlyCost;
  }
  
  public void setYearlyCost(Double yearlyCost)
  {
    this.yearlyCost = yearlyCost;
  }
  
  public String getDonarAName()
  {
    return this.donarAName;
  }
  
  public void setDonarAName(String donarAName)
  {
    this.donarAName = donarAName;
  }
  
  public String getRelativeStudNo()
  {
    return this.relativeStudNo;
  }
  
  public void setRelativeStudNo(String relativeStudNo)
  {
    this.relativeStudNo = relativeStudNo;
  }
  
  public String getSchoolNo()
  {
    return this.schoolNo;
  }
  
  public void setSchoolNo(String schoolNo)
  {
    this.schoolNo = schoolNo;
  }
  
  public String getSchoolType()
  {
    return this.schoolType;
  }
  
  public void setSchoolType(String schoolType)
  {
    this.schoolType = schoolType;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("comp_id", getComp_id()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof SrvyAcademicDetail)) {
      return false;
    }
    SrvyAcademicDetail castOther = (SrvyAcademicDetail)other;
    return new EqualsBuilder().append(getComp_id(), castOther.getComp_id()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getComp_id()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.SrvyAcademicDetail
 * JD-Core Version:    0.7.0.1
 */