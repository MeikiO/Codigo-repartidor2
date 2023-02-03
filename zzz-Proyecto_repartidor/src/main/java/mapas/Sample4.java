package mapas;

import java.awt.Color;
import java.awt.Component;
import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.event.MouseInputListener;

import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.VirtualEarthTileFactoryInfo;
import org.jxmapviewer.cache.FileBasedLocalCache;
import org.jxmapviewer.input.CenterMapListener;
import org.jxmapviewer.input.PanKeyListener;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCenter;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.TileFactoryInfo;
import org.jxmapviewer.viewer.WaypointPainter;



/**
 * A simple sample application that shows
 * a OSM map of Europe
 * @author Martin Steiger
 */
public class Sample4
{
    /**
     * @param args the program args (ignored)
     */
	
	public Recorrido recorrido;
	
    public static void main(String[] args)
    {
      
    	Sample4 sample=new Sample4();

        // Display the viewer in a JFrame
        JFrame frame = new JFrame("JXMapviewer2 Example 4");
        frame.getContentPane().add(sample.devolverMapa(sample.recorrido.getWaypoints()));
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


    
    public Sample4() {
		// TODO Auto-generated constructor stub
	
    	this.recorrido=new Recorrido(1);
    	

    }
    
    public Sample4(Recorrido recorrido) {
		// TODO Auto-generated constructor stub
	
    	this.recorrido=recorrido;
    	

    }
    
	public Sample4(SwingWaypoint punto) {
		// TODO Auto-generated constructor stub
		
		this.recorrido=new Recorrido();
		
		this.getRecorrido().getListaWaypoints().add(punto);
		
	}



	public Component devolverMapa(Set<SwingWaypoint> listaWaypoints) {
		// TODO Auto-generated method stub
		
	     // Create a TileFactoryInfo for OSM
        TileFactoryInfo info = new OSMTileFactoryInfo();
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
        tileFactory.setThreadPoolSize(8);
        
        // Setup local file cache
        File cacheDir = new File(System.getProperty("user.home") + File.separator + ".jxmapviewer2");
        tileFactory.setLocalCache(new FileBasedLocalCache(cacheDir, false));

        // Setup JXMapViewer
        JXMapViewer mapViewer = new JXMapViewer();
        mapViewer.setTileFactory(tileFactory);
        
        
        // Add interactions
        this.añadirInteraccionesMapa(mapViewer);

        
      
   
        for (SwingWaypoint w : listaWaypoints) {
            mapViewer.add(w.getButton());
        } 
        
        
        
        //renderering of the map points
        mapViewer.setOverlayPainter(this.getRecorrido().cargarREcorrido(listaWaypoints));
		
        
        // Set the focus of the map viewer (which location shows)
       this.getRecorrido().seMapInitialPosition(mapViewer);

        

		return  mapViewer;
	}

	
	
	private void añadirInteraccionesMapa(JXMapViewer mapViewer) {
		// TODO Auto-generated method stub
		
        // Add interactions
        MouseInputListener mia = new PanMouseInputListener(mapViewer);
        mapViewer.addMouseListener(mia);
        mapViewer.addMouseMotionListener(mia);
        mapViewer.addMouseListener(new CenterMapListener(mapViewer));
        mapViewer.addMouseWheelListener(new ZoomMouseWheelListenerCenter(mapViewer));
        mapViewer.addKeyListener(new PanKeyListener(mapViewer));
		
	}



	public Recorrido getRecorrido() {
		return recorrido;
	}



	public void setRecorrido(Recorrido recorrido) {
		this.recorrido = recorrido;
	}
	
	
}
