package ps.edu.diyar.studentInfo.database.struct;

public class TermCoursesSummaryHolder
{
  private String regStaus;
  private String regStatusAName;
  private String mark;
  
    private String first;
     private String second;
      private String mid;
       private String practical;
      private String finalm;
      
       
  private Integer crHrs;
  private String crsAName;
  private String crsNo;
  private String crsClass;
  private String termNo;
  
  public TermCoursesSummaryHolder() {}
  
  public TermCoursesSummaryHolder(String regStaus, String regStatusAName, String mark, String first,String second,String mid,String practical,String finalm,Integer crHrs, String crsAName, String crsNo, String crsClass, String termNo)
  {
    this.regStaus = regStaus;
    this.regStatusAName = regStatusAName;
    this.mark = mark;
     this.first = first;
      this.second = second;
       this.mid = mid;
        this.finalm = finalm;
         this.practical = practical;
    this.crHrs = crHrs;
    this.crsAName = crsAName;
    this.crsNo = crsNo;
    this.crsClass = crsClass;
    this.termNo = termNo;
  }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public String getFinalm() {
        return finalm;
    }

    public void setFinalm(String finalm) {
        this.finalm = finalm;
    }

    public String getPractical() {
        return practical;
    }

    public void setPractical(String practical) {
        this.practical = practical;
    }
  
  public String getTermNo()
  {
    return this.termNo;
  }
  
  public void setTermNo(String termNo)
  {
    this.termNo = termNo;
  }
  
  public String getCrsClass()
  {
    return this.crsClass;
  }
  
  public void setCrsClass(String crsClass)
  {
    this.crsClass = crsClass;
  }
  
  public String getRegStaus()
  {
    return this.regStaus;
  }
  
  public void setRegStaus(String regStaus)
  {
    this.regStaus = regStaus;
  }
  
  public String getRegStatusAName()
  {
    return this.regStatusAName;
  }
  
  public void setRegStatusAName(String regStatusAName)
  {
    this.regStatusAName = regStatusAName;
  }
  
  public String getMark()
  {
    return this.mark;
  }
  
  public void setMark(String mark)
  {
    this.mark = mark;
  }
  
  public Integer getCrHrs()
  {
    return this.crHrs;
  }
  
  public void setCrHrs(Integer crHrs)
  {
    this.crHrs = crHrs;
  }
  
  public String getCrsAName()
  {
    return this.crsAName;
  }
  
  public void setCrsAName(String crsAName)
  {
    this.crsAName = crsAName;
  }
  
  public String getCrsNo()
  {
    return this.crsNo;
  }
  
  public void setCrsNo(String crsNo)
  {
    this.crsNo = crsNo;
  }
}



/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\

 * Qualified Name:     ps.edu.diyar.studentInfo.database.struct.TermCoursesSummaryHolder

 * JD-Core Version:    0.7.0.1

 */