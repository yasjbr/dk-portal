<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/lib/struts-bean.tld"    prefix="bean" %>
<%@taglib uri="/WEB-INF/lib/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/lib/struts-logic.tld"   prefix="logic" %>
<%@ taglib  uri="/WEB-INF/lib/struts-bean.tld" prefix="bean" %>
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
<table width="500" border="0" cellspacing="0" cellpadding="0" height="218">
  <tr>
    <td align="center" valign="top" background="/pages/resources/images/loginBg.png" style="background-repeat: no-repeat;" height="170" width="800">
	<html:form action="/login.do" focus="userId">
    <input type="hidden" id="uip" name="uip" value="<%= request.getRemoteAddr() %>" />
<%--<div   style="display:none;visibility:hidden"  id="uip"><%= request.getRemoteAddr() %></div>--%>
<table width="500" border="0" cellspacing="0" cellpadding="0" height="231">
     <logic:notPresent name="notLoginProcess">
     <tr> 
          
  	  <td height="25" align="center" valign="middle" class="messageTxt" colspan="3"><strong><html:errors/></strong></td>
	 
     </tr>
      
    </logic:notPresent>
     
  <tr>
    <td height="42" colspan="3" align="center" valign="top" class="centerpage">للدخول إلى حسابك تحتاج إلى رقمك الجامعي وكلمة المرور خاصتك</td>
  </tr>
   
  <tr>
       
    <td align="center" valign="middle" width="137" rowspan="2" ><img src="/pages/resources/images/diyar_Logo_Small.png" width="63" height="65" /></td>
    <td width="137" height="25" align="left" valign="top" class="qou9Bold">&nbsp;&nbsp;:رقم المستخدم</td>
    <td width="226" height="25" valign="bottom"><html:text property="userId" styleClass="input"/></td>
  </tr>
  <tr>
       
     <td height="32" align="left" valign="bottom" class="qou9Bold">&nbsp;&nbsp;:كلمة المرور</td>
   <td valign="bottom" height="32"><html:password property="password" styleClass="inputPassword" redisplay="false"/>&nbsp;&nbsp;&nbsp;
      <html:submit value="دخول" styleClass="BtnBg60" property="logBtn" onclick="return loginSub();"/></td>
  </tr>
 
 <logic:present name="captchImageRequired">
   <tr>
        <td width="137" height="38" align="right" valign="middle" class="qou">&nbsp;</td>
        <td width="137" height="38" align="left" valign="bottom" class="qou9Bold">&nbsp;&nbsp;:كلمة الحماية</td>
        <td width="226" valign="bottom"><input type="text" name="secText" class="input" /></td>
   </tr>

   <tr>
        <td width="137" height="42" align="right" valign="middle" >&nbsp;</td>
        <td width="137" height="42" align="right" valign="middle" >&nbsp;</td>
        <td width="226" align="right" valign="middle"><span class="messageTxt">ادخل النص الظاهر في الصورة</span>
  <%--            <img src="/pages/imageText.jsp" width="45" height="17" border="1"/>&nbsp;--%>
          <img src="/captchaImage.do?.rv=<%=ps.edu.diyar.common.tools.Randomizer.shortRandom()%>" width="45" height="17" border="1" valign="bottom" />&nbsp;</td>
          
  </tr>
   </logic:present>
 
 <logic:notPresent name="captchImageRequired">
 </logic:notPresent>

  <tr valign="top" >
    <td width="137" align="right" valign="middle" class="qou">&nbsp;</td>
    <td width="137" align="right" valign="middle" class="qou">&nbsp;</td>
    <td valign="top" align="right">
      <%--<img src="/pages/resources/images/bulet.png">&nbsp;<a  href="/admLoginView.do">تقديم طلب التحاق</a><br>--%>
      <%--<img src="/pages/resources/images/bulet.png"> نسيت كلمة المرور--%>
    </td>
  </tr>
</table>
 </html:form>
     
	</td>
  </tr>
</table>