package ps.edu.diyar.admission.useCase;

import java.io.PrintStream;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import ps.edu.diyar.common.component.DataAccessObjectImpl;
import ps.edu.diyar.common.useCase.ComponentUseCase;

public class AdmApplicationLoadDataUseCase
  implements ComponentUseCase
{
  private static Logger logger = Logger.getLogger(AdmApplicationLoadDataUseCase.class);
  
  public Collection execute(Collection input, HttpServletRequest request)
    throws HibernateException
  {
    List retList = null;
    try
    {
      DataAccessObjectImpl cmp = new DataAccessObjectImpl();
      
      List langList = cmp.getList("adm.getLangList");
      if ((langList != null) && (langList.size() > 0)) {
        request.setAttribute("langList", langList);
      }
      List langLevelList = cmp.getList("adm.getLangLevelList");
      if ((langLevelList != null) && (langLevelList.size() > 0)) {
        request.setAttribute("langLevelList", langLevelList);
      }
      List collegelList = cmp.getList("adm.getCollegelList");
      if ((collegelList != null) && (collegelList.size() > 0)) {
        request.setAttribute("collegelList", collegelList);
      }
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
      List maritalStatusList = cmp.getList("adm.getMaritalStatusList");
      if ((maritalStatusList != null) && (maritalStatusList.size() > 0)) {
        request.setAttribute("maritalStatusList", maritalStatusList);
      }
      List healthStatusList = cmp.getList("adm.getHealthStatusList");
      if ((healthStatusList != null) && (healthStatusList.size() > 0)) {
        request.setAttribute("healthStatusList", healthStatusList);
      }
      List certTypesList = cmp.getList("adm.getCertTypesList");
      if ((certTypesList != null) && (certTypesList.size() > 0)) {
        request.setAttribute("certTypesList", certTypesList);
      }
      List jobsList = cmp.getList("adm.getJobsList");
      if ((jobsList != null) && (jobsList.size() > 0)) {
        request.setAttribute("jobsList", jobsList);
      }
      List specDiplomaList = cmp.getList("adm.getSpecDiplomaList");
      if ((specDiplomaList != null) && (specDiplomaList.size() > 0)) {
        request.setAttribute("specDiplomaList", specDiplomaList);
      }
      List specTypesList = cmp.getList("adm.getSpecTypesList");
      if ((specTypesList != null) && (specTypesList.size() > 0)) {
        request.setAttribute("specTypesList", specTypesList);
      }
      List tawOriginList = cmp.getList("adm.getTawOriginList");
      if ((tawOriginList != null) && (tawOriginList.size() > 0)) {
        request.setAttribute("tawOriginList", tawOriginList);
      }
      List tawBranchList = cmp.getList("adm.getTawBranchList");
      if ((tawBranchList != null) && (tawBranchList.size() > 0)) {
        request.setAttribute("tawBranchList", tawBranchList);
      }
    }
    catch (Exception e)
    {
      logger.error("*** AdmApplicationLoadUseCase.execute has ComponentException detials :" + e.toString());
      System.err.println("*** AdmApplicationLoadUseCase.execute has ComponentException detials :" + e.toString());
    }
    return retList;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.admission.useCase.AdmApplicationLoadDataUseCase
 * JD-Core Version:    0.7.0.1
 */