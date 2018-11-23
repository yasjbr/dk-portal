package ps.edu.diyar.tutorInfo.database;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class PrtlTutorStudMark
  implements Serializable
{
  private PrtlTutorStudMarkPK comp_id;
  private String classNo;
  private Short finalMark;
  private Short firstMark;
   private Short secondMark;
    private Short midMark;
     private Short finMark;
  private String userId;
  private Date timeStamp;
  private String computerIp;
  
  public PrtlTutorStudMark(PrtlTutorStudMarkPK comp_id, String classNo, Short finalMark,Short firstMark, Short secondMark,Short midMark, Short finMark,String userId, Date timeStamp, String computerIp)
  {
    this.comp_id = comp_id;
    this.classNo = classNo;
    this.finalMark = finalMark;
    this.userId = userId;
    this.timeStamp = timeStamp;
    this.computerIp = computerIp;
    this.firstMark = firstMark;
    this.secondMark = secondMark;
     this.midMark = midMark;
     this.finMark = finMark;
  }
  
  public PrtlTutorStudMark() {}
  
  public PrtlTutorStudMark(PrtlTutorStudMarkPK comp_id, String userId, Date timeStamp)
  {
    this.comp_id = comp_id;
    this.userId = userId;
    this.timeStamp = timeStamp;
  }
  
  public PrtlTutorStudMarkPK getComp_id()
  {
    return this.comp_id;
  }
  
  public void setComp_id(PrtlTutorStudMarkPK comp_id)
  {
    this.comp_id = comp_id;
  }
  
  public String getClassNo()
  {
    return this.classNo;
  }
  
  public void setClassNo(String classNo)
  {
    this.classNo = classNo;
  }
  
  public Short getFinalMark()
  {
    return this.finalMark;
  }
  
  public void setFinalMark(Short finalMark)
  {
    this.finalMark = finalMark;
  }

    public Short getFirstMark() {
        return firstMark;
    }

    public void setFirstMark(Short firstMark) {
        this.firstMark = firstMark;
    }

    public Short getSecondMark() {
        return secondMark;
    }

    public void setSecondMark(Short secondMark) {
        this.secondMark = secondMark;
    }

    public Short getMidMark() {
        return midMark;
    }

    public void setMidMark(Short midMark) {
        this.midMark = midMark;
    }

    public Short getFinMark() {
        return finMark;
    }

    public void setFinMark(Short finMark) {
        this.finMark = finMark;
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
    if (!(other instanceof PrtlTutorStudMark)) {
      return false;
    }
    PrtlTutorStudMark castOther = (PrtlTutorStudMark)other;
    return new EqualsBuilder().append(getComp_id(), castOther.getComp_id()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getComp_id()).toHashCode();
  }
}



/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\

 * Qualified Name:     ps.edu.diyar.tutorInfo.database.PrtlTutorStudMark

 * JD-Core Version:    0.7.0.1

 */