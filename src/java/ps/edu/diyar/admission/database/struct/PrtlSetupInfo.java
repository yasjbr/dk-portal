package ps.edu.diyar.admission.database.struct;

public class PrtlSetupInfo
{
  private String admTermNo;
  
  public PrtlSetupInfo() {}
  
  public PrtlSetupInfo(String admTermNo)
  {
    this.admTermNo = admTermNo;
  }
  
  public String getAdmTermNo()
  {
    return this.admTermNo;
  }
  
  public void setAdmTermNo(String admTermNo)
  {
    this.admTermNo = admTermNo;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.admission.database.struct.PrtlSetupInfo
 * JD-Core Version:    0.7.0.1
 */