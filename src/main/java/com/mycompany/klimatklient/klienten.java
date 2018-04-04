package com.mycompany.klimatklient;

import com.google.gson.Gson;
import inlamningsuppgift.Dag;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
//import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import java.io.IOException;
import java.util.Scanner;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;



public class klienten {
    private static ClientConfig config = new DefaultClientConfig();
    private static Client client = Client.create(config);
    private static WebResource service = client.resource(UriBuilder.fromUri("http://localhost:8080/Inlamning").build());
    
    
    
    
    public static void main(String []args) throws IOException {
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        String jsonString = service.path("rest").path("climateservice/data").accept(MediaType.APPLICATION_JSON).get(String.class);
       
        Gson gson = new Gson();
        Dag[] dagLista = gson.fromJson(jsonString, Dag[].class);
        System.out.println(jsonString);
        System.out.println();
        //Hämtar all JsonData
        
        //Dag[] dagLista = service.path("rest").path("/climateservice/data").accept(MediaType.APPLICATION_JSON).get(Dag[].class);
        for (Dag b : dagLista){
            System.out.println("Temp " + b.getTemp() + "Luftfuktighet" + b.getLuftfuktighet() + "Belysning " + b.getBelysning() );
        }
        Scanner sc = new Scanner(System.in);
        
        while(true) {
            System.out.println("1. Läsa av just nu "); //Gå till ny meny
            System.out.println("2. Läsa av elförbrukning senaste dygnet ");
            System.out.println("3. Sätta nytt värde på temperatur ");
            System.out.println("4. Sätta nytt värde luftfuktigheten ");
            System.out.println("5. Sätta nytt värde belysning");
            
            int i = sc.nextInt();
        switch (i){
            case 1: 
                
                //Dag[] dagar = service.path("rest/climateservice/data").accept(MediaType.APPLICATION_JSON).get(Dag[].class);
                String jsonString1 = service.path("rest").path("climateservice/data").accept(MediaType.APPLICATION_JSON).get(String.class);
       
                Dag[] dagar = gson.fromJson(jsonString1, Dag[].class);
                int antalDagar = dagar.length;
                
                System.out.println("1. Temperatur");
                System.out.println("2. Luftfuktighet");
                System.out.println("3. Belysning");
                i = sc.nextInt();
                if(i == 1){
                    System.out.println(dagar[antalDagar-1].getTemp());
                }
                else if(i == 2){
                        System.out.println(dagar[antalDagar-1].getLuftfuktighet());
                }
                else if(i == 3){
                        System.out.println(dagar[antalDagar-1].getBelysning());
                }
                    
                else  {
                    System.out.println("Fel siffra! ");
                }
                
                break;
            case 2:
                //skriv av case 1
                Dag[] totEl = service.path("rest/climateservice/data").accept(MediaType.APPLICATION_JSON).get(Dag[].class);
                int dygnsEl =  totEl.length; //likadan som case 1
                System.out.println(totEl[dygnsEl-1].getElforbrukning());
        
                
        break;
            case 3:
                System.out.println("Vilket värde vill du sätta? ");
                int temp = sc.nextInt();
                //POST för att skicka iväg info
                Dag d = new Dag(0,temp, 0, 0, null);
                ClientResponse response = service.path("rest/climateservice/data/add").accept(MediaType.APPLICATION_JSON).post(ClientResponse.class, d);
                
                
            case 4:
                System.out.println("Vilket värde vill du sätta? ");
                int luft = sc.nextInt();
                //POST för att skicka iväg info
                Dag e = new Dag(0,0, 0, luft, null);
                ClientResponse response4 = service.path("rest/climateservice/data/add").accept(MediaType.APPLICATION_JSON).post(ClientResponse.class, e);
            break;   
            case 5:
                 System.out.println("Vilket värde vill du sätta? ");
                int belys = sc.nextInt();
                //POST för att skicka iväg info
                Dag f = new Dag(0,0, belys, 0, null);
                ClientResponse response5 = service.path("rest/climateservice/data/add").accept(MediaType.APPLICATION_JSON).post(ClientResponse.class, f);
            
                break;
        }
        
        }
    }
}
