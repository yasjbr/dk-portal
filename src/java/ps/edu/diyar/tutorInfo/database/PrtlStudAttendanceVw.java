package ps.edu.diyar.tutorInfo.database;

public class PrtlStudAttendanceVw
{
  private PrtlStudAttendanceVwPK comp_id;
  private String studName;
  private String tutorNo;
  
  public PrtlStudAttendanceVwPK getComp_id()
  {
    return this.comp_id;
  }
  
  public void setComp_id(PrtlStudAttendanceVwPK comp_id)
  {
    this.comp_id = comp_id;
  }
  
  public String getTutorNo()
  {
    return this.tutorNo;
  }
  
  public void setTutorNo(String tutorNo)
  {
    this.tutorNo = tutorNo;
  }
  
  public String getStudName()
  {
    return this.studName;
  }
  
  public void setStudName(String studName)
  {
    this.studName = studName;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.tutorInfo.database.PrtlStudAttendanceVw
 * JD-Core Version:    0.7.0.1
 */