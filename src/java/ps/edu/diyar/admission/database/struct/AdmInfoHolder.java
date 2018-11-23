package ps.edu.diyar.admission.database.struct;

public class AdmInfoHolder
{
  String appNo;
  String admTermNo;
  
  public AdmInfoHolder() {}
  
  public AdmInfoHolder(String appNo, String admTermNo)
  {
    this.admTermNo = admTermNo;
    this.appNo = appNo;
  }
  
  public String getAppNo()
  {
    return this.appNo;
  }
  
  public void setAppNo(String appNo)
  {
    this.appNo = appNo;
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
 * Qualified Name:     ps.edu.diyar.admission.database.struct.AdmInfoHolder
 * JD-Core Version:    0.7.0.1
 */