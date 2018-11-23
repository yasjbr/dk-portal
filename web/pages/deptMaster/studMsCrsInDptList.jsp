<%@ page import="ps.edu.diyar.common.tools.Randomizer" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/lib/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/lib/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/lib/qou-Taglib.tld" prefix="qou" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%
  response.setHeader("pragma", "no-cache");
  response.setHeader("Cache-Control", "no-cache");
  response.setHeader("Expires", "0");
%>

<table width="99%" height="412" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td width="99%"  valign="top">

 <logic:present name="studViwedInfo">
     <logic:iterate id="studViwedInfo" name="studViwedInfo" >
         	<div align="right">
                 <br/>
                  <span class="centerpage">:معلومات الطالب </span><Br>
                </div>
     <table width="100%" border="0" cellspacing="0" cellpadding="0" class="borderRoundedClearColor">
       <tr height="30">
         <td class="borderTopLeftLightColor" width="32%" ><div align="right">&nbsp;<bean:write name="studViwedInfo" property="studentId" /></div></td>
         <td class="tableRowLightColor" width="17%"><div align="right" class="centerpage"><bean:message key="studentHeader.id"/>:</div></td>
         <td class="tableRowLightColor" width="32%"  ><div align="right">&nbsp;<bean:write name="studViwedInfo" property="studentName" /></div></td>
         <td class="borderTopRightLightColor" width="19%"><div align="right" class="centerpage">&nbsp;&nbsp;<bean:message key="studentHeader.name"/>:</div></td>
       </tr>
       <tr height="30">
         <td class="qou"><div align="right"><%--a href="#" class="qou"--%>&nbsp;<bean:write name="studViwedInfo" property="specialization" /><%--/a--%></div></td>
         <td class="centerpage"><div align="right"><bean:message key="studentHeader.specialization"/>:</div></td>
         <td class="qou"><div align="right"><%--a href="#" class="qou"--%>&nbsp;<bean:write name="studViwedInfo" property="programName" /><%--/a--%></div></td>
         <td class="centerpage"><div align="right">&nbsp;&nbsp;<bean:message key="studentHeader.program"/>:</div></td>
       </tr>
       <tr height="30" class="tableRowLightColor">
         <td colspan="2" class="borderBottomLeftLightColor">&nbsp;</td>
         <td class="qou" ><div align="right">&nbsp;<bean:write name="studViwedInfo" property="majorSheet" /></div></td>
         <td class="borderBottomRightLightColor"><div align="right" class="centerpage">&nbsp;&nbsp;<bean:message key="studentHeader.majorSheet"/>:</div></td>
       </tr>
     </table>
     </logic:iterate>
    </logic:present>


				<br>


