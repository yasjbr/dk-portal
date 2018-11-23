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
    
    function openDetailsWindow(course,first,second,mid,practical,final)
    {
        var broswerName = new String(navigator.appName);

        if (broswerName.indexOf("Microsoft") >= 0)
        {
            var win = window.open('../../student/showSelectedCourseSummary.do?.rv=<%=ps.edu.diyar.common.tools.Randomizer.shortRandom()%>&course=' + course +'&first='+ first +'&second='+ second +'&mid='+ mid +'&final='+ final +'&practical='+ practical  , '', 'toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=no,width=600,height=520');
        }
        else if (broswerName.indexOf("Netscape") >= 0)
        {
            var win = window.open('../../student/showSelectedCourseSummary.do?.rv=<%=ps.edu.diyar.common.tools.Randomizer.shortRandom()%>&course=' + course +'&first='+ first +'&second='+ second +'&mid='+ mid +'&final='+ final +'&practical='+ practical  , '', 'toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=no,width=600,height=520');
        }

    }
    
function setListSelection(selection, list)
{
  for(var i=0; i < list.options.length; i++)
  {
    if(list.options[i].value == selection)
    {
       list.selectedIndex = i;
       break;
    }
  }
}



</script>



 <table width="99%" border="0" cellspacing="0" cellpadding="0" class="borderRoundedClearColor">
      
       <tr height="30">
         <td class="qou"><div align="right"><%--a href="#" class="qou"--%>&nbsp;<%= session.getAttribute( "selectedStudId" ) %><%--/a--%></div></td>
         <td class="centerpage"><div align="right">رقم الطالب:</div></td>
         <td class="qou"><div align="right"><%--a href="#" class="qou"--%>&nbsp;<%= session.getAttribute( "selectedStudName" ) %><%--/a--%></div></td>
         <td class="centerpage"><div align="right">اسم الطالب:</div></td>
       </tr>
      </table>  
<table align="left" width="99%" cellpadding="0" cellspacing="0" border="0">
            <tr>
              <td width="99%"  valign="top">


				<br>
