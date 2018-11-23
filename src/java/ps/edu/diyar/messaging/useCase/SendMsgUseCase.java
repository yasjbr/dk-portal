package ps.edu.diyar.messaging.useCase;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.apache.struts.upload.FormFile;
import org.hibernate.HibernateException;
import ps.edu.diyar.common.tools.Randomizer;
import ps.edu.diyar.common.useCase.ComponentUseCase;
import ps.edu.diyar.messaging.component.MessageComponent;

public class SendMsgUseCase
        implements ComponentUseCase {

    private static Logger logger = Logger.getLogger(SendMsgUseCase.class);

    public Collection execute(Collection input, HttpServletRequest request)
            throws HibernateException {
        List retList = null;

        Iterator iter = input.iterator();

        String subject = (String) iter.next();
        String messageBody = (String) iter.next();
        String recieverId = (String) iter.next();
        String senderId = (String) iter.next();
        String servirity = (String) iter.next();
        FormFile file = (FormFile) iter.next();
        String termNo = (String) iter.next();
        String extraInfo = (String) iter.next();
        String crsNo = (String) iter.next();
        String crsClass = (String) iter.next();
        String remoteIp = (String) iter.next();
        String deleted = (String) iter.next();
        String deleteDate = (String) iter.next();
        try {
            MessageComponent messageAttachmentComponent = new MessageComponent();
            String seed = Randomizer.RandomPassword();
            String hasAttachment = "N";
            try {
                if (file.getFileSize() > 0) {
                    hasAttachment = "Y";
                } else {
                    hasAttachment = "N";
                }
            } catch (Exception e) {
                hasAttachment = "N";
            }
            Long msgId = messageAttachmentComponent.saveMessage(messageBody, subject, hasAttachment, seed, servirity, senderId, termNo, crsNo, crsClass, extraInfo, remoteIp, deleted, deleteDate);

            messageAttachmentComponent.saveFile(file, String.valueOf(msgId), seed);

            messageAttachmentComponent.saveMessageRecipient(msgId, recieverId);
        } catch (Exception e) {
            logger.error("*** SendMsgUseCase.execute has ComponentException detials :" + e.toString());
            System.err.println("*** SendMsgUseCase.execute has ComponentException detials :" + e.toString());
            retList = new ArrayList();
            retList.add(e);
        }
        return retList;
    }
}
