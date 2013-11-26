/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmos.MedidasSimilitud;

import Algoritmos.Modelo.Pelicula;
import Algoritmos.Modelo.Usuario;
import Algoritmos.Modelo.Valoracion;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author grupo 12
 */
public class Pearson implements MedidaSimilitud {
    
    Map<Pelicula, Valoracion> usuarioPeliculasU; // Lista de todas las valoraciones que un usuario U que ha hecho a las peliculas
    Map<Pelicula, Valoracion> usuarioPeliculasI; // Lista de todas las valoraciones que un usuario I que ha hecho a las peliculas
    List<Valoracion> valoraciones; // Lista de valoraciones totales

    public Pearson(List<Valoracion> valoraciones) {
        this.usuarioPeliculasU = new HashMap<>();
        this.usuarioPeliculasI = new HashMap<>();
        this.valoraciones = new LinkedList<>(valoraciones);
    }
        
    
    private void peliculasComunes() throws Exception{
        
        for (Valoracion v1:usuarioPeliculasI.values()){// Por ahorranos un buble quiza no se pueda borrar la valoracion en usarioPeliculasI
            if (!usuarioPeliculasU.containsKey(v1.getPelicula()))
                usuarioPeliculasI.remove(v1);
        }
        for (Valoracion v1:usuarioPeliculasU.values()){// Por ahorranos un buble quiza no se pueda borrar la valoracion en usarioPeliculasI
            if (!usuarioPeliculasI.containsKey(v1.getPelicula()))
                usuarioPeliculasU.remove(v1);
        }
        
        if (usuarioPeliculasI.size() != usuarioPeliculasU.size()){
            throw new Exception();
        }
    }
    
    private float mediaUsuario(List<Valoracion> usuarioPeliculas){
        
        float media = 0;
        
        for(Valoracion v:usuarioPeliculas){
            media += v.getPuntuacion();
        }  
        
        return media/usuarioPeliculas.size();
        
    }
    
    
    @Override
    public float similitud(Pelicula p1, Pelicula p2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    @Override
    public float similitud(Usuario u1, Usuario u2) {
        float num = 0, den = 0;
        
        for(Valoracion v:valoraciones){
           if(v.getUsuario() == u1){ // Quiza tengamos problemas con comparar directamente objetos Usuario
               this.usuarioPeliculasU.put(v.getPelicula(),v);
           }
           if(v.getUsuario() == u2){ // Quiza tengamos problemas con comparar directamente objetos Usuario
               this.usuarioPeliculasU.put(v.getPelicula(),v);
           }           
        }
        
        float mediaU = mediaUsuario((List)usuarioPeliculasU.values()), mediaI = mediaUsuario((List)usuarioPeliculasI.values());
        
        try {
            peliculasComunes();
            
            for(Valoracion v:usuarioPeliculasU.values()){
                num += (v.getPuntuacion() - mediaU) * (usuarioPeliculasI.get(v.getPelicula()).getPuntuacion() - mediaI);
            }
            float factor1 = 0, factor2 = 0;
            for(Valoracion v:usuarioPeliculasU.values()){
                factor1 += Math.pow((v.getPuntuacion() - mediaU), 2);
            }
            for(Valoracion v:usuarioPeliculasI.values()){
                factor2 += Math.pow((v.getPuntuacion() - mediaI), 2);
            }
            
            den += factor1 * factor2;
        } catch (Exception ex) {
            System.out.println("Las peliculas comunes no tienen el mismo tamaño");
        }
         
        //Medida de similitud transformada
        return (num / (float)Math.sqrt(den) + 1 ) / 2;
    }
    
}
