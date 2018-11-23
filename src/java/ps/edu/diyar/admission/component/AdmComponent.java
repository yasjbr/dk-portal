package ps.edu.diyar.admission.component;

import java.io.PrintStream;
import java.util.List;
import ps.edu.diyar.common.component.DataAccessObjectImpl;

public class AdmComponent
{
  public List getAdmAccountInfo(String userId, String userPwd)
  {
    List retList = null;
    try
    {
      retList = new DataAccessObjectImpl().getList("adm.getAdmAccountInfo", new Object[] { userId, userPwd });
    }
    catch (Exception e)
    {
      System.err.println("Error in AdmComponent.getAdmAccountInfo :" + e);
    }
    return retList;
  }
  
  public List getAdmApplicationLoadData(String appNo, String admTermNo)
  {
    List retList = null;
    try
    {
      retList = new DataAccessObjectImpl().getList("adm.getAdmApplicationLoadData", new Object[] { appNo, admTermNo });
    }
    catch (Exception e)
    {
      System.err.println("Error in AdmComponent.getAdmApplicationLoadData :" + e);
    }
    return retList;
  }
  
  public List getAdmEduInfo(String appNo)
  {
    List retList = null;
    try
    {
      retList = new DataAccessObjectImpl().getList("adm.getAdmEduInfo", new Object[] { appNo });
    }
    catch (Exception e)
    {
      System.err.println("Error in AdmComponent.getAdmEduInfo :" + e);
    }
    return retList;
  }
  
  public List getAdmLangInfo(String appNo)
  {
    List retList = null;
    try
    {
      retList = new DataAccessObjectImpl().getList("adm.getAdmLangInfo", new Object[] { appNo });
    }
    catch (Exception e)
    {
      System.err.println("Error in AdmComponent.getAdmLangInfo :" + e);
    }
    return retList;
  }
  
  public List getAdmStatus(String statId)
  {
    List retList = null;
    try
    {
      retList = new DataAccessObjectImpl().getList("adm.getAdmStatus", new Object[] { statId });
    }
    catch (Exception e)
    {
      System.err.println("Error in AdmComponent.getAdmStatus :" + e);
    }
    return retList;
  }
  
  public List checkAppNoInPrvTerm(String appNo, String admTerm)
  {
    List retList = null;
    try
    {
      retList = new DataAccessObjectImpl().getList("adm.getAppNoInPrvTerm", new Object[] { appNo, admTerm });
    }
    catch (Exception e)
    {
      System.err.println("Error in AdmComponent.checkAppNoInPrvTerm :" + e);
    }
    return retList;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.admission.component.AdmComponent
 * JD-Core Version:    0.7.0.1
 */