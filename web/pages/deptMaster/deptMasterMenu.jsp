<%@ page import="ps.edu.diyar.common.tools.Randomizer" %>
<%@ page import="ps.edu.diyar.common.component.ServletContextAttribute" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
 
<link href="/pages/resources/css/portalStyleMenus.css" rel="stylesheet" type="text/css">
<br />
<table cellspacing="0" width="160"   cellpadding="0">

          <tr>
          <td valign="top">
            <table cellspacing="0" width="160"  cellpadding="0">

            <tr> <td width="160" height="16"  class="menuLinkHeader"  valign="top"  >القائمة الرئيسية</td> </tr>

            <tr class="menuLink"> <td align="right"><a href="/deptMstr/tutorsDeptList.do?.rv=<%= Randomizer.shortRandom()%>"  >العلامات</a></td></tr>

            <% ServletContextAttribute cmp= new ServletContextAttribute(request);
            if(cmp.showRegLink())
            {
            %>
            <tr class="subMenu" > <td align="right"> التسجيل</td></tr>
             <tr class="menuLink"> <td align="right"> <a href="/deptMstr/viewStudNotRegListDept.do?.rv=<%=Randomizer.shortRandom()%>"  >الطلبة الغير المسجلين</a></td></tr>
            <tr class="menuLink"> <td align="right"> <a href="/deptMstr/viewRegStudListDept.do?.rv=<%=Randomizer.shortRandom()%>"  >الطلبة المسجلين</a></td></tr>
            <tr class="menuLink"> <td align="right"> <a href="/deptMstr/viewloadStudentRegCrsInfo.do?.rv=<%=Randomizer.shortRandom()%>"  > التسجيل و السحب و الاضافة</a></td></tr>
            <% } %>

            <tr> <td align="right" valign="top"   class="menuLinkFooter">&nbsp;  </td>  </tr>

            </table>

          </td>
          </tr>
</table>
