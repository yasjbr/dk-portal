package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class SrvyAcademicDetailVwPK
  implements Serializable
{
  private String studId;
  private String termNo;
  private String relativeType;
  private String academicSeq;
  
  public SrvyAcademicDetailVwPK(String studId, String termNo, String relativeType, String academicSeq)
  {
    this.studId = studId;
    this.termNo = termNo;
    this.relativeType = relativeType;
    this.academicSeq = academicSeq;
  }
  
  public SrvyAcademicDetailVwPK() {}
  
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
  
  public String getRelativeType()
  {
    return this.relativeType;
  }
  
  public void setRelativeType(String relativeType)
  {
    this.relativeType = relativeType;
  }
  
  public String getAcademicSeq()
  {
    return this.academicSeq;
  }
  
  public void setAcademicSeq(String academicSeq)
  {
    this.academicSeq = academicSeq;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("studId", getStudId()).append("termNo", getTermNo()).append("relativeType", getRelativeType()).append("academicSeq", getAcademicSeq()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof SrvyAcademicDetailPK)) {
      return false;
    }
    SrvyAcademicDetailPK castOther = (SrvyAcademicDetailPK)other;
    return new EqualsBuilder().append(getStudId(), castOther.getStudId()).append(getTermNo(), castOther.getTermNo()).append(getRelativeType(), castOther.getRelativeType()).append(getAcademicSeq(), castOther.getAcademicSeq()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getStudId()).append(getTermNo()).append(getRelativeType()).append(getAcademicSeq()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.SrvyAcademicDetailVwPK
 * JD-Core Version:    0.7.0.1
 */