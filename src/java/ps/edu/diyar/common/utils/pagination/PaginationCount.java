package ps.edu.diyar.common.utils.pagination;

public class PaginationCount
{
  private int pageNumber;
  
  public PaginationCount(int pageNumber)
  {
    this.pageNumber = pageNumber;
  }
  
  public int getPageIndex()
  {
    this.pageNumber -= 1;
    
    int result = this.pageNumber * 10;
    
    return result;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.common.utils.pagination.PaginationCount
 * JD-Core Version:    0.7.0.1
 */