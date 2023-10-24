package com.sistema.trabajo.servicios;

import com.sistema.trabajo.entidades.Usuario;
import com.sistema.trabajo.entidades.UsuarioRol;

import java.util.Set;

public interface UsuarioService {
    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception;

    public Usuario obtenerUsuario(String username);

    public void eliminarUsuario(Long usuarioId);




}
