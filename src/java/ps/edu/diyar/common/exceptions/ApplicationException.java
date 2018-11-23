package ps.edu.diyar.common.exceptions;

public class ApplicationException
  extends Exception
{
  public ApplicationException() {}
  
  public ApplicationException(String message)
  {
    super(message);
  }
  
  public ApplicationException(String message, Throwable cause)
  {
    super(message, cause);
  }
  
  public ApplicationException(Throwable cause)
  {
    super(cause);
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.common.exceptions.ApplicationException
 * JD-Core Version:    0.7.0.1
 */