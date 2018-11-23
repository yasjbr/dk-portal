<%@ page import="ps.edu.diyar.studentInfo.database.struct.StudentInfoHolder" %>
<%@ page import="ps.edu.diyar.common.tools.Randomizer" %>
<%@ page import="ps.edu.diyar.common.constant.UserInfoHolder" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collection" %>
<%@ page import="ps.edu.diyar.studentInfo.database.struct.MsCoursesList" %>
<%@ page import="ps.edu.diyar.common.tools.AppTxt" %>
<%@ page import="ps.edu.diyar.common.component.ServletContextAttribute" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/lib/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/lib/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/lib/qou-Taglib.tld" prefix="qou" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<NOSCRIPT>
    <meta http-equiv="refresh" content="0;url=/student/noJScript.do" />
</NOSCRIPT>

<%--<%--%>
  <%--response.setHeader("pragma", "no-cache");--%>
  <%--response.setHeader("Cache-Control", "no-cache");--%>
  <%--response.setHeader("Expires", "0");--%>
<%--%>--%>


<script language="JavaScript" type="text/javascript" >

  <%--<%  StudentInfoHolder studInfo = (StudentInfoHolder) ((List) request.getSession().getAttribute(UserInfoHolder.STUDENT_INFO_HOLDER)).get(0); %>--%>


<%--var countCrsReg = 0;--%>
 <%--var minH = 9;--%>
<%--var maxh = 10;//--%>
  <%--&lt;%&ndash;//  <%= (String)request.getAttribute("maxLoad")%>;&ndash;%&gt;--%>
<%--var regedHours = <%=(String)request.getAttribute("hoursSum")%>;--%>
<%--var basicNewLoad = <%=(String)request.getAttribute("newLoad")%>;--%>
<%--var basicOldLoad = <%=(String)request.getAttribute("oldLoad")%>;--%>
<%--var minHours = <%=(String)request.getSession().getAttribute("minLoad")%>;--%>
<%--var regPeriod = "<%=request.getAttribute("regCalItem")+""%>";--%>

</script>

<script src = "/pages/resources/js/stud_reg.js" type = "text/javascript"></script>
<script type="text/javascript">
    var temp="";
    constructorValue( '9','<%= (String)request.getAttribute("maxLoad")%>','<%=(String)request.getAttribute("hoursSum")%>','<%=(String)request.getAttribute("newLoad")%>','<%=(String)request.getSession().getAttribute("minLoad")%>','<%=request.getAttribute("regCalItem")+""%>');
</script>

 
  
