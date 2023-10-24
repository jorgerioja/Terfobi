package com.sistema.trabajo.excepciones;

public class UsuarioFoundException extends Exception {
    public UsuarioFoundException(){
        super("Este nombre de usuario ya existe en la base de datos, vuelva a intentar!");
    }

    public  UsuarioFoundException(String mensaje){
        super(mensaje);
    }


}
