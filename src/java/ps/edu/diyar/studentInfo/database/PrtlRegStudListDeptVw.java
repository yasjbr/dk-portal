package ps.edu.diyar.studentInfo.database;

public class PrtlRegStudListDeptVw
{
  private PrtlRegStudListDeptVwPK comp_id;
  private String studName;
  private String deptNo;
  private String ip;
  private String ipApprove;
  private String rp;
  private String rpApprove;
  private String majorSheetNo;
   private String warn;
  
  public PrtlRegStudListDeptVwPK getComp_id()
  {
    return this.comp_id;
  }
  
  public String getMajorSheetNo()
  {
    return this.majorSheetNo;
  }
  
  public void setMajorSheetNo(String majorSheetNo)
  {
    this.majorSheetNo = majorSheetNo;
  }

    public String getWarn() {
        return warn;
    }

    public void setWarn(String warn) {
        this.warn = warn;
    }
  
  
  
  public void setComp_id(PrtlRegStudListDeptVwPK comp_id)
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
  
  public String getDeptNo()
  {
    return this.deptNo;
  }
  
  public void setDeptNo(String deptNo)
  {
    this.deptNo = deptNo;
  }
  
  public String getIp()
  {
    return this.ip;
  }
  
  public void setIp(String ip)
  {
    this.ip = ip;
  }
  
  public String getIpApprove()
  {
    return this.ipApprove;
  }
  
  public void setIpApprove(String ipApprove)
  {
    this.ipApprove = ipApprove;
  }
  
  public String getRp()
  {
    return this.rp;
  }
  
  public void setRp(String rp)
  {
    this.rp = rp;
  }
  
  public String getRpApprove()
  {
    return this.rpApprove;
  }
  
  public void setRpApprove(String rpApprove)
  {
    this.rpApprove = rpApprove;
  }
}



/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\

 * Qualified Name:     ps.edu.diyar.studentInfo.database.PrtlRegStudListDeptVw

 * JD-Core Version:    0.7.0.1

 */