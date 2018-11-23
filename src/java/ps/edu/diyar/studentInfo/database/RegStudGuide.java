/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 *
 * @author Yaseen Jaber
 */
public class RegStudGuide   implements Serializable{
    
    private RegStudGuidePK comp_id; 
  private  String msCrsTypeAName;
  private   String crsAName;
    private  Integer  crHrs;
    private   String crsMark;
   private     String  crsStatus;
    private     String statusAName;

    public RegStudGuidePK getComp_id() {
        return comp_id;
    }

    public void setComp_id(RegStudGuidePK comp_id) {
        this.comp_id = comp_id;
    }

    public String getMsCrsTypeAName() {
        return msCrsTypeAName;
    }

    public void setMsCrsTypeAName(String msCrsTypeAName) {
        this.msCrsTypeAName = msCrsTypeAName;
    }

    public String getCrsAName() {
        return crsAName;
    }

    public void setCrsAName(String crsAName) {
        this.crsAName = crsAName;
    }

    public Integer getCrHrs() {
        return crHrs;
    }

    public void setCrHrs(Integer crHrs) {
        this.crHrs = crHrs;
    }

    public String getCrsMark() {
        return crsMark;
    }

    public void setCrsMark(String crsMark) {
        this.crsMark = crsMark;
    }

    public String getCrsStatus() {
        return crsStatus;
    }

    public void setCrsStatus(String crsStatus) {
        this.crsStatus = crsStatus;
    }

    public String getStatusAName() {
        return statusAName;
    }

    public void setStatusAName(String statusAName) {
        this.statusAName = statusAName;
    }

    public RegStudGuide() {
    }
       
   
  public String toString()
  {
    return new ToStringBuilder(this).append("comp_id", getComp_id()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof RegMsDtl)) {
      return false;
    }
    RegStudGuide castOther = (RegStudGuide)other;
    return new EqualsBuilder().append(getComp_id(), castOther.getComp_id()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getComp_id()).toHashCode();
  }   
      
}
