/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmos.AlgoritmosRecomendacion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class Algoritmo {

    public List<Map> puntuacionUsuarioPelicula; /*Lista de mapas que contienen un usuario y su puntuacion sobre las distintas peliculas*/
    public List items; /*Lista de peliculas*/
    public List usuarios; /*Lista de usuarios*/
    
    public Algoritmo(){
        puntuacionUsuarioPelicula = new LinkedList<>();
        items = new LinkedList();
        usuarios = new LinkedList();
    }
    
    public void cargarDatos(){
        BufferedReader br = null;
        
        try{ 
            
            URL url = this.getClass().getClassLoader().getResource("algoritmos/pruebas/prueba1.txt");
            br = new BufferedReader(new InputStreamReader(url.openStream()));
            String linea;
            
            while ((linea = br.readLine()) != null) {
                
                Map mapaU = new HashMap();
                String[] partes = linea.split("/");
                
                for (int i = 0; i < partes.length; i = i + 2) {
                    
                    if (partes[i].equals("nota")) {
                        
                        mapaU.put(partes[i], Integer.parseInt(partes[i+1]));
                                          
                    }else{
           
                        mapaU.put(partes[i],partes[i+1]);
            
                    }
                    
                    if(partes[i].equals("pelicula")){
                    
                        if(!items.contains(partes[i+1])){
                            items.add(partes[i+1]);
                        }
                    }else{
                        
                        if(partes[i].equals("nombre")){
                            
                            if(!usuarios.contains(partes[i+1])){
                                usuarios.add(partes[i+1]);
                            }   
                        }
                    }
                }
                
                puntuacionUsuarioPelicula.add(mapaU);
                
            }
            
        
         } catch (IOException ex) {

            Logger.getLogger(Algoritmo.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        
         try {

               br.close();

         } catch (IOException ex) {
               Logger.getLogger(Algoritmo.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Algoritmo a = new Algoritmo();
        
        a.cargarDatos();
   
    }
}
