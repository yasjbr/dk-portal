package ps.edu.diyar.admission.component;

import javax.servlet.http.HttpServletRequest;

public class CommonOperationMessage
{
  public static void updateSuccess(HttpServletRequest request)
  {
    operationMessage(request, "CommonOperationMessage.update.success");
  }
  
  public static void updateFailed(HttpServletRequest request)
  {
    operationMessage(request, "CommonOperationMessage.update.failed");
  }
  
  public static void addSuccess(HttpServletRequest request)
  {
    operationMessage(request, "CommonOperationMessage.add.success");
  }
  
  public static void addFailed(HttpServletRequest request)
  {
    operationMessage(request, "CommonOperationMessage.add.failed");
  }
  
  public static void deleteSuccess(HttpServletRequest request)
  {
    operationMessage(request, "CommonOperationMessage.delete.success");
  }
  
  public static void deleteFailed(HttpServletRequest request)
  {
    operationMessage(request, "CommonOperationMessage.delete.failed");
  }
  
  public static void uploadSuccess(HttpServletRequest request)
  {
    operationMessage(request, "CommonOperationMessage.upload.success");
  }
  
  public static void uploadFailed(HttpServletRequest request)
  {
    operationMessage(request, "CommonOperationMessage.upload.failed");
  }
  
  public static void saveSuccess(HttpServletRequest request)
  {
    operationMessage(request, "CommonOperationMessage.save.success");
  }
  
  public static void saveFailed(HttpServletRequest request)
  {
    operationMessage(request, "CommonOperationMessage.save.failed");
  }
  
  public static void operationMs(HttpServletRequest request, String ms)
  {
    operationMessage(request, ms);
  }
  
  public static void operationSuccess(HttpServletRequest request)
  {
    operationMessage(request, "CommonOperationMessage.operation.success");
  }
  
  public static void operationFailed(HttpServletRequest request)
  {
    operationMessage(request, "CommonOperationMessage.operation.failed");
  }
  
  public static void refreshSuccess(HttpServletRequest request)
  {
    operationMessage(request, "CommonOperationMessage.refresh.success");
  }
  
  public static void refreshFailed(HttpServletRequest request)
  {
    operationMessage(request, "CommonOperationMessage.refresh.failed");
  }
  
  public static void operationMessage(HttpServletRequest request, String msKey)
  {
    request.setAttribute("operationMessage", msKey);
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.admission.component.CommonOperationMessage
 * JD-Core Version:    0.7.0.1
 */