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
            familyHasInsuranceFun();
            familyHasJerusalemFun();
            hasDisabilitiesFun();
            isFamilyHasChronicFun();
       };

  //--------------------------------------------------------
   function isFamilyHasChronicFun()
   {
        var rdio_list =document.srvyHealthDetailForm.isFamilyHasChronic;
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
            document.srvyHealthDetailForm.chronicName.className = 'largeInput';
            document.srvyHealthDetailForm.chronicName.readOnly  = false;
            document.srvyHealthDetailForm.medicalReport.className = 'largeInput';
            document.srvyHealthDetailForm.medicalReport.readOnly  = false;
            document.srvyHealthDetailForm.medicalReport.disabled  = false;
            document.srvyHealthDetailForm.patientRelative.className = 'largeInput';
            document.srvyHealthDetailForm.patientRelative.readOnly  = false;
            document.srvyHealthDetailForm.patientAge.className = 'largeInput';
            document.srvyHealthDetailForm.patientAge.readOnly  = false;
        }
        else if(selected_value == 'N')
        {
            document.srvyHealthDetailForm.chronicName.className = 'largeInputView';
            document.srvyHealthDetailForm.chronicName.value = ' ';
            document.srvyHealthDetailForm.chronicName.readOnly  = true;
            document.srvyHealthDetailForm.medicalReport.className = 'largeInputView';
            document.srvyHealthDetailForm.medicalReport.readOnly  = true;
            document.srvyHealthDetailForm.medicalReport.disabled  = true;
            document.srvyHealthDetailForm.patientRelative.className = 'largeInputView';
            document.srvyHealthDetailForm.patientRelative.value = ' ';
            document.srvyHealthDetailForm.patientRelative.readOnly  = true;
            document.srvyHealthDetailForm.patientAge.className = 'largeInputView';
            document.srvyHealthDetailForm.patientAge.value = ' ';
            document.srvyHealthDetailForm.patientAge.readOnly  = true;
        }

   }

   //--------------------------------------------------------
   function hasDisabilitiesFun()
   {
        var rdio_list =document.srvyHealthDetailForm.hasDisabilities;
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
            document.srvyHealthDetailForm.disabilitiesCount.className = 'largeInput';
            document.srvyHealthDetailForm.disabilitiesCount.readOnly  = false;
            document.srvyHealthDetailForm.disabilitiesDesc.className = 'largeInput';
            document.srvyHealthDetailForm.disabilitiesDesc.readOnly  = false;
        }
        else if(selected_value == 'N')
        {
            document.srvyHealthDetailForm.disabilitiesCount.className = 'largeInputView';
            document.srvyHealthDetailForm.disabilitiesCount.value = ' ';
            document.srvyHealthDetailForm.disabilitiesCount.readOnly  = true;
            document.srvyHealthDetailForm.disabilitiesDesc.className = 'largeInputView';
            document.srvyHealthDetailForm.disabilitiesDesc.value = ' ';
            document.srvyHealthDetailForm.disabilitiesDesc.readOnly  = true;
        }

   }

   //--------------------------------------------------------
   function familyHasJerusalemFun()
   {
        var rdio_list =document.srvyHealthDetailForm.familyHasJerusalem;
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
            document.srvyHealthDetailForm.jerFamilyMembers.className = 'largeInput';
            document.srvyHealthDetailForm.jerFamilyMembers.readOnly  = false;
        }
        else if(selected_value == 'N')
        {
            document.srvyHealthDetailForm.jerFamilyMembers.className = 'largeInputView';
            document.srvyHealthDetailForm.jerFamilyMembers.value = ' ';
            document.srvyHealthDetailForm.jerFamilyMembers.readOnly  = true;
        }

   }

   //--------------------------------------------------------

    function familyHasInsuranceFun()
    {
        var insurTypeList = document.srvyHealthDetailForm.insuranceType;
        var rdio_list =document.srvyHealthDetailForm.familyHasInsurance;
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
            for (var i=0 ; i< insurTypeList.length; i++)
            {
              insurTypeList[i].disabled = false;
            }
            document.srvyHealthDetailForm.insFamilyMembers.className = 'largeInput';
            document.srvyHealthDetailForm.insFamilyMembers.readOnly  = false;
        }
        else if(selected_value == 'N')
        {
            document.srvyHealthDetailForm.insFamilyMembers.className = 'largeInputView';
            document.srvyHealthDetailForm.insFamilyMembers.value = ' ';
            document.srvyHealthDetailForm.insFamilyMembers.readOnly  = true;

            for (var i=0; i< insurTypeList.length; i++)
            {
              insurTypeList[i].disabled = true;
              insurTypeList[i].checked=false;
            }
        }


    }

    //--------------------------------------------------------
     </script>

 </head>
 <BODY  bgcolor="#FFFFFF"  topmargin="0"  valign=center  >
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
   
 <html:form  action="saveStudSocialHealthDetail.do"  method="post"  enctype="multipart/form-data" >
     <%--<html:hidden property="relativeType" value="1"  />--%>

    <tr>
      <td>
          <table width="95%" align="center" class="qou" border="0" cellpadding="0" cellspacing="0">
                <tr class="tableRowClearColor">
                    <td   align="right" class="qouRtl"  valign="bottom"  >
                        <html:radio property="familyHasInsurance" tabindex="<%=String.valueOf(tabindex++)%>"   onclick="familyHasInsuranceFun()"  value="Y"    /> نعم
                        &nbsp;
                        <html:radio property="familyHasInsurance" tabindex="<%=String.valueOf(tabindex++)%>"   onclick="familyHasInsuranceFun()"    value="N"    /> لا
                        &nbsp;
                    </td>
                    <td   align="right" colspan="2" class="qou9BoldRtl">5.1	هل لدى العائلة تأمين صحي (في الضفة بما في ذلك القدس)؟</td>
                </tr>
                <tr>
                    <td width="50%"  class="qouRtl">
                          <html:radio property="insuranceType" tabindex="<%=String.valueOf(tabindex++)%>"   onclick="chngWrkStatus()"  value="1"    /> حكومي
                          &nbsp;
                          <html:radio property="insuranceType" tabindex="<%=String.valueOf(tabindex++)%>"   onclick="chngWrkStatus()"    value="2"    /> خاص
                          &nbsp;
                     </td>
                     <td width="20%" align="right" class="qouRtl" >ما نوع التأمين؟</td>
                     <td width="2%" align="right" class="qouRtl" valign="middle"  >  <lu><li></li></lu>   </td>
                </tr>
                <tr>
                     <td   align="right">
                       <html:text   property="insFamilyMembers"  maxlength="100" styleClass="largeInput" tabindex="<%=String.valueOf(tabindex++)%>" />
                     </td>
                     <td  align="right" class="qouRtl" >	إذا كان الجواب "بنعم"، فما عدد الأفراد الذين يشملهم التأمين؟ </td>
                     <td  align="right" class="qouRtl"  >  <lu><li></li></lu>  </td>
                </tr>
              </table>
      </td>
    </tr>
   <tr><td>&nbsp;</td></tr>
   <tr>
      <td>
          <table width="95%" align="center" class="qou" border="0" cellpadding="0" cellspacing="0">
                <tr class="tableRowClearColor">
                    <td   align="right" class="qouRtl"  valign="bottom"  >
                        <html:radio property="familyHasJerusalem" tabindex="<%=String.valueOf(tabindex++)%>"   onclick="familyHasJerusalemFun()"  value="Y"    /> نعم
                        &nbsp;
                        <html:radio property="familyHasJerusalem" tabindex="<%=String.valueOf(tabindex++)%>"   onclick="familyHasJerusalemFun()"    value="N"    /> لا
                        &nbsp;
                    </td>
                    <td   align="right" colspan="2" class="qou9BoldRtl">5.2 	هل لدى العائلة تأمين وطني (في القدس)؟</td>
                </tr> 
                <tr>
                     <td  width="28%"  align="right">
                       <html:text   property="jerFamilyMembers"  maxlength="100" styleClass="largeInput" tabindex="<%=String.valueOf(tabindex++)%>" />
                     </td>
                     <td width="20%"  align="right" class="qouRtl" >	إذا كان الجواب "بنعم"، فما عدد الأفراد الذين يشملهم التأمين؟ </td>
                     <td  width="2%" align="right" class="qouRtl"  >  <lu><li></li></lu>  </td>
                </tr>
              </table>
      </td>
    </tr>
     <tr><td>&nbsp;</td></tr>
    <tr>
      <td>
          <table width="95%" align="center" class="qou" border="0" cellpadding="1" cellspacing="1">
                <tr class="tableRowClearColor">
                    <td   align="right" class="qouRtl"  valign="bottom"  >
                        <html:radio property="isFamilyHasChronic" tabindex="<%=String.valueOf(tabindex++)%>"   onclick="isFamilyHasChronicFun()"  value="Y"    /> نعم
                        &nbsp;
                        <html:radio property="isFamilyHasChronic" tabindex="<%=String.valueOf(tabindex++)%>"   onclick="isFamilyHasChronicFun()"    value="N"    /> لا
                        &nbsp;
                    </td>
                    <td   align="right" colspan="2" class="qou9BoldRtl">5.3	هل هناك أحد في العائلة يعاني من أمراض مزمنة؟</td>
                </tr>
                <tr>
                     <td colspan="3" align="right" class="qouRtl" >	إذا كان الجواب "بنعم"، أذكر (في حالة المرض، على الطالب أن يرفق تقريراً طبياً):</td>
                 </tr>
              <tr>
                     <td   width="28%"  align="right">
                       <html:text   property="chronicName"  maxlength="100" styleClass="largeInput" tabindex="<%=String.valueOf(tabindex++)%>" />
                     </td>
                     <td   width="20%" align="right" class="qouRtl" >	اسم المريض/ المرضى: </td>
                     <td   width="2%"  align="right" class="qouRtl"  >  <lu><li></li></lu>  </td>
                </tr>
                <tr>
                     <td   align="right">
                       <html:text   property="patientAge"  maxlength="100" styleClass="largeInput" tabindex="<%=String.valueOf(tabindex++)%>" />
                     </td>
                     <td   align="right" class="qouRtl" >العمر :</td>
                     <td   align="right" class="qouRtl"  >  <lu><li></li></lu>  </td>
                </tr>
                <tr>
                     <td   align="right">
                       <html:text   property="patientRelative"  maxlength="100" styleClass="largeInput" tabindex="<%=String.valueOf(tabindex++)%>" />
                     </td>
                     <td   align="right" class="qouRtl" >طلة القرابة :</td>
                     <td   align="right" class="qouRtl"  >  <lu><li></li></lu>  </td>
                </tr>
                <tr>
                     <td   align="right">
                        <table width="95%" align="center" class="qou" border="0" cellpadding="1" cellspacing="1">
                         <tr>
                             <td width="50%" valign="bottom" class="centerpage" align="right">
                                 <logic:present name="showLink">
                                 <a target="_blank" class="enter" href="../../downloadSrvyAtt.do">اضغط هنا لاستعارض الملف المحمل</a>
                                 </logic:present>
                             </td>
                             <td width="50%"><div align="right">&nbsp;&nbsp;الحد الاقصى 10 ميغا&nbsp;&nbsp;<html:file property="medicalReport" styleClass="largeInput"/></div></td>
                         </tr>
                         </table>

                     </td>
                     <td   align="right" class="qouRtl" >التقرير الطبي :</td>
                     <td   align="right" class="qouRtl"  >  <lu><li></li></lu>  </td>
                </tr>
              </table>
      </td>
    </tr>
    <tr><td>&nbsp;</td></tr>
    <tr>
      <td>
          <table width="95%" align="center" class="qou" border="0" cellpadding="1" cellspacing="1">
                <tr class="tableRowClearColor">
                    <td   align="right" class="qouRtl"  valign="bottom"  >
                        <html:radio property="hasDisabilities" tabindex="<%=String.valueOf(tabindex++)%>"   onclick="hasDisabilitiesFun()"  value="Y"    /> نعم
                        &nbsp;
                        <html:radio property="hasDisabilities" tabindex="<%=String.valueOf(tabindex++)%>"   onclick="hasDisabilitiesFun()"    value="N"    /> لا
                        &nbsp;
                    </td>
                    <td   align="right" colspan="2" class="qou9BoldRtl"> 5.4	هل هناك إعاقات في العائلة؟</td>
                </tr>
                <tr>
                     <td colspan="3" align="right" class="qouRtl" >إذا كان الجواب "بنعم"، أذكر:  </td>
                 </tr>
              <tr>
                     <td   width="28%"  align="right">
                       <html:text   property="disabilitiesCount"  maxlength="100" styleClass="largeInput" tabindex="<%=String.valueOf(tabindex++)%>" />
                     </td>
                     <td   width="20%" align="right" class="qouRtl" >عدد المعاقين: </td>
                     <td   width="2%"  align="right" class="qouRtl"  >  <lu><li></li></lu>  </td>
                </tr>
                <tr>
                     <td   align="right">
                       <html:text   property="disabilitiesDesc"  maxlength="100" styleClass="largeInput" tabindex="<%=String.valueOf(tabindex++)%>" />
                     </td>
                     <td   align="right" class="qouRtl" >طبيعة الإعاقة:</td>
                     <td   align="right" class="qouRtl"  >  <lu><li></li></lu>  </td>
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