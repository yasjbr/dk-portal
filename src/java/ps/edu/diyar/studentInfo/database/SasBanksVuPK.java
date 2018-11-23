package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;

public class SasBanksVuPK
  implements Serializable
{
  private String bnkCode;
  private String bnkBraCode;
  
  public String getBnkBraCode()
  {
    return this.bnkBraCode;
  }
  
  public void setBnkBraCode(String bnkBraCode)
  {
    this.bnkBraCode = bnkBraCode;
  }
  
  public String getBnkCode()
  {
    return this.bnkCode;
  }
  
  public void setBnkCode(String bnkCode)
  {
    this.bnkCode = bnkCode;
  }
  
  public boolean equals(Object o)
  {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    SasBanksVuPK that = (SasBanksVuPK)o;
    if (this.bnkBraCode != null ? !this.bnkBraCode.equals(that.bnkBraCode) : that.bnkBraCode != null) {
      return false;
    }
    if (this.bnkCode != null ? !this.bnkCode.equals(that.bnkCode) : that.bnkCode != null) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int result = this.bnkCode != null ? this.bnkCode.hashCode() : 0;
    result = 31 * result + (this.bnkBraCode != null ? this.bnkBraCode.hashCode() : 0);
    return result;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.SasBanksVuPK
 * JD-Core Version:    0.7.0.1
 */