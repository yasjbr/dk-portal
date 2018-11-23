package ps.edu.diyar.taglibs;

import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;
import org.displaytag.util.Href;
import org.displaytag.util.RequestHelper;
import ps.edu.diyar.common.utils.pagination.ListHelper;
import ps.edu.diyar.common.utils.pagination.TableProperties;

public class PaginationTag
  extends TagSupport
{
  private Href baseHref;
  private int pagesize = 0;
  private int pageNumber = 1;
  private ListHelper listHelper = null;
  private int list;
  private TableProperties properties = null;
  private String requestUri;
  private String tableParameterIdentifier;
  private String name;
  
  public void setBaseHref(Href baseRef)
  {
    this.baseHref = baseRef;
  }
  
  public ListHelper getListHelper()
  {
    return this.listHelper;
  }
  
  public void setPagesize(int pagesize)
  {
    this.pagesize = pagesize;
  }
  
  public int getPageSize()
  {
    return this.pagesize;
  }
  
  public String getRequestUri()
  {
    return this.requestUri;
  }
  
  public void setRequestUri(String requstUri)
  {
    this.requestUri = requstUri;
  }
  
  public void setList(int list)
  {
    this.list = list;
  }
  
  public int doEndTag()
    throws JspException
  {
    StringBuffer buffer = new StringBuffer(10000);
    
    buffer.append(getHTMLData());
    
    JspWriter out = this.pageContext.getOut();
    try
    {
      out.write(buffer.toString());
      out.flush();
    }
    catch (IOException e)
    {
      System.out.println("Error in IO " + e);
    }
    this.listHelper = null;
    this.pagesize = 0;
    
    this.requestUri = null;
    this.tableParameterIdentifier = null;
    
    return 1;
  }
  
  public int doStartTag()
    throws JspException
  {
    try
    {
      this.properties = new TableProperties();
    }
    catch (IOException e)
    {
      System.out.println("Error in IO " + e.getMessage());
    }
    initParameters();
    
    this.listHelper = new ListHelper(this.list, this.pagesize, this.properties);
    this.listHelper.setCurrentPage(this.pageNumber);
    
    return 0;
  }
  
  private String getHTMLData()
  {
    StringBuffer buffer = new StringBuffer(10000);
    
    buffer.append(getSearchResultAndNavigation());
    return buffer.toString();
  }
  
  private String getSearchResultAndNavigation()
  {
    if ((this.pagesize != 0) && (this.listHelper != null))
    {
      Href navigationHref = new Href(this.baseHref);
      
      navigationHref.addParameter(encodeParamter("p"), "{0,number,#}");
      
      StringBuffer buffer = new StringBuffer().append(this.listHelper.getNavigationBar(navigationHref.toString()));
      

      return buffer.toString();
    }
    return "";
  }
  
  public void initParameters()
  {
    initHref();
    
    RequestHelper requestHelper = new RequestHelper((HttpServletRequest)this.pageContext.getRequest());
    
    Integer pageNumberParameter = requestHelper.getIntParameter(encodeParamter("p"));
    this.pageNumber = (pageNumberParameter == null ? 1 : pageNumberParameter.intValue());
  }
  
  private void initHref()
  {
    RequestHelper requestHelper = new RequestHelper((HttpServletRequest)this.pageContext.getRequest());
    
    Href normalHref = requestHelper.getHref();
    if (this.requestUri != null)
    {
      this.baseHref = new Href(this.requestUri);
      if (this.baseHref.toString().indexOf("javascript:") == -1)
      {
        HashMap parameterMap = normalHref.getParameterMap();
        this.baseHref.addParameterMap(parameterMap);
      }
    }
    else
    {
      this.baseHref = normalHref;
    }
  }
  
  private String encodeParamter(String parameterName)
  {
    if (this.tableParameterIdentifier == null)
    {
      String stringIdentifier = "x" + getId() + this.name;
      
      char[] charArray = stringIdentifier.toCharArray();
      
      int checkSum = 0;
      for (int j = 0; j < charArray.length; j++) {
        checkSum += charArray[j] * j;
      }
      this.tableParameterIdentifier = ("d-" + checkSum + "-");
    }
    return this.tableParameterIdentifier + parameterName;
  }
  
  public void release()
  {
    super.release();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.taglibs.PaginationTag
 * JD-Core Version:    0.7.0.1
 */