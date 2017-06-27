package co.com.prueba.mongo.servicio;

import java.util.List;

import co.com.prueba.mongo.entidad.Articulo;
import co.com.prueba.mongo.entidad.Usuario;

public interface ServicioBlogInterface {

    List<Articulo> listarArticulos();
    
    List<Usuario> listarUsuarios();
    
    Articulo crearComentario(Articulo articulo);
    
    List<Articulo> comentarioPorUsuario(String idUsuario);
    
    String totalPositivos(String idUsuario);
    
    String totalNegativos(String idUsuario);
    
}
