/*
 * Decompiled with CFR 0_102.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpSession
 *  net.sf.jasperreports.engine.JRDataSource
 *  net.sf.jasperreports.engine.JasperExportManager
 *  net.sf.jasperreports.engine.JasperFillManager
 *  net.sf.jasperreports.engine.JasperPrint
 *  net.sf.jasperreports.engine.JasperReport
 *  net.sf.jasperreports.engine.util.JRLoader
 *  org.apache.log4j.Logger
 *  ps.edu.diyar.common.component.ServletContextAttribute
 *  ps.edu.diyar.common.tools.CharToUnicode
 *  ps.edu.diyar.common.tools.DateTool
 *  ps.edu.diyar.deptMaster.database.struct.DeptMasterInfoHolder
 *  ps.edu.diyar.reporting.dataSources.BanksDataSource
 *  ps.edu.diyar.reporting.dataSources.RegStudReportDataSource
 *  ps.edu.diyar.reporting.dataSources.StudFeesReportDataSource
 *  ps.edu.diyar.reporting.dataSources.StudHoursSumDataSource
 *  ps.edu.diyar.reporting.dataSources.StudInstallmentDataSource
 *  ps.edu.diyar.reporting.dataSources.StudScholarshipDataSource
 *  ps.edu.diyar.studentInfo.component.StudentInfoComponent
 *  ps.edu.diyar.studentInfo.database.PrtlRepCsrlistStudVw
 *  ps.edu.diyar.studentInfo.database.PrtlRepCsrlistStudVwPK
 *  ps.edu.diyar.studentInfo.database.PrtlRepFinancialStudVw
 *  ps.edu.diyar.studentInfo.database.PrtlRepInstallmentStudVw
 *  ps.edu.diyar.studentInfo.database.PrtlRepScholarStudVw
 *  ps.edu.diyar.studentInfo.database.RegTerm
 *  ps.edu.diyar.studentInfo.database.SasBanksVu
 *  ps.edu.diyar.studentInfo.database.struct.CalendarItemInfo
 *  ps.edu.diyar.studentInfo.database.struct.StudentInfoHolder
 *  ps.edu.diyar.studentInfo.useCase.CalendarItemInfoUseCase
 *  ps.edu.diyar.studentInfo.useCase.GetStudActiveRegCalItemUseCase
 *  ps.edu.diyar.studentInfo.useCase.GetStudentInfoUseCase
 *  ps.edu.diyar.studentInfo.useCase.GetTermInfoUseCase
 */
package ps.edu.diyar.reporting.beans;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import org.apache.log4j.Logger;
import ps.edu.diyar.common.component.ServletContextAttribute;
import ps.edu.diyar.common.tools.CharToUnicode;
import ps.edu.diyar.common.tools.DateTool;
import ps.edu.diyar.deptMaster.database.struct.DeptMasterInfoHolder;
import ps.edu.diyar.reporting.dataSources.BanksDataSource;
import ps.edu.diyar.reporting.dataSources.RegStudReportDataSource;
import ps.edu.diyar.reporting.dataSources.StudFeesReportDataSource;
import ps.edu.diyar.reporting.dataSources.StudHoursSumDataSource;
import ps.edu.diyar.reporting.dataSources.StudInstallmentDataSource;
import ps.edu.diyar.reporting.dataSources.StudScholarshipDataSource;
import ps.edu.diyar.studentInfo.component.StudentInfoComponent;
import ps.edu.diyar.studentInfo.database.PrtlRepCsrlistStudVw;
import ps.edu.diyar.studentInfo.database.PrtlRepCsrlistStudVwPK;
import ps.edu.diyar.studentInfo.database.PrtlRepFinancialStudVw;
import ps.edu.diyar.studentInfo.database.PrtlRepInstallmentStudVw;
import ps.edu.diyar.studentInfo.database.PrtlRepScholarStudVw;
import ps.edu.diyar.studentInfo.database.RegTerm;
import ps.edu.diyar.studentInfo.database.SasBanksVu;
import ps.edu.diyar.studentInfo.database.struct.CalendarItemInfo;
import ps.edu.diyar.studentInfo.database.struct.StudentInfoHolder;
import ps.edu.diyar.studentInfo.useCase.CalendarItemInfoUseCase;
import ps.edu.diyar.studentInfo.useCase.GetStudActiveRegCalItemUseCase;
import ps.edu.diyar.studentInfo.useCase.GetStudentInfoUseCase;
import ps.edu.diyar.studentInfo.useCase.GetTermInfoUseCase;

