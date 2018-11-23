package ps.edu.diyar.common.utils.pagination;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class Pagination
{
  private Integer firstPage;
  private Integer lastPage;
  private Integer nextPage;
  private Integer prevPage;
  private MessageFormat urlFormat;
  private ArrayList pages = new ArrayList();
  
  public Pagination(String urlFormatString)
  {
    this.urlFormat = new MessageFormat(urlFormatString);
  }
  
  public void addPage(int number, boolean isSelected)
  {
    this.pages.add(new NumberedPage(number, isSelected));
  }
  
  public Integer getFirstPage()
  {
    return this.firstPage;
  }
  
  public Integer getLastPage()
  {
    return this.lastPage;
  }
  
  public Integer getNextPage()
  {
    return this.nextPage;
  }
  
  public ArrayList getPages()
  {
    return this.pages;
  }
  
  public Integer getPrevPage()
  {
    return this.prevPage;
  }
  
  public void setFirstPage(Integer integer)
  {
    this.firstPage = integer;
  }
  
  public void setLastPage(Integer integer)
  {
    this.lastPage = integer;
  }
  
  public void setNextPage(Integer integer)
  {
    this.nextPage = integer;
  }
  
  public void setPages(ArrayList list)
  {
    this.pages = list;
  }
  
  public void setPrevPage(Integer integer)
  {
    this.prevPage = integer;
  }
  
  public boolean isOnePage()
  {
    return (this.pages == null) || (this.pages.size() <= 1);
  }
  
  public boolean isLast()
  {
    return this.lastPage == null;
  }
  
  public boolean isFirst()
  {
    return this.firstPage == null;
  }
  
  public String getFormattedBanner(String numberedPageFormate, String numberedPageSelectedFormate, String numberedPageSeperator, String fullBanner)
  {
    StringBuffer buffer = new StringBuffer(100);
    
    Iterator pageIterator = this.pages.iterator();
    while (pageIterator.hasNext())
    {
      NumberedPage page = (NumberedPage)pageIterator.next();
      
      Integer pageNumber = new Integer(page.getNumber());
      
      String urlString = this.urlFormat.format(new Object[] { pageNumber });
      

      Object[] pageObjects = { pageNumber, urlString };
      if (page.isSelected()) {
        buffer.append(MessageFormat.format(numberedPageSelectedFormate, pageObjects));
      } else {
        buffer.append(MessageFormat.format(numberedPageFormate, pageObjects));
      }
      if (pageIterator.hasNext()) {
        buffer.append(numberedPageSeperator);
      }
    }
    String numberedPageString = buffer.toString();
    








    Object[] pageObjects = { numberedPageString, this.urlFormat.format(new Object[] { getFirstPage() }), this.urlFormat.format(new Object[] { getPrevPage() }), this.urlFormat.format(new Object[] { getNextPage() }), this.urlFormat.format(new Object[] { getLastPage() }) };
    








    return MessageFormat.format(fullBanner, pageObjects);
  }
  
  public String toString()
  {
    return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE).append("firstPage", this.firstPage).append("lastPage", this.lastPage).append("nextPage", this.nextPage).append("previousPage", this.prevPage).append("pages", this.pages).append("urlFormate", this.urlFormat).toString();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.common.utils.pagination.Pagination
 * JD-Core Version:    0.7.0.1
 */