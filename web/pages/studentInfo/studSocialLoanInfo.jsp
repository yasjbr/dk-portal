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
         document.srvyLoanForm.tblId.value = '';
         document.srvyLoanForm.tblOprType.value = '';
         var cal1=  new Epoch('prsnDate','popup',document.srvyLoanForm.prsnDate);

         hasFamilyPLoanFun();
         takeLoanFun();


       };

 

       function confirmDeleteRecordPLoan(prsnCounter)
        {
                if(confirm('هل تريد حذف هذا السجل ؟'))
                {
                   document.srvyLoanForm.tblId.value = 'pLoan';
                   document.srvyLoanForm.prsnCounter.value = prsnCounter;
                   document.srvyLoanForm.tblOprType.value = 'D';
                   funSubmit();
                }
        }

       function confirmDeleteRecordFLoan(fmlyCounter)
        {
                if(confirm('هل تريد حذف هذا السجل ؟'))
                {
                   document.srvyLoanForm.tblId.value = 'fLoan';
                   document.srvyLoanForm.fmlyCounter.value = fmlyCounter;
                   document.srvyLoanForm.tblOprType.value = 'D';
                   funSubmit();
                }
        }
  
    function funSubmit()
    {
       window.srvyLoanForm.submit();
       return true;
    }


  

    function showHideDivPLoan(divIdV,divIdH ,p_oprType)
    {
       document.srvyLoanForm.tblId.value = 'pLoan';
       document.getElementById(divIdV).style.display="inline";
       document.getElementById(divIdH).style.display="none";
       document.srvyLoanForm.tblOprType.value = p_oprType;

       if(p_oprType == 'U')
       {
           document.getElementById('divTitlePLoan').innerHTML='تعديل';
       }
       else if(p_oprType == 'I')
       {
           document.getElementById('divTitlePLoan').innerHTML='اضافة حقل جديد'  ;
           document.srvyLoanForm.prsnCounter.value = '';
           document.srvyLoanForm.prsnLoaner.value = '';
           document.srvyLoanForm.prsnAmount.value = '';
           document.srvyLoanForm.prsnDate.value = ''; 
       }
    }

    function showHideDivFLoan(divIdV,divIdH ,p_oprType)
    {
       document.srvyLoanForm.tblId.value = 'fLoan';
       document.getElementById(divIdV).style.display="inline";
       document.getElementById(divIdH).style.display="none";
       document.srvyLoanForm.tblOprType.value = p_oprType;

       if(p_oprType == 'U')
       {
           document.getElementById('divTitleFLoan').innerHTML='تعديل';
       }
       else if(p_oprType == 'I')
       {
           document.getElementById('divTitleFLoan').innerHTML='اضافة حقل جديد'  ;
           document.srvyLoanForm.fmlyCounter.value = '';
           document.srvyLoanForm.fmlyLoaner.value = '';
           document.srvyLoanForm.fmlyType.value = '';
           document.srvyLoanForm.fmlyAmount.value = '';
           document.srvyLoanForm.fmlyPeriod.value = '';
        }

    }

  

    function editRecordPLoan(prsnCounter,prsnDate,prsnAmount,prsnLoaner)
    {
            document.srvyLoanForm.tblId.value = 'pLoan';
            document.srvyLoanForm.tblOprType.value = 'U';
            document.srvyLoanForm.prsnCounter.value = prsnCounter;
            document.srvyLoanForm.prsnDate.value = prsnDate;
            document.srvyLoanForm.prsnAmount.value = prsnAmount;
            document.srvyLoanForm.prsnLoaner.value = prsnLoaner; 
    }

   function editRecordFLoan(fmlyCounter,fmlyLoaner,fmlyType,fmlyAmount,fmlyPeriod)
    {
            document.srvyLoanForm.tblId.value = 'fLoan';
            document.srvyLoanForm.tblOprType.value = 'U';
            document.srvyLoanForm.fmlyCounter.value = fmlyCounter;
            document.srvyLoanForm.fmlyLoaner.value = fmlyLoaner;
            document.srvyLoanForm.fmlyType.value = fmlyType;
            document.srvyLoanForm.fmlyAmount.value = fmlyAmount;
            document.srvyLoanForm.fmlyPeriod.value = fmlyPeriod;
    }


     
    function takeLoanFun()
    {

        var selected_list =document.srvyLoanForm.takeLoan;
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
           document.getElementById("pLoanDiv").style.display="inline";
        }
        else
        {
            document.getElementById("pLoanDiv").style.display="none";
        }

    }

    function hasFamilyFLoanFun()
    {

        var selected_list =document.srvyLoanForm.hasFamilyLoan;
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
           document.getElementById("fLoanDiv").style.display="inline";
        }
        else
        {
            document.getElementById("fLoanDiv").style.display="none";
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

 <html:form  action="saveStudSocialLoanInfo.do"  method="post"    >
     <html:hidden property="fmlyCounter"       />
     <html:hidden property="prsnCounter"       />
     <html:hidden property="tblOprType"        />
     <html:hidden property="tblId"             />
    <tr>
      <td>
          <table width="100%" align="center" class="qou" border="0" cellpadding="0" cellspacing="0">

                <tr>
                    <td  align="right"  >
                        <table width="80%" align="right" class="qou" border="0" cellpadding="3" cellspacing="0">
                          <tr class="tableRowClearColor">
                            <td   align="right" class="qouRtl"  valign="bottom"  >  &nbsp;</td>
                            <td   align="right" class="qouRtl"  valign="bottom"  >

                                <html:radio property="applyLoan" tabindex="<%=String.valueOf(tabindex++)%>"   onclick="applyLoanFun()"    value="N"    />لا
                                &nbsp;
                                <html:radio property="applyLoan" tabindex="<%=String.valueOf(tabindex++)%>"   onclick="applyLoanFun()"  value="Y"    />نعم
                                &nbsp;
                            </td>
                            <td   align="right"   class="qou9BoldRtl">7.1	هل ستقوم بتقديم طلب للحصول على مساعدة مالية أو عبر برنامج العمل الطلابي بالكلية؟</td>

                        </tr>
                        <tr><td colspan="3"  align="right" >
                            <table width="50%" align="right" class="qou" border="0" cellpadding="2" cellspacing="2">
                            <tr>
                               <td colspan="2"  align="right">
                                 <html:text   property="applyReason"  maxlength="100" styleClass="largeInput" tabindex="<%=String.valueOf(tabindex++)%>" />
                               </td>
                               <td colspan="2" align="right">
	إذا كان الجواب "بنعم"، ما هو السبب؟                                </td>
                               <td   align="center">
                                 <lu><li></li></lu>
                               </td>
                            </tr>
                           </table>
                        </td></tr>
                         <tr class="tableRowClearColor">
                            <td   align="right" class="qouRtl"  valign="bottom"  >  &nbsp;</td>
                            <td   align="right" class="qouRtl"  valign="bottom"  >

                                <html:radio property="takeLoan" tabindex="<%=String.valueOf(tabindex++)%>"   onclick="takeLoanFun()"    value="Y"    />نعم
                                &nbsp;
                                <html:radio property="takeLoan" tabindex="<%=String.valueOf(tabindex++)%>"   onclick="takeLoanFun()"  value="N"    />لا
                                &nbsp;
                            </td>
                            <td   align="right"   class="qou9BoldRtl">7.2	هل سبق وأن حصلت على منحة أو قرضٍ من أية مؤسسة من خارج الكلية؟</td>

                        </tr>
                           <tr><td colspan="3"  align="right" >
                            <table width="80%" align="right" class="qou" border="0" cellpadding="2" cellspacing="2">
                            <tr>
                               <td colspan="3" align="right">
	إذا كان الجواب "بنعم"، فهل كانت هذه؟</td>
                               <td   align="center">
                                 <lu><li></li></lu>
                               </td>
                            </tr>
                                <tr>
                             <td    align="right" class="qouRtl"  valign="middle">
                               <html:text   property="loanTermCount"  maxlength="100" styleClass="largeInput" tabindex="<%=String.valueOf(tabindex++)%>" />
                             </td>
                             <td   align="center" class="qouRtl"  valign="middle">
عدد الفصول أو السنوات
                             </td>
                             <td  align="center" class="qouRtl"  valign="bottom">
                             <table width="100%"  align="center" class="qouRtl" border="0" cellpadding="0" cellspacing="0"><tr>
                             <td width="25%"  align="right" class="qouRtl" ><html:radio property="loanType" tabindex="<%=String.valueOf(tabindex++)%>"     value="sc"    />منحة</td>
                             <td width="25%"  align="right" class="qouRtl" ><html:radio property="loanType" tabindex="<%=String.valueOf(tabindex++)%>"     value="ln"    />قرض</td>
                             <td width="25%"  align="right" class="qouRtl" ><html:radio property="loanPeriod" tabindex="<%=String.valueOf(tabindex++)%>"     value="tr"    />فصلي/ة</td>
                             <td width="25%"  align="right" class="qouRtl" ><html:radio property="loanPeriod" tabindex="<%=String.valueOf(tabindex++)%>"     value="yr"    />سنوي/ة</td>
                             </tr></table>
                             </td>
                            <td></td>
                          </tr>
                                <tr>
                               <td colspan="3" class="qourtl" align="right">
	أذكر المصدر:</td>
                               <td   align="center">
                                 <lu><li></li></lu>
                               </td>
                            </tr>
                           </table>
                        </td></tr> 


                       </table>
                    </td>
                </tr>  
              <tr>
                  <td>
                        <div id="pLoanDiv" >
                            <div id="viewPLoanDiv">
                            <logic:present name="retListPLoan">
                            <% int i = 1; %>
                            <br/>
                            <table width="100%" border="0" cellspacing="0" cellpadding="0" class="borderRoundedClearColor" bgcolor="#f38e00">
                            <tr class="tabheader">
                            <td width="10%">&nbsp;</td> 
                            <td width="10%"><div dir="rtl" align="center">التاريخ</div></td>
                            <td width="30%"><div align="center">المبلغ بالشيقل الاسرائيلي</div></td>
                            <td width="40%"><div align="center">اسم الشخص/المؤسسة</div></td>
                            <td width="5%"><div align="center">&nbsp;</div></td>
                            </tr>
                            <logic:iterate id="retListPLoan" name="retListPLoan" >
                            <%  if (i%2 == 0) { %>
                            <tr  class="tableRowClearColor"  onMouseOver="this.className='highlight'" onMouseOut="this.className='tableRowClearColor'">

                            <%}else {%>
                            <tr class="tableRowLightColor"  onMouseOver="this.className='highlight'" onMouseOut="this.className='tableRowLightColor'">
                            <%}%>
                            <td align="center">
                            <a  href="javascript:confirmDeleteRecordPLoan('<bean:write name="retListPLoan" property="comp_id.prsnCounter"/>')" title="حذف"><img src="/pages/resources/images/recDelete.gif" border="0" alt="حذف"  width="20" height="20"/></a>
                            &nbsp;
                            <a href="javascript:showHideDivPLoan('addPLoanDiv','viewPLoanDiv','U'); editRecordPLoan('<bean:write name="retListPLoan" property="comp_id.prsnCounter"/>','<bean:write name="retListPLoan" property="prsnDate"  />','<bean:write name="retListPLoan" property="prsnAmount"/>','<bean:write name="retListPLoan" property="prsnLoaner"/>'); " title="تعديل"><img src="/pages/resources/images/recEdit.gif" border="0" alt="تعديل" width="20" height="20"/></a>

                            &nbsp;
                            </td>
                            <td class="qou"><div align="center"><bean:write name="retListPLoan" property="prsnDate"  format="dd-MM-yyyy"/></div></td>
                            <td class="qou"><div align="center"><bean:write name="retListPLoan" property="prsnAmount"   /></div></td>
                            <td class="qou"><div align="center"><bean:write name="retListPLoan" property="prsnLoaner"/></div></td>
                            <td class="qou"><div align="center"><%=i%></div></td>
                            </tr>
                            <% i++; %>
                            </logic:iterate>
                            <tr><td colspan="7" align="center">&nbsp;<a class="tabheaderBorderFullRounded" href="javascript:showHideDivPLoan('addPLoanDiv','viewPLoanDiv','I');">اضافة حقل جديد</a></td></tr>
                            </table>
                            </logic:present>
                            <logic:notPresent name="retListPLoan">
                            <table width="100%" border="0" cellspacing="0" cellpadding="0"  >
                            <tr><td>&nbsp;</td></tr>
                            <tr><td align="center" class="tableRowLightColor textDate"> لا توجد بيانات - <a  href="javascript:showHideDivPLoan('addPLoanDiv','viewPLoanDiv','I');">اضغط هنا للاضافة</a></td></tr>
                            <tr><td>&nbsp;</td></tr>
                            </table>
                            </logic:notPresent>
                            </div>
                        <div id="addPLoanDiv" style="display:none;">
                         <br/>
                        <table width="95%" align="center" class="borderRoundedClearColor" border="0" cellpadding="0" cellspacing="0">
                        <tr>
                        <td colspan="4" class="tabHeaderBigColor" align="center"> <div id="divTitlePLoan"> </div></td>
                        </tr>
                        <tr>
                        <td align="right" ><html:text property="prsnAmount"  tabindex="<%=String.valueOf(tabindex++)%>" styleClass="largeInput"  /> </td>
                        <td align="right" class="qou9Bold">المبلغ بالشيقل الاسرائيلي</td>
                        <td align="right" >
                          <html:text property="prsnLoaner"  tabindex="<%=String.valueOf(tabindex++)%>" styleClass="largeInput"  />
                        </td>
                        <td align="right" class="qou9BoldRtl" >اسم الشخص/المؤسسة</td>
                        </tr>
                        <tr class="tableRowLightColor">
                        <td align="right" width="20%">&nbsp;</td>
                        <td align="right" width="30%" class="qou9Bold">&nbsp;</td>
                        <td align="right" width="20%">
                          <html:text   property="prsnDate" readonly="true"  maxlength="100" styleClass="largeInputView"  tabindex="<%=String.valueOf(tabindex++)%>" />
                        </td>
                        <td align="right" width="30%" class="qou9Bold">التاريخ</td>
                        </tr>
                        <tr  >
                        <td  align="center" colspan="4">
                        <input type="button" value=" &nbsp;&nbsp;&nbsp; الغاء  &nbsp;&nbsp;&nbsp;" class="enter"  tabindex="<%=String.valueOf(tabindex++)%>" onclick="javascript:showHideDivPLoan('viewPLoanDiv','addPLoanDiv','')" >&nbsp;
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

                                <html:radio property="hasFamilyLoan" tabindex="<%=String.valueOf(tabindex++)%>"   onclick="hasFamilyFLoanFun()"    value="Y"    /> نعم
                                &nbsp;
                                <html:radio property="hasFamilyLoan" tabindex="<%=String.valueOf(tabindex++)%>"   onclick="hasFamilyFLoanFun()"  value="N"    /> لا
                                &nbsp;
                            </td>
                            <td width="40%"   align="right"   class="qou9BoldRtl">7.3	هل تتسلم العائلة أي نوع من المساعدة؟</td>

                        </tr>
                      </table>
                  </td>
              </tr>
              <tr>
                  <td>
                       <div id="fLoanDiv" >
                           <div align="right" class="qouRtl"><lu><li>	إذا كان الجواب "بنعم"، وضح:</li></lu></div>
                            <div id="viewFLoanDiv">
                            <logic:present name="retListFLoan">
                            <% int i = 1; %>
                            <br/>
                            <table width="100%" border="0" cellspacing="0" cellpadding="0" class="borderRoundedClearColor" bgcolor="#f38e00">
                            <tr class="tabheader">
                            <td width="10%">&nbsp;</td>
                            <td width="20%"><div dir="rtl" align="center">مدة المساعدة</div></td>
                            <td width="20%"><div dir="rtl" align="center">المبلغ بالشيقل الاسرائيلي</div></td>
                            <td width="20%"><div align="center">نوع المساعدة  </div></td>
                            <td width="20%"><div align="center">اسم الشخص/المؤسسة التي تقدم المساعدة </div></td>
                            <td width="5%"><div align="center">&nbsp;</div></td>
                            </tr>
                            <logic:iterate id="retListFLoan" name="retListFLoan" >
                            <%  if (i%2 == 0) { %>
                            <tr  class="tableRowClearColor"  onMouseOver="this.className='highlight'" onMouseOut="this.className='tableRowClearColor'">

                            <%}else {%>
                            <tr class="tableRowLightColor"  onMouseOver="this.className='highlight'" onMouseOut="this.className='tableRowLightColor'">
                            <%}%>
                            <td align="center">
                            <a  href="javascript:confirmDeleteRecordFLoan('<bean:write name="retListFLoan" property="comp_id.fmlyCounter"/>')" title="حذف"><img src="/pages/resources/images/recDelete.gif" border="0" alt="حذف"  width="20" height="20"/></a>
                            &nbsp;
                            <a href="javascript:showHideDivFLoan('addFLoanDiv','viewFLoanDiv','U'); editRecordFLoan('<bean:write name="retListFLoan" property="comp_id.fmlyCounter"/>','<bean:write name="retListFLoan" property="fmlyLoaner"  />','<bean:write name="retListFLoan" property="fmlyType"/>','<bean:write name="retListFLoan" property="fmlyAmount"/>' ,'<bean:write name="retListFLoan" property="fmlyPeriod"/>' ); " title="تعديل"><img src="/pages/resources/images/recEdit.gif" border="0" alt="تعديل" width="20" height="20"/></a>

                            &nbsp;
                            </td>
                            <td class="qou"><div align="center">
                                 <logic:equal name="retListFLoan" property="fmlyPeriod" value="mn">شهرية</logic:equal>
                                 <logic:equal name="retListFLoan" property="fmlyPeriod" value="yr">سنوية</logic:equal>
                                 <logic:equal name="retListFLoan" property="fmlyPeriod" value="ot">غير ذلك</logic:equal>
                            </div></td>
                            <td class="qou"><div align="center"><bean:write name="retListFLoan" property="fmlyAmount"/></div></td>
                            <td class="qou"><div align="center">
                                <logic:equal name="retListFLoan" property="fmlyType" value="lg">عينية</logic:equal>
                                <logic:equal name="retListFLoan" property="fmlyType" value="ph">مادية</logic:equal>
                            </div></td>
                            <td class="qou"><div align="center"><bean:write name="retListFLoan" property="fmlyLoaner"/></div></td>
                            <td class="qou"><div align="center"><%=i%></div></td>
                            </tr>
                            <% i++; %>
                            </logic:iterate>
                            <tr><td colspan="7" align="center">&nbsp;<a class="tabheaderBorderFullRounded" href="javascript:showHideDivFLoan('addFLoanDiv','viewFLoanDiv','I');">اضافة حقل جديد</a></td></tr>
                            </table>
                            </logic:present>
                            <logic:notPresent name="retListFLoan">
                            <table width="100%" border="0" cellspacing="0" cellpadding="0"  >
                            <tr><td>&nbsp;</td></tr>
                            <tr><td align="center" class="tableRowLightColor textDate"> لا توجد بيانات - <a  href="javascript:showHideDivFLoan('addFLoanDiv','viewFLoanDiv','I');">اضغط هنا للاضافة</a></td></tr>
                            <tr><td>&nbsp;</td></tr>
                            </table>
                            </logic:notPresent>
                            </div>
                        <div id="addFLoanDiv" style="display:none;">
                        <br/>
                        <table width="95%" dir="ltr" align="center" class="borderRoundedClearColor" border="0" cellpadding="0" cellspacing="0">
                        <tr>
                        <td colspan="4" class="tabHeaderBigColor" align="center"> <div id="divTitleFLoan"> </div></td>
                        </tr>
                        <tr class="tableRowLightColor">
                         <td align="right" width="20%">
                              <html:select property="fmlyType"  tabindex="<%=String.valueOf(tabindex++)%>" styleClass="largeInput"  >
                                <html:option value="lg">عينية</html:option>
                                <html:option value="ph">مادية</html:option>
                            </html:select>
                         </td>
                         <td align="right" width="25%" class="qou9BoldRtl">نوع المساعدة</td>
                         <td align="right" width="25%"> <html:text   property="fmlyLoaner"   maxlength="100" styleClass="largeInput"  tabindex="<%=String.valueOf(tabindex++)%>" /> </td>
                         <td align="right" width="30%" class="qou9Bold">اسم الشخص/المؤسسة التي تقدم المساعدة</td>
                        </tr>
                        <tr>
                         <td align="right" width="20%">
                            <html:select property="fmlyPeriod"  tabindex="<%=String.valueOf(tabindex++)%>" styleClass="largeInput"  >
                                <html:option value="mn">شهرية</html:option>
                                <html:option value="yr">سنوية</html:option>
                                <html:option value="ot">غير ذلك</html:option>
                            </html:select>
                         </td>
                         <td align="right" width="25%" class="qou9BoldRtl">مدة المساعدة</td>
                         <td align="right" width="25%"> <html:text   property="fmlyAmount"   maxlength="100" styleClass="largeInput"  tabindex="<%=String.valueOf(tabindex++)%>" /> </td>
                         <td align="right" width="30%" class="qou9Bold">المبلغ بالشيقل الاسرائيلي</td>
                        </tr>
                        <tr  >
                        <td  align="center" colspan="4">
                        <input type="button" value=" &nbsp;&nbsp;&nbsp; الغاء  &nbsp;&nbsp;&nbsp;" class="enter"  tabindex="<%=String.valueOf(tabindex++)%>" onclick="javascript:showHideDivFLoan('viewFLoanDiv','addFLoanDiv','');" >&nbsp;
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