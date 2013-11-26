/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmos.AlgoritmosRecomendacion;

import Algoritmos.MedidasSimilitud.MedidaSimilitud;
import Algoritmos.Modelo.Pelicula;
import Algoritmos.Modelo.Usuario;
import Algoritmos.Modelo.Valoracion;
import java.util.List;

/**
 *
 * @author grupo 12
 */
public class WeitgthedSum implements AlgoritmoRecomendacion {
    
    List<Valoracion> usuarioPeliculas;
    List<Valoracion> peliculaUsuarios;
    MedidaSimilitud medida;
    Usuario usuario;
    Pelicula pelicula;
    float similitud;
    boolean ws;

    public WeitgthedSum(boolean ws, List<Valoracion> valoraciones, float similitud, Usuario usuario, Pelicula pelicula, MedidaSimilitud medida) {
        this.ws = ws;
        
    }

    @Override
    public float prediccion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