<table width="98%"  border="0">
     <tr><td align="center">
    <logic:present name="studViwedInfo">
     <logic:iterate id="studViwedInfo" name="studViwedInfo" >
         	<div align="right">
                 <br/>
                  <span class="centerpage">:معلومات الطالب </span><Br>
                </div>
     <table width="100%" border="0" cellspacing="0" cellpadding="0" class="borderRoundedClearColor">
       <tr height="30">
         <td class="borderTopLeftLightColor" width="32%" ><div align="right">&nbsp;<bean:write name="studViwedInfo" property="studentId" /></div></td>
         <td class="tableRowLightColor" width="17%"><div align="right" class="centerpage"><bean:message key="studentHeader.id"/>:</div></td>
         <td class="tableRowLightColor" width="32%"  ><div align="right">&nbsp;<bean:write name="studViwedInfo" property="studentName" /></div></td>
         <td class="borderTopRightLightColor" width="19%"><div align="right" class="centerpage">&nbsp;&nbsp;<bean:message key="studentHeader.name"/>:</div></td>
       </tr>
       <tr height="30">
         <td class="qou"><div align="right"><%--a href="#" class="qou"--%>&nbsp;<bean:write name="studViwedInfo" property="specialization" /><%--/a--%></div></td>
         <td class="centerpage"><div align="right"><bean:message key="studentHeader.specialization"/>:</div></td>
         <td class="qou"><div align="right"><%--a href="#" class="qou"--%>&nbsp;<bean:write name="studViwedInfo" property="programName" /><%--/a--%></div></td>
         <td class="centerpage"><div align="right">&nbsp;&nbsp;<bean:message key="studentHeader.program"/>:</div></td>
       </tr>
       <tr height="30" class="tableRowLightColor">
         <td colspan="2" class="borderBottomLeftLightColor">&nbsp;</td>
         <td class="qou" ><div align="right">&nbsp;<bean:write name="studViwedInfo" property="majorSheet" /></div></td>
         <td class="borderBottomRightLightColor"><div align="right" class="centerpage">&nbsp;&nbsp;<bean:message key="studentHeader.majorSheet"/>:</div></td>
       </tr>
     </table>
     </logic:iterate>
    </logic:present>

     </td></tr>
     <tr>
      <td width="99%" valign="top">
        <div align="center">
           <span class="qou"><font color="red"><html:errors/></font></span>
        </div>
        <div align="right">
           <br><span class="qou">عزيزي الطالب، من خلال هذه الصفحة يمكنك تسجيل المقررات الدراسية و ذلك بالضغط على فئة المقررات من القائمة التالية و من ثم اختار المقرر الذي ترغب التسجيل له</span><Br><br>
        </div>
        <logic:messagesPresent message="true">
          <html:messages id="message" message="true">
            <div align="center" class="centerpage"><font color="red"><bean:write name="message"/></font></div>
            <br>
          </html:messages>
        </logic:messagesPresent>

     <logic:present name="calItemInfo" >
      <logic:iterate id="calItemInfo" name="calItemInfo" >

        <table width="100%" align="center" class="borderRoundedLightColor">
        <tr>
            <td   width="35%"><div align="right" class="qou"><bean:write name="calItemInfo" property="termAName"/></div></td>
            <td class="borderRoundedBigColor" width="15%"><div align="center">الفصل الدراسي</div></td>
            <td  width="35%"><div align="right" class="qou"><bean:write name="calItemInfo" property="itemAName"/></div></td>
            <td class="borderTopRightBigColor" width="15%"><div align="center">التقويم</div></td>
        </tr>
         <tr><td colspan="4"  height="1"  background="/pages/resources/images/menuBg.gif"></td></tr>
         <tr>
            <td  ><div align="right" class="qou"><bean:write name="calItemInfo" property="endDate"/></div></td>
            <td class="borderRoundedBigColor"><div align="center">نهاية فترة التسجيل</div></td>
            <td ><div align="right" class="qou"><bean:write name="calItemInfo" property="begDate"/></div></td>
            <td class="borderBottomRightBigColor"><div align="center">بداية فترة التسجيل</div></td>
        </tr>
        </table><BR>
        </logic:iterate>
       </logic:present>

        <table width="100%" align="center" class="borderRoundedLightColor">
        <tr>
            <td  width="10%"><div align="center" id="hoursSumDiv" class="qou"><%=(String)request.getAttribute("newLoad")%></div></td>
            <td  width="23%"  class="borderRoundedBigColor"><div align="center">عدد الساعات المسجلة</div></td>
            <td  width="10%"><div align="center" class="qou"><%=(String)request.getAttribute("maxLoad")%></div></td>
            <td class="borderRoundedBigColor" width="23%"><div align="center">عدد الساعات المسموح به</div></td>
        </tr>
        </table>
        
        <table width="100%" cellpadding="0" cellspacing="0">
          <tr>
            <td>
                <br/><br/>
               <div class="centerpage" align="right">المقررات التي تم تسجيلها<font color="red"><b>*</b></font></div>
                <hr align="center" color="#f38e00" size="1"/>
            <logic:present name="registeredCourses">
             <table width="100%" height="37" border="0" cellpadding="0" cellspacing="0" class="borderRoundedClearColor">
                <tr>
                  <td class="borderTopLeftBigColor" width="7%"><div align="center" class="subtitle">حذف</div></td>
                  <td class="tabheader" width="20%"><div align="center" class="subtitle">عضو هيئة التدريس</div></td>
                  <td class="tabheader" width="12%"><div align="center" class="subtitle">الموعد</div></td>
                  <td class="tabheader" width="10%"><div align="center" class="subtitle">اليوم</div></td>
                  <td class="tabheader" width="6%"><div align="center" class="subtitle">الشعبة</div></td>
                  <td class="tabheader" width="6%"><div align="center" class="subtitle">س.م.</div></td>
                  <td class="tabheader" width="22%"><div align="center" class="subtitle">اسم المقرر</div></td>
                  <td class="borderTopRightBigColor" width="7%"><div align="center" class="subtitle">ر. م.</div></td>
                </tr>
               <% int i = 0; %>
            <logic:iterate id="registeredCourses" name="registeredCourses" >
                <logic:present name="deptMaster">
                <form name="delForm<%=i%>" id="delForm<%=i%>" action="/deptMstr/delCrs.do" method="POST">
                </logic:present>
                <logic:notPresent name="deptMaster">
                <form name="delForm<%=i%>" id="delForm<%=i%>" action="/student/delCrs.do" method="POST">
                </logic:notPresent>
            
                  <script >countCrsReg=<%=(i+1)%>;</script>
                  <%   if (i%2 == 0) { %> 
                   <tr class="tableRowClearColor" onMouseOver="this.className='highlight'" onMouseOut="this.className='tableRowClearColor'">

                  <%}else {%>
                   <tr class="tableRowLightColor"  onMouseOver="this.className='highlight'" onMouseOut="this.className='tableRowLightColor'">
                  <%}%>
                  <td><div align="center" class="qou">
                  <logic:notPresent name="regApp">
                          <a href="javascript:delConf('<%=i%>')" class="qou">حذف</a>
                          <input type="hidden" name="no"      value="<bean:write name="registeredCourses" property="crsNo"/>">
                          <input type="hidden" name="hrs"     value="<bean:write name="registeredCourses" property="crsHrs"/>">
                          <input type="hidden" name="stud_id" value="<bean:write name="registeredCourses" property="studId"/>">
                          <input type="hidden" name=".rv"     value="<%=Randomizer.shortRandom()%>">
                  </logic:notPresent>
                  </div></td>
                  <td><div align="right" class="qou"><input type="text" class="smallerInputField_110" disabled value="<bean:write name="registeredCourses" property="tutorAName"/>" dir="rtl"  > </div></td>
                  <td><div align="center" class="qou"><input type="text" class="smallInputField_175" disabled value="<bean:write name="registeredCourses" property="begEndTime"/>" dir="rtl"  ></div></td>
                  <td><div align="center" class="qou"><input type="text" class="smallerInputField_110" disabled value="<bean:write name="registeredCourses" property="dayAName"/>" dir="rtl"  ></div></td>
                  <td><div align="center" class="qou"><bean:write name="registeredCourses" property="classNo"/></div></td>
                  <td><div align="center" class="qou"><bean:write name="registeredCourses" property="crsHrs"/></div></td>
                  <td><div align="right" class="qou"><bean:write name="registeredCourses" property="crsName"/></div></td>
                  <td>
                     <div align="center" class="qou"><bean:write name="registeredCourses" property="crsNo"/></div>
                     <input type="hidden" name="regedCrs" id="reged_crs_<bean:write name="registeredCourses" property="crsNo"/>" value="<bean:write name="registeredCourses" property="crsNo"/>">
                  </td>
                </tr>
                <% i++; %>
                </form>
             </logic:iterate>
             <tr><td colspan="8">&nbsp;</td> </tr>
               </table>
            </logic:present>
               <logic:present name="regApp">
                  <div align="center">
                  <input type="button" value="طباعة اشعار الدفع" onclick="openPayReportPage('<%=(String)(request.getAttribute("stud_id") !=null ?request.getAttribute("stud_id") :"")%>')">
