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
 <script type="text/javascript" src="/pages/resources/js/epoch_classes.js"></script>
<link rel="stylesheet" href="/pages/resources/css/epoch_styles.css" type="text/css">
<link href="/pages/resources/css/dr_portal_style.css" rel="stylesheet" type="text/css">
 <head>

     <script type="text/javascript">

       window.onload = function()
       {
         document.srvyHousingForm.tblId.value = '';
         document.srvyHousingForm.tblOprType.value = '';
         hasFamilyBuildingFun();
         hasFamilyLandFun();
         hasFamilyCarFun();


       };


       function confirmDeleteRecordBldng(bldngNo)
        {
                if(confirm('هل تريد حذف هذا السجل ؟'))
                {
                   document.srvyHousingForm.tblId.value = 'bldng';
                   document.srvyHousingForm.bldngNo.value = bldngNo;
                   document.srvyHousingForm.tblOprType.value = 'D';
                   funSubmit();
                }
        }

       function confirmDeleteRecordLand(landCount)
        {
                if(confirm('هل تريد حذف هذا السجل ؟'))
                {
                   document.srvyHousingForm.tblId.value = 'land';
                   document.srvyHousingForm.landCount.value = landCount;
                   document.srvyHousingForm.tblOprType.value = 'D';
                   funSubmit();
                }
        }

       function confirmDeleteRecordCar(carNo)
        {
                if(confirm('هل تريد حذف هذا السجل ؟'))
                {
                   document.srvyHousingForm.tblId.value = 'car';
                   document.srvyHousingForm.carNo.value = carNo;
                   document.srvyHousingForm.tblOprType.value = 'D';
                   funSubmit();
                }
        }
  
    function funSubmit()
    {
       window.srvyHousingForm.submit();
       return true;
    }


    function showHideDivBldng(divIdV,divIdH ,p_oprType)
    {
       document.srvyHousingForm.tblId.value = 'bldng';
       document.getElementById(divIdV).style.display="inline";
       document.getElementById(divIdH).style.display="none";
       document.srvyHousingForm.tblOprType.value = p_oprType;

       if(p_oprType == 'U')
       {
           document.getElementById('divTitleBldng').innerHTML='تعديل';
       }
       else if(p_oprType == 'I')
       {
           document.getElementById('divTitleBldng').innerHTML='اضافة حقل جديد'  ;
           document.srvyHousingForm.bldngNo.value = '';
           document.srvyHousingForm.bldngType.value = '';
           document.srvyHousingForm.bldngCount.value = '';
           document.srvyHousingForm.bldngUsage.value = '';
           document.srvyHousingForm.bldngPlace.value = '';
       }
    }

    function showHideDivLand(divIdV,divIdH ,p_oprType)
    {
       document.srvyHousingForm.tblId.value = 'land';
       document.getElementById(divIdV).style.display="inline";
       document.getElementById(divIdH).style.display="none";
       document.srvyHousingForm.tblOprType.value = p_oprType;

       if(p_oprType == 'U')
       {
           document.getElementById('divTitleLand').innerHTML='تعديل';
       }
       else if(p_oprType == 'I')
       {
           document.getElementById('divTitleLand').innerHTML='اضافة حقل جديد'  ;
           document.srvyHousingForm.landType.value = '';
           document.srvyHousingForm.landArea.value = '';
           document.srvyHousingForm.landUsage.value = '';
           document.srvyHousingForm.landPalce.value = ''; 
       }
    }

    function showHideDivCar(divIdV,divIdH ,p_oprType)
    {
       document.srvyHousingForm.tblId.value = 'car';
       document.getElementById(divIdV).style.display="inline";
       document.getElementById(divIdH).style.display="none";
       document.srvyHousingForm.tblOprType.value = p_oprType;

       if(p_oprType == 'U')
       {
           document.getElementById('divTitleCar').innerHTML='تعديل';
       }
       else if(p_oprType == 'I')
       {
           document.getElementById('divTitleCar').innerHTML='اضافة حقل جديد'  ;
           document.srvyHousingForm.carNo.value = '';
           document.srvyHousingForm.carType.value = '';
           document.srvyHousingForm.carYear.value = '';
           document.srvyHousingForm.carCount.value = '';
       }

    }

    function editRecordBldng(bldngPlace,bldngUsage,bldngCount,bldngType,bldngNo)
    {
            document.srvyHousingForm.tblId.value = 'bldng';
            document.srvyHousingForm.tblOprType.value = 'U';
            document.srvyHousingForm.bldngNo.value = bldngNo;
            document.srvyHousingForm.bldngType.value = bldngType;
            document.srvyHousingForm.bldngCount.value = bldngCount;
            document.srvyHousingForm.bldngUsage.value = bldngUsage;
            document.srvyHousingForm.bldngPlace.value = bldngPlace;
    }

    function editRecordLand(landCount,landType,landArea,landUsage,landPalce)
    {
            document.srvyHousingForm.tblId.value = 'land';
            document.srvyHousingForm.tblOprType.value = 'U';
            document.srvyHousingForm.landCount.value = landCount;
            document.srvyHousingForm.landType.value = landType;
            document.srvyHousingForm.landArea.value = landArea;
            document.srvyHousingForm.landUsage.value = landUsage;
            document.srvyHousingForm.landPalce.value = landPalce;
    }

   function editRecordCar(carNo,carType,carYear,carCount)
    {
            document.srvyHousingForm.tblId.value = 'car';
            document.srvyHousingForm.tblOprType.value = 'U';
            document.srvyHousingForm.carNo.value = carNo;
            document.srvyHousingForm.carType.value = carType;
            document.srvyHousingForm.carYear.value = carYear;
            document.srvyHousingForm.carCount.value = carCount;
    }


    function hasFamilyBuildingFun()
    {

        var selected_list =document.srvyHousingForm.hasFamilyBuilding;
        var selected_value;
        for(var i = 0; i < selected_list.length; i++)
        {
            if(selected_list[i].checked)
            {
             selected_value = selected_list[i].value;
            }
        }

        if(selected_value == 'Y')
        {
           document.getElementById("bldngDiv").style.display="inline";
        }
        else
        {
            document.getElementById("bldngDiv").style.display="none";
        }

    }

    function hasFamilyLandFun()
    {

        var selected_list =document.srvyHousingForm.hasFamilyLand;
        var selected_value;
        for(var i = 0; i < selected_list.length; i++)
        {
            if(selected_list[i].checked)
            {
             selected_value = selected_list[i].value;
            }
        }

        if(selected_value == 'Y')
        {
           document.getElementById("landDiv").style.display="inline";
        }
        else
        {
            document.getElementById("landDiv").style.display="none";
        }

    }

    function hasFamilyCarFun()
    {

        var selected_list =document.srvyHousingForm.hasFamilyCar;
        var selected_value;
        for(var i = 0; i < selected_list.length; i++)
        {
            if(selected_list[i].checked)
            {
             selected_value = selected_list[i].value;
            }
        }

        if(selected_value == 'Y')
        {
           document.getElementById("carDiv").style.display="inline";
        }
        else
        {
            document.getElementById("carDiv").style.display="none";
        }

    }
     </script>

 </head>
 <BODY  bgcolor="#FFFFFF"  topmargin="0"  valign=center   >
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

 <html:form  action="saveStudSocialHousingInfo.do"  method="post"    >
     <html:hidden property="carNo"       />
     <html:hidden property="landCount"   />
     <html:hidden property="bldngNo"     />
     <html:hidden property="tblId"       />
     <html:hidden property="tblOprType"  />

    <tr>
      <td>
          <table width="100%" align="center" class="qou" border="0" cellpadding="0" cellspacing="0">

                <tr>
                    <td  >
                        <table width="100%" align="center" class="qou" border="0" cellpadding="3" cellspacing="0">
                          <tr class="tableRowClearColor">
                            <td   align="right" class="qouRtl"  valign="bottom"  >  &nbsp;</td>
                            <td   align="right" class="qouRtl"  valign="bottom"  >

                                <html:radio property="livePlace" tabindex="<%=String.valueOf(tabindex++)%>"   onclick="familyHasInsuranceFun()"    value="fm"    />مع الأهل
                                &nbsp;
                                <html:radio property="livePlace" tabindex="<%=String.valueOf(tabindex++)%>"   onclick="familyHasInsuranceFun()"  value="rl"    />مع الأقارب
                                &nbsp;
                                <html:radio property="livePlace" tabindex="<%=String.valueOf(tabindex++)%>"   onclick="familyHasInsuranceFun()"    value="rn"    />بالإيجار
                                &nbsp;
                            </td>
                            <td   align="right"   class="qou9BoldRtl">6.1	أين تسكن خلال دراستك في الجامعة؟	</td>

                        </tr>
                         <tr class="tableRowClearColor">
                           <td align="right" class="qouRtl"  valign="bottom" >
                             <html:text   property="liveRentCost"  maxlength="100" styleClass="largeInput" tabindex="<%=String.valueOf(tabindex++)%>" />
                           </td>
                           <td   align="right" class="qouRtl"  valign="bottom"  >
                             1- قيمة الإيجار الشهري بالشيقل الإسرائيلي
                           </td>
                           <td   align="left" class="qouRtl"  valign="bottom"  > 
                              إذا كنت مستأجراً لبيت، فأذكر:  
                           </td>
                         </tr>
                            <tr class="tableRowClearColor">
                           <td align="right" class="qouRtl"  valign="bottom" >
                            <html:radio property="isLiveShare" tabindex="<%=String.valueOf(tabindex++)%>"   onclick="familyHasInsuranceFun()"  value="Y"    />نعم
                            &nbsp;
                            <html:radio property="isLiveShare" tabindex="<%=String.valueOf(tabindex++)%>"   onclick="familyHasInsuranceFun()"    value="N"    />لا
                            &nbsp;
                           </td>
                           <td   align="right" class="qouRtl"  valign="bottom"  >
