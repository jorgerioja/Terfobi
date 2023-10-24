package com.sistema.trabajo.repositorios;

import com.sistema.trabajo.entidades.Examen;
import com.sistema.trabajo.entidades.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface PreguntaRepository extends JpaRepository<Pregunta, Long> {

    Set<Pregunta> findByExamen(Examen examen);


    
}
