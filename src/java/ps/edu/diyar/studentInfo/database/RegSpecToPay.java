package ps.edu.diyar.studentInfo.database;

public class RegSpecToPay
{
  private String specNo;
  private Integer toPay;
  private Integer termExtraFees;
 private Integer summerTermExtraFees;

    public RegSpecToPay(String specNo, Integer toPay, Integer termExtraFees, Integer summerTermExtraFees) {
        this.specNo = specNo;
        this.toPay = toPay;
        this.termExtraFees = termExtraFees;
        this.summerTermExtraFees = summerTermExtraFees;
    }

    public RegSpecToPay() {
    }

 
 
 
    public String getSpecNo() {
        return specNo;
    }

    public void setSpecNo(String specNo) {
        this.specNo = specNo;
    }
  
   
 

    public Integer getToPay() {
        return toPay;
    }

    public void setToPay(Integer toPay) {
        this.toPay = toPay;
    }

    public Integer getTermExtraFees() {
        return termExtraFees;
    }

    public void setTermExtraFees(Integer termExtraFees) {
        this.termExtraFees = termExtraFees;
    }

    public Integer getSummerTermExtraFees() {
        return summerTermExtraFees;
    }

    public void setSummerTermExtraFees(Integer summerTermExtraFees) {
        this.summerTermExtraFees = summerTermExtraFees;
    }
  
  
   
   
     
}


 