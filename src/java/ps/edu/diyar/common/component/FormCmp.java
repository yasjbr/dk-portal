package ps.edu.diyar.common.component;

import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormCmp
{
  public static String getArabicText(boolean editOpperation, String txt)
  {
    if (!editOpperation) {
      try
      {
        txt = new String(txt.getBytes("ISO8859_1"), "utf8");
      }
      catch (Exception e) {}
    }
    return txt;
  }
  
  public static boolean isEmpty(String txt)
  {
    boolean res = true;
    if ((txt != null) && (!txt.trim().equals(""))) {
      res = false;
    }
    return res;
  }
  
  public static boolean isInteger(String txt)
  {
    boolean res = true;
    try
    {
      Integer.parseInt(txt);
      res = true;
    }
    catch (Exception e)
    {
      res = false;
    }
    return res;
  }
  
  public static boolean isDouble(String txt)
  {
    boolean res = true;
    try
    {
      Double.parseDouble(txt);
      res = true;
    }
    catch (Exception e)
    {
      res = false;
    }
    return res;
  }
  
  public static Date convertStringToDate(String dateValue)
  {
    Date date = null;
    try
    {
      SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
      if ((dateValue != null) && (dateValue.trim().length() > 0)) {
        date = formatter.parse(dateValue.trim());
      }
    }
    catch (Exception ex) {}
    return date;
  }
  
  public static boolean isSelected(String val)
  {
    if ((val != null) && (!val.equals("")) && (!val.equals("*"))) {
      return true;
    }
    return false;
  }
  
  public static String convertDateToString(Date dateValue)
  {
    String dateFormated = null;
    try
    {
      SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
      if (dateValue != null) {
        dateFormated = formatter.format(dateValue);
      }
    }
    catch (Exception ex) {}
    return dateFormated;
  }
  
  public static boolean validCardId(String no)
  {
    int counter = 1;
    

    int vSum = 0;
    if (no.length() == 9) {
      try
      {
        if (Integer.parseInt(no) == 0) {
          return false;
        }
        while (counter < 9)
        {
          int digit = Integer.parseInt(no.substring(counter - 1, counter));
          int odd_even = counter % 2;
          if (odd_even == 0)
          {
            digit *= 2;
            if (digit > 9) {
              digit = Integer.parseInt(String.valueOf(digit).substring(0, 1)) + Integer.parseInt(String.valueOf(digit).substring(1, 2));
            }
          }
          else
          {
            digit *= 1;
            if (digit > 9) {
              digit = Integer.parseInt(String.valueOf(digit).substring(0, 1)) + Integer.parseInt(String.valueOf(digit).substring(1, 2));
            }
          }
          counter += 1;
          vSum += digit;
        }
        System.out.println("vSum " + vSum);
        int result = (10 - vSum % 10) % 10;
        int lastDigit = Integer.parseInt(no.substring(8));
        if (result == lastDigit) {
          return true;
        }
        return false;
      }
      catch (Exception e)
      {
        e.printStackTrace();
        return false;
      }
    }
    return false;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.common.component.FormCmp
 * JD-Core Version:    0.7.0.1
 */