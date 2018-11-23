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
import ps.edu.diyar.admission.useCase.GetAdmTermNoUseCase;
import ps.edu.diyar.common.component.ServletContextAttribute;
import ps.edu.diyar.common.constant.SystemConstant;
import ps.edu.diyar.common.tools.SessionTraker;
import ps.edu.diyar.deptMaster.database.struct.DeptMasterInfoHolder;
import ps.edu.diyar.studentInfo.component.StudentInfoComponent;
import ps.edu.diyar.studentInfo.database.PrtlRegStudApprove;
import ps.edu.diyar.studentInfo.database.PrtlSetup;
import ps.edu.diyar.studentInfo.database.PrtlStudBalanceVw;
import ps.edu.diyar.studentInfo.database.SasFeesToPay;
import ps.edu.diyar.studentInfo.database.SasStudFtermCard;
import ps.edu.diyar.studentInfo.database.struct.MsCoursesList;
import ps.edu.diyar.studentInfo.database.struct.RegStudSetting;
import ps.edu.diyar.studentInfo.database.struct.StudentInfoHolder;
import ps.edu.diyar.studentInfo.useCase.CalendarItemInfoUseCase;
import ps.edu.diyar.studentInfo.useCase.GetAvaliableCoursesListUseCase;
import ps.edu.diyar.studentInfo.useCase.GetMinFinValueUseCase;
import ps.edu.diyar.studentInfo.useCase.GetStudActiveRegCalItemUseCase;
import ps.edu.diyar.studentInfo.useCase.GetStudRegApproveStatusForCalItmUseCase;
import ps.edu.diyar.studentInfo.useCase.GetStudentInfoUseCase;
import ps.edu.diyar.studentInfo.useCase.RegSettingInfoUseCase;
import ps.edu.diyar.studentInfo.useCase.RegistrationPeriodChecksUseCase;
import ps.edu.diyar.studentInfo.useCase.ShowTermFinancialUseCase;
import ps.edu.diyar.studentInfo.useCase.StudnetRegisteredCoursesListUseCase;

public class CourseRegistrationAction
        extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        if (!SessionTraker.isSessionExist(request)) {
            return mapping.findForward("invalidAccess");
        }
        ServletContextAttribute servletContAtt = new ServletContextAttribute(request);
        String regTerm = servletContAtt.getCrsRegTerm();
        String curentTerm = servletContAtt.getCurentTerm();
        Boolean regTermIsIntensive = Boolean.valueOf(servletContAtt.termIsIntensive(regTerm));
        System.out.println("regTerm" + regTerm);
        System.out.println("curentTerm" + curentTerm);
        String studId = null;
        String studSpecTypeNo = null;
        String studSpecNo = "";
        String studMajorSheet = null;
        String studWarnStatus = null;
        Double termBalance = 0.0D;
        Double ftp = 100.0D;
         Double crBaseAmt = 0.0D;
        if (request.getSession().getAttribute("studentInfo") != null) {

            System.out.println("studentInfo is not null ");
            StudentInfoHolder studInfo = (StudentInfoHolder) ((List) request.getSession().getAttribute("studentInfo")).get(0);
            studId = studInfo.getStudentId();

            studSpecTypeNo = studInfo.getSpecTypeNo();
            studSpecNo = studInfo.getSpecializationNo() == null ? "" : studInfo.getSpecializationNo();
            studMajorSheet = studInfo.getMajorSheet();
            studWarnStatus = studInfo.getWarnStatus();
        } else if (request.getSession().getAttribute("deptMaster") != null) {
            DeptMasterInfoHolder deptMasterInfoHolder = (DeptMasterInfoHolder) ((List) request.getSession().getAttribute("deptMaster")).get(0);
            studId = request.getParameter("studId");
            studSpecTypeNo = request.getParameter("studSpecTypeNo");
            studSpecNo = request.getParameter("studSpecNo");
            studMajorSheet = request.getParameter("studMajorSheet");

            boolean studInDpt = false;
            ArrayList input = new ArrayList();
            input.add(studId);
            Collection retList = new GetStudentInfoUseCase().execute(input, request);
            if ((retList != null) && (retList.size() > 0)) {
                StudentInfoHolder studentInfoHolder = (StudentInfoHolder) retList.iterator().next();
                if ((studentInfoHolder.getDeptNo() != null) && (deptMasterInfoHolder.getDeptNo() != null) && (studentInfoHolder.getDeptNo().equals(deptMasterInfoHolder.getDeptNo()))) {
                    studInDpt = true;
                }
                if (!studInDpt) {
                    ActionMessages errors = new ActionMessages();
                    errors.add("error.errorOccuered", new ActionMessage("portal.error.studNotInDpt"));
                    saveErrors(request, errors);
                    return mapping.findForward("fail");
                }
                request.setAttribute("stud_id", studentInfoHolder.getStudentId());
                request.setAttribute("studViwedInfo", retList);
                studSpecTypeNo = studentInfoHolder.getSpecTypeNo();
                studSpecNo = studentInfoHolder.getSpecializationNo();
                studMajorSheet = studentInfoHolder.getMajorSheet();
                studWarnStatus = studentInfoHolder.getWarnStatus();
            }
        } else {
            return mapping.findForward("invalidAccess");
        }

        List inptRegCal = new ArrayList();
        inptRegCal.add(studId);
        inptRegCal.add(regTerm);
        System.out.println(" regTerm  ...... " + regTerm);
        System.out.println("***************before GetStudActiveRegCalItemUseCase");
        String regCalItem = (String) new GetStudActiveRegCalItemUseCase().execute(inptRegCal, request).iterator().next();
        System.out.println("***************after GetStudActiveRegCalItemUseCase");
        request.getSession().setAttribute("currentRegCalItem", regCalItem);
        System.out.println("**************   regCalItem " + regCalItem);

