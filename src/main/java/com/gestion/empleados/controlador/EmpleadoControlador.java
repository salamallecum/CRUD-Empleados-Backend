package com.gestion.empleados.controlador;

import com.gestion.empleados.excepciones.ResourceNotFoundException;
import com.gestion.empleados.modelo.Empleado;
import com.gestion.empleados.repositorio.EmpleadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Clase de tipo controlador
//Agregamos este decorador indicando que será un controlador de tipo REST
@RestController
//Etiquetas necesarias para el intercambio de datos con el frontend
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200/") //Aqui colocamos la direccion http del frontend
public class EmpleadoControlador {

    @Autowired
    private EmpleadoRepositorio repositorio;

    //Este metodo sirve para listar todos los empleados
    @GetMapping("/empleados") //Indica que es una petición GET
    public List<Empleado> listarTodosLosEmpleados() {
        return repositorio.findAll();
    }

    //Este metodo sirve para guardar el empleado
    @PostMapping("/empleados") //Indica que es una petición POST
    public Empleado guardarEmpleado(@RequestBody Empleado empleado) {
        return repositorio.save(empleado);
    }

    //Este metodo sirve para buscar un empleado utilizando su id
    @GetMapping("/empleados/{id}")
    public ResponseEntity<Empleado> obtenerEmpleadoPorId(@PathVariable Long id) {
        Empleado empleado = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el empleado con el ID: " + id));
        return ResponseEntity.ok(empleado);
    }

    //Este metodo sirve para actualizar un empleado
    @PutMapping("/empleados/{id}")//Indica que es una petición PUT
    public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable Long id, @RequestBody Empleado detallesEmpleado) {
        Empleado empleado = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el empleado con el ID: " + id));

        empleado.setNombre(detallesEmpleado.getNombre());
        empleado.setApellido(detallesEmpleado.getApellido());
        empleado.setEmail(detallesEmpleado.getEmail());

        //Actualizamos el empleado
        Empleado empleadoActualizado = repositorio.save(empleado);
        return ResponseEntity.ok(empleadoActualizado);
    }

    //Este metodo sirve para eliminar un empleado
    @DeleteMapping("/empleados/{id}")//Indica que es una petición DELETE
    public ResponseEntity<Map<String, Boolean>> eliminarEmpleado(@PathVariable Long id) {
        Empleado empleado = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el empleado con el ID : " + id));

        repositorio.delete(empleado);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminar", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}
