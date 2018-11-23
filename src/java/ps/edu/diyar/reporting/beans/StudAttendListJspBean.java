package ps.edu.diyar.reporting.beans;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import org.apache.log4j.Logger;
import ps.edu.diyar.common.component.DataAccessObjectImpl;
import ps.edu.diyar.common.tools.CharToUnicode;
import ps.edu.diyar.reporting.dataSources.ClassStudentsDataSource;
import ps.edu.diyar.tutorInfo.database.PrtlStudAttendanceVw;
import ps.edu.diyar.tutorInfo.database.PrtlStudAttendanceVwPK;
import ps.edu.diyar.tutorInfo.database.struct.TutorInfoHolder;

public class StudAttendListJspBean
{
  private static Logger logger = Logger.getLogger(StudAttendListJspBean.class);
  
  public byte[] generateReport(HttpServletRequest req, String imgHeaderPath, String imgFooterPath, String reportName)
  {
    byte[] bytes = null;
    try
    {
      TutorInfoHolder tutorInfo = (TutorInfoHolder)((List)req.getSession().getAttribute("tutorInfo")).get(0);
      

      String termNo = req.getParameter("termNo");
      String crsNo = req.getParameter("crsNo");
      String classNo = req.getParameter("classNo");
      


      Collection studentList = new DataAccessObjectImpl().getList("tutor.getStudClassInfoList", new Object[] { termNo, classNo, crsNo, tutorInfo.getEmpNo() });
      if (studentList != null)
      {
        Iterator iter = studentList.iterator();
        String[][] records = new String[studentList.size()][10];
        
        int count = 0;
        while (iter.hasNext())
        {
          PrtlStudAttendanceVw studAttend = (PrtlStudAttendanceVw)iter.next();
          records[count][0] = (count + 1 + "");
          records[count][1] = studAttend.getComp_id().getStudId();
          records[count][2] = (" " + studAttend.getStudName());
          
          count++;
        }
        Map parameters = new HashMap();
        

        parameters.put("imageHeaderPath", imgHeaderPath);
        parameters.put("imgFooterPath", imgFooterPath);
        parameters.put("crsNo", crsNo);
        parameters.put("classNo", classNo);
        parameters.put("tutorName", CharToUnicode.getUnicodeValue(tutorInfo.getTutorLName()));
        parameters.put("termNo", termNo);
        parameters.put("currentTime", new Date().toString());
        parameters.put("userId", tutorInfo.getEmpNo());
        
        JasperReport jasperReport = (JasperReport)JRLoader.loadObject(reportName);
        

        ClassStudentsDataSource dataSrc = new ClassStudentsDataSource(records);
        
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSrc);
        bytes = JasperExportManager.exportReportToPdf(jasperPrint);
      }
      return bytes;
    }
    catch (Exception e)
    {
      e = 
      





        e;logger.error("****** Error in 'StudAttendListJspBean': " + e.getMessage());e.printStackTrace();return bytes;
    }
    finally {}
    //return bytes;
  }
}



/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\

 * Qualified Name:     ps.edu.diyar.reporting.beans.StudAttendListJspBean

 * JD-Core Version:    0.7.0.1

 */