package ps.edu.diyar.studentInfo.useCase;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import ps.edu.diyar.common.component.DataAccessObjectImpl;
import ps.edu.diyar.common.component.FormCmp;
import ps.edu.diyar.common.tools.DateTool;
import ps.edu.diyar.common.useCase.ComponentUseCase;
import ps.edu.diyar.studentInfo.database.SrvyLoan;
import ps.edu.diyar.studentInfo.database.SrvyLoanFamily;
import ps.edu.diyar.studentInfo.database.SrvyLoanFamilyPK;
import ps.edu.diyar.studentInfo.database.SrvyLoanPK;
import ps.edu.diyar.studentInfo.database.SrvyLoanPersonal;
import ps.edu.diyar.studentInfo.database.SrvyLoanPersonalPK;

public class SaveStudSocialSrvLoanInfoUseCase
  implements ComponentUseCase
{
  private static Logger logger = Logger.getLogger(SaveStudSocialSrvLoanInfoUseCase.class);
  
  public Collection execute(Collection input, HttpServletRequest request)
    throws HibernateException
  {
    Collection retList = null;
    Iterator itr = input.iterator();
    
    String studId = (String)itr.next();
    String termNo = (String)itr.next();
    
    String applyLoan = (String)itr.next();
    String applyReason = (String)itr.next();
    String takeLoan = (String)itr.next();
    String loanType = (String)itr.next();
    String loanPeriod = (String)itr.next();
    String loanTermCount = (String)itr.next();
    String hasFamilyLoan = (String)itr.next();
    

    String fmlyCounter = (String)itr.next();
    String fmlyLoaner = (String)itr.next();
    String fmlyType = (String)itr.next();
    String fmlyAmount = (String)itr.next();
    String fmlyPeriod = (String)itr.next();
    

    String prsnCounter = (String)itr.next();
    String prsnLoaner = (String)itr.next();
    String prsnAmount = (String)itr.next();
    String prsnDate = (String)itr.next();
    
    String tblId = (String)itr.next();
    String tblOprType = (String)itr.next();
    try
    {
      DataAccessObjectImpl cmp = new DataAccessObjectImpl();
      
      SrvyLoanPK objPk = new SrvyLoanPK(studId, termNo);
      SrvyLoan obj = new SrvyLoan(objPk);
      
      obj.setApplyLoan(applyLoan);
      obj.setApplyReason(applyReason);
      obj.setTakeLoan(takeLoan);
      obj.setLoanType(loanType);
      obj.setLoanPeriod(loanPeriod);
      if ((loanTermCount != null) && (!loanTermCount.trim().equals("")) && (FormCmp.isInteger(loanTermCount))) {
        obj.setLoanTermCount(new Integer(loanTermCount));
      }
      obj.setHasFamilyLoan(hasFamilyLoan);
      
      cmp.insertOrUpdate(obj);
      if ((takeLoan != null) && (!takeLoan.trim().equals("Y"))) {
        cmp.updateSqlQuery("  delete FROM SRVY_LOAN_PERSONAL  \n  where \n  stud_id='" + studId + "'\n" + "  and term_no='" + termNo + "'");
      }
      if ((hasFamilyLoan != null) && (!hasFamilyLoan.trim().equals("Y"))) {
        cmp.updateSqlQuery("  delete FROM SRVY_LOAN_FAMILY  \n  where \n  stud_id='" + studId + "'\n" + "  and term_no='" + termNo + "'");
      }
      if ((tblId != null) && (tblId.trim().equals("pLoan")))
      {
        SrvyLoanPersonalPK pLoanObjPk = new SrvyLoanPersonalPK(studId, termNo);
        SrvyLoanPersonal pLoanObj = new SrvyLoanPersonal(pLoanObjPk);
        
        pLoanObj.setPrsnLoaner(prsnLoaner);
        if ((prsnAmount != null) && (!prsnAmount.trim().equals("")) && (FormCmp.isDouble(prsnAmount))) {
          pLoanObj.setPrsnAmount(new Double(prsnAmount));
        }
        if ((prsnDate != null) && (!prsnDate.trim().equals(""))) {
          pLoanObj.setPrsnDate(DateTool.convertStringToDate_dd_mm_yyyy(prsnDate));
        }
        if ((tblOprType != null) && (tblOprType.equals("I")))
        {
          cmp.insert(pLoanObj);
        }
        else if ((tblOprType != null) && (tblOprType.equals("U")))
        {
          pLoanObj.setComp_id(new SrvyLoanPersonalPK(studId, termNo, new Integer(prsnCounter)));
          cmp.update(pLoanObj);
        }
        else if ((tblOprType != null) && (tblOprType.equals("D")))
        {
          pLoanObj.setComp_id(new SrvyLoanPersonalPK(studId, termNo, new Integer(prsnCounter)));
          cmp.delete(pLoanObj);
        }
      }
      else if ((tblId != null) && (tblId.trim().equals("fLoan")))
      {
        SrvyLoanFamilyPK fLoanObjPK = new SrvyLoanFamilyPK(studId, termNo);
        SrvyLoanFamily fLoanObj = new SrvyLoanFamily(fLoanObjPK);
        fLoanObj.setFmlyLoaner(fmlyLoaner);
        fLoanObj.setFmlyType(fmlyType);
        if ((fmlyAmount != null) && (!fmlyAmount.trim().equals("")) && (FormCmp.isDouble(fmlyAmount))) {
          fLoanObj.setFmlyAmount(new Double(fmlyAmount));
        }
        fLoanObj.setFmlyPeriod(fmlyPeriod);
        if ((tblOprType != null) && (tblOprType.equals("I")))
        {
          cmp.insert(fLoanObj);
        }
        else if ((tblOprType != null) && (tblOprType.equals("U")))
        {
          fLoanObj.setComp_id(new SrvyLoanFamilyPK(studId, termNo, new Integer(fmlyCounter)));
          cmp.update(fLoanObj);
        }
        else if ((tblOprType != null) && (tblOprType.equals("D")))
        {
          fLoanObj.setComp_id(new SrvyLoanFamilyPK(studId, termNo, new Integer(fmlyCounter)));
          cmp.delete(fLoanObj);
        }
      }
    }
    catch (Exception e)
    {
      logger.error("*** Error in " + getClass().getName() + ".execute has ComponentException detials :" + e.toString());
      System.err.println("*** Error in " + getClass().getName() + ".execute has ComponentException detials :" + e.toString());
      retList = new ArrayList();
      retList.add(e);
    }
    return retList;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.useCase.SaveStudSocialSrvLoanInfoUseCase
 * JD-Core Version:    0.7.0.1
 */