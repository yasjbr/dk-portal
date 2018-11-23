package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RegSetting
  implements Serializable
{
  private String termNo;
  private Integer termMinCrHrsD;
  private Integer termMaxCrHrsD;
  private Integer termMinCrHrsB;
  private Integer termMaxCrHrsB;
  private Integer summerMinCrHrsD;
  private Integer summerMaxCrHrsD;
  private Integer summerMinCrHrsB;
  private Integer summerMaxCrHrsB;
  private Integer warnedMaxCrHrs;
  
  public RegSetting(String termNo, Integer termMinCrHrsD, Integer termMaxCrHrsD, Integer termMinCrHrsB, Integer termMaxCrHrsB, Integer summerMinCrHrsD, Integer summerMaxCrHrsD, Integer summerMinCrHrsB, Integer summerMaxCrHrsB, Integer warnedMaxCrHrs)
  {
    this.termNo = termNo;
    this.termMinCrHrsD = termMinCrHrsD;
    this.termMaxCrHrsD = termMaxCrHrsD;
    this.termMinCrHrsB = termMinCrHrsB;
    this.termMaxCrHrsB = termMaxCrHrsB;
    this.summerMinCrHrsD = summerMinCrHrsD;
    this.summerMaxCrHrsD = summerMaxCrHrsD;
    this.summerMinCrHrsB = summerMinCrHrsB;
    this.summerMaxCrHrsB = summerMaxCrHrsB;
    this.warnedMaxCrHrs = warnedMaxCrHrs;
  }
  
  public RegSetting() {}
  
  public String getTermNo()
  {
    return this.termNo;
  }
  
  public void setTermNo(String termNo)
  {
    this.termNo = termNo;
  }
  
  public Integer getTermMinCrHrsD()
  {
    return this.termMinCrHrsD;
  }
  
  public void setTermMinCrHrsD(Integer termMinCrHrsD)
  {
    this.termMinCrHrsD = termMinCrHrsD;
  }
  
  public Integer getTermMaxCrHrsD()
  {
    return this.termMaxCrHrsD;
  }
  
  public void setTermMaxCrHrsD(Integer termMaxCrHrsD)
  {
    this.termMaxCrHrsD = termMaxCrHrsD;
  }
  
  public Integer getTermMinCrHrsB()
  {
    return this.termMinCrHrsB;
  }
  
  public void setTermMinCrHrsB(Integer termMinCrHrsB)
  {
    this.termMinCrHrsB = termMinCrHrsB;
  }
  
  public Integer getTermMaxCrHrsB()
  {
    return this.termMaxCrHrsB;
  }
  
  public void setTermMaxCrHrsB(Integer termMaxCrHrsB)
  {
    this.termMaxCrHrsB = termMaxCrHrsB;
  }
  
  public Integer getSummerMinCrHrsD()
  {
    return this.summerMinCrHrsD;
  }
  
  public void setSummerMinCrHrsD(Integer summerMinCrHrsD)
  {
    this.summerMinCrHrsD = summerMinCrHrsD;
  }
  
  public Integer getSummerMaxCrHrsD()
  {
    return this.summerMaxCrHrsD;
  }
  
  public void setSummerMaxCrHrsD(Integer summerMaxCrHrsD)
  {
    this.summerMaxCrHrsD = summerMaxCrHrsD;
  }
  
  public Integer getSummerMinCrHrsB()
  {
    return this.summerMinCrHrsB;
  }
  
  public void setSummerMinCrHrsB(Integer summerMinCrHrsB)
  {
    this.summerMinCrHrsB = summerMinCrHrsB;
  }
  
  public Integer getSummerMaxCrHrsB()
  {
    return this.summerMaxCrHrsB;
  }
  
  public void setSummerMaxCrHrsB(Integer summerMaxCrHrsB)
  {
    this.summerMaxCrHrsB = summerMaxCrHrsB;
  }
  
  public Integer getWarnedMaxCrHrs()
  {
    return this.warnedMaxCrHrs;
  }
  
  public void setWarnedMaxCrHrs(Integer warnedMaxCrHrs)
  {
    this.warnedMaxCrHrs = warnedMaxCrHrs;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("termNo", getTermNo()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof RegSetting)) {
      return false;
    }
    RegSetting castOther = (RegSetting)other;
    return new EqualsBuilder().append(getTermNo(), castOther.getTermNo()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getTermNo()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.RegSetting
 * JD-Core Version:    0.7.0.1
 */