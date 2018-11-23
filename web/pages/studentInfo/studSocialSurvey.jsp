<%@ page import="java.util.List" %>
<%@ page import="ps.edu.diyar.studentInfo.database.struct.StudentInfoHolder" %>
<%@ page import="ps.edu.diyar.common.tools.Randomizer" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<NOSCRIPT>
    <meta http-equiv="refresh" content="0;url=/noJScript.do" />
</NOSCRIPT>

<script src = "/pages/resources/admission/js/ajaxMethods.js" type = "text/javascript"></script>
<%
  response.setHeader("pragma", "no-cache");
  response.setHeader("Cache-Control", "no-cache");
  response.setHeader("Expires", "0");
 
  int  tabindex=1;
%>

<script type="text/javascript" src="/pages/resources/js/epoch_classes.js"></script>
<link rel="stylesheet" href="/pages/resources/css/epoch_styles.css" type="text/css">
<link href="/pages/resources/css/dr_portal_style.css" rel="stylesheet" type="text/css">

<script type="text/javascript">
       window.onload = function(){
        var cal_fatherDob     =  new Epoch('fatherDob','popup',document.studSocialSurveyForm.fatherDob);
        var cal_motherDob=  new Epoch('motherDob','popup',document.studSocialSurveyForm.motherDob);
        var cal_wifeOneDob  =  new Epoch('wifeOneDob','popup',document.studSocialSurveyForm.wifeOneDob);

        haveWorkFun();
     };


    function funSubmit()
    {
        var control = document.forms[0].elements["btnSave"];
        control.disabled = true;

        window.frames['srvWorkDtl'].document.forms[0].submit();
        window.frames['srvWorkDtlP2'].document.forms[0].submit();
        window.frames['srvWorkDtlP3'].document.forms[0].submit();
        window.frames['srvWorkDtlP4'].document.forms[0].submit();
        window.frames['srvyHealthDetail'].document.forms[0].submit();
        window.frames['srvyHousingInfo'].document.forms[0].submit();
        window.frames['srvyStrategicInfo'].document.forms[0].submit();

        window.setInterval("document.studSocialSurveyForm.submit();",3000);
        
        return true;
    }

     function haveWorkFun()
    {
        var hvWrk_list =document.studSocialSurveyForm.haveOtherWork;
        var hvWrk_value;
        for(var i = 0; i < hvWrk_list.length; i++)
        {
            if(hvWrk_list[i].checked)
            {
             hvWrk_value = hvWrk_list[i].value;
            }
        }


      if(hvWrk_value == 'Y')
        {
            document.studSocialSurveyForm.otherWork.readOnly = false;
            document.studSocialSurveyForm.otherWork.className = 'longInput700';
            document.studSocialSurveyForm.otherWorkCrossIncome.readOnly = false;
            document.studSocialSurveyForm.otherWorkCrossIncome.className = 'largeInput';
        }
        else// if(hvWrk_value == 'N')
        {
            document.studSocialSurveyForm.otherWork.value = '';
            document.studSocialSurveyForm.otherWork.readOnly  = true;
            document.studSocialSurveyForm.otherWork.className = 'longInputView700';
            document.studSocialSurveyForm.otherWorkCrossIncome.value = '';
            document.studSocialSurveyForm.otherWorkCrossIncome.readOnly = true;
            document.studSocialSurveyForm.otherWorkCrossIncome.className = 'largeInputView';
        }
    }

</script>


<html:form  action="saveStudSocialSurvey.do" onsubmit="funSubmit()"  method="post"  >

