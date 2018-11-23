package ps.edu.diyar.reporting.dataSources;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import ps.edu.diyar.common.tools.CharToUnicode;

public class StudInstallmentDataSource
  implements JRDataSource
{
  private Object[][] banksData = (Object[][])null;
  private int index = -1;
  private int dataLength = 0;
  
  public StudInstallmentDataSource() {}
  
  public int getIndex()
  {
    return this.index;
  }
  
  public void setIndex(int index)
  {
    this.index = index;
  }
  
  public StudInstallmentDataSource(Object[][] banksData)
  {
    this.banksData = banksData;
    this.index = -1;
    this.dataLength = banksData.length;
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
    if ("inst_sril".equals(fieldName)) {
      value = this.banksData[this.index][0];
    } else if ("instDate".equals(fieldName)) {
      value = this.banksData[this.index][1];
    } else if ("instVal".equals(fieldName)) {
      value = this.banksData[this.index][2];
    }
    return CharToUnicode.getUnicodeValue((String)value);
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.reporting.dataSources.StudInstallmentDataSource
 * JD-Core Version:    0.7.0.1
 */