package ps.edu.diyar.reporting.dataSources;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import ps.edu.diyar.common.tools.CharToUnicode;

public class StudScholarshipDataSource
  implements JRDataSource
{
  private Object[][] data = (Object[][])null;
  private int index = -1;
  private int dataLength = 0;
  
  public StudScholarshipDataSource() {}
  
  public int getIndex()
  {
    return this.index;
  }
  
  public void setIndex(int index)
  {
    this.index = index;
  }
  
  public StudScholarshipDataSource(Object[][] data)
  {
    this.data = data;
    this.index = -1;
    this.dataLength = data.length;
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
    Object value = " ";
    
    String fieldName = field.getName();
    if ("schrAmt".equals(fieldName)) {
      value = this.data[this.index][0];
    } else if ("schrName".equals(fieldName)) {
      value = this.data[this.index][1];
    }
    return CharToUnicode.getUnicodeValue((String)value);
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.reporting.dataSources.StudScholarshipDataSource
 * JD-Core Version:    0.7.0.1
 */