package ps.edu.diyar.studentInfo.database.struct;

import java.util.Date;

public class CalendarItemInfo
{
  private String itemNo;
  private String itemAName;
  private Date begDate;
  private Date endDate;
  private String termAName;
  
  public CalendarItemInfo() {}
  
  public CalendarItemInfo(String itemNo, String itemAName, Date begDate, Date endDate, String termAName)
  {
    this.itemNo = itemNo;
    this.itemAName = itemAName;
    this.begDate = begDate;
    this.endDate = endDate;
    this.termAName = termAName;
  }
  
  public String getTermAName()
  {
    return this.termAName;
  }
  
  public void setTermAName(String termAName)
  {
    this.termAName = termAName;
  }
  
  public String getItemNo()
  {
    return this.itemNo;
  }
  
  public void setItemNo(String itemNo)
  {
    this.itemNo = itemNo;
  }
  
  public String getItemAName()
  {
    return this.itemAName;
  }
  
  public void setItemAName(String itemAName)
  {
    this.itemAName = itemAName;
  }
  
  public Date getBegDate()
  {
    return this.begDate;
  }
  
  public void setBegDate(Date begDate)
  {
    this.begDate = begDate;
  }
  
  public Date getEndDate()
  {
    return this.endDate;
  }
  
  public void setEndDate(Date endDate)
  {
    this.endDate = endDate;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.struct.CalendarItemInfo
 * JD-Core Version:    0.7.0.1
 */