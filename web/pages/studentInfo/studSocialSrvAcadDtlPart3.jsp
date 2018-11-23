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

<script type="text/javascript">
       window.onload = function(){
        var cal_enroleDate     =  new Epoch('enroleDate','popup',document.studSocialSurveyAcadDtlForm.enroleDate);

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
            document.studSocialSurveyAcadDtlForm.relativeAName.value = '';
            document.studSocialSurveyAcadDtlForm.enroleDate.value = '';
            document.studSocialSurveyAcadDtlForm.collegeNo.value = '*';
            document.studSocialSurveyAcadDtlForm.countryNo.value = '*';
            document.studSocialSurveyAcadDtlForm.yearlyCost.value = '';
            document.studSocialSurveyAcadDtlForm.donarAName.value = '';
            document.studSocialSurveyAcadDtlForm.relativeStudNo.value = '';
       }
    }

    function editRecord(relativeAName_p,enroleDate_p,collegeNo_p,countryNo_p,yearlyCost_p,donarAName_p,relativeStudNo_p,academicSeq_p)
    {
        document.studSocialSurveyAcadDtlForm.relativeAName.value = relativeAName_p;
        document.studSocialSurveyAcadDtlForm.enroleDate.value = enroleDate_p;
        document.studSocialSurveyAcadDtlForm.collegeNo.value = collegeNo_p;
        document.studSocialSurveyAcadDtlForm.countryNo.value = countryNo_p;
        document.studSocialSurveyAcadDtlForm.yearlyCost.value = yearlyCost_p;
        document.studSocialSurveyAcadDtlForm.donarAName.value = donarAName_p;
        document.studSocialSurveyAcadDtlForm.relativeStudNo.value = relativeStudNo_p;
        document.studSocialSurveyAcadDtlForm.academicSeq.value = academicSeq_p;

    }
        function confirmDeleteRecord(academicSeq_p,relativeAName_p)
        {
                if(confirm('هل تريد حذف سجل - '+relativeAName_p+' ?'))
                {
                  document.studSocialSurveyAcadDtlForm.relativeAName.value = relativeAName_p;
                  document.studSocialSurveyAcadDtlForm.academicSeq.value = academicSeq_p;
                  document.studSocialSurveyAcadDtlForm.operType.value = '3';
                  document.studSocialSurveyAcadDtlForm.submit();
                  return true;
                }
        }


    function funSubmit()
    {
       document.studSocialSurveyAcadDtlForm.operType.value = oprTypeVal;
       document.studSocialSurveyAcadDtlForm.submit();
       return true;
    }

