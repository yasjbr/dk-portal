<%@ page import="ps.edu.diyar.common.tools.Randomizer" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/WEB-INF/lib/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<br />
          <table width="99%"  border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
                <td width="99%" valign="top" align="center">
                  <table width="100%" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="100%" height="50" class="centerpage">
                      <br/>                        <div align="center" class="bigTextBold_Black">مرحبا بكم في حساب عضو هيئة التدريس</div>
                      </td>

                    </tr>
                    <tr>
                     <td class="centerpage" valign="middle" height="45"><div align="center"  class="bigTextBold_Black">دار الكلمة</DIV></td>
                    </tr>
                    <tr>
                     <td class="centerpage" valign="middle" height="45"><br/></td>
                    </tr>
                    <logic:present name="foundUnreadMsg" >
                    <tr>
                     <td class="borderRoundedLightColor qou9Bold"align="right" height="30">
                         <lu><li  dir="rtl"  ><a  href="/tutor/showMessages.do?.rv=<%= Randomizer.shortRandom()%>"> لديك رسائل غير مقروءة</a></li></lu>
                     </td>
                    </tr>
                    </logic:present>
                    </table>
               </td>
            </tr>
            
            <tr  >
                <td width="99%" valign="top" align="center">
                    
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                            <TD class="borderTopLeftBigColor"  width="100"> <DIV align=center>الاعلانات </DIV></TD>
                        </tr>
                        <logic:present name="userNotifications">
                            <% int i = 0; %>
                       <logic:iterate id="not" name="userNotifications" >
                        <%  if (i%2 == 0) { %>
                               <tr  class="tableRowClearColor"  onMouseOver="this.className='highlight'" onMouseOut="this.className='tableRowClearColor'">

                          <%}else {%>
                                <tr class="tableRowLightColor"  onMouseOver="this.className='highlight'" onMouseOut="this.className='tableRowLightColor'">
                          <%}%>
                            <td>
                            <div align="right" class="qou">
                               <bean:write name="not" property="notMsg" />
                            </div>
                          </td>
                           
                        </tr>
                        <% i++; %>
                       </logic:iterate>
                       <tr><td colspan="6" >&nbsp;</td></tr>
                      </logic:present>
                    </table> 
                </td> 
            </tr>
            
            
          </table>