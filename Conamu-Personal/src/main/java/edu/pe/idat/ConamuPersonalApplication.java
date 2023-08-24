package edu.pe.idat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import edu.pe.idat.request.UsuarioCreateRequest;
import edu.pe.idat.service.TrabajadorService;

@SpringBootApplication
public class ConamuPersonalApplication {
	
	@Autowired
	TrabajadorService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(ConamuPersonalApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init() {
		return args -> {
			
			var usuario = userService.findOneByUsuarioOptional("admin");
			
			if(usuario.isPresent()) {
				return;
			}
			
			UsuarioCreateRequest user = new UsuarioCreateRequest();
			
			user.setContrasena("admin");
			user.setCorreo("test@idat.pe");
			user.setDni("79797979");
			user.setNombreCompletos("Blanca Blacido");
			user.setRol("3");
			user.setTelefono("951654321");
			user.setUsuario("admin");

			userService.addPersonaTrabajador(user);
		};
	}

}
