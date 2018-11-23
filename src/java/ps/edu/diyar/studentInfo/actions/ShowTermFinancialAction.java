/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ps.edu.diyar.studentInfo.actions;

import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
import ps.edu.diyar.studentInfo.useCase.StudentTermFinancialSummaryUseCase;
import ps.edu.diyar.studentInfo.useCase.StudentTermsListUseCase;

/**
 *
 * @author Yaseen Jaber
 */
public class ShowTermFinancialAction 
    
 extends Action
{
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    if (!SessionTraker.isSessionExist(request)) {
      return mapping.findForward("invalidAccess");
    }
    ActionMessage message = null;
    ActionMessages messages = new ActionMessages();
    
    HttpSession session = request.getSession();
      System.out.println("printed here");
      ///// to set current system term not max financial term
     request.setAttribute("fin", "111");
    Collection currentTermFinancial = new  ShowTermFinancialUseCase().execute(new ArrayList(), request);
    Collection currentTermFinancialDetail = new  ShowTermFinancialDetalUseCase().execute(new ArrayList(), request);
    if ((currentTermFinancial != null) && (currentTermFinancial.size() != 0)) {
         System.out.println("vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv");  
      request.setAttribute("selectedTermFinancial", currentTermFinancial);
      request.setAttribute("selectedTermFinancialDetail", currentTermFinancialDetail);
    }
    else{
      System.out.println("vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv");  
    }
    Collection termsList = new StudentTermsListUseCase().execute(new ArrayList(), request);
    if ((termsList != null) && (termsList.size() != 0)) {
      session.setAttribute("termsList", termsList);
    }
    if (request.getAttribute("Error") != null)
    {
      message = new ActionMessage("studentInfo.messages.NotBalance");
      messages.add("org.apache.struts.action.GLOBAL_MESSAGE", message);
      saveErrors(request, messages);
    }
    return mapping.findForward("success");
  }
}

