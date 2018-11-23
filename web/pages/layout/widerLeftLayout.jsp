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
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html:base/>
<qou:SessionValidator/>
<HTML ><HEAD><TITLE><tiles:getAsString name="title"/></TITLE>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<META content="MSHTML 6.00.2600.0" name=GENERATOR>
<link href="/pages/resources/css/dr_portal_style.css" rel="stylesheet" type="text/css">
<link href="/pages/resources/css/ie6.css" rel="stylesheet" type="text/css"> 

</HEAD>
<div align="center">
<BODY topmargin="0"  bgcolor="#fee6cb">

<TABLE cellSpacing=0 cellPadding=0 width="966" align=center border=0 class="qou" >
  <TBODY   bgcolor="#FFFFFF" >
    <TR>
      <TD colSpan=2 >
       <tiles:get name="header"/>
      </TD>
    </TR>
    <TR align="right" valign="top">
      <TD width="18%" valign="top" >
        <tiles:get name="leftMenuBar"/>
      </TD>
      <TD width="82%" >
        <div align="center">
        <table width="100%" cellspacing="3" cellpadding="0" >
          <tr>
             <td><div align="center">
              <tiles:get name="subHeader"/>
             </div></td>
          </tr>
       </table>
        <tiles:get name="body"/>
       </div>
      </TD>

    </TR>
    <tr>
     <td colspan="2" >
       <div align="center">
         <tiles:get name="footer"/>
       </div>
     </td>
    </tr>
     </TBODY>
  </TABLE>
</BODY></div></HTML>
