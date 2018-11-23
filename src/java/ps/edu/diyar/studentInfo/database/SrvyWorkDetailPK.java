package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class SrvyWorkDetailPK
  implements Serializable
{
  private String studId;
  private String termNo;
  private String workerType;
  
  public SrvyWorkDetailPK(String studId, String termNo, String workerType)
  {
    this.studId = studId;
    this.termNo = termNo;
    this.workerType = workerType;
  }
  
  public SrvyWorkDetailPK() {}
  
  public String getStudId()
  {
    return this.studId;
  }
  
  public void setStudId(String studId)
  {
    this.studId = studId;
  }
  
  public String getTermNo()
  {
    return this.termNo;
  }
  
  public void setTermNo(String termNo)
  {
    this.termNo = termNo;
  }
  
  public String getWorkerType()
  {
    return this.workerType;
  }
  
  public void setWorkerType(String workerType)
  {
    this.workerType = workerType;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("studId", getStudId()).append("termNo", getTermNo()).append("workerType", getWorkerType()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof SrvyWorkDetailPK)) {
      return false;
    }
    SrvyWorkDetailPK castOther = (SrvyWorkDetailPK)other;
    return new EqualsBuilder().append(getStudId(), castOther.getStudId()).append(getTermNo(), castOther.getTermNo()).append(getWorkerType(), castOther.getWorkerType()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getStudId()).append(getTermNo()).append(getWorkerType()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.SrvyWorkDetailPK
 * JD-Core Version:    0.7.0.1
 */