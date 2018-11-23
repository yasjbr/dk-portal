<%@ page import="ps.edu.diyar.common.tools.Randomizer" %>
<%@ taglib uri="/WEB-INF/lib/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/lib/struts-bean.tld" prefix="bean" %>
 

 
 
<%@ taglib uri="/WEB-INF/lib/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://psgateway.org" prefix="pagination" %>
<%@ taglib uri="/WEB-INF/lib/struts-tiles.tld" prefix="tiles" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<link href="/pages/resources/css/portalStyleMenus.css" rel="stylesheet" type="text/css">

<table align="right" cellspacing="0" width="160" cellpadding="0"  style="margin-top:10px">

      <tr> <td align="center" width="160" height="24"  class="menuLinkHeader" valign="top">إعدادات</td> </tr>
        <tr class="menuLink"> <td align="right"> <a href="/student/changePassword.do?.rv=<%=Randomizer.shortRandom()%>"  >تعديل البيانات الشخصية</a></td></tr>
      <tr height="150"> <td align="right" valign="top"   class="menuLinkFooter" height="155"></td>  </tr>

</table>
