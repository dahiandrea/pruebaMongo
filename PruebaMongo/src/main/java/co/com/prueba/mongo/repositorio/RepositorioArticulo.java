package co.com.prueba.mongo.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.com.prueba.mongo.entidad.Articulo;

public interface RepositorioArticulo  extends MongoRepository<Articulo, String> {

}
