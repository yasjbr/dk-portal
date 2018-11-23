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

<script type="text/javascript">
       window.onload = function(){
//        var cal_enroleDate     =  new Epoch('enroleDate','popup',document.srvyWorkRelativeForm.enroleDate);

        <logic:present name="viDvAdd">
           showHideDiv('addEditDataDiv','dataDiv','<%=request.getAttribute("viDvAdd")%>');
        </logic:present>


     };

    var oprTypeVal='1';

    function showHideDiv(divIdV,divIdH ,p_oprType)
    {
       document.getElementById(divIdV).style.display="inline";
       document.getElementById(divIdH).style.display="none";

       if(p_oprType == '2')
       {
           document.getElementById('divTitle').innerHTML='تعديل';
           oprTypeVal='2';
       }
       else if(p_oprType == '1')
       {
            document.getElementById('divTitle').innerHTML='اضافة حقل جديد'  ;
            oprTypeVal='1';

            document.srvyWorkRelativeForm.wrlRelativeName.value = '';
            document.srvyWorkRelativeForm.wrlWorkAddress.value = '';
            document.srvyWorkRelativeForm.wrlPhone.value = '';
            document.srvyWorkRelativeForm.wrlJob.value = '';
            document.srvyWorkRelativeForm.wrlCategory.value = '';
            document.srvyWorkRelativeForm.wrlSalary.value = '';
            document.srvyWorkRelativeForm.wrlFamilyContribute.value = '';
            document.srvyWorkRelativeForm.counter.value = '';
       }
    }

    function editRecord(wrlRelativeName_p,wrlWorkAddress_p,wrlPhone_p,wrlJob_p,
                        wrlCategory_p,wrlSalary_p,wrlFamilyContribute_p,counter_p)
    {
         document.srvyWorkRelativeForm.wrlRelativeName.value = wrlRelativeName_p;
        document.srvyWorkRelativeForm.wrlWorkAddress.value = wrlWorkAddress_p;
        document.srvyWorkRelativeForm.wrlPhone.value = wrlPhone_p;
        document.srvyWorkRelativeForm.wrlJob.value = wrlJob_p;
        document.srvyWorkRelativeForm.wrlCategory.value = wrlCategory_p;
        document.srvyWorkRelativeForm.wrlSalary.value = wrlSalary_p;
        document.srvyWorkRelativeForm.wrlFamilyContribute.value = wrlFamilyContribute_p;
        document.srvyWorkRelativeForm.counter.value = counter_p;

    }
        function confirmDeleteRecord(counter_p,wrlRelativeName_p)
        {
                if(confirm('هل تريد حذف سجل - '+wrlRelativeName_p+' ?'))
                {
                   document.srvyWorkRelativeForm.counter.value = counter_p;
                  document.srvyWorkRelativeForm.operType.value = '3';
                  document.srvyWorkRelativeForm.submit();
                  return true;
                }
        }


    function funSubmit()
    {
       document.srvyWorkRelativeForm.operType.value = oprTypeVal;
       document.srvyWorkRelativeForm.submit();
       return true;
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
            <td   ><div align="center" class="errorMsRed"><b><bean:message key="<%=(String)request.getAttribute("operationMessage")%>"/></b></div></td>
            </tr>
            </table>
            </logic:present>
            </td>
            <td width="60%" align="right" >
              <% if(request.getParameter("liveIn")!=null && request.getParameter("liveIn").trim().equals("1"))
              {
              %>
              <div class="textDate" align="right" dir="rtl">4.2.4  الأخوة/الأخوات الذين يعملون، ويسكنون مع العائلة (في بيت الأهل الأصلي):</div>
              <%
              }
              else
              {
              %>
              <div class="textDate" align="right" dir="rtl">4.2.5  الأخوة/الأخوات الذين يعملون ولا يسكنون مع العائلة (في بيت الأهل الأصلي):</div>  
             <%}%>
            </td>
          </tr>
          </table>
           <div id="dataDiv">
                        <logic:present name="srvWrlDataList">
                     <% int i = 1; %>
                            <br/>
                       <table width="100%" border="0" cellspacing="0" cellpadding="0" class="borderRoundedClearColor" bgcolor="#f38e00">
                          <tr class="tabheader">
                            <td width="10%">&nbsp;</td>
                            <td width="10%"><div align="center">مبلغ المساهمة مع العائلة</div></td>
                            <td width="10%"><div align="center">الأجر الشهري بالشيقل</div></td>
                            <td width="15%"><div class="qouRtl" align="center">تصنيف العمل(يشمل الأعمال الحرة)</div></td>
                            <td width="10%"><div align="center">المهنة</div></td>
                            <td width="5%"><div align="center">تلفون/ فاكس</div></td>
                            <td width="10%"><div align="center">مكان العمل</div></td>
                            <td width="20%"><div align="center">اسم الأخ/الأخت</div></td>
                            <td width="5%"><div align="center">&nbsp;</div></td>
                          </tr>
                     <logic:iterate id="srvWrlDataList" name="srvWrlDataList" >
                         <%  if (i%2 == 0) { %>
                               <tr  class="tableRowClearColor"  onMouseOver="this.className='highlight'" onMouseOut="this.className='tableRowClearColor'">

                          <%}else {%>
                                <tr class="tableRowLightColor"  onMouseOver="this.className='highlight'" onMouseOut="this.className='tableRowLightColor'">
                          <%}%>
                            <td align="center">
                            <a  href="javascript:confirmDeleteRecord( '<bean:write name="srvWrlDataList" property="comp_id.counter"/>','<bean:write name="srvWrlDataList" property="wrlRelativeName"/>')" title="حذف"><img src="/pages/resources/images/recDelete.gif" border="0" alt="حذف"  width="20" height="20"/></a>
                            &nbsp;
                            <a href="javascript:showHideDiv('addEditDataDiv','dataDiv','2'); editRecord( '<bean:write name="srvWrlDataList" property="wrlRelativeName" />','<bean:write name="srvWrlDataList" property="wrlWorkAddress"/>','<bean:write name="srvWrlDataList" property="wrlPhone"/>','<bean:write name="srvWrlDataList" property="wrlJob"/>','<bean:write name="srvWrlDataList" property="wrlCategory"   />','<bean:write name="srvWrlDataList" property="wrlSalary"/>','<bean:write name="srvWrlDataList" property="wrlFamilyContribute"/>','<bean:write name="srvWrlDataList" property="comp_id.counter"/>'); " title="تعديل"><img src="/pages/resources/images/recEdit.gif" border="0" alt="تعديل" width="20" height="20"/></a>
                            &nbsp;
                            </td>
                            <td class="qou"><div align="center"><bean:write name="srvWrlDataList" property="wrlFamilyContribute"/></div></td>
                            <td class="qou"><div align="center"><bean:write name="srvWrlDataList" property="wrlSalary"   /></div></td>
                            <td class="qou"><div align="center"><bean:write name="srvWrlDataList" property="wrlCategory"/></div></td>
                            <td class="qou"><div align="center"><bean:write name="srvWrlDataList" property="wrlJob"/></div></td>
                            <td class="qou"><div align="center"><bean:write name="srvWrlDataList" property="wrlPhone"/></div></td>
                            <td class="qou"><div align="right" ><bean:write name="srvWrlDataList" property="wrlWorkAddress" /></div></td>
                            <td class="qou"><div align="center"><bean:write name="srvWrlDataList" property="wrlRelativeName"/> </div></td>
                            <td><%=i%></td>
                          </tr>
                      <% i++; %>
                     </logic:iterate>
                       <tr><td colspan="7" align="center">&nbsp;<a class="tabheaderBorderFullRounded" href="javascript:showHideDiv('addEditDataDiv','dataDiv','1');">اضافة حقل جديد</a></td></tr>
                     </table>
                     </logic:present>
              <logic:notPresent name="srvWrlDataList">
                <table width="100%" border="0" cellspacing="0" cellpadding="0"  >
                <tr><td>&nbsp;</td></tr>
                <tr><td align="center" class="tableRowLightColor textDate"> لا توجد بيانات - <a  href="javascript:showHideDiv('addEditDataDiv','dataDiv','1');">اضغط هنا للاضافة</a></td></tr>
                <tr><td>&nbsp;</td></tr>
                </table>
              </logic:notPresent>



          </div>

      </td>
    </tr>
     <html:form  action="saveStudSocialSrvWorkRelativeInfo.do"  method="post"  >
     <html:hidden property="counter"      />
     <html:hidden property="operType"     />
     <html:hidden property="wrlIsLiveIn"  />

     <tr>
      <td>
          <div id="addEditDataDiv" style="display:none;">
              <br/>
            <table width="95%" align="center" class="borderRoundedClearColor" border="0" cellpadding="0" cellspacing="0">
                <tr>
                    <td colspan="4" class="tabHeaderBigColor" align="center"> <div id="divTitle"> </div></td>
                </tr>
                <tr class="tableRowLightColor">
                    <td align="right" width="20%"><html:text   property="wrlWorkAddress"   maxlength="100" styleClass="largeInput"  tabindex="<%=String.valueOf(tabindex++)%>" /></td>
                    <td align="right" width="30%" class="qou9Bold">مكان العمل</td>
                    <td align="right" width="20%"><html:text   property="wrlRelativeName"   maxlength="100" styleClass="largeInput" tabindex="<%=String.valueOf(tabindex++)%>" /></td>
                    <td align="right" width="30%" class="qou9Bold">اسم الأخ/الأخت</td>
                </tr>
                <tr>
                    <td align="right" ><html:text property="wrlJob"  tabindex="<%=String.valueOf(tabindex++)%>" styleClass="largeInput"  /> </td>
                    <td align="right" class="qou9Bold">المهنة</td>
                    <td align="right" ><html:text property="wrlPhone"     tabindex="<%=String.valueOf(tabindex+2)%>" styleClass="largeInput"/>  </td>
                    <td align="right" class="qou9Bold" >تلفون/ فاكس</td>
                </tr>
                <tr class="tableRowLightColor">
                    <td align="right" ><html:text   property="wrlSalary"   maxlength="100" styleClass="largeInput" tabindex="<%=String.valueOf(tabindex++)%>" /></td>
                    <td align="right" class="qou9BoldRtl">الأجر الشهري بالشيقل</td>
                    <td align="right"><html:text   property="wrlCategory"   maxlength="100" styleClass="largeInput" tabindex="<%=String.valueOf(tabindex++)%>" /></td>
                    <td align="right" class="qou9Bold">تصنيف العمل (يشمل الأعمال الحرة)</td>
                </tr>
                <tr class="tableRowLightColor">
                    <td align="right" colspan="3"><html:text   property="wrlFamilyContribute"   maxlength="100" styleClass="largeInput" tabindex="<%=String.valueOf(tabindex++)%>" /></td>
                    <td align="right" class="qou9Bold">مبلغ المساهمة مع العائلة</td>
                </tr>
                <tr  >
                    <td  align="center" colspan="4">
                        <input type="button" value=" &nbsp;&nbsp;&nbsp; الغاء  &nbsp;&nbsp;&nbsp;" class="enter"  tabindex="<%=String.valueOf(tabindex++)%>" onclick="javascript:showHideDiv('dataDiv','addEditDataDiv');" >&nbsp;
                        <input type="button" value=" &nbsp;&nbsp;&nbsp; حفظ  &nbsp;&nbsp;&nbsp;" class="enter"  tabindex="<%=String.valueOf(tabindex++)%>"   onclick="javascript:funSubmit();">&nbsp;
                    </td>
                </tr>
            </table>

          </div>

      </td>
    </tr>
    <tr>
        <td>
        <html:errors  />
        </td>
    </tr>
    </html:form>
  </TABLE>
</BODY></div></HTML>