
var countCrsReg = 0;
var minH = 0;
var maxh = 0;
var regedHours = 0;
var basicNewLoad = 0;
var basicOldLoad = 0;
var minHours = 0;
var regPeriod = '';


function constructorValue( minH_p,maxh_p,regedHours_p,basicNewLoad_p,minHours_p,regPeriod_p)
{
  this.minH = minH_p;
  this.maxh = maxh_p;
  this.regedHours = regedHours_p;
  this.basicNewLoad = basicNewLoad_p;
  this.minHours = minHours_p;
  this.regPeriod = regPeriod_p;
   

}
 



function cbxClicked(cbxNo)
{
//    alert(cbxNo);

    var x = document.getElementById("cbx_"+cbxNo);

    if(x.checked)// this mean that the check box is selected now
    {
       if(!checkHours(cbxNo, "selection"))
       {
            alert("لقد تجاوزت الحد الاعلى لعدد الساعات المسموح تسجيله: "+maxh)
            x.checked = false;
       }
       else if(!checkStatus(cbxNo, "selection"))
       {
            x.checked = false;
       }
       else if(crsRegedInOtherClass(cbxNo))
       {
            alert("لقد قمت بتسجيل هذا المقرر بشعبة مختلفة")
            x.checked = false;
       }
       else
       {
            countCrsReg++;
       }
    }
    else// this mean that the check box is unselected now
    {
       countCrsReg--;
    }

    
    updateHoursSum();
}

function updateHoursSum()
{
  var hsum = 0;
  for(var i=0; i < document.form1.elements.length; i++)
  {
    var elementName = new String(document.form1.elements[i].name);
    if(elementName.indexOf("cbx_") != -1)
      if(document.form1.elements[i].checked)
      {
          var chkNo = elementName.substring(elementName.indexOf("cbx_")+4);
          var hidInfo = new String((document.getElementById("cri_"+chkNo)).value);
          var offset = hidInfo.indexOf("_h")
          var hours = hidInfo.substring(offset+2, offset+3);
          hsum = hsum + parseInt(hours);

      }
  }
// alert( basicNewLoad);
  document.getElementById("hoursSumDiv").innerHTML = (hsum + parseInt(basicNewLoad));
}

function checkHours(cbxNo, action)
{
  var numOfCrsHours = 0;

  var hidInfo = new String((document.getElementById("cri_"+cbxNo)).value);
  var offset = hidInfo.indexOf("_h")
  var hours = hidInfo.substring(offset+2, offset+3);

  if(regPeriod == "RP")
    numOfCrsHours = parseInt(hours) + parseInt(document.getElementById("hoursSumDiv").innerHTML)
  else
    numOfCrsHours = parseInt(hours) + parseInt(document.getElementById("hoursSumDiv").innerHTML) + basicOldLoad;

  if(action == "selection" && (numOfCrsHours) > maxh)
    return false;
  else
  {
    return true;
  }
}

function checkStatus(cbxNo, action)
{
    var hidInfo = new String((document.getElementById("cri_"+cbxNo)).value);
//    alert(hidInfo);
    var offset = hidInfo.indexOf("_s");
    var status = hidInfo.substring(offset+2, offset+3);

    // these check must be updated according to course status from db
    // what implemented now is a demo

    if(status == "S")
    {
      if(confirm("لقد إجتزت هذا المقرر بنجاح في السابق, هل تريد إعادة تسجيله؟"))
        return true;
      else
        return false;
    }

    if(status == "T")
    {
      if(confirm("لقد تم إحتساب هذا المقرر في السابق, هل تريد أعادة تسجيله؟"))
        return true;
      else
        return false;
    }

    var regedCrshidInfo = new String((document.getElementById("reged_crs_"+cbxNo)));
    if(regedCrshidInfo != "null")
    {
      alert("لقد قمت تسجيل هذا القمرر مسبقا، لايمكن إعادة تسجيله الا في حال حذف المقرر المسجل أولا")
        return false;
    }

    return true;
}
function crsRegedInOtherClass(cbxNo)
{
    var indxClsNo = cbxNo.indexOf("_c")
    var crsNo = cbxNo.substring(0, indxClsNo);

    for(var i=0; i < document.form1.elements.length; i++)
    {
        var elementName = new String(document.form1.elements[i].name);
          if(elementName.indexOf("cbx_"+crsNo) != -1 )
          if(document.form1.elements[i].checked && document.form1.elements[i].name !="cbx_"+cbxNo)
          {
              return true;
          }
    }

}