//-------------------------
        List studentSasInput = new ArrayList();
//studentSasInput.add(studId);
//studentSasInput.add(curentTerm);
        Collection currentTermFinancial = new ShowTermFinancialUseCase().execute(new ArrayList(), request);
        if ((currentTermFinancial != null) && (currentTermFinancial.size() != 0)) {
            SasStudFtermCard studTermFinancial = (SasStudFtermCard) currentTermFinancial.iterator().next();
            Double studTermBalance = studTermFinancial.getBaseTermBalance();
            System.out.println("studTermBalance " + studTermBalance);

            PrtlSetup prtlSetup = new PrtlSetup("", "");

            Collection resList = new GetMinFinValueUseCase().execute(null, request);
            if ((resList != null) && (resList.size() > 0)) {
                prtlSetup = (PrtlSetup) resList.iterator().next();
            }

            String minFinV = prtlSetup.getSetupValue();
            //Double.parseDouble(minFinV)){
            System.out.println("ggggh" + studTermBalance);
            if (studTermBalance < Double.parseDouble(minFinV)) {
                ActionMessages errors = new ActionMessages();
                errors.add("error.errorOccuered", new ActionMessage("portal.error.internalMessage", "لا يمكنك التسجيل بسبب وجود مستحقات مالية من الفصل السابق"));
                saveErrors(request, errors);
                return mapping.findForward("failed");
            }

        } else {
            System.out.println("qw");
        }

