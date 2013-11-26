/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmos.Modelo;

/**
 *
 * @author grupo 12
 */
public class Valoracion {
    
    int puntuacion;
    String comentario;
    Usuario usuario;
    Pelicula pelicula;

    public Valoracion(int puntuacion, String comentario, Usuario usuario, Pelicula pelicula) {
        this.puntuacion = puntuacion;
        this.comentario = comentario;
        this.usuario = usuario;
        this.pelicula = pelicula;
    }

    public Valoracion(int puntuacion,Usuario usuario, Pelicula pelicula) {
        this.puntuacion = puntuacion;
        this.usuario = usuario;
        this.pelicula = pelicula;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public String getComentario() {
        return comentario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }
    
    
    
}
