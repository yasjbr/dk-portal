package ps.edu.diyar.login.actions;

import java.io.OutputStream;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import ps.edu.diyar.common.tools.Randomizer;
import ps.edu.diyar.login.component.PasswordImageCreator;

public class CaptchaImageAction
  extends Action
{
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    try
    {
      response.setContentType("image/png");
      OutputStream os = response.getOutputStream();
      String text = Randomizer.shortRandom(new Integer(4));
      request.getSession().setAttribute("passwordImageData", text);
      
      ImageIO.write(PasswordImageCreator.createRandomImage(text.toLowerCase(), request.getRealPath("ARIAL.TTF"), new Float(20.0F), "FDF7D7", "FF0000"), "png", os);
      os.close();
    }
    catch (IllegalStateException e) {}catch (Exception ee) {}catch (Throwable eee) {}
    return null;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.login.actions.CaptchaImageAction
 * JD-Core Version:    0.7.0.1
 */