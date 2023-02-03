/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 *
 * @author flarrinaga
 */
public class JSON2Object {

    public static void main(String[] args) {

        Gson gson = new Gson();
        Presidentes presi;
        
        
        try (Reader reader = new FileReader("C:\\Users\\Lenovo\\Desktop\\3.maila 2seilabetea\\Web II\\Ejercicios\\08-JSON y JSON Schema\\005-PresidentesGSON\\src\\main\\java\\01-Tabla de presidentes.json")) {

			// Convert JSON to Java Object
            presi = gson.fromJson(reader, Presidentes.class);
            System.out.println("El nombre es:" + presi.getNombre());
            System.out.println("El estado natal es:" + presi.getEstado_natal());
            System.out.println("El partido es:" + presi.getPartido());
            System.out.print("El mandato es:" );
            for(NestedObject valor: presi.getMandato()) {
            	System.out.println("\n"+valor.toString());
            }
    
			// Convert JSON to JsonElement, and later to String
            /*JsonElement json = gson.fromJson(reader, JsonElement.class);
            String jsonInString = gson.toJson(json);
            System.out.println(jsonInString);*/

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}


 