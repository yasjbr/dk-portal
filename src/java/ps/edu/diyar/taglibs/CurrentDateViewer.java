package ps.edu.diyar.taglibs;

import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

public class CurrentDateViewer
  extends TagSupport
{
  public int doStartTag()
  {
    try
    {
      JspWriter out = this.pageContext.getOut();
      SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
      Calendar cal = Calendar.getInstance();
      out.print(format.format(cal.getTime()));
    }
    catch (Exception ioe)
    {
      System.out.println("Error: " + ioe);
    }
    return 0;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.taglibs.CurrentDateViewer
 * JD-Core Version:    0.7.0.1
 */