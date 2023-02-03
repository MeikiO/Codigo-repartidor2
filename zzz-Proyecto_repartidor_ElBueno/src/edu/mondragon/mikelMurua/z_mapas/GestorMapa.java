package z_mapas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.io.File;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.cache.FileBasedLocalCache;
import org.jxmapviewer.input.CenterMapListener;
import org.jxmapviewer.input.PanKeyListener;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCenter;
import org.jxmapviewer.painter.Painter;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.TileFactoryInfo;
import org.jxmapviewer.viewer.WaypointPainter;

import z_enumeraciones.DiasSemana;
import z_modelo_equipo_repartidores.Cliente;
import z_modelo_equipo_repartidores.Repartidor;



public class GestorMapa
{
	public Set<Cliente> listaWaypoints;
	private Repartidor repartidorActual;
	private JXMapViewer mapViewer;
	private String diaActual;
	
	private final static int threadNum=8;
	private final static int zoomInicial=20;

	private final static String pathNoClientImage="resources/images/download.jpg";
	
    public GestorMapa(Set<Cliente> listaPuntos, Repartidor repartidorActual, String string) {
    	this.diaActual=string;
    	this.listaWaypoints=listaPuntos;
    	this.repartidorActual=repartidorActual;
    }
    
	public Component devolverMapa() {
        TileFactoryInfo info = new OSMTileFactoryInfo();
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
        tileFactory.setThreadPoolSize(this.threadNum);
        
        File cacheDir = new File(System.getProperty("user.home") + File.separator + ".jxmapviewer2");
        tileFactory.setLocalCache(new FileBasedLocalCache(cacheDir, false));

        mapViewer = new JXMapViewer();
        mapViewer.setTileFactory(tileFactory);
        
        this.añadirInteraccionesMapa(mapViewer);

        for (Cliente w : listaWaypoints) {
        	if(w.getDiasCompletados().contains(this.diaActual)) {
        		w.getButton().setBackground(Color.GREEN);
        	}
        	else {
        		w.getButton().setBackground(w.getLista_productos().get(0).getColor());
        	}	
        	
        	w.setRepartidorResponsable(repartidorActual);
        	
        	w.setDiaActual(DiasSemana.getDiaDeAbreviacion(diaActual));
        	
            mapViewer.add(w.getButton());
        } 

        mapViewer.setOverlayPainter(this.cargarREcorrido());

        this.seMapInitialPosition(mapViewer);
        
		return  mapViewer;
	}

	public Painter<? super JXMapViewer> cargarREcorrido() {
        WaypointPainter<Cliente> swingWaypointPainter = new SwingWaypointOverlayPainter();   
        swingWaypointPainter.setWaypoints(this.listaWaypoints);
    
        return swingWaypointPainter;
	}

	public void seMapInitialPosition(JXMapViewer mapViewer) {
        mapViewer.setZoom(this.zoomInicial);
        if(!this.listaWaypoints.isEmpty()) {
        	mapViewer.setAddressLocation(this.listaWaypoints.iterator().next().getPosition());
        }
   }
	
	public void setPositionCliente(Cliente elegido) {
	     mapViewer.setZoom(this.zoomInicial);
	     if(elegido!=null) {
	     	mapViewer.setAddressLocation(elegido.getPosition());
	     }
	}
	
	private void añadirInteraccionesMapa(JXMapViewer mapViewer) {
        MouseInputListener mia = new PanMouseInputListener(mapViewer);
        mapViewer.addMouseListener(mia);
        mapViewer.addMouseMotionListener(mia);
        mapViewer.addMouseListener(new CenterMapListener(mapViewer));
        mapViewer.addMouseWheelListener(new ZoomMouseWheelListenerCenter(mapViewer));
        mapViewer.addKeyListener(new PanKeyListener(mapViewer));
	}

	public static JPanel visualizarNoHayDatos() {
		ImageIcon icon=new ImageIcon(pathNoClientImage);		

		JPanel panel=new MyPanel(icon.getImage()); 
		panel.setLayout(new BorderLayout());
		
		JLabel label=new JLabel("NO DATA");
		label.setFont(new Font("Arial", Font.BOLD,80 )); 
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setOpaque(false); 
		panel.add(label);
		
		return panel;
	}
	
	public Set<Cliente> getListaWaypoints() {
		return listaWaypoints;
	}


	public void setListaWaypoints(Set<Cliente> listaWaypoints) {
		this.listaWaypoints = listaWaypoints;
	}

}
