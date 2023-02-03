package z_mapas_coordenadas;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

public class ConvertirDireccionACoordenadas {
	private static final String API_KEY = "d4bf4e0a72ab765688f0f7b5dcfef666";
    private static final String LLAMADA_WEB_API = "http://api.positionstack.com/v1/forward";

    public static void main(String[] args) throws IOException, InterruptedException {

    	ConvertirDireccionACoordenadas programa=new ConvertirDireccionACoordenadas();
     	String direccion=	"Biteri Hiribidea, 2, 2i";
     	String codigoPostalBuscado="20500";
     	     	
     	Coordenadas coordenadaEspecificada=programa.realizarConsultaDeCoordenada(direccion,codigoPostalBuscado);

    }
    
	public Coordenadas realizarConsultaDeCoordenada(String direccion, String codigoPostalBuscado) throws IOException, InterruptedException {
		String resultado="";
     	Coordenadas conversor=null;
		
     	try {
     		resultado=this.cogerCoordenadasDeDireccion(direccion);
     		conversor=this.cogerCoordenadaDeResultadoWeb(codigoPostalBuscado,resultado);
     	}
     	catch(Exception ex) {
     		ex.printStackTrace();
     	}
     
		return conversor;
	}

	public String cogerCoordenadasDeDireccion(String direccion) throws IOException, InterruptedException {	
     	String direccionCodificada=this.codificarDireccion(direccion);
    	
    	System.out.println(direccionCodificada);
    		
    	String requestUri = LLAMADA_WEB_API + 
    			"?access_key=" + API_KEY + 
    			"&query=" + direccionCodificada;
    	
    	System.out.println(requestUri);
    		
        HttpClient client = HttpClient.newHttpClient(); 
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(requestUri))
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
        
        System.out.println("------------------------------------------");
              
        return response.body();   
	}

	public String codificarDireccion(String direccion) {
    	
    	String cadena=new String(direccion);
    	
    	cadena=cadena.replace(" ","%20");
    	
    	/*
    		Formato de direccion de la api positionstack
    		
    		+Lo unico que tenemos que hacer es sustituir todos los espacios
    		por %20
    		
    		String direccion="1600 Pennsylvania Ave NW, Washington DC";

			-> como tiene que quedar la direccion para la peticion (query)
			1600%20Pennsylvania%20Ave%20NW,%20Washington%20DC
			
			Ejemplo de peticion exitosa:
			
			http://api.positionstack.com/v1/forward
			?access_key=d4bf4e0a72ab765688f0f7b5dcfef666
			&query=1600%20Pennsylvania%20Ave%20NW,%20Washington%20DC
    
    	 */
    	
    	return cadena.toString();
    }
    
    public Coordenadas cogerCoordenadaDeResultadoWeb(String codigoPostalBuscado, String resultado) {
    	Gson gson = new Gson();
    	double latitudBuscada=0;
     	double longitudBuscada=0;
     	double confianza=0;
     
 		ObjetosJSon todosLosDatos = gson.fromJson(resultado, ObjetosJSon.class); //pasamos el JSon a objeto
    	
 		for(RespuestaAPI actual: todosLosDatos.getData()) {
     		 if(actual.getPostal_code()==Integer.valueOf(codigoPostalBuscado)) {
     			 latitudBuscada=actual.getLatitude();
     			 longitudBuscada=actual.getLongitude();
     		 }
     		 
     		 if(actual.getPostal_code()==0) {
     			 if(actual.getConfidence()>confianza) {
     				confianza=actual.getConfidence();
     				latitudBuscada=actual.getLatitude();
     	 			longitudBuscada=actual.getLongitude();
     			 }
     		 }
     	 }
     	
     	 Coordenadas conversor=new Coordenadas(latitudBuscada,longitudBuscada);
     	 return conversor;
	}
	
}