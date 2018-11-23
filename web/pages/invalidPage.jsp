<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="http://psgateway.org" prefix="pagination" %>
<%@ taglib uri="/WEB-INF/lib/qou-Taglib.tld" prefix="qou" %>
<%
  response.setHeader("pragma", "no-cache");
  response.setHeader("Cache-Control", "no-cache");
  response.setHeader("Expires", "0");
%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>دار الكلمة</title>
<link href="/pages/resources/css/dr_portal_style.css" rel="stylesheet" type="text/css">
<script>
function openHelpWindow()
{
  var broswerName = new String(navigator.appName);
  if(broswerName.indexOf("Microsoft") >= 0)
    var win = window.open('pages/registrationHelpPage.jsp','','toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=no,width=1000,height=315');
  else if(broswerName.indexOf("Netscape") >= 0)
    var win = window.open('pages/registrationHelpPage.jsp','','toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=no,width=1000,height=315');
}
</script>
</head>

<body topMargin="0" bgcolor="ebefd6" >

<table align="center" width="99%" border="3" cellspacing="0" cellpadding="0"  dir="rtl">
  <tr height="101">
    <td colspan="0" align="center" valign="top" height="101" width="99%"><jsp:include page="drPortalHeader.jsp" flush="true" /></td>
  </tr>
 <tr>
    <td width="99%" align="right" valign="top">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td align="right" valign="top">
        <table width="100%"  border="0" cellpadding="0" cellspacing="0" >
          <tr>
            <td align="right" valign="top">
            <table width="100%" border="0" cellspacing="0" cellpadding="0" height="200">
              <tr>
                <td height="25" colspan="2" align="center" valign="middle" class="subMain">دار الكلمة</td>
              </tr>

              <tr>
                <td height="35" colspan="2" align="center" valign="middle" class="qou">
                  <div align="center"  class="subMain"><font color="#FF0000">نأسف,الصفحة المطلوبة غير موجودة</font></div>
                </td>
              </tr>
            </table>
        </td>
       </tr>
    </table>

	</td>
  </tr>
  </table>
  <tr>
  <td>&nbsp;<br></td>
  </tr>
  <tr>
    <td colspan="3" align="center" valign="top" height="25"><jsp:include page="drPrtalFooter.jsp" flush="true" /></td>
  </tr>
</table>

</body>
</html>


