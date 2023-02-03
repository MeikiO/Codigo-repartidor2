

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.DecimalFormat;

import com.google.gson.Gson;


//clase para pasar de direccion a coordenadas, usando el api de internet
//POSITIONSTACK

public class ConvertirDireccionACoordenadas {
	private static final String API_KEY = "d4bf4e0a72ab765688f0f7b5dcfef666";
    private static final String LLAMADA_WEB_API = "http://api.positionstack.com/v1/forward";

    public static void main(String[] args) throws IOException, InterruptedException {

    	
    	ConvertirDireccionACoordenadas programa=new ConvertirDireccionACoordenadas();
     	String direccion2="1600 Pennsylvania Ave NW, Washington DC";
     	String direccion=	"Biteri Hiribidea, 2, 2i";
     	String codigoPostalBuscado="20500";
     	
     	
     	CoordenadasToDMS coordenadaEspecificada=programa.realizarConsultaDeCoordenada(direccion,codigoPostalBuscado);
     	
     	
     	 
    }
    
    
    

	public CoordenadasToDMS realizarConsultaDeCoordenada(String direccion, String codigoPostalBuscado) throws IOException, InterruptedException {
   	
		//String resultado=this.cogerCoordenadasDeDireccion(direccion);
     	
     	String resultado="{\"data\":[{\"latitude\":43.323096,\"longitude\":-1.974683,\"type\":\"address\",\"name\":\"Biteri plaza 2\",\"number\":\"2\",\"postal_code\":\"20001\",\"street\":\"Biteri plaza\",\"confidence\":1,\"region\":\"Gipuzkoa\",\"region_code\":\"PV\",\"county\":null,\"locality\":\"San Sebastian\",\"administrative_area\":\"Donostia-San Sebasti\\u00e1n\",\"neighbourhood\":null,\"country\":\"Spain\",\"country_code\":\"ESP\",\"continent\":\"Europe\",\"label\":\"Biteri plaza 2, San Sebastian, PV, Spain\"},{\"latitude\":43.36236,\"longitude\":-1.79546,\"type\":\"address\",\"name\":\"Biteri Kalea 2\",\"number\":\"2\",\"postal_code\":\"20280\",\"street\":\"Biteri Kalea\",\"confidence\":1,\"region\":\"Gipuzkoa\",\"region_code\":\"PV\",\"county\":null,\"locality\":\"Portua\",\"administrative_area\":\"Hondarribia\",\"neighbourhood\":null,\"country\":\"Spain\",\"country_code\":\"ESP\",\"continent\":\"Europe\",\"label\":\"Biteri Kalea 2, Portua, PV, Spain\"},{\"latitude\":43.065404,\"longitude\":-2.488841,\"type\":\"address\",\"name\":\"Biteri Etorbidea 2\",\"number\":\"2\",\"postal_code\":\"20500\",\"street\":\"Biteri Etorbidea\",\"confidence\":1,\"region\":\"Gipuzkoa\",\"region_code\":\"PV\",\"county\":null,\"locality\":\"Mondrag\\u00f3n\",\"administrative_area\":\"Arrasate\\/Mondrag\\u00f3n\",\"neighbourhood\":null,\"country\":\"Spain\",\"country_code\":\"ESP\",\"continent\":\"Europe\",\"label\":\"Biteri Etorbidea 2, Mondrag\\u00f3n, PV, Spain\"},{\"latitude\":43.313249,\"longitude\":-1.898781,\"type\":\"address\",\"name\":\"Biteri kalea 2\",\"number\":\"2\",\"postal_code\":\"20100\",\"street\":\"Biteri kalea\",\"confidence\":1,\"region\":\"Gipuzkoa\",\"region_code\":\"PV\",\"county\":null,\"locality\":\"Errenteria\",\"administrative_area\":\"Errenteria\",\"neighbourhood\":null,\"country\":\"Spain\",\"country_code\":\"ESP\",\"continent\":\"Europe\",\"label\":\"Biteri kalea 2, Errenteria, PV, Spain\"},{\"latitude\":43.313381,\"longitude\":-1.901467,\"type\":\"address\",\"name\":\"Biteri kalea 23\",\"number\":\"23\",\"postal_code\":\"20100\",\"street\":\"Biteri kalea\",\"confidence\":1,\"region\":\"Gipuzkoa\",\"region_code\":\"PV\",\"county\":null,\"locality\":\"Errenteria\",\"administrative_area\":\"Errenteria\",\"neighbourhood\":null,\"country\":\"Spain\",\"country_code\":\"ESP\",\"continent\":\"Europe\",\"label\":\"Biteri kalea 23, Errenteria, PV, Spain\"},{\"latitude\":43.313718,\"longitude\":-1.901658,\"type\":\"address\",\"name\":\"Biteri kalea 28\",\"number\":\"28\",\"postal_code\":\"20100\",\"street\":\"Biteri kalea\",\"confidence\":1,\"region\":\"Gipuzkoa\",\"region_code\":\"PV\",\"county\":null,\"locality\":\"Errenteria\",\"administrative_area\":\"Errenteria\",\"neighbourhood\":null,\"country\":\"Spain\",\"country_code\":\"ESP\",\"continent\":\"Europe\",\"label\":\"Biteri kalea 28, Errenteria, PV, Spain\"},{\"latitude\":43.362609,\"longitude\":-1.797762,\"type\":\"address\",\"name\":\"Biteri Kalea 24\",\"number\":\"24\",\"postal_code\":\"20280\",\"street\":\"Biteri Kalea\",\"confidence\":1,\"region\":\"Gipuzkoa\",\"region_code\":\"PV\",\"county\":null,\"locality\":\"Hondarribia\",\"administrative_area\":\"Hondarribia\",\"neighbourhood\":null,\"country\":\"Spain\",\"country_code\":\"ESP\",\"continent\":\"Europe\",\"label\":\"Biteri Kalea 24, Hondarribia, PV, Spain\"},{\"latitude\":43.362503,\"longitude\":-1.797342,\"type\":\"address\",\"name\":\"Biteri Kalea 22\",\"number\":\"22\",\"postal_code\":\"20280\",\"street\":\"Biteri Kalea\",\"confidence\":1,\"region\":\"Gipuzkoa\",\"region_code\":\"PV\",\"county\":null,\"locality\":\"Hondarribia\",\"administrative_area\":\"Hondarribia\",\"neighbourhood\":null,\"country\":\"Spain\",\"country_code\":\"ESP\",\"continent\":\"Europe\",\"label\":\"Biteri Kalea 22, Hondarribia, PV, Spain\"},{\"latitude\":43.313368,\"longitude\":-1.900914,\"type\":\"address\",\"name\":\"Biteri kalea 20\",\"number\":\"20\",\"postal_code\":\"20100\",\"street\":\"Biteri kalea\",\"confidence\":1,\"region\":\"Gipuzkoa\",\"region_code\":\"PV\",\"county\":null,\"locality\":\"Errenteria\",\"administrative_area\":\"Errenteria\",\"neighbourhood\":null,\"country\":\"Spain\",\"country_code\":\"ESP\",\"continent\":\"Europe\",\"label\":\"Biteri kalea 20, Errenteria, PV, Spain\"},{\"latitude\":43.313653,\"longitude\":-1.901511,\"type\":\"address\",\"name\":\"Biteri kalea 26\",\"number\":\"26\",\"postal_code\":\"20100\",\"street\":\"Biteri kalea\",\"confidence\":1,\"region\":\"Gipuzkoa\",\"region_code\":\"PV\",\"county\":null,\"locality\":\"Errenteria\",\"administrative_area\":\"Errenteria\",\"neighbourhood\":null,\"country\":\"Spain\",\"country_code\":\"ESP\",\"continent\":\"Europe\",\"label\":\"Biteri kalea 26, Errenteria, PV, Spain\"}]}\r\n";
     	

     	 	
     	CoordenadasToDMS conversor=this.cogerCoordenadaDeResultadoWeb(codigoPostalBuscado,resultado);
     	
     
     	 System.out.println("latitud: "+ conversor.getLatitudDMS().toString()+" longitud: "+conversor.getLongitudDMS().toString());
     	 
		return conversor;
	}




	private String cogerCoordenadasDeDireccion(String direccion) throws IOException, InterruptedException {

     	
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
    
	
    private CoordenadasToDMS cogerCoordenadaDeResultadoWeb(String codigoPostalBuscado, String resultado) {
      	Gson gson = new Gson();
    	ObjetosJSon todosLosDatos = gson.fromJson(resultado, ObjetosJSon.class); //pasamos el JSon a objeto
      	double latitudBuscada=0;
     	double longitudBuscada=0;
		
     	 for(RespuestaAPI actual: todosLosDatos.getListaCoordenadas()) {
     		 if(actual.getPostal_code()==Integer.valueOf(codigoPostalBuscado)) {
     			 latitudBuscada=actual.getLatitude();
     			 longitudBuscada=actual.getLongitude();
     			 System.out.println(actual.toString());
     		 }
     	 }
     	
     	 
     	 CoordenadasToDMS conversor=new CoordenadasToDMS(latitudBuscada,longitudBuscada);
     	 return conversor;
	}
	
}