/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmos.Modelo;

import java.util.List;

/**
 *
 * @author Alvaro
 */
public class Pelicula {
    
    private String _titulo;
    private int _anno;
    private int _id;
    private List<Valoracion> _valoraciones;

    public Pelicula(String _titulo, int _anno, int _id, List<Valoracion> _valoraciones) {
        this._titulo = _titulo;
        this._anno = _anno;
        this._id = _id;
        this._valoraciones = _valoraciones;
    }

    

    public String getTitulo() {
        return _titulo;
    }

    public void setTitulo(String _titulo) {
        this._titulo = _titulo;
    }

    public int getAnno() {
        return _anno;
    }

    public void setAnno(int _anno) {
        this._anno = _anno;
    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public List<Valoracion> getValoraciones() {
        return _valoraciones;
    }
    
    
    
}

