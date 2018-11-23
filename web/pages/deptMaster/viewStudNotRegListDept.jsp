<%@ page import="ps.edu.diyar.common.tools.Randomizer" %>
<%@ page import="ps.edu.diyar.common.component.ServletContextAttribute" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/lib/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/lib/qou-Taglib.tld" prefix="qou" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>



<TABLE width="99%" border=0 align="center" cellPadding=0 cellSpacing=0>
  <TBODY>
    <TR>
      <TD><div align="center">
        <table width="100%" border="0">
          <tr>
           <td width="100%" valign="top">

            <TABLE cellPadding=0 cellSpacing=0  width="100%">
             <TBODY>
                <tr><td>
              <logic:present name="operationMessage">
              <div align="center"><b><bean:message key='<%= request.getAttribute("operationMessage")+"" %>'/> </b><br/></div>
              </logic:present>
                  <br/>
                <div align="right">
                  <table width="100%" border="0" cellspacing="0" cellpadding="0"  >
                    <tr>
                      <td  align="center">
                     <logic:present name="studList">
                     <% int i = 0; %>

                          <div align="right" class="centerpage"> قائمة الطلاب الغير المسجلين للفصل : <%= new ServletContextAttribute(request).getCrsRegTerm()%></div>
                      <table width="100%" border="0" cellspacing="0" cellpadding="0" class="borderRoundedClearColor">
                          <tr class="tabheader">
                            <td width="10%" height="17" class="borderTopLeftBigColor"><div align="center">&nbsp;</div></td>
                            <td width="10%"><div align="center">الخطة الاسترشادية</div></td>
                            <td width="30%"><div align="center">اسم الطالب</div></td>
                            <td width="20%"><div align="center">رقم الطالب</div></td>
                            <td width="10%"><div align="center">رقم الخطة</div></td>
                            <td width="5%"  class="borderTopRightBigColor"></td>
                           </tr>
                     <logic:iterate id="studList" name="studList" >
                         <%  if (i%2 == 0) { %>
                               <tr  class="tableRowClearColor"  onMouseOver="this.className='highlight'" onMouseOut="this.className='tableRowClearColor'">

                          <%}else {%>
                                <tr class="tableRowLightColor"  onMouseOver="this.className='highlight'" onMouseOut="this.className='tableRowLightColor'">
                          <%}%>
                             <td></td>
                             <td class="qou"><div align="center"><a href="../../deptMstr/studMsCrsInDptList.do?.rv=<%=Randomizer.shortRandom()%>&studId=<bean:write name="studList" property="studId"/>">عرض</a></div></td>
                             <td class="qou"><div align="right" ><a href="../../deptMstr/loadStudentRegCrsInfo.do?.rv=<%=Randomizer.shortRandom()%>&studId=<bean:write name="studList" property="studId"/>"><bean:write name="studList" property="studName"/></a></div></td>
                             <td class="qou"><div align="center"><a href="../../deptMstr/loadStudentRegCrsInfo.do?.rv=<%=Randomizer.shortRandom()%>&studId=<bean:write name="studList" property="studId"/>"><bean:write name="studList" property="studId"/></a></div></td>
                             <td class="qou"><div align="center"><bean:write name="studList" property="majorSheetNo"/></div></td>
                             <td align="center"><%=i+1%></td>
                           </tr>
                      <% i++; %>
                     </logic:iterate>
                          <tr><td colspan="7">&nbsp;</td></tr>
                     </table>
                         <br/>
                      <div align="right" class="qouRed">* لأستعراض بيانات الطالب قم بالضغط على رقم الطالب او اسمه</div>
                     </logic:present>
                      <logic:present name="searchNotFoundResult">
                      <table width="100%" border="1" cellspacing="0" cellpadding="0" class="border" bordercolor="#4A6D8C">
                        <tr bgcolor="#EAF0F4" class="centerpage">
                          <td width="99%"><div align="center">&nbsp;  No Avaliable Data </div></td>
                         </tr>
                      </table>
                     </logic:present>
                           <br/>
                          <%--<input type="button" value="  عودة  " class="enter" onclick="javaScript:parent.location = '/deptMstr/tutorsDeptList.do?.rv=<%= Randomizer.shortRandom()%>'">&nbsp;--%>

                     </td>
                    </tr>
                  </table>
                   </div>  </td>
            </tr>
           </TBODY></table>


                </td></tr>

                </TABLE>
             </div></td></tr>




</TABLE>