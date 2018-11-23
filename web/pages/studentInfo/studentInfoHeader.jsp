<%@ page contentType="text/html; charset=UTF-8" %>
 
<%@ taglib uri="/WEB-INF/lib/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/lib/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/lib/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://psgateway.org" prefix="pagination" %>
<%@ taglib uri="/WEB-INF/lib/struts-tiles.tld" prefix="tiles" %>
<table align="left" style="margin-top:10px" width="99%" cellspacing="0" cellpadding="0" class="borderRoundedClearColor">
  <tr height="30">
       
    <td>
    <logic:present name="studentInfo">
     <logic:iterate id="studentInfo" name="studentInfo" >
     <table width="100%" border="0" cellspacing="0" cellpadding="0">
       <tr height="30">
         <td class="borderTopLeftLightColor" width="32%" ><div align="right">&nbsp;<bean:write name="studentInfo" property="studentId" /></div></td>
         <td class="tableRowLightColor" width="17%"><div align="right" class="centerpage"><bean:message key="studentHeader.id"/>:</div></td>
         <td class="tableRowLightColor" width="32%"  ><div align="right">&nbsp;<bean:write name="studentInfo" property="studentName" /></div></td>
         <td class="borderTopRightLightColor" width="19%"><div align="right" class="centerpage">&nbsp;&nbsp;<bean:message key="studentHeader.name"/>:</div></td>
       </tr>
       <tr height="30"> 
         <td class="qou"><div align="right"><%--a href="#" class="qou"--%>&nbsp;<bean:write name="studentInfo" property="specialization" /><%--/a--%></div></td>
         <td class="centerpage"><div align="right"><bean:message key="studentHeader.specialization"/>:</div></td>
         <td class="qou"><div align="right"><%--a href="#" class="qou"--%>&nbsp;<bean:write name="studentInfo" property="programName" /><%--/a--%></div></td>
         <td class="centerpage"><div align="right">&nbsp;&nbsp;<bean:message key="studentHeader.program"/>:</div></td>
       </tr>
       <tr height="30" class="tableRowLightColor">
         <td colspan="2" class="borderBottomLeftLightColor">&nbsp;</td>
         <td class="qou" ><div align="right">&nbsp;<bean:write name="studentInfo" property="majorSheet" /></div></td>
         <td class="borderBottomRightLightColor"><div align="right" class="centerpage">&nbsp;&nbsp;<bean:message key="studentHeader.majorSheet"/>:</div></td>
       </tr>
        
     </table>
     </logic:iterate>
    </logic:present>
    <logic:notPresent name="studentInfo">
     <table width="100%" border="0" cellspacing="0" cellpadding="0">
       <tr height="30" class="tableRowLightColor">
         <td width="100%"><div align="center">&nbsp;No Avaliable Data</div></td>
        </tr>
     </table>
    </logic:notPresent>
     </td>
  </tr>
</table>