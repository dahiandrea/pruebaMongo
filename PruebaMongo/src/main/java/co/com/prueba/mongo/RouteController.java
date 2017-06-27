package co.com.prueba.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.com.prueba.mongo.entidad.Articulo;
import co.com.prueba.mongo.servicio.ServicioBlogInterface;


@RestController
@RequestMapping(value = "/")
@CrossOrigin(origins = "*")
public class RouteController {

	@Autowired
	private ServicioBlogInterface servicioBlog;
	
	@RequestMapping(method = RequestMethod.GET, value = "/listarArticulos")
	public String listarArticulos() {
		return convertJavaToJson(servicioBlog.listarArticulos());
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/listarUsuarios")
    public String listarUsuarios() {
        return convertJavaToJson(servicioBlog.listarUsuarios());
    }
	
	@RequestMapping(method = RequestMethod.POST, value = "/crearComentario")
    public String crearComentario(@RequestBody String body) {
        return convertJavaToJson(servicioBlog.crearComentario(convertJsonToArticulo(body)));
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "/comentariosPorUsuario/{idUsuario}")
    public String comentarioPorUsuario(@PathVariable("idUsuario") String idUsuario) {
        return convertJavaToJson(servicioBlog.comentarioPorUsuario(idUsuario));
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "/totalPositivos/{idUsuario}")
    public String totalPositivos(@PathVariable("idUsuario") String idUsuario) {
        return servicioBlog.totalPositivos(idUsuario);
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "/totalNegativos/{idUsuario}")
    public String totalNegativos(@PathVariable("idUsuario") String idUsuario) {
        return servicioBlog.totalNegativos(idUsuario);
    }
		
	public static String convertJavaToJson(Object objeto) {
        final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        return gson.toJson(objeto);
    }
	
	public static Articulo convertJsonToArticulo(String objetoJson) {
        final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        return gson.fromJson(objetoJson, Articulo.class);
    }
}
