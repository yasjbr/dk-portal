package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class PrtlRegStudApprove
  implements Serializable
{
  private PrtlRegStudApprovePK comp_id;
  private String regSave;
  private Date regSaveDate;
  private String regApp;
  private Date regAppDate;
  private String userId;
  private String computerIp;
  
  public PrtlRegStudApprove(PrtlRegStudApprovePK comp_id, String regSave, Date regSaveDate, String regApp, Date regAppDate, String userId, String computerIp)
  {
    this.comp_id = comp_id;
    this.regSave = regSave;
    this.regSaveDate = regSaveDate;
    this.regApp = regApp;
    this.regAppDate = regAppDate;
    this.userId = userId;
    this.computerIp = computerIp;
  }
  
  public PrtlRegStudApprove() {}
  
  public PrtlRegStudApprove(PrtlRegStudApprovePK comp_id)
  {
    this.comp_id = comp_id;
  }
  
  public PrtlRegStudApprovePK getComp_id()
  {
    return this.comp_id;
  }
  
  public void setComp_id(PrtlRegStudApprovePK comp_id)
  {
    this.comp_id = comp_id;
  }
  
  public String getRegSave()
  {
    return this.regSave;
  }
  
  public void setRegSave(String regSave)
  {
    this.regSave = regSave;
  }
  
  public Date getRegSaveDate()
  {
    return this.regSaveDate;
  }
  
  public void setRegSaveDate(Date regSaveDate)
  {
    this.regSaveDate = regSaveDate;
  }
  
  public String getRegApp()
  {
    return this.regApp;
  }
  
  public void setRegApp(String regApp)
  {
    this.regApp = regApp;
  }
  
  public Date getRegAppDate()
  {
    return this.regAppDate;
  }
  
  public void setRegAppDate(Date regAppDate)
  {
    this.regAppDate = regAppDate;
  }
  
  public String getUserId()
  {
    return this.userId;
  }
  
  public void setUserId(String userId)
  {
    this.userId = userId;
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
    if (!(other instanceof PrtlRegStudApprove)) {
      return false;
    }
    PrtlRegStudApprove castOther = (PrtlRegStudApprove)other;
    return new EqualsBuilder().append(getComp_id(), castOther.getComp_id()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getComp_id()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.PrtlRegStudApprove
 * JD-Core Version:    0.7.0.1
 */