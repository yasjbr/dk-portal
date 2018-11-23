<%@ page import="ps.edu.diyar.common.tools.Randomizer" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/lib/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/lib/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<script>
function deleteMessage(msgId)
{
  if(!msgId)
   {
   alert("الرجاء تحديد الرسالة المراد حذفها ");
   }
   else
   {
     if(confirm("الرجاء تأكيد عملية الحذف"))
     {
         parent.location="/student/deleteMsg.do?msgId="+msgId+"&.rv=<%=Randomizer.shortRandom()%>";

     }
   }
}
function replayMs(msgId,termNo,crsNo,crsClass)
{
      parent.location="/student/createUserMessages.do?msgId="+msgId+"&crsNo="+crsNo+"&crsClass="+crsClass+"&termNo="+termNo+"&.rv=<%=Randomizer.shortRandom()%>";
 }

</script>
<table width="99%"  border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td width="99%" valign="top">
       <table width="100%">
        <tr>
        <td width="100%" valign="top">
         <div align="right"  class="centerpage">عرض الرسائل</div>
         <logic:present name="messages" >
          <logic:iterate id="messages" name="messages"  >
          <table width="100%" border="0" cellpadding="1" cellspacing="0" class="borderRoundedClearColor">
             <tr>
             <td>&nbsp;&nbsp;</td>
             <td align="left" width="50%">
                <logic:equal name="messages" property="hasAttachment" value="Y">
                    <a target="_blank" href="../../downloadMsgAtt.do?id=<bean:write name="messages" property="msgSeed"/><bean:write name="messages" property="comp_id.msgId"/>"><img src="/pages/resources/images/attach.gif" width="12" height="12" border="0" alt="اضغط لتحميل الملف"></a>
                </logic:equal>
                <logic:equal name="messages" property="servirity" value="irgante">
                <img src="/pages/resources/images/flag.gif" width="12" height="12" alt="هام">
                </logic:equal>
              </td>
              <td align="right"  width="50%" class="noprint">

                 <a class=qou href="javascript:replayMs('<bean:write name="messages" property="comp_id.msgId"/>','<bean:write name="messages" property="termNo"/>','<bean:write name="messages" property="crsNo"/>','<bean:write name="messages" property="classNo"/>');">
                <img src="/pages/resources/images/replay1.gif" border=0 width="15" alt="ارسال رد">
                
               </a>
               <a class=qou href="javascript:window.print()">
                <img border=0 src="/pages/resources/images/printer.gif" width=14 alt="طباعة">
               </a>
                <a class=qou href="javascript:deleteMessage(<bean:write name="messages" property="comp_id.msgId"/>)">
                <img src="/pages/resources/images/deleteMessage.gif" border=0  alt="حذف الرسالة">
               </a>
               <%--<a class=qou href="javascript:window.close()">--%>
                <%--<img src="/pages/resources/images/close.gif" border=0 width="15" alt="إغلاق">--%>
               <%--</a>--%>
              </td>
              <td>&nbsp;&nbsp;</td>
             </tr>
             
             
             <tr >
             <td>&nbsp;&nbsp;</td>
              <td width="100%" colspan="2">
               <table width="100%" cellpadding="0"  cellspacing="0" class="borderRoundedClearColor">
               <tr >
                 <td align="left" width="30%" class="borderTopLeftLightColor">&nbsp;&nbsp;<bean:write name="messages" property="extraInfo" /></td>
                 <td class="tableRowLightColor" align="right" width="60%" class="qou">&nbsp;&nbsp;<bean:write name="messages" property="senderName" /></td>
                 <td align="center" width="10%" class="borderTopRightLightColor"><strong>: المرسل </strong></td>
                </tr>
               <tr>
                 <td align="right" width="90%" class="qou" colspan="2"><bean:write name="messages" property="msgTitle" filter="false"/></td>
                 <td align="center" width="10%" class="centerpage">  العنوان :</td>
                </tr>
               </table>
             
              <td>&nbsp;&nbsp;</td>
             </tr>
             <tr>
             <td>&nbsp;&nbsp;</td>
              <td class="qou"  colspan="2"><div align="right"><br>
               <bean:write name="messages" property="msgBody" filter="false"/></div><br>
              </td>
              <td>&nbsp;&nbsp;</td>
             </tr>
             
            </table><br>
            </logic:iterate>
            </logic:present>
          </td>
         </tr>
        </table>
       </td>
      </tr>
  </table>