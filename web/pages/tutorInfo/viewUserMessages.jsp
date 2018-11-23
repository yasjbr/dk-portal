<%@ page import="ps.edu.diyar.common.tools.Randomizer" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/lib/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/lib/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/lib/qou-Taglib.tld"  prefix="qou" %>
<%@ taglib uri="/WEB-INF/tld1/pagination.tld"  prefix="pagination" %>
<%@taglib uri="/WEB-INF/lib/struts-logic.tld" prefix="logic" %>

 

<%
  response.setHeader("pragma", "no-cache");
  response.setHeader("Cache-Control", "no-cache");
  response.setHeader("Expires", "0");
%>
<%!
        Long count = new Long("1");
        int messageCount;
%>
<%
//        count = (Long)request.getAttribute("count");
//        messageCount = count.intValue();
%>
<script>
function sendReplay(formNo)
{ // increase the from by 1 because of the fomr of sorting take number 0
     document.forms[++formNo].submit()
}
function checkAll()
{
  var value=document.all.checkAll.checked
   for(var j=0; j <document.forms.length ; j++)
  for(var i=0; i < document.forms[j].elements.length; i++)
  {
    var elementName = new String(document.forms[j].elements[i].name);
    if(elementName.indexOf("del_msg_") != -1)
      {
         document.forms[j].elements[i].checked=value
      }
  }
}

function checkCheckedBox(msgCheckBox)
{
 if(!msgCheckBox.checked)
  document.all.checkAll.checked=false

}

function deleteMessage()
{
  var selection = false;
  document.mainForm.deletedValue.value=""
for(var j=0; j <document.forms.length ; j++)
  for(var i=0; i < document.forms[j].elements.length; i++)
  {
    var elementName = new String(document.forms[j].elements[i].name);
    if(elementName.indexOf("del_msg_") != -1)
      {
        if(document.forms[j].elements[i].checked)
         {
            selection = true;
            document.mainForm.deletedValue.value=document.mainForm.deletedValue.value+ document.forms[j].elements[i].value+","
         }
      }
  }


  if(!selection)
    alert("الرجاء تحديد الرسالة المراد حذفها ");
  else
   {
     if(confirm("الرجاء تأكيد عملية الحذف"))
     {
      document.mainForm.deleteMsg.value="del"
      document.mainForm.submit();
     }
   }
}
function setListSelection(selection, list)
{
  for(var i=0; i < list.options.length; i++)
  {
    if(list.options[i].value == selection)
    {
       list.selectedIndex = i;
       break;
    }
  }
}



