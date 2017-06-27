package co.com.prueba.mongo;
 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
 
/**
 * Archivo de configuraci�n en la ruta que se defina en el argumento --spring.config.location de la app
 * @author diegheal
 *
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer {
	
	public static void main(String[] args) {       
		SpringApplication.run(Application.class, args);
	}
}
