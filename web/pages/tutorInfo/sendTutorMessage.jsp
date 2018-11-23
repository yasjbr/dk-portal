<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/tld1/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld1/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/tld1/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/lib/struts-html.tld" prefix="html" %>
<%--Added By Ibrahim Assi Date:10-8-2011--%>
<script  src="/pages/resources/ckeditor/ckeditor.js" type="text/javascript"></script>
<%-- End Added By Ibrahim Assi Date:10-8-2011--%>
 <script language="javascript">
/* move element by element */
 function move( col1, col2 ,action)
 {
   var count=col1.length;

   if(col1.length > 0 && col1.selectedIndex!=-1)
   {
     for(var i=0;i<count;)
     {
       if(col1.options[i].selected)
       {
         toMove = col1.options[i];
         opt = new Option( toMove.text, toMove.value, false, false );
         col1.options[i] = null;
         col2.options[col2.length] = opt;
         count--;
       }
       else
       {
          i++
       }
     }
   }
   return true;
 }
/* move all element in one click to sec2d list*/
function moveAll( col1, col2 , listName )
{
  var count=col1.length;

  for(var i=0;i<count;i++)
  {
     toMove = col1.options[i];
     opt = new Option(toMove.text,toMove.value,false,false);
     col2.options[col2.length] = opt;
  }
  return true;
}

/* empty list*/
function empty(col1)
{
  var L=col1.length
  for(var i=L;i>=0;i--)
  {
   col1.options[i] = null;
  }
  return true;
}

/* to remove the element after trans it to the secd list*/
function remove( col1)
{
  col1.options[ col1.selectedIndex ] = null;
  return true;
}

function setAllListSelected(form)
{
    var existUsers = "";
    var selectedUsers = "";
    for (var i = 0; i < form.recieverStudent.length; i++)
    {
           form.recieverStudent.options[i].selected=true
           selectedUsers = selectedUsers + form.recieverStudent.options[i].value  +"_" + form.recieverStudent.options[i].text +";";
    }

    for (var i = 0; i < form.classStudent.length; i++)
    {
           form.classStudent.options[i].selected=true
           existUsers = existUsers + form.classStudent.options[i].value  +"_" + form.classStudent.options[i].text +";";
    }
    form.existUsers.value = existUsers;
    form.selectedUsers.value = selectedUsers;
 }

