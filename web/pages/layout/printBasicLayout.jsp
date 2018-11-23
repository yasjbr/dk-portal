 <%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/lib/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/lib/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/lib/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://psgateway.org" prefix="pagination" %>
<%@ taglib uri="/WEB-INF/lib/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="http://psgateway.org" prefix="pagination" %>
<%@ taglib uri="/WEB-INF/lib/qou-Taglib.tld" prefix="qou" %>
<%@ taglib uri="/WEB-INF/lib/struts-tiles.tld" prefix="tiles" %>
<%
  response.setHeader("pragma", "no-cache");
  response.setHeader("Cache-Control", "no-cache");
  response.setHeader("Expires", "0");
%>
<HTML ><HEAD><TITLE><tiles:getAsString name="title"/></TITLE>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<META content="MSHTML 6.00.2600.0" name=GENERATOR>
<link href="/pages/resources/css/dr_portal_style.css" rel="stylesheet" type="text/css">
</HEAD>
<div align="center">
<BODY topmargin="0"  bgcolor="#fee6cb" >
<TABLE cellSpacing=0 cellPadding=0 width="966" align=center border=0 class="qou" >
  <TBODY bgcolor="#FFFFFF" >
    <TR>
      <TD >
       <tiles:get name="header"/>
      </TD>
    </TR>
    <TR align="right" valign="top">
     <TD width="64%" >
        <div align="center">
        <table width="100%" cellspacing="3" cellpadding="0" >
          <tr>
             <td>
              <tiles:get name="subHeader"/>
             </td>
          </tr>
       </table>
        <tiles:get name="body"/>
       </div>
      </TD>
     </TR>
    <tr>
     <td>
       <div align="center">
         <tiles:get name="footer"/>
       </div>
     </td>
     </tr>
  </TABLE>
</BODY></div></HTML>
