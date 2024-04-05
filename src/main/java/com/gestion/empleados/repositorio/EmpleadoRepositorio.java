package com.gestion.empleados.repositorio;

import com.gestion.empleados.modelo.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Con esta etiqueta indicamos que esta clase es de tipo repositorio
@Repository
public interface EmpleadoRepositorio extends JpaRepository<Empleado, Long> {
}
