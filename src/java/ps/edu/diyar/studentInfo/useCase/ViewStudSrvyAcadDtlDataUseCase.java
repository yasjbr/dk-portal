package ps.edu.diyar.studentInfo.useCase;

import java.io.PrintStream;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.HibernateException;
import ps.edu.diyar.common.component.DataAccessObjectImpl;
import ps.edu.diyar.common.useCase.ComponentUseCase;

public class ViewStudSrvyAcadDtlDataUseCase
  implements ComponentUseCase
{
  public Collection execute(Collection input, HttpServletRequest request)
    throws HibernateException
  {
    List returnList = null;
    try
    {
      DataAccessObjectImpl cmp = new DataAccessObjectImpl();
      

      List countryList = cmp.getList("adm.getCountrylList");
      if ((countryList != null) && (countryList.size() > 0)) {
        request.setAttribute("countryList", countryList);
      }
      List univColgList = cmp.getList("adm.getUnivColglList");
      if ((univColgList != null) && (univColgList.size() > 0)) {
        request.setAttribute("univColgList", univColgList);
      }
      List schoolList = cmp.getList("adm.getSchoolList");
      if ((schoolList != null) && (schoolList.size() > 0)) {
        request.setAttribute("schoolList", schoolList);
      }
    }
    catch (Exception e)
    {
      System.err.println("*** ViewStudSrvyAcadDtlDataUseCase.execute has ComponentException detials :" + e.toString());
    }
    return returnList;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.useCase.ViewStudSrvyAcadDtlDataUseCase
 * JD-Core Version:    0.7.0.1
 */