<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/lib/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/lib/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/lib/qou-Taglib.tld" prefix="qou" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ page import="java.util.List"%>

<TABLE width="95%" border=0 align="center" cellPadding=0 cellSpacing=0 class="qou" >
  <TBODY>
    <TR>
      <TD width="64%" ><div align="center">
          <table width="100%" height="237" border="0">
          <tr>
          <td width="100%" >
           <logic:present name="propertyMessageTxt">
           <div align="center"><br>
                <table width="90%" border="0" height="30" align="center" cellpadding="0" cellspacing="0" class="borderRoundedRedColor">
                    <tr>
                      <td height="28"     ><div align="center"><b><bean:message key='<%=(String)request.getAttribute("propertyMessageTxt")%>'/></b></div></td>
                    </tr>
                  </table>
            </div>
            </logic:present>
          </td>
          </tr>
            <tr>
              <td width="98%" height="233" valign="top">
                <br>
               <p align="right" class="qou"> يمكنك ان تقوم بتعديل بريدك الالكتروني ورقم الهاتف او الجوال وكلمة المرور و لتغيير كلمة المرور, أدخل الكلمة الحالية في المكان المحدد ثم أدخل الكلمة الجديدة مرتان على أن لا يقل عدد حروفها عن 6 ولا يزيد عن 18 حرف ثم إضغط إستمرار</p>

                <html:form action="updateCmaPassword.do">
                <input type="hidden" name="type"          value="5">
                <input type="hidden" name="auditScreenId" value="5">
                <table width="100%" cellspacing="0" cellpadding="0">
                  <tr>
                    <td align="right" class="centerpage" colspan='2'>الاعدادات الشخصية</td>
                  </tr>
                  <tr>
                    <td align="right" class="qou" colspan='2'><hr align="center" color="#f38e00" size="1"></td>
                  </tr>
                  <tr>
                    <td align="right" class="qou"><html:text property="email" styleClass="largeInput" /></td>
                    <td class="qou" align="right" width="20%" >:البريد الالكتروني</td>
                  </tr>
                  <tr>
                    <td align="right" class="qou" colspan='2' height='0'><html:errors property="wrongEmail"/></td>
                  </tr>
				  <tr>
                    <td align="right" class="qou"><html:errors property="wrongPhone"/> <html:text property="mobile" styleClass="largeInput"  	 maxlength="14"/></td>
                    <td class="qou" align="right" width="20%">:رقم الهاتف/الجوال</td>
                  </tr>
                </table>
                 <br>
                 <table width="100%" cellspacing="0" cellpadding="0">
                  <tr>
                    <td align="right" class="centerpage" colspan='2'>تغيير كلمة المرور</td>
                  </tr>
                  <tr>
                    <td align="right" class="qou" colspan='2'><hr align="center" color="#f38e00" size="1"></td>
                  </tr>
		  <tr>
                    <td align="right" class="qou"><html:password property="oldPassword" styleClass="largeInput"  maxlength="18"/></td>
                    <td class="qou" align="right" width="20%">:كلمة المرور الحالية</td>
                  </tr>
                  <tr>
                    <td align="right" class="qou" colspan='2' height='0'><html:errors property="wrongOldPassword" /></td>
                  </tr>
                  <tr>
                    <td align="right"><html:password property="newPassword" styleClass="largeInput"  maxlength="18"/></td>
                    <td class="qou" align="right" width="20%">:كلمة المرور الجديدة</td>
                  </tr>
                  <tr>
                    <td align="right"><html:password property="newPassword2" styleClass="largeInput"   maxlength="18"/></td>
                    <td class="qou" align="right" width="20%">:كلمة المرور الجديدة</td>
                  </tr>
                  <tr>
                    <td align="right" class="qou" colspan='2' height='0'><html:errors property="wrongNewPassword" /></td>
                  </tr>
                </table>
                <br>
                <table width="100%" cellspacing="0" cellpadding="0">
                  <tr>
                    <td align="right">
                    <html:reset value="مسح" styleClass="enter"/>
                    <html:submit value="إستمرار" styleClass="enter"/>
                    </td>
                    <td width="20%"></td>
                  </tr>
                  <tr>
                    <td align="right" class="qou" colspan='2' height='0'><html:errors property="successUpdate"/></td>
                  </tr>
                </table>
               </html:form>
              </td>
            </tr>
          </table>
        </div>
      </TD>
    </TR>
 </TBODY>
</TABLE>