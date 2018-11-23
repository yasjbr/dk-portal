package ps.edu.diyar.common.utils.pagination;

import java.io.IOException;
import java.util.Properties;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TableProperties
{
  private static Log log = LogFactory.getLog(TableProperties.class);
  public static final String PROPERTY_STRING_PAGING_PAGE_LINK = "paging.banner.page.link";
  public static final String PROPERTY_STRING_PAGING_PAGE_SELECTED = "paging.banner.page.selected";
  public static final String PROPERTY_STRING_PAGING_PAGE_SPARATOR = "paging.banner.page.separator";
  public static final String PROPERTY_STRING_PAGING_BANNER_FULL = "paging.banner.full";
  public static final String PROPERTY_STRING_PAGING_BANNER_LAST = "paging.banner.last";
  public static final String PROPERTY_STRING_PAGING_BANNER_FIRST = "paging.banner.first";
  public static final String PROPERTY_STRING_PAGING_BANNER_ONEPAGE = "paging.banner.onepage";
  private static final String PROPERTY_INT_PAGING_GROUPSIZE = "paging.banner.group_size";
  private Properties properties = null;
  
  public TableProperties()
    throws IOException
  {
    Properties defaultProperties = new Properties();
    
    defaultProperties.load(getClass().getResourceAsStream("Table.properties"));
    
    this.properties = new Properties(defaultProperties);
  }
  
  public String getPagingBannerOnePage()
  {
    return getProperty("paging.banner.onepage");
  }
  
  public String getPagingBannerFirst()
  {
    return getProperty("paging.banner.first");
  }
  
  public String getPagingBannerLast()
  {
    return getProperty("paging.banner.last");
  }
  
  public String getPagingBannerFull()
  {
    return getProperty("paging.banner.full");
  }
  
  public String getPagingPageLink()
  {
    return getProperty("paging.banner.page.link");
  }
  
  public String getPagingPageSelected()
  {
    return getProperty("paging.banner.page.selected");
  }
  
  public String getPagingPageSeparator()
  {
    return getProperty("paging.banner.page.separator");
  }
  
  private String getProperty(String key)
  {
    return this.properties.getProperty(key);
  }
  
  public int getPagingGroupSize(int defaultValue)
  {
    return getIntProperty("paging.banner.group_size", defaultValue);
  }
  
  private int getIntProperty(String key, int defaultValue)
  {
    int intValue = defaultValue;
    try
    {
      intValue = Integer.parseInt(getProperty(key));
    }
    catch (NumberFormatException e)
    {
      log.warn("Invalid value for \"pPropertyName\" property: value=\"" + getProperty(key) + "\"; using default \"pDefault\"");
    }
    return intValue;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.common.utils.pagination.TableProperties
 * JD-Core Version:    0.7.0.1
 */