package ps.edu.diyar.common.utils.pagination;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class NumberedPage
{
  public int number;
  public boolean selected;
  
  public NumberedPage(int number, boolean isSelected)
  {
    this.number = number;
    this.selected = isSelected;
  }
  
  public boolean isSelected()
  {
    return this.selected;
  }
  
  public int getNumber()
  {
    return this.number;
  }
  
  public void setSeleted(boolean b)
  {
    this.selected = b;
  }
  
  public void setNumber(int i)
  {
    this.number = i;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE).append("number", this.number).append("selected", this.selected).toString();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.common.utils.pagination.NumberedPage
 * JD-Core Version:    0.7.0.1
 */