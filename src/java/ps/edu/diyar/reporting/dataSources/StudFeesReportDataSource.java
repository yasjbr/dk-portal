package ps.edu.diyar.reporting.dataSources;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import ps.edu.diyar.common.tools.CharToUnicode;

public class StudFeesReportDataSource
  implements JRDataSource
{
  private Object[][] reportData = (Object[][])null;
  private int index = -1;
  private int dataLength = 0;
  
  public StudFeesReportDataSource() {}
  
  public StudFeesReportDataSource(Object[][] reportData)
  {
    this.reportData = reportData;
    this.index = -1;
    this.dataLength = reportData.length;
  }
  
  public Object[][] getReportData()
  {
    return this.reportData;
  }
  
  public void setReportData(Object[][] reportData)
  {
    this.reportData = reportData;
    this.index = -1;
    this.dataLength = reportData.length;
  }
  
  public boolean next()
    throws JRException
  {
    this.index += 1;
    return this.index < this.dataLength;
  }
  
  public Object getFieldValue(JRField field)
    throws JRException
  {
    Object value = null;
    
    String fieldName = field.getName();
    if ("serial".equals(fieldName)) {
      value = this.reportData[this.index][0] != null ? this.reportData[this.index][0] : "";
    } else if ("fName".equals(fieldName)) {
      value = this.reportData[this.index][1] != null ? this.reportData[this.index][1] : "";
    } else if ("fVal".equals(fieldName)) {
      value = this.reportData[this.index][2] != null ? this.reportData[this.index][2] : "";
    } else if ("fees_total".equals(fieldName)) {
      value = this.reportData[this.index][3] != null ? this.reportData[this.index][3] : "";
    } else if ("fTotalVal".equals(fieldName)) {
      value = this.reportData[this.index][4] != null ? this.reportData[this.index][4] : "";
    } else if ("fTotalWrd".equals(fieldName)) {
      value = this.reportData[this.index][5] != null ? this.reportData[this.index][5] : "";
    } else {
      value = " ";
    }
    value = CharToUnicode.getUnicodeValue((String)value);
    
    return value;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.reporting.dataSources.StudFeesReportDataSource
 * JD-Core Version:    0.7.0.1
 */