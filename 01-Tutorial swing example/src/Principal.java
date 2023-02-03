
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;  

public class Principal extends JFrame implements ActionListener {

	
	final JTextField tf;
	JLabel l;
	Suma sum;
	
	
	public Principal() {
		// TODO Auto-generated constructor stub
		this.setTitle("ejemplo simple para ir calentando");
		
		sum=new Suma();
		
		
		
	    tf=new JTextField();  
	    tf.setBounds(50,50, 150,20);  
	    
        l=new JLabel();  
        l.setBounds(50,100, 250,20);     
        
		JButton b=new JButton("click");//creating instance of JButton   
		b=new JButton(new ImageIcon(".\\Resources\\ok_icon.png")); 
		b.setBounds(130,150,100, 40);//x axis, y axis, width, height  
		b.setActionCommand("hello");
		b.addActionListener(this); 
				
		JButton b2=new JButton("ip");//creating instance of JButton   
		b2.setBounds(130,200,100, 40);//x axis, y axis, width, height  
		b2.setActionCommand("ip");
		b2.addActionListener(this); 
		
		
		JButton b3=new JButton("+");//creating instance of JButton   
		b3.setBounds(100,250,40, 40);//x axis, y axis, width, height  
		b3.setActionCommand("suma");
		b3.addActionListener(this);
		
		JButton b4=new JButton("-");//creating instance of JButton   
		b4.setBounds(150,250,40, 40);//x axis, y axis, width, height  
		b4.setActionCommand("resta");
		b4.addActionListener(this);
		
		this.add(b);
		this.add(b2);
		this.add(b3);
		this.add(b4);
		this.add(tf);
		this.add(l);
	
		this.setSize(400,500);//400 width and 500 height  
		this.setLayout(null);//using no layout managers  
		this.setVisible(true);//making the frame visible  
	
	}

 	public void actionPerformed(ActionEvent e){  
    
 		String command= e.getActionCommand();
 	 
	 	 switch (command) {
			case "hello": {
				tf.setText("Welcome to Javatpoint.");   
				break;
			}
			case "ip": {	
			   try{  
			        String host=tf.getText();  
			        String ip=java.net.InetAddress.getByName(host).getHostAddress();  
			        l.setText("IP of "+host+" is: "+ip);  
			        }catch(Exception ex){System.out.println(ex);}  
	      
					break;
				}
			case "suma": {	
				   
				sum.sumar(1);
				
				tf.setText(sum.toString());
				
						break;
			}
			
			case "resta": {	
				   
				sum.resta(1);
				
				tf.setText(sum.toString());
				
						break;
			}
			
				default:
						break;
		 	}
 		
 	  
 	  
 		 
    }  


	
	
	public static void main(String[] args) {  
	    
		Principal p=new Principal();
	

		}







}  
