package ps.edu.diyar.tutorInfo.database;

public class PrtlStudMarkVw
{
  private PrtlStudMarkVwPK comp_id;
  private String studName;
  private Short crsMark;
  private Short firstMark;
   private Short secondMark;
    private Short midMark;
     private Short practicalMark;
      private Short finMark;
  private String classNo;
  private String tutorNo;
  
  public PrtlStudMarkVwPK getComp_id()
  {
    return this.comp_id;
  }
  
  public void setComp_id(PrtlStudMarkVwPK comp_id)
  {
    this.comp_id = comp_id;
  }
  
  public String getStudName()
  {
    return this.studName;
  }
  
  public void setStudName(String studName)
  {
    this.studName = studName;
  }
  
  public Short getCrsMark()
  {
    return this.crsMark;
  }
  
  public void setCrsMark(Short crsMark)
  {
    this.crsMark = crsMark;
  }

    public Short getFirstMark() {
        return firstMark;
    }

    public void setFirstMark(Short firstMark) {
        this.firstMark = firstMark;
    }
  
  
  
  public String getClassNo()
  {
    return this.classNo;
  }
  
  public void setClassNo(String classNo)
  {
    this.classNo = classNo;
  }
  
  public String getTutorNo()
  {
    return this.tutorNo;
  }
  
  public void setTutorNo(String tutorNo)
  {
    this.tutorNo = tutorNo;
  }

    public Short getSecondMark() {
        return secondMark;
    }

    public void setSecondMark(Short secondMark) {
        this.secondMark = secondMark;
    }

    public Short getMidMark() {
        return midMark;
    }

    public void setMidMark(Short midMark) {
        this.midMark = midMark;
    }

    public Short getPracticalMark() {
        return practicalMark;
    }

    public void setPracticalMark(Short practicalMark) {
        this.practicalMark = practicalMark;
    }

    public Short getFinMark() {
        return finMark;
    }

    public void setFinMark(Short finMark) {
        this.finMark = finMark;
    }
  
  
  
  
}

 