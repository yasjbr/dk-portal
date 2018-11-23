/*
 * Decompiled with CFR 0_102.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 *  org.apache.log4j.Logger
 *  org.apache.struts.upload.FormFile
 *  org.hibernate.HibernateException
 *  ps.edu.diyar.common.tools.Randomizer
 *  ps.edu.diyar.common.useCase.ComponentUseCase
 *  ps.edu.diyar.messaging.component.MessageComponent
 */
package ps.edu.diyar.messaging.useCase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.apache.struts.upload.FormFile;
import org.hibernate.HibernateException;
import ps.edu.diyar.common.tools.Randomizer;
import ps.edu.diyar.common.useCase.ComponentUseCase;
import ps.edu.diyar.messaging.component.MessageComponent;

public class SendTutorMessageUseCase
        implements ComponentUseCase {
    private static Logger logger = Logger.getLogger((Class)SendTutorMessageUseCase.class);

    public Collection execute(Collection input, HttpServletRequest request) throws HibernateException {
        ArrayList<String> retList = null;
        Vector messageVector = new Vector();
        Iterator iter = input.iterator();
        String subject = (String)iter.next();
        String msgBody = (String)iter.next();
        String[] recieverList = (String[])iter.next();
        String senderId = (String)iter.next();
        String servirity = (String)iter.next();
        FormFile file = (FormFile)iter.next();
        String termNo = (String)iter.next();
        String crsNo = (String)iter.next();
        String crsClass = (String)iter.next();
        String messageExtraInfo = (String)iter.next();
        String compIP = (String)iter.next();
         String deleted = (String)iter.next();
          String deleteDate = (String)iter.next();
          
        try {
            MessageComponent messageAttachmentComponent = new MessageComponent();
            String seed = Randomizer.RandomPassword();
            String hasAttachment = "N";
            try {
                hasAttachment = file.getFileSize() > 0 ? "Y" : "N";
            }
            catch (Exception e) {
                hasAttachment = "N";
            }
            Long msgId = messageAttachmentComponent.saveMessage(msgBody, subject, hasAttachment, seed, servirity, senderId, termNo, crsNo, crsClass, messageExtraInfo, compIP,deleted,deleteDate);
            messageAttachmentComponent.saveFile(file, String.valueOf(msgId), seed);
            for (int i = 0; i < recieverList.length; ++i) {
                try {
                    messageAttachmentComponent.saveMessageRecipient(msgId, recieverList[i]);
                    continue;
                }
                catch (Exception e) {
                    // empty catch block
                }
            }
        }
        catch (Exception ce) {
            logger.error((Object)("Error in Saving message and forums use case " + ce));
            ce.printStackTrace();
            retList = new ArrayList<String>();
            retList.add(ce.getMessage());
        }
        finally {
            return retList;
        }
    }
}