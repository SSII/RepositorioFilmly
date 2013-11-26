/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmos.AlgoritmosRecomendacion;

import Algoritmos.Modelo.Pelicula;
import Algoritmos.Modelo.Usuario;

/**
 *
 * @author grupo 12
 */
public class WeitgthedSum implements AlgoritmoRecomendacion {
    
    boolean ws;

    public WeitgthedSum(boolean ws) {
        this.ws = ws;
    }
    
    public float prediccion(Usuario u, Pelicula p) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public float prediccion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
