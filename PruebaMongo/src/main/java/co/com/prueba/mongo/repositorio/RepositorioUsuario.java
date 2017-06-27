package co.com.prueba.mongo.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.com.prueba.mongo.entidad.Usuario;

public interface RepositorioUsuario extends MongoRepository<Usuario, String>{

}
