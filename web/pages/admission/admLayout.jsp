<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="http://psgateway.org" prefix="pagination" %>
<%@ taglib uri="/WEB-INF/lib/struts-tiles.tld" prefix="tiles" %>

<html:base/>

<HTML ><HEAD><TITLE><tiles:getAsString name="title"/></TITLE>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<META content="MSHTML 6.00.2600.0" name=GENERATOR>
<link href="/pages/resources/css/dr_portal_style.css" rel="stylesheet" type="text/css">

</HEAD>
 <BODY topmargin="0" bgcolor="#fee6cb">
<TABLE cellSpacing=0 cellPadding=0 width="966" align=center border=0>
   <TR>
    <td>
         <tiles:get name="header"/>
    </td>
   </TR>
    <TR align="right" valign="top">
     <TD width="966"  bgcolor="#FFFFFF">
        <div align="center" dir="rtl" >
            <tiles:get name="body"/>
       </div>
      </TD>
     </TR>
   <tr>
       <td width="966" height="50">
         <tiles:get name="footer"/>
       </td>

    </tr>

  </TABLE>
</BODY></HTML>