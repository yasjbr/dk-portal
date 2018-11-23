package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;

public class PrtlStudMsCsVwPK
  implements Serializable
{
  private String studId;
  private String regTermNo;
  private String crsNo;
  private String classNo;
  
  public String getStudId()
  {
    return this.studId;
  }
  
  public void setStudId(String studId)
  {
    this.studId = studId;
  }
  
  public String getRegTermNo()
  {
    return this.regTermNo;
  }
  
  public void setRegTermNo(String regTermNo)
  {
    this.regTermNo = regTermNo;
  }
  
  public String getCrsNo()
  {
    return this.crsNo;
  }
  
  public void setCrsNo(String crsNo)
  {
    this.crsNo = crsNo;
  }
  
  public String getClassNo()
  {
    return this.classNo;
  }
  
  public void setClassNo(String classNo)
  {
    this.classNo = classNo;
  }
  
  public boolean equals(Object o)
  {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    PrtlStudMsCsVwPK that = (PrtlStudMsCsVwPK)o;
    if (this.classNo != null ? !this.classNo.equals(that.classNo) : that.classNo != null) {
      return false;
    }
    if (this.crsNo != null ? !this.crsNo.equals(that.crsNo) : that.crsNo != null) {
      return false;
    }
    if (this.regTermNo != null ? !this.regTermNo.equals(that.regTermNo) : that.regTermNo != null) {
      return false;
    }
    if (this.studId != null ? !this.studId.equals(that.studId) : that.studId != null) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int result = this.studId != null ? this.studId.hashCode() : 0;
    result = 31 * result + (this.regTermNo != null ? this.regTermNo.hashCode() : 0);
    result = 31 * result + (this.crsNo != null ? this.crsNo.hashCode() : 0);
    result = 31 * result + (this.classNo != null ? this.classNo.hashCode() : 0);
    return result;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.PrtlStudMsCsVwPK
 * JD-Core Version:    0.7.0.1
 */