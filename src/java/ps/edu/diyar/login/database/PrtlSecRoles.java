package ps.edu.diyar.login.database;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class PrtlSecRoles
  implements Serializable
{
  private Integer roleid;
  private String rolename;
  private String roleADesc;
  private String roleLDesc;
  private String roleStatus;
  private String roleCat;
  
  public PrtlSecRoles(Integer roleid, String rolename, String roleADesc, String roleLDesc, String roleStatus, String roleCat)
  {
    this.roleid = roleid;
    this.rolename = rolename;
    this.roleADesc = roleADesc;
    this.roleLDesc = roleLDesc;
    this.roleStatus = roleStatus;
    this.roleCat = roleCat;
  }
  
  public PrtlSecRoles() {}
  
  public PrtlSecRoles(Integer roleid, String roleStatus, String roleCat)
  {
    this.roleid = roleid;
    this.roleStatus = roleStatus;
    this.roleCat = roleCat;
  }
  
  public Integer getRoleid()
  {
    return this.roleid;
  }
  
  public void setRoleid(Integer roleid)
  {
    this.roleid = roleid;
  }
  
  public String getRolename()
  {
    return this.rolename;
  }
  
  public void setRolename(String rolename)
  {
    this.rolename = rolename;
  }
  
  public String getRoleADesc()
  {
    return this.roleADesc;
  }
  
  public void setRoleADesc(String roleADesc)
  {
    this.roleADesc = roleADesc;
  }
  
  public String getRoleLDesc()
  {
    return this.roleLDesc;
  }
  
  public void setRoleLDesc(String roleLDesc)
  {
    this.roleLDesc = roleLDesc;
  }
  
  public String getRoleStatus()
  {
    return this.roleStatus;
  }
  
  public void setRoleStatus(String roleStatus)
  {
    this.roleStatus = roleStatus;
  }
  
  public String getRoleCat()
  {
    return this.roleCat;
  }
  
  public void setRoleCat(String roleCat)
  {
    this.roleCat = roleCat;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("roleid", getRoleid()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof PrtlSecRoles)) {
      return false;
    }
    PrtlSecRoles castOther = (PrtlSecRoles)other;
    return new EqualsBuilder().append(getRoleid(), castOther.getRoleid()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getRoleid()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.login.database.PrtlSecRoles
 * JD-Core Version:    0.7.0.1
 */