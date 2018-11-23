<%@ page import="ps.edu.diyar.common.tools.Randomizer" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/lib/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/lib/qou-Taglib.tld" prefix="qou" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%
  String term = null;
  if(request.getParameter("term") != null)
   term = request.getParameter("term");
  else if(request.getAttribute("term") != null)
   term = (String) request.getAttribute("term");
%>

 
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

                <div align="right">
                  <table width="100%" border="0" cellspacing="0" cellpadding="0"  >
                    <tr>
                      <td  align="center">
                     <logic:present name="tutCrsList">
                     <% int i = 0; %>
                         
                         <logic:present name="tutInfo">
                             <logic:iterate id="tutInfo" name="tutInfo" >
                                 <br/>
                             <table width="100%" border="0" cellspacing="0" cellpadding="0" class="borderRoundedLightColor">
                               <tr  >
                                 <td width="10%" class="qou" ><div align="right"><bean:write name="tutInfo" property="empNo" />&nbsp;&nbsp;</div></td>
                                 <td width="25%" class="tabheader"><div align="center" class="centerpage">رقم عضو هيئة التدريس:</div></td>
                                 <td width="40%" class="qou"  ><div align="right"><bean:write name="tutInfo" property="tutorAName" />&nbsp;&nbsp;</div></td>
                                 <td width="25%" class="tabheader"><div align="center" class="centerpage">&nbsp;&nbsp;اسم عضو هيئة التدريس:</div></td>
                               </tr>
                             </table>

                             </logic:iterate>
                            </logic:present> 
                          <div align="right" class="centerpage"> قائمة المقررات</div>
                      <table width="100%" border="0" cellspacing="0" cellpadding="0" class="borderRoundedClearColor">
                          <tr class="tabheader">
                            <td width="30%" height="17" class="borderTopLeftBigColor"><div align="center">العلامات</div></td>
                            <td width="10%"><div align="center">الشعبة</div></td>
                            <td width="40%"><div align="center">اسم المقرر</div></td>
                            <td width="20%" class="borderTopRightBigColor"><div align="center">المقرر</div></td>
                          </tr>
                     <logic:iterate id="TermSchedule" name="tutCrsList" >
                         <%  if (i%2 == 0) { %>
                               <tr  class="tableRowClearColor"  onMouseOver="this.className='highlight'" onMouseOut="this.className='tableRowClearColor'">

                          <%}else {%>
                                <tr class="tableRowLightColor"  onMouseOver="this.className='highlight'" onMouseOut="this.className='tableRowLightColor'">
                          <%}%>
                            <td class="qou"><div align="center">
                                <a href="../../deptMstr/marksApprove.do?.rv=<%=Randomizer.shortRandom()%>&empNo=<%=request.getParameter("tutNo")%>&classNo=<bean:write name="TermSchedule" property="classNo"/>&crsNo=<bean:write name="TermSchedule" property="courseNo"/>&crsSeq=&termNo=<bean:write name="TermSchedule" property="termNo"/> " class="qou">
                               عرض</a></div>
                            </td>
                             <td class="qou"><div align="center"><bean:write name="TermSchedule" property="classNo"/></div></td>
                             <td class="qou"><div align="right"><bean:write name="TermSchedule" property="courseName"/></div></td>
                             <td class="qou"><div align="center"><bean:write name="TermSchedule" property="courseNo"/></div></td>
                          </tr>
                      <% i++; %>
                     </logic:iterate>
                          <tr><td colspan="3">&nbsp;</td></tr>
                     </table>
                     </logic:present>
                      <logic:notPresent name="tutCrsList">
                      <table width="100%" border="1" cellspacing="0" cellpadding="0" class="border" bordercolor="#4A6D8C">
                        <tr bgcolor="#EAF0F4" class="centerpage">
                          <td width="99%"><div align="center">&nbsp;  No Avaliable Data </div></td>
                         </tr>
                      </table>
                     </logic:notPresent>
                           <br/>
                          <input type="button" value="  عودة  " class="enter" onclick="javaScript:parent.location = '/deptMstr/tutorsDeptList.do?.rv=<%= Randomizer.shortRandom()%>'">&nbsp;
                          
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