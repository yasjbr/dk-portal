package ps.edu.diyar.login.component;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import ps.edu.diyar.common.tools.Randomizer;

public class PasswordImageCreator
{
  public static BufferedImage createRandomImage(String imageText, String imageFontFile, Float imageFontSize, String imageBackgroundColor, String imageForgroundColor)
  {
    String text = Randomizer.RandomPassword();
    
    String fontFile = "";
    Float fontSize = Float.valueOf(20.0F);
    Color background = Color.white;
    Color color = Color.black;
    Font font = null;
    if ((imageText != null) && (!imageText.trim().equals(""))) {
      text = imageText;
    }
    if ((imageFontFile != null) && (!imageFontFile.trim().equals("")))
    {
      fontFile = imageFontFile;
      try
      {
        font = Font.createFont(0, new FileInputStream(fontFile));
        if (imageFontSize != null)
        {
          fontSize = imageFontSize;
          font = font.deriveFont(fontSize.floatValue());
        }
      }
      catch (FontFormatException e)
      {
        e.printStackTrace();
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
    if ((imageBackgroundColor != null) && (!imageBackgroundColor.trim().equals(""))) {
      background = new Color(Integer.parseInt(imageBackgroundColor, 16));
    }
    if ((imageForgroundColor != null) && (!imageForgroundColor.trim().equals(""))) {
      color = new Color(Integer.parseInt(imageForgroundColor, 16));
    }
    BufferedImage buffer = new BufferedImage(1, 1, 1);
    Graphics2D g2 = buffer.createGraphics();
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    FontRenderContext fc = g2.getFontRenderContext();
    Rectangle2D bounds = font.getStringBounds(text, fc);
    

    int width = (int)bounds.getWidth();
    int height = (int)bounds.getHeight();
    

    buffer = new BufferedImage(width, height, 1);
    g2 = buffer.createGraphics();
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g2.setFont(font);
    

    g2.setColor(background);
    g2.fillRect(0, 0, width, height);
    g2.setColor(color);
    g2.drawString(text, 0, (int)-bounds.getY());
    

    return buffer;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.login.component.PasswordImageCreator
 * JD-Core Version:    0.7.0.1
 */