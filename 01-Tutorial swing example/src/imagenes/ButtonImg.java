package imagenes;

import javax.swing.*;    

public class ButtonImg 
{
  ButtonImg()
  {
    JFrame f = new JFrame("Add Image Icon to JButton");          
    Icon icon = new ImageIcon(".\\resources\\icons\\edit_add.png");
    JButton btn = new JButton(icon);
    btn.setBounds(40,80,200,50);  
    f.add(btn);  
    f.setSize(300,250);  
    f.setLayout(null);  
    f.setVisible(true);  
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
  }
  public static void main(String[] args) {  
    new ButtonImg();  
  }
}