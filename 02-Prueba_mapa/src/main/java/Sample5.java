


import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.event.MouseInputListener;

import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.VirtualEarthTileFactoryInfo;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCursor;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.TileFactory;
import org.jxmapviewer.viewer.TileFactoryInfo;

/**
 * This example demonstrate the use of different {@link TileFactory} elements.
 * @author Martin Steiger
 */
public class Sample5
{
    /**
     * @param args the program args (ignored)
     */
    public static void main(String[] args)
    {
       
        final JLabel labelThreadCount = new JLabel("Threads: ");

        
        
        
        // Display the viewer in a JFrame
        JFrame frame = new JFrame("JXMapviewer2 Example 5");
        frame.setLayout(new BorderLayout());
 
        
        
        
        frame.add(devolverMapa(),BorderLayout.CENTER);

        frame.add(labelThreadCount, BorderLayout.SOUTH);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


        Timer t = new Timer(500, new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Set<Thread> threads = Thread.getAllStackTraces().keySet();
                labelThreadCount.setText("Threads: " + threads.size());
            }
        });

        t.start();
    }

	private static Component devolverMapa() {
		// TODO Auto-generated method stub
		
	    final List<TileFactory> factories = new ArrayList<TileFactory>();

		
        TileFactoryInfo osmInfo = new OSMTileFactoryInfo();
        TileFactoryInfo veInfo = new VirtualEarthTileFactoryInfo(VirtualEarthTileFactoryInfo.MAP);
//        TileFactoryInfo googleInfo = new GoogleMapsTileFactoryInfo("<key>");

        factories.add(new DefaultTileFactory(osmInfo));
        factories.add(new DefaultTileFactory(veInfo));
//        factories.add(new DefaultTileFactory(googleInfo));

        // Setup JXMapViewer
        final JXMapViewer mapViewer = new JXMapViewer();
        final JLabel labelAttr = new JLabel();
        mapViewer.setLayout(new BorderLayout());
        mapViewer.add(labelAttr, BorderLayout.SOUTH);

        TileFactory firstFactory = factories.get(0);
        mapViewer.setTileFactory(firstFactory);
        labelAttr.setText(firstFactory.getInfo().getAttribution() + " - " + firstFactory.getInfo().getLicense());

        GeoPosition frankfurt = new GeoPosition(50.11, 8.68);

        // Set the focus
        mapViewer.setZoom(7);
        mapViewer.setAddressLocation(frankfurt);

        // Add interactions
        MouseInputListener mia = new PanMouseInputListener(mapViewer);
        mapViewer.addMouseListener(mia);
        mapViewer.addMouseMotionListener(mia);

        mapViewer.addMouseWheelListener(new ZoomMouseWheelListenerCursor(mapViewer));

        
		return mapViewer;
	}

    
    
    
}
