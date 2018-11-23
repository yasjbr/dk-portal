<%@ page contentType="text/html; charset=UTF-8" %>
<SCRIPT language=JavaScript>
function makeArray() {
     for (i = 0; i<makeArray.arguments.length; i++)
         this[i] = makeArray.arguments[i];
 }

function getFullYear(d) {
    var y = d.getYear();
    if (y < 1000) {y += 1900};
    return y;
}

//var zone = "EDT";
var days = new makeArray("&#1575;&#1604;&#1575;&#1581;&#1583;","&#1575;&#1604;&#1575;&#1579;&#1606;&#1610;&#1606;","&#1575;&#1604;&#1579;&#1604;&#1575;&#1579;&#1575;&#1569;","&#1575;&#1604;&#1575;&#1585;&#1576;&#1593;&#1575;&#1569;","&#1575;&#1604;&#1582;&#1605;&#1610;&#1587;","&#1575;&#1604;&#1580;&#1605;&#1593;&#1577;","&#1575;&#1604;&#1587;&#1576;&#1578;");
var months = new makeArray("&#1603;&#1575;&#1606;&#1608;&#1606; &#1579;&#1575;&#1606;&#1610;","&#1588;&#1576;&#1575;&#1591;","&#1570;&#1584;&#1575;&#1585;","&#1606;&#1610;&#1587;&#1575;&#1606;","&#1571;&#1610;&#1575;&#1585;","&#1581;&#1586;&#1610;&#1585;&#1575;&#1606;","&#1578;&#1605;&#1608;&#1586;","&#1570;&#1576;","&#1571;&#1610;&#1604;&#1608;&#1604;","&#1578;&#1588;&#1585;&#1610;&#1606; &#1571;&#1608;&#1604;","&#1578;&#1588;&#1585;&#1610;&#1606; &#1579;&#1575;&#1606;&#1610;","&#1603;&#1575;&#1606;&#1608;&#1606; &#1571;&#1608;&#1604;");

function format_time(t) {

    var Day = t.getDay();
    var Date = t.getDate();
    var Month = t.getMonth();
    var Year = t.getFullYear();

    timeString = "";
    timeString += days[Day];
    timeString += "/ ";
    timeString += " ";
    timeString += Date;
    timeString += " ";
    timeString += months[Month];
    timeString += "/ ";
    timeString += " ";
    timeString += Year;

   return timeString;
 }
function openWindow(url,h,w)
{
  var broswerName = new String(navigator.appName);
  if(broswerName.indexOf("Microsoft") >= 0)
  var win = window.open(url,'',"toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=no,height="+h+",width="+w+"'");
  else if(broswerName.indexOf("Netscape") >= 0)
  var win = window.open(url,'',"toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=no,height="+h+",width="+w+"'");
}
</SCRIPT>

<table align="center" width="966" dir="rtl" height="250" border="0" cellspacing="0" cellpadding="0">
  <tr>
   <td align="right" width="966" height="104" valign="middle" bgcolor="#f38e00">
     
     <table align="center" width="966" dir="rtl" height="104" border="0" cellspacing="0" cellpadding="0">
       <tr>
         <td align="center" width="139" height="104" valign="middle"><img src="/pages/resources/images/diyar_Logo.png" width="97" height="100" /></td>
         <td align="center" width="827" height="104" valign="middle"><img src="/pages/resources/images/title.png" width="713" height="77" /></td>
       </tr> 
     </table>
      
   </td>
  </tr>
   
   
  <tr>
   <td align="center" width="966" height="121" valign="top" bgcolor="#f38e00">
     
     <table align="center" width="966" dir="rtl" height="121" border="0" cellspacing="0" cellpadding="0">
       <tr>
         <td align="right" width="139" height="121" valign="middle"><img src="/pages/resources/images/h_pic_1.png" width="139" height="121" /></td>
         <td align="right" width="5" height="121" valign="middle"></td>
         <td align="center" width="166" height="121" valign="middle"><img src="/pages/resources/images/h_pic_2.png" width="166" height="121" /></td>
         <td align="right" width="5" height="121" valign="middle"></td>
         <td align="center" width="165" height="121" valign="middle"><img src="/pages/resources/images/h_pic_3.png" width="165" height="121" /></td>
         <td align="right" width="5" height="121" valign="middle"></td>
         <td align="center" width="166" height="121" valign="middle"><img src="/pages/resources/images/h_pic_4.png" width="166" height="121" /></td>
         <td align="right" width="5" height="121" valign="middle"></td>
         <td align="center" width="165" height="121" valign="middle"><img src="/pages/resources/images/h_pic_5.png" width="165" height="121" /></td>
         <td align="right" width="5" height="121" valign="middle"></td>
         <td align="center" width="140" height="121" valign="middle"><img src="/pages/resources/images/h_pic_6.png" width="140" height="121" /></td>
       </tr> 
     </table>
     
   </td>
  </tr>
  
   
  <tr>
   <td align="right" width="966" height="35" valign="middle" bgcolor="#f38e00">
   
     <table align="center" width="966" dir="rtl" height="35" border="0" cellspacing="0" cellpadding="0">
       <tr>
         <td align="right" width="320" height="35" valign="middle">&nbsp;&nbsp;<a href="http://www.daralkalima.edu.ps/" target="_self" class="portalHeader">الصفحة الرئيسية</a></td>
        
         <td align="center" width="320" height="35" valign="middle" class="bigTextBold">طلب الالتحاق</td>
         
         <td align="left" width="320" height="35" valign="middle" class="date">
         <script language=JavaScript>
            <!--
			d = new Date();
			document.write(format_time(d));
			// -->
	     </script></td>
         <td align="left" width="6" height="35"></td>
       </tr>
     </table> 
       
   </td>
  </tr> 
</table>
