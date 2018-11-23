 <%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/lib/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/lib/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/lib/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/lib/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://psgateway.org" prefix="pagination" %>
<%@ taglib uri="/WEB-INF/lib/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/lib/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/lib/qou-Taglib.tld"   prefix="qou" %>
 
<logic:present name="pdfHeaderInfo" >
<table  align="center" width="966" dir="ltr" height="102" border="0" cellspacing="0" cellpadding="0" >
  <tr>
    <td align="center" valign="middle"  > <br/>
    <table width="95%" border="0" cellspacing="3" cellpadding="3" bgcolor="#E7E2E2" class="pdfBorderBlack" >
         <tr>
         <td width="15%" align="center" class="qou">&nbsp;
          <logic:present name="viewCurrentDate">
             : التاريخ
             <br/>
             <qou:CurrentDateViewer/>
          </logic:present>
         </td>
         <td width="70%" align="center" class="pdfBorderBlack" bgcolor="#DDDBDB">
           <table width="95%" border="0" cellspacing="0" cellpadding="0"   >
             <tr><td colspan="3" align="center" class="pdfTitle"  > جامعة القدس المفتوحة </td></tr>
             <tr><td colspan="3" align="center" class="pdfTitle"  >&nbsp;<logic:notEqual name="pdfHeaderInfo" property="title" value=""> <bean:write name="pdfHeaderInfo" property="title"/> </logic:notEqual></td></tr>
             <tr>
               <td width="15%" align="center" class="pdfSubTitle" >&nbsp;<logic:notEqual name="pdfHeaderInfo" property="lefttSubTitle"  value="">  <bean:write name="pdfHeaderInfo" property="lefttSubTitle" />  </logic:notEqual></td>
               <td width="15%" align="center" class="pdfSubTitle" >&nbsp;<logic:notEqual name="pdfHeaderInfo" property="centerSubTitle" value="">  <bean:write name="pdfHeaderInfo" property="centerSubTitle"/>  </logic:notEqual></td>
               <td width="15%" align="center" class="pdfSubTitle" >&nbsp;<logic:notEqual name="pdfHeaderInfo" property="rightSubTitle"  value="">  <bean:write name="pdfHeaderInfo" property="rightSubTitle" />  </logic:notEqual></td>
             </tr>
          </table>

         </td>
         <td width="15%" align="center"  ><img src="/pages/resources/images/qouLogo.png" border="0" width="102" height="102" alt="شعار الجامعة" /></td>
         </tr>
    </table>
   </td>
 </tr>
 <tr><td align="center" >
      <table width="95%"  border="0" ><tr><td>
      &nbsp;&nbsp;
      <div align="left"><span class=centerpage>
      &nbsp;&nbsp;
      <a class=qou href="javascript:window.close()">
      <img src="/pages/resources/images/close_pdf.gif" border=0 width="15" height="15" alt="إغلاق">
      </a>
      &nbsp;&nbsp;
      <a class=qou href="javascript:window.print()">
      <img border=0 height=12 src="/pages/resources/images/printer.gif" width=14 alt="طباعة"></a>
      </span></div></td></tr></table>
 </td></tr>
</table>
</logic:present>
<logic:notPresent name="pdfHeaderInfo"> <div class="pdfBorderBlack" align="center"><font color="red" > fill pdfHeaderInfo </font></div> </logic:notPresent>

