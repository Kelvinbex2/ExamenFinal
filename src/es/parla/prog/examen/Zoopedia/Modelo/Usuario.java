package es.parla.prog.examen.Zoopedia.Modelo;

import java.time.LocalDate;

public class Usuario {
    protected String nombre;
    protected String apellidos;
    protected int edad;
    protected LocalDate fecha;

    public Usuario(String nombre, String apellidos, int edad, LocalDate fecha) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.fecha = fecha;
    }

    public Usuario() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

   
}
