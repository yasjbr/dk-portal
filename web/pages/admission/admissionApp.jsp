<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<NOSCRIPT>
    <meta http-equiv="refresh" content="0;url=/noJScript.do" />
</NOSCRIPT>

<script src = "/pages/resources/admission/js/ajaxMethods.js" type = "text/javascript"></script>
<script src = "/pages/resources/admission/js/validaterequiredFiled.js" type = "text/javascript"></script>
<%
  response.setHeader("pragma", "no-cache");
  response.setHeader("Cache-Control", "no-cache");
  response.setHeader("Expires", "0");
%>
<%
  int  tabindex=1;
%>

<script type="text/javascript" src="/pages/resources/js/epoch_classes.js"></script>

<link rel="stylesheet" href="/pages/resources/css/epoch_styles.css" type="text/css">
<link rel="stylesheet" href="/pages/resources/css/dr_portal_style.css" type="text/css">

<script language="javascript" >

    window.onload = function(){
        var cal_birthDate     =  new Epoch('birthDate','popup',document.admApplicationForm.birthDate);
        var cal_eduStartDate_1=  new Epoch('eduStartDate_1','popup',document.admApplicationForm.eduStartDate_1);
        var cal_eduEndDate_1  =  new Epoch('eduEndDate_1','popup',document.admApplicationForm.eduEndDate_1);
        var cal_eduStartDate_2=  new Epoch('eduStartDate_2','popup',document.admApplicationForm.eduStartDate_2);
        var cal_eduEndDate_2  =  new Epoch('eduEndDate_2','popup',document.admApplicationForm.eduEndDate_2);
        var cal_eduStartDate_3=  new Epoch('eduStartDate_3','popup',document.admApplicationForm.eduStartDate_3);
        var cal_eduEndDate_3  =  new Epoch('eduEndDate_3','popup',document.admApplicationForm.eduEndDate_3);
        var cal_eduGradeDate_1=  new Epoch('eduGradeDate_1','popup',document.admApplicationForm.eduGradeDate_1);
        var cal_eduGradeDate_2=  new Epoch('eduGradeDate_2','popup',document.admApplicationForm.eduGradeDate_2);
        var cal_eduGradeDate_3=  new Epoch('eduGradeDate_3','popup',document.admApplicationForm.eduGradeDate_3);
     };



  function funSubmit(v)
    {

        var missing_info="";

        if(v=='1')
        missing_info=checkReqFiled();

        if (missing_info != "")
        {
            alert("الرجاء ادخال الحقول التالية"+"\n"+missing_info);
            return false;
        }
        else
        {

                var msg  ='';
                if(v=='1')
                {
//                    if(document.admApplicationForm.tawAvg.value == "" || document.admApplicationForm.tawAvg.value == "*")
//                    msg+='يرجى ادخال معدل التوجيهي'+' *\n';
//                    if(document.admApplicationForm.englishMark.value == "" || document.admApplicationForm.englishMark.value == "*")
//                    msg+='يرجى ادخال علامة الانجليزي'+' *\n';


                    if(msg!='')
                    {
                    alert(msg);
                    }
                    else
                    {
                       if(confirm('في حال قمت بالتثبيت لن تستطيع التعديل على البيانات المدخلة ........ هل تريد الاستمرار ؟'))
                       {
                            document.admApplicationForm.appStatus.value = v;
                            document.admApplicationForm.submit();
                            return true;
                       }
                    }

                }
                else
                {
                document.admApplicationForm.appStatus.value = v;
                document.admApplicationForm.submit();
                return true;
                }
        }

    }
</script>


<html:form  action="admApplicationSave.do"  method="post"  >
<table width="964"  border="0" cellpadding="0" cellspacing="0" align="center"    bgcolor="#FFFFFF">
 <html:hidden property="admStatus"   />
 <html:hidden property="appStatus"   />
