<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/lib/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/lib/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/lib/qou-Taglib.tld" prefix="qou" %>

 
 
<%@ taglib uri="/WEB-INF/lib/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://psgateway.org" prefix="pagination" %>
<%@ taglib uri="/WEB-INF/lib/struts-tiles.tld" prefix="tiles" %>
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
<link href="/pages/resources/css/dr_portal_style.css" rel="stylesheet" type="text/css">

<script type="text/javascript">
       window.onload = function()
       {
            chngWrkStatus();

            if( document.srvyWorkDetailForm.wrkSector.value== '3')
            document.getElementById('wrkOtherDiv').style.display = "inline"
       };

   function wrkOtherFun(wrkOthVal)
   {

       var divId=  document.getElementById('wrkOtherDiv') ;

       if(wrkOthVal == '3')
       {
          divId.style.display = "inline";
       }
       else
       {
         document.srvyWorkDetailForm.wrkOther.value='';
         divId.style.display = "none"; 
       }

   }

    function chngWrkStatus()
    {

        var wrk_list =document.srvyWorkDetailForm.isWork;
        var wrk_value;
        for(var i = 0; i < wrk_list.length; i++)
        {
            if(wrk_list[i].checked)
            {
             wrk_value = wrk_list[i].value;
            }
        }


        
        if(wrk_value == 'Y')
        {
            document.srvyWorkDetailForm.wrkSector.disabled = false;
            document.srvyWorkDetailForm.wrkSector.className = 'largeInput';
            document.srvyWorkDetailForm.wrkType1.disabled = false;
            document.srvyWorkDetailForm.wrkType1.className = 'inputFieldSmaller65';
            document.srvyWorkDetailForm.wrkType2.disabled = false;
            document.srvyWorkDetailForm.wrkType2.className = 'inputFieldSmaller65';
            document.srvyWorkDetailForm.wrkSalary.disabled = false;
            document.srvyWorkDetailForm.wrkSalary.className = 'largeInput';
            document.srvyWorkDetailForm.wrkCompany.className = 'largeInput';
            document.srvyWorkDetailForm.wrkJob.className = 'largeInput';
            document.srvyWorkDetailForm.wrkAddress.className = 'largeInput';
            document.srvyWorkDetailForm.wrkPhone.className = 'largeInput';
//            document.srvyWorkDetailForm.wrkReason.className = 'largeInput';

            document.srvyWorkDetailForm.wrkCompany.readOnly  = false;
            document.srvyWorkDetailForm.wrkJob.readOnly  = false;
            document.srvyWorkDetailForm.wrkAddress.readOnly  = false;
            document.srvyWorkDetailForm.wrkPhone.readOnly  = false;
//            document.srvyWorkDetailForm.wrkReason.readOnly  = false;
            

        }
        else if(wrk_value == 'N')
        {
            document.srvyWorkDetailForm.wrkSector.value = '*';
            document.srvyWorkDetailForm.wrkSector.disabled = true;
            document.srvyWorkDetailForm.wrkSector.className = 'largeInputView';
            document.srvyWorkDetailForm.wrkType1.value = '*';
            document.srvyWorkDetailForm.wrkType1.disabled = true;
            document.srvyWorkDetailForm.wrkType1.className = 'inputFieldSmallerView65';
            document.srvyWorkDetailForm.wrkType2.value = '*';
            document.srvyWorkDetailForm.wrkType2.disabled = true;
            document.srvyWorkDetailForm.wrkType2.className = 'inputFieldSmallerView65';
            document.srvyWorkDetailForm.wrkSalary.value = '*';
            document.srvyWorkDetailForm.wrkSalary.disabled = true;
            document.srvyWorkDetailForm.wrkSalary.className = 'largeInputView';

            document.srvyWorkDetailForm.wrkCompany.className = 'largeInputView';
            document.srvyWorkDetailForm.wrkJob.className = 'largeInputView';
            document.srvyWorkDetailForm.wrkAddress.className = 'largeInputView';
            document.srvyWorkDetailForm.wrkPhone.className = 'largeInputView';

            document.srvyWorkDetailForm.wrkCompany.value = " ";
            document.srvyWorkDetailForm.wrkJob.value = ' ';
            document.srvyWorkDetailForm.wrkAddress.value = ' ';
            document.srvyWorkDetailForm.wrkPhone.value = ' ';

            document.srvyWorkDetailForm.wrkCompany.readOnly = "readonly";
            document.srvyWorkDetailForm.wrkJob.readOnly = "readonly";
            document.srvyWorkDetailForm.wrkAddress.readOnly = "readonly";
            document.srvyWorkDetailForm.wrkPhone.readOnly = "readonly";

            document.srvyWorkDetailForm.wrkOther.value='';
            document.getElementById('wrkOtherDiv').style.display = "none";

        }

    }


