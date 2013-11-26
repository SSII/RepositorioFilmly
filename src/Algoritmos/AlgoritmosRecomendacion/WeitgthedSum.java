/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmos.AlgoritmosRecomendacion;

import Algoritmos.MedidasSimilitud.MedidaSimilitud;
import Algoritmos.Modelo.Pelicula;
import Algoritmos.Modelo.Usuario;
import Algoritmos.Modelo.Valoracion;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author grupo 12
 */
public class WeitgthedSum implements AlgoritmoRecomendacion {
    
    List<Valoracion> usuarioPeliculas; // Lista de todas las valoraciones que un usuario que ha hecho a las peliculas
    List<Valoracion> peliculaUsuarios; // Lista de valoraciones que se han hecho sobre una película
    MedidaSimilitud medida; // Objeto medida de similitud (Coseno o Pearson)
    Usuario usuario; // Usuario actual
    Pelicula pelicula; // Película actual
    boolean ws; // Tipo de algoritmo; true WS, false WA

    public WeitgthedSum(boolean ws, List<Valoracion> valoraciones, float similitud, Usuario usuario, Pelicula pelicula, MedidaSimilitud medida) {
        this.ws = ws;
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
        
    }
    
    @Override
    public float mediaUsuario(){
        
        float media = 0;
        
        for(Valoracion v:usuarioPeliculas){
            media += v.getPuntuacion();
        }  
        
        return media/usuarioPeliculas.size();
        
    }
    
    @Override
    public float mediaPelicula(){
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }

    @Override
    public float prediccion() {
        float num = 0, dem = 0;
        
        /* Sumatoria de la similitud de todos los usuarios que han votado la Pelicula
           con el Usuario. Denominador común de ambos algoritmos*/
        for (Valoracion v:peliculaUsuarios){
            dem += medida.similitud(usuario, v.getUsuario());
        }
        
        if(ws){ // Algorimto WS
            /* Numerador del algoritmo WS */
            for (Valoracion v:peliculaUsuarios){
                num += v.getPuntuacion() * medida.similitud(usuario, v.getUsuario());
            }

            return num/dem;
        }
        
        //Algoritmo WA
        
        float media = mediaUsuario();
        
        /* Numerador del algoritmo WA */
        for (Valoracion v:peliculaUsuarios){
            num += (v.getPuntuacion() - mediaUsuario()) * medida.similitud(usuario, v.getUsuario());
        }
        
        return media + num/dem;
    }
    
}