</script>
<TABLE width="100%"  border=0 align=center cellPadding=0 cellSpacing=0 class="qou" >
  <TBODY>
     <TR align="right" valign="top">
      <TD width="64%" >
        <div align="center">
          <table width="100%"  border="0">

            <tr>
              <td width="98%"  valign="top">
              <table width="100%">
              <tr><td>
               <logic:present name="crsInfo">
                   <logic:iterate id="crsInfo" name="crsInfo"  >
                       <table width="100%" class="borderRoundedLightColor">
                           <tr>
                               <td align="right"  width="20%" class="qou"><bean:write name="crsInfo" property="crsNo"/></td>
                               <td align="center" width="20%" class="centerpage">رقم المقرر :</td>
                               <td align="right"  width="40%" class="qou"><bean:write name="crsInfo" property="crsAName"/></td>
                               <td align="center" width="20%" class="centerpage">اسم المقرر :</td>
                           </tr>
                       </table>
                   </logic:iterate>
               </logic:present>
              </td></tr>
              <tr>
              <td width="100%" valign="top">
                <table width="100%">
                 <tr>
                  <TD width="60%" class="qou">
                    <pagination:pagination list="<%= messageCount %>" pagesize="10" requestUri="../../tutor/viewUserMessages.do?.rv=<%=Randomizer.shortRandom()%>"/>
                  </td>
                  <TD width="40%" class="qou">
                   &nbsp;
                   </td>
                 </tr>
                </table>
		   <table class="borderRoundedClearColor" align="center" cellpadding="0" cellspacing="0" width="99%">
               		  <tbody><tr>
                   <td height="40" align="center" valign="top">
                    <table cellpadding="0" cellspacing="0" width="100%">
                      <tbody>
                      <logic:present name="msgList">
                       <tr valign="top" >
                        <td class="tabheader" width="10%"><div align="center">الحالة</div></td>
  					    <td class="tabheader" width="29%"><div align="center">المرسل</div></td>
                        <td class="tabheader" width="16%"><div align="center">التاريخ</div></td>
                        <td class="tabheader" width="35%"><div align="center">الموضــــــــــوع</div></td>
                        <td class="borderTopRightBigColor" width="8%" colspan="2" ><div align="left"> <input type="checkbox" name="checkAll" onclick="checkAll()" ></div></td>
                       </tr>
                      <% int rowNumber=0;%>
                       <logic:iterate id="msgList" name="msgList"  >
                       <form action="/tutor/createStudentMessage.do?.rv=<%=Randomizer.shortRandom()%>&rowNumber=<%=rowNumber%>" name="<%=rowNumber%>" method="post" target="_blank">
					      <%  if (rowNumber%2 == 0) { %>
                               <tr  class="tableRowClearColor"  onMouseOver="this.className='highlight'" onMouseOut="this.className='tableRowClearColor'">

                          <%}else {%>
                                <tr class="tableRowLightColor"  onMouseOver="this.className='highlight'" onMouseOut="this.className='tableRowLightColor'">
                          <%}%>

 						 <input type="hidden" name="recieverName" value="<bean:write name="msgList" property="senderId"/>" >
						 <input type="hidden" name="msgId" value="<bean:write name="msgList" property="msgId"/>" >
						 <input type="hidden" name="studentId" value="<bean:write name="msgList" property="senderId" />" >
                         <td class="qou" ><div align="center">
                             <logic:equal    name="msgList" property="viewed" value="F"> <img src="/pages/resources/images/msgUnRead.png" width="35" height="25"  title="رسالة جديدة"  alt="رسالة جديدة"></logic:equal>
                             <logic:notEqual name="msgList" property="viewed" value="F"> <img src="/pages/resources/images/msgRead.png" width="35" height="25"   title="رسالة مقروءة"   alt="رسالة مقروءة"></logic:notEqual>
                         </div></td>
                         <td class="qou" ><div align="center"><bean:write name="msgList" property="senderName"/> </div></td>
                         <td class="qou" height="10" ><div align="center"><bean:write name="msgList" property="timeStamp" format="dd-MM-yyyy"/></div></td>
                         <td class="qou" height="10"><div align="right">
                             <logic:equal name="msgList" property="viewed" value="F">
                             <b>
                             <a href="../../tutor/viewUserMessagesDetails.do?msgId=<bean:write name="msgList" property="msgId"/>&senderId=<bean:write name="msgList" property="senderId"/>&read=<bean:write name="msgList" property="viewed"/>&row=<%=rowNumber%>&mt=<%=request.getParameter("tmt")%>" class="qou"   ><bean:write name="msgList" property="msgTitle" filter="false"/></a>
                             </b>
                             </logic:equal>
                             <logic:notEqual name="msgList" property="viewed" value="F">
                             <a href="../../tutor/viewUserMessagesDetails.do?msgId=<bean:write name="msgList" property="msgId"/>&senderId=<bean:write name="msgList" property="senderId"/>&read=<bean:write name="msgList" property="viewed"/>&.rv=<%=Randomizer.shortRandom()%>" class="qou"   ><bean:write name="msgList" property="msgTitle" filter="false"/></a>
                             </logic:notEqual>
                         </div></td>
                         <td height="10" width="4%"> <input type="checkbox" onclick="checkCheckedBox(this.value)" name="<%="del_msg_"+(rowNumber+1)%>"  value="<bean:write name="msgList" property="msgId"/>"></td>
                         <td height="10"  >
                             <logic:equal name="msgList" property="servirity" value="irgante">
                             <img src="/pages/resources/images/flag.gif" width="12" height="12" alt="هام">
                             </logic:equal>
                         </td>

                     </tr></form>
                   <% rowNumber++; %>
                   </logic:iterate>
                   <tr><td colspan="7">&nbsp;</td> </tr>
                   </logic:present>
                      <logic:notPresent name="msgList">
                          <tr><td align="center" valign="middle"  class="qouRed">
                              <br/>
                                 لاتوجد رسائل
                              <br/><br/>
                          </td> </tr>
                      </logic:notPresent>
                  </tbody></table>
                 </td>
                </tr>
               </tbody></table>
           </table>
         </td>
         </tr>
          <tr valign="top" >
          <td valign="top" align="right">
          <table cellpadding="0" cellspacing="0"  >
           <form action="/tutor/deleteMsg.do?.rv=<%=Randomizer.shortRandom()%>" name="mainForm" method="post">
            <tr valign="top" >
             <td height="20" valign="top"> <div align="right">
                 <input type="hidden" name="deleteMsg">
                 <input type="hidden" name="deletedValue">
                 <input type="hidden" name="crsNo" value="<%= request.getParameter("crsNo")%>">
                 <input type="hidden" name="crsClass" value="<%= request.getParameter("crsClass")%>">
                 <input type="hidden" name="termNo" value="<%= request.getParameter("termNo")%>">
                 <a title="حذف الرسائل" href="javascript:deleteMessage()" class="qou"><img src="/pages/resources/images/delete.gif" border="0"/></a>
                </div>
              </td>
             </tr>
           </form>
          </table>
              <br/>
              <div align="center">
              <input type="button" value="  عودة  " class="enter" onclick="javaScript:parent.location = '/tutor/showMessages.do?.rv=<%=Randomizer.shortRandom()%>'">&nbsp;
              </div>
          </td>
          </tr>
          </table>
        </div>
      </td>
    </TR>
</TABLE>