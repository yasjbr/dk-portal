/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ps.edu.diyar.studentInfo.useCase;

import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.hibernate.HibernateException;
import ps.edu.diyar.common.component.DataAccessObjectImpl;
import ps.edu.diyar.common.tools.RequestSelectedTermIndexBinder;
import ps.edu.diyar.common.useCase.ComponentUseCase;
import ps.edu.diyar.deptMaster.database.struct.DeptMasterInfoHolder;
import ps.edu.diyar.studentInfo.database.SasStudFtermCard;
import ps.edu.diyar.studentInfo.database.struct.StudentInfoHolder;

/**
 *
 * @author Yaseen Jaber
 */
public class ShowTermFinancialUseCase  implements ComponentUseCase
{
  public Collection execute(Collection input, HttpServletRequest request)
    throws HibernateException
  {
    List termSummaryList = null;
    try
    {
      HttpSession session = request.getSession();
      String crntTermNo = null;
       String crntTermNo11 = null;
      String studId = null;
      
      
      if (request.getSession().getAttribute("studentInfo") != null)
      {
          System.out.println("13322");
        StudentInfoHolder studentInfo = (StudentInfoHolder)((List)session.getAttribute("studentInfo")).get(0);
          System.out.println("studentInfo" + studentInfo.getStudentName());
       // crntTermNo = studentInfo.getSystemCurrentTermNo();
        //  crntTermNo = studentInfo.getCurrentTermNo(); changd 8.6.2016 to use fin term 
         if (request.getAttribute("fin") != null)
         {
               crntTermNo = studentInfo.getCurrentTermNo();
               System.out.println("vf1" );
               crntTermNo11 = studentInfo.getFinMaxTermNo();  
               System.out.println("CurrentTermNo11 *******************" + crntTermNo11);
         }
        else
        {
              crntTermNo = studentInfo.getFinMaxTermNo();   
              System.out.println("vf2" );
        }
        System.out.println("CurrentTermNo *******************" + crntTermNo);
        studId = studentInfo.getStudentId();
      }
      else if (request.getSession().getAttribute("deptMaster") != null)
      {
          System.out.println("printed hre");
        DeptMasterInfoHolder deptMasterInfo = (DeptMasterInfoHolder)((List)request.getSession().getAttribute("deptMaster")).get(0);
          crntTermNo = deptMasterInfo.getCurrentTermNo(); //changd 8.6.2016 to use fin term 
           studId = request.getParameter("studId");
       /////
         System.out.println("CurrentTermNo ********22***********" + crntTermNo);
        List maxFinTermList= new DataAccessObjectImpl().getList("stud.getStudentLastFinancialTermNo", new Object[] { studId, crntTermNo});
      if ((maxFinTermList != null) && ((String)maxFinTermList.get(0) != null))
      {
          
          crntTermNo = (String)maxFinTermList.get(0);
          System.out.println("finMaxTermNo"+crntTermNo);
                
      }
         
         
       ///////
      
        
      }
      String selectedTerm = "";
      if (request.getParameter("term") != null)
      {
          
        selectedTerm = request.getParameter("term");
          
      }
      else
      {
        selectedTerm = crntTermNo;
          System.out.println("selectedTerm"+selectedTerm);
        request.setAttribute("term", selectedTerm);
      }
      DataAccessObjectImpl cmp = new DataAccessObjectImpl();
      if ((request.getParameter("index") == null) && (session.getAttribute("termsList") != null)) {
        request.setAttribute("index", RequestSelectedTermIndexBinder.setRequestSelectedTermIndex((List)session.getAttribute("termsList"), selectedTerm));
      }
       System.out.println("term parameter"+selectedTerm);
          System.out.println("studId"+studId);
      termSummaryList = cmp.getList("Portal.getStudentCurrentTermFinancial", new Object[] { studId, selectedTerm });
    }
    catch (Exception e)
    {
      e.printStackTrace();
      System.out.println("Error in the show term summary use case" + e);
    }
      SasStudFtermCard cc = (SasStudFtermCard) termSummaryList.get(0);
      
      System.out.println("cc"+cc.getDbBaseAmt());
    return termSummaryList;
  }
}


 