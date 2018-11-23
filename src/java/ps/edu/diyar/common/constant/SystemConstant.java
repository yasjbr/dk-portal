package ps.edu.diyar.common.constant;

public class SystemConstant
{
  public static final int STUDENT = 1;
  public static final int TUTOR = 2;
  public static final int DEPT_MASTER = 3;
  public static final int COLG_MASTER = 4;
  public static String SUCCESS = "success";
  public static String FAIL = "fail";
  public static String SEARCH_NOT_FOUND_RESULT = "searchNotFoundResult";
  
  public static abstract interface SESSION_ATTRIBUTE
  {
    public static final String STUD_ALLOW_LOGIN = "studAllowLogin";
    public static final String SHOW_PAY_REPORT = "showPayRep";
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.common.constant.SystemConstant
 * JD-Core Version:    0.7.0.1
 */