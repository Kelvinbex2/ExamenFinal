package es.parla.prog.examen.Zoopedia.Modelo;

public class Animal implements Comparable<Animal> {
    protected String nombre;
    protected String cuerno;
    protected int numeroCuerno;
    protected int colmillos;
    protected boolean esFavourito;

    public boolean isEsFavourito() {
        return esFavourito;
    }

    public void setEsFavourito(boolean esFavourito) {
        this.esFavourito = esFavourito;
    }

    public Animal() {
    }

    public Animal(String nombre, String cuerno, int numeroCuerno, int colmillos) {
        this.nombre = nombre;
        this.cuerno = cuerno;
        this.numeroCuerno = numeroCuerno;
        this.colmillos = colmillos;
        this.esFavourito = true;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCuerno() {
        return cuerno;
    }

    public void setCuerno(String cuerno) {
        this.cuerno = cuerno;
    }

    public int getNumeroCuerno() {
        return numeroCuerno;
    }

    public void setNumeroCuerno(int numeroCuerno) {
        this.numeroCuerno = numeroCuerno;
    }

    public int getColmillos() {
        return colmillos;
    }

    public void setColmillos(int colmillos) {
        this.colmillos = colmillos;
    }

    public void SelecioneFav(Usuario usuario) {
        System.out.println("El " + usuario.getNombre() + " ha selecionado " + nombre + " como favorito");
    }

    @Override
    public int compareTo(Animal a) {

        return this.nombre.compareTo(a.nombre);
    }

    public void detalle(){
        System.out.println();
    }

}
