package com.sistema.trabajo.entidades;


import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "roles")
public class Rol {
    @Id
    private Long rolId;
    private String nombre;

    //a un rol le puede pertenecer a muchos usuarios
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "rol")
    private Set<UsuarioRol>usuarioRoles=new HashSet<>();

    public  Rol(){

    }

    public Rol(Long rolId, String nombre) {
        this.rolId = rolId;
        this.nombre = nombre;
    }

    public Long getRolId() {
        return rolId;
    }

    public void setRolId(Long rolId) {
        this.rolId = rolId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<UsuarioRol> getUsuarioRoles() {
        return usuarioRoles;
    }

    public void setUsuarioRoles(Set<UsuarioRol> usuarioRoles) {
        this.usuarioRoles = usuarioRoles;
    }


}
