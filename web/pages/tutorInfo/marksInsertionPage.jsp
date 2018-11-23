<%@ page import="ps.edu.diyar.common.tools.Randomizer" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/lib/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/lib/struts-html.tld" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
  

<script>



 function going(value1)
  {
   if(value1=="1")
   {
    if(confirm("الرجاء تأكيد عملية التثبيت"))
     {
      document.all.submitValue.value=value1;
      document.forms[0].submit();
      return true;
     }
   }else{
    document.all.submitValue.value=value1;
    document.forms[0].submit();
    return true;
   }
  }

  

var timerID = 0;
var tStart  = null;
var tStart1  = null;

function UpdateTimer() {

   if(timerID) {
      clearTimeout(timerID);
      clockID  = 0;
   }

   if(!tStart)
      tStart   = new Date();

   if(!tStart1)
    {
     tStart1   = new Date();
     tStart1.setMinutes(15);
     tStart1.setSeconds(0);
    }
   var   tDate = new Date();
   var   tDiff = tDate.getTime() - tStart.getTime();
   tDate.setTime(tDiff);
    tDiff = tStart1.getTime()-tDate.getTime();
   tDate.setTime(tDiff);

   document.marksInsertionForm.theTime.value = ""
                                   + tDate.getMinutes() + ":"
                                   + tDate.getSeconds();
   if(document.marksInsertionForm.theTime.value=="1:0")
    {

     window.open('/pages/sharedIncludes/marksAutoSave.html','ann','toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no,width=350,height=110')
     going('2')
    }

   if(document.marksInsertionForm.theTime.value=="0:0" || tDate.getMinutes() > 15)
   {
    Reset()
    Stop();
   }
   else
    timerID = setTimeout("UpdateTimer()", 1000);
}

function Start() {
   tStart   = new Date();
   if(document.marksInsertionForm.theTime)
   {
    document.marksInsertionForm.theTime.value = "15:00";
    timerID  = setTimeout("UpdateTimer()", 1000);
   }
}

function Stop()
{
   if(timerID)
   {
      timerID = 0;
      clearTimeout(timerID);
   }

   tStart = null;
}

function Reset()
{
   tStart = null;

   document.marksInsertionForm.theTime.value = "00:00";
}





</script>
 <script type="text/javascript">

      var current_x;
      var current_y;
      var current_x_txt=["finalPrac","finalExam","mid1","hw2","hw1"];

      var next_x;
      var next_y;

      document.onkeydown = check;

      function check(e){

      next_x=current_x  ;
      next_y =current_y  ;

      if (!e) var e = window.event;

      (e.keyCode) ? key = e.keyCode : key = e.which;

      var pr_row_id=document.getElementById(current_y);

      try{


       switch(key){

      case 37:  next_x = (current_x>0 ? current_x- 1 :current_x) ; break; //left

      case 38:  next_y = (current_y>1 ?  current_y- 1:current_y);
                if(pr_row_id.id %2!=0)
                pr_row_id.className='normal';
                else
                pr_row_id.className='tableRowLightColor';
                break; //up

      case 39:  next_x = (current_x <4 ? (1*current_x) + 1 :current_x); break; //right

      case 40:  next_y = (current_y <rowCount? (1*current_y)+ 1:current_y);
                if(pr_row_id.id %2!=0)
                pr_row_id.className='normal';
                else
                pr_row_id.className='tableRowLightColor';

                break; //down

      }

      var nxt_row_id=document.getElementById(next_y);

      switch(key){
      case 38:  nxt_row_id.className='highlight';  break; //up
      case 40:  nxt_row_id.className='highlight';  break; //down

      }

      if (key==37|key==38|key==39|key==40){

       var code=document.getElementsByName(current_x_txt[current_x]+current_y)[0].value;
      if(code!=""){}
      (document.getElementsByName(current_x_txt[next_x]+next_y)[0]).focus();

       current_x = next_x;
       current_y = next_y;

      }

      }catch(Exception){ }
      }

      function setCurrent(element){
       current_x = element.slice(0,1);
       current_y = element.slice(1,element.length);
       var row_id=document.getElementById(current_y);
       row_id.className='highlight';
       rowReColor();
      }
         function rowReColor()
      {
         for(i=1;i<=rowCount;i++)
        {
            var rowId_c=document.getElementById(i);
            if(i != current_y)
            {
                if(i %2!=0)
                rowId_c.className='normal';
                else
                rowId_c.className='tableRowLightColor';
            }
        }
      }
	</script>
