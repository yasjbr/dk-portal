package ps.edu.diyar.common.struct;

public class LabelValue
{
  private String label;
  private String value;
  
  public LabelValue() {}
  
  public LabelValue(String label, String value)
  {
    this.label = label;
    this.value = value;
  }
  
  public LabelValue(String label_1, String label_2, String value)
  {
    this.label = (label_1 + " - " + label_2);
    this.value = value;
  }
  
  public LabelValue(String label_1, String label_2, String label_3, String value)
  {
    this.label = (label_1 + " " + label_2 + " " + label_3);
    this.value = value;
  }
  
  public String getLabel()
  {
    return this.label;
  }
  
  public void setLabel(String label)
  {
    this.label = label;
  }
  
  public String getValue()
  {
    return this.value;
  }
  
  public void setValue(String value)
  {
    this.value = value;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.common.struct.LabelValue
 * JD-Core Version:    0.7.0.1
 */