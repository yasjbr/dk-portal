<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="http://psgateway.org" prefix="pagination" %>
<%@ taglib uri="/WEB-INF/lib/struts-tiles.tld" prefix="tiles" %>
<%
  response.setHeader("pragma", "no-cache");
  response.setHeader("Cache-Control", "no-cache");
  response.setHeader("Expires", "0");

    int tabindex=1;
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<META content="MSHTML 6.00.2600.0" name=GENERATOR>
 <script type="text/javascript" src="/pages/resources/js/epoch_classes.js"></script>
<link rel="stylesheet" href="/pages/resources/css/epoch_styles.css" type="text/css">
<link href="/pages/resources/css/dr_portal_style.css" rel="stylesheet" type="text/css">
 <head>

     <script type="text/javascript">

       window.onload = function()
       {
            stgcHasLoanFun();
            stgcAffairsFun();
            stgcUnrwaFun();


       };

     function stgcUnrwaFun()
    {
        var rdio_list =document.srvyStrategicForm.stgcUnrwa;
        var selected_value;
        for(var i = 0; i < rdio_list.length; i++)
        {
            if(rdio_list[i].checked)
            {
             selected_value = rdio_list[i].value;
            }
        }

        if(selected_value == 'Y')
        {
            document.srvyStrategicForm.stgcUnrwaNo.className = 'largeInput';
            document.srvyStrategicForm.stgcUnrwaNo.readOnly  = false;
        }
        else if(selected_value == 'N')
        {
            document.srvyStrategicForm.stgcUnrwaNo.className = 'largeInputView';
            document.srvyStrategicForm.stgcUnrwaNo.value = ' ';
            document.srvyStrategicForm.stgcUnrwaNo.readOnly  = true;
        }


    }
    function stgcAffairsFun()
    {
        var rdio_list =document.srvyStrategicForm.stgcAffairs;
        var selected_value;
        for(var i = 0; i < rdio_list.length; i++)
        {
            if(rdio_list[i].checked)
            {
             selected_value = rdio_list[i].value;
            }
        }

        if(selected_value == 'Y')
        {
            document.srvyStrategicForm.stgcCaseNo.className = 'largeInput';
            document.srvyStrategicForm.stgcCaseNo.readOnly  = false;
        }
        else if(selected_value == 'N')
        {
            document.srvyStrategicForm.stgcCaseNo.className = 'largeInputView';
            document.srvyStrategicForm.stgcCaseNo.value = ' ';
            document.srvyStrategicForm.stgcCaseNo.readOnly  = true;
        }


    }

    function stgcHasLoanFun()
    {
        var rdio_list =document.srvyStrategicForm.stgcHasLoan;
        var selected_value;
        for(var i = 0; i < rdio_list.length; i++)
        {
            if(rdio_list[i].checked)
            {
             selected_value = rdio_list[i].value;
            }
        }

        if(selected_value == 'Y')
        { 
            document.srvyStrategicForm.stgcSource.className = 'largeTextArea';
            document.srvyStrategicForm.stgcSource.readOnly  = false;
        }
        else if(selected_value == 'N')
        {
            document.srvyStrategicForm.stgcSource.className = 'largeTextAreaView';
            document.srvyStrategicForm.stgcSource.value = ' ';
            document.srvyStrategicForm.stgcSource.readOnly  = true;
        }


    }
 
     </script>

 </head>
 <BODY  bgcolor="#FFFFFF"  topmargin="0"  valign=center>
