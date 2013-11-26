/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmos.AlgoritmosRecomendacion;
import Algoritmos.Modelo.*;

/**
 *
 * @author Alvaro
 */
public interface AlgoritmoRecomendacion {
    
    /* Algoritmo de predicción a implementar */
    public abstract float prediccion();
    
    /* Media de todas la valoraciones hechas por el Usuario */
    public abstract float mediaUsuario();
    
    /* Media de todas la valoraciones hechas por los usuarios a la Pelicula */
    public abstract float mediaPelicula();
}
