package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;

public class SrvyAcademicDetailVw
  implements Serializable
{
  private SrvyAcademicDetailVwPK comp_id;
  private String relativeAName;
  private Date enroleDate;
  private String collegeNo;
  private String ucAName;
  private String countryNo;
  private String countryAName;
  private Double yearlyCost;
  private String donarAName;
  private String relativeStudNo;
  private String schoolNo;
  private String schoolAName;
  private String schoolType;
  
  public SrvyAcademicDetailVwPK getComp_id()
  {
    return this.comp_id;
  }
  
  public void setComp_id(SrvyAcademicDetailVwPK comp_id)
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
  
  public String getUcAName()
  {
    return this.ucAName;
  }
  
  public void setUcAName(String ucAName)
  {
    this.ucAName = ucAName;
  }
  
  public String getCountryNo()
  {
    return this.countryNo;
  }
  
  public void setCountryNo(String countryNo)
  {
    this.countryNo = countryNo;
  }
  
  public String getCountryAName()
  {
    return this.countryAName;
  }
  
  public void setCountryAName(String countryAName)
  {
    this.countryAName = countryAName;
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
  
  public String getSchoolAName()
  {
    return this.schoolAName;
  }
  
  public void setSchoolAName(String schoolAName)
  {
    this.schoolAName = schoolAName;
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
    return new ToStringBuilder(this).toString();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.SrvyAcademicDetailVw
 * JD-Core Version:    0.7.0.1
 */