<TABLE cellSpacing=0 cellPadding=0 width="966" align=center border=0 class="qou" dir="ltr" >
  <TBODY    >
   <tr>
      <td>
          <table width="100%" cellspacing="0" cellpadding="0" border="0">
          <tr>
            <td width="40%" align="left">
            <logic:present name="operationMessage">
            <table width="90%" border="0"   align="left" cellpadding="0" cellspacing="0" class="borderRoundedLightColor">
            <tr>
            <td   ><div align="center" class="errorMsRed"><b><bean:message key="<%=(String)request.getAttribute("operationMessage")%>"/></b></div></td>
            </tr>
            </table>
            </logic:present>
            </td>
          </tr>
          </table>
      </td>
    </tr>

 <html:form  action="saveStudSocialStrategicInfo.do"  method="post"  >
     <%--<html:hidden property="relativeType" value="1"  />--%>

    <tr>
      <td>
          <table width="95%" align="center" class="qou" border="0" cellpadding="2" cellspacing="2">
                <tr class="tableRowClearColor">
                    <td   align="right" colspan="3" class="qou9BoldRtl">8.1	ما هي استراتيجيات التكيف التي اتبعتها العائلة من أجل تغطية مصاريف العائلة؟</td>
                </tr>
                <tr>
                    <td width="68%"  class="qouRtl">  &nbsp;
                     </td>
                     <td width="30%" align="right" class="qouRtl" >ضع إشارة في المربع الذي يتناسب وحالتك:</td>
                     <td width="2%" align="right" class="qouRtl" valign="middle"  >     </td>
                </tr>
                <tr>
                     <td dir="rtl"  align="right">
                        <html:radio property="stgcHasLoan" tabindex="<%=String.valueOf(tabindex++)%>"   onclick="stgcHasLoanFun()"  value="Y"    /> نعم
                        &nbsp;
                        <html:radio property="stgcHasLoan" tabindex="<%=String.valueOf(tabindex++)%>"   onclick="stgcHasLoanFun()"    value="N"    /> لا
                        &nbsp; 
                     </td>
                     <td  align="right" class="qouRtl" >اللجوء إلى الاستدانة  </td>
                     <td  align="right" class="qouRtl"  >  <lu><li></li></lu>  </td>
                </tr>
                <tr>
                     <td   align="right">  &nbsp;
                     </td>
                     <td  align="right" class="qouRtl" >	ممن كانت الاستدانة؟  حدد:</td>
                     <td  align="right" class="qouRtl"  ><lu><li></li></lu> </td>
                </tr>
                <tr>
                     <td   align="right" colspan="2">
                          <html:textarea property="stgcSource" cols="80" rows="3"    styleClass="largeTextArea"   ></html:textarea>
                     </td>
                     <td  align="right" class="qouRtl"  >&nbsp;    </td>
                </tr>
                <tr>
                     <td   align="right">  &nbsp;
                     </td>
                     <td  align="right" class="qouRtl" >	الاعتماد على المساعدات الخارجية:</td>
                     <td  align="right" class="qouRtl"  ><lu><li></li></lu> </td>
                </tr>
                <tr>
                     <td   dir="rtl" align="right">
                        <html:radio property="stgcFamily" tabindex="<%=String.valueOf(tabindex++)%>"     value="Y"    /> نعم
                        &nbsp;
                        <html:radio property="stgcFamily" tabindex="<%=String.valueOf(tabindex++)%>"        value="N"    /> لا
                        &nbsp;
                     </td>
                     <td  align="right" class="qouRtl" >1-	الأخوة/الأهل (شبكة المساندة العائلية)</td>
                     <td  align="right" class="qouRtl"  >&nbsp;</td>
                </tr>
                <tr>
                     <td   dir="rtl" align="right">
                        <html:radio property="stgcOutsideHelp" tabindex="<%=String.valueOf(tabindex++)%>"      value="Y"    /> نعم
                        &nbsp;
                        <html:radio property="stgcOutsideHelp" tabindex="<%=String.valueOf(tabindex++)%>"       value="N"    /> لا
                        &nbsp;
                     </td>
                     <td  align="right" class="qouRtl" >2-	طلب المساعدة من المؤسسات الخارجية (مثل مؤسسات إقراض أو من تقدم منح جزئية)</td>
                     <td  align="right" class="qouRtl"  >&nbsp;</td>
                </tr>
                <tr>
                     <td   align="right">
                         <table width="100%" align="center" class="qou" border="0" cellpadding="0" cellspacing="0">
                            <tr>
                                <td width="53%" align="right"><html:text   property="stgcCaseNo"  maxlength="100" styleClass="largeInput" tabindex="<%=String.valueOf(tabindex++)%>" /></td>
                                <td width="30%" class="qouRtl" align="left"> رقم الحالة الاجتماعية:</td>
                                <td width="9%" class="qouRtl"><html:radio property="stgcAffairs" tabindex="<%=String.valueOf(tabindex++)%>"   onclick="stgcAffairsFun()"    value="N"    /> لا</td>
                                <td width="8%" class="qouRtl"><html:radio property="stgcAffairs" tabindex="<%=String.valueOf(tabindex++)%>"   onclick="stgcAffairsFun()"  value="Y"    /> نعم</td>


                            </tr>
                         </table> 
                     </td>
                     <td  align="right" class="qouRtl" >3-	التوجه للشؤون الاجتماعية  </td>
                     <td  align="right" class="qouRtl"  >&nbsp;</td>
                </tr>
                <tr>
                     <td   align="right">
                         <table width="100%" align="center" class="qou" border="0" cellpadding="0" cellspacing="0">
                            <tr>
                                <td width="53%" align="right"><html:text   property="stgcUnrwaNo"  maxlength="100" styleClass="largeInput" tabindex="<%=String.valueOf(tabindex++)%>" /></td>
                                <td width="30%" class="qouRtl" align="left"> رقم الحالة الاجتماعية:</td>
                                <td width="9%" class="qouRtl"><html:radio property="stgcUnrwa" tabindex="<%=String.valueOf(tabindex++)%>"   onclick="stgcUnrwaFun()"    value="N"    /> لا</td>
                                <td width="8%" class="qouRtl"><html:radio property="stgcUnrwa" tabindex="<%=String.valueOf(tabindex++)%>"   onclick="stgcUnrwaFun()"  value="Y"    /> نعم</td>


                            </tr>
                         </table>
                     </td>
                     <td  align="right" class="qouRtl" >4-	التوجه لوكالة الغوث        </td>
                     <td  align="right" class="qouRtl"  >&nbsp;</td>
                </tr>



                <tr>
                     <td   align="right">
                         <html:text   property="stgcOther"  maxlength="100" styleClass="longInput700" tabindex="<%=String.valueOf(tabindex++)%>" />
                     </td>
                     <td  align="right" class="qouRtl" >	أية استراتيجيات أخرى (حدد): </td>
                     <td  align="right" class="qouRtl"  ><lu><li></li></lu> </td>
                </tr>
              </table>
      </td>
    </tr>
   <tr><td>&nbsp;</td></tr>

   

    <tr>
        <td>
        <html:errors  />
        </td>
    </tr>
 </html:form>
  </TABLE>
</BODY>
</HTML>