<%--                      <a href="/student/viewStudRegCrsReport?.rv=<%=Randomizer.shortRandom()%>" class="qou" target="_blank">طباعة اشعار الدفع</a>--%>
                  </div>
                </logic:present>
            <logic:notPresent name="registeredCourses">
             <table width="100%" cellspacing="0" cellpadding="0" class="border">
              <tr class="tableRowLightColor">
                  <td width="99%"><div align="center" class="centerpage">&nbsp;لا يوجد مقررات مسجلة</div></td>
                 </tr>
              </table>
           </logic:notPresent>
             </td>
            </tr>
          </table>

         <logic:present name="avlbCrsList">
<logic:present name="deptMaster">
<form name="form1" action = "/deptMstr/saveReg.do" method="post">
</logic:present>
<logic:notPresent name="deptMaster">
<form name="form1" action = "/student/saveReg.do" method="post">
</logic:notPresent>
<input type="hidden" name="stud_id" id="stud_id" value="<%=(String)(request.getAttribute("stud_id") !=null ?request.getAttribute("stud_id") :"")%>" >
<input type="hidden" name="p" value="1" id="p">
<input type="hidden" name="visited" id="visited" value="1">
<input type="hidden" name="prevNewHsum" id="prevNewHsum">
<input type="hidden" name="newLoadHours"  value="<%=(String)request.getAttribute("newLoad")%>" id="newLoadHours"/>
<input type="hidden" name="oldLoadHours"  value="<%=(String)request.getAttribute("oldLoad")%>" id="oldLoadHours"/>