</script>
</HEAD>
<div align="center" >
<BODY  bgcolor="#FFFFFF"  topmargin="0"  valign=center>
<TABLE cellSpacing=0 cellPadding=0 width="966" align=center border=0 class="qou" dir="ltr" >
  <TBODY    >
    <tr>
      <td><table width="100%" cellspacing="0" cellpadding="0" border="0">
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
            <td width="60%" align="right" >
              <div class="textDate" align="right" dir="rtl">3.3  هل لديك أبناء/بنات يدرسون حالياً في الجامعات/الكليات المحلية أو خارج البلاد؟</div>
            </td>
          </tr>
          </table>
          <div id="dataDiv">
                        <logic:present name="srvAcadDtl">
                     <% int i = 0; %>
                            <br/>
                       <table width="100%" border="0" cellspacing="0" cellpadding="0" class="borderRoundedClearColor" bgcolor="#f38e00">
                          <tr class="tabheader">
                            <td width="10%">&nbsp;</td>
                            <td width="15%"><div align="center">الرقم الجامعي لطالب كلية دار الكلمة</div></td>
                            <td width="13%"><div align="center">من يسدد المصاريف الجامعية  (العائلة، مصادر أخرى)</div></td>
                            <td width="11%"><div align="center">التكلفة السنوية بالشيكل</div></td>
                            <td width="5%"><div align="center">الدولة</div></td>
                            <td width="6%"><div align="center">اسم الجامعة/الكلية</div></td>
                            <td width="5%"><div align="center">تاريخ الالتحاق بالجامعة/الكلية</div></td>
                            <td width="10%"><div align="center">الاسم</div></td>
                          </tr>
                     <logic:iterate id="srvAcadDtl" name="srvAcadDtl" >
                         <%  if (i%2 == 0) { %>
                               <tr  class="tableRowClearColor"  onMouseOver="this.className='highlight'" onMouseOut="this.className='tableRowClearColor'">

                          <%}else {%>
                                <tr class="tableRowLightColor"  onMouseOver="this.className='highlight'" onMouseOut="this.className='tableRowLightColor'">
                          <%}%>
                            <td align="center">
                            <a  href="javascript:confirmDeleteRecord('<bean:write name="srvAcadDtl" property="comp_id.academicSeq"/>','<bean:write name="srvAcadDtl" property="relativeAName"/>')" title="حذف"><img src="/pages/resources/images/recDelete.gif" border="0" alt="حذف"  width="20" height="20"/></a>
                            &nbsp;
                            <a href="javascript:showHideDiv('addEditDataDiv','dataDiv','2'); editRecord('<bean:write name="srvAcadDtl" property="relativeAName"/>','<bean:write name="srvAcadDtl" property="enroleDate" format="dd/MM/yyyy"/>','<bean:write name="srvAcadDtl" property="collegeNo"/>','<bean:write name="srvAcadDtl" property="countryNo"/>','<bean:write name="srvAcadDtl" property="yearlyCost"/>','<bean:write name="srvAcadDtl" property="donarAName"   />','<bean:write name="srvAcadDtl" property="relativeStudNo"/>','<bean:write name="srvAcadDtl" property="comp_id.academicSeq"/>'); " title="تعديل"><img src="/pages/resources/images/recEdit.gif" border="0" alt="تعديل" width="20" height="20"/></a>
                            &nbsp;
                            </td>
                            <td class="qou"><div align="center"><bean:write name="srvAcadDtl" property="relativeStudNo"/></div></td>
                            <td class="qou"><div align="center"><bean:write name="srvAcadDtl" property="donarAName"   /></div></td>
                            <td class="qou"><div align="center"><bean:write name="srvAcadDtl" property="yearlyCost"/></div></td>
                            <td class="qou"><div align="center"><bean:write name="srvAcadDtl" property="countryAName"/></div></td>
                            <td class="qou"><div align="center"><bean:write name="srvAcadDtl" property="ucAName"/></div></td>
                             <td class="qou"><div align="right"><bean:write name="srvAcadDtl" property="enroleDate" format="dd/MM/yyyy"/></div></td>
                            <td class="qou"><div align="center"><bean:write name="srvAcadDtl" property="relativeAName"/> </div></td>
                          </tr>
                      <% i++; %>
                     </logic:iterate>
                       <tr><td colspan="7" align="center">&nbsp;<a class="tabheaderBorderFullRounded" href="javascript:showHideDiv('addEditDataDiv','dataDiv','1');">اضافة حقل جديد</a></td></tr>
                     </table>
                     </logic:present>
              <logic:notPresent name="srvAcadDtl">
                <table width="100%" border="0" cellspacing="0" cellpadding="0"  >
                <tr><td>&nbsp;</td></tr>
                <tr><td align="center" class="tableRowLightColor textDate"> لا توجد بيانات - <a  href="javascript:showHideDiv('addEditDataDiv','dataDiv','1');">اضغط هنا للاضافة</a></td></tr>
                <tr><td>&nbsp;</td></tr>
                </table>
              </logic:notPresent>



          </div>

      </td>
    </tr>
     <html:form  action="saveStudSrvyAcadDtl.do"  method="post"  >
     <html:hidden property="relativeType" value="3"  />
     <html:hidden property="operType"     />
     <html:hidden property="academicSeq"  />

     <tr>
      <td>
          <div id="addEditDataDiv" style="display:none;">
              <br/>
            <table width="95%" align="center" class="borderRoundedClearColor" border="0" cellpadding="0" cellspacing="0">
                <tr>
                    <td colspan="4" class="tabHeaderBigColor" align="center"> <div id="divTitle"> </div></td>
                </tr>
                <tr class="tableRowLightColor">
                    <td align="right" width="20%"><html:text   property="enroleDate"   maxlength="100" styleClass="largeInputView" readonly="true" tabindex="<%=String.valueOf(tabindex++)%>" /></td>
                    <td align="right" width="35%" class="qou9Bold">تاريخ الالتحاق بالجامعة/الكلية</td>
                    <td align="right" width="17%"><html:text   property="relativeAName"   maxlength="100" styleClass="largeInput" tabindex="<%=String.valueOf(tabindex++)%>" /></td>
                    <td align="right" width="28%" class="qou9Bold">الاسم</td>
                </tr>
                <tr>
                    <td align="right" ><html:select property="collegeNo"  tabindex="<%=String.valueOf(tabindex++)%>" styleClass="largeInput"  > <html:option value="*">اختر</html:option>  <logic:present name="univColgList"><html:options collection="univColgList" property="value"  labelProperty="label"/></logic:present></html:select></td>
                    <td align="right" class="qou9Bold">اسم الجامعة/الكلية</td>
                    <td align="right" ><html:select property="countryNo"     tabindex="<%=String.valueOf(tabindex+2)%>" styleClass="largeInput"> <logic:present name="countryList"><html:options collection="countryList" property="value"  labelProperty="label"/></logic:present> </html:select></td>
                    <td align="right" class="qou9Bold" >الدولة</td>
                </tr>
                <tr class="tableRowLightColor">
                    <td align="right" ><html:text   property="donarAName"   maxlength="100" styleClass="largeInput" tabindex="<%=String.valueOf(tabindex++)%>" /></td>
                    <td align="right" class="qou9BoldRtl">من يسدد المصاريف الجامعية  (العائلة، مصادر أخرى)</td>
                    <td align="right"><html:text   property="yearlyCost"   maxlength="100" styleClass="largeInput" tabindex="<%=String.valueOf(tabindex++)%>" /></td>
                    <td align="right" class="qou9Bold">التكلفة السنوية بالشيكل</td>
                </tr>
                <tr  >
                    <td  align="center" colspan="2">
                        <input type="button" value=" &nbsp;&nbsp;&nbsp; الغاء  &nbsp;&nbsp;&nbsp;" class="enter"  tabindex="<%=String.valueOf(tabindex++)%>" onclick="javascript:showHideDiv('dataDiv','addEditDataDiv');" >&nbsp;
                        <input type="button" value=" &nbsp;&nbsp;&nbsp; حفظ  &nbsp;&nbsp;&nbsp;" class="enter"  tabindex="<%=String.valueOf(tabindex++)%>"   onclick="javascript:funSubmit();">&nbsp;
                    </td>
                    <td  align="right"><html:text   property="relativeStudNo"   maxlength="100" styleClass="largeInput" tabindex="<%=String.valueOf(tabindex++)%>" /></td>
                    <td  class="qou9Bold" align="right">الرقم الجامعي لطالب كلية دار الكلمة</td>


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