<table width="100%" cellpadding="0" cellspacing="0">
<tr>
<td>

        <table width="100%" cellpadding="0" cellspacing="0">

          <tr><td>
              <logic:present name="operationMessage">
              <div align="center"><br>
                <table width="90%" border="0" height="30" align="center" cellpadding="0" cellspacing="0" class="borderRoundedLightColor">
                    <tr>
                      <td height="28"     ><div align="center"><b><bean:message key='<%=(String)request.getAttribute("operationMessage")%>'/></b></div></td>
                    </tr>
                  </table>
             </div>
                  <br/>
             </logic:present>
          </td></tr>
        <logic:present name="studInfoData">
        <logic:iterate id="studInfoData" name="studInfoData"  >
        <tr><td class="qou9Bold" align="left">
            <span dir="rtl">رقم الطالب الجامعي:<input type="text" class="largeInputView" readonly="true"    tabindex="<%=String.valueOf(tabindex++)%>" value="<bean:write name="studInfoData" property="studId" />" /></span>
        </td></tr>
         <tr><td>&nbsp;</td></tr>
        <tr>
            <td align="right">
            <table align="center" width="964" height="25" cellPadding="0" cellSpacing="0" border="0" class="borderRoundedLightColor" >
            <tr>
            <td align="right" valign="middle" width="964" height="25" class="qou9Bold"><span dir="rtl">&nbsp;* القسم الأول: معلومات عامة</span></td>
            </tr>
            </table> 
            </td>
        </tr>

        <tr><td>
            <table align="right" width="700" border="0" cellpadding="0" cellspacing="2" dir="rtl">
            <tr><td colspan="4"   class="centerpage" dir="rtl">1.1اسم الطالب الرباعي:</td></tr>
            <tr>
            <td width="160" align="center" valign="middle" class="qou" dir="rtl">الإسم الأول</td>
            <td width="160" align="center" valign="middle" class="qou" dir="rtl">إسم الأب</td>
            <td width="160" align="center" valign="middle" class="qou" dir="rtl">إسم الجد</td>
            <td width="160" align="center" valign="middle" class="qou" dir="rtl">إسم العائلة</td>
            </tr>
            <tr>
            <td align="center" valign="middle"><input type="text" class="largeInputView" readonly="true"    tabindex="<%=String.valueOf(tabindex++)%>" value="<bean:write name="studInfoData" property="firstName" />" /></td>
            <td align="center" valign="middle"><input type="text" class="largeInputView" readonly="true"    tabindex="<%=String.valueOf(tabindex++)%>" value="<bean:write name="studInfoData" property="secondName" />"  /></td>
            <td align="center" valign="middle"><input type="text" class="largeInputView" readonly="true"    tabindex="<%=String.valueOf(tabindex++)%>" value="<bean:write name="studInfoData" property="thirdName" />"  /></td>
            <td align="center" valign="middle"><input type="text" class="largeInputView" readonly="true"    tabindex="<%=String.valueOf(tabindex++)%>" value="<bean:write name="studInfoData" property="familyName" />"  /></td>
            </tr>
            </table>
        </td></tr>

        <tr><td>
            <br/>
            <table align="right" width="500" border="0" cellpadding="0" cellspacing="2" dir="rtl">
            <tr><td colspan="4"   class="centerpage" dir="rtl">1.2نوع البطاقة: </td></tr>
            <tr>
            <td width="160" align="center" valign="middle" class="qou" dir="rtl">نوع الهوية</td>
            <td width="160" align="center" valign="middle" class="qou" dir="rtl">رقم الهوية</td>
            </tr>
            <tr>
            <td align="center" valign="middle">
            <input type="text" class="largeInputView" readonly="true"    tabindex="<%=String.valueOf(tabindex++)%>" value=' <logic:equal name="studInfoData" property="idcardType" value="1">هوية شخصية</logic:equal><logic:equal name="studInfoData" property="idcardType" value="2">جواز سفر</logic:equal>'  />
            </td>
            <td align="center" valign="middle"><input type="text" class="largeInputView" readonly="true"    tabindex="<%=String.valueOf(tabindex++)%>" value="<bean:write name="studInfoData" property="idcardNo" />"  />  </td>
            </tr>
            </table>
        </td></tr>
 
        <tr><td dir="rtl">
            <br/>
         <table align="right" width="500" border="0" cellpadding="0" cellspacing="2" dir="ltr">
                <tr><td colspan="4"   class="centerpage" dir="rtl">1.3 السنة الجامعية و التخصص :</td></tr>
                <tr>
                 <td width="160" align="center" valign="middle" class="qou" dir="rtl">التخصص </td>
                 <td width="160" align="center" valign="middle" class="qou" dir="rtl">السنة الجامعية</td>
                </tr>
                <tr>
                 <td align="center" valign="middle"><input type="text" class="largeInputView" readonly="true"    tabindex="<%=String.valueOf(tabindex++)%>" value="<bean:write name="studInfoData" property="specAName" />"  />  </td>
                 <td align="center" valign="middle"><input type="text" class="largeInputView" readonly="true"    tabindex="<%=String.valueOf(tabindex++)%>" value="<%=((StudentInfoHolder) ((List) request.getSession().getAttribute("studentInfo")).get(0)).getSystemCurrentTermNo()%>"  />  </td>
                </tr>
                </table>

        </td></tr>
            <tr><td>&nbsp;</td></tr>
        <tr><td dir="rtl">
         <table align="right" width="700" border="0" cellpadding="0" cellspacing="2" dir="ltr">
                <tr><td colspan="4"   class="centerpage" dir="rtl">1.4 تاريخ ومكان الولادة:</td></tr>
                <tr>
                 <td width="160" align="center" valign="middle" class="qou" dir="rtl">المدينة </td>
                 <td width="160" align="center" valign="middle" class="qou" dir="rtl">المحافظة</td>
                 <td width="160" align="center" valign="middle" class="qou" dir="rtl"> الدولة</td>
                 <td width="160" align="center" valign="middle" class="qou" dir="rtl"> تاريخ الولادة</td>
                </tr>
                <tr>
                 <td align="center" valign="middle"><html:select property="birthLocality"  disabled="true"  tabindex="<%=String.valueOf(tabindex+2)%>" styleClass="largeInputView"> <logic:present name="birthLocalityList"><html:options collection="birthLocalityList" property="value"  labelProperty="label"/></logic:present> </html:select> </td>
                 <td align="center" valign="middle"><html:select property="birthGovernate" disabled="true"  tabindex="<%=String.valueOf(tabindex+2)%>" styleClass="largeInputView"> <logic:present name="birthGovernateList"><html:options collection="birthGovernateList" property="value"  labelProperty="label"/></logic:present> </html:select> </td>
                 <td align="center" valign="middle"><html:select property="birthCountry"   disabled="true"  tabindex="<%=String.valueOf(tabindex+2)%>" styleClass="largeInputView"> <logic:present name="countryList"><html:options collection="countryList" property="value"  labelProperty="label"/></logic:present> </html:select></td>
                 <td align="center" valign="middle"><input type="text" class="largeInputView" readonly="true"    tabindex="<%=String.valueOf(tabindex++)%>" value="<bean:write name="studInfoData" property="birthDateFormatted" />"  />  </td>
                </tr><% tabindex+=2;%>
                </table>
        </td></tr>
          <tr><td>&nbsp;</td></tr>
        <tr>
        <td align="right" valign="middle" dir="rtl" class="centerpage">
            <table><tr><td class="centerpage"><div  >&nbsp; 1.5	الجنس:&nbsp;&nbsp;
            <div id="gender_div">
            <input disabled="true" <logic:equal name="studInfoData" property="gender" value="M">checked </logic:equal> type="radio" name="sex" value="male" > ذكر
            &nbsp;&nbsp;&nbsp;&nbsp;
            <input disabled="true" <logic:equal name="studInfoData" property="gender" value="F">checked </logic:equal> type="radio" name="sex" value="male" >  أنثى
            </div></div>  </td><td></td></tr></table>
        </td>
        </tr>
            <tr><td>&nbsp;</td></tr>
        <tr>
            <td align="right" valign="middle" dir="rtl" class="centerpage">
               <table align="right" width="700" border="0" cellpadding="0" cellspacing="2" dir="ltr">
                <tr><td colspan="4"   class="centerpage" dir="rtl">1.6	الحالة الاجتماعية:  	</td></tr>
                <tr>
                 <td   align="right" valign="middle" class="qou" dir="rtl"><input type="text" class="largeInputView" readonly="true"    tabindex="<%=String.valueOf(tabindex++)%>" value="<bean:write name="studInfoData" property="statusAName" />"  />&nbsp;&nbsp;&nbsp;&nbsp; </td> 
                </tr>
            </table>
        </td>
        </tr>

