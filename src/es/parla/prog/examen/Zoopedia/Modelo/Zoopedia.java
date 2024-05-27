package es.parla.prog.examen.Zoopedia.Modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Zoopedia {
    protected String nombre;
    protected LocalDate fecha;
    protected List<Animal> an;
    protected List<Usuario> us;

    public Zoopedia(String nombre, LocalDate fecha) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.an = new ArrayList<>();
        this.us = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public List<Animal> getAn() {
        return an;
    }

    public void setAn(List<Animal> an) {
        this.an = an;
    }

    public List<Usuario> getUs() {
        return us;
    }

    public void setUs(List<Usuario> us) {
        this.us = us;
    }

    public void crearAnimal(Animal animal) {
        try {
            an.add(animal);
        } catch (IllegalArgumentException e) {
            System.out.println("************No puedes crear este Animal*********************" + e);
        }

    }

    public void crearUsuario(Usuario usuario) {
        us.add(usuario);
    }

    public int calcularPuntos() {

        int puntos = 0;
        for (Animal a : getAn()) {
            if (a instanceof NivelNormal) {
                puntos += NivelNormal.PUNTOSNORMAL;
            }
            if (a instanceof NivelRaro) {
                puntos += NivelRaro.PUNTOSRAROS;
            }
            if (a instanceof NivelPokemonn) {
                puntos += NivelPokemonn.PUNTOSPOKEMON;
            }
        }
        return puntos;
    }
}