<tr>
 <td width="99%" align="center"   >
     <html:errors/>
       <table width="100%" border="0" cellpadding="0" cellspacing="0" align="center"  >
           <tr><td align="center">
              <logic:present name='operationMessage'>
                <div align="center" class="centerpageRed18"><b><bean:message key='<%= request.getAttribute("operationMessage")+"" %>'/> </b><br/></div>
              </logic:present>
              <logic:present name="errorMsg">
                <div align="center" class="centerpageRed18"><b><%= request.getAttribute("errorMsg")%> </b><br/></div>
              </logic:present>
              <logic:present name="appAprove">
                <div align="center" class="borderRoundedRedColor">
                    الطلب مثبت لا يمكن التعديل على البيانات المدخلة
                </div>
              </logic:present>
               <logic:present name="admStatus">
                   <br/>
                 <div align="center" class="borderRoundedRedColor">
                 <logic:iterate id="admStatus" name="admStatus"  >
                        حالة الطلب  :<bean:write name="admStatus" property="statAName" />
                  </logic:iterate>
                 </div>
              </logic:present>

           </td></tr>
           <tr>
               <td align="right">

                   <table dir="ltr" align="right">
                       <tr>
                           <td>
                               <html:select property="appStudentCat" styleClass="largeInput" tabindex="<%=String.valueOf(tabindex++)%>">
                                      <html:option value="*">اختر</html:option> 
                                      <html:option value="N">سنة اولى</html:option>
                                      <html:option value="T">محول</html:option>
                                </html:select>
                           </td>
                           <td align="right" class="centerpage"><font color="red">*</font>تصنيف الطالب :</td>
                       </tr>

                   </table>
                       <br/>
               </td>
           </tr>

           <tr>
               <td align="right">
               <table align="center" width="964" height="25" cellPadding="0" cellSpacing="0" border="0" class="borderRoundedLightColor" >
              <tr>
                <td align="right" valign="middle" width="964" height="25" class="qou9Bold">&nbsp;البيانات الشخصية</td>
              </tr>
              </table> 
                
                </td>
           </tr>
           <tr><td>
               <table align="right" width="700" border="0" cellpadding="0" cellspacing="2" dir="rtl">
                <tr><td colspan="4"   class="centerpage" dir="rtl"><font color="red">*</font>1. الاسم باللغة العربية</td></tr>
                <tr>
                 <td width="160" align="center" valign="middle" class="qou" dir="rtl">الإسم الأول</td>
                 <td width="160" align="center" valign="middle" class="qou" dir="rtl">إسم الأب</td>
                 <td width="160" align="center" valign="middle" class="qou" dir="rtl">إسم الجد</td>
                 <td width="160" align="center" valign="middle" class="qou" dir="rtl">إسم العائلة</td>
                </tr>
                <tr>
                 <td align="center" valign="middle"><html:text  property="firstName"   maxlength="20" styleClass="largeInput"   tabindex="<%=String.valueOf(tabindex++)%>" /></td>
                 <td align="center" valign="middle"><html:text  property="secondName"  maxlength="20" styleClass="largeInput"   tabindex="<%=String.valueOf(tabindex++)%>" /></td>
                 <td align="center" valign="middle"><html:text  property="thirdName"   maxlength="20" styleClass="largeInput"   tabindex="<%=String.valueOf(tabindex++)%>" /></td>
                 <td align="center" valign="middle"><html:text  property="familyName"  maxlength="20" styleClass="largeInput"   tabindex="<%=String.valueOf(tabindex++)%>" /></td>
                </tr>
                </table>

           </td></tr>

            <tr><td>
               <table align="right" width="700" border="0" cellpadding="0" cellspacing="2" dir="rtl">
                <tr><td colspan="4"   class="centerpage" dir="rtl"><font color="red">*</font>2. الاسم باللغة الانجليزية</td></tr>
                <tr>
                 <td width="160" align="center" valign="middle" class="qou" dir="rtl">Family </td>
                 <td width="160" align="center" valign="middle" class="qou" dir="rtl"> Grandfather</td>
                 <td width="160" align="center" valign="middle" class="qou" dir="rtl">Father </td>
                 <td width="160" align="center" valign="middle" class="qou" dir="rtl">First</td>
                </tr>
                <tr>
                 <td align="center" valign="middle"><html:text  property="familyNameE"  maxlength="20" styleClass="largeInput"   tabindex="<%=String.valueOf(tabindex+3)%>" /></td>
                 <td align="center" valign="middle"><html:text  property="thirdNameE"   maxlength="20" styleClass="largeInput"   tabindex="<%=String.valueOf(tabindex+2)%>" /></td>
                 <td align="center" valign="middle"><html:text  property="secondNameE"  maxlength="20" styleClass="largeInput"   tabindex="<%=String.valueOf(tabindex+1)%>" /> </td>
                 <td align="center" valign="middle"><html:text  property="firstNameE"   maxlength="20" styleClass="largeInput"   tabindex="<%=String.valueOf(tabindex)%>" /><% tabindex+=4;%></td>
                </tr>
                </table>

           </td></tr>
             <tr>
                 <td align="right" valign="middle" dir="rtl" class="centerpage">
                        <table><tr><td class="centerpage"><div  >&nbsp;<font color="red">*</font>3. الجنس:&nbsp;&nbsp;
                        <div id="gender_div"><html:radio property="gender"  onclick="fillNextList('natgender', 'nationality','M')"   value="M"    /> ذكر
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <html:radio property="gender" onclick="fillNextList('natgender', 'nationality','F')" value="F"    /> أنثى
                        </div></div>  </td><td></td></tr></table>
                 </td>
           </tr>
           <tr><td>
               <br/>
               <table align="right" width="500" border="0" cellpadding="0" cellspacing="2" dir="rtl">
                <tr><td colspan="4"   class="centerpage" dir="rtl"><font color="red">*</font>4.هوية مقدم الطلب</td></tr>
                <tr>
                    <td width="160" align="center" valign="middle" class="qou" dir="rtl">نوع الهوية</td>
                    <td width="160" align="center" valign="middle" class="qou" dir="rtl">رقم الهوية</td>
                </tr>
                <tr>
                    <td align="center" valign="middle"><html:select property="idcardType" styleClass="largeInput"  tabindex="<%=String.valueOf(tabindex++)%>" >
                                                         <html:option value="*">اختر</html:option>
                                                         <html:option value="1">هوية شخصية</html:option>
                                                         <html:option value="2">جواز سفر</html:option>
                                                     </html:select></td>
                     <td align="center" valign="middle"><html:text   property="idcardNo" maxlength="9"  styleClass="largeInput"  tabindex="<%=String.valueOf(tabindex++)%>"  /></td>
                 

                 </tr>
                </table>
           </td></tr>
           <tr><td>
               <br/>
