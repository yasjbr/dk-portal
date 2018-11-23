<%@ page import="ps.edu.diyar.common.tools.Randomizer" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/lib/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/lib/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/lib/qou-Taglib.tld" prefix="qou" %>
<%@ taglib uri="/WEB-INF/lib/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/lib/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/lib/qou-Taglib.tld" prefix="qou" %>

 
 
<%@ taglib uri="/WEB-INF/lib/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://psgateway.org" prefix="pagination" %>
<%@ taglib uri="/WEB-INF/lib/struts-tiles.tld" prefix="tiles" %>
<%
  response.setHeader("pragma", "no-cache");
  response.setHeader("Cache-Control", "no-cache");
  response.setHeader("Expires", "0");
%>

<table align="left" width="99%" height="412" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td width="99%"  valign="top">
				<br />
<logic:present name="hasLoan">
    <p align="right" class="qou"><span class="qouRed"><strong>ملاحظه هامة:</strong></span> الطالب مقسط لهذا الفصل: لذلك لا يمكن اظهار حالة المادة والعلامة النهائية إلا بعد تسديد الاقساط، فقط يمكن الاطلاع على علامة الإمتحان النصفي والتعيين الاول</p>
</logic:present>

<logic:present name="showingCurrentSystemTerm">
<%-- Show current term marks (active term)--%>
<p align="right" class="centerpage" dir="rtl">المراسلات:</p>
<table width="100%" cellspacing="0" cellpadding="0" class="borderRoundedClearColor" >
                    <tr>
                      <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
                              <TR >
                                <TD class="borderTopLeftBigColor"  width="20"> <DIV align=center>الوارد</DIV></TD>
                                 <TD class="borderTopLeftBigColor"  width="20"> <DIV align=center>الصادر</DIV></TD>
                                <TD class="tabheader" width="40%"><DIV align=center>اسم المقرر</DIV></TD>
                                <TD class="borderTopRightBigColor" width="20%"><DIV align=center>رقم المقرر</DIV></TD>
                              </TR>

                      <logic:present name="termCourseSummary">
                       <% int i = 0; %>
                       <logic:iterate id="TermCourse" name="termCourseSummary" >
                        <%  if (i%2 == 0) { %>
                               <tr  class="tableRowClearColor"  onMouseOver="this.className='highlight'" onMouseOut="this.className='tableRowClearColor'">

                          <%}else {%>
                                <tr class="tableRowLightColor"  onMouseOver="this.className='highlight'" onMouseOut="this.className='tableRowLightColor'">
                          <%}%>
                          <td><div align="center" class="qou"><a  href="../../student/viewUserMessages.do?crsNo=<bean:write name="TermCourse" property="crsNo" />&crsClass=<bean:write name="TermCourse" property="crsClass" />&termNo=<bean:write name="TermCourse" property="termNo" />&.rv=<%=Randomizer.shortRandom()%>" title="عرض رسائل <bean:write name="TermCourse" property="crsAName" />"><img src="/pages/resources/images/msg.png" border="0" height="25" width="25" alt="عرض رسائل <bean:write name="TermCourse" property="crsAName" />"  /></a></div></td>
                           <td><div align="center" class="qou"><a  href="../../student/viewSentMessages.do?crsNo=<bean:write name="TermCourse" property="crsNo" />&crsClass=<bean:write name="TermCourse" property="crsClass" />&termNo=<bean:write name="TermCourse" property="termNo" />&.rv=<%=Randomizer.shortRandom()%>" title="عرض رسائل <bean:write name="TermCourse" property="crsAName" />"><img src="/pages/resources/images/msgSent.png" border="0" height="25" width="25" alt="عرض رسائل <bean:write name="TermCourse" property="crsAName" />"  /></a></div></td>
                          <td>
                            <div align="right" class="qou">
                               <bean:write name="TermCourse" property="crsAName" />
                            </div>
                          </td>
                          <td>
                            <div align="center" class="qou">
                                  <bean:write name="TermCourse" property="crsNo" />
                            </div>
                          </td>
                        </tr>
                        <% i++; %>
                       </logic:iterate>
                       <tr><td colspan="6" >&nbsp;</td></tr>
                      </logic:present>
                     <logic:notPresent name="termCourseSummary">
                      <tr >
                        <td colspan="5" ><div align="center" class="centerpage"><font color=red><html:errors/></font></div></td>
                      </tr>
                    </logic:notPresent>

                      </table></td>
                    </tr>
                  </table>
<%--End Of Show current term marks (active term)--%>
</logic:present>
<logic:notPresent name="showingCurrentSystemTerm">
                   <div align="center" class="centerpage"><font color=red>حاليا لاتوجد مراسلات </font></div>
</logic:notPresent>


             </td>
            </tr>
          </table>