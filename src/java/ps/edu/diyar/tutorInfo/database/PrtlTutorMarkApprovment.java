package ps.edu.diyar.tutorInfo.database;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class PrtlTutorMarkApprovment
  implements Serializable
{
  private PrtlTutorMarkApprovmentPK comp_id;
  private String tutorNo;
  private String approve;
  private String userId;
  private Date timeStamp;
  private String computerIp;
  
  public PrtlTutorMarkApprovment(PrtlTutorMarkApprovmentPK comp_id, String tutorNo, String approve, String userId, Date timeStamp, String computerIp)
  {
    this.comp_id = comp_id;
    this.tutorNo = tutorNo;
    this.approve = approve;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.computerIp = computerIp;
  }
  
  public PrtlTutorMarkApprovment() {}
  
  public PrtlTutorMarkApprovment(PrtlTutorMarkApprovmentPK comp_id, String approve)
  {
    this.comp_id = comp_id;
    this.approve = approve;
  }
  
  public PrtlTutorMarkApprovmentPK getComp_id()
  {
    return this.comp_id;
  }
  
  public void setComp_id(PrtlTutorMarkApprovmentPK comp_id)
  {
    this.comp_id = comp_id;
  }
  
  public String getTutorNo()
  {
    return this.tutorNo;
  }
  
  public void setTutorNo(String tutorNo)
  {
    this.tutorNo = tutorNo;
  }
  
  public String getApprove()
  {
    return this.approve;
  }
  
  public void setApprove(String approve)
  {
    this.approve = approve;
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
  
  public String getComputerIp()
  {
    return this.computerIp;
  }
  
  public void setComputerIp(String computerIp)
  {
    this.computerIp = computerIp;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("comp_id", getComp_id()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof PrtlTutorMarkApprovment)) {
      return false;
    }
    PrtlTutorMarkApprovment castOther = (PrtlTutorMarkApprovment)other;
    return new EqualsBuilder().append(getComp_id(), castOther.getComp_id()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getComp_id()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.tutorInfo.database.PrtlTutorMarkApprovment
 * JD-Core Version:    0.7.0.1
 */