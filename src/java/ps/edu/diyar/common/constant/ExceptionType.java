package ps.edu.diyar.common.constant;

public class ExceptionType
{
  public static final int EXCEPTION = 1;
  public static final int SQL_EXCEPTION = 2;
  public static final int HIBERNATE_EXCEPTION = 3;
  public static final int COMPONENT_EXCEPTION = 4;
  public static final int CLOSE_SESSION_EXCEPTION = 5;
  
  public static String toString(int valueExceptionType)
  {
    String txtExp = null;
    switch (valueExceptionType)
    {
    case 1: 
      txtExp = "Exception"; break;
    case 2: 
      txtExp = "Sql Exception"; break;
    case 3: 
      txtExp = "Hibernate Exception"; break;
    case 4: 
      txtExp = "Component Exception"; break;
    case 5: 
      txtExp = "close session Exception"; break;
    default: 
      txtExp = "undefined Exception";
    }
    return txtExp;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.common.constant.ExceptionType
 * JD-Core Version:    0.7.0.1
 */