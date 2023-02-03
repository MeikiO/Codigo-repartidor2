import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel{

       private BufferedImage image;

       public ImagePanel(String imagen) {
          try {                
             image = ImageIO.read(new File(imagen));
          } catch (IOException ex) {
          }
       }

       @Override
       protected void paintComponent(Graphics g) {
           super.paintComponent(g);
           g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
       }

}
