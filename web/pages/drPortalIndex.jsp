<%@ page contentType="text/html; charset=UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Dar Al-Kalima University College – Academic Portal</title>

<META NAME="Description" CONTENT="Dar Al-Kalima University College – Academic Portal">

<META name="keywords" content="Dar Al-Kalima University College – Academic Portal">
<link rel="shortcut icon" href="/pages/resources/images/favicon.ico" >
<link href="/pages/resources/css/dr_portal_style.css" rel="stylesheet" type="text/css">
</head>
 
<body topMargin="0"   bgcolor="#fee6cb" >
<table width="966" border="0" cellspacing="0" cellpadding="0" align="center" dir="rtl">
  <TBODY   bgcolor="#FFFFFF" >
  <tr height="101"> 
    <td colspan="3" align="center" valign="top" height="101" width="966"><jsp:include page="drPortalHeader.jsp" flush="true" /></td>
  </tr>
 <tr> 
    <td width="966" align="right" valign="top">
	<table width="966" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="215"><jsp:include page="loginRightMenu.jsp" flush="true" /></td>
    <td width="360" align="center" valign="middle" height="170"><br /><br />
    <%  if (request.getParameter("reLogin")!=null){%>
     <div align="center"  class="centerpage"><font color="#FF0000">الرجاء تسجيل الدخول</font></div>
     <%}%>
	<jsp:include page="loginCenterMenu.jsp" flush="true" />
        
	</td>
        
    <td width="225" valign="top" align="right" > <br />
	<table width="225" border="0" cellspacing="0" cellpadding="0" height="170">
      <tr>
        <td valign="top" align="right"  ></td>
      </tr>
    </table></td>
  </tr>
</table>

	</td>
  </tr>
  <tr>
  <td><br /><br /></td>
  </tr>
  <tr>
    <td colspan="3"  align="center" valign="top" height="50"><jsp:include page="drPortalFooter.jsp" flush="true" /></td>
  </tr>
  </TBODY>
</table>


</body>
</html>
