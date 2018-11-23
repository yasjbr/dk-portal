package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class SrvyWorkTypeDtl
  implements Serializable
{
  private SrvyWorkTypeDtlPK comp_id;
  
  public SrvyWorkTypeDtl(SrvyWorkTypeDtlPK comp_id)
  {
    this.comp_id = comp_id;
  }
  
  public SrvyWorkTypeDtl() {}
  
  public SrvyWorkTypeDtlPK getComp_id()
  {
    return this.comp_id;
  }
  
  public void setComp_id(SrvyWorkTypeDtlPK comp_id)
  {
    this.comp_id = comp_id;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("comp_id", getComp_id()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof SrvyWorkTypeDtl)) {
      return false;
    }
    SrvyWorkTypeDtl castOther = (SrvyWorkTypeDtl)other;
    return new EqualsBuilder().append(getComp_id(), castOther.getComp_id()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getComp_id()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.SrvyWorkTypeDtl
 * JD-Core Version:    0.7.0.1
 */