<tr><td>
               <br/>
               <table align="right" width="100%" border="0" cellpadding="0" cellspacing="2" dir="ltr">
                <tr><td colspan="4"   class="centerpage" dir="ltr">1.7	عنوان الإقامة الدائم:</td></tr>
                <tr>
                 <td width="160" align="center" valign="middle" class="qou" dir="rtl"> الشارع</td>
                 <td width="160" align="center" valign="middle" class="qou" dir="rtl">المدينة </td>
                 <td width="160" align="center" valign="middle" class="qou" dir="rtl">المحافظة</td>
                 <td width="160" align="center" valign="middle" class="qou" dir="rtl">الدولة</td>
                </tr>
                <tr>
                 <td align="center" valign="middle"><input type="text" class="largeInputView" readonly="true"    tabindex="<%=String.valueOf(tabindex++)%>" value="<bean:write name="studInfoData" property="perStreet" />"  /></td>
                 <td align="center" valign="middle"><html:select property="perLocality"  disabled="true"  styleClass="largeInputView"   tabindex="<%=String.valueOf(tabindex+2)%>" > <html:option value="*">اختر</html:option> <logic:present name="perLocalityList"><html:options collection="perLocalityList" property="value"  labelProperty="label"/></logic:present></html:select> </td>
                 <td align="center" valign="middle"><html:select property="perGovernate" disabled="true"  styleClass="largeInputView"   tabindex="<%=String.valueOf(tabindex+1)%>" onchange="fillNextList('perlocal','perLocality',this.value,document.forms[0].perCountry.options[document.forms[0].perCountry.selectedIndex].value)"  > <html:option value="*">اختر</html:option> <logic:present name="perGovernateList"><html:options collection="perGovernateList" property="value"  labelProperty="label"/></logic:present></html:select> </td>
                 <td align="center" valign="middle"><html:select property="perCountry"   disabled="true"  styleClass="largeInputView"   tabindex="<%=String.valueOf(tabindex)%>"  onchange="fillPerCovList(this.value,'perGovernate','perLocality')" > <html:option value="*">اختر</html:option> <logic:present name="countryList"><html:options collection="countryList" property="value"  labelProperty="label"/></logic:present></html:select> </td>
                </tr><% tabindex+=3;%>
                 <tr>
                 <td width="160" align="center" valign="middle" class="qou" dir="rtl">رقم الهاتف</td>
                 <td width="160" align="center" valign="middle" class="qou" dir="rtl"> رقم المحمول</td>
                 <td width="160" align="center" valign="middle" class="qou" dir="rtl" >البريد الالكتروني </td>
                 <td width="160" align="center" valign="middle" class="qou" dir="rtl">ص.ب </td>
                 </tr>
                <tr>
                 <td align="center" valign="middle"><input type="text" class="largeInputView" readonly="true"    tabindex="<%=String.valueOf(tabindex++)%>" value="<bean:write name="studInfoData" property="perTel" />"  /></td>
                 <td align="center" valign="middle"><input type="text" class="largeInputView" readonly="true"    tabindex="<%=String.valueOf(tabindex++)%>" value="<bean:write name="studInfoData" property="perMobile" />"  /></td>
                 <td align="center" valign="middle"><input type="text" class="largeInputView" readonly="true"    tabindex="<%=String.valueOf(tabindex++)%>" value="<bean:write name="studInfoData" property="perEmail" />"  /></td>
                 <td align="center" valign="middle"><input type="text" class="largeInputView" readonly="true"    tabindex="<%=String.valueOf(tabindex++)%>" value="<bean:write name="studInfoData" property="perBoxNo" />"  /></td>
                 </tr><% tabindex+=3;%>
                </table>

           </td></tr>
           <tr><td>
               <br/>
               <table align="right" width="100%" border="0" cellpadding="0" cellspacing="2" dir="ltr">
                <tr><td colspan="4"   class="centerpage" dir="rtl">1.8      العنوان المؤقت (أثناء الدراسة في الجامعة) إذا كان يختلف عن العنوان الدائم:</td></tr>
                <tr>
                 <td width="160" align="center" valign="middle" class="qou" dir="rtl"> الشارع</td>
                 <td width="160" align="center" valign="middle" class="qou" dir="rtl">المدينة </td>
                 <td width="160" align="center" valign="middle" class="qou" dir="rtl">المحافظة</td>
                 <td width="160" align="center" valign="middle" class="qou" dir="rtl">الدولة</td>
                </tr>
                <tr>
                 <td align="center" valign="middle"><input type="text" class="largeInputView" readonly="true"    tabindex="<%=String.valueOf(tabindex++)%>" value="<bean:write name="studInfoData" property="currStreet" />"  /></td>
                 <td align="center" valign="middle"><html:select property="currLocality"    disabled="true" tabindex="<%=String.valueOf(tabindex+2)%>" styleClass="largeInputView"> <html:option value="*">اختر</html:option> <logic:present name="currLocalityList"><html:options collection="currLocalityList" property="value"  labelProperty="label"/></logic:present> </html:select> </td>
                 <td align="center" valign="middle"><html:select property="currGovernate"   disabled="true" tabindex="<%=String.valueOf(tabindex+1)%>" styleClass="largeInputView" onchange="fillNextList('perlocal','currLocality',this.value,document.forms[0].currCountry.options[document.forms[0].currCountry.selectedIndex].value)"> <html:option value="*">اختر</html:option> <logic:present name="currGovernateList"><html:options collection="currGovernateList" property="value"  labelProperty="label"/></logic:present> </html:select> </td>
                 <td align="center" valign="middle"><html:select property="currCountry"     disabled="true" tabindex="<%=String.valueOf(tabindex)%>" styleClass="largeInputView" onchange="fillPerCovList(this.value,'currGovernate','currLocality')"> <html:option value="*">اختر</html:option> <logic:present name="countryList"><html:options collection="countryList" property="value"  labelProperty="label"/></logic:present></html:select> </td>
                </tr><% tabindex+=3;%>
                 <tr>
                 <td width="160" align="center" valign="middle" class="qou" dir="rtl">رقم الهاتف</td>
                 <td width="160" align="center" valign="middle" class="qou" dir="rtl"> رقم المحمول</td>
                 <td width="160" align="center" valign="middle" class="qou" dir="rtl" >البريد الالكتروني </td>
                 <td width="160" align="center" valign="middle" class="qou" dir="rtl">ص.ب </td>
                 </tr>
                <tr>
                 <td align="center" valign="middle"><input type="text" class="largeInputView" readonly="true"    tabindex="<%=String.valueOf(tabindex++)%>" value="<bean:write name="studInfoData" property="currTel" />"  /></td>
                 <td align="center" valign="middle"><input type="text" class="largeInputView" readonly="true"    tabindex="<%=String.valueOf(tabindex++)%>" value="<bean:write name="studInfoData" property="currMobile" />"  /></td>
                 <td align="center" valign="middle"><input type="text" class="largeInputView" readonly="true"    tabindex="<%=String.valueOf(tabindex++)%>" value="<bean:write name="studInfoData" property="currEmail" />"  /></td>
                 <td align="center" valign="middle"><input type="text" class="largeInputView" readonly="true"    tabindex="<%=String.valueOf(tabindex++)%>" value="<bean:write name="studInfoData" property="currBoxNo" />"  /></td>
                 </tr><% tabindex+=3;%>
                </table>

           </td></tr>

        



         </logic:iterate>
         </logic:present>
       <tr><td>&nbsp;<br/></td></tr>
        <tr>
            <td align="right">
            <table align="center" width="964" height="25" cellPadding="0" cellSpacing="0" border="0" class="borderRoundedLightColor" >
            <tr>
            <td width="50%" align="right" class="qou9BoldRtl"><html:errors property="errorPartTwo"/></td>
            <td width="50%" align="right" valign="middle"   height="25" class="qou9Bold"><span dir="rtl">&nbsp;* القسم الثاني: معلومات عن العائلة</span></td>
            </tr>
            </table>
            </td>
        </tr>

        <tr><td>
                       <br/>
                        <table align="right" width="700" border="0" cellpadding="0" cellspacing="2" dir="rtl">
                        <tr><td colspan="4"   class="centerpage" dir="rtl">2.1 بيانات الاب:</td></tr>
                        <tr>
                         <td width="160" align="center" valign="middle" class="qou" dir="rtl">اسم الأب</td>
                         <td width="160" align="center" valign="middle" class="qou" dir="rtl">تاريخ الولادة</td>
                         <td width="160" align="center" valign="middle" class="qou" dir="rtl">نوع البطاقة </td>
                         <td width="160" align="center" valign="middle" class="qou" dir="rtl">رقم البطاقة </td>
                         <td width="160" align="center" valign="middle" class="qou" dir="rtl">المستوى التعليمي</td>
                        </tr>
                        <tr>
                         <td align="center" valign="middle"><html:text   property="fatherAName"           maxlength="100" styleClass="largeInput" tabindex="<%=String.valueOf(tabindex++)%>" /> </td>
                         <td align="center" valign="middle"><html:text   property="fatherDob"             maxlength="100" styleClass="largeInputView" readonly="true"  tabindex="<%=String.valueOf(tabindex++)%>" /> </td>
                         <td align="center" valign="middle">
                              <html:select property="fatherIdCardType" styleClass="largeInput" tabindex="<%=String.valueOf(tabindex++)%>">
                                      <html:option value="*">اختر</html:option>
                                      <html:option value="1">هوية فلسطينية</html:option>
                                      <html:option value="2">جواز سفر عربي</html:option>
                                      <html:option value="3">جواز سفر اجنبي</html:option>
                                </html:select>
                         <td align="center" valign="middle"><html:text   property="fatherIdCard"          maxlength="100" styleClass="largeInput" tabindex="<%=String.valueOf(tabindex++)%>" /> </td>
                         <td align="center" valign="middle">
                             <html:select property="fatherAcademicLevel" styleClass="largeInput" tabindex="<%=String.valueOf(tabindex++)%>">
                                     <html:option value="*">اختر</html:option>
                                     <html:option value="1">امي</html:option>
                                     <html:option value="2">ابتدائي</html:option>
                                     <html:option value="3">اساسي</html:option>
                                     <html:option value="4">ثانوي</html:option>
                                     <html:option value="5">دبلوم متوسط</html:option>
                                     <html:option value="6">جامعي(بكالوريوس وما بعد)</html:option>
                                </html:select>
                         </tr>
                        </table>

                   </td></tr>
                   <tr><td>
                       <br/>
                        <table align="right" width="700" border="0" cellpadding="0" cellspacing="2" dir="rtl">
                        <tr><td colspan="4"   class="centerpage" dir="rtl">2.2 بيانات الام:</td></tr>
                        <tr>
                         <td width="160" align="center" valign="middle" class="qou" dir="rtl">اسم الام</td>
                         <td width="160" align="center" valign="middle" class="qou" dir="rtl">تاريخ الولادة</td>
                         <td width="160" align="center" valign="middle" class="qou" dir="rtl">نوع البطاقة </td>
                         <td width="160" align="center" valign="middle" class="qou" dir="rtl">رقم البطاقة </td>
                         <td width="160" align="center" valign="middle" class="qou" dir="rtl">المستوى التعليمي</td>
                        </tr>






                        <tr>
                         <td align="center" valign="middle"><html:text   property="motherAName"           maxlength="100" styleClass="largeInput" tabindex="<%=String.valueOf(tabindex++)%>" /> </td>
                         <td align="center" valign="middle"><html:text   property="motherDob"             maxlength="100" styleClass="largeInputView" readonly="true"  tabindex="<%=String.valueOf(tabindex++)%>" /> </td>
                         <td align="center" valign="middle">
                                   <html:select property="motherIdCardType" styleClass="largeInput" tabindex="<%=String.valueOf(tabindex++)%>">
                                      <html:option value="*">اختر</html:option>
                                      <html:option value="1">هوية فلسطينية</html:option>
                                      <html:option value="2">جواز سفر عربي</html:option>
                                      <html:option value="3">جواز سفر اجنبي</html:option>
                                </html:select>
                         <td align="center" valign="middle"><html:text   property="motherIdCard"          maxlength="100" styleClass="largeInput" tabindex="<%=String.valueOf(tabindex++)%>" /> </td>
                         <td align="center" valign="middle">
                             <html:select property="motherAcademicLevel" styleClass="largeInput" tabindex="<%=String.valueOf(tabindex++)%>">
                                     <html:option value="*">اختر</html:option>
                                     <html:option value="1">امي</html:option>
                                     <html:option value="2">ابتدائي</html:option>
                                     <html:option value="3">اساسي</html:option>
                                     <html:option value="4">ثانوي</html:option>
                                     <html:option value="5">دبلوم متوسط</html:option>
                                     <html:option value="6">جامعي(بكالوريوس وما بعد)</html:option>
                                </html:select>
                         </tr>
                        </table>

                   </td></tr>

        <tr>
            <td align="right" valign="middle" dir="rtl" class="centerpage">

               <table align="right" width="700" border="0" cellpadding="0" cellspacing="2" dir="ltr">
                <tr><td colspan="2">&nbsp;</td></tr>
                <tr>
                     <td  width="55%"  align="right" valign="middle" class="qou" dir="rtl"><html:text   property="familyCountAll"  maxlength="100" styleClass="largeInput" tabindex="<%=String.valueOf(tabindex++)%>" />&nbsp;&nbsp;&nbsp;&nbsp; </td>
                     <td  width="45%"    class="centerpage" dir="rtl">2.3 	العدد الإجمالي لأفراد عائلتك (بما فيه نفسك) :</td>
                </tr>
                <tr><td colspan="2">&nbsp;</td></tr>
            </table>
        </td>
        </tr>
         <tr>
            <td align="right" valign="middle" dir="rtl" class="centerpage">

               <table align="right" width="700" border="0" cellpadding="0" cellspacing="2" dir="ltr">
                 <tr>
                     <td  width="55%"  align="right" valign="middle" class="qou" dir="rtl"><html:text   property="familyCountUnder18"  maxlength="100" styleClass="largeInput" tabindex="<%=String.valueOf(tabindex++)%>" />&nbsp;&nbsp;&nbsp;&nbsp; </td>
                     <td  width="45%"    class="centerpage" dir="rtl">2.4 	عدد أفراد عائلتك تحت سن 18 :</td>
                </tr>
                <tr><td colspan="2">&nbsp;</td></tr>
            </table>
        </td>
        </tr>
        <tr><td>
             <table align="right" width="450" border="0" cellpadding="0" cellspacing="2" dir="rtl">
            <tr><td colspan="4"   class="centerpage" dir="rtl">2.5 	عدد الأخوة والأخوات الذين يسكنون في بيت الأهل (بما فيه نفسك):</td></tr>
            <tr>
             <td width="160" align="center" valign="middle" class="qou" dir="rtl">عدد الأخوة</td>
             <td width="160" align="center" valign="middle" class="qou" dir="rtl">عدد الأخوات</td>
            </tr>
            <tr>
             <td align="center" valign="middle"><html:text   property="brothersCount"  maxlength="100" styleClass="largeInput" tabindex="<%=String.valueOf(tabindex++)%>" /> </td>
             <td align="center" valign="middle"><html:text   property="sistersCount"  maxlength="100" styleClass="largeInput" tabindex="<%=String.valueOf(tabindex++)%>" /> </td>
            </tr>
            </table>

       </td></tr>
        <tr><td>&nbsp;</td></tr>
        <tr><td>
             <table align="right" width="850" border="0" cellpadding="0" cellspacing="2" dir="rtl">
            <tr><td colspan="4"   class="centerpage" dir="rtl">2.6	عدد الأفراد من غير الأخوة/الأخوات الذين يسكنون في بيت الأهل (أقارب من الدرجة الأولى:  الأجداد، الأعمام، الأخوال، الخالات، العمات ...الخ)</td></tr>
            <tr>
             <td width="160" align="center" valign="middle" class="qou" dir="rtl">عدد  الذكور</td>
             <td width="160" align="center" valign="middle" class="qou" dir="rtl">عدد  الاناث</td>
            </tr>
            <tr>
             <td align="center" valign="middle"><html:text   property="otherMaleCount"  maxlength="100" styleClass="largeInput" tabindex="<%=String.valueOf(tabindex++)%>" /> </td>
             <td align="center" valign="middle"><html:text   property="otherFemaleCount"  maxlength="100" styleClass="largeInput" tabindex="<%=String.valueOf(tabindex++)%>" /> </td>
            </tr>
            </table>

       </td></tr>

         <tr><td>
                       <br/>
                        <table align="right" width="700" border="0" cellpadding="0" cellspacing="2" dir="rtl">
                        <tr><td colspan="4"   class="centerpage" dir="rtl">2.7 بيانات الزوج/الزوجة:</td></tr>
                        <tr>
                         <td width="160" align="center" valign="middle" class="qou" dir="rtl">اسم الزوج/الزوجة</td>
                         <td width="160" align="center" valign="middle" class="qou" dir="rtl">تاريخ ميلاد الزوج/الزوجة</td>
                         <td width="160" align="center" valign="middle" class="qou" dir="rtl">عدد الأطفال</td>
                         <td width="160" align="center" valign="middle" class="qou" dir="rtl">نوع البطاقة </td>
                         <td width="160" align="center" valign="middle" class="qou" dir="rtl">رقم البطاقة الشخصية</td>
                         <td width="160" align="center" valign="middle" class="qou" dir="rtl">المستوى التعليمي</td>
                        </tr>
                        <tr>
                         <td align="center" valign="middle"><html:text   property="wifeOneAName"       maxlength="100" styleClass="largeInput" tabindex="<%=String.valueOf(tabindex++)%>" /> </td>
                         <td align="center" valign="middle"><html:text   property="wifeOneDob"         maxlength="100" styleClass="largeInputView" readonly="true"  tabindex="<%=String.valueOf(tabindex++)%>" /> </td>
                         <td align="center" valign="middle"><html:text   property="childrenCount"       maxlength="100" styleClass="largeInput" tabindex="<%=String.valueOf(tabindex++)%>" /> </td>                            
                         <td align="center" valign="middle">
                             <html:select property="wifeOneIdCardType" styleClass="largeInput" tabindex="<%=String.valueOf(tabindex++)%>">
                                      <html:option value="*">اختر</html:option>
                                      <html:option value="1">هوية فلسطينية</html:option>
                                      <html:option value="2">جواز سفر عربي</html:option>
                                      <html:option value="3">جواز سفر اجنبي</html:option>
                                </html:select>
                         <td align="center" valign="middle"><html:text   property="wifeOneIdCard"      maxlength="100" styleClass="largeInput" tabindex="<%=String.valueOf(tabindex++)%>" /> </td>
                         <td align="center" valign="middle">
                             <html:select property="wifeOneAcadmicLevel" styleClass="largeInput" tabindex="<%=String.valueOf(tabindex++)%>">
                                     <html:option value="*">اختر</html:option>
                                     <html:option value="1">امي</html:option>
                                     <html:option value="2">ابتدائي</html:option>
                                     <html:option value="3">اساسي</html:option>
                                     <html:option value="4">ثانوي</html:option>
                                     <html:option value="5">دبلوم متوسط</html:option>
                                     <html:option value="6">جامعي(بكالوريوس وما بعد)</html:option>
                                </html:select>
                            </td>
                        </tr>
                        </table>

                   </td></tr>
           
        <tr><td>&nbsp;</td></tr>
         <tr>
            <td align="right">
            <table align="center" width="964" height="25" cellPadding="0" cellSpacing="0" border="0" class="borderRoundedLightColor" >
            <tr>
            <td width="50%" align="right" class="qou9BoldRtl"><html:errors property="errorPartThree"/></td>
            <td width="50%" align="right" valign="middle"   height="25" class="qou9Bold"><span dir="rtl">&nbsp;* القسم الثالث : الوضع التعليمي</span></td>
            </tr>
            </table>
            </td>
        </tr>
         <tr><td>&nbsp;</td></tr>
        <tr>
        <td align="center" >
        <iframe width="966"  height="220"  src="/student/viewStudSrvyAcadDtl.do?relativeType=1&.rv=<%=Randomizer.shortRandom()%>" scrolling="auto" frameborder="0" align="center" marginheight="0" marginwidth="0" ></iframe>
        </td>
        </tr>

        <tr>
        <td align="center" >
        <iframe width="966"  height="220"  src="/student/viewStudSrvyAcadDtl.do?relativeType=2&.rv=<%=Randomizer.shortRandom()%>" scrolling="auto" frameborder="0" align="center" marginheight="0" marginwidth="0" ></iframe>
        </td>
        </tr>

        <tr>
        <td align="center" >
        <iframe width="966"  height="220"  src="/student/viewStudSrvyAcadDtl.do?relativeType=3&.rv=<%=Randomizer.shortRandom()%>" scrolling="auto" frameborder="0" align="center" marginheight="0" marginwidth="0" ></iframe>
        </td>
        </tr>

        <tr>
        <td align="center" >
        <iframe width="966"  height="220"  src="/student/viewStudSrvyAcadDtl.do?relativeType=4&.rv=<%=Randomizer.shortRandom()%>" scrolling="auto" frameborder="0" align="center" marginheight="0" marginwidth="0" ></iframe>
        </td>
        </tr>

        <tr><td>
             <table align="right" width="100%" border="0" cellpadding="0" cellspacing="2" dir="rtl">
            <tr><td colspan="4"   class="centerpage" dir="rtl">3.5 هل لديك مصاريف أخرى( كتب، مواصلات،...الخ) ؟ </td></tr>
            <tr>
             <td width="10%" align="center" valign="middle" class="qouRtl"  >اذكرها</td>
             <td width="90%" align="center" valign="middle" class="qou" dir="rtl">المبلغ الإجمالي/  شيكل سنوياً</td>
            </tr>
            <tr>
             <td align="center" valign="middle"><html:text   property="otherAcademicExpensive"  maxlength="400" styleClass="longInput700" tabindex="<%=String.valueOf(tabindex++)%>" /> </td>
             <td align="center" valign="middle"><html:text   property="otherAcademicCost"  maxlength="8" styleClass="largeInput" tabindex="<%=String.valueOf(tabindex++)%>" /> </td>
            </tr>
            </table>

       </td></tr>
         <tr><td>&nbsp;</td></tr>
         <tr>
            <td align="right">
            <table align="center" width="964" height="25" cellPadding="0" cellSpacing="0" border="0" class="borderRoundedLightColor" >
            <tr>
            <td width="50%" align="right" class="qou9BoldRtl"><html:errors property="errorPartFour"/></td>
            <td width="50%" align="right" valign="middle"   height="25" class="qou9Bold"><span dir="rtl">&nbsp;* القسم الرابع :  العمل</span></td>
            </tr>
            </table>
            </td>
        </tr>

        <tr><td>&nbsp;</td></tr>
        <tr>
        <td align="center" >
        <iframe width="966"  height="180" name="srvWorkDtl" id="srvWorkDtl" src="/student/viewStudSocialSrvWorkDtlInfo.do?workerType=you&.rv=<%=Randomizer.shortRandom()%>" scrolling="auto" frameborder="0" align="center" marginheight="0" marginwidth="0" ></iframe>
        </td>
        </tr>

        <tr><td>&nbsp;</td></tr>
        <tr>
        <td align="center" >
        <iframe width="966"  height="210" name="srvWorkDtlP2" id="srvWorkDtlP2" src="/student/viewStudSocialSrvWorkDtlInfo.do?workerType=fath&.rv=<%=Randomizer.shortRandom()%>" scrolling="auto" frameborder="0" align="center" marginheight="0" marginwidth="0" ></iframe>
        </td>
        </tr>

        <tr><td>&nbsp;</td></tr>
        <tr>
        <td align="center" >
        <iframe width="966"  height="180" name="srvWorkDtlP3" id="srvWorkDtlP3" src="/student/viewStudSocialSrvWorkDtlInfo.do?workerType=moth&.rv=<%=Randomizer.shortRandom()%>" scrolling="auto" frameborder="0" align="center" marginheight="0" marginwidth="0" ></iframe>
        </td>
        </tr>

        <tr><td>&nbsp;</td></tr>
        <tr>
        <td align="center" >
        <iframe width="966"  height="180" name="srvWorkDtlP4" id="srvWorkDtlP4" src="/student/viewStudSocialSrvWorkDtlInfo.do?workerType=wife&.rv=<%=Randomizer.shortRandom()%>" scrolling="auto" frameborder="0" align="center" marginheight="0" marginwidth="0" ></iframe>
        </td>
        </tr>

        <tr><td>&nbsp;</td></tr>
        <tr>
        <td align="center" >
        <iframe width="966"  height="180" name="srvWorkRelativeDtlP1" id="srvWorkRelativeDtlP1" src="/student/viewStudSocialSrvWorkRelativeInfo.do?liveIn=1&.rv=<%=Randomizer.shortRandom()%>" scrolling="auto" frameborder="0" align="center" marginheight="0" marginwidth="0" ></iframe>
        </td>
        </tr>


        <tr><td>&nbsp;</td></tr>
        <tr>
        <td align="center" >
        <iframe width="966"  height="180" name="srvWorkRelativeDtlP2" id="srvWorkRelativeDtlP2" src="/student/viewStudSocialSrvWorkRelativeInfo.do?liveIn=0&.rv=<%=Randomizer.shortRandom()%>" scrolling="auto" frameborder="0" align="center" marginheight="0" marginwidth="0" ></iframe>
        </td>
        </tr>

        <tr><td>
             <table align="right" width="100%" border="0" cellpadding="0" cellspacing="2" dir="rtl">
            <tr>
                <td  colspan="2"   class="centerpage" dir="rtl">
                    4.3	هل لديك مصادر دخل أخرى، أذكرها:
                <html:radio property="haveOtherWork"  onclick="haveWorkFun()"  tabindex="<%=String.valueOf(tabindex++)%>"     value="Y"    /> نعم
                &nbsp;
                <html:radio property="haveOtherWork"  onclick="haveWorkFun()"  tabindex="<%=String.valueOf(tabindex++)%>"     value="N"    /> لا
                &nbsp;    
                </td>
            </tr>
            <tr>
             <td width="10%" align="center" valign="middle" class="qouRtl"  >اذكرها</td>
             <td width="90%" align="center" valign="middle" class="qou" dir="rtl">المبلغ الإجمالي</td>
            </tr>
            <tr>
             <td align="center" valign="middle"><html:text   property="otherWork"  maxlength="400" styleClass="longInput700" tabindex="<%=String.valueOf(tabindex++)%>" /> </td>
             <td align="center" valign="middle"><html:text   property="otherWorkCrossIncome"  maxlength="8" styleClass="largeInput" tabindex="<%=String.valueOf(tabindex++)%>" /> </td>
            </tr>
            </table>

       </td></tr>
         <tr><td>&nbsp;</td></tr>
           <tr><td>
             <table align="right" width="100%" border="0" cellpadding="0" cellspacing="2" dir="ltr">
                <tr>
                <td width="40%" align="right">
                    <html:select property="familyIncome"  tabindex="<%=String.valueOf(tabindex+2)%>" styleClass="largeInput">
                        <html:option value="*">اختر</html:option>
                        <html:option value="1">أقل من 1000</html:option>
                        <html:option value="2"> 1000- 1999 </html:option>
                        <html:option value="3">2000 – 2999 </html:option>
                        <html:option value="4">3000 – 3999 </html:option>
                        <html:option value="5">4000 – 4999</html:option>
                        <html:option value="6">	5000 – 5999</html:option>
                        <html:option value="7">6000 – 6999 </html:option>
                        <html:option value="8">7000 – 7999 </html:option>
                        <html:option value="9">8000 – 8999</html:option>
                        <html:option value="10">9000 – 9999 </html:option>
                        <html:option value="11">10000 وأكثر </html:option>
                    </html:select>
                </td>
                <td width="60%"  class="centerpage" dir="rtl">4.4	ما هو تقديرك لدخل العائلة الشهري (شامل الأب، الأم، شخصك والمصادر الأخرى) (بالشيقل):</td>
                </tr>
            </table>
       </td></tr>
         <tr><td>&nbsp;</td></tr>

          <tr><td>
             <table align="right" width="100%" border="0" cellpadding="0" cellspacing="2" dir="ltr">
            <tr><td colspan="4"   class="centerpage" dir="rtl">4.5 عدد أفراد العائلة (في سن العمل) العَاطلون عن العمل: </td></tr>
            <tr>
             <td width="10%" align="center" valign="middle" class="qouRtl"  >أذكر السبب/الأسباب ؟</td>
             <td width="90%" align="center" valign="middle" class="qou" dir="rtl">عدد العاطلون عن العمل</td>
            </tr>
            <tr>
             <td align="center" valign="middle"><html:text   property="unemployedResons"  maxlength="400" styleClass="longInput700" tabindex="<%=String.valueOf(tabindex++)%>" /> </td>
             <td align="center" valign="middle"><html:text   property="familyUnemployed"  maxlength="8" styleClass="largeInput" tabindex="<%=String.valueOf(tabindex++)%>" /> </td>
            </tr>
            </table>

       </td></tr>
          <tr><td>&nbsp;</td></tr>

          <tr><td align="right">
             <table align="right" width="100%" border="0" cellpadding="0" cellspacing="2" dir="ltr">
            <tr><td colspan="6"   class="centerpage" dir="rtl">4.6	من يقوم بتسديد الأقساط والمصاريف الجامعية عنك:  (يمكنك اختيار أكثر من إجابة)</td></tr>
            <tr>
             <td width="35%" align="right"  class="qou">
              الأب<html:multibox property="payer" value='1'/>
             </td>
             <td width="15%" align="right"  class="qou">
               الأم <html:multibox property="payer" value='2'/>
             </td>
             <td width="15%"  align="right"  class="qou">
              أحد الأخوة <html:multibox property="payer" value='3'/>
             </td>
             <td width="15%"  align="right"  class="qou">
               الزوج  <html:multibox property="payer" value='4'/>
             </td>
              <td width="15%"  align="right"  class="qou">
               الزوجة <html:multibox property="payer" value='5'/>
             </td>
             <td width="5%">&nbsp;&nbsp;</td>
             </tr>

             <tr>
             <td  align="right"  class="qouRtl" colspan="3">
               غير ذلك، أذكر: (حدد) <html:text   property="otherPayer"   styleClass="largeInput" tabindex="<%=String.valueOf(tabindex++)%>" />
             </td>
             <td  align="right"  class="qou" >
             أحد الأقارب<html:multibox property="payer" value='6'/>
             </td>
             <td align="right"  class="qou">
