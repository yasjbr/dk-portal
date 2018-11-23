package ps.edu.diyar.studentInfo.database;

public class PrtlRepCsrlistStudVw
{
  private PrtlRepCsrlistStudVwPK comp_id;
  private String crsAName;
  private Integer crsHrs;
  private String crsStatus;
  private String crsClass;
  private String userId;
  private String tutorAName;
  
  public PrtlRepCsrlistStudVwPK getComp_id()
  {
    return this.comp_id;
  }
  
  public void setComp_id(PrtlRepCsrlistStudVwPK comp_id)
  {
    this.comp_id = comp_id;
  }
  
  public String getCrsAName()
  {
    return this.crsAName;
  }
  
  public void setCrsAName(String crsAName)
  {
    this.crsAName = crsAName;
  }
  
  public Integer getCrsHrs()
  {
    return this.crsHrs;
  }
  
  public void setCrsHrs(Integer crsHrs)
  {
    this.crsHrs = crsHrs;
  }
  
  public String getCrsStatus()
  {
    return this.crsStatus;
  }
  
  public void setCrsStatus(String crsStatus)
  {
    this.crsStatus = crsStatus;
  }
  
  public String getCrsClass()
  {
    return this.crsClass;
  }
  
  public void setCrsClass(String crsClass)
  {
    this.crsClass = crsClass;
  }
  
  public String getUserId()
  {
    return this.userId;
  }
  
  public void setUserId(String userId)
  {
    this.userId = userId;
  }
  
  public String getTutorAName()
  {
    return this.tutorAName;
  }
  
  public void setTutorAName(String tutorAName)
  {
    this.tutorAName = tutorAName;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.PrtlRepCsrlistStudVw
 * JD-Core Version:    0.7.0.1
 */