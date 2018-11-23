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

<script type="text/javascript">
    function sendMessage()
{
  var selection = false;
  for(var i=0; i < document.form2.elements.length; i++)
  {
    var elementName = new String(document.form2.elements[i].name);
    if(elementName.indexOf("sendMsg_") != -1)
      if(document.form2.elements[i].checked)
        selection = true;
  }

  if(!selection)
    alert("الرجاء اختيار شعبة واحدة على الاقل قبل الضغط على المراسلات");
  else
    document.form2.submit();
}
</script>
 
<TABLE width="99%" border=0 align="center" cellPadding=0 cellSpacing=0>
  <TBODY>
    <TR>
      <TD><div align="center">
        <table width="100%" border="0">
          <tr>
           <td width="100%" valign="top">
             <br>
            <div align="right" class="centerpage"> المراسلات</div>
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
                            <td width="15%" height="17" class="borderTopLeftBigColor"><div align="center">الوارد</div></td>
                            <td width="15%" height="17" class="borderTopLeftBigColor"><div align="center">الصادر</div></td>
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
                             <a  href="../../tutor/viewUserMessages.do?crsNo=<bean:write name="TermSchedule" property="courseNo" />&crsClass=<bean:write name="TermSchedule" property="classNo" />&termNo=<bean:write name="TermSchedule" property="termNo" />&.rv=<%=Randomizer.shortRandom()%>" title="عرض رسائل <bean:write name="TermSchedule" property="courseName" />"><img src="/pages/resources/images/msg.png" border="0" height="25" width="25" alt="عرض رسائل <bean:write name="TermSchedule" property="courseName" />"  /></a>
                            </div></td>
                            <td class="qou"><div align="center">
                             <a  href="../../tutor/viewSentMessages.do?crsNo=<bean:write name="TermSchedule" property="courseNo" />&crsClass=<bean:write name="TermSchedule" property="classNo" />&termNo=<bean:write name="TermSchedule" property="termNo" />&.rv=<%=Randomizer.shortRandom()%>" title="عرض رسائل <bean:write name="TermSchedule" property="courseName" />"><img src="/pages/resources/images/msgSent.png" border="0" height="25" width="25" alt="عرض رسائل <bean:write name="TermSchedule" property="courseName" />"  /></a>
                            </div></td>
                             <td class="qou"><div align="center"><bean:write name="TermSchedule" property="classNo"/></div></td>
                             <td class="qou"><div align="right"><bean:write name="TermSchedule" property="courseName"/></div></td>
                             <td class="qou"><div align="center"><bean:write name="TermSchedule" property="courseNo"/><input type="checkbox" name="sendMsg_<%=i%>" value="classNo=<bean:write name="TermSchedule" property="classNo"/>_a_crsNo=<bean:write name="TermSchedule" property="courseNo"/>_b_crsSeq=_c_term=<bean:write name="TermSchedule" property="termNo"/>"></div></td>
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

                 <tr><td>
                 <br>
                  <div align="center"><br>
                    <span class="centerpage"> &nbsp;<a href="javascript:sendMessage()" class="enter">مراسلات</a></span></div>
       </td></tr>


</TABLE>