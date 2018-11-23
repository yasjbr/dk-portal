package ps.edu.diyar.studentInfo.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
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
import ps.edu.diyar.deptMaster.database.struct.DeptMasterInfoHolder;
import ps.edu.diyar.studentInfo.component.StudentInfoComponent;
import ps.edu.diyar.studentInfo.database.PrtlStudBalanceVw;
import ps.edu.diyar.studentInfo.database.struct.StudentInfoHolder;
import ps.edu.diyar.studentInfo.useCase.GetStudentInfoUseCase;
import ps.edu.diyar.studentInfo.useCase.ShowTermSummaryUseCase;
import ps.edu.diyar.studentInfo.useCase.StudMsCrsListUseCase;

public class StudMsCrsListAction
  extends Action
{
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    if (!SessionTraker.isSessionExist(request)) {
      return mapping.findForward("invalidAccess");
    }
    String msNo = "";
    String specNo = "";
    String studId = "";
    if (request.getSession().getAttribute("studentInfo") != null)
    {
      StudentInfoHolder studentInfo = (StudentInfoHolder)((List)request.getSession().getAttribute("studentInfo")).get(0);
      studId = studentInfo.getStudentId();
      specNo = studentInfo.getSpecializationNo();
      msNo = studentInfo.getMajorSheet();
      
      StudentInfoComponent termSummaryCmp = new StudentInfoComponent();
      List financialList2 = null;
      financialList2 = termSummaryCmp.getStudentFinancialTermsDebt(new Object[] { studentInfo.getStudentId(), studentInfo.getCurrentTermNo() });
      if (financialList2.size() != 0)
      {
        PrtlStudBalanceVw sasStudBalanceTemp = (PrtlStudBalanceVw)financialList2.get(0);
        Double termBalance = sasStudBalanceTemp.getTermBalance();
         System.out.println("term balance,,,"+termBalance);
        if (termBalance.doubleValue() < 0.0D) {
            System.out.println("term balance    ........."+termBalance);
          request.setAttribute("Error", "Error");
        }
      }
    }
    else if (request.getSession().getAttribute("deptMaster") != null)
    {
      DeptMasterInfoHolder deptMasterInfo = (DeptMasterInfoHolder)((List)request.getSession().getAttribute("deptMaster")).get(0);
      String deptNo = deptMasterInfo.getDeptNo();
      
      studId = request.getParameter("studId");
      ArrayList input = new ArrayList();
      input.add(studId);
      Collection retList = new GetStudentInfoUseCase().execute(input, request);
      if ((retList != null) && (retList.size() > 0))
      {
        StudentInfoHolder studentInfoHolder = (StudentInfoHolder)retList.iterator().next();
        if ((studentInfoHolder.getDeptNo() != null) && (deptNo != null) && (!studentInfoHolder.getDeptNo().equals(deptNo)))
        {
          ActionMessages errors = new ActionMessages();
          errors.add("error.errorOccuered", new ActionMessage("portal.error.studNotInDpt"));
          saveErrors(request, errors);
          return mapping.findForward("failed");
        }
        studId = studentInfoHolder.getStudentId();
        specNo = studentInfoHolder.getSpecializationNo();
        msNo = studentInfoHolder.getMajorSheet();
        
        request.setAttribute("studViwedInfo", retList);
      }
      else
      {
        ActionMessages errors = new ActionMessages();
        errors.add("error.errorOccuered", new ActionMessage("portal.error.studNotInDpt"));
        saveErrors(request, errors);
        return mapping.findForward("failed");
      }
    }
    ArrayList input = new ArrayList();
    input.add(studId);
    input.add(specNo);
    input.add(msNo);
    

    Collection res = new StudMsCrsListUseCase().execute(input, request);
    if ((res != null) && (res.size() > 0)) {
      request.setAttribute("studMsCrs", res);
        System.out.println("shanata");
        
    }
    Collection currentTermSummary = new ShowTermSummaryUseCase().execute(new ArrayList(), request);
    if ((currentTermSummary != null) && (currentTermSummary.size() != 0)) {
      request.setAttribute("selectedTermSummary", currentTermSummary);
       System.out.println("batta");
    }
    return mapping.findForward("success");
  }
}
