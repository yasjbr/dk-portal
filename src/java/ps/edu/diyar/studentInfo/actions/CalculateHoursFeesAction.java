package ps.edu.diyar.studentInfo.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
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
import ps.edu.diyar.admission.component.CommonOperationMessage;
import ps.edu.diyar.colgMaster.usecase.GetColgMasterInfoUseCase;
import ps.edu.diyar.deptMaster.usecase.GetDeptMasterInfoUseCase;
import ps.edu.diyar.login.database.struct.UserInfo;
import ps.edu.diyar.login.forms.LoginForm;
import ps.edu.diyar.login.usecase.LoginUseCase;
import ps.edu.diyar.messaging.database.PrtlNotifications;
import ps.edu.diyar.messaging.forms.CalculateHoursFeesForm;
import ps.edu.diyar.studentInfo.component.StudentInfoComponent;
import ps.edu.diyar.studentInfo.database.RegSpecToPay;
import ps.edu.diyar.studentInfo.database.struct.StudentInfoHolder;
import ps.edu.diyar.studentInfo.forms.StudSasInitialFinancialForm;
import ps.edu.diyar.studentInfo.useCase.ChkShowPrintPayRepUseCase;
import ps.edu.diyar.studentInfo.useCase.GetNotificationsUseCase;
import ps.edu.diyar.studentInfo.useCase.GetStudentInfoUseCase;
import ps.edu.diyar.studentInfo.useCase.SasInitiateStudFinincialUseCase;
import ps.edu.diyar.studentInfo.useCase.UpdatePasswordUseCase;
import ps.edu.diyar.tutorInfo.useCase.GetTutorInfoUseCase;

public class CalculateHoursFeesAction
        extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // CalculateHoursFeesForm item = (CalculateHoursFeesForm) form;
        StudSasInitialFinancialForm inForm = (StudSasInitialFinancialForm) form;
        ActionMessages errors = new ActionMessages();

        String hours = inForm.getHours().trim();
        if ((hours == null) || (hours.trim().equals(""))) {
         
             hours="0";
         }
          
         int total=0;
        HttpSession session = request.getSession(true);

        ArrayList input = new ArrayList();

        StudentInfoHolder studInfo = (StudentInfoHolder) ((List) session.getAttribute("studentInfo")).get(0);

        String specNo = studInfo.getSpecializationNo();
        System.out.println("specccccccccccccccccc0000000    " + specNo);
        StudentInfoComponent studCmp = new StudentInfoComponent();
        List studHoursFeesToPayList = null;
        studHoursFeesToPayList = studCmp.getStudHoursFeesToPay(specNo);

        if ((studHoursFeesToPayList != null) && (studHoursFeesToPayList.size() > 0)) {
             System.out.println("222 yas   " +hours);
            RegSpecToPay res = (RegSpecToPay) studHoursFeesToPayList.iterator().next();
          System.out.println("res ok 1 ");
            int extra = res.getTermExtraFees();
             System.out.println("res ok  2");
            int to1 = (int) (res.getToPay() * Integer.parseInt(hours) * 0.3);
             System.out.println("res ok 3 ----  "+res.getToPay() * Integer.parseInt(hours));
            total = to1 + extra;
            System.out.println("to pay ---------------  " + total);
            request.setAttribute("total", total);
              request.setAttribute("sum", res.getToPay() * Integer.parseInt(hours));

            request.setAttribute("studHoursFeesToPayList", studHoursFeesToPayList);

        }
        System.out.println("vvvvvvvvvvvv" + request.getSession().getAttribute("initialTerm"));
        //  request.getAttribute("initialTerm");
        input.add(studInfo.getStudentId());
        input.add(request.getSession().getAttribute("initialTerm"));

        // request.getSession().getAttribute("initialTerm");
        input.add("19");

         input.add(String.valueOf(total));
System.out.println("before result");
        Collection result = new SasInitiateStudFinincialUseCase().execute(input, request);
System.out.println("after result");
        if ((result != null) && (result.size() > 0)) {
 System.out.println("result != null");
        } else {
            
             System.out.println("result = null");

        }

        /**
         * *
         * insert record into current term financial
         */
        /**
         *
         */
        return mapping.findForward("calculate");
    }
}
