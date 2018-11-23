<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/lib/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/lib/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<table width="95%">
	<tr>
		<td><br><br>
		  <div align="center" class="centerpage">الرجاء ادخال رقم الطالب وثم الضغط على زر تحميل</DIV>
           <html:form action="loadStudentRegCrsInfo.do" method="post" >
             <table border="0" cellpadding="0" cellspacing="5" width="100%">
               <tr class="subtitle">
                    <td height="17" align="center" width="99%">
                         <html:submit styleClass="enter"  property="save"  value="تحميل" />
                         <html:text property="studId"  styleClass="largeInput"/>
                         <span class="centerpage">:رقم الطالب</span>
                    </td>
                </tr>
               <tr class="subtitle">
                    <td width="99%" align="center" >
                        <html:errors/>
                    </td>
                </tr>

                <%--<tr class="centerpage">--%>
                    <%--<td width="99%" align="center" >--%>
                    <%--<br/>--%>
                    <%--أو--%>
                    <%--<br/><br/>--%>
                    <%--<input type="button" value="  استعراض الطلاب المسجلين  " class="enter" onclick="javaScript:parent.location = '/deptMstr/viewRegStudListDept.do'">&nbsp;--%>
                    <%--</td>--%>
                <%--</tr>--%>

            </table>
           </html:form>
		</td>
	</tr>

</table>