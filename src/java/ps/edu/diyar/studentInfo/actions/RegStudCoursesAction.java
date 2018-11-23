package ps.edu.diyar.studentInfo.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import ps.edu.diyar.common.component.ServletContextAttribute;
import ps.edu.diyar.common.tools.SessionTraker;
import ps.edu.diyar.deptMaster.database.struct.DeptMasterInfoHolder;
import ps.edu.diyar.studentInfo.component.StudCourseRegComponent;
import ps.edu.diyar.studentInfo.database.PrtlRegStudApprove;
import ps.edu.diyar.studentInfo.database.PrtlRegStudApprovePK;
import ps.edu.diyar.studentInfo.database.RegStud;
import ps.edu.diyar.studentInfo.database.RegStudPK;
import ps.edu.diyar.studentInfo.database.struct.MsCoursesList;
import ps.edu.diyar.studentInfo.database.struct.StudentInfoHolder;
import ps.edu.diyar.studentInfo.useCase.StudnetRegisteredCoursesListUseCase;

public class RegStudCoursesAction
  extends Action
{
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    if (!SessionTraker.isSessionExist(request)) {
      return mapping.findForward("invalidAccess");
    }
    if (!request.getMethod().equalsIgnoreCase("POST"))
    {
      ActionMessages errors = new ActionMessages();
      errors.add("error.errorOccuered", new ActionMessage("portal.error.internalMessage", "Invalid Access Method!"));
      saveErrors(request, errors);
      return mapping.findForward("result");
    }
    String studId = "";
    String userId = "";
    if (request.getSession().getAttribute("studentInfo") != null)
    {
      StudentInfoHolder studInfo = (StudentInfoHolder)((List)request.getSession().getAttribute("studentInfo")).get(0);
      studId = studInfo.getStudentId();
      userId = studId;
    }
    else if (request.getSession().getAttribute("deptMaster") != null)
    {
      DeptMasterInfoHolder deptMasterInfoHolder = (DeptMasterInfoHolder)((List)request.getSession().getAttribute("deptMaster")).get(0);
      userId = deptMasterInfoHolder.getEmpNo();
      studId = request.getParameter("stud_id");
    }
    else
    {
      return mapping.findForward("invalidAccess");
    }
    String process = request.getParameter("p");
    


    int regHoursSum = 0;
    int minHours = Integer.parseInt((String)request.getSession().getAttribute("minLoad"));
    int maxHours = Integer.parseInt((String)request.getSession().getAttribute("maxLoad"));
    int prevNewHsum = Integer.parseInt(request.getParameter("prevNewHsum"));
    
    request.removeAttribute("regApp");
    


    ServletContextAttribute servletContextAtt = new ServletContextAttribute(request);
    String regTerm = servletContextAtt.getCrsRegTerm();
    Enumeration enumer = request.getParameterNames();
    String result = null;
    
    ArrayList courses = new ArrayList();
    try
    {
      regHoursSum = Integer.parseInt(request.getParameter("newLoadHours") != null ? request.getParameter("newLoadHours") : "0");
      int new_reg_hours_sum = 0;
      while (enumer.hasMoreElements())
      {
        String paraName = (String)enumer.nextElement();
        if (paraName.startsWith("cbx_"))
        {
          StringTokenizer tk = new StringTokenizer(paraName, "_");
          String cbx = tk.nextToken();
          String crsNo = tk.nextToken();
          String classNo = tk.nextToken().substring(1);
          

          String crsInfo = request.getParameter("cri_" + crsNo + "_c" + classNo);
          String crHrs = crsInfo.substring(crsInfo.indexOf("h") + 1, crsInfo.lastIndexOf("_"));
          
          RegStud regCrs = new RegStud();
          RegStudPK regCrsPk = new RegStudPK();
          regCrs.setComp_id(regCrsPk);
          regCrs.getComp_id().setStudId(studId);
          regCrs.getComp_id().setTermNo(regTerm);
          regCrs.getComp_id().setCrsNo(crsNo);
          regCrs.setCrsClass(classNo);
          regCrs.setCrsHrs(new Short(crHrs));
          regCrs.setTimeStamp(new Date());
          regCrs.setUserId(userId);
          courses.add(regCrs);
          new_reg_hours_sum += Integer.parseInt(crHrs);
        }
      }
      PrtlRegStudApprove regApp = new PrtlRegStudApprove();
      PrtlRegStudApprovePK regAppPK = new PrtlRegStudApprovePK();
      
      regAppPK.setStudId(studId);
      regAppPK.setTermNo(regTerm);
      
      Object currentRegCalItem = request.getSession().getAttribute("currentRegCalItem");
      if (currentRegCalItem != null) {
        regAppPK.setCalendarItem((String)currentRegCalItem);
      } else {
        throw new Exception("No Current Calendar Item Avaliable!");
      }
      regApp.setComp_id(regAppPK);
      regApp.setUserId(userId);
      if (process.equalsIgnoreCase("1"))
      {
        regApp.setRegSave("Y");
        regApp.setRegSaveDate(new Date());
      }
      else if (process.equalsIgnoreCase("2"))
      {
        regApp.setRegApp("Y");
        regApp.setRegAppDate(new Date());
      }
      int new_load = getRegisteredHrs(studId, regTerm, request) + new_reg_hours_sum;
      if (new_load > maxHours)
      {
        result = "لقد تجاوزت الحد الاعلى لعدد الساعات المسموح تسجيله: " + maxHours;
      }
      else if (((regHoursSum >= minHours) && (process.equalsIgnoreCase("2"))) || (process.equalsIgnoreCase("1")))
      {
        StudCourseRegComponent comp = new StudCourseRegComponent();
        result = comp.saveCourses(studId, regTerm, courses, regApp, prevNewHsum);
        if (((result == null) || (result.length() <= 0)) && (process.equalsIgnoreCase("1")))
        {
          request.setAttribute("regApp", "Y");
          result = "تمت عملية التسجيل";
        }
        else if (((result == null) || (result.length() <= 0)) && (process.equalsIgnoreCase("2")))
        {
          request.setAttribute("regApp", "Y");
          result = "تمت عملية التثبيت";
        }
      }
      else
      {
        result = "عدد الساعات المسجلة اقل من " + minHours + "ساعات ,لا يمكنك تثبيت التسجيل";
      }
      request.setAttribute("processId", process);
      request.setAttribute("studId", studId);
      ActionMessages errors;
      return mapping.findForward("result");
    }
    catch (Exception e)
    {
      e.printStackTrace();
      ActionMessages errors;
      return mapping.findForward("result");
    }
    finally
    {
      ActionMessages errors = new ActionMessages();
      errors.add("error.errorOccuered", new ActionMessage("portal.error.internalMessage", result));
      saveErrors(request, errors);
    }
   // return mapping.findForward("result");
  }
  
  private int getRegisteredHrs(String studId, String regTerm, HttpServletRequest request)
  {
    int load = 0;
    

    ArrayList regCrsInput = new ArrayList();
    regCrsInput.add(studId);
    regCrsInput.add(regTerm);
    Collection registeredCourses = new StudnetRegisteredCoursesListUseCase().execute(regCrsInput, request);
    if ((registeredCourses != null) && (registeredCourses.size() > 0))
    {
      request.setAttribute("registeredCourses", registeredCourses);
      Iterator itr = registeredCourses.iterator();
      int newLoad = 0;
      while (itr.hasNext())
      {
        MsCoursesList regStud = (MsCoursesList)itr.next();
        if (regStud.getCrsHrs() != null) {
          newLoad += Integer.parseInt(regStud.getCrsHrs());
        }
      }
      load = newLoad;
    }
    return load;
  }
}



/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\

 * Qualified Name:     ps.edu.diyar.studentInfo.actions.RegStudCoursesAction

 * JD-Core Version:    0.7.0.1

 */