<table align="right" width="700" border="0" cellpadding="0" cellspacing="2" dir="rtl">
                <tr><td colspan="4"   class="centerpage" dir="rtl"><font color="red">*</font>5.بيانات الاب</td></tr>
                <tr>
                 <td width="160" align="center" valign="middle" class="qou" dir="rtl">اسم الاب الثلاثي </td>
                 <td width="160" align="center" valign="middle" class="qou" dir="rtl">درجة التحصيل العلمي </td>
                 <td width="160" align="center" valign="middle" class="qou" dir="rtl">الوظيفة الحالية </td>
                </tr>
                <tr>
                 <td align="center" valign="middle"><html:text   property="fatherName"  maxlength="100" styleClass="largeInput" tabindex="<%=String.valueOf(tabindex++)%>" /></td>
                 <td align="center" valign="middle"><html:select property="fatherCert" styleClass="largeInput" tabindex="<%=String.valueOf(tabindex++)%>" > <html:option value="*">اختر</html:option> <logic:present name="certTypesList"><html:options collection="certTypesList" property="value"  labelProperty="label"/></logic:present></html:select> </td>
                 <td align="center" valign="middle"><html:select property="fatherJob"  styleClass="largeInput" tabindex="<%=String.valueOf(tabindex++)%>" > <html:option value="*">اختر</html:option> <logic:present name="jobsList"><html:options collection="jobsList" property="value"  labelProperty="label"/></logic:present></html:select> </td>
                </tr>
                </table>

           </td></tr>
            <tr><td>
                <br/>
               <table align="right" width="700" border="0" cellpadding="0" cellspacing="2" dir="rtl">
                <tr><td colspan="4"   class="centerpage" dir="rtl"><font color="red">*</font>6.بيانات الام</td></tr>
                <tr>
                 <td width="160" align="center" valign="middle" class="qou" dir="rtl">اسم الام الثلاثي </td>
                 <td width="160" align="center" valign="middle" class="qou" dir="rtl">درجة التحصيل العلمي </td>
                 <td width="160" align="center" valign="middle" class="qou" dir="rtl">الوظيفة الحالية </td>
                </tr>
                <tr>
                 <td align="center" valign="middle"><html:text   property="motherName" maxlength="100" styleClass="largeInput"   tabindex="<%=String.valueOf(tabindex++)%>" /></td>
                 <td align="center" valign="middle"><html:select property="motherCert" styleClass="largeInput"   tabindex="<%=String.valueOf(tabindex++)%>" > <html:option value="*">اختر</html:option> <logic:present name="certTypesList"><html:options collection="certTypesList" property="value"  labelProperty="label"/></logic:present></html:select> </td>
                 <td align="center" valign="middle"><html:select property="motherJob"  styleClass="largeInput"   tabindex="<%=String.valueOf(tabindex++)%>" > <html:option value="*">اختر</html:option> <logic:present name="jobsList"><html:options collection="jobsList" property="value"  labelProperty="label"/></logic:present></html:select> </td>
                </tr>
                </table>

           </td></tr>


                
           <tr><td>
               <br/>
               <table align="right" width="100%" border="0" cellpadding="0" cellspacing="2" dir="ltr">
                <tr><td colspan="4"   class="centerpage" dir="ltr"><font color="red">*</font>7.العنوان الدائم</td></tr>
                <tr>
                 <td width="160" align="center" valign="middle" class="qou" dir="rtl"> الشارع</td>
                 <td width="160" align="center" valign="middle" class="qou" dir="rtl">المدينة </td>
                 <td width="160" align="center" valign="middle" class="qou" dir="rtl">المحافظة</td>
                 <td width="160" align="center" valign="middle" class="qou" dir="rtl">الدولة</td>
                </tr>
                <tr>
                 <td align="center" valign="middle"><html:text   property="perStreet"     maxlength="100" styleClass="largeInput"   tabindex="<%=String.valueOf(tabindex+3)%>" /></td>
                 <td align="center" valign="middle"><html:select property="perLocality"  styleClass="largeInput"   tabindex="<%=String.valueOf(tabindex+2)%>" > <html:option value="*">اختر</html:option> <logic:present name="perLocalityList"><html:options collection="perLocalityList" property="value"  labelProperty="label"/></logic:present></html:select> </td>
                 <td align="center" valign="middle"><html:select property="perGovernate" styleClass="largeInput"   tabindex="<%=String.valueOf(tabindex+1)%>" onchange="fillNextList('perlocal','perLocality',this.value,document.forms[0].perCountry.options[document.forms[0].perCountry.selectedIndex].value)"  > <html:option value="*">اختر</html:option> <logic:present name="perGovernateList"><html:options collection="perGovernateList" property="value"  labelProperty="label"/></logic:present></html:select> </td>
                 <td align="center" valign="middle"><html:select property="perCountry"   styleClass="largeInput"   tabindex="<%=String.valueOf(tabindex)%>"  onchange="fillPerCovList(this.value,'perGovernate','perLocality')" > <html:option value="*">اختر</html:option> <logic:present name="countryList"><html:options collection="countryList" property="value"  labelProperty="label"/></logic:present></html:select> </td>
                </tr><% tabindex+=3;%>
                 <tr>
                 <td width="160" align="center" valign="middle" class="qou" dir="rtl">رقم الهاتف</td>
                 <td width="160" align="center" valign="middle" class="qou" dir="rtl"> رقم المحمول</td>
                 <td width="160" align="center" valign="middle" class="qou" dir="rtl" >البريد الالكتروني </td>
                 <td width="160" align="center" valign="middle" class="qou" dir="rtl">ص.ب </td>
                 </tr>
                <tr>
                 <td align="center" valign="middle"><html:text   property="perTel"    styleClass="largeInput"   tabindex="<%=String.valueOf(tabindex+3)%>"  maxlength="15" /></td>
                 <td align="center" valign="middle"><html:text   property="perMobile" styleClass="largeInput"   tabindex="<%=String.valueOf(tabindex+2)%>"  maxlength="15" /></td>
                 <td align="center" valign="middle"><html:text   property="perEmail"  styleClass="largeInput"   tabindex="<%=String.valueOf(tabindex+1)%>"  maxlength="40"  /></td>
                 <td align="center" valign="middle"><html:text   property="perBoxNo"  styleClass="largeInput"   tabindex="<%=String.valueOf(tabindex)%>"    maxlength="10"/></td>
                 </tr><% tabindex+=3;%>
                </table>

           </td></tr>
           <tr><td>
               <br/>
               <table align="right" width="100%" border="0" cellpadding="0" cellspacing="2" dir="ltr">
                <tr><td colspan="4"   class="centerpage" dir="rtl"> 8.العنوان الحالي - ان كان مختلفا عن الدائم - </td></tr>
                <tr>
                 <td width="160" align="center" valign="middle" class="qou" dir="rtl"> الشارع</td>
                 <td width="160" align="center" valign="middle" class="qou" dir="rtl">المدينة </td>
                 <td width="160" align="center" valign="middle" class="qou" dir="rtl">المحافظة</td>
                 <td width="160" align="center" valign="middle" class="qou" dir="rtl">الدولة</td>
                </tr>
                <tr>
                 <td align="center" valign="middle"><html:text   property="currStreet"     tabindex="<%=String.valueOf(tabindex+3)%>" styleClass="largeInput"   maxlength="100"/></td>
                 <td align="center" valign="middle"><html:select property="currLocality"   tabindex="<%=String.valueOf(tabindex+2)%>" styleClass="largeInput"> <html:option value="*">اختر</html:option> <logic:present name="currLocalityList"><html:options collection="currLocalityList" property="value"  labelProperty="label"/></logic:present> </html:select> </td>
                 <td align="center" valign="middle"><html:select property="currGovernate"  tabindex="<%=String.valueOf(tabindex+1)%>" styleClass="largeInput" onchange="fillNextList('perlocal','currLocality',this.value,document.forms[0].currCountry.options[document.forms[0].currCountry.selectedIndex].value)"> <html:option value="*">اختر</html:option> <logic:present name="currGovernateList"><html:options collection="currGovernateList" property="value"  labelProperty="label"/></logic:present> </html:select> </td>
                 <td align="center" valign="middle"><html:select property="currCountry"    tabindex="<%=String.valueOf(tabindex)%>" styleClass="largeInput" onchange="fillPerCovList(this.value,'currGovernate','currLocality')"> <html:option value="*">اختر</html:option> <logic:present name="countryList"><html:options collection="countryList" property="value"  labelProperty="label"/></logic:present></html:select> </td>
                </tr><% tabindex+=3;%>
                 <tr>
                 <td width="160" align="center" valign="middle" class="qou" dir="rtl">رقم الهاتف</td>
                 <td width="160" align="center" valign="middle" class="qou" dir="rtl"> رقم المحمول</td>
                 <td width="160" align="center" valign="middle" class="qou" dir="rtl" >البريد الالكتروني </td>
                 <td width="160" align="center" valign="middle" class="qou" dir="rtl">ص.ب </td>
                 </tr>
                <tr>
                 <td align="center" valign="middle"><html:text   property="currTel"     tabindex="<%=String.valueOf(tabindex+3)%>" styleClass="largeInput"   maxlength="15"/></td>
                 <td align="center" valign="middle"><html:text   property="currMobile"  tabindex="<%=String.valueOf(tabindex+2)%>" styleClass="largeInput"   maxlength="15" /></td>
                 <td align="center" valign="middle"><html:text   property="currEmail"   tabindex="<%=String.valueOf(tabindex+1)%>" styleClass="largeInput"   maxlength="40"/></td>
                 <td align="center" valign="middle"><html:text   property="currBoxNo"   tabindex="<%=String.valueOf(tabindex)%>"   styleClass="largeInput"   maxlength="10"  /></td>
                 </tr><% tabindex+=3;%>
                </table>

           </td></tr>
           <tr><td>
               <br/>
               <table align="right" width="700" border="0" cellpadding="0" cellspacing="2" dir="ltr">
                <tr><td colspan="4"   class="centerpage" dir="rtl"><font color="red">*</font>9.مكان الولادة</td></tr>
                <tr>
                 <td width="160" align="center" valign="middle" class="qou" dir="rtl">المدينة </td>
                 <td width="160" align="center" valign="middle" class="qou" dir="rtl">المحافظة</td>
                 <td width="160" align="center" valign="middle" class="qou" dir="rtl"> الدولة</td>
                </tr>
                <tr>
                 <td align="center" valign="middle"><html:select property="birthLocality"   tabindex="<%=String.valueOf(tabindex+2)%>" styleClass="largeInput"><html:option value="*">اختر</html:option> <logic:present name="birthLocalityList"><html:options collection="birthLocalityList" property="value"  labelProperty="label"/></logic:present> </html:select> </td>
                 <td align="center" valign="middle"><html:select property="birthGovernate"  tabindex="<%=String.valueOf(tabindex+1)%>" styleClass="largeInput" onchange="fillNextList('perlocal','birthLocality',this.value,document.forms[0].birthCountry.options[document.forms[0].birthCountry.selectedIndex].value)"><html:option value="*">اختر</html:option><logic:present name="birthGovernateList"><html:options collection="birthGovernateList" property="value"  labelProperty="label"/></logic:present>  </html:select> </td>
                 <td align="center" valign="middle"><html:select property="birthCountry"    tabindex="<%=String.valueOf(tabindex)%>" styleClass="largeInput" onchange="fillPerCovList(this.value,'birthGovernate','birthLocality')"><html:option value="*">اختر</html:option>  <logic:present name="countryList"><html:options collection="countryList" property="value"  labelProperty="label"/></logic:present></html:select> </td>
                </tr><% tabindex+=2;%>
                </table>

          </td></tr>
          <tr><td>
               <br/>
                    <table dir="ltr" width="100%">
                    <tr>
                       <td> <html:text   property="noOfChildrens" styleClass="smallInputField"   tabindex="<%=String.valueOf(tabindex+2)%>"  maxlength="2" /></td>
                       <td align="right" class="centerpage"> 12.عدد الاولاد (ان وجد) </td>
                       <td align="right" > <html:select property="maritalStatus"  tabindex="<%=String.valueOf(tabindex+1)%>" styleClass="largeInput"> <html:option value="*">اختر</html:option> <logic:present name="maritalStatusList"><html:options collection="maritalStatusList" property="value"  labelProperty="label"/></logic:present></html:select>                    </td>
                       <td align="right" class="centerpage"><font color="red">*</font>11.الحالة الاجتماعية </td>
                       <td align="right"> <html:text   property="birthDate"    tabindex="<%=String.valueOf(tabindex)%>" readonly="true" styleClass="largeInputView"   /></td>
                       <td align="right" class="centerpage"><font color="red">*</font>10.تاريخ الميلاد </td>
                     </tr><% tabindex+=2;%>
                     <tr>
                       <td>&nbsp; </td>
                       <td align="right" class="centerpage">&nbsp;</td>
                       <td align="right"><html:select property="healthStatus"  tabindex="<%=String.valueOf(tabindex+1)%>" styleClass="largeInput"> <html:option value="*">اختر</html:option> <logic:present name="healthStatusList"><html:options collection="healthStatusList" property="value"  labelProperty="label"/></logic:present></html:select>                    </td>
                       <td align="right" class="centerpage"><font color="red">*</font>14.الحالة الصحية </td>
                       <td align="right" > <html:select property="nationality"  tabindex="<%=String.valueOf(tabindex)%>" styleClass="largeInput"> <html:option value="*">اختر</html:option> <logic:present name="genderMList"><html:options collection="genderMList" property="value"  labelProperty="label"/></logic:present></html:select>                     </td>
                       <td align="right" class="centerpage"><font color="red">*</font>13.الجنسية </td>
                     </tr><% tabindex+=1;%>
                      <tr>
                            <td colspan="6"  align="right" >
                            <table>
                            <tr>
                            <td align="right" > <html:text    tabindex="<%=String.valueOf(tabindex++)%>" property="emergencyTel" styleClass="largeInput"  maxlength="15" /></td>
                            <td align="right" class="centerpage"><font color="red">*</font>15.رقم الهاتف  في حالة الطوارئ </td>
                            </tr>
                            <tr>
                            <td align="right"   > <html:text    tabindex="<%=String.valueOf(tabindex++)%>" property="emergencyAddress"  maxlength="100" styleClass="largeInput380"  /> </td>
                            <td align="right"  class="centerpage"><font color="red">*</font>16.العنوان في حالة الطوارئ </td>
                            </tr></table>
                            </td>
                      </tr>
                    </table>
           </td></tr>
           <tr><td>
               <br/>
                    <table dir="ltr">
                    <tr>
                    <td>
                    <html:text  property="healthSituation"  tabindex="<%=String.valueOf(tabindex++)%>" maxlength="200" styleClass="largeInput440"  />
                    </td>
                    <td align="right" class="centerpage"> 17.اذا كنت تعاني من اي مشاكل صحية يرجى التوضيح</td>
                    </tr>
                    </table><br/>&nbsp;
           </td></tr>
           <tr>
               <td align="right">
               <table align="center" width="964" height="25" cellPadding="0" cellSpacing="0" border="0" class="borderRoundedLightColor" >
              <tr>
                <td align="right" valign="middle" width="964" height="25" class="qou9Bold">&nbsp;المعلومات التربوية</td>
              </tr>
              </table>
             </td>
           </tr>
           <tr><td>
               <br/>
                    <table dir="ltr">
                    <tr>
                    <td>
                        <html:select property="schoolNo" tabindex="<%=String.valueOf(tabindex++)%>"  styleClass="largeInput"> <html:option value="*">اختر</html:option>  <logic:present name="schoolList"><html:options collection="schoolList" property="value"  labelProperty="label"/></logic:present></html:select>
                    </td>
                    <td align="right" class="centerpage"><font color="red">*</font>1.اسم المدرسة التي تخرجت منها</td>
                    </tr>
                    </table> 
            </td></tr>
            <tr><td>
               <br/>
               <table align="right" width="100%" border="0" cellpadding="0" cellspacing="2" dir="ltr">
                <tr><td colspan="5"   class="centerpage" dir="rtl"><font color="red">*</font>2.عنوان المدرسة </td></tr>
                <tr>
                 <td width="160" align="center" valign="middle" class="qou" dir="rtl">ص.ب </td>
                 <td width="160" align="center" valign="middle" class="qou" dir="rtl"> الشارع</td>
                 <td width="160" align="center" valign="middle" class="qou" dir="rtl">المدينة </td>
                 <td width="160" align="center" valign="middle" class="qou" dir="rtl">المحافظة</td>
                 <td width="160" align="center" valign="middle" class="qou" dir="rtl">الدولة</td>
                </tr>
                <tr>
                 <td align="center" valign="middle"><html:text   property="schoolBoxNo"      tabindex="<%=String.valueOf(tabindex+4)%>" styleClass="largeInput"  maxlength="10"/></td>
                 <td align="center" valign="middle"><html:text   property="schoolStreet"     tabindex="<%=String.valueOf(tabindex+3)%>" styleClass="largeInput"  /></td>
                 <td align="center" valign="middle"><html:select property="schoolLocality"   tabindex="<%=String.valueOf(tabindex+2)%>" styleClass="largeInput">  <html:option value="*">اختر</html:option> <logic:present name="schoolLocalityList"><html:options collection="schoolLocalityList" property="value"  labelProperty="label"/></logic:present> </html:select> </td>
                 <td align="center" valign="middle"><html:select property="schoolGovernate"  tabindex="<%=String.valueOf(tabindex+1)%>" styleClass="largeInput" onchange="fillNextList('perlocal','schoolLocality',this.value,document.forms[0].schoolCountry.options[document.forms[0].schoolCountry.selectedIndex].value)">  <html:option value="*">اختر</html:option><logic:present name="schoolGovernateList"><html:options collection="schoolGovernateList" property="value"  labelProperty="label"/></logic:present> </html:select> </td>
                 <td align="center" valign="middle"><html:select property="schoolCountry"    tabindex="<%=String.valueOf(tabindex)%>" styleClass="largeInput" onchange="fillPerCovList(this.value,'schoolGovernate','schoolLocality')">  <html:option value="*">اختر</html:option> <logic:present name="countryList"><html:options collection="countryList" property="value"  labelProperty="label"/></logic:present></html:select> </td>
                </tr> <% tabindex+=4;%>
                </table>

           </td></tr>
           <tr><td align="right">
               <br/>
                    <table dir="ltr">
                    <tr>
                       <td align="right" >
                                <html:select property="schoolType"  tabindex="<%=String.valueOf(tabindex++)%>" styleClass="largeInput">
                                      <html:option value="*">اختر</html:option>
                                      <html:option value="1"> حكومية</html:option>
                                      <html:option value="2">خاصة</html:option>
                                      <html:option value="3">وكالة</html:option>
                                </html:select></td>
                       <td align="right" class="centerpage"><font color="red">*</font>3.نوع المدرسة</td>
                    </tr>
                    </table> 
           </td></tr>
           <tr><td align="right">
               <br/>
                    <table dir="ltr" width="100%" border="0">
                    <tr>
                       <td align="right"> <html:text   property="tawYear"  tabindex="<%=String.valueOf(tabindex+2)%>" maxlength="4"  styleClass="smallInputField"  /></td>
                       <td align="right" class="centerpage"><font color="red">*</font>6.سنة التخرج</td>
                       <td align="right" > <html:select property="tawBranch"  tabindex="<%=String.valueOf(tabindex+1)%>" styleClass="smallInputField"> <html:option value="*">اختر</html:option> <logic:present name="tawBranchList"><html:options collection="tawBranchList" property="value"  labelProperty="label"/></logic:present></html:select> </td>
                       <td align="right" class="centerpage"><font color="red">*</font>5.فرع التوجيهي</td>
                       <td align="right" > <html:select property="tawOrigin"  tabindex="<%=String.valueOf(tabindex)%>" styleClass="smallInputField"> <html:option value="*">اختر</html:option> <logic:present name="tawOriginList"><html:options collection="tawOriginList" property="value"  labelProperty="label"/></logic:present></html:select> </td>
                       <td align="right" class="centerpage"><font color="red">*</font>4.نوع التوجيهي</td>
                    </tr><% tabindex+=2;%>
                    <tr>
                       <td align="right"> <html:text   property="englishMark"  tabindex="<%=String.valueOf(tabindex+2)%>"  maxlength="3" styleClass="smallInputField"  /></td>
                       <td align="right" class="centerpage"><font color="red"></font>9.علامة اللغة الانجليزية</td>
                       <td align="right"> <html:text   property="tawAvg"  tabindex="<%=String.valueOf(tabindex+1)%>" maxlength="6"  styleClass="smallInputField"  /></td>
                       <td align="right" class="centerpage"><font color="red"></font>8.معدل التوجيهي</td>
                       <td align="right"  > <html:text   property="tawSeat"  tabindex="<%=String.valueOf(tabindex)%>" maxlength="9"  styleClass="smallInputField"  /></td>
                       <td align="right" class="centerpage"><font color="red"></font>7.رقم الجلوس</td>
                    </tr> <% tabindex+=2;%>
                    </table>
               <br/>&nbsp;
           </td></tr>
           <tr><td align="right" class="centerpage">
                 في حال كونك طالب محول من كلية أو جامعة أخرى . الرجاء تعبئة  الجدول التالي  بأسماء الكليات و المعاهد و الجامعات التي درست فيها مرتبة من الاحدث الى الاقدم ، الرجاء الطلب من المؤسسات التعليمية المذكورة أدناه إرسال كشوف علاماتك للكلية .
           </td></tr>
           <tr><td>
               <br/>
               <table align="right" width="100%" border="0" cellpadding="0" cellspacing="2" dir="rtl">
                <tr>
                 <td width="10%" align="center" valign="middle" class="qou" dir="rtl">اسم المؤسسة </td>
                 <td width="10%" align="center" valign="middle" class="qou" dir="rtl">الدولة</td>
                 <td width="10%" align="center" valign="middle" class="qou" dir="rtl">المحافظة</td>
                 <td width="10%" align="center" valign="middle" class="qou" dir="rtl">المدينة </td>
                 <td width="25%" align="center" valign="middle" class="qouRtl"  > تاريخ الالتحاق (من -الى)</td>
                 <td width="10%" align="center" valign="middle" class="qou" dir="rtl">نوع الشهادة</td>
                 <td width="10%" align="center" valign="middle" class="qou" dir="rtl">الدرجة التي حصلت عليها </td>
                 <td width="10%" align="center" valign="middle" class="qou" dir="rtl">تاريخ الحصول عليها</td>
                </tr>
                   
                <tr>
                     <td align="center" valign="middle"><html:select property="eduUcNo_1"         tabindex="<%=String.valueOf(tabindex++)%>" styleClass="smallInputField">  <html:option value="*">اختر</html:option> <logic:present name="univColgList"><html:options collection="univColgList" property="value"  labelProperty="label"/></logic:present></html:select> </td>
                     <td align="center" valign="middle"><html:select property="eduUcCountry_1"    tabindex="<%=String.valueOf(tabindex++)%>" styleClass="smallInputField"   onchange="fillPerCovList(this.value,'eduUcGovernate_1','eduUcLocality_1')">  <html:option value="*">اختر</html:option> <logic:present name="countryList"><html:options collection="countryList" property="value"  labelProperty="label"/></logic:present></html:select> </td>
                     <td align="center" valign="middle"><html:select property="eduUcGovernate_1"  tabindex="<%=String.valueOf(tabindex++)%>" styleClass="smallInputField"   onchange="fillNextList('perlocal','eduUcLocality_1',this.value,document.forms[0].eduUcCountry_1.options[document.forms[0].eduUcCountry_1.selectedIndex].value)">  <html:option value="*">اختر</html:option><logic:present name="eduUcGovernate_1List"><html:options collection="eduUcGovernate_1List" property="value"  labelProperty="label"/></logic:present> </html:select> </td>
                     <td align="center" valign="middle"><html:select property="eduUcLocality_1"   tabindex="<%=String.valueOf(tabindex++)%>" styleClass="smallInputField">  <html:option value="*">اختر</html:option><logic:present name="eduUcLocality_1List"><html:options collection="eduUcLocality_1List" property="value"  labelProperty="label"/></logic:present> </html:select> </td>
                     <td align="center" valign="middle"><html:text   property="eduStartDate_1"    tabindex="<%=String.valueOf(tabindex++)%>" styleClass="smallInputFieldView"   readonly="true"  /> - <html:text   property="eduEndDate_1" styleClass="smallInputFieldView"  readonly="true"  /></td>
                     <td align="center" valign="middle"><html:select property="rsdSpecNo_1"       tabindex="<%=String.valueOf(tabindex++)%>" styleClass="smallInputField">  <html:option value="*">اختر</html:option> <logic:present name="specDiplomaList"><html:options collection="specDiplomaList" property="value"  labelProperty="label"/></logic:present></html:select> </td>
                     <td align="center" valign="middle"><html:select property="eduSpecTypeNo_1"   tabindex="<%=String.valueOf(tabindex++)%>" styleClass="smallInputField">  <html:option value="*">اختر</html:option> <logic:present name="specTypesList"><html:options collection="specTypesList" property="value"  labelProperty="label"/></logic:present></html:select> </td>
                     <td align="center" valign="middle"><html:text   property="eduGradeDate_1"    tabindex="<%=String.valueOf(tabindex++)%>" styleClass="smallInputFieldView"   readonly="true"  /></td>
                </tr>
                 <tr>
                     <td align="center" valign="middle"><html:select property="eduUcNo_2"         tabindex="<%=String.valueOf(tabindex++)%>" styleClass="smallInputField">  <html:option value="*">اختر</html:option> <logic:present name="univColgList"><html:options collection="univColgList" property="value"  labelProperty="label"/></logic:present></html:select> </td>
                     <td align="center" valign="middle"><html:select property="eduUcCountry_2"    tabindex="<%=String.valueOf(tabindex++)%>" styleClass="smallInputField"  onchange="fillPerCovList(this.value,'eduUcGovernate_2','eduUcLocality_2')">  <html:option value="*">اختر</html:option> <logic:present name="countryList"><html:options collection="countryList" property="value"  labelProperty="label"/></logic:present></html:select> </td>
                     <td align="center" valign="middle"><html:select property="eduUcGovernate_2"  tabindex="<%=String.valueOf(tabindex++)%>" styleClass="smallInputField"  onchange="fillNextList('perlocal','eduUcLocality_2',this.value,document.forms[0].eduUcCountry_2.options[document.forms[0].eduUcCountry_2.selectedIndex].value)">  <html:option value="*">اختر</html:option><logic:present name="eduUcGovernate_2List"><html:options collection="eduUcGovernate_2List" property="value"  labelProperty="label"/></logic:present> </html:select> </td>
                     <td align="center" valign="middle"><html:select property="eduUcLocality_2"   tabindex="<%=String.valueOf(tabindex++)%>" styleClass="smallInputField">  <html:option value="*">اختر</html:option><logic:present name="eduUcLocality_2List"><html:options collection="eduUcLocality_2List" property="value"  labelProperty="label"/></logic:present> </html:select> </td>
                     <td align="center" valign="middle"><html:text   property="eduStartDate_2"    tabindex="<%=String.valueOf(tabindex++)%>" styleClass="smallInputFieldView"   readonly="true"  /> - <html:text   property="eduEndDate_2" styleClass="smallInputFieldView"  readonly="true"  /></td>
                     <td align="center" valign="middle"><html:select property="rsdSpecNo_2"       tabindex="<%=String.valueOf(tabindex++)%>" styleClass="smallInputField">  <html:option value="*">اختر</html:option> <logic:present name="specDiplomaList"><html:options collection="specDiplomaList" property="value"  labelProperty="label"/></logic:present></html:select> </td>
                     <td align="center" valign="middle"><html:select property="eduSpecTypeNo_2"   tabindex="<%=String.valueOf(tabindex++)%>" styleClass="smallInputField">  <html:option value="*">اختر</html:option> <logic:present name="specTypesList"><html:options collection="specTypesList" property="value"  labelProperty="label"/></logic:present></html:select> </td>
                     <td align="center" valign="middle"><html:text   property="eduGradeDate_2"    tabindex="<%=String.valueOf(tabindex++)%>" styleClass="smallInputFieldView"   readonly="true"  /></td>
                </tr>
                <tr>
                     <td align="center" valign="middle"><html:select property="eduUcNo_3"         tabindex="<%=String.valueOf(tabindex++)%>" styleClass="smallInputField">  <html:option value="*">اختر</html:option> <logic:present name="univColgList"><html:options collection="univColgList" property="value"  labelProperty="label"/></logic:present></html:select> </td>
                     <td align="center" valign="middle"><html:select property="eduUcCountry_3"    tabindex="<%=String.valueOf(tabindex++)%>" styleClass="smallInputField"  onchange="fillPerCovList(this.value,'eduUcGovernate_3','eduUcLocality_3')">  <html:option value="*">اختر</html:option> <logic:present name="countryList"><html:options collection="countryList" property="value"  labelProperty="label"/></logic:present></html:select> </td>
                     <td align="center" valign="middle"><html:select property="eduUcGovernate_3"  tabindex="<%=String.valueOf(tabindex++)%>" styleClass="smallInputField"  onchange="fillNextList('perlocal','eduUcLocality_3',this.value,document.forms[0].eduUcCountry_3.options[document.forms[0].eduUcCountry_3.selectedIndex].value)">  <html:option value="*">اختر</html:option><logic:present name="eduUcGovernate_3List"><html:options collection="eduUcGovernate_3List" property="value"  labelProperty="label"/></logic:present> </html:select> </td>
                     <td align="center" valign="middle"><html:select property="eduUcLocality_3"   tabindex="<%=String.valueOf(tabindex++)%>" styleClass="smallInputField">  <html:option value="*">اختر</html:option> <logic:present name="eduUcLocality_3List"><html:options collection="eduUcLocality_3List" property="value"  labelProperty="label"/></logic:present></html:select> </td>
                     <td align="center" valign="middle"><html:text   property="eduStartDate_3"    tabindex="<%=String.valueOf(tabindex++)%>" styleClass="smallInputFieldView"   readonly="true"  /> - <html:text   property="eduEndDate_3" styleClass="smallInputFieldView"  readonly="true"  /></td>
                     <td align="center" valign="middle"><html:select property="rsdSpecNo_3"       tabindex="<%=String.valueOf(tabindex++)%>" styleClass="smallInputField">  <html:option value="*">اختر</html:option> <logic:present name="specDiplomaList"><html:options collection="specDiplomaList" property="value"  labelProperty="label"/></logic:present></html:select> </td>
                     <td align="center" valign="middle"><html:select property="eduSpecTypeNo_3"   tabindex="<%=String.valueOf(tabindex++)%>" styleClass="smallInputField">  <html:option value="*">اختر</html:option> <logic:present name="specTypesList"><html:options collection="specTypesList" property="value"  labelProperty="label"/></logic:present></html:select> </td>
                     <td align="center" valign="middle"><html:text   property="eduGradeDate_3"    tabindex="<%=String.valueOf(tabindex++)%>" styleClass="smallInputFieldView"   readonly="true"  /></td>
                </tr>
                 
                </table>

           </td></tr>
           <tr><td>
               <br/>
               <table align="right"  border="0" cellpadding="0" cellspacing="2" dir="rtl">
                <tr><td colspan="4"   class="centerpage" dir="rtl"><font color="red">*</font>البرنامج الذي تريد الالتحاق به</td></tr>
                <tr>
                 <td width="22%" align="center" valign="middle" class="qou" dir="rtl">الخيار الاول - الكلية </td>
                 <td width="23%" align="center" valign="middle" class="qou" dir="rtl">الخيار الاول -التخصص</td>
                 <td width="10%">&nbsp;</td>
                 <td width="22%" align="center" valign="middle" class="qou" dir="rtl">الخيار الثاني - الكلية </td>
                 <td width="23%" align="center" valign="middle" class="qou" dir="rtl">الخيار الثاني -التخصص</td>
                </tr>
                <tr> 
                 <td align="center" valign="middle"><html:select property="collegeNo"  tabindex="<%=String.valueOf(tabindex++)%>" styleClass="largeInput" onchange = "fillNextList('specs', 'specNo',this.value)"> <html:option value="*">اختر</html:option>  <logic:present name="collegelList"><html:options collection="collegelList" property="value"  labelProperty="label"/></logic:present></html:select> </td>
                 <td align="center" valign="middle"><html:select property="specNo"  tabindex="<%=String.valueOf(tabindex++)%>" styleClass="largeInput"> <html:option value="*">اختر</html:option><logic:present name="specsCollegeList"><html:options collection="specsCollegeList" property="value"  labelProperty="label"/></logic:present>  </html:select> </td>
                 <td>&nbsp;</td>
                 <td align="center" valign="middle"><html:select property="collegeNoOther"  tabindex="<%=String.valueOf(tabindex++)%>" styleClass="largeInput" onchange = "fillNextList('specs', 'specNoOther',this.value)"> <html:option value="*">اختر</html:option>  <logic:present name="collegelList"><html:options collection="collegelList" property="value"  labelProperty="label"/></logic:present></html:select> </td>
                 <td align="center" valign="middle"><html:select property="specNoOther"  tabindex="<%=String.valueOf(tabindex++)%>" styleClass="largeInput"> <html:option value="*">اختر</html:option><logic:present name="specsCollegeList"><html:options collection="specsCollegeList" property="value"  labelProperty="label"/></logic:present>  </html:select> </td>
                </tr>
                </table>
                  <br/>&nbsp;<br/>&nbsp;<br/>&nbsp; 
           </td></tr>
           <tr>
               <td align="right">
               <table align="center" width="964" height="25" cellPadding="0" cellSpacing="0" border="0" class="borderRoundedLightColor" >
              <tr>
                <td align="right" valign="middle" width="964" height="25" class="qou9Bold">&nbsp;المقدرة اللغوية</td>
              </tr>
              </table>
               
               </td>
           </tr>
           <tr><td>
               <br/>
               <table align="right" width="700" border="0" cellpadding="0" cellspacing="2" dir="rtl">
                <tr><td colspan="4"   class="centerpage" dir="rtl"><font color="red">*</font>اللغات التي تعرفها بداية من لغتك الام  مع تحديد القدرة </td></tr>
                <tr>
                 <td width="160" align="center" valign="middle" class="qou" dir="rtl">اللغة</td>
                 <td width="160" align="center" valign="middle" class="qou" dir="rtl"> مستوى القراءة</td>
                 <td width="160" align="center" valign="middle" class="qou" dir="rtl">مستوى الكتابة </td>
                 <td width="160" align="center" valign="middle" class="qou" dir="rtl">مستوى المحادثة</td>
                </tr>
                <tr>
                 <td align="center" valign="middle"><html:select property="lngLangNo_1"        tabindex="<%=String.valueOf(tabindex++)%>" styleClass="largeInput">  <html:option value="*">اختر</html:option> <logic:present name="langList"><html:options collection="langList" property="value"  labelProperty="label"/></logic:present></html:select> </td>
                 <td align="center" valign="middle"><html:select property="lngReadLevelNo_1"   tabindex="<%=String.valueOf(tabindex++)%>" styleClass="largeInput">  <html:option value="*">اختر</html:option> <logic:present name="langLevelList"><html:options collection="langLevelList" property="value"  labelProperty="label"/></logic:present></html:select> </td>
                 <td align="center" valign="middle"><html:select property="lngWriteLevelNo_1"  tabindex="<%=String.valueOf(tabindex++)%>" styleClass="largeInput">  <html:option value="*">اختر</html:option> <logic:present name="langLevelList"><html:options collection="langLevelList" property="value"  labelProperty="label"/></logic:present></html:select> </td>
                 <td align="center" valign="middle"><html:select property="lngSpeakLevelNo_1"  tabindex="<%=String.valueOf(tabindex++)%>" styleClass="largeInput">  <html:option value="*">اختر</html:option> <logic:present name="langLevelList"><html:options collection="langLevelList" property="value"  labelProperty="label"/></logic:present></html:select> </td>
                </tr>
                <tr>
                 <td align="center" valign="middle"><html:select property="lngLangNo_2"        tabindex="<%=String.valueOf(tabindex++)%>" styleClass="largeInput">  <html:option value="*">اختر</html:option> <logic:present name="langList"><html:options collection="langList" property="value"  labelProperty="label"/></logic:present></html:select> </td>
                 <td align="center" valign="middle"><html:select property="lngReadLevelNo_2"   tabindex="<%=String.valueOf(tabindex++)%>" styleClass="largeInput">  <html:option value="*">اختر</html:option> <logic:present name="langLevelList"><html:options collection="langLevelList" property="value"  labelProperty="label"/></logic:present></html:select> </td>
                 <td align="center" valign="middle"><html:select property="lngWriteLevelNo_2"  tabindex="<%=String.valueOf(tabindex++)%>" styleClass="largeInput">  <html:option value="*">اختر</html:option> <logic:present name="langLevelList"><html:options collection="langLevelList" property="value"  labelProperty="label"/></logic:present></html:select> </td>
                 <td align="center" valign="middle"><html:select property="lngSpeakLevelNo_2"  tabindex="<%=String.valueOf(tabindex++)%>" styleClass="largeInput">  <html:option value="*">اختر</html:option> <logic:present name="langLevelList"><html:options collection="langLevelList" property="value"  labelProperty="label"/></logic:present></html:select> </td>
                </tr>
                <tr>
                 <td align="center" valign="middle"><html:select property="lngLangNo_3"        tabindex="<%=String.valueOf(tabindex++)%>" styleClass="largeInput">  <html:option value="*">اختر</html:option> <logic:present name="langList"><html:options collection="langList" property="value"  labelProperty="label"/></logic:present></html:select> </td>
                 <td align="center" valign="middle"><html:select property="lngReadLevelNo_3"   tabindex="<%=String.valueOf(tabindex++)%>" styleClass="largeInput">  <html:option value="*">اختر</html:option> <logic:present name="langLevelList"><html:options collection="langLevelList" property="value"  labelProperty="label"/></logic:present></html:select> </td>
                 <td align="center" valign="middle"><html:select property="lngWriteLevelNo_3"  tabindex="<%=String.valueOf(tabindex++)%>" styleClass="largeInput">  <html:option value="*">اختر</html:option> <logic:present name="langLevelList"><html:options collection="langLevelList" property="value"  labelProperty="label"/></logic:present></html:select> </td>
                 <td align="center" valign="middle"><html:select property="lngSpeakLevelNo_3"  tabindex="<%=String.valueOf(tabindex++)%>" styleClass="largeInput">  <html:option value="*">اختر</html:option> <logic:present name="langLevelList"><html:options collection="langLevelList" property="value"  labelProperty="label"/></logic:present></html:select> </td>
                </tr>
                </table>

           </td></tr>
            

            
            <tr  >
                <td align="right"><br/>&nbsp; </td>
            </tr>

            <tr  >
                <td align="center">

                    <logic:notPresent name="appAprove">
                     <input type="button" value="  حفظ  " class="enter"  tabindex="<%=String.valueOf(tabindex++)%>" onclick="javaScript:funSubmit('0')">&nbsp;
                     <input type="button" value="  تثبيت  " class="enter"  tabindex="<%=String.valueOf(tabindex++)%>" onclick="javaScript:funSubmit('1')">&nbsp;
                    </logic:notPresent>
                    <input type="button" value="  خروج  " class="enter"  tabindex="<%=String.valueOf(tabindex++)%>" onclick="javaScript:parent.location = '/logout.do'">&nbsp;

                </td>
            </tr>

       </table>
 </td>
</tr>

</table>
</html:form>