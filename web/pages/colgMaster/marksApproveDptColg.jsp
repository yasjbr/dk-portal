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
<html:form action="marksApproveDptColg.do" method="post" >


<table width="95%" border=0 align="center" cellPadding=0 cellSpacing=0 class="qou"  >
  <TBODY>
    <TR>
      <TD width="99%" >
        <div align="center">
          <table width="100%" border="0">
            <tr>
              <td width="100%" valign="top">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0" >
                     <%--<tr class="centerpage" >--%>
                          <%--<td width="99%" dir="rtl" align="right"><html:errors/>--%>
                           <%--<logic:present name="error.marksApproved">--%>
                            <%--<table width="81%" height="30" align="center" cellpadding="0" cellspacing="0" class="border">--%>
                             <%--<tr>--%>
                              <%--<td height="28" bgcolor="#E00000" ><div align="center" class="subtitle">--%>
                             <%--ناسف ,لايمكنك التعديل على البيانات المثبتة,الرجاء مراجعة التسجيل.--%>
                              <%--</div></td>--%>
                             <%--</tr>--%>
                            <%--</table><br>--%>
                           <%--</logic:present>--%>
                          <%--</td>--%>
                        <%--</tr>--%>
                    <tr>
				    <td>
                         <logic:present name="tutInfo">
                             <logic:iterate id="tutInfo" name="tutInfo" >
                                <br/>
                             <table width="100%" border="0" cellspacing="0" cellpadding="0" class="borderRoundedLightColor">
                               <tr  >
                                 <td width="10%" class="qou" ><div align="right"><bean:write name="tutInfo" property="empNo" />&nbsp;&nbsp;</div></td>
                                 <td width="20%" class="tabheader"><div align="center" class="centerpage">رقم عضو هيئة التدريس:</div></td>
                                 <td width="45%" class="qou"  ><div align="right"><bean:write name="tutInfo" property="tutorAName" />&nbsp;&nbsp;</div></td>
                                 <td width="25%" class="tabheader"><div align="center" class="centerpage">&nbsp;&nbsp;اسم عضو هيئة التدريس:</div></td>
                               </tr>
                             </table>
                              <br/>
                             </logic:iterate>
                            </logic:present>

				    <logic:present name="studentListForCourse">
                  <table width="100%" align="right" border="0" class="borderRoundedLightColor">

                    <tr>
                         <td   ><div align="right" class="qou"><%=request.getParameter("classNo")%></div></td>
                        <td class="tabheader" width="13%"><div align="center">:الشعبة</div>

				    <html:hidden property="classNo" value="<%=request.getParameter("classNo")%>"/>
                    <html:hidden property="termNo" value="<%=request.getParameter("termNo")%>"/>
                    <html:hidden property="crsNo" value="<%=request.getParameter("crsNo")%>"/>
                    <html:hidden property="empNo" value="<%=request.getParameter("empNo")%>"/>
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
                  </table>
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
                               <td class="tabheader" width="40%"><div align="center">العلامة</div></td>
                               <td class="tabheader" width="40%"><div align="center">اسم الطالب</div></td>
                               <td class="tabheader" width="25%"><div align="center">رقم الطالب</div></td>
                               <td class="tabheader" width="5%"><div align="center">م</div></td>
                               </tr>
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
                                <input type="text"   readonly  class="readonlyInputFieldSmaller" tabindex="<%=x%>" value='<bean:write name="studentListForCourse" property="crsMark"/>'>
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
                     <logic:notPresent name="calenderInfo">
                     <br/>
                     <%--<span class="centerpage"><a href="<%="../../tutor/viewStudentList.do?classNo="+request.getParameter("classNo")+"&crsNo="+request.getParameter("crsNo") +"&termNo="+request.getParameter("termNo")+  class="qou">رجـــــوع</a></span>--%>
                     </logic:notPresent>

                     <input type="button" value="  عودة  " class="enter" onclick="javaScript:parent.location = '/colgMstr/tutorsColgCrsList.do?tutNo=<%=request.getParameter("empNo")%>&.rv=<%= Randomizer.shortRandom()%>'">&nbsp;
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
