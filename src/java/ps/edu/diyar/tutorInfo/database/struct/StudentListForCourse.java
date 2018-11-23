package ps.edu.diyar.tutorInfo.database.struct;

public class StudentListForCourse
{
  private String crsMark;
  private String firstMark;
   private String practicalMark;
    private String secondMark;
     private String midMark;
      private String finMark;
  private String studAName;
  private String studId;
  
  public StudentListForCourse() {}
  
  public StudentListForCourse(String studId, String studAName)
  {
    this.studId = studId;
    this.studAName = studAName;
  }
  
  public StudentListForCourse(String studId, String studAName, Short mark,Short first,Short second,Short mid,Short practical,Short fin)
  {
    this.studId = studId;
    this.studAName = studAName;
    if (mark != null) {
      this.crsMark = String.valueOf(mark);
    }
    
    if (first != null) {
      this.firstMark = String.valueOf(first);
    }
    
    
    if (second != null) {
      this.secondMark = String.valueOf(second);
      
    }if (mid != null) {
      this.midMark = String.valueOf(mid);
    }
    if (practical != null) {
      this.practicalMark = String.valueOf(practical);
    }
    if (fin != null) {
      this.finMark = String.valueOf(fin);
    }
    
  }
  
  public String getStudAName()
  {
    return this.studAName;
  }
  
  public void setStudAName(String studAName)
  {
    this.studAName = studAName;
  }
  
  public String getStudId()
  {
    return this.studId;
  }
  
  public void setStudId(String studId)
  {
    this.studId = studId;
  }
  
  public String getCrsMark()
  {
    return this.crsMark;
  }
  
  public void setCrsMark(String crsMark)
  {
    this.crsMark = crsMark;
  }

    public String getFirstMark() {
        return firstMark;
    }

    public void setFirstMark(String firstMark) {
        this.firstMark = firstMark;
    }

    public String getPracticalMark() {
        return practicalMark;
    }

    public void setPracticalMark(String practicalMark) {
        this.practicalMark = practicalMark;
    }

    public String getSecondMark() {
        return secondMark;
    }

    public void setSecondMark(String secondMark) {
        this.secondMark = secondMark;
    }

    public String getMidMark() {
        return midMark;
    }

    public void setMidMark(String midMark) {
        this.midMark = midMark;
    }

    public String getFinMark() {
        return finMark;
    }

    public void setFinMark(String finMark) {
        this.finMark = finMark;
    }
  
  
  
  
  
}



/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\

 * Qualified Name:     ps.edu.diyar.tutorInfo.database.struct.StudentListForCourse

 * JD-Core Version:    0.7.0.1

 */