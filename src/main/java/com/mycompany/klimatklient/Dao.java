package com.mycompany.klimatklient;


import inlamningsuppgift.Dag;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class Dao {
    
       public List<Dag> getAllMeasuringpoints() throws ClassNotFoundException {
            Class.forName("com.mysql.jdbc.Driver"); 
            Scanner sc = new Scanner(System.in);
            Class.forName("com.mysql.jdbc.Driver");  
            List<Dag> allaDagar = new ArrayList<>();
        
       
        
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Inlamning", "marcus", "bergstrom");){

                PreparedStatement stmt = con.prepareStatement("SELECT * from klimat");
                ResultSet rs = stmt.executeQuery(); // Datat i tabellen i MySQL. Detta är jdbc anropet
           
                
        while (rs.next()){
            
            int id = rs.getInt("idklimat"); //Samla upp datat för i varje kolumn
            String tempS = rs.getString("Temperatur"); //namnet på kolumnen
            String belysningS = rs.getString("Belysning");
            String luftfuktighetS = rs.getString("Luftfuktighet");
            String elforbrukningS = rs.getString("Elförbrukning");
            Date datum = rs.getDate("Datum");
            
            int temp = Integer.parseInt(tempS);
            int belysning = Integer.parseInt(belysningS);
            int luftfuktighet = Integer.parseInt(luftfuktighetS);
            int elforbrukning = Integer.parseInt(elforbrukningS);
            
            
            
            //Skapa ett day.java objekt och lägg i lista
            Dag d = new Dag(elforbrukning, temp, belysning, luftfuktighet, datum); //stoppa in inlästa värden från databasen som inparametrar här
            allaDagar.add(d); //javaobjekt
        }
        
        }
        
        catch (Exception e){
            e.printStackTrace();
        }
             
      return allaDagar;
    }
    public List<Dag> getTemp(){
           
        List<Dag> tempLista = new ArrayList<>();
        Dag d1 = new Dag(1, "35");
        Dag d2 = new Dag(2, "40");
        Dag d3 = new Dag(3, "45");
        
        
        //skapa Dag på klienten
        //posta dagen till servern
        //servern anrpåar DAO
        //dao lägger in dagen i databasen genom att inserta en rad
        return tempLista;
    
        
    }
}
