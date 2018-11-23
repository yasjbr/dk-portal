package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;

public class RegSpecToPayPK
  implements Serializable
{
  private String specNo;

    public String getSpecNo() {
        return specNo;
    }

    public void setSpecNo(String specNo) {
        this.specNo = specNo;
    }
  
   
   
   
  public boolean equals(Object o)
  {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    RegSpecToPayPK that = (RegSpecToPayPK)o;
    if (this.specNo != null ? !this.specNo.equals(that.specNo) : that.specNo != null) {
      return false;
    }
    
    return true;
  }
  
  public int hashCode()
  {
    int result = this.specNo != null ? this.specNo.hashCode() : 0;
     
   
    return result;
  }
}

 