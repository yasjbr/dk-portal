<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/lib/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/lib/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/lib/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://psgateway.org" prefix="pagination" %>
<%@ taglib uri="/WEB-INF/lib/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/lib/qou-Taglib.tld" prefix="qou" %>
 
<%@ page import="java.util.Iterator" %>
<tiles:importAttribute />
<table  align="center" width="900" dir="rtl" height="102" border="0" cellspacing="0" cellpadding="0" bgcolor="#6e862e">
 <tr>
   <td align="center" valign="middle" width="115" rowspan="2" height="102"><a href="/indexPage.do" target="_self"><img src="/pages/resources/images/qouLogo.png" border="0" width="102" height="102" alt="شعار الجامعة" /></a></td>
   <td width="785" height="71" align="right" dir="rtl">
   <table width="785" height="71" border="0" cellspacing="0" cellpadding="0">
     <tr>
       <td align="right" width="265" height="71">
       <table align="right" height="71" width="265" border="0" cellspacing="0" cellpadding="0">
         <tr>
           <td width="258" align="center" valign="bottom"><img src="/pages/resources/images/arabicPortalTitle.png" /></td>
         </tr>
       </table>
       </td>
       <td align="right" width="533" height="71">
       <table width="527" height="71" border="0" align="left" cellspacing="0" cellpadding="0">
             <tr>
               <td align="center" valign="middle" dir="ltr" width="262" height="71"><img src="/pages/resources/images/alBawwaba.png" /></td>
    <td width="265" align="left">
    <table align="left" height="71" width="265" border="0" cellspacing="0" cellpadding="0">
         <tr>
           <td width="258" align="center" valign="bottom"><img src="/pages/resources/images/engPortalTitle.png" /></td>
         </tr>
       </table>
               </td>
             </tr>
           </table>

       </td>
     </tr>
   </table>

   </td>
 </tr>
   <tr>
   <td align="left" width="785" height="31">
   <table align="left" width="785" height="31" border="0" cellspacing="0" cellpadding="0">
     <tr>
       <td align="right" height="3" colspan="2" valign="top"><img src="/pages/resources/images/gradienLine.png" width="674" height="3" /></td>
     </tr>
     <tr>
       <td width="685" height="28" align="right" valign="bottom" dir="ltr" class="pTextHeader">
       <table width="100%">
          <tr class="upperMenuBGColor">

   <td height="22" class="subtitle" colspan="2" >
     <div align="center">
       <!--  title of the screen that opend  -->
        <tiles:getAsString name="subtitle"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      </div>
   </td>
 </tr>
       </table>
       </td>
       <td width="100" height="28" align="left" valign="middle" class="pTextHeader">
       <div align="left">
    <qou:CurrentDateViewer/>&nbsp;
       </div>

       </td>
     </tr>
   </table>
   </td>
 </tr>
     <tr>
   <td width="900" colspan="2" valign="top" height="14" background="/pages/resources/images/topBg.png"></td>
 </tr>
   </table>
