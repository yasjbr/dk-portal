package ps.edu.diyar.common.component;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import ps.edu.diyar.studentInfo.database.PrtlSetup;
import ps.edu.diyar.studentInfo.database.RegTerm;

public class ServletContextAttribute
{
  private HttpServletRequest request;
  
  public ServletContextAttribute(HttpServletRequest request)
  {
    this.request = request;
  }
  
  public String getCrsRegTerm()
  {
    String regTerm = "";
    if (this.request.getSession().getAttribute("crsRegTerm") != null)
    {
      regTerm = (String)this.request.getSession().getAttribute("crsRegTerm");
    }
    else
    {
      regTerm = getDbPrtlSetupValue("crsRegTerm");
      this.request.getSession().setAttribute("crsRegTerm", regTerm);
    }
    return regTerm;
  }
  
  public String getCurentTerm()
  {
    String term = "";
    if (this.request.getSession().getAttribute("curentTerm") != null)
    {
      term = (String)this.request.getSession().getAttribute("curentTerm");
    }
    else
    {
      term = getDbPrtlSetupValue("curentTerm");
      this.request.getSession().setAttribute("curentTerm", term);
    }
    return term;
  }
  
  public boolean showRegLink()
  {
    String shwRegLnkVal = "";
    boolean show = false;
    if (this.request.getSession().getAttribute("shwRegLnk") != null)
    {
      shwRegLnkVal = (String)this.request.getSession().getAttribute("shwRegLnk");
    }
    else
    {
      shwRegLnkVal = getDbPrtlSetupValue("shwRegLnk");
      this.request.getSession().setAttribute("shwRegLnk", shwRegLnkVal);
    }
    if ((shwRegLnkVal != null) && (shwRegLnkVal.equals("Y"))) {
      show = true;
    }
    return show;
  }
  
  public boolean termIsIntensive(String termNo)
  {
    Boolean res = Boolean.valueOf(false);
    try
    {
      if (this.request.getSession().getAttribute("crsRegTermIsIntensive") != null)
      {
        res = (Boolean)this.request.getSession().getAttribute("crsRegTermIsIntensive");
      }
      else
      {
        List retList = new DataAccessObjectImpl().getList("portal.getTermInfo", new Object[] { termNo });
        if ((retList != null) && (retList.size() > 0))
        {
          RegTerm termInfo = (RegTerm)retList.iterator().next();
          if ((termInfo.getIsIntensive() != null) && (termInfo.getIsIntensive().equals("Y"))) {
            res = Boolean.valueOf(true);
          }
        }
        this.request.getSession().setAttribute("crsRegTermIsIntensive", res);
      }
    }
    catch (Exception e)
    {
      System.err.println("Error in ServletContextAttribute.getPrtlSetupValue:" + e);
      res = Boolean.valueOf(false);
    }
    return res.booleanValue();
  }
  
  private String getDbPrtlSetupValue(String keyValue)
  {
    String val = "";
    try
    {
      List retList = new DataAccessObjectImpl().getList("portal.getPrtlSetupValue", new Object[] { keyValue });
      if ((retList != null) && (retList.size() > 0))
      {
        PrtlSetup prtlSetup = (PrtlSetup)retList.iterator().next();
        val = prtlSetup.getSetupValue();
      }
    }
    catch (Exception e)
    {
      System.err.println("Error in ServletContextAttribute.getPrtlSetupValue:" + e);
      val = "";
    }
    return val;
  }
}


 