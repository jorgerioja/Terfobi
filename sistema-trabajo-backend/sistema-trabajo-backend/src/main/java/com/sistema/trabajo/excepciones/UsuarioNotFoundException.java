package com.sistema.trabajo.excepciones;

public class UsuarioNotFoundException extends Exception {
    public UsuarioNotFoundException(){
        super("Este nombre de usuario no existe en la base de datos, vuelva a intentar!");
    }

    public  UsuarioNotFoundException(String mensaje){
        super(mensaje);
    }
}
