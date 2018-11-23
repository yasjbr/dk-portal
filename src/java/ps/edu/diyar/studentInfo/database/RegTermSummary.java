package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import java.math.BigDecimal;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RegTermSummary
  implements Serializable
{
  private RegTermSummaryPK comp_id;
  private String collegeNo;
  private String deptNo;
  private String specNo;
  private String msNo;
  private String minorNo;
  private Integer termHrs;
  private Integer termHrsPassed;
  private Integer termHrsFailed;
  private Integer termHrsW;
  private BigDecimal termPoints;
  private BigDecimal termAvg;
  private String termHonorStatus;
  private Integer specHrs;
  private Integer specHrsPassed;
  private Integer specHrsFailed;
  private Integer specHrsW;
  private Short specPoints;
  private BigDecimal specAvg;
  private String specHonorStatus;
  private short cumHrs;
  private short cumHrsPassed;
  private short cumHrsFailed;
  private short cumHrsW;
  private BigDecimal cumPoints;
  private BigDecimal cumAvg;
  private Short cumHrsTrans;
  private String warnNo;
  private String graduateStatus;
  private String levelNo;
  private String studStatus;
  private RegWarn warning;
  private RegStudStatus studentStatus;
  
  public RegTermSummary(RegTermSummaryPK comp_id, String collegeNo, String deptNo, String specNo, String msNo, String minorNo, Integer termHrs, Integer termHrsPassed, Integer termHrsFailed, Integer termHrsW, BigDecimal termPoints, BigDecimal termAvg, String termHonorStatus, Integer specHrs, Integer specHrsPassed, Integer specHrsFailed, Integer specHrsW, Short specPoints, BigDecimal specAvg, String specHonorStatus, short cumHrs, short cumHrsPassed, short cumHrsFailed, short cumHrsW, BigDecimal cumPoints, BigDecimal cumAvg, Short cumHrsTrans, String warnNo, String graduateStatus, String levelNo, String studStatus)
  {
    this.comp_id = comp_id;
    this.collegeNo = collegeNo;
    this.deptNo = deptNo;
    this.specNo = specNo;
    this.msNo = msNo;
    this.minorNo = minorNo;
    this.termHrs = termHrs;
    this.termHrsPassed = termHrsPassed;
    this.termHrsFailed = termHrsFailed;
    this.termHrsW = termHrsW;
    this.termPoints = termPoints;
    this.termAvg = termAvg;
    this.termHonorStatus = termHonorStatus;
    this.specHrs = specHrs;
    this.specHrsPassed = specHrsPassed;
    this.specHrsFailed = specHrsFailed;
    this.specHrsW = specHrsW;
    this.specPoints = specPoints;
    this.specAvg = specAvg;
    this.specHonorStatus = specHonorStatus;
    this.cumHrs = cumHrs;
    this.cumHrsPassed = cumHrsPassed;
    this.cumHrsFailed = cumHrsFailed;
    this.cumHrsW = cumHrsW;
    this.cumPoints = cumPoints;
    this.cumAvg = cumAvg;
    this.cumHrsTrans = cumHrsTrans;
    this.warnNo = warnNo;
    this.graduateStatus = graduateStatus;
    this.levelNo = levelNo;
    this.studStatus = studStatus;
  }
  
  public RegWarn getWarning()
  {
    return this.warning;
  }
  
  public void setWarning(RegWarn warning)
  {
    this.warning = warning;
  }
  
  public RegStudStatus getStudentStatus()
  {
    return this.studentStatus;
  }
  
  public void setStudentStatus(RegStudStatus studentStatus)
  {
    this.studentStatus = studentStatus;
  }
  
  public RegTermSummary() {}
  
  public RegTermSummary(RegTermSummaryPK comp_id)
  {
    this.comp_id = comp_id;
  }
  
  public RegTermSummaryPK getComp_id()
  {
    return this.comp_id;
  }
  
  public void setComp_id(RegTermSummaryPK comp_id)
  {
    this.comp_id = comp_id;
  }
  
  public String getCollegeNo()
  {
    return this.collegeNo;
  }
  
  public void setCollegeNo(String collegeNo)
  {
    this.collegeNo = collegeNo;
  }
  
  public String getDeptNo()
  {
    return this.deptNo;
  }
  
  public void setDeptNo(String deptNo)
  {
    this.deptNo = deptNo;
  }
  
  public String getSpecNo()
  {
    return this.specNo;
  }
  
  public void setSpecNo(String specNo)
  {
    this.specNo = specNo;
  }
  
  public String getMsNo()
  {
    return this.msNo;
  }
  
  public void setMsNo(String msNo)
  {
    this.msNo = msNo;
  }
  
  public String getMinorNo()
  {
    return this.minorNo;
  }
  
  public void setMinorNo(String minorNo)
  {
    this.minorNo = minorNo;
  }
  
  public Integer getTermHrs()
  {
    return this.termHrs;
  }
  
  public void setTermHrs(Integer termHrs)
  {
    this.termHrs = termHrs;
  }
  
  public Integer getTermHrsPassed()
  {
    return this.termHrsPassed;
  }
  
  public void setTermHrsPassed(Integer termHrsPassed)
  {
    this.termHrsPassed = termHrsPassed;
  }
  
  public Integer getTermHrsFailed()
  {
    return this.termHrsFailed;
  }
  
  public void setTermHrsFailed(Integer termHrsFailed)
  {
    this.termHrsFailed = termHrsFailed;
  }
  
  public Integer getTermHrsW()
  {
    return this.termHrsW;
  }
  
  public void setTermHrsW(Integer termHrsW)
  {
    this.termHrsW = termHrsW;
  }
  
  public BigDecimal getTermPoints()
  {
    return this.termPoints;
  }
  
  public void setTermPoints(BigDecimal termPoints)
  {
    this.termPoints = termPoints;
  }
  
  public BigDecimal getTermAvg()
  {
    return this.termAvg;
  }
  
  public void setTermAvg(BigDecimal termAvg)
  {
    this.termAvg = termAvg;
  }
  
  public String getTermHonorStatus()
  {
    return this.termHonorStatus;
  }
  
  public void setTermHonorStatus(String termHonorStatus)
  {
    this.termHonorStatus = termHonorStatus;
  }
  
  public Integer getSpecHrs()
  {
    return this.specHrs;
  }
  
  public void setSpecHrs(Integer specHrs)
  {
    this.specHrs = specHrs;
  }
  
  public Integer getSpecHrsPassed()
  {
    return this.specHrsPassed;
  }
  
  public void setSpecHrsPassed(Integer specHrsPassed)
  {
    this.specHrsPassed = specHrsPassed;
  }
  
  public Integer getSpecHrsFailed()
  {
    return this.specHrsFailed;
  }
  
  public void setSpecHrsFailed(Integer specHrsFailed)
  {
    this.specHrsFailed = specHrsFailed;
  }
  
  public Integer getSpecHrsW()
  {
    return this.specHrsW;
  }
  
  public void setSpecHrsW(Integer specHrsW)
  {
    this.specHrsW = specHrsW;
  }
  
  public Short getSpecPoints()
  {
    return this.specPoints;
  }
  
  public void setSpecPoints(Short specPoints)
  {
    this.specPoints = specPoints;
  }
  
  public BigDecimal getSpecAvg()
  {
    return this.specAvg;
  }
  
  public void setSpecAvg(BigDecimal specAvg)
  {
    this.specAvg = specAvg;
  }
  
  public String getSpecHonorStatus()
  {
    return this.specHonorStatus;
  }
  
  public void setSpecHonorStatus(String specHonorStatus)
  {
    this.specHonorStatus = specHonorStatus;
  }
  
  public short getCumHrs()
  {
    return this.cumHrs;
  }
  
  public void setCumHrs(short cumHrs)
  {
    this.cumHrs = cumHrs;
  }
  
  public short getCumHrsPassed()
  {
    return this.cumHrsPassed;
  }
  
  public void setCumHrsPassed(short cumHrsPassed)
  {
    this.cumHrsPassed = cumHrsPassed;
  }
  
  public short getCumHrsFailed()
  {
    return this.cumHrsFailed;
  }
  
  public void setCumHrsFailed(short cumHrsFailed)
  {
    this.cumHrsFailed = cumHrsFailed;
  }
  
  public short getCumHrsW()
  {
    return this.cumHrsW;
  }
  
  public void setCumHrsW(short cumHrsW)
  {
    this.cumHrsW = cumHrsW;
  }
  
  public BigDecimal getCumPoints()
  {
    return this.cumPoints;
  }
  
  public void setCumPoints(BigDecimal cumPoints)
  {
    this.cumPoints = cumPoints;
  }
  
  public BigDecimal getCumAvg()
  {
    return this.cumAvg;
  }
  
  public void setCumAvg(BigDecimal cumAvg)
  {
    this.cumAvg = cumAvg;
  }
  
  public Short getCumHrsTrans()
  {
    return this.cumHrsTrans;
  }
  
  public void setCumHrsTrans(Short cumHrsTrans)
  {
    this.cumHrsTrans = cumHrsTrans;
  }
  
  public String getWarnNo()
  {
    return this.warnNo;
  }
  
  public void setWarnNo(String warnNo)
  {
    this.warnNo = warnNo;
  }
  
  public String getGraduateStatus()
  {
    return this.graduateStatus;
  }
  
  public void setGraduateStatus(String graduateStatus)
  {
    this.graduateStatus = graduateStatus;
  }
  
  public String getLevelNo()
  {
    return this.levelNo;
  }
  
  public void setLevelNo(String levelNo)
  {
    this.levelNo = levelNo;
  }
  
  public String getStudStatus()
  {
    return this.studStatus;
  }
  
  public void setStudStatus(String studStatus)
  {
    this.studStatus = studStatus;
  }
  
  public String getIsGraduate()
  {
    String isGraduate = "";
    if ((this.graduateStatus == null) || (this.graduateStatus.equals("")) || (this.graduateStatus.equalsIgnoreCase("n"))) {
      isGraduate = "لا";
    } else if (this.graduateStatus.equalsIgnoreCase("y")) {
      isGraduate = "نعم";
    }
    return isGraduate;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("comp_id", getComp_id()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof RegTermSummary)) {
      return false;
    }
    RegTermSummary castOther = (RegTermSummary)other;
    return new EqualsBuilder().append(getComp_id(), castOther.getComp_id()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getComp_id()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.RegTermSummary
 * JD-Core Version:    0.7.0.1
 */