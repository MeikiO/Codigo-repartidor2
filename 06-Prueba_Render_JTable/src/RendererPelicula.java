import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class RendererPelicula implements ListCellRenderer<Pelicula> {

	@Override
	public Component getListCellRendererComponent(JList<? extends Pelicula> arg0, Pelicula object, int arg2, boolean arg3,
			boolean arg4) {
		object.setBorder(BorderFactory.createLineBorder(Color.red));
		return object;
	}

}
