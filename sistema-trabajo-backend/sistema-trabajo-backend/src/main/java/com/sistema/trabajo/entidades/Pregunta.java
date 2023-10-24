package com.sistema.trabajo.entidades;

import javax.persistence.*;

@Entity
@Table(name = "preguntas")
public class Pregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long preguntaId;
    @Column(length = 5000)
    private String contenido;
    private String imagen;
    private String imagenFob1;
    private String imagenFob2;
    private String opcion1;
    private String opcion2;
    private String opcion3;
    private String opcion4;
    @Transient
    private String respuestaDada;
    private String respuesta;
    private String respuestaDet;

    @ManyToOne(fetch = FetchType.EAGER)
    private Examen examen;
    //muchas preguntas le pueden pertenecer a un examen


    public Long getPreguntaId() {
        return preguntaId;
    }

    public void setPreguntaId(Long preguntaId) {
        this.preguntaId = preguntaId;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getImagenFob1() {
        return imagenFob1;
    }

    public void setImagenFob1(String imagenFob1) {
        this.imagenFob1 = imagenFob1;
    }

    public String getImagenFob2() {
        return imagenFob2;
    }

    public void setImagenFob2(String imagenFob2) {
        this.imagenFob2 = imagenFob2;
    }

    public String getOpcion1() {
        return opcion1;
    }

    public void setOpcion1(String opcion1) {
        this.opcion1 = opcion1;
    }

    public String getOpcion2() {
        return opcion2;
    }

    public void setOpcion2(String opcion2) {
        this.opcion2 = opcion2;
    }

    public String getOpcion3() {
        return opcion3;
    }

    public void setOpcion3(String opcion3) {
        this.opcion3 = opcion3;
    }

    public String getOpcion4() {
        return opcion4;
    }

    public void setOpcion4(String opcion4) {
        this.opcion4 = opcion4;
    }

    public String getRespuestaDada() {
        return respuestaDada;
    }

    public void setRespuestaDada(String respuestaDada) {
        this.respuestaDada = respuestaDada;
    }

    public String getRespuestaDet() {
        return respuestaDet;
    }

    public void setRespuestaDet(String respuestaDet) {
        this.respuestaDet = respuestaDet;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public Pregunta() {
    }
}