<logic:present name="studMsCrs">
<%-- Show current term marks (active term)--%>
				<div align="right">
                  <span class="centerpage">:الخطة الاسترشادية</span><Br>
                </div>
                <table width="100%" cellspacing="0" cellpadding="0" class="borderRoundedClearColor" >
                    <tr>
                      <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
                              <TR >
                                <TD class="borderTopLeftBigColor" width="10%"   ><DIV align=center>الحالة</DIV>
                                <TD class="tabheader" width="5%"><DIV align=center>العلامة</DIV></TD>
                                <TD class="tabheader" width="5%"><DIV align=center>عدد الساعات</DIV></TD>
                                <TD class="tabheader"  width="25%"> <DIV align=right>نوع المقرر</DIV></TD>
                                <TD class="tabheader" width="25%"><DIV align=right>اسم المقرر</DIV></TD>
                                <TD class="tabheader" width="10%"><DIV align=right>رقم المقرر</DIV></TD>
                                <TD class="borderTopRightBigColor" width="10%"><DIV align=center>الفصل </DIV></TD>
                              </TR>


                       <logic:iterate id="TermCourse" name="studMsCrs" >


                           <logic:equal name="TermCourse" property="crsStatus" value="S">
                           <tr class="tableRowLightColor" onMouseOver="this.className='highlight'" onMouseOut="this.className='tableRowLightColor'"  >
                           </logic:equal>
                           <logic:equal name="TermCourse" property="crsStatus" value="R">
                           <tr class="tableRowFailedCourse" onMouseOver="this.className='highlight'" onMouseOut="this.className='tableRowFailedCourse'"  >
                           </logic:equal>
                           <logic:notEqual name="TermCourse" property="crsStatus" value="S">
                           <logic:notEqual name="TermCourse" property="crsStatus" value="R">
                           <tr class="tableRowClearColor" onMouseOver="this.className='highlight'" onMouseOut="this.className='tableRowClearColor'"  >
                           </logic:notEqual>
                           </logic:notEqual>


                           <td align="center" class="borderBottom"> &nbsp; <bean:write name="TermCourse" property="crsStatusAName" /> </td>
                           <td align="center" class="borderBottom"> &nbsp;<bean:write name="TermCourse" property="crsMark" /> </td>
                           <td align="center" class="borderBottom"> &nbsp;<bean:write name="TermCourse" property="crsHrs" /> </td>
                           <td align="right" class="borderBottom"> &nbsp;<bean:write name="TermCourse" property="mscrsTypeName" /> </td>
                           <td align="right" class="borderBottom"> &nbsp;<bean:write name="TermCourse" property="crsName" /> </td>
                           <td align="right" class="borderBottom"> &nbsp;<bean:write name="TermCourse" property="crsNo" /> </td>
                           <td align="center" class="borderBottom"> &nbsp;<bean:write name="TermCourse" property="termNo" /> </td>
                        </tr>
                       </logic:iterate>
                       <tr><td colspan="6" >&nbsp;</td></tr>



                      </table></td>
                    </tr>
                  </table>
                      </logic:present>


<logic:notPresent name="studMsCrs">
<table align="left" width="100%" height="35" cellpadding="0" cellspacing="0" class="borderRoundedClearColor" >
                    <tr>
                      <td valign="middle" width="100%" align="center" class="centerpage">الخطة الاسترشادية غير  متوفرة</td>
    </tr>
    </table><br /><br />
</logic:notPresent>
<p align="right" class="centerpage" dir="rtl">بيانات الفصل الحالي:</p>
                  <logic:present name="selectedTermSummary">
                <logic:iterate id="selectedTermSummary" name="selectedTermSummary" >
                <table width="100%" height="50" cellpadding="0" cellspacing="0" class="borderRoundedClearColor" >
                    <tr>
                      <td height="50" ><table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
                        <tr>
                          <td class="borderTopLeftBigColor" width="9%" height="18"><div  class="tabheader" align="center">لوحة
                              الشرف</div></td>
                          <td class="tabheader" width="12%"><div align="center">المعدل</div></td>
                          <td class="tabheader" width="11%"><div align="center">النقاط</div></td>
                          <td class="tabheader" width="12%"><div align="center">ساعة منسحب</div></td>
                          <td class="tabheader" width="11%"><div align="center">ساعة راسب</div></td>
                          <td class="tabheader" width="11%"><div align="center">ساعة محتسبة</div></td>
                          <td class="tabheader" width="11%"><div align="center">ساعة مجتازة</div></td>
                          <td class="borderTopRightBigColor" width="23%" colspan="2" ><div align="left">ساعة مسجلة</div></td>

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
				  <Br>

                      </logic:iterate>

                     </logic:present>
                     <logic:notPresent name="selectedTermSummary">
                      <table width="100%" border="1" cellspacing="0" cellpadding="0" class="border" bordercolor="#4A6D8C">
                        <tr class="tableRowLightColor">
                          <td width="100%"><div align="center" class="centerpage">&nbsp;No Avaliable Data</div></td>
                         </tr>
                      </table>
                          <Br>
                     </logic:notPresent>

                     

             </td>
            </tr>
    <tr><td>
        <div align="center"  class="centerpage">
                      <input name="Sub" type="button" value="الانتقال لتسجيل الطالب"  class="enter" onClick="javaScript:parent.location = '/deptMstr/loadStudentRegCrsInfo.do?.rv=<%=Randomizer.shortRandom()%>&studId=<%=request.getParameter("studId")%>'">&nbsp;&nbsp;
                     </div>

        <br/>
    </td></tr>
          </table>