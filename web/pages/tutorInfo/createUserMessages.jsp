<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.ArrayList"%>
<%@ taglib uri="/WEB-INF/lib/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/WEB-INF/lib/struts-html.tld" prefix="html" %>

<script  src="/pages/resources/ckeditor/ckeditor.js" type="text/javascript"></script>
 <TABLE align="left" width="99%" border=0 cellPadding=0 cellSpacing=0 class="qou" >
  <TBODY>
    <TR align="right" valign="top">
      <TD width="99%" >
	  <div align="center">
<%--          <p align="right"> </p>--%>
          <table border="0" width="100%">
        <tbody>
        <tr>
         <td valign="top" width="100%">
            <div align="right">
           <html:form method="post" action="/sendUserMessages" enctype="multipart/form-data">
            <table   cellpadding="0" cellspacing="0" width="100%" align="center" >
              <tbody>
              <tr>
                <td>
                  <table border="0" cellpadding="0" cellspacing="0" width="100%">
                    <tbody>
                      <tr class="subtitle">
                        <td height="17" width="87%">
                          <div align="right"><font color="#000000" >
                        <logic:present name="studentInfo">
                              <logic:iterate id="studentinfo" name="studentInfo" >
                                  <bean:write name="studentinfo" property="studentName" />
                              </logic:iterate>
                        </logic:present>

                     </font></div>
                      </td>
                        <td width="13%"><div align="right"><font color="#000000">المرسل </font></div></td>
                      </tr>
                      <tr class="subtitle">
                        <td height="17" dir="rtl" ><div align="right"><font color="#000000">
                               <html:hidden property="recieverId" />
                               <html:hidden property="messageExtraInfo" />
                               <html:hidden property="crsNo" />
                               <html:hidden property="crsClass" />
                               <html:text property="recieverName"  readonly="true"  maxlength="100" styleClass="largeInputView"/>
                              </font>
                            </div>
                          </td>
                        <td height="17"><div align="right"><font color="#000000">المستلم </font></div></td>
                      </tr>
  
            <tr class="subtitle">
                        <td height="17"><div align="right">
                            <html:text styleClass="largeInput"  property="subject" maxlength="100"/>
							</div></td>
                        <td height="17"><div align="right"><font color="#000000">الموضوع </font></div></td>
                      </tr>
                      <tr  class="qou">
                        <td colspan="2" > <div align="right"><html:errors property="emptySubject" /></div></td>
                       </tr>
                       <tr>
                       <td  colspan="2" class="subtitle"><div align="right">
                        <font color="#000000">نص                 الرسالة </font></div>
                        </td> </tr>
                      <tr class="qou">
                       <td colspan="2" >
                         <div align="right">
                            <table border="0" cellpadding="0" cellspacing="0" width="100%">
                                  <tr class="qou">
                                   <td align="center">
                              <html:textarea property="messageBody" cols="80" rows="10" styleId="messageBody" style="width:100%"></html:textarea>
                            <script type="text/javascript">
                             CKEDITOR.replace( 'messageBody', { skin : 'kama' });
                            </script>
                                     </td>
                                  </tr>
                            </table>
                         </div>
                        </td>
                      </tr>
                     <tr  class="qou">
                       <td colspan="2" >
                     <div align="right">
                      <html:errors property="emptyMessageBody" />
                    </div>
                    </td>
                   </tr>
                   <tr class="centerpage">
                    <td align="right">
                      <div align="right"><html:file property="theFile" styleClass="largeFileInput"/>       &nbspالحد الاقصى 2 ميغا</div>
                    </td>
                    <td height="25" align="right">
                      <div align="right">ملف مرفق:</div>
                    </td>
                   </tr>
                   <tr class="centerpage">
                   <td align="right">
                      <html:errors property="wrongFileInfo" />
                   </td>
                   <td height="3" align="right"></td>
                  </tr>
                      <tr>
                        <td colspan="2" height="25">
                          <div align="center">
                             <html:reset styleClass="enter" value="مسح"/> <html:submit styleClass="enter"  property="save"   value="ارسل" />
                          </div>
                        </td>
                       </tr>
                      </tbody>
                     </table>
                    </td>
                   </tr>
                  </tbody>
                 </table>
                </html:form>
               </div>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
     </TD>
    </TR>
  </TBODY>
</TABLE>