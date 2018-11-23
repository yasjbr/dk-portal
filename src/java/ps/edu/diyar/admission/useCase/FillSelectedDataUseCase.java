package ps.edu.diyar.admission.useCase;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import ps.edu.diyar.common.useCase.ComponentUseCase;

public class FillSelectedDataUseCase
  implements ComponentUseCase
{
  private static Logger logger = Logger.getLogger(FillSelectedDataUseCase.class);
  
  public Collection execute(Collection input, HttpServletRequest request)
    throws HibernateException
  {
    List retList = null;
    boolean falg = false;
    String collegeNo = null;
    String perCountry = null;
    String currCountry = null;
    String birthCountry = null;
    String schoolCountry = null;
    String eduUcCountry_1 = null;
    String eduUcCountry_2 = null;
    String eduUcCountry_3 = null;
    String perGovernate = null;
    String currGovernate = null;
    String birthGovernate = null;
    String schoolGovernate = null;
    String eduUcGovernate_1 = null;
    String eduUcGovernate_2 = null;
    String eduUcGovernate_3 = null;
    

    Iterator iter = input.iterator();
    String gender = (String)iter.next();
    if (iter.hasNext())
    {
      falg = true;
      collegeNo = (String)iter.next();
      perCountry = (String)iter.next();
      currCountry = (String)iter.next();
      birthCountry = (String)iter.next();
      schoolCountry = (String)iter.next();
      eduUcCountry_1 = (String)iter.next();
      eduUcCountry_2 = (String)iter.next();
      eduUcCountry_3 = (String)iter.next();
      perGovernate = (String)iter.next();
      currGovernate = (String)iter.next();
      birthGovernate = (String)iter.next();
      schoolGovernate = (String)iter.next();
      eduUcGovernate_1 = (String)iter.next();
      eduUcGovernate_2 = (String)iter.next();
      eduUcGovernate_3 = (String)iter.next();
    }
    try
    {
      ArrayList inp = new ArrayList();
      inp.add(gender);
      Collection resultList = new GetNationalityListUseCase().execute(inp, request);
      if ((resultList != null) && (resultList.size() > 0)) {
        request.setAttribute("genderMList", resultList);
      }
      if (falg)
      {
        if (isSelected(collegeNo))
        {
          resultList = null;
          inp.clear();
          inp.add(collegeNo);
          resultList = new GetSpecsOfCollegeNoListUseCase().execute(inp, request);
          if ((resultList != null) && (resultList.size() > 0)) {
            request.setAttribute("specsCollegeList", resultList);
          }
        }
        if (isSelected(perCountry))
        {
          resultList = null;inp.clear();inp.add(perCountry);resultList = new GetGovernateListUseCase().execute(inp, request);
          if ((resultList != null) && (resultList.size() > 0)) {
            request.setAttribute("perGovernateList", resultList);
          }
        }
        if (isSelected(currCountry))
        {
          resultList = null;inp.clear();inp.add(currCountry);resultList = new GetGovernateListUseCase().execute(inp, request);
          if ((resultList != null) && (resultList.size() > 0)) {
            request.setAttribute("currGovernateList", resultList);
          }
        }
        if (isSelected(birthCountry))
        {
          resultList = null;inp.clear();inp.add(birthCountry);resultList = new GetGovernateListUseCase().execute(inp, request);
          if ((resultList != null) && (resultList.size() > 0)) {
            request.setAttribute("birthGovernateList", resultList);
          }
        }
        if (isSelected(schoolCountry))
        {
          resultList = null;inp.clear();inp.add(schoolCountry);resultList = new GetGovernateListUseCase().execute(inp, request);
          if ((resultList != null) && (resultList.size() > 0)) {
            request.setAttribute("schoolGovernateList", resultList);
          }
        }
        if (isSelected(eduUcCountry_1))
        {
          resultList = null;inp.clear();inp.add(eduUcCountry_1);resultList = new GetGovernateListUseCase().execute(inp, request);
          if ((resultList != null) && (resultList.size() > 0)) {
            request.setAttribute("eduUcGovernate_1List", resultList);
          }
        }
        if (isSelected(eduUcCountry_2))
        {
          resultList = null;inp.clear();inp.add(eduUcCountry_2);resultList = new GetGovernateListUseCase().execute(inp, request);
          if ((resultList != null) && (resultList.size() > 0)) {
            request.setAttribute("eduUcGovernate_2List", resultList);
          }
        }
        if (isSelected(eduUcCountry_3))
        {
          resultList = null;inp.clear();inp.add(eduUcCountry_3);resultList = new GetGovernateListUseCase().execute(inp, request);
          if ((resultList != null) && (resultList.size() > 0)) {
            request.setAttribute("eduUcGovernate_3List", resultList);
          }
        }
        if (isSelected(perGovernate))
        {
          resultList = null;inp.clear();inp.add(perGovernate);inp.add(perCountry);resultList = new GetLocalityListUseCase().execute(inp, request);
          if ((resultList != null) && (resultList.size() > 0)) {
            request.setAttribute("perLocalityList", resultList);
          }
        }
        if (isSelected(currGovernate))
        {
          resultList = null;inp.clear();inp.add(currGovernate);inp.add(currCountry);resultList = new GetLocalityListUseCase().execute(inp, request);
          if ((resultList != null) && (resultList.size() > 0)) {
            request.setAttribute("currLocalityList", resultList);
          }
        }
        if (isSelected(birthGovernate))
        {
          resultList = null;inp.clear();inp.add(birthGovernate);inp.add(birthCountry);resultList = new GetLocalityListUseCase().execute(inp, request);
          if ((resultList != null) && (resultList.size() > 0)) {
            request.setAttribute("birthLocalityList", resultList);
          }
        }
        if (isSelected(schoolGovernate))
        {
          resultList = null;inp.clear();inp.add(schoolGovernate);inp.add(schoolCountry);resultList = new GetLocalityListUseCase().execute(inp, request);
          if ((resultList != null) && (resultList.size() > 0)) {
            request.setAttribute("schoolLocalityList", resultList);
          }
        }
        if (isSelected(eduUcGovernate_1))
        {
          resultList = null;inp.clear();inp.add(eduUcGovernate_1);inp.add(eduUcCountry_1);resultList = new GetLocalityListUseCase().execute(inp, request);
          if ((resultList != null) && (resultList.size() > 0)) {
            request.setAttribute("eduUcLocality_1List", resultList);
          }
        }
        if (isSelected(eduUcGovernate_2))
        {
          resultList = null;inp.clear();inp.add(eduUcGovernate_2);inp.add(eduUcCountry_2);resultList = new GetLocalityListUseCase().execute(inp, request);
          if ((resultList != null) && (resultList.size() > 0)) {
            request.setAttribute("eduUcLocality_2List", resultList);
          }
        }
        if (isSelected(eduUcGovernate_3))
        {
          resultList = null;inp.clear();inp.add(eduUcGovernate_3);inp.add(eduUcCountry_3);resultList = new GetLocalityListUseCase().execute(inp, request);
          if ((resultList != null) && (resultList.size() > 0)) {
            request.setAttribute("eduUcLocality_3List", resultList);
          }
        }
      }
    }
    catch (Exception e)
    {
      retList = new ArrayList();
      retList.add(e);
      logger.error("*** FillSelectedDataUseCase.execute has ComponentException detials :" + e.toString());
      System.err.println("*** FillSelectedDataUseCase.execute has ComponentException detials :" + e.toString());
    }
    return retList;
  }
  
  private boolean isSelected(String item)
  {
    boolean res = false;
    if ((item != null) && (!item.equals("")) && (!item.equals("*"))) {
      res = true;
    }
    return res;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.admission.useCase.FillSelectedDataUseCase
 * JD-Core Version:    0.7.0.1
 */