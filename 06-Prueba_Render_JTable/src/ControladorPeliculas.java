import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ControladorPeliculas {

	Vista vista;
	String fichero;
	List<Pelicula>lista;
	public ControladorPeliculas(String fichero, Vista vista) {
		this.fichero=fichero;
		this.vista=vista;
		this.lista=new ArrayList<>();
		this.leerClaseDeFichero();
	}
	private void leerClaseDeFichero() {
		String linea = null;
		lista = new ArrayList<>();
		Pelicula pelicula = null;
		
		
		try (BufferedReader in = new BufferedReader(new FileReader(this.fichero))) {
			while((linea = in.readLine())!=null){
				pelicula = leerPelicula(linea);
				if (pelicula!=null){
					lista.add(pelicula);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	private Pelicula leerPelicula(String linea) {
		String [] palabras = linea.split("[$]");
		Pelicula pelicula = new Pelicula (palabras[0],palabras[1],Integer.parseInt(palabras[2]),palabras[3],palabras[4],palabras[5]);
		return pelicula;
	} 
	public Vista getVista() {
		return vista;
	}
	public List<Pelicula> getLista() {
		return lista;
	}

}
