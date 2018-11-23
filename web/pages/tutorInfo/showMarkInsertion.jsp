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
             <br>
            <div align="right" class="centerpage"> ادخال العلامات</div>
            <TABLE cellPadding=0 cellSpacing=0 class="borderRoundedClearColor" width="100%">
             <TBODY>
                <tr><td>
                <form name="form2" action="../../tutor/viewTutorMessageAction.do?.rv=<%=Randomizer.shortRandom()%>" method="get">
                <div align="right">
                  <table width="100%" border="0" cellspacing="0" cellpadding="0"  >
                    <tr>
                      <td >
                     <logic:present name="tutorTermSchedule">
                     <% int i = 0; %>
                      <table width="100%" border="0" cellspacing="0" cellpadding="0">
                          <tr class="tabheader">
                              <td width="30%" height="17" class="borderTopLeftBigColor"><div align="center">ادخال العلامات</div></td>
                              <td width="10%"><div align="center">الشعبة</div></td>
                              <td width="40%"><div align="center">اسم المقرر</div></td>
                              <td width="20%" class="borderTopRightBigColor"><div align="center">المقرر/م</div></td>
                          </tr>
                     <logic:iterate id="TermSchedule" name="tutorTermSchedule" >
                         <%  if (i%2 == 0) { %>
                               <tr  class="tableRowClearColor"  onMouseOver="this.className='highlight'" onMouseOut="this.className='tableRowClearColor'">

                          <%}else {%>
                                <tr class="tableRowLightColor"  onMouseOver="this.className='highlight'" onMouseOut="this.className='tableRowLightColor'">
                          <%}%>
                            <td class="qou"><div align="center">
                                <a href="../../tutor/viewMarksInsertion.do?.rv=<%=Randomizer.shortRandom()%>&classNo=<bean:write name="TermSchedule" property="classNo"/>&crsNo=<bean:write name="TermSchedule" property="courseNo"/>&crsSeq=&termNo=<bean:write name="TermSchedule" property="termNo"/> " class="qou">
                                دخول</a></div>
                            </td>
                             <td class="qou"><div align="center"> <bean:write name="TermSchedule" property="classNo"/></div></td>
                             <td class="qou"><div align="right"><bean:write name="TermSchedule" property="courseName"/></div></td>
                             <td class="qou"><div align="center"><bean:write name="TermSchedule" property="courseNo"/></div></td>
                          </tr>
                      <% i++; %>
                     </logic:iterate>
                     </table>
                     </logic:present>
                      <logic:notPresent name="tutorTermSchedule">
                      <table width="100%" border="1" cellspacing="0" cellpadding="0" class="border" bordercolor="#4A6D8C">
                        <tr bgcolor="#EAF0F4" class="centerpage">
                          <td width="99%"><div align="center">&nbsp;  No Avaliable Data </div></td>
                         </tr>
                      </table>
                     </logic:notPresent>
                     </td>
                    </tr>
                  </table>
                   </div> </form></td>
            </tr>
           </TBODY></table>


                </td></tr>

                </TABLE>
             </div></td></tr>




</TABLE>