أعتمد على نفسي<html:multibox property="payer" value='7'/>
             </td>
             <td>&nbsp;&nbsp;</td>
            </tr>
            </table>

       </td></tr>
       <tr><td>&nbsp;</td></tr>
         <tr>
            <td align="right">
            <table align="center" width="964" height="25" cellPadding="0" cellSpacing="0" border="0" class="borderRoundedLightColor" >
            <tr>
            <td width="50%" align="right" class="qou9BoldRtl"><html:errors property="errorPartFive"/></td>
            <td width="50%" align="right" valign="middle"   height="25" class="qou9Bold"><span dir="rtl">&nbsp;*القسم الخامس: الوضع الصحي</span></td>
            </tr>
            </table>
            </td>
        </tr>

        <tr><td>&nbsp;</td></tr>
        <tr>
        <td align="center" >
        <iframe width="966"  height="440" name="srvyHealthDetail" id="srvyHealthDetail" src="/student/viewStudSocialHealthDetail.do?.rv=<%=Randomizer.shortRandom()%>" scrolling="auto" frameborder="0" align="center" marginheight="0" marginwidth="0" ></iframe>
        </td>
        </tr>

        <tr><td>&nbsp;</td></tr>
        <tr>
            <td align="right">
            <table align="center" width="964" height="25" cellPadding="0" cellSpacing="0" border="0" class="borderRoundedLightColor" >
            <tr>
            <td width="50%" align="right" class="qou9BoldRtl"><html:errors property="errorPartSix"/></td>
            <td width="50%" align="right" valign="middle"   height="25" class="qou9Bold"><span dir="rtl">&nbsp;* القسم السادس: المسكن والعقارات</span></td>
            </tr>
            </table>
            </td>
        </tr>

        <tr><td>&nbsp;</td></tr>
        <tr>
        <td align="center" >
        <iframe width="966"  height="800" name="srvyHousingInfo" id="srvyHousingInfo" src="/student/viewStudSocialSrvHousingInfo.do?.rv=<%=Randomizer.shortRandom()%>" scrolling="auto" frameborder="0" align="center" marginheight="0" marginwidth="0" ></iframe>
        </td>
        </tr>
        <tr><td>&nbsp;</td></tr>
        <tr>
            <td align="right">
            <table align="center" width="964" height="25" cellPadding="0" cellSpacing="0" border="0" class="borderRoundedLightColor" >
            <tr>
            <td width="50%" align="right" class="qou9BoldRtl"><html:errors property="errorPartSeven"/></td>
            <td width="50%" align="right" valign="middle"   height="25" class="qou9Bold"><span dir="rtl">&nbsp;* القسم السابع: المساعدات/القروض</span></td>
            </tr>
            </table>
            </td>
        </tr>

        <tr><td>&nbsp;</td></tr>
        <tr>
        <td align="center" >
        <iframe width="966"  height="650" name="srvyHousingInfo" id="srvyLoanInfo" src="/student/viewStudSocialSrvLoanInfo.do?.rv=<%=Randomizer.shortRandom()%>" scrolling="auto" frameborder="0" align="center" marginheight="0" marginwidth="0" ></iframe>
        </td>
        </tr>
        <tr><td>&nbsp;</td></tr>
        <tr>
            <td align="right">
            <table align="center" width="964" height="25" cellPadding="0" cellSpacing="0" border="0" class="borderRoundedLightColor" >
            <tr>
            <td width="50%" align="right" class="qou9BoldRtl"><html:errors property="errorPartEight"/></td>
            <td width="50%" align="right" valign="middle"   height="25" class="qou9Bold"><span dir="rtl">&nbsp;* القسم الثامن: استراتيجيات التكيف</span></td>
            </tr>
            </table>
            </td>
        </tr>

        <tr><td>&nbsp;</td></tr>
        <tr>
        <td align="center" >
        <iframe width="966"  height="450" name="srvyStrategicInfo" id="srvyStrategicInfo" src="/student/viewStudSocialSrvStrategicInfo.do?.rv=<%=Randomizer.shortRandom()%>" scrolling="auto" frameborder="0" align="center" marginheight="0" marginwidth="0" ></iframe>
        </td>
        </tr>
        <tr>
          <td align="right" class="qou" ><hr align="center" color="#f38e00" size="1"></td>
        </tr>
          <tr>  <td align="right" class="qou" >&nbsp;</td>  </tr>
        <tr>
          <td align="center" class="qou" >

            <table width="50%" class="borderRoundedLightColor" cellPadding="5" cellSpacing="5"  >
                <tr>
                   <td class="centerpageRed18" align="center"><div align="center">تنبيــــه </div></td>
                </tr>
                <tr align="right"><td class="qourtl14">
                 إن استمارة المسح الاجتماعي معدة لأغراض إحصائية واستخدامات علمية بحتة والمعلومات المقدمة ستبقى طي الكتمان.  وإعطاء أية معلومات غير صحيحة في الإجابة على الأسئلة المتعلقة بالأمور المالية تحرم الطالب/الطالبة من الحصول على أية مساعدات مالية قد تتوفر في الكلية.
                </td></tr>
            </table>

          </td>
        </tr>
            <tr>  <td align="right" class="qou" >&nbsp;</td>  </tr>
        <tr>
          <td align="right" class="centerpage" ><div align="center">
           أشهد أن جميع المعلومات الواردة في هذا الطلب صادقة وصحيحة؛ وأنني أتعهد بأن أحضر كافة المستندات التي ستطلب مني.
          </div></td>
        </tr>
        <tr>  <td align="right" class="qou" >&nbsp;</td>  </tr>
        <tr>
          <td align="right" class="qou" ><hr align="center" color="#f38e00" size="1"></td>
        </tr>


        <tr  >
        <td align="center">
           <input type="button" value="  حفظ  " class="enter"  name="btnSave" onclick="funSubmit()" tabindex="<%=String.valueOf(tabindex++)%>"  >&nbsp;
           <%--<input type="submit" value="  حفظ  " class="enter"   tabindex="<%=String.valueOf(tabindex++)%>"  >&nbsp;--%>
         </td>
        </tr>
        </table>


 </td>
</tr>
</table>


</html:form>