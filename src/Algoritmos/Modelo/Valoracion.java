/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmos.Modelo;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author grupo 12
 */

@Entity
public class Valoracion implements Serializable {
    @Id
    @GeneratedValue
    Long _id;
    
    @Column(name="rate")
    int _puntuacion;
    String _comentario;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="idUser", referencedColumnName = "id")
    Usuario _usuario;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="idPelicula", referencedColumnName = "id")
    Pelicula _pelicula;

    public Valoracion() {
    }

    public Valoracion(int puntuacion, String comentario, Usuario usuario, Pelicula pelicula) {
        this._puntuacion = puntuacion;
        this._comentario = comentario;
        this._usuario = usuario;
        this._pelicula = pelicula;
    }

    public Valoracion(int puntuacion,Usuario usuario, Pelicula pelicula) {
        this._puntuacion = puntuacion;
        this._usuario = usuario;
        this._pelicula = pelicula;
    }

    public int getPuntuacion() {
        return _puntuacion;
    }

    public String getComentario() {
        return _comentario;
    }

    public Usuario getUsuario() {
        return _usuario;
    }

    public Pelicula getPelicula() {
        return _pelicula;
    }
    
    
    
}