</script>
<%--<script>--%>
<%--   _editor_url = "/pages/resources/htmlarea3";--%>
<%--   _editor_lang = "en";--%>
<%--</script>--%>
<%--<script src="/pages/resources/htmlarea3/htmlarea.js"></script>--%>
<TABLE width="99%"  border=0 cellPadding=0 cellSpacing=0>
  <tr>
    <td valign="top"><div align="right">
       <html:form action="sendTutorMessageAction.do" method="post" enctype="multipart/form-data">
        <div style="display: none;">
        <html:textarea cols="0" rows="0" property="existUsers"></html:textarea>
        <html:textarea cols="0" rows="0" property="selectedUsers"></html:textarea>
        <input type="hidden" name="crsNo" value="<%= request.getAttribute("crsNo")+"" %>" />
        <input type="hidden" name="classNo" value="<%= request.getAttribute("classNo")+"" %>" />
        </div>
         <div align='center' class='centerpage'><font color='red'><html:errors property="messageSendStatus"/></font></div>
          <table  cellpadding="0" cellspacing="5" width="100%">
            <tbody>
              <tr>
                <td>
                 <table border="0" cellpadding="0" cellspacing="0" width="100%" class="borderRoundedClearColor" >
                  <tbody>
                  <tr class="subtitle">
                    <td colspan="2"><div align="center">
                        <table border=0 cellpadding=0 cellspacing=0 width="100%">
                          <tbody>
                            <tr>
                              <tbody>
                                 <tr>
                                   <td align=middle class="tabHeaderBigColor" ><div align="center" class="subtitle">قائمة أسماء طلاب الشعبة</div></td>
                                  </tr>
                                 <tr>
                                  <td bgcolor="#f38e00"><table border=0 cellpadding=2 cellspacing=1 width="100%">
                                  <tbody>
                                    <tr>
                                      <td align="middle" bgcolor="#ffffff" valign="top" width="50%"><table border=0 cellpadding=2 cellspacing=0 width="100%">
                                          <tbody>
                                            <tr>
                                              <td align=middle bgcolor="#f38e00"><div align="center" class="subtitle">قائمة أسماء طلاب الشعبة</div></td>
                                            </tr>
                                            <tr>
                                              <td class="tableRowLightColor" align=middle><table width="50%" border=0 cellpadding=0 cellspacing=2>
                                                  <tbody>
                                                    <tr  >
                                                      <td >
                                                       <input type="hidden" name="submitValue" value="1" >
                                                        <html:select property="classStudent" multiple="true" size="10"   styleClass="borderRoundedList">
                                                          <logic:present name="existUsersList">
                                                            <html:options collection="existUsersList" property="tutorUserId"  labelProperty="tutorAName"/>
                                                          </logic:present>
                                                        </html:select>
                                                      </td>
                                                      <td width="16" valign=top><br>
                                                          <br>
                                                          <br>
                                                          <br>
                                                          <button onClick="move(classStudent, recieverStudent,'remove');return false;"  class="enter"  >&nbsp;&gt;&nbsp;</button>
                                                          &nbsp;<br>&nbsp;
                                                          <button  onClick="moveAll(classStudent, recieverStudent,'classStudent');empty(classStudent);return false;" class="enter" >&gt;&gt;</button></td>
                                                    </tr>
                                                  </tbody>
                                              </table></td>
                                            </tr>
                                          </tbody>
                                      </table></td>
                                      <td align=middle bgcolor=#ffffff valign=top width="50%"><table border=0 cellpadding=2 cellspacing=0 width="100%">
                                          <tbody>
                                            <tr>
                                              <td align=middle bgcolor="#f38e00"><div align="center" class="subtitle">المستلمون </div></td>
                                            </tr>
                                            <tr>
                                              <td align=middle  class="tableRowLightColor"><table width="50%" border=0 cellpadding=0 cellspacing=2>
                                                  <tbody>
                                                    <tr>
                                                      <td width="20" valign=top><br>
                                                          <br>
                                                          <br>
                                                          <br>
                                                          <button onClick="move(recieverStudent,classStudent,'remove');return false;"   class="enter" >&nbsp;&lt;&nbsp;</button>
                                                          &nbsp;<br>&nbsp;
                                                          <button onClick="moveAll(recieverStudent,classStudent,'recieverStudent');empty(recieverStudent);return false;" class="enter"   >&lt;&lt;</button></td>
                                                      <td >
                                                            <html:select property="recieverStudent" size="10" multiple="true"  styleClass="borderRoundedList">
                										         <logic:present name="selectedUsersList">
		    										               <html:options collection="selectedUsersList" property="tutorUserId"  labelProperty="tutorAName"/>
           	        											 </logic:present>
                                                            </html:select>
                                                      </td>
                                                    </tr>
                                                  </tbody>
                                              </table></td>
                                            </tr>
                                          </tbody>
                                      </table></td>
                                    </tr>
                                  </tbody>
                              </table></td>
                            </tr>
                          </tbody>
                        </table>
                    </div align="right"><html:errors property="emptyRecieverStudent" /></td>
                    </tr>
                  <tr>
                    <td colspan="2" height="17"></td>
                  </tr>
                  <tr><td>
                  <div  >
                  <table border="0" width="100%" >
                    <tr>
                    <td align="right" class="borderRoundedLightColor"  ><div  ><html:errors property="emptySubject" /><html:text styleClass="largeFileInputMSG" property="subject" maxlength="100"/><strong>&nbsp;&nbsp;:الموضوع</strong></div></td>
                    </tr>

                  </tr>
                  <tr>
                    <td colspan="2" height="4"></td>
                  </tr>
                  <tr class="centerpage">
                  <td height="17" align="right">نص الرسالة :<html:errors property="emptyMessageBody" /></td>
                  </tr>

                          <tr class="qou">
                           <td align="center">
<%--                                <html:textarea property="messageBody" cols="60" rows="20" styleId="messageBody" style="width:100%"></html:textarea>--%>
<%--                            Added By Ibrahim Assi Date :10-8-2011--%>
                            <html:textarea property="messageBody" cols="80" rows="10" styleId="messageBody" style="width:100%"></html:textarea>
                            <script type="text/javascript">
                             CKEDITOR.replace( 'messageBody', { skin : 'kama' });
                            </script>
<%--                          End  Added By Ibrahim Assi Date :10-8-2011--%>
                        </td>
                      </tr>


                 <tr class="centerpage">
                    <td align="right"><div align="right">
                    <table dir="ltr" >
                      <tr class="centerpage">
                          <td align="right"><div align="right">
                           &nbsp<span>الحد الاقصى 10 ميغا</span>
                          <html:file property="theFile" styleClass="largeFileInput"/>
                          </div></td>
                          <td height="25" align="right"><div align="right">ملف مرفق:</div></td>
                      </tr>

                       <tr >
                        <td align="right"><div align="right">
                            <html:select  property="servirity" styleClass="dropList">
                            <html:option value="normal">عادي</html:option>
                            <html:option value="irgante">عاجل</html:option>
                            </html:select>
                        </div></td>
                        <td height="17" class="centerpage" align="right"><div align="right">الحالة :</div></td>
                      </tr>
                    </table></div></td>
                    </table>
                   </td>

                  </tr>
                  </tr>
                  <tr>
                    <td colspan="2" height="25"><div align="center"> <html:reset styleClass="enterMSG" value="مسح"/> <html:submit styleClass="enterMSG"  property="save" onclick="setAllListSelected(this.form);return true;"  value="ارسل" /> </div></td>
                  </tr>
                </table></td>
              </tr>
            </tbody>
          </table>
        </html:form>
    </div></td>
  </tr>
  <TBODY>
 </TBODY></TABLE>
<%--<script type="text/javascript" defer="0">--%>
<%--    globalWidth = 500;--%>
<%--    globalHeight = 250;--%>
<%--    HTMLArea.replace("messageBody");--%>
<%--</script>--%>