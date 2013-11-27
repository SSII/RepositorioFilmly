/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmos.AlgoritmosRecomendacion;

import Algoritmos.Modelo.Pelicula;
import Algoritmos.Modelo.Usuario;
import Algoritmos.Modelo.Valoracion;
import Algoritmos.persistencia.GestorPersistencia;
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
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author admin
 */
public class Algoritmo {

    public List<Map> puntuacionUsuarioPelicula; /*Lista de mapas que contienen un usuario y su puntuacion sobre las distintas peliculas*/
    public List<Pelicula> items; /*Lista de peliculas*/
    public List<Usuario> usuarios; /*Lista de usuarios*/
    private List<Valoracion> valoraciones;
    
    public Algoritmo(){
        GestorPersistencia.crearConexion();
        EntityManager em = GestorPersistencia.getInstancia().getEntityManager();
        
        puntuacionUsuarioPelicula = new LinkedList<>();
        items = new LinkedList<>();
        usuarios = new LinkedList();
        valoraciones = new LinkedList();
        
        Query q = em.createNativeQuery("select *  from peliculas", Pelicula.class);
        Query q2 = em.createNativeQuery("select * from usuarios", Usuario.class);
        Query q3 = em.createNativeQuery("select * from valoraciones", Valoracion.class);
        
        
        items = q.getResultList();      
        usuarios = q2.getResultList();
        valoraciones = q3.getResultList();
        
        
            
        Query buscaValoraciones = em.createNativeQuery("select * from valoraciones v where v.idPelicula = 1625 ", Valoracion.class);
            
        items.get(1624).setValoraciones(buscaValoraciones.getResultList());
            
         
        
        System.out.println("Tamaño peliculas: " + items.size());
        System.out.println("Tamaño usuarios: " + usuarios.size());
        System.out.println("Tamaño valoraciones: " + valoraciones.size());
    }
    
    /*public void cargarDatos(){
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
    }*/
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Algoritmo a = new Algoritmo();
        
       // a.cargarDatos();
   
    }
}