public class RegStudReportJspBean {
    private static Logger logger = Logger.getLogger((Class)RegStudReportJspBean.class);

    public byte[] generateReport(HttpServletRequest req, String studScholarshipReportPath, String studInstallmentReportPath, String studHoursSumReportPath, String banksDetailsReportPath, String studFeesReportPath, String regStudReportPath, String imgHeaderPath, String imgFooterPath) {
        Object bytes = null;
        try {
            String studId = null;
            String studName = null;
            String studSpecName = null;
            String studColg = null;
            String regTerm = null;
            HashMap<String, Object> parameters = new HashMap<String, Object>();
            if (req.getSession().getAttribute("studentInfo") != null) {
                StudentInfoHolder studInfo = (StudentInfoHolder)((List)req.getSession().getAttribute("studentInfo")).get(0);
                studId = studInfo.getStudentId();
                studColg = studInfo.getProgramName();
                studName = studInfo.getStudentName();
                studSpecName = studInfo.getSpecialization() == null ? "" : studInfo.getSpecialization();
            } else if (req.getSession().getAttribute("deptMaster") != null) {
                DeptMasterInfoHolder deptMasterInfoHolder = (DeptMasterInfoHolder)((List)req.getSession().getAttribute("deptMaster")).get(0);
                studId = req.getParameter("stud_id");
                boolean studInDpt = false;
                ArrayList<String> input = new ArrayList<String>();
                input.add(studId);
                Collection retList = new GetStudentInfoUseCase().execute(input, req);
                if (retList != null && retList.size() > 0) {
                    StudentInfoHolder studentInfoHolder = (StudentInfoHolder)retList.iterator().next();
                    if (studentInfoHolder.getDeptNo() != null && deptMasterInfoHolder.getDeptNo() != null && studentInfoHolder.getDeptNo().equals(deptMasterInfoHolder.getDeptNo())) {
                        studInDpt = true;
                    }
                    if (!studInDpt) {
                        Object var22_25 = null;
                        return (byte[]) var22_25;
                    }
                    studColg = studentInfoHolder.getProgramName();
                    studName = studentInfoHolder.getStudentName();
                    studSpecName = studentInfoHolder.getSpecialization() == null ? "" : studentInfoHolder.getSpecialization();
                }
            } else {
                Object deptMasterInfoHolder = null;
                return (byte[]) deptMasterInfoHolder;
            }
            ServletContextAttribute servletCntxtAttib = new ServletContextAttribute(req);
            regTerm = servletCntxtAttib.getCrsRegTerm();
            if (req.getSession().getAttribute("currentRegCalItem") == null) {
                ArrayList<String> inptRegCal = new ArrayList<String>();
                inptRegCal.add(studId);
                inptRegCal.add(regTerm);
                String regCalItem = (String)new GetStudActiveRegCalItemUseCase().execute(inptRegCal, req).iterator().next();
                req.getSession().setAttribute("currentRegCalItem", (Object)regCalItem);
            }
            String currentRegCalItem = (String)req.getSession().getAttribute("currentRegCalItem");
            ArrayList<String> inputCalItm = new ArrayList<String>();
            inputCalItm.add(currentRegCalItem);
            inputCalItm.add(regTerm);
            Collection calItemInfo = new CalendarItemInfoUseCase().execute(inputCalItm, null);
            if (calItemInfo != null && calItemInfo.size() > 0) {
                CalendarItemInfo calendarItemInfo = (CalendarItemInfo)calItemInfo.iterator().next();
                parameters.put("calItemName", calendarItemInfo.getItemAName());
            }
            StudentInfoComponent studCmp = new StudentInfoComponent();
            List studScholarshipReportList = null;
            Object[][] studScholarshipRecords = null;
            studScholarshipReportList = studCmp.getStudScholarshipReportList(studId, regTerm);
            if (studScholarshipReportList != null) {
                studScholarshipRecords = new String[studScholarshipReportList.size()][2];
                Iterator iter = studScholarshipReportList.iterator();
                int count = 0;
                while (iter.hasNext()) {
                    PrtlRepScholarStudVw prtlRepScholarStudVw = (PrtlRepScholarStudVw)iter.next();
                    studScholarshipRecords[count][0] = String.valueOf(prtlRepScholarStudVw.getSchlrAmt());
                    studScholarshipRecords[count][1] = prtlRepScholarStudVw.getSchlrAName();
                    ++count;
                }
            }
            StudScholarshipDataSource studScholarshipReportDataSource = new StudScholarshipDataSource(studScholarshipRecords);
            List studFeesReportList = null;
            Object[][] studFeesReportRecords = null;
            studFeesReportList = studCmp.getStudFeesReportList(studId, regTerm);
            if (studFeesReportList != null) {
                studFeesReportRecords = new String[studFeesReportList.size()][6];
                Iterator iter = studFeesReportList.iterator();
                int count = 0;
                double fees_total = 0.0;
                while (iter.hasNext()) {
                    PrtlRepFinancialStudVw prtlRepFinancialStudVw = (PrtlRepFinancialStudVw)iter.next();
                    studFeesReportRecords[count][0] = String.valueOf(count + 1);
                    studFeesReportRecords[count][1] = prtlRepFinancialStudVw.getFinDesc();
                    studFeesReportRecords[count][2] = String.valueOf(prtlRepFinancialStudVw.getAmount());
                    fees_total+=prtlRepFinancialStudVw.getAmount().doubleValue();
                    ++count;
                }
                if (count > 0) {
                    studFeesReportRecords[count - 1][3] = String.valueOf(fees_total);
                    String fTotalSybl = studCmp.getFeesTotalSymbol(regTerm, studId);
                    String fTotalInChr = studCmp.getFeesTotalInChar(regTerm, studId);
                    studFeesReportRecords[count - 1][4] = fTotalSybl != null ? fTotalSybl : " ";
                    studFeesReportRecords[count - 1][5] = fTotalInChr != null ? fTotalInChr : " ";
                }
            }
            StudFeesReportDataSource studFeesReportDataSource = new StudFeesReportDataSource(studFeesReportRecords);
            List studInstallmentReportList = null;
            Object[][] studInstallmentRecords = null;
            studInstallmentReportList = studCmp.getStudInstallmentReportList(studId, regTerm);
            if (studInstallmentReportList != null) {
                studInstallmentRecords = new String[studInstallmentReportList.size()][3];
                Iterator iter = studInstallmentReportList.iterator();
                int count = 0;
                while (iter.hasNext()) {
                    PrtlRepInstallmentStudVw prtlRepInstallmentStudVw = (PrtlRepInstallmentStudVw)iter.next();
                    studInstallmentRecords[count][0] = String.valueOf(prtlRepInstallmentStudVw.getInstRownum());
                    studInstallmentRecords[count][1] = DateTool.decorateYYYY_MM_DD((Object)prtlRepInstallmentStudVw.getDueDate());
                    studInstallmentRecords[count][2] = String.valueOf(prtlRepInstallmentStudVw.getInstValue());
                    ++count;
                }
            }
            StudInstallmentDataSource studInstallmentDataSource = new StudInstallmentDataSource(studInstallmentRecords);
            List studHoursSumReportList = null;
            Object[][] studHoursSumRecords = null;
            studHoursSumReportList = studCmp.getStudHoursSumReportList(studId, regTerm);
            if (studHoursSumReportList != null) {
                studHoursSumRecords = new String[studHoursSumReportList.size()][6];
                Iterator iter = studHoursSumReportList.iterator();
                int count = 0;
                int sumHrs = 0;
                while (iter.hasNext()) {
                    PrtlRepCsrlistStudVw prtlRepCsrlistStudVw = (PrtlRepCsrlistStudVw)iter.next();
                    studHoursSumRecords[count][0] = String.valueOf(count + 1);
                    studHoursSumRecords[count][1] = prtlRepCsrlistStudVw.getComp_id().getCrsNo();
                    studHoursSumRecords[count][2] = prtlRepCsrlistStudVw.getCrsAName();
                    studHoursSumRecords[count][3] = prtlRepCsrlistStudVw.getCrsClass();
                    studHoursSumRecords[count][4] = String.valueOf(prtlRepCsrlistStudVw.getCrsHrs());
                    sumHrs+=prtlRepCsrlistStudVw.getCrsHrs().intValue();
                    ++count;
                }
                if (count > 0) {
                    studHoursSumRecords[count - 1][5] = String.valueOf(sumHrs);
                }
            }
            StudHoursSumDataSource studHoursSumDataSource = new StudHoursSumDataSource(studHoursSumRecords);
            List banksDetailsReportList = null;
            Object[][] banksDetailsRecords = null;
            banksDetailsReportList = studCmp.getBanksDetailsList();
            if (banksDetailsReportList != null) {
                banksDetailsRecords = new String[banksDetailsReportList.size()][2];
                Iterator iter = banksDetailsReportList.iterator();
                int count = 0;
                while (iter.hasNext()) {
                    SasBanksVu sasBanksVu = (SasBanksVu)iter.next();
                    banksDetailsRecords[count][0] = sasBanksVu.getBnkADesc();
                    banksDetailsRecords[count][1] = sasBanksVu.getBraADesc() + "/\u0631\u0642\u0645 \u0627\u0644\u062d\u0633\u0627\u0628 " + sasBanksVu.getBankAccount();
                    ++count;
                }
            }
            BanksDataSource banksDataSource = new BanksDataSource(banksDetailsRecords);
            String regTermDesc = regTerm;
            ArrayList<String> inpt = new ArrayList<String>();
            inpt.add(regTerm);
            Collection retlist = new GetTermInfoUseCase().execute(inpt, req);
            if (retlist != null && retlist.size() > 0) {
                RegTerm regTermInfo = (RegTerm)retlist.iterator().next();
                regTermDesc = regTermInfo.getTermAName() + " - " + regTermInfo.getTermNo();
            }
            parameters.put("conn1", (Object)studScholarshipReportDataSource);
            parameters.put("conn2", (Object)studInstallmentDataSource);
            parameters.put("conn3", (Object)studHoursSumDataSource);
            parameters.put("conn4", (Object)banksDataSource);
            parameters.put("conn5", (Object)studFeesReportDataSource);
            parameters.put("studScholarshipReportPath", studScholarshipReportPath);
            parameters.put("studInstallmentReportPath", studInstallmentReportPath);
            parameters.put("studHoursSumReportPath", studHoursSumReportPath);
            parameters.put("banksDetailsReportPath", banksDetailsReportPath);
            parameters.put("studFeesReportPath", studFeesReportPath);
            parameters.put("regStudReportPath", regStudReportPath);
            parameters.put("imgHeaderPath", imgHeaderPath);
            parameters.put("imgFooterPath", imgFooterPath);
            parameters.put("reportDate", DateTool.decorateYYYY_MM_DD((Object)new Date()));
            parameters.put("termName", regTermDesc);
            parameters.put("copyName", CharToUnicode.getUnicodeValue((String)"\u0646\u0633\u062e\u0629 \u0627\u0644\u0628\u0646\u0643"));
            parameters.put("studName", CharToUnicode.getUnicodeValue((String)studName));
            parameters.put("studId", studId);
            parameters.put("studSpec", CharToUnicode.getUnicodeValue((String)studSpecName));
            parameters.put("studColg", CharToUnicode.getUnicodeValue((String)studColg));
            JasperReport jasperReport = (JasperReport)JRLoader.loadObject((String)regStudReportPath);
            RegStudReportDataSource dataSrc = new RegStudReportDataSource((Object[][])new String[][]{{" "}, {" "}});
            JasperPrint jasperPrint = JasperFillManager.fillReport((JasperReport)jasperReport, parameters, (JRDataSource)dataSrc);
            bytes = JasperExportManager.exportReportToPdf((JasperPrint)jasperPrint);
            return (byte[]) bytes;
        }
        catch (Exception e) {
            logger.error((Object)("****** Error in 'RegStudReportJspBean': " + e.getMessage()));
            e.printStackTrace();
        }
        finally {
            return (byte[]) bytes;
        }
    }
}