function submitProcess(pp)
{
    var hsum = 0;
    var reRegisterCrs = false;

    for(var i=0; i < document.form1.elements.length; i++)
    {
        var elementName = new String(document.form1.elements[i].name);
        if(elementName.indexOf("cbx_") != -1)
          if(document.form1.elements[i].checked)
          {
              var chkNo = elementName.substring(elementName.indexOf("cbx_")+4);
              var hidInfo = new String((document.getElementById("cri_"+chkNo)).value);
              var offset = hidInfo.indexOf("_h")
              var hours = hidInfo.substring(offset+2, offset+3);
              hsum = hsum + parseInt(hours);
          }

        var regedCrshidInfo = new String((document.getElementById("reged_crs_"+chkNo)));
        if(regedCrshidInfo != "null")
        {
            reRegisterCrs = true;
        }
    }

//    if(regPeriod == "RP")
//    {
        if((hsum+parseInt(basicNewLoad )) > maxh)
        {

            alert("لقد تجاوزت الحد الاعلى لعدد الساعات المسموح تسجيله: "+maxh)
//            document.getElementById("hoursSumDiv").innerHTML = hsum ;
            return false;
        }
//    }
//    else
//    {
//        if(parseInt(hsum + regedHours) > maxh)
//        {
//            alert("لقد تجاوزت الحد الاعلى لعدد الساعات المسموح تسجيله: "+maxh)
//            document.getElementById("hoursSumDiv").innerHTML =(hsum + parseInt(regedHours));
//            return false;
//        }
//     }

    // to check if total registerd hours more than 2
    var newHoursReg = document.getElementById("hoursSumDiv").innerHTML;
    document.getElementById("newLoadHours").value = newHoursReg;

    if(parseInt(newHoursReg) < parseInt(minHours) && pp=="RP")
    {
        alert("عدد الساعات المسجلة اقل من أربع ساعات ,لا يمكنك تثبيت التسجيل")
        return false;
    }

    if(reRegisterCrs == true)
    {
        alert("لقد قمت بتسجيل مقررات مسجلة مسبقا، لايمكن إعادة تسجيل هذه المقررات الا في حال حذف المقررات المسجلة أولا")
        return false;
    }

    if(pp == "RP" && !confirm("في حال قيامك بتثبيت تسجيلك لن يكون بإمكانك التعديل على المقررات المسجلة، هل تريد الاستمرار؟"))
    {
        return;
    }

    document.getElementById("p").value = pp;
    document.getElementById("prevNewHsum").value = basicNewLoad;
    document.form1.submit();
}

function delConf(formId)
{
   if(confirm("هل أنت متأكد من أنك تريد حذف هذا المقرر؟"))
   {
        document.getElementById("btnsDiv").innerHTML = "عملية الحذف قيد التنفيذ"
        document.getElementById("delForm"+formId).submit();
   }
}
 

function openPayReportPage(stud_id)
{
  var broswerName = new String(navigator.appName);

  if(broswerName.indexOf("Microsoft") >= 0)
  {
	var win = window.open('/student/viewStudRegCrsReport?stud_id='+stud_id+'&.rv=<%=Randomizer.shortRandom()%>','OldLoad','toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=no,width=1000,height=400');
  }
  else if(broswerName.indexOf("Netscape") >= 0)
  {
	var win = window.open('../../student/viewStudRegCrsReport?stud_id='+stud_id+'&.rv=<%=Randomizer.shortRandom()%>','OldLoad','toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=no,width=1000,height=400');
  }
}

