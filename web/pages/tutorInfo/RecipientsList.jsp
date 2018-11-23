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

<html>
    
        
        <HEAD><TITLE><tiles:getAsString name="title"/></TITLE>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<META content="MSHTML 6.00.2600.0" name=GENERATOR>
<link href="/pages/resources/css/dr_portal_style.css" rel="stylesheet" type="text/css">
</HEAD>
    

<TABLE width="100%"  border=0 align=center cellPadding=0 cellSpacing=0 class="qou" >
  <TBODY>
     <TR align="right" valign="top">
      <TD width="64%" >
        <div align="center">
          <table width="100%"  border="0">

            <tr>
              <td width="98%"  valign="top">
              <table width="100%">
               
              <tr>
              <td width="100%" valign="top">
                 
		   <table class="borderRoundedClearColor" align="center" cellpadding="0" cellspacing="0" width="99%">
               		  <tbody><tr>
                   <td height="40" align="center" valign="top">
                    <table cellpadding="0" cellspacing="0" width="100%">
                      <tbody>
                      <logic:present name="messages">
                       <tr valign="top" >                  
                        <td class="tabheader" width="35%"><div align="center">قائمة المرسل اليهم</div></td>
                       </tr> 
                      <% int rowNumber=0;%> 
                       <logic:iterate id="messages" name="messages"  >
                     
					      <%  if (rowNumber%2 == 0) { %>
                               <tr  class="tableRowClearColor"  onMouseOver="this.className='highlight'" onMouseOut="this.className='tableRowClearColor'">

                          <%}else {%>
                                <tr class="tableRowLightColor"  onMouseOver="this.className='highlight'" onMouseOut="this.className='tableRowLightColor'">
                          <%}%>

 			   
                         <td class="qou" ><div align="center"><bean:write name="messages" property="recipientName"/> </div></td>
                          </tr>
                   <% rowNumber++; %>
                   </logic:iterate>
                   <tr><td colspan="7">&nbsp;</td> </tr>
                   </logic:present>
                      <logic:notPresent name="messages">
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
          
          </table>
        </div>
      </td>
    </TR>
</TABLE>
</html>