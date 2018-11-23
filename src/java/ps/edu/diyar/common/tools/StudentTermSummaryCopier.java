package ps.edu.diyar.common.tools;

import ps.edu.diyar.studentInfo.database.RegStudStatus;
import ps.edu.diyar.studentInfo.database.RegTermSummary;
import ps.edu.diyar.studentInfo.database.RegWarn;
import ps.edu.diyar.studentInfo.database.struct.StudentInfoHolder;

public class StudentTermSummaryCopier
{
  public static StudentInfoHolder copyValues(RegTermSummary termSummary, StudentInfoHolder studentInfo)
  {
    studentInfo.setLevelNo(termSummary.getLevelNo());
    if (termSummary.getStudStatus() != null) {
      studentInfo.setStudStatusName(termSummary.getStudentStatus().getStatusAName());
    } else {
      studentInfo.setStudStatusName("NA");
    }
    studentInfo.setCumHTran(String.valueOf(termSummary.getCumHrsTrans()));
    studentInfo.setCumHPassed(String.valueOf(termSummary.getCumHrsPassed()));
    studentInfo.setGraduateStatus(termSummary.getGraduateStatus());
    
    studentInfo.setCumAvg(String.valueOf(termSummary.getCumAvg()));
    if (termSummary.getWarning() != null) {
      studentInfo.setWarningName(termSummary.getWarning().getWarnAName());
    } else {
      studentInfo.setWarningName("NA");
    }
    return studentInfo;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.common.tools.StudentTermSummaryCopier
 * JD-Core Version:    0.7.0.1
 */