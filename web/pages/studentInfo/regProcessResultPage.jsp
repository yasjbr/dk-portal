<%@ page import="ps.edu.diyar.common.tools.Randomizer" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/lib/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/lib/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/lib/qou-Taglib.tld" prefix="qou" %>
<%@ taglib uri="/WEB-INF/lib/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/lib/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/lib/qou-Taglib.tld" prefix="qou" %>

 
 
<%@ taglib uri="/WEB-INF/lib/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://psgateway.org" prefix="pagination" %>
<%@ taglib uri="/WEB-INF/lib/struts-tiles.tld" prefix="tiles" %>
<script>
function openRegReportPage()
{
  var broswerName = new String(navigator.appName);
  var studId = '<%=request.getAttribute("studId")%>';
  var processId = '<%=request.getAttribute("processId")%>';

  if(broswerName.indexOf("Microsoft") >= 0)
  {
	var win = window.open('regProcessReport.do?s='+studId+'&p='+processId+'&.rv=<%=Randomizer.shortRandom()%>','OldLoad','toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=no,width=1000,height=400');
  }
  else if(broswerName.indexOf("Netscape") >= 0)
  {
	var win = window.open('../../student/regProcessReport.do?s='+studId+'&p='+processId+'&.rv=<%=Randomizer.shortRandom()%>','OldLoad','toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=no,width=1000,height=400');
  }
}

function openPayReportPage()
{
  var broswerName = new String(navigator.appName);

  if(broswerName.indexOf("Microsoft") >= 0)
  {
	var win = window.open('viewStudRegCrsReport?.rv=<%=Randomizer.shortRandom()%>','OldLoad','toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=no,width=1000,height=400');
  }
  else if(broswerName.indexOf("Netscape") >= 0)
  {
	var win = window.open('../../student/viewStudRegCrsReport?.rv=<%=Randomizer.shortRandom()%>','OldLoad','toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=no,width=1000,height=400');
  }
}
</script>
<table width="480"  border="0">
    <tr>
      <td width="98%"  valign="top">
        <div align="center"><br>
        <table width="81%" height="30" align="center" cellpadding="0" cellspacing="0" class="border">
            <tr>
              <td height="28" bgcolor="#E00000" ><div align="center" class="subtitle"><html:errors/></div></td>
            </tr>
          </table>
          <table width="81%" height="30" align="center" cellpadding="0" cellspacing="0" >
            <tr>
             <td height="28" align="center"  >
              <%--<logic:notPresent name="noRegRep">--%>
               <%--<div align="right">--%>
                 <%--<input type="button" value="تقرير عملية التسجيل" onclick="openRegReportPage()">--%>
               <%--</div>--%>
               <%--</logic:notPresent>--%>
                 &nbsp;
              </td>
              <logic:present name="regApp">
               <logic:present name="isOldStudent">
                 <logic:present name="regP1App">
                   <td height="28"  >
                     <div align="center">
                      <br/>
                      <input type="button" value="طباعة اشعار الدفع" onclick="openPayReportPage()">
                     </div>
                   </td>
                 </logic:present>
               </logic:present>
             </logic:present>
            </tr>
          </table>
        </div>
      </td>
    </tr>
</table>