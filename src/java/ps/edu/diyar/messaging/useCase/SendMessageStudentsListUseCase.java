package ps.edu.diyar.messaging.useCase;

import java.util.Collection;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import ps.edu.diyar.common.useCase.ComponentUseCase;
import ps.edu.diyar.tutorInfo.component.TutorTermScheduleComponent;

public class SendMessageStudentsListUseCase
  implements ComponentUseCase
{
  private static Logger logger = Logger.getLogger(SendMessageStudentsListUseCase.class);
  
  public Collection execute(Collection input, HttpServletRequest request)
    throws HibernateException
  {
    List retList = null;
    String termNo = "";
    StringBuffer queryConditionTemp = new StringBuffer();
    
    Enumeration enumer = request.getParameterNames();
    while (enumer.hasMoreElements())
    {
      String parameter = (String)enumer.nextElement();
      if (parameter.startsWith("sendMsg_"))
      {
        String paramValue = request.getParameter(parameter);
        
        String classNo = paramValue.substring(paramValue.indexOf("classNo=") + 8, paramValue.indexOf("_a_"));
        String crsNo = paramValue.substring(paramValue.indexOf("crsNo=") + 6, paramValue.indexOf("_b_"));
        
        request.setAttribute("classNo", classNo);
        request.setAttribute("crsNo", crsNo);
        
        queryConditionTemp.append("(a.comp_id.crsNo ='" + crsNo + "' and a.crsClass ='" + classNo + "') or ");
        
        termNo = paramValue.substring(paramValue.indexOf("term=") + 5);
        
          System.out.println("term_no is /////////////  "+ termNo);
      }
    }
    String queryCondition = null;
    if (queryConditionTemp.length() > 0) {
      queryCondition = queryConditionTemp.toString().substring(0, queryConditionTemp.toString().lastIndexOf("or"));
    }
    try
    {
      if ((queryCondition != null) && (!queryCondition.equals("")))
      {
        TutorTermScheduleComponent cmp = new TutorTermScheduleComponent();
        retList = cmp.getStudentListForMultiCourse(new Object[] { termNo, queryCondition });
      }
      return retList;
    }
    catch (Exception ce)
    {
      ce =   ce;
      
      logger.error("Error in SendMessageStudentsListUseCase " + ce);
      ce.printStackTrace();
        
        return retList;
    }
    finally {}
    //return retList;
  }
}

 