<!-- here -->
           <form name = "form1" action="../../deptMstr/showSelectedTermSummary.do?.rv=<%=Randomizer.shortRandom()%>" method="post">
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
                       <qou:TermListNavigator pageType="deptMstr/showSelectedTermSummary.do"/>

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
    if(request.getParameter("term") != null)
      term = request.getParameter("term");
    else
      term = (String) request.getAttribute("term");
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
                                <TD class="borderTopLeftBigColor"  width="6%"> <DIV align=center>تفاصيل</DIV></TD>
                                <TD class="borderTopLeftBigColor" width="10%"><DIV align=center>العلامة</DIV></TD>
                                <TD class="tabheader" width="10%" height=19 ><DIV align=center>الحالة</DIV></TD>
                                <TD class="tabheader" width="10%"><DIV align=center>عدد الساعات</DIV></TD>
                                <TD class="tabheader" width="35%"><DIV align=center>اسم المقرر</DIV></TD>
                                <TD align="center" class="borderTopRightBigColor" width="15%">رقم المقرر</TD>
                              </TR>

                      <logic:present name="termCourseSummary">
                       <% int i = 0; %>
                       <logic:iterate id="TermCourse" name="termCourseSummary" >
                        <%  if (i%2 == 0) { %>
                               <tr  class="tableRowClearColor"  onMouseOver="this.className='highlight'" onMouseOut="this.className='tableRowClearColor'">

                          <%}else {%>
                                <tr class="tableRowLightColor"  onMouseOver="this.className='highlight'" onMouseOut="this.className='tableRowLightColor'">
                          <%}%>
                          <%--<td><div align="center" class="qou"><a  href="../../student/viewUserMessages.do?crsNo=<bean:write name="TermCourse" property="crsNo" />&crsClass=<bean:write name="TermCourse" property="crsClass" />&termNo=<bean:write name="TermCourse" property="termNo" />&.rv=<%=Randomizer.shortRandom()%>" title="عرض رسائل <bean:write name="TermCourse" property="crsAName" />"><img src="/pages/resources/images/msg.png" border="0" height="25" width="25" alt="عرض رسائل <bean:write name="TermCourse" property="crsAName" />"  /></a></div></td>--%>
                          
                           <td>
                            <div align="center" class="qou">
                                   <a href="javascript:openDetailsWindow(' + <bean:write name="TermCourse" property="crsNo" /> + ','+ 
                                      <bean:write name="TermCourse" property="first" /> + ','+ 
                                      <bean:write name="TermCourse" property="second" /> + ','+ 
                                      <bean:write name="TermCourse" property="mid" /> + ','+ 
                                       <bean:write name="TermCourse" property="practical" /> + ','+ 
                                        <bean:write name="TermCourse" property="finalm" /> + ','+ 
                                      ')" > 
                                      ....  
                                   </a>
                            </div>
                            
                           
                          </td>
                          
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

				<div align="right">
                  <span class="centerpage">:المقررات الفصلية </span><Br>

                </div>
                <table width="99%" cellspacing="0" cellpadding="0" class="borderRoundedClearColor" >
                    <tr>
                      <td><table width="99%" border="0" cellspacing="0" cellpadding="0">
                              <TR>
                                
                                <TD class="borderTopLeftBigColor"  width="6%"> <DIV align=center>تفاصيل</DIV></TD>
                                <TD class="borderTopLeftBigColor"  width="6%"> <DIV align=center>العلامة</DIV></TD>
                                <TD class="tabheader"  height=19 width="10%" > <DIV align=center>الحالة</DIV></TD>
                                <TD class="tabheader"  width="10%"> <DIV align=center>عدد الساعات</DIV></TD>
                                <TD class="tabheader"  width="34%"> <DIV align=center>اسم المقرر</DIV></TD>
                                <TD class="borderTopRightBigColor"  width="10%"> <P align=center class=subtitle>رقم
                                    المقرر/م</P></TD>
                              </TR>

                      <logic:present name="termCourseSummary">
                       <% int i = 0; %>
                       <logic:iterate id="TermCourse" name="termCourseSummary" >

                            <%  if (i%2 == 0) { %>
                               <tr  class="tableRowClearColor"  onMouseOver="this.className='highlight'" onMouseOut="this.className='tableRowClearColor'">

                          <%}else {%>
                                <tr class="tableRowLightColor"  onMouseOver="this.className='highlight'" onMouseOut="this.className='tableRowLightColor'">
                          <%}%>
                                            
                           <td>
                            <div align="center" class="qou">
                                   <a href="javascript:openDetailsWindow(' + <bean:write name="TermCourse" property="crsNo" /> + ','+ 
                                      <bean:write name="TermCourse" property="first" /> + ','+ 
                                      <bean:write name="TermCourse" property="second" /> + ','+ 
                                      <bean:write name="TermCourse" property="mid" /> + ','+ 
                                       <bean:write name="TermCourse" property="practical" /> + ','+ 
                                        <bean:write name="TermCourse" property="finalm" /> + ','+ 
                                      ')" > 
                                      ....  
                                   </a>
                            </div>
                            
                           
                          </td>
                           <td><div align="center" class="qou"><bean:write name="TermCourse" property="mark" /></div></td>
                          <td height="14"><div align="center" class="qou"><bean:write name="TermCourse" property="regStatusAName" /></div></td>
                          <td><div align="center" class="qou"><bean:write name="TermCourse" property="crHrs" /></div></td>
                          <td>
                            <div align="right" class="qou">
                               <bean:write name="TermCourse" property="crsAName" />
                            </div>
                        
                 
                              </td>
                              
                              <td>
                            <div align="right" class="qou">
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
<%--End Of Show normal terms--%>
</logic:notPresent>
<p align="right" class="centerpage" dir="rtl">بيانات الفصل:</p>
<!-- to view term details -->

                <logic:present name="selectedTermSummary">
                <logic:iterate id="selectedTermSummary" name="selectedTermSummary" >

                <logic:notPresent name="Error">
                <table width="100%" height="50" cellpadding="0" cellspacing="0" class="borderRoundedClearColor" >
                    <tr>
                      <td height="50" ><table border="0"  width="100%" height="50"   cellpadding="0" cellspacing="0">
                        <tr>
                          <td class="borderTopLeftBigColor" width="13%" height="18"><div  class="tabheader" align="center">لوحة
                              الشرف</div></td>
                          <td class="tabheader" width="10%"><div align="center">المعدل</div></td>
                          <td class="tabheader" width="9%"><div align="center">النقاط</div></td>
                          <td class="tabheader" width="12%"><div align="center">ساعة منسحب</div></td>
                          <td class="tabheader" width="11%"><div align="center">ساعة راسب</div></td>
                          <td class="tabheader" width="11%"><div align="center">ساعة محتسبة</div></td>
                          <td class="tabheader" width="11%"><div align="center">ساعة مجتازة</div></td>
                          <td class="borderTopRightBigColor" width="23%" colspan="2" ><div align="center">ساعة مسجلة</div></td>

                        </tr>
                        <tr class="qou">
                          <td height="15"><div align="center"><bean:write name="selectedTermSummary" property="termHonorStatus" /></div></td>
                          <td><div align="center"><bean:write name="selectedTermSummary" property="termAvg" /></div></td>
                          <td><div align="center"><bean:write name="selectedTermSummary" property="termPoints" /></div></td>
                          <td><div align="center"><bean:write name="selectedTermSummary" property="termHrsW" /></div></td>
                          <td><div align="center"><bean:write name="selectedTermSummary" property="termHrsFailed" /></div></td>
                          <td><div align="center">NA</div></td>
                          <td><div align="center"><bean:write name="selectedTermSummary" property="termHrsPassed" /></div></td>
                          <td><div align="center"><bean:write name="selectedTermSummary" property="termHrs" /></div></td>
                          <td><div align="right" class="centerpage" >&nbsp;&nbsp;فصلي</div></td>
                        </tr>
                        <tr>
                          <td class="borderBottomLeftLightColor"><div align="center" class="qou"></div></td>
                          <td class="tableRowLightColor"><div align="center" class="qou"><bean:write name="selectedTermSummary" property="cumAvg" /></div></td>
                          <td class="tableRowLightColor"><div align="center" class="qou"><bean:write name="selectedTermSummary" property="cumPoints" /></div></td>
                          <td class="tableRowLightColor"><div align="center" class="qou">NA</div></td>
                          <td class="tableRowLightColor"><div align="center" class="qou">NA</div></td>
                          <td class="tableRowLightColor"><div align="center" class="qou"><bean:write name="selectedTermSummary" property="cumHrsTrans" /></div></td>
                          <td class="tableRowLightColor"><div align="center" class="qou"><bean:write name="selectedTermSummary" property="cumHrsPassed" /></div></td>
                          <td class="tableRowLightColor"><div align="center" class="qou"><bean:write name="selectedTermSummary" property="cumHrs" /></div></td>
                          <td class="borderBottomRightLightColor"><div align="right" class="centerpage"  >&nbsp;&nbsp;تراكمي</div></td>
                        </tr>
                      </table></td>
                    </tr>
                  </table>

