<%@ page import="ps.edu.diyar.common.tools.Randomizer" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
 
<link href="/pages/resources/css/portalStyleMenus.css" rel="stylesheet" type="text/css">
<br />
<table cellspacing="0" width="160"   cellpadding="0">

          <tr>
          <td valign="top">
              <table cellspacing="0" width="160"  cellpadding="0">

                    <tr> <td width="160" height="16"  class="menuLinkHeader"  valign="top"  >عضو هيئة التدريس</td> </tr>

                  <tr class="menuLink"> <td align="right"><a href="/tutor/showTutorTermSchedule.do?.rv=<%= Randomizer.shortRandom()%>"  ><bean:message key="tutorInfo.Menu.schedule"/></a></td></tr>
                  <tr class="menuLink"> <td align="right"><a href="/tutor/showAttendTbl.do?.rv=<%= Randomizer.shortRandom()%>"  >جدول حضور الطلبة</a></td></tr>
                  <tr class="menuLink"> <td align="right"><a href="/tutor/showMarkInsertion.do?.rv=<%= Randomizer.shortRandom()%>"  >ادخال العلامات</a></td></tr>
                  <tr class="menuLink"> <td align="right"><a href="/tutor/showMessages.do?.rv=<%= Randomizer.shortRandom()%>"  >المراسلات</a></td></tr>

                    <tr> <td align="right" valign="top"   class="menuLinkFooter">&nbsp;  </td>  </tr>

              </table>

          </td>
          </tr>
</table>