<%
    if(request.getAttribute("avlbCrsList") != null)
    {
        int crsMsType = -1;
        String crsPrvInOtherTime="";
        String crsPrvSuccessed="";
        boolean skip=false;
        boolean firstRowPrint=false;
         // this is just for demo purpose, to be replaced by
        // course actual status value from db and update javascript
        String status = "";
        ServletContextAttribute servletContAtt=new ServletContextAttribute(request);
        String crsRegTerm=servletContAtt.getCrsRegTerm();

        Collection crsList = (Collection) request.getAttribute("avlbCrsList");
        Iterator iter = crsList.iterator();
        int i = 0;
        while(iter.hasNext())
        {
            skip=false ;
            firstRowPrint=true;
            MsCoursesList crs = (MsCoursesList) iter.next();
            status = crs.getCrsStatus();

            if(crsPrvSuccessed.equals(crs.getCrsNo()))
            firstRowPrint=false;

            if(crsMsType != Integer.parseInt(crs.getMsCrsType()) && crsMsType != -1)
            {
%>
       </table>
<%
            }
            if(crsMsType != Integer.parseInt(crs.getMsCrsType()))
            {

                crsMsType = Integer.parseInt(crs.getMsCrsType());

                firstRowPrint=true;
%>
       <br>
       <input type="hidden" name="p" value="1" id="p">
       <div class="centerpage" align="right">مقررات  <%=AppTxt.textManipulation(crs.getMscrsTypeName()) +" "+(crs.getMsCrsType()!=null &&crs.getMsCrsType().equals("6")?"مطروحة":"المطروحة")%>  <font color="red"><b>*</b></font></div>
        <hr align="center" color="#f38e00" size="1"/>

     <table width="100%" height="37" border="0" cellpadding="0" cellspacing="0"  class="borderRoundedClearColor">
        <tr>
          <%--<td class="borderTopLeftBigColor" width="7%" ><div align="center" class="subtitle">الشعب</div></td>--%>
          <td class="borderTopLeftBigColor" width="5%" ><div align="center" class="subtitle">الشعبة</div></td>
          <td class="tabheader" width="5%" ><div align="center" class="subtitle">العلامة</div></td>
          <td class="tabheader" width="5%" ><div align="center" class="subtitle">الحالة</div></td>
          <td class="tabheader" width="14%" ><div align="center" class="subtitle">عضو هيئة التدريس</div></td>
          <td class="tabheader" width="15%" ><div align="center" class="subtitle">الموعد</div></td>
          <td class="tabheader" width="10%"><div align="center" class="subtitle">اليوم</div></td>
          <td class="tabheader" width="2%"><div align="center" class="subtitle">س.م</div></td>
          <td class="tabheader" width="20%"><div align="center" class="subtitle">اسم المقرر</div></td>
          <td class="borderTopRightBigColor" colspan="2"  width="12%"><div align="center" class="subtitle">ر. م.</div></td>
   
        </tr>
      <% }
            else if(crsPrvInOtherTime.equals(crs.getCrsNo()+"*"+crs.getClassNo()))
            {
                skip=true;


  
      %>
         <script type="text/javascript">

          

             temp="";
             temp=document.getElementById("ct_<%=crs.getCrsNo()+crs.getClassNo()%>").value;
           
             
             if (document.form1.visited.value == "1" )
             {
                
                 console.log("1"+"<%=crsPrvInOtherTime%>")
           console.log("<%=crs.getCrsNo()+"*"+crs.getClassNo()%>")
           console.log(temp)
                document.getElementById("ct_<%=crs.getCrsNo()+crs.getClassNo()%>").value=temp+"|  "+"<%=crs.getBegTime()+" - "+crs.getEndTime()%>";
                
             }
                    
             
             temp="";
             temp=document.getElementById("cd_<%=crs.getCrsNo()+crs.getClassNo()%>").value;
             if (document.form1.visited.value == "1")
             document.getElementById("cd_<%=crs.getCrsNo()+crs.getClassNo()%>").value=temp+" | "+"<%=crs.getDayAName()%>";

         </script>

           <% }
//           if(crs.getTermNo() !=null && crsRegTerm.equals(crs.getTermNo()))
//           {
//              skip=true;
//           }
//           if(!firstRowPrint && crsPrvSuccessed.equals(crs.getCrsNo())&& crs.getCrsStatus().equals("S"))
//           {
//              skip=true;
//           }
                

       if(!skip)
       {

              crsPrvInOtherTime=crs.getCrsNo()+"*"+crs.getClassNo();
              boolean noClassesAvaliable = crs.getClass().equals("-1")?true:false;

         if((status!=null && status.equalsIgnoreCase("R") ) || (status!=null &&status.equalsIgnoreCase("I")) )
         {
        %>
        <tr class="tableRowRegisteredCourse">
        <%
         }
         else if(status!=null &&status.equals("S"))
        {
        %>
        <tr class="tableRowLightColor">
        <%
        }
         else if(status!=null &&status.equalsIgnoreCase("T"))
        {
        %>
        <tr class="tableRowTransferedCourse">
        <%
        }
        else if(status!=null &&status.equalsIgnoreCase("F"))
        {
        %>
        <tr class="tableRowFailedCourse">
        <%
        }
        else
        {
        %>
        <tr>
        <%}i++;%>

          <%--<td>--%>
          <%--<%if(status==null ||(!status.equalsIgnoreCase("R") && !status.equalsIgnoreCase("I")&& !status.equalsIgnoreCase("S") && !noClassesAvaliable)){ %>--%>
            <%--<div align="center" class="qou"><a href="javascript:openClasses('<%=crs.getCrsNo()%>' )" class="qou">الشعب</a></div>--%>
          <%--<%}%>--%>
          <%--</td>--%>

          <%if(noClassesAvaliable){ %>
          <td><div align="center" class="qou">مغلقة</div></td>
          <%}else{%>
          <td><div align="center" class="qou"><input type="text" class="smallerInputField" disabled value="<%=crs.getClassNo()%>" dir="rtl" id="cn_<%=crs.getCrsNo()%>" name="cn_<%=crs.getCrsNo()%>">
          <input type="hidden" value="<%=crs.getClassNo()%>" id="cnh_<%=crs.getCrsNo()%>" name="cnh_<%=crs.getCrsNo()%>">
          </div></td>
          <%}%>

          <td><div align="center" class="qou"><%=AppTxt.textManipulation(crs.getCrsMark())%></div></td>
          <td><div align="center" class="qou"><%=AppTxt.textManipulation(crs.getCrsStatusAName())%></div></td>
          <td><div align="right" class="qou"><input type="text" class="midInputField_110" disabled  value="<%=AppTxt.textManipulation(crs.getTutorAName())%>" dir="rtl" id="ctu_<%=crs.getCrsNo()%>"></div></td>
          <td><div align="right" class="qou"><input type="text" class="smallInputField_175" disabled value="<%=crs.getBegTime()+" - "+crs.getEndTime()%>" dir="rtl"       id="ct_<%=crs.getCrsNo()+crs.getClassNo()%>"></div></td>
          <td><div align="center" class="qou"><input type="text" class="smallerInputField_110" disabled value="<%=AppTxt.textManipulation(crs.getDayAName())%>" dir="rtl" id="cd_<%=crs.getCrsNo()+crs.getClassNo()%>"></div></td>
          <td><div align="center" class="qou"><%=AppTxt.textManipulation(crs.getCrsHrs())%></div></td>
          <td><div align="right" class="qou"><%=AppTxt.textManipulation(crs.getCrsName())%></div></td>
          <td><div align="right" class="qou"><%=AppTxt.textManipulation(crs.getCrsNo())%></div></td>
          <td>
          <%if(status==null ||(!status.equalsIgnoreCase("R") && !status.equalsIgnoreCase("I") && !noClassesAvaliable)){ %>
            <div align="center" class="qou">
                <input type="checkbox" id="cbx_<%=crs.getCrsNo()+"_c"+crs.getClassNo()%>" name="cbx_<%=crs.getCrsNo()+"_c"+crs.getClassNo()%>" onClick="javascript:cbxClicked('<%=crs.getCrsNo()+"_c"+crs.getClassNo()%>')">
            </div>
            <input type="hidden" id="cri_<%=crs.getCrsNo()+"_c"+crs.getClassNo()%>" name="cri_<%=crs.getCrsNo()+"_c"+crs.getClassNo()%>" value="<%=crs.getCrsNo()%>_h<%=crs.getCrsHrs()%>_s<%=status%>">
          <%}%>
          </td>

        </tr>
<%        }// end if !skip
   //    crsPrvInOtherTime=crs.getCrsNo()+"*"+crs.getClassNo();
       crsPrvSuccessed=crs.getCrsNo();
            }//end loop %>
            <tr><td colspan="11">&nbsp;</td> </tr>
        <%
        }
