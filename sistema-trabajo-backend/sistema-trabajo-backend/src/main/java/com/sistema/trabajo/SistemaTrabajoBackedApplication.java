package com.sistema.trabajo;

import com.sistema.trabajo.entidades.Rol;
import com.sistema.trabajo.entidades.Usuario;
import com.sistema.trabajo.entidades.UsuarioRol;
import com.sistema.trabajo.excepciones.UsuarioFoundException;
import com.sistema.trabajo.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//import javax.sound.midi.SysexMessage;
import java.util.HashSet;
import java.util.Set;


@SpringBootApplication
public class SistemaTrabajoBackedApplication implements CommandLineRunner {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SistemaTrabajoBackedApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

			/*try{
				Usuario usuario = new Usuario();

				usuario.setNombre("Jorge");
				usuario.setApellido("Rioja");
				usuario.setUsername("jorger");
				usuario.setPassword(bCryptPasswordEncoder.encode("12345"));
				usuario.setEmail("j1@gmail.com");
				usuario.setTelefono("957233486");
				usuario.setPerfil("foto.png");

				Rol rol = new Rol();
				rol.setRolId(1L);
				rol.setNombre("ADMIN");

				Set<UsuarioRol> usuarioRoles = new HashSet<>();
				UsuarioRol usuarioRol = new UsuarioRol();
				usuarioRol.setRol(rol);
				usuarioRol.setUsuario(usuario);
				usuarioRoles.add(usuarioRol);

				Usuario usuarioGuardado = usuarioService.guardarUsuario(usuario, usuarioRoles);
				System.out.println(usuarioGuardado.getUsername());

			}catch (UsuarioFoundException exception){
				exception.printStackTrace();
			}*/




	}
}
