package co.com.prueba.mongo.servicio;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.count;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.unwind;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.out;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import co.com.prueba.mongo.entidad.Articulo;
import co.com.prueba.mongo.entidad.Usuario;
import co.com.prueba.mongo.repositorio.RepositorioArticulo;
import co.com.prueba.mongo.repositorio.RepositorioUsuario;

@Service
public class ServicioBlog implements ServicioBlogInterface {

    @Autowired
    RepositorioArticulo repositorioArticulo;

    @Autowired
    RepositorioUsuario repositorioUsuario;

    @Autowired
    MongoTemplate mongoTemplate;
    
    @Override
    public List<Articulo> listarArticulos() {
        return repositorioArticulo.findAll();
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return repositorioUsuario.findAll();
    }

    @Override
    public Articulo crearComentario(Articulo articulo) {
        return repositorioArticulo.save(articulo);
    }

    @Override
    public List<Articulo> comentarioPorUsuario(String idUsuario) {
        Aggregation agg = newAggregation(
                unwind("$comentarios"),
                match(Criteria.where("comentarios.userid").is(idUsuario)),
                group("id", "comentarios").push("comentarios").as("comentarios")
            );

    AggregationResults<Articulo> groupResults = mongoTemplate.aggregate(agg, Articulo.class, Articulo.class);
    return groupResults.getMappedResults();

    }

    @Override
    public String totalPositivos(String idUsuario) {
        Aggregation agg = newAggregation(
                unwind("$comentarios"),
                match(Criteria.where("comentarios.userid").is(idUsuario)),
                match(Criteria.where("comentarios.tipo").is("positivo")),
                count().as("totalPositivos")
            );

    AggregationResults<Usuario> groupResults = mongoTemplate.aggregate(agg, Articulo.class, Usuario.class);
    return groupResults!= null && groupResults.getUniqueMappedResult() !=null ? groupResults.getUniqueMappedResult().getTotalPositivos() : "0";
    }

    @Override
    public String totalNegativos(String idUsuario) {
        Aggregation agg = newAggregation(
                unwind("$comentarios"),
                match(Criteria.where("comentarios.userid").is(idUsuario)),
                match(Criteria.where("comentarios.tipo").is("negativo")),
                count().as("totalNegativos")
            );

    AggregationResults<Usuario> groupResults = mongoTemplate.aggregate(agg, Articulo.class, Usuario.class);
    return groupResults!= null && groupResults.getUniqueMappedResult() !=null ? groupResults.getUniqueMappedResult().getTotalNegativos() : "0";
    }

}
