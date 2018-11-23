
function checkReqFiled()
 {
     var missingInfo="";
     var bgColorReq="#FFCBCB";
     var bgColorNorm="#FFFFFF";


    // ---------------------------------------------------------------------------------
    if(document.admApplicationForm.appStudentCat.value == "" || document.admApplicationForm.appStudentCat.value == "*")
    {
    document.admApplicationForm.appStudentCat.style.backgroundColor =bgColorReq;
    missingInfo+="تصنيف الطالب"+" *\n";
    }
    else
    {
    document.admApplicationForm.appStudentCat.style.backgroundColor =bgColorNorm;
    }
    // ---------------------------------------------------------------------------------
    if(document.admApplicationForm.firstName.value == "" ||
       document.admApplicationForm.firstName.value == "*")
    {
    document.admApplicationForm.firstName.style.backgroundColor =bgColorReq;
    missingInfo+="الاسم الاول - بالعربي"+" *\n";
    }
    else
    {
    document.admApplicationForm.firstName.style.backgroundColor =bgColorNorm;
    }
     // ---------------------------------------------------------------------------------
    if(document.admApplicationForm.secondName.value == "" ||
       document.admApplicationForm.secondName.value == "*")
    {
    document.admApplicationForm.secondName.style.backgroundColor =bgColorReq;
    missingInfo+="اسم الاب - بالعربي"+" *\n";
    }
    else
    {
    document.admApplicationForm.secondName.style.backgroundColor =bgColorNorm;
    }
  // ---------------------------------------------------------------------------------
    if(document.admApplicationForm.thirdName.value == "" ||
       document.admApplicationForm.thirdName.value == "*")
    {
    document.admApplicationForm.thirdName.style.backgroundColor =bgColorReq;
    missingInfo+="اسم الجد- بالعربي "+" *\n";
    }
    else
    {
    document.admApplicationForm.thirdName.style.backgroundColor =bgColorNorm;
    }
     // ---------------------------------------------------------------------------------
    if(document.admApplicationForm.familyName.value == "" ||
       document.admApplicationForm.familyName.value == "*")
    {
    document.admApplicationForm.familyName.style.backgroundColor =bgColorReq;
    missingInfo+="اسم العائلة- بالعربي "+" *\n";
    }
    else
    {
    document.admApplicationForm.familyName.style.backgroundColor =bgColorNorm;
    }
     // ---------------------------------------------------------------------------------
    if(document.admApplicationForm.firstNameE.value == "" ||
       document.admApplicationForm.firstNameE.value == "*")
    {
    document.admApplicationForm.firstNameE.style.backgroundColor =bgColorReq;
    missingInfo+="الاسم الاول - بالاتيني"+" *\n";
    }
    else
    {
    document.admApplicationForm.firstNameE.style.backgroundColor =bgColorNorm;
    }
      // ---------------------------------------------------------------------------------
    if(document.admApplicationForm.secondNameE.value == "" ||
       document.admApplicationForm.secondNameE.value == "*")
    {
    document.admApplicationForm.secondNameE.style.backgroundColor =bgColorReq;
    missingInfo+="اسم الاب - بالاتيني"+" *\n";
    }
    else
    {
    document.admApplicationForm.secondNameE.style.backgroundColor =bgColorNorm;
    }
      // ---------------------------------------------------------------------------------
    if(document.admApplicationForm.thirdNameE.value == "" ||
       document.admApplicationForm.thirdNameE.value == "*")
    {
    document.admApplicationForm.thirdNameE.style.backgroundColor =bgColorReq;
    missingInfo+="اسم الجد - بالاتيني"+" *\n";
    }
    else
    {
    document.admApplicationForm.thirdNameE.style.backgroundColor =bgColorNorm;
    }
      // ---------------------------------------------------------------------------------
    if(document.admApplicationForm.familyNameE.value == "" ||
       document.admApplicationForm.familyNameE.value == "*")
    {
    document.admApplicationForm.familyNameE.style.backgroundColor =bgColorReq;
    missingInfo+="اسم العائلة - بالاتيني"+" *\n";
    }
    else
    {
    document.admApplicationForm.familyNameE.style.backgroundColor =bgColorNorm;
    }
     // ---------------------------------------------------------------------------------
    if(document.admApplicationForm.idcardType.value == "" ||
       document.admApplicationForm.idcardType.value == "*")
    {
    document.admApplicationForm.idcardType.style.backgroundColor =bgColorReq;
    missingInfo+="نوع الهوية"+" *\n";
    }
    else
    {
    document.admApplicationForm.idcardType.style.backgroundColor =bgColorNorm;
    }
     // ---------------------------------------------------------------------------------
    if(document.admApplicationForm.idcardNo.value == "" ||
       document.admApplicationForm.idcardNo.value == "*")
    {
    document.admApplicationForm.idcardNo.style.backgroundColor =bgColorReq;
    missingInfo+="رقم الهوية"+" *\n";
    }
    else
    {
    document.admApplicationForm.idcardNo.style.backgroundColor =bgColorNorm;
    }
     // ---------------------------------------------------------------------------------
    //    if(document.admApplicationForm.fatherName.value == "" ||
    //       document.admApplicationForm.fatherName.value == "*")
    //    {
    //    document.admApplicationForm.fatherName.style.backgroundColor =bgColorReq;
    //    missingInfo+="اسم الاب"+" *\n";
    //    }
    //    else
    //    {
    //    document.admApplicationForm.fatherName.style.backgroundColor =bgColorNorm;
    //    }
    // ---------------------------------------------------------------------------------
    if(document.admApplicationForm.fatherCert.value == "" ||
       document.admApplicationForm.fatherCert.value == "*")
    {
    document.admApplicationForm.fatherCert.style.backgroundColor =bgColorReq;
    missingInfo+="بيانات الاب - درجة التحصيل العلمي "+" *\n";
    }
    else
    {
    document.admApplicationForm.fatherCert.style.backgroundColor =bgColorNorm;
    }
    // ---------------------------------------------------------------------------------
    if(document.admApplicationForm.fatherJob.value == "" ||
       document.admApplicationForm.fatherJob.value == "*")
    {
    document.admApplicationForm.fatherJob.style.backgroundColor =bgColorReq;
    missingInfo+="بيانات الاب - الوظيفة الحالية "+" *\n";
    }
    else
    {
    document.admApplicationForm.fatherJob.style.backgroundColor =bgColorNorm;
    }
    // ---------------------------------------------------------------------------------
    if(document.admApplicationForm.motherName.value == "" ||
       document.admApplicationForm.motherName.value == "*")
    {
    document.admApplicationForm.motherName.style.backgroundColor =bgColorReq;
    missingInfo+="بيانات الام - اسم الام الثلاثي "+" *\n";
    }
    else
    {
    document.admApplicationForm.motherName.style.backgroundColor =bgColorNorm;
    }
    // ---------------------------------------------------------------------------------
    if(document.admApplicationForm.motherCert.value == "" ||
       document.admApplicationForm.motherCert.value == "*")
    {
    document.admApplicationForm.motherCert.style.backgroundColor =bgColorReq;
    missingInfo+="بيانات الام - درجة التحصيل العلمي "+" *\n";
    }
    else
    {
    document.admApplicationForm.motherCert.style.backgroundColor =bgColorNorm;
    }
    // ---------------------------------------------------------------------------------
    if(document.admApplicationForm.motherJob.value == "" ||
       document.admApplicationForm.motherJob.value == "*")
    {
    document.admApplicationForm.motherJob.style.backgroundColor =bgColorReq;
    missingInfo+="بيانات الام - الوظيفة الحالية "+" *\n";
    }
    else
    {
    document.admApplicationForm.motherJob.style.backgroundColor =bgColorNorm;
    }

      // ---------------------------------------------------------------------------------
    if(document.admApplicationForm.birthCountry.value == "" ||
       document.admApplicationForm.birthCountry.value == "*")
    {
    document.admApplicationForm.birthCountry.style.backgroundColor =bgColorReq;
    missingInfo+="مكان الولادة - الدولة"+" *\n";
    }
    else
    {
    document.admApplicationForm.birthCountry.style.backgroundColor =bgColorNorm;
    }
     // ---------------------------------------------------------------------------------
    if(document.admApplicationForm.birthGovernate.value == "" ||
       document.admApplicationForm.birthGovernate.value == "*")
    {
    document.admApplicationForm.birthGovernate.style.backgroundColor =bgColorReq;
    missingInfo+="مكان الولادة - المحافظة"+" *\n";
    }
    else
    {
    document.admApplicationForm.birthGovernate.style.backgroundColor =bgColorNorm;
    }
      // ---------------------------------------------------------------------------------
    if(document.admApplicationForm.birthLocality.value == "" ||
       document.admApplicationForm.birthLocality.value == "*")
    {
    document.admApplicationForm.birthLocality.style.backgroundColor =bgColorReq;
    missingInfo+="مكان الولادة - المدينة"+" *\n";
    }
    else
    {
    document.admApplicationForm.birthLocality.style.backgroundColor =bgColorNorm;
    }
    // ---------------------------------------------------------------------------------
    if(document.admApplicationForm.birthDate.value == "" ||
     document.admApplicationForm.birthDate.value == "*")
    {
    document.admApplicationForm.birthDate.style.backgroundColor =bgColorReq;
    missingInfo+="تاريخ الميلاد"+" *\n";
    }
    else
    {
    document.admApplicationForm.birthDate.style.backgroundColor =bgColorNorm;
    }
      // ---------------------------------------------------------------------------------
    if(document.admApplicationForm.maritalStatus.value == "" ||
     document.admApplicationForm.maritalStatus.value == "*")
    {
    document.admApplicationForm.maritalStatus.style.backgroundColor =bgColorReq;
    missingInfo+="الحالة الاجتماعية"+" *\n";
    }
    else
    {
    document.admApplicationForm.maritalStatus.style.backgroundColor =bgColorNorm;
    }
       // ---------------------------------------------------------------------------------
    if(document.admApplicationForm.nationality.value == "" ||
     document.admApplicationForm.nationality.value == "*")
    {
    document.admApplicationForm.nationality.style.backgroundColor =bgColorReq;
    missingInfo+="الجنسية"+" *\n";
    }
    else
    {
    document.admApplicationForm.nationality.style.backgroundColor =bgColorNorm;
    }
   // ---------------------------------------------------------------------------------
    if(document.admApplicationForm.healthStatus.value == "" ||
     document.admApplicationForm.healthStatus.value == "*")
    {
    document.admApplicationForm.healthStatus.style.backgroundColor =bgColorReq;
    missingInfo+="الحالة الصحية"+" *\n";
    }
    else
    {
    document.admApplicationForm.healthStatus.style.backgroundColor =bgColorNorm;
    }
     // ---------------------------------------------------------------------------------
    if(document.admApplicationForm.emergencyAddress.value == "" ||
     document.admApplicationForm.emergencyAddress.value == "*")
    {
    document.admApplicationForm.emergencyAddress.style.backgroundColor =bgColorReq;
    missingInfo+="العنوان في حالة الطوارئ"+" *\n";
    }
    else
    {
    document.admApplicationForm.emergencyAddress.style.backgroundColor =bgColorNorm;
    }
      // ---------------------------------------------------------------------------------
    if(document.admApplicationForm.emergencyTel.value == "" ||
     document.admApplicationForm.emergencyTel.value == "*")
    {
    document.admApplicationForm.emergencyTel.style.backgroundColor =bgColorReq;
    missingInfo+="رقم الهاتف"+" *\n";
    }
    else
    {
    document.admApplicationForm.emergencyTel.style.backgroundColor =bgColorNorm;
    }
       // ---------------------------------------------------------------------------------
    if(document.admApplicationForm.schoolNo.value == "" ||
     document.admApplicationForm.schoolNo.value == "*")
    {
    document.admApplicationForm.schoolNo.style.backgroundColor =bgColorReq;
    missingInfo+="اسم المدرسة التي تخرجت منها"+" *\n";
    }
    else
    {
    document.admApplicationForm.schoolNo.style.backgroundColor =bgColorNorm;
    }
       // ---------------------------------------------------------------------------------
    if(document.admApplicationForm.schoolType.value == "" ||
     document.admApplicationForm.schoolType.value == "*")
    {
    document.admApplicationForm.schoolType.style.backgroundColor =bgColorReq;
    missingInfo+="نوع المدرسة"+" *\n";
    }
    else
    {
    document.admApplicationForm.schoolType.style.backgroundColor =bgColorNorm;
    }
       // ---------------------------------------------------------------------------------
    if(document.admApplicationForm.tawOrigin.value == "" ||
     document.admApplicationForm.tawOrigin.value == "*")
    {
    document.admApplicationForm.tawOrigin.style.backgroundColor =bgColorReq;
    missingInfo+="نوع التوجيهي"+" *\n";
    }
    else
    {
    document.admApplicationForm.tawOrigin.style.backgroundColor =bgColorNorm;
    }
    // ---------------------------------------------------------------------------------
    if(document.admApplicationForm.tawYear.value == "" ||
     document.admApplicationForm.tawYear.value == "*")
    {
    document.admApplicationForm.tawYear.style.backgroundColor =bgColorReq;
    missingInfo+="سنة التوجيهي"+" *\n";
    }
    else
    {
    document.admApplicationForm.tawYear.style.backgroundColor =bgColorNorm;
    }
    // ---------------------------------------------------------------------------------
    if(document.admApplicationForm.tawBranch.value == "" ||
     document.admApplicationForm.tawBranch.value == "*")
    {
    document.admApplicationForm.tawBranch.style.backgroundColor =bgColorReq;
    missingInfo+="فرع التوجيهي"+" *\n";
    }
    else
    {
    document.admApplicationForm.tawBranch.style.backgroundColor =bgColorNorm;
    }
    // ---------------------------------------------------------------------------------
    if(document.admApplicationForm.collegeNo.value == "" ||
     document.admApplicationForm.collegeNo.value == "*")
    {
    document.admApplicationForm.collegeNo.style.backgroundColor =bgColorReq;
    missingInfo+="الكلية"+" *\n";
    }
    else
    {
    document.admApplicationForm.collegeNo.style.backgroundColor =bgColorNorm;
    }
       // ---------------------------------------------------------------------------------
//    if(document.admApplicationForm.perBoxNo.value == "" ||
//     document.admApplicationForm.perBoxNo.value == "*")
//    {
//    document.admApplicationForm.perBoxNo.style.backgroundColor =bgColorReq;
//    missingInfo+="العنوان الدائم - ص.ب"+" *\n";
//    }
//    else
//    {
//    document.admApplicationForm.perBoxNo.style.backgroundColor =bgColorNorm;
//    }
       // ---------------------------------------------------------------------------------
    if(document.admApplicationForm.perStreet.value == "" ||
     document.admApplicationForm.perStreet.value == "*")
    {
    document.admApplicationForm.perStreet.style.backgroundColor =bgColorReq;
    missingInfo+="العنوان الدائم - الشارع"+" *\n";
    }
    else
    {
    document.admApplicationForm.perStreet.style.backgroundColor =bgColorNorm;
    }
       // ---------------------------------------------------------------------------------
    if(document.admApplicationForm.perCountry.value == "" ||
     document.admApplicationForm.perCountry.value == "*")
    {
    document.admApplicationForm.perCountry.style.backgroundColor =bgColorReq;
    missingInfo+="العنوان الدائم - الدولة"+" *\n";
    }
    else
    {
    document.admApplicationForm.perCountry.style.backgroundColor =bgColorNorm;
    }
     // ---------------------------------------------------------------------------------
    if(document.admApplicationForm.perGovernate.value == "" ||
     document.admApplicationForm.perGovernate.value == "*")
    {
    document.admApplicationForm.perGovernate.style.backgroundColor =bgColorReq;
    missingInfo+="العنوان الدائم - المحافظة"+" *\n";
    }
    else
    {
    document.admApplicationForm.perGovernate.style.backgroundColor =bgColorNorm;
    }
    // ---------------------------------------------------------------------------------
    if(document.admApplicationForm.perLocality.value == "" ||
     document.admApplicationForm.perLocality.value == "*")
    {
    document.admApplicationForm.perLocality.style.backgroundColor =bgColorReq;
    missingInfo+="العنوان الدائم - المدينة"+" *\n";
    }
    else
    {
    document.admApplicationForm.perLocality.style.backgroundColor =bgColorNorm;
    }
     // ---------------------------------------------------------------------------------
//    if(document.admApplicationForm.perTel.value == "" ||
//     document.admApplicationForm.perTel.value == "*")
//    {
//    document.admApplicationForm.perTel.style.backgroundColor =bgColorReq;
//    missingInfo+="العنوان الدائم - رقم الهاتف"+" *\n";
//    }
//    else
//    {
//    document.admApplicationForm.perTel.style.backgroundColor =bgColorNorm;
//    }
      // ---------------------------------------------------------------------------------
//    if(document.admApplicationForm.perMobile.value == "" ||
//     document.admApplicationForm.perMobile.value == "*")
//    {
//    document.admApplicationForm.perMobile.style.backgroundColor =bgColorReq;
//    missingInfo+="العنوان الدائم - رقم المحمول"+" *\n";
//    }
//    else
//    {
//    document.admApplicationForm.perMobile.style.backgroundColor =bgColorNorm;
//    }

   // ---------------------------------------------------------------------------------
    if(document.admApplicationForm.perEmail.value == "" ||
     document.admApplicationForm.perEmail.value == "*")
    {
    document.admApplicationForm.perEmail.style.backgroundColor =bgColorReq;
    missingInfo+="العنوان الدائم - البريد الالكتروني"+" *\n";
    }
    else
    {
    document.admApplicationForm.perEmail.style.backgroundColor =bgColorNorm;
    }
      // ---------------------------------------------------------------------------------
//    if(document.admApplicationForm.schoolBoxNo.value == "" ||
//     document.admApplicationForm.schoolBoxNo.value == "*")
//    {
//    document.admApplicationForm.schoolBoxNo.style.backgroundColor =bgColorReq;
//    missingInfo+="عنوان المدرسة - ص.ب"+" *\n";
//    }
//    else
//    {
//    document.admApplicationForm.schoolBoxNo.style.backgroundColor =bgColorNorm;
//    }
       // ---------------------------------------------------------------------------------
//    if(document.admApplicationForm.schoolStreet.value == "" ||
//     document.admApplicationForm.schoolStreet.value == "*")
//    {
//    document.admApplicationForm.schoolStreet.style.backgroundColor =bgColorReq;
//    missingInfo+="عنوان المدرسة - الشارع"+" *\n";
//    }
//    else
//    {
//    document.admApplicationForm.schoolStreet.style.backgroundColor =bgColorNorm;
//    }
        // ---------------------------------------------------------------------------------
    if(document.admApplicationForm.schoolCountry.value == "" ||
     document.admApplicationForm.schoolCountry.value == "*")
    {
    document.admApplicationForm.schoolCountry.style.backgroundColor =bgColorReq;
    missingInfo+="عنوان المدرسة - الدولة"+" *\n";
    }
    else
    {
    document.admApplicationForm.schoolCountry.style.backgroundColor =bgColorNorm;
    }
        // ---------------------------------------------------------------------------------
    if(document.admApplicationForm.schoolGovernate.value == "" ||
     document.admApplicationForm.schoolGovernate.value == "*")
    {
    document.admApplicationForm.schoolGovernate.style.backgroundColor =bgColorReq;
    missingInfo+="عنوان المدرسة - المحافظة"+" *\n";
    }
    else
    {
    document.admApplicationForm.schoolGovernate.style.backgroundColor =bgColorNorm;
    }
       // ---------------------------------------------------------------------------------
    if(document.admApplicationForm.schoolLocality.value == "" ||
     document.admApplicationForm.schoolLocality.value == "*")
    {
    document.admApplicationForm.schoolLocality.style.backgroundColor =bgColorReq;
    missingInfo+="عنوان المدرسة - المدينة"+" *\n";
    }
    else
    {
    document.admApplicationForm.schoolLocality.style.backgroundColor =bgColorNorm;
    }
     // ---------------------------------------------------------------------------------
    if(document.admApplicationForm.specNo.value == "" ||
     document.admApplicationForm.specNo.value == "*")
    {
    document.admApplicationForm.specNo.style.backgroundColor =bgColorReq;
    missingInfo+="التخصص"+" *\n";
    }
    else
    {
    document.admApplicationForm.specNo.style.backgroundColor =bgColorNorm;
    }
     // ---------------------------------------------------------------------------------
//    if(document.admApplicationForm.tawSeat.value == "" ||
//     document.admApplicationForm.tawSeat.value == "*")
//    {
//    document.admApplicationForm.tawSeat.style.backgroundColor =bgColorReq;
//    missingInfo+="رقم الجلوس"+" *\n";
//    }
//    else
//    {
//    document.admApplicationForm.tawSeat.style.backgroundColor =bgColorNorm;
//    }
    // ===========================================================================
      if(document.admApplicationForm.appStudentCat.value == "T"  )
    {
            // ---------------------------------------------------------------------------------
            if(document.admApplicationForm.eduUcNo_1.value == "" ||
             document.admApplicationForm.eduUcNo_1.value == "*")
            {
            document.admApplicationForm.eduUcNo_1.style.backgroundColor =bgColorReq;
            missingInfo+="بيانات المحول - اسم المؤسسة"+" *\n";
            }
            else
            {
            document.admApplicationForm.eduUcNo_1.style.backgroundColor =bgColorNorm;
            }
           // ---------------------------------------------------------------------------------
            if(document.admApplicationForm.eduUcCountry_1.value == "" ||
             document.admApplicationForm.eduUcCountry_1.value == "*")
            {
            document.admApplicationForm.eduUcCountry_1.style.backgroundColor =bgColorReq;
            missingInfo+="بيانات المحول - الدولة"+" *\n";
            }
            else
            {
            document.admApplicationForm.eduUcCountry_1.style.backgroundColor =bgColorNorm;
            }
           // ---------------------------------------------------------------------------------
            if(document.admApplicationForm.eduUcGovernate_1.value == "" ||
             document.admApplicationForm.eduUcGovernate_1.value == "*")
            {
            document.admApplicationForm.eduUcGovernate_1.style.backgroundColor =bgColorReq;
            missingInfo+="بيانات المحول - المحافظة"+" *\n";
            }
            else
            {
            document.admApplicationForm.eduUcGovernate_1.style.backgroundColor =bgColorNorm;
            }
           // ---------------------------------------------------------------------------------
            if(document.admApplicationForm.eduUcLocality_1.value == "" ||
             document.admApplicationForm.eduUcLocality_1.value == "*")
            {
            document.admApplicationForm.eduUcLocality_1.style.backgroundColor =bgColorReq;
            missingInfo+="بيانات المحول - المدينة"+" *\n";
            }
            else
            {
            document.admApplicationForm.eduUcLocality_1.style.backgroundColor =bgColorNorm;
            }
           // ---------------------------------------------------------------------------------
            if(document.admApplicationForm.eduStartDate_1.value == "" ||
             document.admApplicationForm.eduStartDate_1.value == "*")
            {
            document.admApplicationForm.eduStartDate_1.style.backgroundColor =bgColorReq;
            missingInfo+="بيانات المحول - تاريخ الالتحاق - من"+" *\n";
            }
            else
            {
            document.admApplicationForm.eduStartDate_1.style.backgroundColor =bgColorNorm;
            }
           // ---------------------------------------------------------------------------------
            if(document.admApplicationForm.eduEndDate_1.value == "" ||
             document.admApplicationForm.eduEndDate_1.value == "*")
            {
            document.admApplicationForm.eduEndDate_1.style.backgroundColor =bgColorReq;
            missingInfo+="بيانات المحول - تاريخ الالتحاق - الى"+" *\n";
            }
            else
            {
            document.admApplicationForm.eduEndDate_1.style.backgroundColor =bgColorNorm;
            }
            // ---------------------------------------------------------------------------------
            if(document.admApplicationForm.rsdSpecNo_1.value == "" ||
             document.admApplicationForm.rsdSpecNo_1.value == "*")
            {
            document.admApplicationForm.rsdSpecNo_1.style.backgroundColor =bgColorReq;
            missingInfo+="بيانات المحول - نوع الشهادة"+" *\n";
            }
            else
            {
            document.admApplicationForm.rsdSpecNo_1.style.backgroundColor =bgColorNorm;
            }
            // ---------------------------------------------------------------------------------
            if(document.admApplicationForm.eduSpecTypeNo_1.value == "" ||
             document.admApplicationForm.eduSpecTypeNo_1.value == "*")
            {
            document.admApplicationForm.eduSpecTypeNo_1.style.backgroundColor =bgColorReq;
            missingInfo+="بيانات المحول - الدرجة التي حصلت عليها"+" *\n";
            }
            else
            {
            document.admApplicationForm.eduSpecTypeNo_1.style.backgroundColor =bgColorNorm;
            }
            // ---------------------------------------------------------------------------------
            if(document.admApplicationForm.eduGradeDate_1.value == "" ||
             document.admApplicationForm.eduGradeDate_1.value == "*")
            {
            document.admApplicationForm.eduGradeDate_1.style.backgroundColor =bgColorReq;
            missingInfo+="بيانات المحول - تاريخ الحصول عليها"+" *\n";
            }
            else
            {
            document.admApplicationForm.eduGradeDate_1.style.backgroundColor =bgColorNorm;
            }
           // **********************************************************

            if(document.admApplicationForm.eduUcNo_2.value != "" &&
             document.admApplicationForm.eduUcNo_2.value != "*")
            {
            document.admApplicationForm.eduUcNo_2.style.backgroundColor =bgColorReq;
            missingInfo+="بيانات المحول - اسم المؤسسة"+" *\n";

           // ---------------------------------------------------------------------------------
            if(document.admApplicationForm.eduUcCountry_2.value == "" ||
             document.admApplicationForm.eduUcCountry_2.value == "*")
            {
            document.admApplicationForm.eduUcCountry_2.style.backgroundColor =bgColorReq;
            missingInfo+="بيانات المحول - الدولة"+" *\n";
            }
            else
            {
            document.admApplicationForm.eduUcCountry_2.style.backgroundColor =bgColorNorm;
            }
           // ---------------------------------------------------------------------------------
            if(document.admApplicationForm.eduUcGovernate_2.value == "" ||
             document.admApplicationForm.eduUcGovernate_2.value == "*")
            {
            document.admApplicationForm.eduUcGovernate_2.style.backgroundColor =bgColorReq;
            missingInfo+="بيانات المحول - المحافظة"+" *\n";
            }
            else
            {
            document.admApplicationForm.eduUcGovernate_2.style.backgroundColor =bgColorNorm;
            }
           // ---------------------------------------------------------------------------------
            if(document.admApplicationForm.eduUcLocality_2.value == "" ||
             document.admApplicationForm.eduUcLocality_2.value == "*")
            {
            document.admApplicationForm.eduUcLocality_2.style.backgroundColor =bgColorReq;
            missingInfo+="بيانات المحول - المدينة"+" *\n";
            }
            else
            {
            document.admApplicationForm.eduUcLocality_2.style.backgroundColor =bgColorNorm;
            }
           // ---------------------------------------------------------------------------------
            if(document.admApplicationForm.eduStartDate_2.value == "" ||
             document.admApplicationForm.eduStartDate_2.value == "*")
            {
            document.admApplicationForm.eduStartDate_2.style.backgroundColor =bgColorReq;
            missingInfo+="بيانات المحول - تاريخ الالتحاق - من"+" *\n";
            }
            else
            {
            document.admApplicationForm.eduStartDate_2.style.backgroundColor =bgColorNorm;
            }
           // ---------------------------------------------------------------------------------
            if(document.admApplicationForm.eduEndDate_2.value == "" ||
             document.admApplicationForm.eduEndDate_2.value == "*")
            {
            document.admApplicationForm.eduEndDate_2.style.backgroundColor =bgColorReq;
            missingInfo+="بيانات المحول - تاريخ الالتحاق - الى"+" *\n";
            }
            else
            {
            document.admApplicationForm.eduEndDate_2.style.backgroundColor =bgColorNorm;
            }
            // ---------------------------------------------------------------------------------
            if(document.admApplicationForm.rsdSpecNo_2.value == "" ||
             document.admApplicationForm.rsdSpecNo_2.value == "*")
            {
            document.admApplicationForm.rsdSpecNo_2.style.backgroundColor =bgColorReq;
            missingInfo+="بيانات المحول - نوع الشهادة"+" *\n";
            }
            else
            {
            document.admApplicationForm.rsdSpecNo_2.style.backgroundColor =bgColorNorm;
            }
            // ---------------------------------------------------------------------------------
            if(document.admApplicationForm.eduSpecTypeNo_2.value == "" ||
             document.admApplicationForm.eduSpecTypeNo_2.value == "*")
            {
            document.admApplicationForm.eduSpecTypeNo_2.style.backgroundColor =bgColorReq;
            missingInfo+="بيانات المحول - الدرجة التي حصلت عليها"+" *\n";
            }
            else
            {
            document.admApplicationForm.eduSpecTypeNo_2.style.backgroundColor =bgColorNorm;
            }
            // ---------------------------------------------------------------------------------
            if(document.admApplicationForm.eduGradeDate_2.value == "" ||
             document.admApplicationForm.eduGradeDate_2.value == "*")
            {
            document.admApplicationForm.eduGradeDate_2.style.backgroundColor =bgColorReq;
            missingInfo+="بيانات المحول - تاريخ الحصول عليها"+" *\n";
            }
            else
            {
            document.admApplicationForm.eduGradeDate_2.style.backgroundColor =bgColorNorm;
            }
            }
            else
            {
                document.admApplicationForm.eduUcNo_2.style.backgroundColor =bgColorNorm;
                document.admApplicationForm.eduUcCountry_2.style.backgroundColor =bgColorNorm;
                document.admApplicationForm.eduUcGovernate_2.style.backgroundColor =bgColorNorm;
                document.admApplicationForm.eduUcLocality_2.style.backgroundColor =bgColorNorm;
                document.admApplicationForm.eduStartDate_2.style.backgroundColor =bgColorNorm;
                document.admApplicationForm.eduEndDate_2.style.backgroundColor =bgColorNorm;
                document.admApplicationForm.rsdSpecNo_2.style.backgroundColor =bgColorNorm;
                document.admApplicationForm.eduSpecTypeNo_2.style.backgroundColor =bgColorNorm;
                document.admApplicationForm.eduGradeDate_2.style.backgroundColor =bgColorNorm;
            }
            // *********************************************************************

            if(document.admApplicationForm.eduUcNo_3.value != "" &&
             document.admApplicationForm.eduUcNo_3.value != "*")
            {
            document.admApplicationForm.eduUcNo_3.style.backgroundColor =bgColorReq;
            missingInfo+="بيانات المحول - اسم المؤسسة"+" *\n";

           // ---------------------------------------------------------------------------------
            if(document.admApplicationForm.eduUcCountry_3.value == "" ||
             document.admApplicationForm.eduUcCountry_3.value == "*")
            {
            document.admApplicationForm.eduUcCountry_3.style.backgroundColor =bgColorReq;
            missingInfo+="بيانات المحول - الدولة"+" *\n";
            }
            else
            {
            document.admApplicationForm.eduUcCountry_3.style.backgroundColor =bgColorNorm;
            }
           // ---------------------------------------------------------------------------------
            if(document.admApplicationForm.eduUcGovernate_3.value == "" ||
             document.admApplicationForm.eduUcGovernate_3.value == "*")
            {
            document.admApplicationForm.eduUcGovernate_3.style.backgroundColor =bgColorReq;
            missingInfo+="بيانات المحول - المحافظة"+" *\n";
            }
            else
            {
            document.admApplicationForm.eduUcGovernate_3.style.backgroundColor =bgColorNorm;
            }
           // ---------------------------------------------------------------------------------
            if(document.admApplicationForm.eduUcLocality_3.value == "" ||
             document.admApplicationForm.eduUcLocality_3.value == "*")
            {
            document.admApplicationForm.eduUcLocality_3.style.backgroundColor =bgColorReq;
            missingInfo+="بيانات المحول - المدينة"+" *\n";
            }
            else
            {
            document.admApplicationForm.eduUcLocality_3.style.backgroundColor =bgColorNorm;
            }
           // ---------------------------------------------------------------------------------
            if(document.admApplicationForm.eduStartDate_3.value == "" ||
             document.admApplicationForm.eduStartDate_3.value == "*")
            {
            document.admApplicationForm.eduStartDate_3.style.backgroundColor =bgColorReq;
            missingInfo+="بيانات المحول - تاريخ الالتحاق - من"+" *\n";
            }
            else
            {
            document.admApplicationForm.eduStartDate_3.style.backgroundColor =bgColorNorm;
            }
           // ---------------------------------------------------------------------------------
            if(document.admApplicationForm.eduEndDate_3.value == "" ||
             document.admApplicationForm.eduEndDate_3.value == "*")
            {
            document.admApplicationForm.eduEndDate_3.style.backgroundColor =bgColorReq;
            missingInfo+="بيانات المحول - تاريخ الالتحاق - الى"+" *\n";
            }
            else
            {
            document.admApplicationForm.eduEndDate_3.style.backgroundColor =bgColorNorm;
            }
            // ---------------------------------------------------------------------------------
            if(document.admApplicationForm.rsdSpecNo_3.value == "" ||
             document.admApplicationForm.rsdSpecNo_3.value == "*")
            {
            document.admApplicationForm.rsdSpecNo_3.style.backgroundColor =bgColorReq;
            missingInfo+="بيانات المحول - نوع الشهادة"+" *\n";
            }
            else
            {
            document.admApplicationForm.rsdSpecNo_3.style.backgroundColor =bgColorNorm;
            }
            // ---------------------------------------------------------------------------------
            if(document.admApplicationForm.eduSpecTypeNo_3.value == "" ||
             document.admApplicationForm.eduSpecTypeNo_3.value == "*")
            {
            document.admApplicationForm.eduSpecTypeNo_3.style.backgroundColor =bgColorReq;
            missingInfo+="بيانات المحول - الدرجة التي حصلت عليها"+" *\n";
            }
            else
            {
            document.admApplicationForm.eduSpecTypeNo_3.style.backgroundColor =bgColorNorm;
            }
            // ---------------------------------------------------------------------------------
            if(document.admApplicationForm.eduGradeDate_3.value == "" ||
             document.admApplicationForm.eduGradeDate_3.value == "*")
            {
            document.admApplicationForm.eduGradeDate_3.style.backgroundColor =bgColorReq;
            missingInfo+="بيانات المحول - تاريخ الحصول عليها"+" *\n";
            }
            else
            {
            document.admApplicationForm.eduGradeDate_3.style.backgroundColor =bgColorNorm;
            }
            }
            else
            {
                document.admApplicationForm.eduUcNo_3.style.backgroundColor =bgColorNorm;
                document.admApplicationForm.eduUcCountry_3.style.backgroundColor =bgColorNorm;
                document.admApplicationForm.eduUcGovernate_3.style.backgroundColor =bgColorNorm;
                document.admApplicationForm.eduUcLocality_3.style.backgroundColor =bgColorNorm;
                document.admApplicationForm.eduStartDate_3.style.backgroundColor =bgColorNorm;
                document.admApplicationForm.eduEndDate_3.style.backgroundColor =bgColorNorm;
                document.admApplicationForm.rsdSpecNo_3.style.backgroundColor =bgColorNorm;
                document.admApplicationForm.eduSpecTypeNo_3.style.backgroundColor =bgColorNorm;
                document.admApplicationForm.eduGradeDate_3.style.backgroundColor =bgColorNorm;
            }
            // *********************************************************************
                  
    }
     // ===========================================================================
          if(document.admApplicationForm.lngLangNo_1.value == "" ||
             document.admApplicationForm.lngLangNo_1.value == "*")
            {
            document.admApplicationForm.lngLangNo_1.style.backgroundColor =bgColorReq;
            missingInfo+="المقدرة اللغوية - اللغة"+" *\n";
            }
            else
            {
            document.admApplicationForm.lngLangNo_1.style.backgroundColor =bgColorNorm;
            }
           // ---------------------------------------------------------------
           if(document.admApplicationForm.lngReadLevelNo_1.value == "" ||
             document.admApplicationForm.lngReadLevelNo_1.value == "*")
            {
            document.admApplicationForm.lngReadLevelNo_1.style.backgroundColor =bgColorReq;
            missingInfo+="المقدرة اللغوية - مستوى القراءة"+" *\n";
            }
            else
            {
            document.admApplicationForm.lngReadLevelNo_1.style.backgroundColor =bgColorNorm;
            }
            // ----------------------------------------------------------
            if(document.admApplicationForm.lngWriteLevelNo_1.value == "" ||
             document.admApplicationForm.lngWriteLevelNo_1.value == "*")
            {
            document.admApplicationForm.lngWriteLevelNo_1.style.backgroundColor =bgColorReq;
            missingInfo+="المقدرة اللغوية - مستوى الكتابة"+" *\n";
            }
            else
            {
            document.admApplicationForm.lngWriteLevelNo_1.style.backgroundColor =bgColorNorm;
            }
            // ----------------------------------------------------------
             if(document.admApplicationForm.lngSpeakLevelNo_1.value == "" ||
             document.admApplicationForm.lngSpeakLevelNo_1.value == "*")
            {
            document.admApplicationForm.lngSpeakLevelNo_1.style.backgroundColor =bgColorReq;
            missingInfo+="المقدرة اللغوية - مستوى المحادثة"+" *\n";
            }
            else
            {
            document.admApplicationForm.lngSpeakLevelNo_1.style.backgroundColor =bgColorNorm;
            }
            // ----------------------------------------------------------

     // ===========================================================================
      if(document.admApplicationForm.lngLangNo_2.value != "" &&
         document.admApplicationForm.lngLangNo_2.value != "*")
        {
           if(document.admApplicationForm.lngReadLevelNo_2.value == "" ||
             document.admApplicationForm.lngReadLevelNo_2.value == "*")
            {
            document.admApplicationForm.lngReadLevelNo_2.style.backgroundColor =bgColorReq;
            missingInfo+="المقدرة اللغوية - مستوى القراءة"+" *\n";
            }
            else
            {
            document.admApplicationForm.lngReadLevelNo_2.style.backgroundColor =bgColorNorm;
            }
            // ----------------------------------------------------------
            if(document.admApplicationForm.lngWriteLevelNo_2.value == "" ||
             document.admApplicationForm.lngWriteLevelNo_2.value == "*")
            {
            document.admApplicationForm.lngWriteLevelNo_2.style.backgroundColor =bgColorReq;
            missingInfo+="المقدرة اللغوية - مستوى الكتابة"+" *\n";
            }
            else
            {
            document.admApplicationForm.lngWriteLevelNo_2.style.backgroundColor =bgColorNorm;
            }
            // ----------------------------------------------------------
             if(document.admApplicationForm.lngSpeakLevelNo_2.value == "" ||
             document.admApplicationForm.lngSpeakLevelNo_2.value == "*")
            {
            document.admApplicationForm.lngSpeakLevelNo_2.style.backgroundColor =bgColorReq;
            missingInfo+="المقدرة اللغوية - مستوى المحادثة"+" *\n";
            }
            else
            {
            document.admApplicationForm.lngSpeakLevelNo_2.style.backgroundColor =bgColorNorm;
            }
            // ----------------------------------------------------------
        }
        else
        {
            document.admApplicationForm.lngReadLevelNo_2.style.backgroundColor =bgColorNorm;
            document.admApplicationForm.lngWriteLevelNo_2.style.backgroundColor =bgColorNorm;
            document.admApplicationForm.lngSpeakLevelNo_2.style.backgroundColor =bgColorNorm;
        }// ===========================================================================
      if(document.admApplicationForm.lngLangNo_3.value != "" &&
         document.admApplicationForm.lngLangNo_3.value != "*")
        {
           if(document.admApplicationForm.lngReadLevelNo_3.value == "" ||
             document.admApplicationForm.lngReadLevelNo_3.value == "*")
            {
            document.admApplicationForm.lngReadLevelNo_3.style.backgroundColor =bgColorReq;
            missingInfo+="المقدرة اللغوية - مستوى القراءة"+" *\n";
            }
            else
            {
            document.admApplicationForm.lngReadLevelNo_3.style.backgroundColor =bgColorNorm;
            }
            // ----------------------------------------------------------
            if(document.admApplicationForm.lngWriteLevelNo_3.value == "" ||
             document.admApplicationForm.lngWriteLevelNo_3.value == "*")
            {
            document.admApplicationForm.lngWriteLevelNo_3.style.backgroundColor =bgColorReq;
            missingInfo+="المقدرة اللغوية - مستوى الكتابة"+" *\n";
            }
            else
            {
            document.admApplicationForm.lngWriteLevelNo_3.style.backgroundColor =bgColorNorm;
            }
            // ----------------------------------------------------------
             if(document.admApplicationForm.lngSpeakLevelNo_3.value == "" ||
             document.admApplicationForm.lngSpeakLevelNo_3.value == "*")
            {
            document.admApplicationForm.lngSpeakLevelNo_3.style.backgroundColor =bgColorReq;
            missingInfo+="المقدرة اللغوية - مستوى المحادثة"+" *\n";
            }
            else
            {
            document.admApplicationForm.lngSpeakLevelNo_3.style.backgroundColor =bgColorNorm;
            }
            // ----------------------------------------------------------
        }
        else
        {
            document.admApplicationForm.lngReadLevelNo_3.style.backgroundColor =bgColorNorm;
            document.admApplicationForm.lngWriteLevelNo_3.style.backgroundColor =bgColorNorm;
            document.admApplicationForm.lngSpeakLevelNo_3.style.backgroundColor =bgColorNorm;
        }
     // ===========================================================================


       	return missingInfo;
 }