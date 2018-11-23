package ps.edu.diyar.admission.database;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class PrtlAdmLanguage
  implements Serializable
{
  private PrtlAdmLanguagePK comp_id;
  private String readLevelNo;
  private String writeLevelNo;
  private String speakLevelNo;
  private Date timeStamp;
  
  public PrtlAdmLanguage(PrtlAdmLanguagePK comp_id, String readLevelNo, String writeLevelNo, String speakLevelNo, Date timeStamp)
  {
    this.comp_id = comp_id;
    this.readLevelNo = readLevelNo;
    this.writeLevelNo = writeLevelNo;
    this.speakLevelNo = speakLevelNo;
    this.timeStamp = timeStamp;
  }
  
  public PrtlAdmLanguage() {}
  
  public PrtlAdmLanguagePK getComp_id()
  {
    return this.comp_id;
  }
  
  public void setComp_id(PrtlAdmLanguagePK comp_id)
  {
    this.comp_id = comp_id;
  }
  
  public String getReadLevelNo()
  {
    return this.readLevelNo;
  }
  
  public void setReadLevelNo(String readLevelNo)
  {
    this.readLevelNo = readLevelNo;
  }
  
  public String getWriteLevelNo()
  {
    return this.writeLevelNo;
  }
  
  public void setWriteLevelNo(String writeLevelNo)
  {
    this.writeLevelNo = writeLevelNo;
  }
  
  public String getSpeakLevelNo()
  {
    return this.speakLevelNo;
  }
  
  public void setSpeakLevelNo(String speakLevelNo)
  {
    this.speakLevelNo = speakLevelNo;
  }
  
  public Date getTimeStamp()
  {
    return this.timeStamp;
  }
  
  public void setTimeStamp(Date timeStamp)
  {
    this.timeStamp = timeStamp;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("comp_id", getComp_id()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof PrtlAdmLanguage)) {
      return false;
    }
    PrtlAdmLanguage castOther = (PrtlAdmLanguage)other;
    return new EqualsBuilder().append(getComp_id(), castOther.getComp_id()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getComp_id()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.admission.database.PrtlAdmLanguage
 * JD-Core Version:    0.7.0.1
 */