<p align="right" class="centerpage" dir="rtl">حالة الطالب الفصلية:</p>
		<table width="100%" cellspacing="0" cellpadding="0" class="borderRoundedClearColor" >
                    <tr><td>
                <table width="100%" border="0" cellspacing="0" cellpadding="0">

                        <tr>
                          <td class="borderTopLeftLightColor" width="26%"><div align="right" class="qou"><bean:write name="selectedTermSummary" property="levelNo" /></div></td>
                          <td class="tableRowLightColor" width="17%"><div align="right" class="centerpage">المستوى:</div></td>
                          <td class="tableRowLightColor" width="42%">
                           <div align="right" class="qou">
                            <logic:notEmpty name="selectedTermSummary" property="studentStatus">
                              <bean:write name="selectedTermSummary" property="studentStatus.statusAName" />
                            </logic:notEmpty>
                           </div>
                          </td>
                          <td class="borderTopRightLightColor" width="15%"><div align="right" class="centerpage">&nbsp;&nbsp;الطالب:</div></td>
                        </tr>
                        <tr class="qou">
                          <td><div align="right"><bean:write name="selectedTermSummary" property="isGraduate" /></div></td>
                          <td><div align="right" class="centerpage">خريج:</div></td>
                          <td>
                            <div align="right">
                             <logic:notEmpty name="selectedTermSummary" property="warning">
                              <bean:write name="selectedTermSummary" property="warning.warnAName" />
                             </logic:notEmpty>
                            </div>
                          </td>
                          <td><div align="right" class="centerpage" >&nbsp;&nbsp;انذار:</div></td>
                        </tr>
                      </table>
			</td></tr></table>
           </logic:notPresent>                       

<!-- End of view term details -->
                      </logic:iterate>
                     </logic:present>

                     <logic:notPresent name="selectedTermSummary">
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