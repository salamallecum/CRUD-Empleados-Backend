package com.gestion.empleados.modelo;

import jakarta.persistence.*;

//Con esta etiqueta indicamos que la clase modela la entidad empleado
//Al ejecutar la app por primera vez, automaticamene creará la tabla empleado en BD con los campos indicados en la clase
@Entity
//Con esta etiqueta, indicamos que la clase modela objetos de la tabla Empleado de la BD
@Table(name = "empleados")
public class Empleado {

    //Con estas etiquetas mapeamos el id de la tabla e indicamos que es autoincrementable
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //Con esta etiqueta, indicamos que el valor corresponde al valor de la columna nombre de la tabla empleados de la BD y definimos sus propiedades
    @Column(name = "nombre", length = 60, nullable = false)
    private String nombre;
    @Column(name = "apellido", length = 60, nullable = false)
    private String apellido;
    @Column(name = "email", length = 60, nullable = false, unique = true)
    private String email;

    //Constructor vacio
    public Empleado() {
    }

    //Constructor con atributos
    public Empleado(Long id, String nombre, String apellido, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }

    //Metodos getter y setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
