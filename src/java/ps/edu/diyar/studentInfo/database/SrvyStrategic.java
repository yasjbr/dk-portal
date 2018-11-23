package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class SrvyStrategic
  implements Serializable
{
  private SrvyStrategicPK comp_id;
  private String stgcHasLoan;
  private String stgcSource;
  private String stgcFamily;
  private String stgcOutsideHelp;
  private String stgcAffairs;
  private String stgcCaseNo;
  private String stgcUnrwa;
  private String stgcUnrwaNo;
  private String stgcOther;
  
  public SrvyStrategic(SrvyStrategicPK comp_id, String stgcHasLoan, String stgcSource, String stgcFamily, String stgcOutsideHelp, String stgcAffairs, String stgcCaseNo, String stgcUnrwa, String stgcUnrwaNo, String stgcOther)
  {
    this.comp_id = comp_id;
    this.stgcHasLoan = stgcHasLoan;
    this.stgcSource = stgcSource;
    this.stgcFamily = stgcFamily;
    this.stgcOutsideHelp = stgcOutsideHelp;
    this.stgcAffairs = stgcAffairs;
    this.stgcCaseNo = stgcCaseNo;
    this.stgcUnrwa = stgcUnrwa;
    this.stgcUnrwaNo = stgcUnrwaNo;
    this.stgcOther = stgcOther;
  }
  
  public SrvyStrategic() {}
  
  public SrvyStrategic(SrvyStrategicPK comp_id)
  {
    this.comp_id = comp_id;
  }
  
  public SrvyStrategicPK getComp_id()
  {
    return this.comp_id;
  }
  
  public void setComp_id(SrvyStrategicPK comp_id)
  {
    this.comp_id = comp_id;
  }
  
  public String getStgcHasLoan()
  {
    return this.stgcHasLoan;
  }
  
  public void setStgcHasLoan(String stgcHasLoan)
  {
    this.stgcHasLoan = stgcHasLoan;
  }
  
  public String getStgcSource()
  {
    return this.stgcSource;
  }
  
  public void setStgcSource(String stgcSource)
  {
    this.stgcSource = stgcSource;
  }
  
  public String getStgcFamily()
  {
    return this.stgcFamily;
  }
  
  public void setStgcFamily(String stgcFamily)
  {
    this.stgcFamily = stgcFamily;
  }
  
  public String getStgcOutsideHelp()
  {
    return this.stgcOutsideHelp;
  }
  
  public void setStgcOutsideHelp(String stgcOutsideHelp)
  {
    this.stgcOutsideHelp = stgcOutsideHelp;
  }
  
  public String getStgcAffairs()
  {
    return this.stgcAffairs;
  }
  
  public void setStgcAffairs(String stgcAffairs)
  {
    this.stgcAffairs = stgcAffairs;
  }
  
  public String getStgcCaseNo()
  {
    return this.stgcCaseNo;
  }
  
  public void setStgcCaseNo(String stgcCaseNo)
  {
    this.stgcCaseNo = stgcCaseNo;
  }
  
  public String getStgcUnrwa()
  {
    return this.stgcUnrwa;
  }
  
  public void setStgcUnrwa(String stgcUnrwa)
  {
    this.stgcUnrwa = stgcUnrwa;
  }
  
  public String getStgcUnrwaNo()
  {
    return this.stgcUnrwaNo;
  }
  
  public void setStgcUnrwaNo(String stgcUnrwaNo)
  {
    this.stgcUnrwaNo = stgcUnrwaNo;
  }
  
  public String getStgcOther()
  {
    return this.stgcOther;
  }
  
  public void setStgcOther(String stgcOther)
  {
    this.stgcOther = stgcOther;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("comp_id", getComp_id()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof SrvyStrategic)) {
      return false;
    }
    SrvyStrategic castOther = (SrvyStrategic)other;
    return new EqualsBuilder().append(getComp_id(), castOther.getComp_id()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getComp_id()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.SrvyStrategic
 * JD-Core Version:    0.7.0.1
 */