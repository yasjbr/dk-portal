package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RegLang
  implements Serializable
{
  private String langNo;
  private String langAName;
  private String langLName;
  private String userId;
  private Date timeStamp;
  private String isActive;
  private String notes;
  
  public RegLang(String langNo, String langAName, String langLName, String userId, Date timeStamp, String isActive, String notes)
  {
    this.langNo = langNo;
    this.langAName = langAName;
    this.langLName = langLName;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
    this.notes = notes;
  }
  
  public RegLang() {}
  
  public RegLang(String langNo, String langAName, String userId, Date timeStamp, String isActive)
  {
    this.langNo = langNo;
    this.langAName = langAName;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.isActive = isActive;
  }
  
  public String getLangNo()
  {
    return this.langNo;
  }
  
  public void setLangNo(String langNo)
  {
    this.langNo = langNo;
  }
  
  public String getLangAName()
  {
    return this.langAName;
  }
  
  public void setLangAName(String langAName)
  {
    this.langAName = langAName;
  }
  
  public String getLangLName()
  {
    return this.langLName;
  }
  
  public void setLangLName(String langLName)
  {
    this.langLName = langLName;
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
  
  public String getIsActive()
  {
    return this.isActive;
  }
  
  public void setIsActive(String isActive)
  {
    this.isActive = isActive;
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
    return new ToStringBuilder(this).append("langNo", getLangNo()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof RegLang)) {
      return false;
    }
    RegLang castOther = (RegLang)other;
    return new EqualsBuilder().append(getLangNo(), castOther.getLangNo()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getLangNo()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.RegLang
 * JD-Core Version:    0.7.0.1
 */