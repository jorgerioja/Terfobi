package com.sistema.trabajo.repositorios;

import com.sistema.trabajo.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public Usuario findByUsername(String username);



}