</script>
</HEAD>
<div align="center" >
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
            <td   ><div align="center" class="errorMsRed"><b><bean:message key='<%=(String)request.getAttribute("operationMessage")%>'/></b></div></td>
            </tr>
            </table>
            </logic:present>
            </td>
          </tr>
          </table>
      </td>
    </tr>
     <html:form  action="saveStudSocialSrvWorkDtlInfo.do"  method="post"  >
     <html:hidden property="workerType"   />

     <tr>
      <td>
             <table width="95%" align="center" class="qou" border="0" cellpadding="0" cellspacing="0">
                <tr class="tableRowClearColor">
                    <td align="right" class="qouRtl"  valign="bottom" colspan="4" >
                        <html:radio property="isWork" tabindex="<%=String.valueOf(tabindex++)%>"   onclick="chngWrkStatus()"  value="Y"    /> نعم
                        &nbsp;
                        <html:radio property="isWork" tabindex="<%=String.valueOf(tabindex++)%>"   onclick="chngWrkStatus()"    value="N"    /> لا
                        &nbsp;
                    </td>
                    <td align="right" colspan="2" class="qou9BoldRtl">4.1 	هل تعمل؟</td>
                </tr>
                <tr>
                    <td align="right" class="qouRtl" colspan="6"> اذا كان الجواب "نعم" ، حدد :</td>
                </tr>
                <tr>
                     <td width="20%" align="right">
                       <html:text   property="wrkAddress"  maxlength="100" styleClass="largeInput" tabindex="<%=String.valueOf(tabindex++)%>" />
                     </td>
                     <td width="17%" align="right" class="qouRtl" >	عنوان مكان العمل  :</td>
                     <td width="2%" align="right" class="qouRtl"  >  <lu><li></li></lu>  </td>
                     <td width="35%" align="right">
                     <table width="100%" cellpadding="0" cellspacing="0">
                         <tr>
                             <td width="65%" class="qouRtl" align="right"><div id="wrkOtherDiv" style="display:none;" >&nbsp;حدد:&nbsp;<html:text   property="wrkOther"  maxlength="100" styleClass="largeInput90" tabindex="<%=String.valueOf(tabindex++)%>" /></div></td>
                             <td width="35%">
                            <html:select property="wrkSector" styleClass="largeInput" onchange="wrkOtherFun(this.value)"  tabindex="<%=String.valueOf(tabindex++)%>">
                             <html:option value="*">اختر</html:option>
                             <html:option value="*">خاص</html:option>
                             <html:option value="1">حكومي</html:option>
                             <html:option value="2">اعمال حرة</html:option>
                             <html:option value="3">غير ذالك</html:option>
                            </html:select>
                             </td>
                         </tr>
                     </table>

                     </td>
                     <td width="25%" align="right" class="qouRtl" >القطاع :</td>
                     <td width="2%" align="right" class="qouRtl" valign="middle"  >  <lu><li></li></lu>   </td>
                </tr>
                <tr><td colspan="6" height="4"></td></tr>
                  <tr>
                     <td   align="right">
                       <html:text   property="wrkPhone"  maxlength="100" styleClass="largeInput" tabindex="<%=String.valueOf(tabindex++)%>" />
                     </td>
                     <td  align="right" class="qouRtl" >تلفون/فاكس :</td>
                     <td   align="right" class="qouRtl"  valign="middle"  >  <lu><li></li></lu>   </td>
                     <td align="right">
                       <html:text   property="wrkCompany"   maxlength="100" styleClass="largeInput" tabindex="<%=String.valueOf(tabindex++)%>" />
                     </td>
                     <td align="right" class="qouRtl" >	اسم المؤسسة (جامعة، شركة ...الخ)  :</td>
                     <td align="right" class="qouRtl"  >
                       <lu><li>&nbsp;</li></lu>
                    </td>
                </tr>
                 <tr><td colspan="6" height="4"></td></tr>
                  <tr>
                     <td   align="right">
                       <html:select property="wrkType2" styleClass="inputFieldSmaller65" tabindex="<%=String.valueOf(tabindex++)%>">
                           <html:option value="*">اختر</html:option>
                           <html:option value="ft">متفرغ</html:option>
                           <html:option value="pt">غير متفرغ</html:option>
                      </html:select>
                      &nbsp;
                      <html:select property="wrkType1" styleClass="inputFieldSmaller65" tabindex="<%=String.valueOf(tabindex++)%>">
                         <html:option value="*">اختر</html:option>
                         <html:option value="dy">يومي</html:option>
                         <html:option value="hr">بالساعات</html:option>
                         <html:option value="mt">شهري</html:option>
                      </html:select>
                     </td>
                     <td  align="right" class="qouRtl" >	تصنيف العمل ( يمكن اختيار اكثر من اجابة) :</td>
                     <td   align="right" class="qouRtl"  valign="middle"  >  <lu><li></li></lu>   </td>
                     <td align="right">
                       <html:text   property="wrkJob"  maxlength="100" styleClass="largeInput" tabindex="<%=String.valueOf(tabindex++)%>" />
                     </td>
                     <td align="right" class="qouRtl" >المهنة (مثلاً:  أستاذ، نجار، طبيب ...الخ) :</td>
                     <td align="right" class="qouRtl"  >
                       <lu><li>&nbsp;</li></lu>
                    </td>
                </tr>
                <tr><td colspan="6" height="4"></td></tr>
                 <tr>
                     <td colspan="4"  align="right">
                      <html:select property="wrkSalary" styleClass="largeInput" tabindex="<%=String.valueOf(tabindex++)%>">
                         <html:option value="*">اختر</html:option>
                         <html:option value="*">أقل من 500</html:option>
                         <html:option value="1">500 - 999</html:option>
                         <html:option value="2">1000 - 1449</html:option>
                         <html:option value="2">1500 - 1999</html:option>
                         <html:option value="2">2000 - 2449</html:option>
                         <html:option value="2">2500 وأكثر </html:option>
                      </html:select>
                     </td>
                     <td  align="right" class="qouRtl" >	الأجر الشهري بالشيقل:</td>
                     <td   align="right" class="qouRtl"  valign="middle"  >  <lu><li></li></lu>   </td>
                 </tr>


            </table>

      </td>
    </tr>
    <tr>
        <td>
        <html:errors  />
        </td>
    </tr>
    <%--<tr>--%>
      <%--<td align="right" class="qou" ><hr align="center" color="#f38e00" size="1"></td>--%>
    <%--</tr>--%>


    <%--<tr  >--%>
    <%--<td align="center">--%>
    <%--<input type="submit" value="  حفظ  " class="enter"  tabindex="<%=String.valueOf(tabindex++)%>"  >&nbsp;--%>
    <%--</td>--%>
    <%--</tr>--%>
    </html:form>
  </TABLE>
</BODY></div></HTML>