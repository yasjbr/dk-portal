<%@ page import="ps.edu.diyar.common.tools.Randomizer" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/lib/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/lib/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/lib/qou-Taglib.tld" prefix="qou" %>
<%@ taglib uri="/WEB-INF/lib/struts-logic.tld" prefix="logic" %>
<%
    response.setHeader("pragma", "no-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Expires", "0");
%>
<script language="javascript">

    function openDetailsWindow(serNo)
    {
        var broswerName = new String(navigator.appName);

        if (broswerName.indexOf("Microsoft") >= 0)
        {
            var win = window.open('../../student/showSelectedTermSummary.do?.rv=<%=ps.edu.diyar.common.tools.Randomizer.shortRandom()%>&serNo=' + serNo, '', 'toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=no,width=600,height=520');
        } else if (broswerName.indexOf("Netscape") >= 0)
        {
            var win = window.open('../../student/showSelectedTermSummary.do?.rv=<%=ps.edu.diyar.common.tools.Randomizer.shortRandom()%>&serNo=' + serNo, '', 'toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=no,width=600,height=520');
        }

    }

    function setListSelection(selection, list)
    {
        for (var i = 0; i < list.options.length; i++)
        {
            if (list.options[i].value == selection)
            {
                list.selectedIndex = i;
                break;
            }
        }
    }



</script>


<html>
    <HEAD><TITLE><tiles:getAsString name="title"/></TITLE>
        <META http-equiv=Content-Type content="text/html; charset=UTF-8">
        <META content="MSHTML 6.00.2600.0" name=GENERATOR>
        <link href="/pages/resources/css/dr_portal_style.css" rel="stylesheet" type="text/css">
    </HEAD>


    <logic:present name="selectedCourseSummary">
         
        <logic:iterate  id="courseWt" name="selectedCourseSummary" >

            <table width="99%" cellspacing="0" cellpadding="0" class="borderRoundedClearColor" >


                <tr>

                    <TD class="borderTopLeftBigColor"  width="15%"> <DIV align=center>النهائي</DIV></TD>
                    <TD class="borderTopLeftBigColor"  width="15%"> <DIV align=center>عملي</DIV></TD>
                    <TD class="borderTopLeftBigColor"  width="15%"> <DIV align=center>نصفي</DIV></TD>
                    <TD class="borderTopLeftBigColor"  width="15%"> <DIV align=center>الثاني</DIV></TD>
                    <TD class="borderTopLeftBigColor"  width="15%"> <DIV align=center>الاول</DIV></TD>
                    <TD class="borderTopRightBigColor"  width="25%"> <P align=center class=subtitle> 
                          <%=request.getParameter("course")%>   المقرر            </P></TD>


                </tr>




                <tr>
                    
                    <td>
                        <div align="center" class="qou">
                            <bean:write name="courseWt" property="finalm" />
                        </div>
                    </td>
                    
                    <td>
                        <div align="center" class="qou">
                            <bean:write name="courseWt" property="practical" />
                        </div>
                    </td>

                    <td>
                        <div align="center" class="qou">
                            <bean:write name="courseWt" property="mid" />
                        </div>
                    </td>

                    <td>
                        <div align="center" class="qou">
                            <bean:write name="courseWt" property="second" />
                        </div>
                    </td>

                    <td>
                        <div align="center" class="qou">
                            <bean:write name="courseWt" property="first" />
                        </div>
                    </td>
                    <td>
                        <div align="center" class="qou">
                             الاوزان
                        </div>
                    </td>
                </tr>

            </table>
        </logic:iterate>
    </logic:present>

    
     <table width="99%" cellspacing="0" cellpadding="0" class="borderRoundedClearColor" >
          <tr>

                    <TD class="borderTopLeftBigColor"  width="15%"> <DIV align=center>النهائي</DIV></TD>
                    <TD class="borderTopLeftBigColor"  width="15%"> <DIV align=center>عملي</DIV></TD>
                    <TD class="borderTopLeftBigColor"  width="15%"> <DIV align=center>نصفي</DIV></TD>
                    <TD class="borderTopLeftBigColor"  width="15%"> <DIV align=center>الثاني</DIV></TD>
                    <TD class="borderTopLeftBigColor"  width="15%"> <DIV align=center>الاول</DIV></TD>
                    <TD class="borderTopRightBigColor"  width="25%"> <P align=center class=subtitle> 
                             </P></TD>


                </tr>
    <tr>
                    
                    <td>
                        <div align="center" class="qou">
                          <%=request.getParameter("final")%>   
                        </div>
                    </td>
                    
                    <td>
                        <div align="center" class="qou">
                          <%=request.getParameter("practical")%>   
                        </div>
                    </td>

                    <td>
                        <div align="center" class="qou">
                        <%=request.getParameter("mid")%>   
                        </div>
                    </td>

                    <td>
                        <div align="center" class="qou">
                           <%=request.getParameter("second")%>   
                        </div>
                    </td>

                    <td>
                        <div align="center" class="qou">
                           <%=request.getParameter("first")%>   
                        </div>
                    </td>
                    <td>
                        <div align="center" class="qou">
                             العلامات
                        </div>
                    </td>
                </tr>
                </table     
    
    <logic:notPresent name="selectedCourseSummary">
        <div align="right">
            <span class="centerpage"> لا يوجد أوزان لهذا المقرر   </span><Br>
        </div>  
        
        </logic:notPresent>
    
    
</html>