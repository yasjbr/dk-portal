<%@ page import="ps.edu.diyar.common.tools.SessionTraker" %>
<jsp:useBean id="jspBean" class="ps.edu.diyar.reporting.beans.RegStudReportJspBean" scope="request" />
<%@ page contentType="charset=UTF-8" %>
<%
//  response.setHeader("pragma", "no-cache");
//  response.setHeader("Cache-Control", "no-cache");
//  response.setHeader("Expires", "0");
    try
    {
        if(!SessionTraker.isSessionExist(request))
           request.getRequestDispatcher("/pages/invalidPage.jsp").forward(request,pageContext.getResponse());
        else
        {
            out.clear();
            out = pageContext.pushBody(); 

            byte[] bytes = jspBean.generateReport(request,
                                                    application.getRealPath("/reports/studScholarshipReport.jasper"),
                                                    application.getRealPath("/reports/studInstallmentReport.jasper"),
                                                    application.getRealPath("/reports/studHoursSumReport.jasper"),
                                                    application.getRealPath("/reports/banksDetailsReport.jasper"),
                                                    application.getRealPath("/reports/studFeesReport.jasper"),
                                                    application.getRealPath("/reports/regStudReport.jasper"),
                                                    application.getRealPath("/pages/resources/images/reportHeader.jpg"),
                                                    application.getRealPath("/pages/resources/images/reportFooter.jpg") );
            if(bytes != null && bytes.length > 0)
            {
                response.setContentType("application/pdf");
                response.setHeader("Content-Disposition","inline; filename=studList.pdf;");

                ServletOutputStream ouputStream = response.getOutputStream();
                ouputStream.write(bytes, 0, bytes.length);
                ouputStream.flush();
                ouputStream.close();
            }
            else
            {
                out.print("<h1> No Reports Found </h1>");
            }
        }
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
    out.clear();
    out = pageContext.pushBody();
%>