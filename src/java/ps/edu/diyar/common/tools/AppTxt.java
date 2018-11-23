package ps.edu.diyar.common.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AppTxt
{
  public static String textManipulation(String input)
  {
    String retText = "";
    if ((input == null) || (input.equals(""))) {
      retText = "   ";
    } else {
      retText = input;
    }
    return retText;
  }
  
  public static String textManipulation(Integer input)
  {
    String retText = "";
    if (input == null) {
      retText = "   ";
    } else {
      retText = input.toString();
    }
    return retText;
  }
  
  public static String textManipulation(Long input)
  {
    String retText = "";
    if (input == null) {
      retText = "   ";
    } else {
      retText = String.valueOf(input);
    }
    return retText;
  }
  
  public static String textManipulation(Float input)
  {
    String retText = "";
    if (input == null) {
      retText = "   ";
    } else {
      retText = input.toString();
    }
    return retText;
  }
  
  public static String textManipulation(Date input)
  {
    String retText = "";
    if (input == null)
    {
      retText = "   ";
    }
    else
    {
      SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
      retText = formatter.format(input);
    }
    return retText;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.common.tools.AppTxt
 * JD-Core Version:    0.7.0.1
 */