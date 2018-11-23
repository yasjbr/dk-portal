package ps.edu.diyar.studentInfo.useCase;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import ps.edu.diyar.common.component.DataAccessObjectImpl;
import ps.edu.diyar.common.useCase.ComponentUseCase;
import ps.edu.diyar.login.usecase.LoginUseCase;

/**
 *
 * @author Yaseen Jaber
 */
public class GetNotificationsUseCase
        implements ComponentUseCase {

    private static Logger logger = Logger.getLogger(GetNotificationsUseCase.class);

    public Collection execute(Collection input, HttpServletRequest request)
            throws HibernateException {
        List retList = null;

        Iterator iter = input.iterator();
        String userId = (String) iter.next();
        try {
            DataAccessObjectImpl cmp = new DataAccessObjectImpl();
            retList = cmp.getList("msg.getNotifications");
          //    retList = cmp.getList("msg.getNotifications", new Object[]{userId});
        } catch (Exception e) {
            logger.error("*** GetNotificationsUseCase.execute has ComponentException detials :" + e.toString());
            System.err.println("*** GetNotificationsUseCase.execute has ComponentException detials :" + e.toString());
        }
        return retList;
    }

}
