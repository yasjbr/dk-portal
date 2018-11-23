<%@ page import="ps.edu.diyar.common.tools.Randomizer" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/lib/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/lib/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/lib/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://psgateway.org" prefix="pagination" %>
<%@ taglib uri="/WEB-INF/lib/struts-tiles.tld" prefix="tiles" %>

<table align="left" width="99%" border="0" cellPadding=0 cellSpacing=0>
          <tr>
           <td width="99%" valign="top">
<br />
<p align="right" class="centerpage" dir="rtl">  جدول اللقاءات الاسبوعية</p>
 <TABLE cellPadding="0" cellSpacing="0"  width="100%">
      <tr>
      <td>

<table align="right" width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td >
                     <logic:present name="studTermSchedule">
                     <% int i = 0; %>
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="borderRoundedClearColor" bgcolor="#f38e00">
                          <tr class="tabheader">
                            <td width="15%"><div align="center">القاعة</div></td>
                            <%--<td width="13%"><div align="center">البناية</div></td>--%>
                            <td width="11%"><div align="center">الموعد</div></td>
                            <td width="5%"><div align="center">اليوم</div></td>
                            <td width="6%"><div align="center">الشعبة</div></td>
                            <td width="2%"><div align="center">س.م</div></td>
                            <td width="15%"><div align="center">اسم المقرر</div></td>
                            <td width="10%"><div align="center">المقرر/م</div></td>
                          </tr>
                     <logic:iterate id="TermSchedule" name="studTermSchedule" >
                         <%  if (i%2 == 0) { %>
                               <tr  class="tableRowClearColor"  onMouseOver="this.className='highlight'" onMouseOut="this.className='tableRowClearColor'">

                          <%}else {%>
                                <tr class="tableRowLightColor"  onMouseOver="this.className='highlight'" onMouseOut="this.className='tableRowLightColor'">
                          <%}%>


                            <td class="qou"><div align="center"><bean:write name="TermSchedule" property="roomName"/></div></td>
                            <%--<td class="qou"><div align="center"><bean:write name="TermSchedule" property="buildingName"/></div></td>--%>
                            <td class="qou"><div align="center"><bean:write name="TermSchedule" property="beginTime"/> - <bean:write name="TermSchedule" property="endTime"/></div></td>
                            <td class="qou"><div align="center"><bean:write name="TermSchedule" property="dayName"/></div></td>
                            <td class="qou"><div align="center"><bean:write name="TermSchedule" property="classNo"/></div></td>
                            <td class="qou"><div align="center"><bean:write name="TermSchedule" property="courseHours"/></div></td>
                            <td class="qou"><div align="right"><bean:write name="TermSchedule" property="courseName"/></div></td>
                            <td class="qou"><div align="center"><bean:write name="TermSchedule" property="courseNo"/> </div></td>
                          </tr>
                      <% i++; %>
                     </logic:iterate>
                       <tr><td colspan="7">&nbsp;</td></tr>
                     </table>
                     </logic:present>
                      <logic:notPresent name="studTermSchedule">
                      <table width="100%" border="0" cellspacing="0" cellpadding="0" class="border" bordercolor="#999999">
                        <tr bgcolor="#f8eee0" class="centerpage">
                          <td width="99%"><div align="center">&nbsp;  No Avaliable Data </div></td>
                         </tr>
                      </table>
                     </logic:notPresent>
                     </td>
                    </tr>
                  </table>
                    </td>
            </tr>
          </table>
<br />

    </td>
  </tr>
</TABLE>
