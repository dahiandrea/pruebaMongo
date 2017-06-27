package co.com.prueba.mongo.entidad;

import java.util.ArrayList;

public class Articulo {

    private String id;
    private String nombre;
    private String descripcion;
    private String autor;
    private ArrayList<Comentario> comentarios;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getContenido() {
        return descripcion;
    }
    public void setContenido(String contenido) {
        this.descripcion = contenido;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public ArrayList<Comentario> getComentarios() {
        return comentarios;
    }
    public void setComentarios(ArrayList<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
    
    
}
