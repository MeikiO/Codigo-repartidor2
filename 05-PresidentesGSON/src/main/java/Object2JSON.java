/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author flarrinaga
 */
public class Object2JSON {
  
    public static void main(String[] args) {

    	Object2JSON programa=new Object2JSON();
    	
        Staff staff = programa.createDummyStaff();
        Presidentes presi=programa.createDummyPresi();
        
        //1. Convert object to JSON string
        Gson gson = new Gson();
        String json = gson.toJson(staff);
        String json2=gson.toJson(presi);
        System.out.println(json);
        System.out.println(json2);

        //2. Convert object to JSON string and save into a file directly
        try (FileWriter writer = new FileWriter("C:\\Users\\Lenovo\\Desktop\\3.maila 2seilabetea\\Web II\\Ejercicios\\08-JSON y JSON Schema\\005-PresidentesGSON\\src\\main\\java\\prueba.json")) {

            //gson.toJson(staff, writer); //empleados
            gson.toJson(presi,writer);  //presidentes
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    private static Staff createDummyStaff() {

        Staff staff = new Staff();
        staff.setName("Felix");
        staff.setAge(35);
        staff.setPosition("Lecturer");
        staff.setSalary(new BigDecimal("10000"));
        List<String> skills = new ArrayList<>();
        skills.add("java");
        skills.add("python");
        skills.add("shell");
        staff.setSkills(skills);
        return staff;

    }

    private static Presidentes createDummyPresi() {

    	List<NestedObject> mandatos=new ArrayList<>();
    	
    	for(int i=0;i<2;i++) {
    		NestedObject man=new NestedObject(1,"30 de abril de 1789",
    				"4 de marzo de 1793","JonAdams");
    		
    		mandatos.add(man);
    	}
    	
    	Presidentes presiDummy=new Presidentes("GEorge Washington",
    			"Virginia","Independiente",mandatos);
    	

        return presiDummy;

    }
    
}

    
