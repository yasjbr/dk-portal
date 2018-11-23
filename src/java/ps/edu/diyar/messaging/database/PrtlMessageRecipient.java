package ps.edu.diyar.messaging.database;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class PrtlMessageRecipient
  implements Serializable
{
  private PrtlMessageRecipientPK comp_id;
  private String viewed;
  private Date viewDate;
  private String computerIp;
   private String deleted;
    private String deleteDate;
  
  public PrtlMessageRecipient(PrtlMessageRecipientPK comp_id, String viewed, Date viewDate, String computerIp,String deleted,String deleteDate)
  {
    this.comp_id = comp_id;
    this.viewed = viewed;
    this.viewDate = viewDate;
    this.computerIp = computerIp;
    this.deleted = deleted;
    this.deleteDate=deleteDate;
  }

    public String getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(String deleteDate) {
        this.deleteDate = deleteDate;
    }
  
  
  
  
  public PrtlMessageRecipient() {}
  
  public PrtlMessageRecipient(PrtlMessageRecipientPK comp_id, String viewed)
  {
    this.comp_id = comp_id;
    this.viewed = viewed;
  }
  
  public PrtlMessageRecipientPK getComp_id()
  {
    return this.comp_id;
  }
  
  public void setComp_id(PrtlMessageRecipientPK comp_id)
  {
    this.comp_id = comp_id;
  }
  
  public String getViewed()
  {
    return this.viewed;
  }
  
  public void setViewed(String viewed)
  {
    this.viewed = viewed;
  }
  
  public Date getViewDate()
  {
    return this.viewDate;
  }
  
  public void setViewDate(Date viewDate)
  {
    this.viewDate = viewDate;
  }
  
  public String getComputerIp()
  {
    return this.computerIp;
  }
  
  public void setComputerIp(String computerIp)
  {
    this.computerIp = computerIp;
  }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }
  
  
  
  
  public String toString()
  {
    return new ToStringBuilder(this).append("comp_id", getComp_id()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof PrtlMessageRecipient)) {
      return false;
    }
    PrtlMessageRecipient castOther = (PrtlMessageRecipient)other;
    return new EqualsBuilder().append(getComp_id(), castOther.getComp_id()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getComp_id()).toHashCode();
  }
}


 