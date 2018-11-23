package ps.edu.diyar.common.exceptions;

import ps.edu.diyar.common.constant.ExceptionType;

public class ComponentException
  extends ApplicationException
{
  private int exceptionType;
  private String exceptionLocation;
  
  public int getExceptionType()
  {
    return this.exceptionType;
  }
  
  public String getExceptionTypeTxt()
  {
    return ExceptionType.toString(this.exceptionType);
  }
  
  public void setExceptionType(int exceptionType)
  {
    this.exceptionType = exceptionType;
  }
  
  public String getExceptionLocation()
  {
    return this.exceptionLocation;
  }
  
  public void setExceptionLocation(String exceptionLocation)
  {
    this.exceptionLocation = exceptionLocation;
  }
  
  public ComponentException(int exceptionType, String exceptionLocation, String message)
  {
    super(message);
    this.exceptionLocation = exceptionLocation;
    this.exceptionType = exceptionType;
  }
  
  public String toString()
  {
    String txt = ExceptionType.toString(this.exceptionType) + "  in  " + this.exceptionLocation + "  details : " + super.getMessage();
    return txt;
  }
  
  public ComponentException() {}
  
  public ComponentException(String message)
  {
    super(message);
  }
  
  public ComponentException(String message, Throwable cause)
  {
    super(message, cause);
  }
  
  public ComponentException(Throwable cause)
  {
    super(cause);
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.common.exceptions.ComponentException
 * JD-Core Version:    0.7.0.1
 */