2- هل تشارك البيت مع طلبة آخرين
                           </td>
                           <td   align="right" class="qouRtl"  valign="bottom"  >  &nbsp;</td>
                         </tr>
                         <tr><td colspan="3" >&nbsp;</td></tr>
                         <tr class="tableRowClearColor">
                            <td   align="right" colspan="3"   class="qou9BoldRtl">6.2	ما نوع المنزل الذي تسكنه عائلتك؟  (جديد عمره عشر سنوات أو أقل)  أو (قديم عمره أكثر من عشر سنوات)</td>
                         </tr>
                         <tr>
                             <td    align="right" class="qouRtl"  valign="middle">
                               <html:text   property="liveNoRoom"  maxlength="100" styleClass="largeInput" tabindex="<%=String.valueOf(tabindex++)%>" />
                             </td>
                             <td   align="center" class="qouRtl"  valign="middle">
                              عدد الغرف (ما عدا المطبخ والحمام)
                             </td>
                             <td  align="center" class="qouRtl"  valign="bottom">
                             <table width="80%"  align="center" class="qouRtl" border="0" cellpadding="0" cellspacing="0"><tr>
                             <td width="25%"  align="right" class="qouRtl" ><html:radio property="liveHouseType" tabindex="<%=String.valueOf(tabindex++)%>"   onclick="familyHasInsuranceFun()"  value="on"    />ملك</td>
                             <td width="25%"  align="right" class="qouRtl" ><html:radio property="liveHouseType" tabindex="<%=String.valueOf(tabindex++)%>"   onclick="familyHasInsuranceFun()"  value="rn"    />مستأجر</td>
                             <td width="25%"  align="right" class="qouRtl" ><html:radio property="liveIsOld" tabindex="<%=String.valueOf(tabindex++)%>"   onclick="familyHasInsuranceFun()"    value="Y"    />قديم</td>
                             <td width="25%"  align="right" class="qouRtl" ><html:radio property="liveIsOld" tabindex="<%=String.valueOf(tabindex++)%>"   onclick="familyHasInsuranceFun()"  value="N"    />جديد</td>
                             </tr></table>
                             </td>
                         </tr>

                       </table>
                    </td>
                </tr>
               <tr>
                   <td align="right" >
                       <table width="80%" align="right" class="qou" border="0" cellpadding="2" cellspacing="2">
                       <tr>
                           <td colspan="2"  align="right">
                             <html:text   property="liveHouseCost"  maxlength="100" styleClass="largeInput" tabindex="<%=String.valueOf(tabindex++)%>" />
                           </td>
                           <td colspan="2" align="right">
                            	إذا كان البيت بالإيجار، ما قيمة الإيجار الشهري بالشيقل الاسرائيلي؟
                           </td>
                           <td   align="center">
                             <lu><li></li></lu>  
                           </td>
                       </tr>
                          <tr>
                               <td align="right" width="24%" class="qou"><html:text   property="liveOwnerPhone"  maxlength="100" styleClass="largeInput" tabindex="<%=String.valueOf(tabindex++)%>" /></td>
                               <td align="center" width="24%" class="qou">رقم الهاتف </td>
                               <td align="right" width="24%" class="qou"><html:text   property="liveOwnerName"  maxlength="100" styleClass="largeInput" tabindex="<%=String.valueOf(tabindex++)%>" /></td>
                               <td align="right" width="24%" class="qouRtl">	اسم صاحب المنزل (المالك) </td>
                               <td align="center" width="5%"><lu><li></li></lu></td>
                          </tr>
                          <tr>
                              <td colspan="4" align="right" class="qourtl">	عنوان المنزل:</td>
                              <td align="center" ><lu><li></li></lu></td>
                          </tr>
                           <tr>
                               <td colspan="6"  align="left" >
                                <table width="95%" align="left" class="qou" border="0" cellpadding="3" cellspacing="0">
                                <tr>
                                    <td  align="right" width="16%" class="qou"><html:text   property="liveHousePob"  maxlength="100" styleClass="largeInput" tabindex="<%=String.valueOf(tabindex++)%>" /></td>
                                    <td  align="center" width="16%" class="qou">ص.ب</td>
                                    <td  align="right" width="16%" class="qou"><html:text   property="liveHouseTown"  maxlength="100" styleClass="largeInput" tabindex="<%=String.valueOf(tabindex++)%>" /></td>
                                    <td  align="center" width="16%" class="qou">مدينة/قرية/مخيم </td>
                                    <td  align="right" width="16%" class="qou">
                                        <%--<html:text   property="liveHouseDistrict"  maxlength="100" styleClass="largeInput" tabindex="<%=String.valueOf(tabindex++)%>" />--%>
                                        <html:select property="liveHouseDistrict"  tabindex="<%=String.valueOf(tabindex+1)%>" styleClass="largeInput" >  <html:option value="*">اختر</html:option><logic:present name="governateList"><html:options collection="governateList" property="value"  labelProperty="label"/></logic:present> </html:select>
                                    </td>
                                    <td  align="right" width="16%" class="qou">	المحافظة</td>
                                    <td align="center" width="4%"><lu><li></li></lu></td>
                                </tr>

                                <tr>
                                   <td align="right"  class="qou" colspan="3"><html:text   property="liveHousePhone"  maxlength="100" styleClass="largeInput" tabindex="<%=String.valueOf(tabindex++)%>" /></td>
                                   <td align="center"  class="qou">رقم الهاتف </td>
                                   <td align="right"   class="qou"><html:text   property="liveHouseStreet"  maxlength="100" styleClass="largeInput" tabindex="<%=String.valueOf(tabindex++)%>" /></td>
                                   <td align="right"  class="qouRtl">	الشارع </td>
                                   <td align="center" ><lu><li></li></lu></td>
                                </tr>
                                </table>
                               </td>

                           </tr>

                       </table>
                   </td>
               </tr>
              <tr>
                  <td>
                      <table width="100%" align="center" class="qou" border="0" cellpadding="3" cellspacing="0">
                          <tr class="tableRowClearColor">
                             <td  width="60%"   align="right" class="qouRtl"  valign="bottom"  >

                                <html:radio property="hasFamilyBuilding" tabindex="<%=String.valueOf(tabindex++)%>"   onclick="hasFamilyBuildingFun()"    value="Y"    /> نعم
                                &nbsp;
                                <html:radio property="hasFamilyBuilding" tabindex="<%=String.valueOf(tabindex++)%>"   onclick="hasFamilyBuildingFun()"  value="N"    /> لا
                                &nbsp;
                            </td>
                            <td width="40%"   align="right"   class="qou9BoldRtl">6.3	هل تملك عائلتك عقارات؟  وما طبيعة هذه العقارات؟</td>

                        </tr>
                      </table>
                  </td>
              </tr>
              <tr>
                  <td>

                        <div id="bldngDiv" >
                            <div id="viewBldngDiv">
                            <logic:present name="retListBldng">
                            <% int i = 1; %>
                            <br/>
                            <table width="100%" border="0" cellspacing="0" cellpadding="0" class="borderRoundedClearColor" bgcolor="#f38e00">
                            <tr class="tabheader">
                            <td width="10%">&nbsp;</td>
                            <td width="20%"><div align="center">الموقع</div></td>
                            <td width="30%"><div dir="rtl" align="center">الاستخدام (سكن، إيجار،...الخ)</div></td>
                            <td width="5%"><div align="center">العدد</div></td>
                            <td width="30%"><div align="center">نوع العقار</div></td>
                            <td width="5%"><div align="center">&nbsp;</div></td>
                            </tr>
                            <logic:iterate id="retListBldng" name="retListBldng" >
                            <%  if (i%2 == 0) { %>
                            <tr  class="tableRowClearColor"  onMouseOver="this.className='highlight'" onMouseOut="this.className='tableRowClearColor'">

                            <%}else {%>
                            <tr class="tableRowLightColor"  onMouseOver="this.className='highlight'" onMouseOut="this.className='tableRowLightColor'">
                            <%}%>
                            <td align="center">
                            <a  href="javascript:confirmDeleteRecordBldng('<bean:write name="retListBldng" property="comp_id.bldngNo"/>')" title="حذف"><img src="/pages/resources/images/recDelete.gif" border="0" alt="حذف"  width="20" height="20"/></a>
                            &nbsp;
                            <a href="javascript:showHideDivBldng('addBldngDiv','viewBldngDiv','U'); editRecordBldng('<bean:write name="retListBldng" property="bldngPlace"/>','<bean:write name="retListBldng" property="bldngUsage"  />','<bean:write name="retListBldng" property="bldngCount"/>','<bean:write name="retListBldng" property="bldngType"/>','<bean:write name="retListBldng" property="comp_id.bldngNo"/>'); " title="تعديل"><img src="/pages/resources/images/recEdit.gif" border="0" alt="تعديل" width="20" height="20"/></a>

                            &nbsp;
                            </td>
                            <td class="qou"><div align="center"><bean:write name="retListBldng" property="bldngPlace"/></div></td>
                            <td class="qou"><div align="center"><bean:write name="retListBldng" property="bldngUsage"   /></div></td>
                            <td class="qou"><div align="center"><bean:write name="retListBldng" property="bldngCount"/></div></td>
                            <td class="qou"><div align="center">
                                <logic:equal name="retListBldng" property="bldngType" value="1"> منزل للسكن</logic:equal>
                                <logic:equal name="retListBldng" property="bldngType" value="2"> شقق للإيجار</logic:equal>
                                <logic:equal name="retListBldng" property="bldngType" value="3"> محلات خاصة</logic:equal>
                                <logic:equal name="retListBldng" property="bldngType" value="4">محلات للإيجار </logic:equal>
                                <logic:equal name="retListBldng" property="bldngType" value="5">غير ذلك </logic:equal>
                            </div></td>
                            <td class="qou"><div align="center"><%=i%></div></td>
                            </tr>
                            <% i++; %>
                            </logic:iterate>
                            <tr><td colspan="7" align="center">&nbsp;<a class="tabheaderBorderFullRounded" href="javascript:showHideDivBldng('addBldngDiv','viewBldngDiv','I');">اضافة حقل جديد</a></td></tr>
                            </table>
                            </logic:present>
                            <logic:notPresent name="retListBldng">
                            <table width="100%" border="0" cellspacing="0" cellpadding="0"  >
                            <tr><td>&nbsp;</td></tr>
                            <tr><td align="center" class="tableRowLightColor textDate"> لا توجد بيانات - <a  href="javascript:showHideDivBldng('addBldngDiv','viewBldngDiv','I');">اضغط هنا للاضافة</a></td></tr>
                            <tr><td>&nbsp;</td></tr>
                            </table>
                            </logic:notPresent>
                            </div>
                        <div id="addBldngDiv" style="display:none;">
                        <br/>
                        <table width="95%" align="center" class="borderRoundedClearColor" border="0" cellpadding="0" cellspacing="0">
                        <tr>
                        <td colspan="4" class="tabHeaderBigColor" align="center"> <div id="divTitleBldng"> </div></td>
                        </tr>
                        <tr class="tableRowLightColor">
                        <td align="right" width="20%"><html:text   property="bldngCount"   maxlength="100" styleClass="largeInput"  tabindex="<%=String.valueOf(tabindex++)%>" /></td>
                        <td align="right" width="30%" class="qou9Bold">العدد</td>
                        <td align="right" width="20%">
                            <html:select property="bldngType"  tabindex="<%=String.valueOf(tabindex++)%>" styleClass="largeInput"  >
                                <html:option value="1">منزل للسكن</html:option>
                                <html:option value="2">شقق للإيجار</html:option>
                                <html:option value="3">محلات خاصة</html:option>
                                <html:option value="4">محلات للإيجار</html:option>
                                <html:option value="5">غير ذلك </html:option>
                            </html:select>
                        </td>
                        <td align="right" width="30%" class="qou9Bold">نوع العقار</td>
                        </tr>
                        <tr>
                        <td align="right" ><html:text property="bldngPlace"  tabindex="<%=String.valueOf(tabindex++)%>" styleClass="largeInput"  /> </td>
                        <td align="right" class="qou9Bold">الموقع</td>
                        <td align="right" ><html:text property="bldngUsage"     tabindex="<%=String.valueOf(tabindex+2)%>" styleClass="largeInput"/>  </td>
                        <td align="right" class="qou9BoldRtl" >الاستخدام (سكن، إيجار،...الخ)</td>
                        </tr>
                        <tr  >
                        <td  align="center" colspan="4">
                        <input type="button" value=" &nbsp;&nbsp;&nbsp; الغاء  &nbsp;&nbsp;&nbsp;" class="enter"  tabindex="<%=String.valueOf(tabindex++)%>" onclick="javascript:showHideDivBldng('viewBldngDiv','addBldngDiv','');" >&nbsp;
                        <input type="button" value=" &nbsp;&nbsp;&nbsp; حفظ  &nbsp;&nbsp;&nbsp;" class="enter"  tabindex="<%=String.valueOf(tabindex++)%>"   onclick="funSubmit();">&nbsp;
                        </td>
                        </tr>
                        </table>
                        </div>
                        </div>
                  </td>
              </tr>
                <tr><td>&nbsp;</td></tr>
              <tr>
                  <td>
                      <table width="100%" align="center" class="qou" border="0" cellpadding="3" cellspacing="0">
                          <tr class="tableRowClearColor">
                             <td  width="60%"   align="right" class="qouRtl"  valign="bottom"  >

                                <html:radio property="hasFamilyLand" tabindex="<%=String.valueOf(tabindex++)%>"   onclick="hasFamilyLandFun()"    value="Y"    /> نعم
                                &nbsp;
                                <html:radio property="hasFamilyLand" tabindex="<%=String.valueOf(tabindex++)%>"   onclick="hasFamilyLandFun()"  value="N"    /> لا
                                &nbsp;
                            </td>
                            <td width="40%"   align="right"   class="qou9BoldRtl">6.4	هل لدى عائلتك أراضٍ؟</td>

                        </tr>
                      </table>
                  </td>
              </tr>
              <tr>
                  <td>
                        <div id="landDiv" >
                            <div id="viewLandDiv">
                            <logic:present name="retListLand">
                            <% int i = 1; %>
                            <br/>
                            <table width="100%" border="0" cellspacing="0" cellpadding="0" class="borderRoundedClearColor" bgcolor="#f38e00">
                            <tr class="tabheader">
                            <td width="10%">&nbsp;</td>
                            <td width="20%"><div align="center">الموقع</div></td>
                            <td width="30%"><div dir="rtl" align="center">الاستخدام (زراعية، غير زراعية)</div></td>
                            <td width="5%"><div align="center">المساحة</div></td>
                            <td width="30%"><div align="center">نوع الأرض </div></td>
                            <td width="5%"><div align="center">&nbsp;</div></td>
                            </tr>
                            <logic:iterate id="retListLand" name="retListLand" >
                            <%  if (i%2 == 0) { %>
                            <tr  class="tableRowClearColor"  onMouseOver="this.className='highlight'" onMouseOut="this.className='tableRowClearColor'">

                            <%}else {%>
                            <tr class="tableRowLightColor"  onMouseOver="this.className='highlight'" onMouseOut="this.className='tableRowLightColor'">
                            <%}%>
                            <td align="center">
                            <a  href="javascript:confirmDeleteRecordLand('<bean:write name="retListLand" property="comp_id.landCount"/>')" title="حذف"><img src="/pages/resources/images/recDelete.gif" border="0" alt="حذف"  width="20" height="20"/></a>
                            &nbsp;
                            <a href="javascript:showHideDivLand('addLandDiv','viewLandDiv','U'); editRecordLand('<bean:write name="retListLand" property="comp_id.landCount"/>','<bean:write name="retListLand" property="landType"  />','<bean:write name="retListLand" property="landArea"/>','<bean:write name="retListLand" property="landUsage"/>','<bean:write name="retListLand" property="landPalce"/>'); " title="تعديل"><img src="/pages/resources/images/recEdit.gif" border="0" alt="تعديل" width="20" height="20"/></a>

                            &nbsp;
                            </td>
                            <td class="qou"><div align="center"><bean:write name="retListLand" property="landPalce"/></div></td>
                            <td class="qou"><div align="center">
                                <logic:equal name="retListLand" property="landUsage" value="ag"> زراعية</logic:equal>
                                <logic:equal name="retListLand" property="landUsage" value="or">غير زراعية</logic:equal>
                            </div></td>
                            <td class="qou"><div align="center"><bean:write name="retListLand" property="landArea"   /></div></td>
                            <td class="qou"><div align="center"><bean:write name="retListLand" property="landType"/></div></td>
                            <td class="qou"><div align="center"><%=i%></div></td>
                            </tr>
                            <% i++; %>
                            </logic:iterate>
                            <tr><td colspan="7" align="center">&nbsp;<a class="tabheaderBorderFullRounded" href="javascript:showHideDivLand('addLandDiv','viewLandDiv','I');">اضافة حقل جديد</a></td></tr>
                            </table>
                            </logic:present>
                            <logic:notPresent name="retListLand">
                            <table width="100%" border="0" cellspacing="0" cellpadding="0"  >
                            <tr><td>&nbsp;</td></tr>
                            <tr><td align="center" class="tableRowLightColor textDate"> لا توجد بيانات - <a  href="javascript:showHideDivLand('addLandDiv','viewLandDiv','I');">اضغط هنا للاضافة</a></td></tr>
                            <tr><td>&nbsp;</td></tr>
                            </table>
                            </logic:notPresent>
                            </div>
                        <div id="addLandDiv" style="display:none;">
                         <br/>
                        <table width="95%" align="center" class="borderRoundedClearColor" border="0" cellpadding="0" cellspacing="0">
                        <tr>
                        <td colspan="4" class="tabHeaderBigColor" align="center"> <div id="divTitleLand"> </div></td>
                        </tr>
                        <tr class="tableRowLightColor">
                        <td align="right" width="20%"><html:text   property="landArea"   maxlength="100" styleClass="largeInput"  tabindex="<%=String.valueOf(tabindex++)%>" /></td>
                        <td align="right" width="30%" class="qou9Bold">المساحة</td>
                        <td align="right" width="20%">
                          <html:text   property="landType"   maxlength="100" styleClass="largeInput"  tabindex="<%=String.valueOf(tabindex++)%>" />
                        </td>
                        <td align="right" width="30%" class="qou9Bold">نوع الأرض </td>
                        </tr>
                        <tr>
                        <td align="right" ><html:text property="landPalce"  tabindex="<%=String.valueOf(tabindex++)%>" styleClass="largeInput"  /> </td>
                        <td align="right" class="qou9Bold">الموقع</td>
                        <td align="right" >
                             <html:select property="landUsage"  tabindex="<%=String.valueOf(tabindex++)%>" styleClass="largeInput"  >
                                <html:option value="ag"> زاعية</html:option>
                                <html:option value="or">غير زراعية </html:option>
                            </html:select>
                        </td>
                        <td align="right" class="qou9BoldRtl" >الاستخدام (زراعية، غير زراعية)</td>
                        </tr>
                        <tr  >
                        <td  align="center" colspan="4">
                        <input type="button" value=" &nbsp;&nbsp;&nbsp; الغاء  &nbsp;&nbsp;&nbsp;" class="enter"  tabindex="<%=String.valueOf(tabindex++)%>" onclick="javascript:showHideDivLand('viewLandDiv','addLandDiv','')" >&nbsp;
                        <input type="button" value=" &nbsp;&nbsp;&nbsp; حفظ  &nbsp;&nbsp;&nbsp;" class="enter"  tabindex="<%=String.valueOf(tabindex++)%>"   onclick="javascript:funSubmit();">&nbsp;
                        </td>
                        </tr>
                        </table>
                        </div>
                        </div>
                  </td>
              </tr>

             <tr><td>&nbsp;</td></tr>
              <tr>
                  <td>
                      <table width="100%" align="center" class="qou" border="0" cellpadding="3" cellspacing="0">
                          <tr class="tableRowClearColor">
                             <td  width="60%"   align="right" class="qouRtl"  valign="bottom"  >

                                <html:radio property="hasFamilyCar" tabindex="<%=String.valueOf(tabindex++)%>"   onclick="hasFamilyCarFun()"    value="Y"    /> نعم
                                &nbsp;
                                <html:radio property="hasFamilyCar" tabindex="<%=String.valueOf(tabindex++)%>"   onclick="hasFamilyCarFun()"  value="N"    /> لا
                                &nbsp;
                            </td>
                            <td width="40%"   align="right"   class="qou9BoldRtl">6.5	هل لدى العائلة (بما فيهم الأخوة/الأخوات) أي نوع من السيارات؟</td>

                        </tr>
                      </table>
                  </td>
              </tr>
              <tr>
                  <td>
                       <div id="carDiv" >
                            <div id="viewCarDiv">
                            <logic:present name="retListCar">
                            <% int i = 1; %>
                            <br/>
                            <table width="100%" border="0" cellspacing="0" cellpadding="0" class="borderRoundedClearColor" bgcolor="#f38e00">
                            <tr class="tabheader">
                            <td width="10%">&nbsp;</td>
                            <td width="30%"><div dir="rtl" align="center">سنة الإنتاج (الموديل)</div></td>
                            <td width="30%"><div align="center">نوع السيارة </div></td>
                            <td width="25%"><div align="center">العدد </div></td>
                            <td width="5%"><div align="center">&nbsp;</div></td>
                            </tr>
                            <logic:iterate id="retListCar" name="retListCar" >
                            <%  if (i%2 == 0) { %>
                            <tr  class="tableRowClearColor"  onMouseOver="this.className='highlight'" onMouseOut="this.className='tableRowClearColor'">

                            <%}else {%>
                            <tr class="tableRowLightColor"  onMouseOver="this.className='highlight'" onMouseOut="this.className='tableRowLightColor'">
                            <%}%>
                            <td align="center">
                            <a  href="javascript:confirmDeleteRecordCar('<bean:write name="retListCar" property="comp_id.carNo"/>')" title="حذف"><img src="/pages/resources/images/recDelete.gif" border="0" alt="حذف"  width="20" height="20"/></a>
                            &nbsp;
                            <a href="javascript:showHideDivCar('addCarDiv','viewCarDiv','U'); editRecordCar('<bean:write name="retListCar" property="comp_id.carNo"/>','<bean:write name="retListCar" property="carType"  />','<bean:write name="retListCar" property="carYear"/>','<bean:write name="retListCar" property="carCount"/>' ); " title="تعديل"><img src="/pages/resources/images/recEdit.gif" border="0" alt="تعديل" width="20" height="20"/></a>

                            &nbsp;
                            </td>
                            <td class="qou"><div align="center"><bean:write name="retListCar" property="carYear"/></div></td>
                            <td class="qou"><div align="center"><bean:write name="retListCar" property="carType"   /></div></td>
                            <td class="qou"><div align="center"><bean:write name="retListCar" property="carCount"/></div></td>
                            <td class="qou"><div align="center"><%=i%></div></td>
                            </tr>
                            <% i++; %>
                            </logic:iterate>
                            <tr><td colspan="7" align="center">&nbsp;<a class="tabheaderBorderFullRounded" href="javascript:showHideDivCar('addCarDiv','viewCarDiv','I');">اضافة حقل جديد</a></td></tr>
                            </table>
                            </logic:present>
                            <logic:notPresent name="retListCar">
                            <table width="100%" border="0" cellspacing="0" cellpadding="0"  >
                            <tr><td>&nbsp;</td></tr>
                            <tr><td align="center" class="tableRowLightColor textDate"> لا توجد بيانات - <a  href="javascript:showHideDivCar('addCarDiv','viewCarDiv','I');">اضغط هنا للاضافة</a></td></tr>
                            <tr><td>&nbsp;</td></tr>
                            </table>
                            </logic:notPresent>
                            </div>
                        <div id="addCarDiv" style="display:none;">
                        <br/>
                        <table width="95%" dir="ltr" align="center" class="borderRoundedClearColor" border="0" cellpadding="0" cellspacing="0">
                        <tr>
                        <td colspan="6" class="tabHeaderBigColor" align="center"> <div id="divTitleCar"> </div></td>
                        </tr>
                        <tr class="tableRowLightColor">
                         <td align="right" width="20%"><html:text property="carYear"  tabindex="<%=String.valueOf(tabindex++)%>" styleClass="largeInput"  /> </td>
                         <td align="right" width="20%" class="qou9BoldRtl">سنة الإنتاج (الموديل)</td> 
                         <td align="right" width="20%"> <html:text   property="carType"   maxlength="100" styleClass="largeInput"  tabindex="<%=String.valueOf(tabindex++)%>" /> </td>
                         <td align="right" width="10%" class="qou9Bold">نوع السيارة </td> 
                         <td align="right" width="20%"><html:text   property="carCount"   maxlength="100" styleClass="largeInput"  tabindex="<%=String.valueOf(tabindex++)%>" /></td>
                         <td align="right" width="10%" class="qou9Bold">العدد </td>
                        </tr>
                        <tr  >
                        <td  align="center" colspan="6">
                        <input type="button" value=" &nbsp;&nbsp;&nbsp; الغاء  &nbsp;&nbsp;&nbsp;" class="enter"  tabindex="<%=String.valueOf(tabindex++)%>" onclick="javascript:showHideDivCar('viewCarDiv','addCarDiv','');" >&nbsp;
                        <input type="button" value=" &nbsp;&nbsp;&nbsp; حفظ  &nbsp;&nbsp;&nbsp;" class="enter"  tabindex="<%=String.valueOf(tabindex++)%>"   onclick="javascript:funSubmit();">&nbsp;
                        </td>
                        </tr>
                        </table>
                        </div>
                        </div>
                  </td>
              </tr>

              </table>
      </td>
    </tr>
     <tr><td>&nbsp;</td></tr>

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