%>

        </table>

<br>

        <div align="center" id="btnsDiv" class="centerpage">
          <logic:present name="studentInfo">
              
           <%--<input name="Sub" type="button" value="<%=((String)request.getAttribute("regCalItem")).equalsIgnoreCase("IP")?"تثبيت التسجيل":"تثبيت السحب والاضافة - نهائي"%>"  class="enter" onClick="submitProcess('2')">&nbsp;&nbsp;--%>
           <input name="Sub" type="button" value="<%=((String)request.getAttribute("regCalItem")).equalsIgnoreCase("IP")?"حفظ التسجيل":"حفظ السحب والاضافة"%>"  class="enter" onClick="submitProcess('1')">&nbsp;&nbsp;
           </logic:present>
           <logic:present name="deptMaster">
           <input name="Sub" type="button" value="<%=((String)request.getAttribute("regCalItem")).equalsIgnoreCase("IP")?"حفظ التسجيل":"حفظ السحب والاضافة"%>"  class="enter" onClick="submitProcess('1')">&nbsp;&nbsp;               
           <input name="Sub" type="button" value="<%=((String)request.getAttribute("regCalItem")).equalsIgnoreCase("IP")?"تثبيت التسجيل":"تثبيت السحب والاضافة - نهائي"%>"  class="enter" onClick="submitProcess('2')">&nbsp;&nbsp;
           </logic:present>
        </div>
             <script type="text/javascript">document.form1.visited.value = "2"; updateHoursSum();</script>
       </form>
     </logic:present>
     <logic:notPresent name="regApp">
     <logic:notPresent name="avlbCrsList">
      <table width="100%" cellspacing="0" cellpadding="0" class="border">
        <tr class="tableRowLightColor">
            <td width="99%"><div align="center" class="centerpage">&nbsp;جميع الشعب مغلقة حالياً</div></td>
        </tr>
      </table>
     </logic:notPresent>
     </logic:notPresent>     
      </td>
    </tr>
</table>
 