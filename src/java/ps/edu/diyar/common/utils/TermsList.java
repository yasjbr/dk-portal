package ps.edu.diyar.common.utils;

import java.io.Serializable;

public class TermsList
  implements Serializable
{
  private String termNo;
  private String termName;
  private boolean selected;
  
  public TermsList() {}
  
  public TermsList(String termNo, String termName)
  {
    this.termNo = termNo;
    this.termName = termName;
  }
  
  public String getTermNo()
  {
    return this.termNo;
  }
  
  public void setTermNo(String termNo)
  {
    this.termNo = termNo;
  }
  
  public void setTermName(String termName)
  {
    this.termName = termName;
  }
  
  public String getTermName()
  {
    return this.termName;
  }
  
  public void setSelected(boolean selected)
  {
    this.selected = selected;
  }
  
  public boolean isSelected()
  {
    return this.selected;
  }
}
