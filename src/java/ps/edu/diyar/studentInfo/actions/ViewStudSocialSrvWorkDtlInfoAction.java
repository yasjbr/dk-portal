package ps.edu.diyar.studentInfo.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import ps.edu.diyar.common.tools.SessionTraker;
import ps.edu.diyar.studentInfo.database.SrvyWorkDetail;
import ps.edu.diyar.studentInfo.database.SrvyWorkDetailPK;
import ps.edu.diyar.studentInfo.database.SrvyWorkTypeDtl;
import ps.edu.diyar.studentInfo.database.SrvyWorkTypeDtlPK;
import ps.edu.diyar.studentInfo.database.struct.StudentInfoHolder;
import ps.edu.diyar.studentInfo.forms.SrvyWorkDetailForm;
import ps.edu.diyar.studentInfo.useCase.GetStudSocialSrvWorkDtlInfoUseCase;
import ps.edu.diyar.studentInfo.useCase.GetStudSocialSrvWorkTypeDtlUseCase;

public class ViewStudSocialSrvWorkDtlInfoAction
  extends Action
{
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    if (!SessionTraker.isSessionExist(request)) {
      return mapping.findForward("invalidAccess");
    }
    SrvyWorkDetailForm inForm = (SrvyWorkDetailForm)form;
    
    StudentInfoHolder studInfo = (StudentInfoHolder)((List)request.getSession().getAttribute("studentInfo")).get(0);
    

    String workerType = request.getParameter("workerType");
    
    ArrayList inpt = new ArrayList();
    inpt.add(studInfo.getStudentId());
    inpt.add(studInfo.getSystemCurrentTermNo());
    inpt.add(workerType);
    Collection retList = new GetStudSocialSrvWorkDtlInfoUseCase().execute(inpt, request);
    if ((retList != null) && (retList.size() > 0))
    {
      SrvyWorkDetail wrkDtl = (SrvyWorkDetail)retList.iterator().next();
      
      inForm.setEditOpperation(true);
      
      inForm.setWorkerType(wrkDtl.getComp_id().getWorkerType());
      inForm.setIsWork(wrkDtl.getIsWork());
      inForm.setWrkSector(wrkDtl.getWrkSector());
      inForm.setWrkOther(wrkDtl.getWrkOther());
      inForm.setWrkCompany(wrkDtl.getWrkCompany());
      inForm.setWrkJob(wrkDtl.getWrkJob());
      inForm.setWrkAddress(wrkDtl.getWrkAddress());
      inForm.setWrkPhone(wrkDtl.getWrkPhone());
      if (wrkDtl.getWrkSalary() != null) {
        inForm.setWrkSalary(wrkDtl.getWrkSalary().intValue() + "");
      }
      inForm.setWrkReason(wrkDtl.getWrkReason());
      
      Collection resultList = new GetStudSocialSrvWorkTypeDtlUseCase().execute(inpt, request);
      if ((resultList != null) && (resultList.size() > 0))
      {
        Iterator itr = resultList.iterator();
        while (itr.hasNext())
        {
          String type = ((SrvyWorkTypeDtl)itr.next()).getComp_id().getTypeCode();
          if ("ft,pt".contains(type)) {
            inForm.setWrkType2(type);
          } else {
            inForm.setWrkType1(type);
          }
        }
      }
    }
    String falg = "";
    if ((workerType != null) && (workerType.trim().equals("fath"))) {
      falg = "P2";
    } else if ((workerType != null) && (workerType.trim().equals("moth"))) {
      falg = "P3";
    } else if ((workerType != null) && (workerType.trim().equals("wife"))) {
      falg = "P4";
    }
    return mapping.findForward("success" + falg);
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.studentInfo.actions.ViewStudSocialSrvWorkDtlInfoAction
 * JD-Core Version:    0.7.0.1
 */