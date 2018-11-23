package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class SrvyHousingCar
  implements Serializable
{
  private SrvyHousingCarPK comp_id;
  private String carType;
  private String carYear;
  private Integer carCount;
  
  public SrvyHousingCar(SrvyHousingCarPK comp_id, String carType, String carYear, Integer carCount)
  {
    this.comp_id = comp_id;
    this.carType = carType;
    this.carYear = carYear;
    this.carCount = carCount;
  }
  
  public SrvyHousingCar() {}
  
  public SrvyHousingCar(SrvyHousingCarPK comp_id)
  {
    this.comp_id = comp_id;
  }
  
  public SrvyHousingCarPK getComp_id()
  {
    return this.comp_id;
  }
  
  public void setComp_id(SrvyHousingCarPK comp_id)
  {
    this.comp_id = comp_id;
  }
  
  public String getCarType()
  {
    return this.carType;
  }
  
  public void setCarType(String carType)
  {
    this.carType = carType;
  }
  
  public String getCarYear()
  {
    return this.carYear;
  }
  
  public void setCarYear(String carYear)
  {
    this.carYear = carYear;
  }
  
  public Integer getCarCount()
  {
    return this.carCount;
  }
  
  public void setCarCount(Integer carCount)
  {
    this.carCount = carCount;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("comp_id", getComp_id()).toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof SrvyHousingCar)) {
      return false;
    }
    SrvyHousingCar castOther = (SrvyHousingCar)other;
    return new EqualsBuilder().append(getComp_id(), castOther.getComp_id()).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getComp_id()).toHashCode();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.database.SrvyHousingCar
 * JD-Core Version:    0.7.0.1
 */