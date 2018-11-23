package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RegStudPastUniPK
  implements Serializable
{
  private String studId;
  private String uniNo;
  
  public RegStudPastUniPK(String studId, String uniNo)
  {
    this.studId = studId;
    this.uniNo = uniNo;
  }
  
  public RegStudPastUniPK() {}
  
  public String getStudId()
  {
    return this.studId;
  }
  
  public void setStudId(String studId)
  {
    this.studId = studId;
  }
  
  public String getUniNo()
  {
    return this.uniNo;
  }
  
  public void setUniNo(String uniNo)
  {
    this.uniNo = uniNo;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("studId", getStudId()).append("uniNo", getUniNo()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof RegStudPastUniPK)) {
      return false;
    }
    RegStudPastUniPK castOther = (RegStudPastUniPK)other;
    return new EqualsBuilder().append(getStudId(), castOther.getStudId()).append(getUniNo(), castOther.getUniNo()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getStudId()).append(getUniNo()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.RegStudPastUniPK
 * JD-Core Version:    0.7.0.1
 */