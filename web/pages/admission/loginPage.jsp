<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%
  response.setHeader("pragma", "no-cache");
  response.setHeader("Cache-Control", "no-cache");
  response.setHeader("Expires", "0");
%>
<script>
function loginSub()
{
    document.loginForm.logBtn.disabled = true;
    document.loginForm.submit();
    return true;
}
</script>

<table width="340" border="0" cellspacing="0" cellpadding="0" height="210">
  <tr><td> <br/><br/><br/>  </td></tr>
  <tr>
    <td align="center" valign="top" background="/pages/resources/admission/images/loginBg.png" style="background-repeat: no-repeat;" height="170" width="340">
	<html:form action="admLogin.do" focus="userId">

	<table width="340" border="0" cellspacing="0" cellpadding="0" height="210">
  <tr>
    <td height="15" colspan="3" align="center" valign="top" class="orgTextBold">الدخول الى الحساب الخاص بطلبك</td>
  </tr>
  	<%--<logic:notPresent name="notLoginProcess">--%>
     <tr>
  	  <td height="15" align="center" valign="middle" class="centerpage" colspan="3"><strong><html:errors/></strong></td>
	 </tr>
    <%--</logic:notPresent>--%>
  <tr>
    <td height="20" colspan="3" align="center" valign="middle" class="qou">للدخول إلى حسابك تحتاج إلى اسم المستخدم وكلمة المرور خاصتك</td>
  </tr>
  <tr>
    <td width="100"  height="25" align="left" valign="middle" class="qou9Bold">&nbsp;&nbsp;:رقم المستخدم</td>
    <td width="153" height="25" align="right" valign="middle"><html:text property="userId" styleClass="input"/></td>
    <td width="87" align="right" valign="middle">&nbsp;</td>
  </tr>
  <tr>
    <td width="100" height="25" align="left" valign="middle" class="qou9Bold" dir="rtl">&nbsp;&nbsp;:كلمة المرور</td>
    <td width="153" height="25" align="right" valign="middle"><html:password property="password" styleClass="inputPassword" redisplay="false"/></td>
    <td width="87" height="25" align="right" valign="middle"><html:submit value="دخول" styleClass="BtnBg60" property="logBtn" onclick="return loginSub();"/></td>
  </tr>
   <tr>
     <td colspan="3" height="50" valign="top" align="left">
         
    </td>
  </tr>
</table>
 </html:form>
	</td>
  </tr>
    <tr><td> <br/><br/><br/>  </td></tr>
</table>