//-------------------------
        ArrayList regCrsInput = new ArrayList();
        regCrsInput.add(studId);
        regCrsInput.add(regTerm);
        Collection registeredCourses = new StudnetRegisteredCoursesListUseCase().execute(regCrsInput, request);
        if ((registeredCourses != null) && (registeredCourses.size() > 0)) {
            request.setAttribute("registeredCourses", registeredCourses);
            Iterator itr = registeredCourses.iterator();
            int newLoad = 0;
            while (itr.hasNext()) {
                MsCoursesList regStud = (MsCoursesList) itr.next();
                if (regStud.getCrsHrs() != null) {
                    newLoad += Integer.parseInt(regStud.getCrsHrs());
                }
            }
            request.setAttribute("newLoad", String.valueOf(newLoad));
            System.out.println("**************   newLoad " + String.valueOf(newLoad));
        } else {
            request.setAttribute("newLoad", "0");
        }
        ArrayList inptStt = new ArrayList();
        inptStt.add(studSpecTypeNo);
        inptStt.add(regTermIsIntensive);
        inptStt.add(studWarnStatus);
        Collection regSett = new RegSettingInfoUseCase().execute(inptStt, request);
        if ((regSett != null) && (regSett.size() > 0)) {
            RegStudSetting regStudSetting = (RegStudSetting) regSett.iterator().next();
            request.setAttribute("maxLoad", String.valueOf(regStudSetting.getMaxCrHrs()));
            request.setAttribute("hoursSum", "0");
            
            request.getSession().setAttribute("minLoad", String.valueOf(regStudSetting.getMinCrHrs()));
            request.getSession().setAttribute("maxLoad", String.valueOf(regStudSetting.getMaxCrHrs()));
        }
        ArrayList inp = new ArrayList();
        inp.add(studId);
        inp.add(regTerm);
        inp.add(regCalItem);
        Collection studentApprovedList = new GetStudRegApproveStatusForCalItmUseCase().execute(inp, null);
        System.out.println("studentApprovedList.size() " + studentApprovedList.size());

        if ((studentApprovedList != null) && (studentApprovedList.size() > 0)) {
            System.out.println("studentApprovedList is not null ");
            PrtlRegStudApprove prtlRegStudApprove = (PrtlRegStudApprove) studentApprovedList.iterator().next();
            if ((prtlRegStudApprove.getRegApp() != null) && (prtlRegStudApprove.getRegApp().equals("Y"))) {
                request.setAttribute("regApp", "Y");
                ActionMessages errors = new ActionMessages();
                errors.add("error.errorOccuered", new ActionMessage("portal.error.internalError", "لا يمكنك التعديل على المقررات المسجلة بسبب قيامك بتثبيت التسجيل"));
                saveErrors(request, errors);
                return mapping.findForward("success");
            }
        }
        ArrayList input = new ArrayList();
        input.add(studId);
        input.add(regTerm);
        input.add(regCalItem);

        System.out.println("regTerm .. 0.. 0    1 " + regTerm);
        System.out.println("regCalItem  ...... 2 " + regCalItem);
        Collection periodCheck = new RegistrationPeriodChecksUseCase().execute(input, request);
        String retValue = (String) periodCheck.iterator().next();
        System.out.println("**************** retValue **** " + retValue);
        System.out.println("**************** regTerm **** " + regTerm);
        if ((retValue != null) && (!retValue.equals("0"))) {
             System.out.println("here is point0.........r");
            ActionMessages errors = new ActionMessages();
            errors.add("error.errorOccuered", new ActionMessage("portal.error.internalMessage", retValue));
            saveErrors(request, errors);
            System.out.println("here is point1.........r");
            return mapping.findForward("failed");

        }
        System.out.println("here is rel1");
        ArrayList inputCalItm = new ArrayList();
        inputCalItm.add(regCalItem);
        inputCalItm.add(regTerm);
        Collection calItemInfo = new CalendarItemInfoUseCase().execute(inputCalItm, null);
        if ((calItemInfo != null) && (calItemInfo.size() > 0)) {
            request.setAttribute("calItemInfo", calItemInfo);
        }
        ArrayList inptAvlbCrs = new ArrayList();
        inptAvlbCrs.add(regTerm);
        inptAvlbCrs.add(studMajorSheet);
        inptAvlbCrs.add(studSpecNo);
        inptAvlbCrs.add(studId);
        Collection avlbCrsList = new GetAvaliableCoursesListUseCase().execute(inptAvlbCrs, null);
        if ((avlbCrsList != null) && (avlbCrsList.size() > 0)) {
            request.setAttribute("avlbCrsList", avlbCrsList);
        } else {
            request.setAttribute(SystemConstant.SEARCH_NOT_FOUND_RESULT, "true");
        }
        request.setAttribute("regCalItem", regCalItem);

        System.out.println("ccccc");

        
        
      //  Portal.getStudentFeesToPay
                
        /**
         * *
         * this is to check if the student balance is credit plus before
         * registering in the term -- added at 21/04/2017
         */
        List financialList2 = null;
        List feesToPayList = null;
        
        StudentInfoComponent termSummaryCmp = new StudentInfoComponent();
        System.out.println("ccccc" + regTerm);
        financialList2 = termSummaryCmp.getStudentFinancialTermsDebt(new Object[]{studId, regTerm});

       
        
        if (financialList2.size() != 0) {

            PrtlStudBalanceVw sasStudBalanceTemp = (PrtlStudBalanceVw) financialList2.get(0);
            
          
             
            termBalance = sasStudBalanceTemp.getTermBalance();
            crBaseAmt = sasStudBalanceTemp.getCrBaseAmt();
            
            
           
        }
        
         feesToPayList = termSummaryCmp.getStudentFeesToPay(new Object[]{studId, regTerm});
           if (feesToPayList.size() != 0) {
               SasFeesToPay sasFeesToPayTemp = (SasFeesToPay) feesToPayList.get(0);
                ftp = sasFeesToPayTemp.getFeesToPay();
            
           }
         System.out.println("saved fees to pay  "+ftp);
        

       // if (termBalance.doubleValue() <= 99.0D) {
            
             if (crBaseAmt.doubleValue() < ftp) {
            System.out.println("term balance for the term :  "+termBalance);
              System.out.println("paid fees less than 99 :    "+crBaseAmt);
            
            ActionMessages errors = new ActionMessages();
            errors.add("error.errorOccuered", new ActionMessage("portal.error.internalMessage", +termBalance + "لا يمكنك التسجيل  لان رصيدك للتسجيل للفصل الحالي غير كافي وهو       "));
            saveErrors(request, errors);
           // request.setAttribute("initialTerm", regTerm);
              request.getSession().setAttribute("initialTerm", regTerm);
            
            return mapping.findForward("hours");
        }

        System.out.println("cc new");
        ///////////////////
        return mapping.findForward("success");
    }
}
