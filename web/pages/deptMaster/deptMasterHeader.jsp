<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/WEB-INF/lib/qou-Taglib.tld" prefix="qou" %>
<%@ taglib uri="/WEB-INF/lib/struts-tiles.tld" prefix="tiles" %>
<br />
<table width="99%" cellspacing="0" cellpadding="0" >
  <tr>
    <td>
    <logic:present name="deptMaster">
     <logic:iterate id="deptMaster" name="deptMaster" >
     <table width="100%" border="0" cellspacing="0" cellpadding="0" class="borderRoundedClearColor">
       <tr height="30">
         <td class="borderTopLeftLightColor" width="32%" ><div align="right">&nbsp;<bean:write name="deptMaster" property="empNo" /></div></td>
         <td class="tableRowLightColor" width="17%"><div align="right" class="centerpage">الرقم:</div></td>
         <td class="tableRowLightColor" width="32%"  ><div align="right">&nbsp;<bean:write name="deptMaster" property="empAName" /></div></td>
         <td class="borderTopRightLightColor" width="19%"><div align="right" class="centerpage">&nbsp;&nbsp;<bean:message key="studentHeader.name"/>:</div></td>
       </tr>
       <tr height="30">
         <td class="qou"><div align="right"><%--a href="#" class="qou"--%>&nbsp;<bean:write name="deptMaster" property="accRankDesc" /><%--/a--%></div></td>
         <td class="centerpage"><div align="right">الرتبة الاكاديمية:</div></td>
         <td class="qou"><div align="right"><%--a href="#" class="qou"--%>&nbsp;<bean:write name="deptMaster" property="deptDesc" /><%--/a--%></div></td>
         <td class="centerpage"><div align="right">&nbsp;&nbsp;الدائرة:</div></td>
       </tr>

     </table>
     </logic:iterate>
    </logic:present>
    <logic:notPresent name="deptMaster">
     <table width="100%" border="0" cellspacing="0" cellpadding="0">
       <tr class="tableRowLightColor" height="30">
         <td width="99%"><div align="center">&nbsp;No Avaliable Data</div></td>
        </tr>
     </table>
    </logic:notPresent>
     </td>
  </tr>
</table>