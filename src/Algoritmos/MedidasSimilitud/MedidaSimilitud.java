/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmos.MedidasSimilitud;
import Algoritmos.Modelo.*; 
/**
 *
 * @author Alvaro
 */
public interface MedidaSimilitud {
    
    public abstract float similitud(Pelicula p1, Pelicula p2);
    
    public abstract float similitud(Usuario u1, Usuario u2);
}
