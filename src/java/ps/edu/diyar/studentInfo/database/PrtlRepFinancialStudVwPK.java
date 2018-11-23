package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;

public class PrtlRepFinancialStudVwPK
  implements Serializable
{
  private String studId;
  private String termNo;
  private String finCode;
  
  public String getStudId()
  {
    return this.studId;
  }
  
  public void setStudId(String studId)
  {
    this.studId = studId;
  }
  
  public String getTermNo()
  {
    return this.termNo;
  }
  
  public void setTermNo(String termNo)
  {
    this.termNo = termNo;
  }
  
  public String getFinCode()
  {
    return this.finCode;
  }
  
  public void setFinCode(String finCode)
  {
    this.finCode = finCode;
  }
  
  public boolean equals(Object o)
  {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    PrtlRepFinancialStudVwPK that = (PrtlRepFinancialStudVwPK)o;
    if (this.finCode != null ? !this.finCode.equals(that.finCode) : that.finCode != null) {
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
    int result = this.studId != null ? this.studId.hashCode() : 0;
    result = 31 * result + (this.termNo != null ? this.termNo.hashCode() : 0);
    result = 31 * result + (this.finCode != null ? this.finCode.hashCode() : 0);
    return result;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.PrtlRepFinancialStudVwPK
 * JD-Core Version:    0.7.0.1
 */