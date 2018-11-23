<%@ page import="ps.edu.diyar.common.tools.Randomizer" %>
<%@ page import="ps.edu.diyar.common.component.ServletContextAttribute" %>
<%@ page import="ps.edu.diyar.common.constant.SystemConstant" %>
<%@ taglib uri="/WEB-INF/lib/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/lib/struts-bean.tld" prefix="bean" %>
 

 
 
<%@ taglib uri="/WEB-INF/lib/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://psgateway.org" prefix="pagination" %>
<%@ taglib uri="/WEB-INF/lib/struts-tiles.tld" prefix="tiles" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<link href="/pages/resources/css/portalStyleMenus.css" rel="stylesheet" type="text/css">

<table align="right" cellspacing="0" width="160" cellpadding="0" style="margin-top:10px">

      <tr> <td align="center" width="160" height="24"  class="menuLinkHeader" valign="top">معلومات الطالب</td> </tr>
       <tr class="subMenu" > <td align="right"> <bean:message key="studentInfo.Menu.term"/> </td></tr>
       <tr class="menuLink"> <td align="right"> <a href="/student/showStudTermSchedule.do?.rv=<%=Randomizer.shortRandom()%>"  >جدول اللقاءات</a></td></tr>
       <tr class="menuLink"> <td align="right"> <a href="/student/showStudExamSchedule.do?.rv=<%=Randomizer.shortRandom()%>"  >جدول الامتحانات</a></td></tr>
       <tr class="menuLink"> <td align="right"> <a href="/student/showTermSummary.do?.rv=<%=Randomizer.shortRandom()%>"  >العلامات</a></td></tr>
        <tr class="menuLink"> <td align="right"> <a href="/student/showTermFinancial.do?.rv=<%=Randomizer.shortRandom()%>"  >المالية</a></td></tr>
       <tr class="menuLink"> <td align="right"> <a href="/student/showMessages.do?.rv=<%=Randomizer.shortRandom()%>"  >المراسلات</a></td></tr>
       <tr class="subMenu" > <td align="right"> التسجيل</td></tr>
       <tr class="menuLink"> <td align="right"> <a href="/student/studMsCrsList.do?.rv=<%=Randomizer.shortRandom()%>"  >الخطة الاسترشادية</a></td></tr>
       <% ServletContextAttribute cmp= new ServletContextAttribute(request);
          if(cmp.showRegLink())
          {
       %>
       <tr class="menuLink"> <td align="right"> <a href="/student/crsReg.do?.rv=<%=Randomizer.shortRandom()%>"  > التسجيل و السحب و الاضافة</a></td></tr>
       <% }
         if(request.getSession().getAttribute(SystemConstant.SESSION_ATTRIBUTE.SHOW_PAY_REPORT)!=null &&
                 request.getSession().getAttribute(SystemConstant.SESSION_ATTRIBUTE.SHOW_PAY_REPORT).equals("Y"))
          {
       %>
       <tr class="menuLink"> <td align="right"> <a  target="_blank" href="/student/viewStudRegCrsReport?.rv=<%=Randomizer.shortRandom()%>"  > طباعة اشعار الدفع</a></td></tr>
       <% } %>
    
      <tr  > <td align="right" valign="top"   class="menuLinkFooter" height="155"></td>  </tr>

</table>

<br/><br/>
<table align="right" cellspacing="0" width="160" cellpadding="0" style="margin-top:10px">

      <tr> <td align="center" width="160" height="24"  class="menuLinkHeader" valign="top"> </td> </tr>

        <tr class="menuLink"> <td align="right"> <a href="/student/viewStudSocialSurvey.do?.rv=<%=Randomizer.shortRandom()%>" target="_blank"  >استمارة المسح الاجتماعي </a></td></tr>

       <tr  > <td align="right" valign="top"   class="menuLinkFooter" height="155"></td>  </tr>

</table>
