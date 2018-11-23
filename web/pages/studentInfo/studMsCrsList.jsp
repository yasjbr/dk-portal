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

<table width="99%" height="412" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td width="99%"  valign="top">


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
                           

                           
                           <logic:notPresent name="Error">
                            <td align="center" class="borderBottom"> &nbsp; <bean:write name="TermCourse" property="crsStatusAName" /> </td>
                            <td align="center" class="borderBottom"> &nbsp;<bean:write name="TermCourse" property="crsMark" /> </td>
                           </logic:notPresent>
                           <logic:present name="Error">
                            <td align="center" class="borderBottom"> &nbsp; </td>
                            <td align="center" class="borderBottom"> &nbsp; </td>                               
                           </logic:present>
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
                 <logic:present name="Error">
                    <div align="right"  class="qouRtl"><b><font color="#FF0000">ملاحظه هامة:</font></b>عزيزي الطالب: لا يمكنك استعراض علامات الفصل المختار قبل تسديد رسوم هذا الفصل.</div><br>
                 </logic:present>  
                <logic:notPresent name="Error">
                <logic:present name="selectedTermSummary">
                <logic:iterate id="selectedTermSummary" name="selectedTermSummary" >
                <table width="100%" height="50" cellpadding="0" cellspacing="0" class="borderRoundedClearColor" >
                    <tr>
                      <td height="50" ><table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
                        <tr>
                          <td class="borderTopLeftBigColor" width="13%" height="18"><div  class="tabheader" align="center">لوحة
                              الشرف</div></td>
                          <td class="tabheader" width="10%"><div align="center">المعدل</div></td>
                          <td class="tabheader" width="9%"><div align="center">النقاط</div></td>
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
                     </logic:notPresent>
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
          </table>