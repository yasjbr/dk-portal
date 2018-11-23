package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class SasStudFtermCard
  implements Serializable
{
  private SasStudFtermCardPK comp_id;
  private Double dbBaseAmt;
  private Double crBaseAmt;
  private Double baseTermBalance;
  private String userId;
  private Date timeStamp;
  private String notes;
  private Double schlrValue;
  
  public SasStudFtermCard(SasStudFtermCardPK comp_id, Double dbBaseAmt, Double crBaseAmt, Double baseTermBalance, String userId, Date timeStamp, String notes,Double schlrValue)
  {
    this.comp_id = comp_id;
    this.dbBaseAmt = dbBaseAmt;
     this.schlrValue = schlrValue;
    this.crBaseAmt = crBaseAmt;
    this.baseTermBalance = baseTermBalance;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.notes = notes;
  }
  
  public SasStudFtermCard() {}
  
  public SasStudFtermCard(SasStudFtermCardPK comp_id, String userId, Date timeStamp)
  {
    this.comp_id = comp_id;
    this.userId = userId;
    this.timeStamp = timeStamp;
  }
  
  public SasStudFtermCardPK getComp_id()
  {
    return this.comp_id;
  }
  
  public void setComp_id(SasStudFtermCardPK comp_id)
  {
    this.comp_id = comp_id;
  }
  
  public Double getDbBaseAmt()
  {
    return this.dbBaseAmt;
  }

    public Double getSchlrValue() {
        return schlrValue;
    }

    public void setSchlrValue(Double schlrValue) {
        this.schlrValue = schlrValue;
    }
  
  
  
  public void setDbBaseAmt(Double dbBaseAmt)
  {
    this.dbBaseAmt = dbBaseAmt;
  }
  
  public Double getCrBaseAmt()
  {
    return this.crBaseAmt;
  }
  
  public void setCrBaseAmt(Double crBaseAmt)
  {
    this.crBaseAmt = crBaseAmt;
  }
  
  public Double getBaseTermBalance()
  {
    return this.baseTermBalance;
  }
  
  public void setBaseTermBalance(Double baseTermBalance)
  {
    this.baseTermBalance = baseTermBalance;
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
  
  public String getNotes()
  {
    return this.notes;
  }
  
  public void setNotes(String notes)
  {
    this.notes = notes;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("comp_id", getComp_id()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof SasStudFtermCard)) {
      return false;
    }
    SasStudFtermCard castOther = (SasStudFtermCard)other;
    return new EqualsBuilder().append(getComp_id(), castOther.getComp_id()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getComp_id()).toHashCode();
  }
}
