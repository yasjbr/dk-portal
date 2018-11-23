/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ps.edu.diyar.studentInfo.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import ps.edu.diyar.common.tools.SessionTraker;
import ps.edu.diyar.studentInfo.useCase.ShowTermFinancialDetalUseCase;
import ps.edu.diyar.studentInfo.useCase.ShowTermFinancialUseCase;
import ps.edu.diyar.studentInfo.useCase.ShowTermSummaryUseCase;
import ps.edu.diyar.studentInfo.useCase.StudentTermCourseSummaryUseCase;

/**
 *
 * @author Yaseen Jaber
 */
public class ShowSelectedTermFinancialAction extends Action
{
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
       
    ActionMessage message = null;
    ActionMessages messages = new ActionMessages();
    if (!SessionTraker.isSessionExist(request)) {
      return mapping.findForward("invalidAccess");
    }
      
         
    Collection selectedTermSummary = new ShowTermFinancialUseCase().execute(new ArrayList(), request);
     Collection currentTermFinancialDetail = new  ShowTermFinancialDetalUseCase().execute(new ArrayList(), request);
    if ((selectedTermSummary != null) && (selectedTermSummary.size() != 0)) {
      request.setAttribute("selectedTermFinancial", selectedTermSummary);
         request.setAttribute("selectedTermFinancialDetail", currentTermFinancialDetail);
        System.out.println("h1y");
    }
    /*System.out.println("3");
    List termCourseSummary = (List)new StudentTermCourseSummaryUseCase().execute(new ArrayList(), request);
    if ((termCourseSummary != null) && (termCourseSummary.size() != 0))
    {
         System.out.println("33");
      request.setAttribute("termCourseSummary", termCourseSummary);
    }*/
    else  if (request.getAttribute("Error") != null)
    {
         System.out.println("443");
        System.out.println("hi");
      message = new ActionMessage("studentInfo.messages.NotBalance");
      messages.add("org.apache.struts.action.GLOBAL_MESSAGE", message);
      saveErrors(request, messages);
    }
      System.out.println("dddddddd");
    return mapping.findForward("success");
  }
}

