/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmos.AlgoritmosRecomendacion;

import Algoritmos.MedidasSimilitud.MedidaSimilitud;
import Algoritmos.Modelo.*;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author grupo12
 */
public class ItemAverageAdjustment implements AlgoritmoRecomendacion {
    
    List<Valoracion> usuarioPeliculas;
    List<Valoracion> peliculaUsuarios;
    MedidaSimilitud medida;
    Usuario usuario;
    Pelicula pelicula;
    float similitud;
    int n;

    public ItemAverageAdjustment(int n, List<Valoracion> valoraciones, float similitud, Usuario usuario, Pelicula pelicula, MedidaSimilitud medida) {

        this.similitud = similitud;
        this.usuario = usuario;
        this.pelicula = pelicula;
        this.peliculaUsuarios = new LinkedList<>();
        this.usuarioPeliculas = new LinkedList<>();
        this.medida = medida;
        
        for(Valoracion v:valoraciones){
            if(v.getUsuario()==this.usuario){
                this.usuarioPeliculas.add(v);
            }
            if(v.getPelicula()==this.pelicula){
                this.peliculaUsuarios.add(v);
            }
        }
        if (n == -1){
            this.n = n;
        }else{
            this.n = this.usuarioPeliculas.size();
        }        
        
    }
    
    private float mediaUsuario(Usuario u){
        
        float media = 0;
        
        for(int i=0; i<n; ++i){
            media += usuarioPeliculas.get(i).getPuntuacion();
        }  
        
        return media/n;
        
    }
    
    private float mediaPelicula(Pelicula p){
        
        float media = 0;
        
        for(Valoracion v:peliculaUsuarios){
            media += v.getPuntuacion();
        }  
        
        return media/peliculaUsuarios.size();
        
    }
    
    private float correlacion(Usuario u){
        
        float media = mediaUsuario(u);
        int acum = 0;
        
        for(int i=0; i<n; ++i){
            acum += (medida.similitud(pelicula, usuarioPeliculas.get(i).getPelicula()))*
                    (usuarioPeliculas.get(i).getPuntuacion() - media);
       }
        
        return acum;
        
    }
    
    

    @Override
    public float prediccion() {
        
       float acum = 0;
       
       for(int i=0; i<n; ++i){ 
           acum += Math.abs(medida.similitud(pelicula, usuarioPeliculas.get(i).getPelicula()));
       }
           
       return correlacion(usuario)/acum + mediaPelicula(pelicula);
        
    }
}