<%
  response.setHeader("pragma", "no-cache");
  response.setHeader("Cache-Control", "no-cache");
  response.setHeader("Expires", "0");
%>
<link href="/pages/resources/css/dr_portal_style.css" rel="stylesheet" type="text/css">
<html:form action="insertedMarksCheck.do" method="post" >


<table width="99%" border=0 align="left" cellPadding=0 cellSpacing=0 class="qou"  >
  <TBODY>
    <TR>
      <TD width="99%" >
        <div align="center">
          <table width="100%" border="0">
            <tr>
              <td width="100%" valign="top">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0" >
                     <tr class="subtitle"  bgcolor="#E00000">
                          <td width="99%" dir="rtl" align="center">
                              <html:errors/>
                              
                           <logic:present name="error.marksApproved">
                            <table width="81%" height="30" align="center" cellpadding="0" cellspacing="0" class="border">
                             <tr>
                              <td height="28" bgcolor="#E00000" ><div align="center" class="subtitle">
                             ناسف ,لايمكنك التعديل على البيانات المثبتة,الرجاء مراجعة التسجيل.
                              </div></td>
                             </tr>
                            </table><br>
                           </logic:present>
                          </td>
                        </tr>
                    <tr>
				    <td>
				    <logic:present name="studentListForCourse">
                        <br/>
                  <table width="100%" align="right" border="0" class="borderRoundedLightColor">

                    <tr>
                         <td   ><div align="right" class="qou"><%=request.getParameter("classNo")%></div></td>
                        <td class="tabheader" width="13%"><div align="center">:الشعبة</div>

		    <html:hidden property="classNo" value='<%=request.getParameter("classNo")%>'/>
                    <html:hidden property="termNo" value='<%=request.getParameter("termNo")%>'/>
                    <html:hidden property="crsNo" value='<%=request.getParameter("crsNo")%>'/>
                    </td>
                       <td   width="13%"><div align="right" class="qou"><%=request.getParameter("crsNo")%></div></td>
                       <td class="tabheader" width="13%"><div align="center">:رقم المقرر</div></td>
                       <logic:present name="courseInfo" >
                       <logic:iterate id="courseInfo" name="courseInfo" >
                        <td   width="35%" ><div align="right" class="qou"><bean:write name="courseInfo" property="crsAName"/></div></td>
                        <td class="tabheader" width="15%"><div align="center">:اسم المقرر</div></td>
                       </logic:iterate>
                       </logic:present>
                       <logic:notPresent name="courseInfo" >
                       <td   width="13%"><div align="right" class="qou"></div></td>
                       <td class="tabheader" width="13%"><div align="right"></div></td>
                       </logic:notPresent>

                    </tr>
                     <logic:present name="calenderInfo">
                       <logic:iterate id="calenderInfo" name="calenderInfo" >
                           <tr><td colspan="6"  height="1"  background="/pages/resources/images/menuBg.gif"></td></tr>
                          <tr>
                           <td   width="13%"><div align="right" class="qou"><bean:write name="calenderInfo" property="endDate" format="dd-MM-yyyy"/></div></td>
                           <td class="tabheader" width="13%"><div align="center">:إلى</div></td>

                           <td   width="13%"><div align="right" class="qou"><bean:write name="calenderInfo" property="begDate" format="dd-MM-yyyy"/></div></td>
                           <td class="tabheader" width="13%"><div align="center">:من</div></td>

                           <td   width="35%"><div align="right" class="qou">فترة ادخال العلامات</div></td>
                           <td class="tabheader" width="15%"><div align="center">:نوع التقويم</div></td>
                          </tr>
                           </logic:iterate>
                      </logic:present>
                           
                     <logic:present name="calenderInfoM1">
                         <logic:iterate id="calenderInfoM1" name="calenderInfoM1" >
                           <tr><td colspan="6"  height="1"  background="/pages/resources/images/menuBg.gif"></td></tr>
                          <tr>
                           <td   width="13%"><div align="right" class="qou"><bean:write name="calenderInfoM1" property="endDate" format="dd-MM-yyyy"/></div></td>
                           <td class="tabheader" width="13%"><div align="center">:إلى</div></td>

                           <td   width="13%"><div align="right" class="qou"><bean:write name="calenderInfoM1" property="begDate" format="dd-MM-yyyy"/></div></td>
                           <td class="tabheader" width="13%"><div align="center">:من</div></td>

                           <td   width="35%"><div align="right" class="qou">  علامة الامتحان الاول   </div></td>
                           <td class="tabheader" width="15%"><div align="center">:نوع التقويم</div></td>
                          </tr>
                         </logic:iterate>
                      </logic:present>
                           
                            <logic:present name="calenderInfoM2">
                         <logic:iterate id="calenderInfoM2" name="calenderInfoM2" >
                           <tr><td colspan="6"  height="1"  background="/pages/resources/images/menuBg.gif"></td></tr>
                          <tr>
                           <td   width="13%"><div align="right" class="qou"><bean:write name="calenderInfoM2" property="endDate" format="dd-MM-yyyy"/></div></td>
                           <td class="tabheader" width="13%"><div align="center">:إلى</div></td>

                           <td   width="13%"><div align="right" class="qou"><bean:write name="calenderInfoM2" property="begDate" format="dd-MM-yyyy"/></div></td>
                           <td class="tabheader" width="13%"><div align="center">:من</div></td>

                           <td   width="35%"><div align="right" class="qou">   علامة الامتحان الثاني       </div></td>
                           <td class="tabheader" width="15%"><div align="center">:نوع التقويم</div></td>
                          </tr>
                         </logic:iterate>
                      </logic:present>
                           
                           
                             <logic:present name="calenderInfoMMid">
                         <logic:iterate id="calenderInfoMMid" name="calenderInfoMMid" >
                           <tr><td colspan="6"  height="1"  background="/pages/resources/images/menuBg.gif"></td></tr>
                          <tr>
                           <td   width="13%"><div align="right" class="qou"><bean:write name="calenderInfoMMid" property="endDate" format="dd-MM-yyyy"/></div></td>
                           <td class="tabheader" width="13%"><div align="center">:إلى</div></td>

                           <td   width="13%"><div align="right" class="qou"><bean:write name="calenderInfoMMid" property="begDate" format="dd-MM-yyyy"/></div></td>
                           <td class="tabheader" width="13%"><div align="center">:من</div></td>

                           <td   width="35%"><div align="right" class="qou">   علامة الامتحان النصفي       </div></td>
                           <td class="tabheader" width="15%"><div align="center">:نوع التقويم</div></td>
                          </tr>
                         </logic:iterate>
                      </logic:present>
                           
                           
                            <logic:present name="calenderInfoMFin">
                         <logic:iterate id="calenderInfoMFin" name="calenderInfoMFin" >
                           <tr><td colspan="6"  height="1"  background="/pages/resources/images/menuBg.gif"></td></tr>
                          <tr>
                           <td   width="13%"><div align="right" class="qou"><bean:write name="calenderInfoMFin" property="endDate" format="dd-MM-yyyy"/></div></td>
                           <td class="tabheader" width="13%"><div align="center">:إلى</div></td>

                           <td   width="13%"><div align="right" class="qou"><bean:write name="calenderInfoMFin" property="begDate" format="dd-MM-yyyy"/></div></td>
                           <td class="tabheader" width="13%"><div align="center">:من</div></td>

                           <td   width="35%"><div align="right" class="qou">   علامة الامتحان النهائي       </div></td>
                           <td class="tabheader" width="15%"><div align="center">:نوع التقويم</div></td>
                          </tr>
                         </logic:iterate>
                      </logic:present>
                           
                  </table>
				   </logic:present>
					</td>
				   </tr>
				    <tr>
                      <td> 
                      <logic:present name="calenderInfo">
                        <table align="right">
                            <tr>
                                <td class="qou" align="right">ينصح بإجراء حفظ للعلامات قبل انتهاء الوقت المتبقي تجنبا لفقدها</td>
                                <td><input type="text" readonly name="theTime" class="readonlyInputFieldSmaller"></td>
                                <td class="qou" align="right">: الوقت المتبقي قبل انقطاع الاتصال مع الخادم هو</td>
                                <td class="centerpage" align="right"><font color="red">: هام</font></td>
                            </tr>
                        </table><br>
                       </logic:present>
                        </td>
				   </tr>
				    <%--<tr>--%>
                      <%--<td>--%>
                         <%--<div align="right"><br>--%>
                               <%--<a href="/tutor/studListReport?.rv=<%=Randomizer.shortRandom()%>&classNo=<%=request.getParameter("classNo")%>&crsNo=<%=request.getParameter("crsNo")%>&termNo=<%=request.getParameter("termNo")%>&t=f&src=mi" class="centerpage" target="_blank">طباعة نموذج</a>--%>
                             <%--| <a href="/tutor/studListReport?.rv=<%=Randomizer.shortRandom()%>&classNo=<%=request.getParameter("classNo")%>&crsNo=<%=request.getParameter("crsNo")%>&termNo=<%=request.getParameter("termNo")%>&t=m&src=mi" class="centerpage" target="_blank">طباعة نموذج مع علامات النصفي</a>--%>
                             <%--| <a href="/tutor/studListReport?.rv=<%=Randomizer.shortRandom()%>&classNo=<%=request.getParameter("classNo")%>&crsNo=<%=request.getParameter("crsNo")%>&termNo=<%=request.getParameter("termNo")%>&t=e&src=mi" class="centerpage" target="_blank">طباعة نموذج فارغ</a> <img src="/pages/resources/images/printer.gif">--%>
                        <%--</div>--%>
                          <%--</td>--%>
				   <%--</tr>--%>
				    <tr>
                      <td>
                      <logic:present name="studentListForCourse">
                          <div align="right"><br/>
                           <table align="right" width="100%" border="0" class="borderRoundedClearColor">
                               
                               <tr>
                                  
                               <td class="tabheader" width="10%"><div align="center">العلامة</div></td>
                               <td class="tabheader" width="10%"><div align="center">النهائي</div></td>
                               <td class="tabheader" width="10%"><div align="center">النصفي</div></td>
                               <td class="tabheader" width="10%"><div align="center">الثاني</div></td>
                               <td class="tabheader" width="10%"><div align="center">الاول</div></td>
                               <td class="tabheader" width="25%"><div align="center">اسم الطالب</div></td>
                               <td class="tabheader" width="20%"><div align="center">رقم الطالب</div></td>
                               <td class="tabheader" width="5%"><div align="center">م</div></td>
                               </tr>
                                 <tr><td colspan="6"  height="1"  background="/pages/resources/images/menuBg.gif"></td></tr>
                                <logic:present name="courseWt">
                                    <logic:iterate id="courseWt" name="courseWt" >
                               <tr>
                               <td class="tabheader" width="10%"><div align="center">  </div></td> 
                               <td class="tabheader" width="10%"><div align="center"><bean:write name="courseWt" property="finalm"/></div></td> 
                               <td class="tabheader" width="10%"><div align="center"><bean:write name="courseWt" property="mid"/></div></td> 
                               <td class="tabheader" width="10%"><div align="center"><bean:write name="courseWt" property="second"/></div></td> 
                               <td class="tabheader" width="10%"><div align="center"><bean:write name="courseWt" property="first"/></div></td>                            
                               <td  colspan="3" class="tabheader" width="50%"><div align="center">الاوزان  </div></td>                           
                               </tr>
                                    </logic:iterate>
                                </logic:present>
                               <% int x=0;%>
                           <logic:iterate id="studentListForCourse" name="studentListForCourse" >
                                <%  if (x%2 == 0) { %>
                                <tr class="tableRowLightColor"  onMouseOver="this.className='highlight'" onMouseOut="this.className='tableRowLightColor'">
                                <%} else {   %>
                                <tr class="tableRowClearColor"  onMouseOver="this.className='highlight'" onMouseOut="this.className='tableRowClearColor'">
                                <%} x++;%>
                                <td ><div align="center">
                                <input type="hidden" name="studName<%=x%>" value='<bean:write name="studentListForCourse" property="studAName"/>'>
                                <input type="hidden" name="studId<%=x%>" value='<bean:write name="studentListForCourse" property="studId"/>'>
                                <logic:present    name="error.marksApproved"><input type="text"   readonly  class="readonlyInputFieldSmaller" tabindex="<%=x%>" value='<bean:write name="studentListForCourse" property="crsMark"/>'></logic:present>
                                <logic:present    name="calenderInfo"> <logic:notPresent name="error.marksApproved"><input type="text"   name="m<%=x%>" readonly  class="readonlyInputFieldSmaller" tabindex="<%=x%>" value='<bean:write name="studentListForCourse" property="crsMark"/>'></logic:notPresent> </logic:present>
                                <logic:notPresent name="calenderInfo"> <logic:notPresent name="error.marksApproved"><input type="text"   readonly  class="readonlyInputFieldSmaller" tabindex="<%=x%>" value='<bean:write name="studentListForCourse" property="crsMark"/>'></logic:notPresent> </logic:notPresent>
                                </div></td>
                                
                                 
                                 <td ><div align="center">                                
                                <logic:present    name="error.marksApproved"><input type="text"   readonly  class="readonlyInputFieldSmaller" tabindex="<%=x%>" value='<bean:write name="studentListForCourse" property="finMark"/>'></logic:present>
                                <logic:present    name="calenderInfoMFin"> <logic:notPresent name="error.marksApproved"><input type="text"   name="fn<%=x%>" class="inputFieldSmaller" tabindex="<%=x%>" value='<bean:write name="studentListForCourse" property="finMark"/>'></logic:notPresent> </logic:present>
                                <logic:notPresent name="calenderInfoMFin"> <logic:notPresent name="error.marksApproved"><input type="text"   readonly  class="readonlyInputFieldSmaller" tabindex="<%=x%>" value='<bean:write name="studentListForCourse" property="finMark"/>'></logic:notPresent> </logic:notPresent>
                                </div></td>
                                 <td ><div align="center">                                
                                <logic:present    name="error.marksApproved"><input type="text"   readonly  class="readonlyInputFieldSmaller" tabindex="<%=x%>" value='<bean:write name="studentListForCourse" property="midMark"/>'></logic:present>
                                <logic:present    name="calenderInfoMMid"> <logic:notPresent name="error.marksApproved"><input type="text"   name="md<%=x%>" class="inputFieldSmaller" tabindex="<%=x%>" value='<bean:write name="studentListForCourse" property="midMark"/>'></logic:notPresent> </logic:present>
                                <logic:notPresent name="calenderInfoMMid"> <logic:notPresent name="error.marksApproved"><input type="text"   readonly  class="readonlyInputFieldSmaller" tabindex="<%=x%>" value='<bean:write name="studentListForCourse" property="midMark"/>'></logic:notPresent> </logic:notPresent>
                                </div></td>
                                 <td ><div align="center">                                
                                <logic:present    name="error.marksApproved"><input type="text"   readonly  class="readonlyInputFieldSmaller" tabindex="<%=x%>" value='<bean:write name="studentListForCourse" property="secondMark"/>'></logic:present>
                                <logic:present    name="calenderInfoM2"> <logic:notPresent name="error.marksApproved"><input type="text"   name="s<%=x%>" class="inputFieldSmaller" tabindex="<%=x%>" value='<bean:write name="studentListForCourse" property="secondMark"/>'></logic:notPresent> </logic:present>
                                <logic:notPresent name="calenderInfoM2"> <logic:notPresent name="error.marksApproved"><input type="text"   readonly  class="readonlyInputFieldSmaller" tabindex="<%=x%>" value='<bean:write name="studentListForCourse" property="secondMark"/>'></logic:notPresent> </logic:notPresent>
                                </div></td>
                                 
                                <td ><div align="center">                                
                                <logic:present    name="error.marksApproved"><input type="text"   readonly  class="readonlyInputFieldSmaller" tabindex="<%=x%>" value='<bean:write name="studentListForCourse" property="firstMark"/>'></logic:present>
                                <logic:present    name="calenderInfoM1"> <logic:notPresent name="error.marksApproved"><input type="text"   name="f<%=x%>" class="inputFieldSmaller" tabindex="<%=x%>" value='<bean:write name="studentListForCourse" property="firstMark"/>'></logic:notPresent> </logic:present>
                                <logic:notPresent name="calenderInfoM1"> <logic:notPresent name="error.marksApproved"><input type="text"   readonly  class="readonlyInputFieldSmaller" tabindex="<%=x%>" value='<bean:write name="studentListForCourse" property="firstMark"/>'></logic:notPresent> </logic:notPresent>
                                </div></td>
                                
                                <td ><div align="right"><bean:write name="studentListForCourse" property="studAName"/></div></td>
                                <td ><div align="center"><bean:write name="studentListForCourse" property="studId"/></div></td>
                                <td ><div align="center"><%=x%></div></td>
                                </tr>
                           </logic:iterate>
                                <tr> <td  colspan="4">&nbsp;</td> </tr>
                           </table>
                           </div>
                      </logic:present>

                        </td>
				   </tr>
				    <tr>
                      <td>
                     <logic:present name="studentListForCourse">
                         <%--<qou:StudentMarks activeStyle=" smallerInputField " readOnlyStyle="readonlyInputFieldSmaller"/>--%>
				<div align="center">
                     <html:hidden  property="marksChecked" />
                     <logic:notPresent name="calenderInfoAny">
                     <br/>           
                     <%--<span class="centerpage"><a href="<%="../../tutor/viewStudentList.do?classNo="+request.getParameter("classNo")+"&crsNo="+request.getParameter("crsNo") +"&termNo="+request.getParameter("termNo")+  class="qou">رجـــــوع</a></span>--%>
                     </logic:notPresent>
                     <logic:present name="calenderInfoAny">
                         <logic:present name="courseWt">
                         <input type="hidden" name="submitValue" value="0" ><br>
                         <button class="enter" name="end" onclick="going('0')">حفظ وخروج</button> &nbsp;
                         <%--<button class="enter" name="commit" onclick="going('1')">تثبيت</button>&nbsp;--%>
                         <button class="enter" name="save" onclick="going('2')">حفظ</button>
                          </logic:present>
		     </logic:present>
                         
                           <logic:notPresent name="courseWt">
                         لا يوجد أوزان لهذا المقرر, لا يمكنك حفظ العلامات
                          </logic:notPresent>
                   </div>
                     </logic:present>
                      <logic:notPresent name="studentListForCourse">
                      <table width="100%" border="1" cellspacing="0" cellpadding="0" class="border" bordercolor="#4A6D8C">
                        <tr bgcolor="#EAF0F4" class="centerpage">
                          <td width="99%"><div align="center">نأسف، الشعبة المطلوبة غير موجودة</div></td>
                         </tr>
                      </table>
                     </logic:notPresent>
                     </td>
                    </tr>
                  </table>
                </td>
            </tr>
          </table>
         </div>
       </TD>
    </TR>
    
</TABLE>
<logic:notPresent name="error.marksApproved">
    <script>Start()</script>
</logic:notPresent>
</html:form>
