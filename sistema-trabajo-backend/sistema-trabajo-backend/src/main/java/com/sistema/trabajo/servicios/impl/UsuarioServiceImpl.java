package com.sistema.trabajo.servicios.impl;


import com.sistema.trabajo.entidades.Usuario;
import com.sistema.trabajo.entidades.UsuarioRol;
import com.sistema.trabajo.excepciones.UsuarioFoundException;
import com.sistema.trabajo.repositorios.RolRepository;
import com.sistema.trabajo.repositorios.UsuarioRepository;
import com.sistema.trabajo.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;


    @Override
    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception {
        Usuario usuarioLocal=usuarioRepository.findByUsername(usuario.getUsername());
        if (usuarioLocal !=null){//si el usuario existe ya no se prodrá registrar
            System.out.println("El usuario ya existe");
            throw new UsuarioFoundException("El usuario ya esta presente");
        }
        else {
            for(UsuarioRol usuarioRol:usuarioRoles){
                rolRepository.save(usuarioRol.getRol());

            }
            usuario.getUsuarioRoles().addAll(usuarioRoles);
            usuarioLocal=usuarioRepository.save(usuario);
        }
        return usuarioLocal;

    }

    @Override
    public Usuario obtenerUsuario(String username) {
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public void eliminarUsuario(Long usuarioId) {
        usuarioRepository.deleteById(usuarioId);

    }
}
