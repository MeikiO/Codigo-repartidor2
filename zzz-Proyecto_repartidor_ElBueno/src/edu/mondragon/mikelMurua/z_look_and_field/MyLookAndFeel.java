package z_look_and_field;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class MyLookAndFeel {
	
	private static String LAF="javax.swing.plaf.nimbus.NimbusLookAndFeel";
	
	public MyLookAndFeel(JFrame ventana) {
		try {
			UIManager.setLookAndFeel(LAF);
			SwingUtilities.updateComponentTreeUI(ventana);
		} 
		catch (Exception e) {
			System.out.println("Error setting the LAF..." + e);
	    }
	}	
	
}
