import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class GruposPBL extends JFrame implements WindowListener {

	JMenuBar barra;
	JMenu	menuFile, menuEdit, menuSalir;
	JMenuItem opcionMenu;
	JMenu subMenu;
	JList<Alumno> listaAlumnos;
	List<Alumno> listAlumnos;
	Alumno alumnoSeleccionado;
	Modelo modelo;
	final int NUM_GRUPOS=6;
	List<Grupo> listaGrupos;
	JPanel panel;
	
	public GruposPBL(){
		super ("Definicion grupos PBL");
		
		
		this.modelo=new Modelo();
		this.listAlumnos=new ArrayList<>();
		listaAlumnos = new JList<>();	
		this.listaAlumnos.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		listaAlumnos.setModel(modelo);
		this.inicializar();
		this.setLocation(200,200);
		this.getContentPane().add(crearPanelCentral());
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addWindowListener(this);
	
	}
	

	private void inicializar() {

		try (ObjectInputStream out= new ObjectInputStream( new FileInputStream ("files/alumnos.dat"))){
			this.listAlumnos=(List<Alumno>) out.readObject();
			for(Alumno a:this.listAlumnos) {
				this.modelo.addElement(a);
			}
			
			
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.listaGrupos=new ArrayList<>();
		for(int i=0;i<this.NUM_GRUPOS;i++) {
			try (ObjectInputStream out= new ObjectInputStream( new FileInputStream ("files/grupo"+i+".dat"))){
				
				this.listaGrupos.add((Grupo) out.readObject());
				
				
			} catch (FileNotFoundException e) {
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}


	private Container crearPanelCentral() {
		JSplitPane panel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true,crearPanelIzquierda(),crearPanelDerecha());
		panel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		panel.setDividerLocation(150);
		return panel;
	}

	public Component crearPanelDerecha() {
		int x,y;
		x=NUM_GRUPOS/2;
		panel  = new JPanel(new GridLayout(x,x,5,5));
		panel.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
		
		for(Grupo g: this.listaGrupos) {
			panel.add(g);
			g.setVista(this);
		}
		return panel;
	}
	public JList<Alumno> getListaAlumnos() {
		return listaAlumnos;
	}


	public Modelo getModelo() {
		return modelo;
	}


	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}


	public Component crearPanelIzquierda() {
		JScrollPane panelSeleccion = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panelSeleccion.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder
				(BorderFactory.createLoweredBevelBorder(),"Lista Clase"),
				BorderFactory.createEmptyBorder(2,2,2,2)));
																							
		panelSeleccion.setOpaque(true);
		
		panelSeleccion.setViewportView(listaAlumnos);

		return panelSeleccion;
	}
	


		
		

	public static void main(String[] args) {
//		try {
//			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
//				| UnsupportedLookAndFeelException e) {
//			
//			e.printStackTrace();
//		}
		
		GruposPBL ejercicio = new GruposPBL();
		  
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		try (ObjectOutputStream out= new ObjectOutputStream( new FileOutputStream ("files/alumnos.dat"))){
			out.writeObject(this.listAlumnos);
			
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i=0;i<this.NUM_GRUPOS;i++) {
			try (ObjectOutputStream out= new ObjectOutputStream( new FileOutputStream ("files/grupo"+i+".dat"))){
				out.writeObject(this.listaGrupos.get(i));
				
			} catch (FileNotFoundException e) {
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}


	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}



}
