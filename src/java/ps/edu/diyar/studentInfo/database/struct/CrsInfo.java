package ps.edu.diyar.studentInfo.database.struct;

public class CrsInfo
{
  private String crsNo;
  private String CrsAName;
  
  public CrsInfo() {}
  
  public CrsInfo(String crsNo, String crsAName)
  {
    this.crsNo = crsNo;
    this.CrsAName = crsAName;
  }
  
  public String getCrsNo()
  {
    return this.crsNo;
  }
  
  public void setCrsNo(String crsNo)
  {
    this.crsNo = crsNo;
  }
  
  public String getCrsAName()
  {
    return this.CrsAName;
  }
  
  public void setCrsAName(String crsAName)
  {
    this.CrsAName = crsAName;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.struct.CrsInfo
 * JD-Core Version:    0.7.0.1
 */