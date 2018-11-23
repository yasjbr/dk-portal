package ps.edu.diyar.common.tools;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.lang.time.FastDateFormat;

public class DateTool
{
  public static final String decorateYYYY_MM_DD(Object columnValue)
  {
    FastDateFormat dateFormat = FastDateFormat.getInstance("dd/MM/yyyy");
    if (columnValue != null)
    {
      Date date = (Date)columnValue;
      return dateFormat.format(date);
    }
    return " ";
  }
  
  public static Date convertStringToDate_dd_mm_yyyy(String dateValue)
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
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.common.tools.DateTool
 * JD-Core Version:    0.7.0.1
 */