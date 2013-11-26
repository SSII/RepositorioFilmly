/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmos.Modelo;

/**
 *
 * @author Alvaro
 */
public class Usuario {
    String _nombre;
    String _nick;
    String _pass;
    String _email;
    String _id;

    public Usuario(String _nombre, String _nick, String _pass, String _email, String _id) {
        this._nombre = _nombre;
        this._nick = _nick;
        this._pass = _pass;
        this._email = _email;
        this._id = _id;
    }

    public String getNombre() {
        return _nombre;
    }

    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    public String getNick() {
        return _nick;
    }

    public void setNick(String _nick) {
        this._nick = _nick;
    }

    public String getPass() {
        return _pass;
    }

    public void setPass(String _pass) {
        this._pass = _pass;
    }

    public String getEmail() {
        return _email;
    }

    public void setEmail(String _email) {
        this._email = _email;
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }
    
    
}