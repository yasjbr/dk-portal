<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/lib/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/lib/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/lib/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://psgateway.org" prefix="pagination" %>
<%@ taglib uri="/WEB-INF/lib/struts-tiles.tld" prefix="tiles" %>
<%
  response.setHeader("pragma", "no-cache");
  response.setHeader("Cache-Control", "no-cache");
  response.setHeader("Expires", "0");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html:base/> 
<HTML ><HEAD><TITLE><tiles:getAsString name="title"/></TITLE>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<META content="MSHTML 6.00.2600.0" name=GENERATOR>
<link href="/pages/resources/css/dr_portal_style.css" rel="stylesheet" type="text/css">
</HEAD>
<div align="center">
<BODY bgcolor="#fee6cb"  topmargin="0" >
<TABLE cellSpacing=0 cellPadding=0 width="966" align=center border=0 class="qou" dir="ltr" >
  <TBODY   bgcolor="#FFFFFF" >
    <TR>
      <TD colSpan=3>
       <tiles:get name="header"/>
      </TD>
    </TR>  
    <TR align="center" valign="top">
      <TD width="806" >
        <div align="center">
        <table width="806" cellspacing="3" cellpadding="0" >
          <tr>
             <td><div align="center">
              <tiles:get name="subHeader"/>
             </div></td>
          </tr>
       </table>
        <tiles:get name="body"/>
       </div>
      </TD>
      <TD width="160" valign="top" height="250">
        <tiles:get name="rightMenuBar"/>
        <br /><br />
      </TD>
    </TR>
    <tr>
     <td colspan="3" >
       <div align="center" class="footer" >
         <tiles:get name="footer"/>
       </div>
     </td>

    </tr>
  </TABLE>
</BODY></div></HTML>