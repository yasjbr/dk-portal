package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RegStudLangPK
  implements Serializable
{
  private String studId;
  private String langId;
  
  public RegStudLangPK(String studId, String langId)
  {
    this.studId = studId;
    this.langId = langId;
  }
  
  public RegStudLangPK() {}
  
  public String getStudId()
  {
    return this.studId;
  }
  
  public void setStudId(String studId)
  {
    this.studId = studId;
  }
  
  public String getLangId()
  {
    return this.langId;
  }
  
  public void setLangId(String langId)
  {
    this.langId = langId;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("studId", getStudId()).append("langId", getLangId()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof RegStudLangPK)) {
      return false;
    }
    RegStudLangPK castOther = (RegStudLangPK)other;
    return new EqualsBuilder().append(getStudId(), castOther.getStudId()).append(getLangId(), castOther.getLangId()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getStudId()).append(getLangId()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.RegStudLangPK
 * JD-Core Version:    0.7.0.1
 */