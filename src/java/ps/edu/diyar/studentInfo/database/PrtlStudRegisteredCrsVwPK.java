package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;

public class PrtlStudRegisteredCrsVwPK
  implements Serializable
{
  private String termNo;
  private String studId;
  private String classNo;
  private String crsNo;
  
  public String getTermNo()
  {
    return this.termNo;
  }
  
  public void setTermNo(String termNo)
  {
    this.termNo = termNo;
  }
  
  public String getStudId()
  {
    return this.studId;
  }
  
  public void setStudId(String studId)
  {
    this.studId = studId;
  }
  
  public String getClassNo()
  {
    return this.classNo;
  }
  
  public void setClassNo(String classNo)
  {
    this.classNo = classNo;
  }
  
  public String getCrsNo()
  {
    return this.crsNo;
  }
  
  public void setCrsNo(String crsNo)
  {
    this.crsNo = crsNo;
  }
  
  public boolean equals(Object o)
  {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    PrtlStudRegisteredCrsVwPK that = (PrtlStudRegisteredCrsVwPK)o;
    if (this.classNo != null ? !this.classNo.equals(that.classNo) : that.classNo != null) {
      return false;
    }
    if (this.crsNo != null ? !this.crsNo.equals(that.crsNo) : that.crsNo != null) {
      return false;
    }
    if (this.studId != null ? !this.studId.equals(that.studId) : that.studId != null) {
      return false;
    }
    if (this.termNo != null ? !this.termNo.equals(that.termNo) : that.termNo != null) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int result = this.termNo != null ? this.termNo.hashCode() : 0;
    result = 31 * result + (this.studId != null ? this.studId.hashCode() : 0);
    result = 31 * result + (this.classNo != null ? this.classNo.hashCode() : 0);
    result = 31 * result + (this.crsNo != null ? this.crsNo.hashCode() : 0);
    return result;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.PrtlStudRegisteredCrsVwPK
 * JD-Core Version:    0.7.0.1
 */