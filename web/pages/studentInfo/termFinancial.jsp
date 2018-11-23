<%@ page import="ps.edu.diyar.common.tools.Randomizer" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/lib/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/lib/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/lib/qou-Taglib.tld" prefix="qou" %>
<%@ taglib uri="/WEB-INF/lib/struts-logic.tld" prefix="logic" %>
<%
    response.setHeader("pragma", "no-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Expires", "0");
%>
<script language="javascript">
    function setListSelection(selection, list)
    {
        for (var i = 0; i < list.options.length; i++)
        {
            if (list.options[i].value == selection)
            {
                list.selectedIndex = i;
                break;
            }
        }
    }



</script>
<table align="left" width="99%" cellpadding="0" cellspacing="0" border="0">
    <tr>
        <td width="99%"  valign="top">


            <br>
            <!-- here -->
            <form name = "form1" action="../../student/showSelectedTermFinancial.do?.rv=<%=Randomizer.shortRandom()%>" method="post">
                <TABLE cellPadding="0" cellSpacing="0" class="borderRoundedLightColor" width="100%">
                    <TBODY>
                        <TR>
                            <TD>
                                <TABLE border=0 cellPadding=0 cellSpacing=0 height=24 width="99%">
                                    <TBODY>
                                        <TR   height=24 vAlign=center>
                                            <TD height=24 width="24%">
                                                <DIV align=center class="centerpage">

                                                    <!-- the terms navigation tags -->
                                                    <qou:TermListNavigator pageType="student/showSelectedTermFinancial.do"/>

                                                </DIV></TD>
                                            <TD height=24 width="58%">
                                                <DIV align=center>
                                                    <INPUT class=enter name=Submit type=submit value=اذهب>
                                                    <select class=bigList name="term">
                                                        <logic:present name="termsList">
                                                            <logic:iterate id="termsList" name="termsList">
                                                                <option value=<bean:write name="termsList" property="termNo"/>                                
                                                                        >
                                                                    <bean:write name="termsList" property="termName" />
                                                                    -

                                                                    <bean:write name="termsList" property="termNo" />
                                                                </logic:iterate>
                                                            </logic:present>
                                                    </select>
                                                    <%
                                                        String term = null;
                                                        if (request.getParameter("term") != null) {
                                                            term = request.getParameter("term");
                                                        } else {
                                                            term = (String) request.getAttribute("term");
                                                        }
                                                    %>
                                                    <script>setListSelection("<%=term%>", document.form1.term)</script>
                                                </DIV></TD>
                                            <TD height=24 width="18%" class="centerpage" align="center">الفصل الدراسي   :</TD>
                                        </TR></TBODY></TABLE></TD></TR></TBODY></TABLE>
            </form>

            <logic:present name="hasLoan">
                <div align="right"  class="qou"><b><font color="#FF0000">ملاحظه هامة:</font></b>الطالب مقسط لهذا الفصل: لذلك لا يمكن اظهار حالة المادة والعلامة النهائية إلا بعد تسديد الاقساط، فقط يمكن الاطلاع على علامة الإمتحان النصفي والتعيين الاول</div><br>
                    </logic:present>
                    <logic:present name="Error">
                <div align="right"  class="qou"><b><font color="#FF0000">ملاحظه هامة:</font></b>عزيزي الطالب: لا يمكنك استعراض علامات الفصل المختار قبل تسديد رسوم هذا الفصل.</div><br>
                    </logic:present>
                    <logic:present name="showingCurrentSystemTerm">
                        <%-- Show current term marks (active term)--%>
                <p class="centerpage" align="right" dir="rtl">المقررات الفصلية:</p>
                <table width="100%" cellspacing="0" cellpadding="0" class="borderRoundedClearColor" >
                    <tr>
                        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
                                <TR >
                                    <%--<TD class="borderTopLeftBigColor"  width="11%"> <DIV align=center>المراسلات</DIV></TD>--%>
                                    <TD class="borderTopLeftBigColor" width="10%"><DIV align=center>العلامة</DIV></TD>
                                    <TD class="tabheader" width="10%" height=19 ><DIV align=center>الحالة</DIV></TD>
                                    <TD class="tabheader" width="10%"><DIV align=center>عدد الساعات</DIV></TD>
                                    <TD class="tabheader" width="35%"><DIV align=center>اسم المقرر</DIV></TD>
                                    <TD align="center" class="borderTopRightBigColor" width="15%">رقم المقرر</TD>
                                </TR>

                                <logic:present name="termCourseSummary">
                                    <% int i = 0; %>
                                    <logic:iterate id="TermCourse" name="termCourseSummary" >
                                        <%  if (i % 2 == 0) { %>
                                        <tr  class="tableRowClearColor"  onMouseOver="this.className = 'highlight'" onMouseOut="this.className = 'tableRowClearColor'">

                                            <%} else {%>
                                        <tr class="tableRowLightColor"  onMouseOver="this.className = 'highlight'" onMouseOut="this.className = 'tableRowLightColor'">
                                            <%}%>
                                            <%--<td><div align="center" class="qou"><a  href="../../student/viewUserMessages.do?crsNo=<bean:write name="TermCourse" property="crsNo" />&crsClass=<bean:write name="TermCourse" property="crsClass" />&termNo=<bean:write name="TermCourse" property="termNo" />&.rv=<%=Randomizer.shortRandom()%>" title="عرض رسائل <bean:write name="TermCourse" property="crsAName" />"><img src="/pages/resources/images/msg.png" border="0" height="25" width="25" alt="عرض رسائل <bean:write name="TermCourse" property="crsAName" />"  /></a></div></td>--%>
                                            <td><div align="center" class="qou"><bean:write name="TermCourse" property="mark" /></div></td>
                                            <td height="14"><div align="center" class="qou"><bean:write name="TermCourse" property="regStatusAName" /></div></td>
                                            <td><div align="center" class="qou"><bean:write name="TermCourse" property="crHrs" /></div></td>
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
                                    <tr>
                                        <td>&nbsp;</td>
                                        <td colspan="3">&nbsp;</td>
                                        <td>&nbsp;</td>
                                    </tr>
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

                <%-- Show normal older terms--%>



                <%--End Of Show normal terms--%>
            </logic:notPresent>
            <p align="right" class="centerpage" dir="rtl">بيانات الفصل:</p>
            <!-- to view term details -->

            <logic:present name="selectedTermFinancial">
                <logic:iterate id="selectedTermFinancial" name="selectedTermFinancial" >
                    <logic:notPresent name="Error">
                        <table width="100%" height="50" cellpadding="0" cellspacing="0" class="borderRoundedClearColor" >
                            <tr>
                                <td height="50" ><table border="0"  width="100%" height="50"   cellpadding="0" cellspacing="0">
                                        <tr>
                                            <td class="tabheader" width="12%"><div align="center">الرصيد المتبقي</div></td>
                                            <td class="tabheader" width="12%"><div align="center"> قيمة المنحة</div></td>
                                            <td class="tabheader" width="12%"><div align="center">المبلغ المطلوب</div></td>
                                            <td class="tabheader" width="11%"><div align="center">المبلغ المدفوع</div></td>
                                        </tr>
                                        <tr class="qou">
                                             <td height="15"><div align="center"><bean:write name="selectedTermFinancial" property="baseTermBalance" /></div></td>
                                               <td height="15"><div align="center"><bean:write name="selectedTermFinancial" property="schlrValue" /></div></td>
                                            <td height="15"><div align="center"><bean:write name="selectedTermFinancial" property="dbBaseAmt" /></div></td>
                                            <td><div align="center"><bean:write name="selectedTermFinancial" property="crBaseAmt" /></div></td>
                                        </tr> 
                                    </table></td>
                            </tr>
                        </table>
                    </logic:notPresent>  
                </logic:iterate>
            </logic:present>



            <logic:present name="selectedTermFinancialDetail">
                <%-- Show current term marks (active term)--%>
                <p align="right" class="centerpage" dir="rtl">التفاصيل:</p>
                <table width="100%" cellspacing="0" cellpadding="0" class="borderRoundedClearColor" >
                    <tr>
                        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
                                <TR >
                                    <TD class="borderTopLeftBigColor"  width="50%"> <DIV align=center>المبلغ</DIV></TD>
                                    <TD class="borderTopLeftBigColor"  width="50%"> <DIV align=center>البند المالي</DIV></TD>

                                </TR>

                                <logic:present name="selectedTermFinancialDetail">
                                    <% int c = 0; %>
                                    <logic:iterate id="selectedTermFinancialDetail" name="selectedTermFinancialDetail" >
                                        <%  if (c % 2 == 0) { %>
                                        <tr  class="tableRowClearColor"  onMouseOver="this.className = 'highlight'" onMouseOut="this.className = 'tableRowClearColor'">

                                            <%} else {%>
                                        <tr class="tableRowLightColor"  onMouseOver="this.className = 'highlight'" onMouseOut="this.className = 'tableRowLightColor'">
                                            <%}%>
                                            <td>
                                                <div align="center" class="qou">
                                                    <bean:write name="selectedTermFinancialDetail" property="smDbAmt" />
                                                </div>
                                            </td>
                                            <td>
                                                <div align="center" class="qou">
                                                    <bean:write name="selectedTermFinancialDetail" property="finName" />
                                                </div>
                                            </td>
                                        </tr>
                                        <% c++;%>
                                    </logic:iterate>
                                    <tr><td colspan="2" >&nbsp;</td></tr>
                                </logic:present>
                                <logic:notPresent name="selectedTermFinancialDetail">
                                    <tr >
                                        <td colspan="2" ><div align="center" class="centerpage"><font color=red><html:errors/></font></div></td>
                                    </tr>
                                </logic:notPresent>

                            </table></td>
                    </tr>
                </table>



                <%--End Of Show current term marks (active term)--%>
            </logic:present>











            <logic:notPresent name="selectedTermFinancial">
                <table width="99%" border="1" cellspacing="0" cellpadding="0" class="border" bordercolor="#4A6D8C">
                    <tr class="tableRowLightColor">
                        <td width="99%"><div align="center" class="centerpage">&nbsp;No Avaliable Data</div></td>
                    </tr>
                </table>
            </logic:notPresent>
            <br/><br/>
        </td>
    </tr>
</table>