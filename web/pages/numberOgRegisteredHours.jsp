<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="ps.edu.diyar.common.tools.Randomizer" %>
<%@ taglib uri="/WEB-INF/lib/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/lib/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/lib/qou-Taglib.tld" prefix="qou" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>



<TABLE width="99%" border=0 align=center cellPadding=0 cellSpacing=0 class="qou" >
    <TR align="right" valign="top">
        <td width="100%"  valign="top">
            <div align="center"><br>
                <html:form method="post" action="/calculateHoursFees" enctype="multipart/form-data">
                    <table  border="1" cellpadding="0" cellspacing="0" width="100%" align="center" >
                        <tr class="subtitle">
                            <td  colspan="3" height="28" bgcolor="#E00000" ><div align="center" class="subtitle"><html:errors/></div></td> 
                        </tr>


                        <tr class="subtitle">
                            <td  colspan="3" height="28"   ><div align="center" class="subtitle"><font color="#000000">  الرجاء ادخال عدد الساعات التي تنوي تسجيلها ثم انقر على زر احتساب لمعرفة الملبغ المطلوب   </font></div></td> 
                        </tr>
                        <tr class="subtitle" >

                            <td   height="17" width="30%">
                                <div align="center">

                                    <logic:present name="total">
                                        <p align="right" class="qou">
                                            <span >
                                                 <%=request.getAttribute("total")%>     يرجى تسديد الدفعة الاولى من الأقساط وقيمتها 
                                            </span>   
                                        </p>
                                        
                                         <p align="right" class="qou">
                                            <span >
                                                 <%=request.getAttribute("sum")%>     من أصل 
                                            </span>   
                                        </p>
                                    </logic:present>
                                </div>
                            </td>

                            <td height="17" width="20%">
                                <div align="right">
                                    <html:submit styleClass="enter"  property="save"   value="احسب" />
                                    <html:text styleClass="Input"  property="hours" maxlength="100"/>
                                </div>
                            </td>
                            <td height="17" width="10%" >
                                <div  align="right">
                                    <font color="#000000"> عدد الساعات       </font>
                                </div>
                            </td>

                        </tr>

                    </table>    

                </html:form>    

            </div>
        </td>
    </TR>
</TABLE>




