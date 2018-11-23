<%@ page import="ps.edu.diyar.common.tools.Randomizer" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/lib/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/lib/qou-Taglib.tld" prefix="qou" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<table align="center" width="95%" border="0" cellPadding=0 cellSpacing=0>
          <tr>
           <td width="99%" valign="top">
<br />
<p align="right" class="centerpage" dir="rtl">قائمة اعضاء هيئة التدريس</p>
 <TABLE cellPadding="0" cellSpacing="0"  width="100%">
      <tr>
      <td>

<table align="center" width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td align="center" >
                     <logic:present name="tutDptList">
                     <% int i = 0; %>
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="borderRoundedClearColor" bgcolor="#f38e00">
                          <tr class="tabheader">
                            <td  width="10%" ><div align="right">الشعب</div></td>
                            <td  width="65%" ><div align="right">الاسم</div></td>
                            <td  width="15%" ><div align="right">الرقم</div></td>
                            <td  width="5%" ><div align="right">&nbsp;</div></td>
                          </tr>
                     <logic:iterate id="tutDptList" name="tutDptList" >
                         <%  if (i%2 == 0) { %>
                               <tr  class="tableRowClearColor"  onMouseOver="this.className='highlight'" onMouseOut="this.className='tableRowClearColor'">

                          <%}else {%>
                                <tr class="tableRowLightColor"  onMouseOver="this.className='highlight'" onMouseOut="this.className='tableRowLightColor'">
                          <%}%>
                            <td class="qou"><div align="right"><a href="/colgMstr/tutorsColgCrsList.do?tutNo=<bean:write name="tutDptList" property="value"/>&.rv=<%= Randomizer.shortRandom()%>">عرض</a>  </div></td>
                            <td class="qou"><div align="right"><bean:write name="tutDptList" property="label"/></div></td>
                            <td class="qou"><div align="right"><bean:write name="tutDptList" property="value"/> </div></td>
                            <td class="qou"><div align="right">&nbsp;</div></td>
                            </tr>
                      <% i++; %>
                     </logic:iterate>
                       <tr><td colspan="7">&nbsp;</td></tr>
                     </table>
                     </logic:present>
                      <logic:notPresent name="tutDptList">
                      <table width="100%" border="0" cellspacing="0" cellpadding="0" class="border" bordercolor="#999999">
                        <tr bgcolor="#f8eee0" class="centerpage">
                          <td width="99%"><div align="center">&nbsp;  No Avaliable Data </div></td>
                         </tr>
                      </table>
                     </logic:notPresent>
                          <br/>
                        <input type="button" value="  عودة  " class="enter" onclick="javaScript:parent.location = '/colgMstr/colgList.do?.rv=<%= Randomizer.shortRandom()%>'">&nbsp;

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
