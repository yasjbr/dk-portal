package ps.edu.diyar.messaging.actions;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import ps.edu.diyar.common.tools.SessionTraker;
import ps.edu.diyar.messaging.database.PrtlMessageAttachment;
import ps.edu.diyar.messaging.useCase.DownloadMsgAttUseCase;
import ps.edu.diyar.studentInfo.database.SrvyHealthDetail;
import ps.edu.diyar.studentInfo.database.struct.StudentInfoHolder;
import ps.edu.diyar.studentInfo.useCase.ViewStudSocialHealthDetailUseCase;

public class DownloadMsgAttAction
  extends Action
{
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    if (!SessionTraker.isSessionExist(request)) {
      return mapping.findForward("invalidAccess");
    }
    ArrayList input = new ArrayList();
    String param = mapping.getPrefix();
    if ((param != null) && (param.trim().equals("srvy")))
    {
      StudentInfoHolder studInfo = (StudentInfoHolder)((List)request.getSession().getAttribute("studentInfo")).get(0);
      

      ArrayList inpt = new ArrayList();
      inpt.add(studInfo.getStudentId());
      inpt.add(studInfo.getSystemCurrentTermNo());
      Collection result = new ViewStudSocialHealthDetailUseCase().execute(inpt, request);
      if ((result != null) && (result.size() > 0))
      {
        SrvyHealthDetail obj = (SrvyHealthDetail)result.iterator().next();
        downloadFile(response, obj.getMedicalReport(), obj.getMedicalReportType(), "MedicalReport");
        return null;
      }
    }
    else
    {
      input.add(request.getParameter("id"));
      Collection result = new DownloadMsgAttUseCase().execute(input, request);
      if ((result != null) && (result.size() != 0))
      {
        PrtlMessageAttachment msgAtt = (PrtlMessageAttachment)result.iterator().next();
        downloadFile(response, msgAtt.getFileContent(), msgAtt.getFileType(), msgAtt.getFileName());
        return null;
      }
    }
    return mapping.findForward("downloadResult");
  }
  
  private void downloadFile(HttpServletResponse response, Blob fileContent, String fileType, String fileName)
    throws Exception
  {
    InputStream is = fileContent.getBinaryStream();
    response.setContentType(fileType);
    response.setHeader("Content-Disposition", "inline; filename=" + fileName + ";");
    ServletOutputStream out = response.getOutputStream();
    BufferedInputStream bufferedIo = new BufferedInputStream(is);
    
    int bytesRead = 0;
    byte[] byteArray = new byte[1024];
    boolean isTrue = true;
    while (isTrue)
    {
      bytesRead = bufferedIo.read(byteArray);
      if (bytesRead == -1) {
        break;
      }
      out.write(byteArray);
      out.flush();
    }
    bufferedIo.close();
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.messaging.actions.DownloadMsgAttAction
 * JD-Core Version:    0.7.0.1
 */