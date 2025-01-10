package es.parla.prog.examen.Zoopedia.Vista;

import es.parla.prog.examen.Zoopedia.Entrada.Entrada;
import es.parla.prog.examen.Zoopedia.Modelo.Animal;
import es.parla.prog.examen.Zoopedia.Modelo.Factoria.FactoriaAnimal;
import es.parla.prog.examen.Zoopedia.Modelo.NivelNormal;
import es.parla.prog.examen.Zoopedia.Modelo.NivelPokemonn;
import es.parla.prog.examen.Zoopedia.Modelo.NivelRaro;
import es.parla.prog.examen.Zoopedia.Modelo.Usuario;
import es.parla.prog.examen.Zoopedia.Modelo.Zoopedia;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    static Zoopedia zoopedia;
    static ArrayList<Zoopedia> zo = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static Usuario iuUsuario;
    static String msg = "";

    public static void main(String[] args) throws Exception {
        LocalDate date = crearFecha();
        zoopedia = new Zoopedia("El paradise", date);
        iuUsuario = new Usuario("Kelvin", "Obamedo", 22, date);
        zoopedia.crearUsuario(iuUsuario);
        zo.add(zoopedia);
        crearMenu();
    }

    public static LocalDate crearFecha() {
        System.out.print("YYYY: ");
        int anio = Entrada.leerEntero();
        System.out.print("MM: ");
        int mes = Entrada.leerEntero();
        System.out.print("DD: ");
        int dia = Entrada.leerEntero();

        return LocalDate.of(anio, mes, dia);
    }

    public static void crearAnimal() {
        System.out.print("1.Nivel normal\n2.Nivel Raro\n3.Nivel Pokemon\nSelecione un tipo");
        int opc = Entrada.leerEntero();
        System.out.print("Nombre: ");
        String nombre = Entrada.leerString();
        System.out.print("Tiene Cuernos/Colmillos S/N: ");
        String hayCuerno = Entrada.leerString();
        System.out.print("Cuantos cuernos tiene:  ");
        int cuerno = Entrada.leerEntero();
        System.out.print("Comillos: ");
        int colmillos = Entrada.leerEntero();

        Animal animal = FactoriaAnimal.crearAnimal(opc, cuerno, colmillos);
        animal.setColmillos(colmillos);
        animal.setCuerno(hayCuerno);
        animal.setNombre(nombre);
        animal.setNumeroCuerno(cuerno);
        zoopedia.crearAnimal(animal);
    }

    public static void crearMenu() {
        int opc = 0;
        do {
            System.out.print(
                    "1.Registrar Animal\n2.Crear usuario \n3.Marca Favorito\n4.Mostrar Info\n0.Salir, calcular puntos y generar fichero\nElige una opcion: ");
            opc = Entrada.leerEntero();
            switch (opc) {
                case 1:
                    crearAnimal();
                    break;

                case 2:
                    crearUsuario();
                    break;

                case 3:
                    marcaFavorito();
                    break;
                case 4:
                    mostrarInfo();
                    break;
                case 0:
                    calcularPuntos();
                    fiche();
                    System.out.println("Saliendo!!! Se ha creado un fichero durante la visita");
                    break;

                default:
                    break;
            }
        } while (opc != 0);
    }

    private static void calcularPuntos() {
        for (Usuario usuario : zoopedia.getUs()) {
            System.out.println("Los putos del " + usuario.getNombre() + " " + zoopedia.calcularPuntos());

        }
    }

    private static void crearUsuario() {
        System.out.print("Nombre: ");
        String nom = Entrada.leerString();
        System.out.print("Apellidos: ");
        String apellidos = Entrada.leerString();
        System.out.print("Edad: ");
        int edad = Entrada.leerEntero();
        Usuario ususUsuario = new Usuario(nom, apellidos, edad, crearFecha());
        zoopedia.crearUsuario(ususUsuario);

    }

    // es un metodo que coge la posicion del usuario y se le asigna un animal
    public static Animal favorito(Usuario usuario) {
        System.out.println("Selecione el animal favorito: ");
        List<Animal> animals = zoopedia.getAn();

        for (int i = 0; i < animals.size(); i++) {
            System.out.println((1 + i) + " ." + animals.get(i).getNombre());
        }

        int opc = 0;
        do {
            System.out.print("Selecione una opcion: ");
            opc = Entrada.leerEntero();
        } while (opc < 0 || opc > animals.size());

        return animals.get(opc - 1);
    }

    // este metodo recorrer todos los usuarion y animles, y le asingna un animal a
    // un usuario
    public static void marcaFavorito() {
        try {

            for (int i = 0; i < zoopedia.getUs().size(); i++) {

                Usuario a = zoopedia.getUs().get(i);
                Animal b = zoopedia.getAn().get(i);
                b = favorito(a);
                System.out.println("quieres que sea tu animal favorito: ");
                String bs = Entrada.leerString();
                if (bs.equalsIgnoreCase("S")) {
                    msg = " Ha elegigo el animal " + b.getNombre() + " como favourito";
                    b.setEsFavourito(true);
                } else {
                    msg = " Ha elegigo el animal " + b.getNombre() + " como no favourito";
                    b.setEsFavourito(false);
                }

                System.out.println("El usuario " + a.getNombre() + msg);
            }

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Tienes que crear al menos dos animales" + e);
        }

    }

    public static void mostrarInfo() {
        System.out.println("1.Listado Animal\n2.Buscar Animal\n3.Favorito");
        int opc = Entrada.leerEntero();
        switch (opc) {
            case 1:
                mostrarListado();
                break;

            case 2:
                mostrarPosicion();
                break;

            case 3:
                mostrarFavourito();
                break;
            default:
                break;
        }

    }

    public static void mostrarListado() {
        String msg = "";
        int cuerno = 0;
        int colmillos = 0;
        for (Animal animal : zoopedia.getAn()) {

            if (animal instanceof NivelNormal) {
                NivelNormal n = (NivelNormal) animal;
                msg = NivelNormal.TIPO;
                cuerno = n.getNumeroCuerno();
                colmillos = n.getColmillos();
            } else if (animal instanceof NivelRaro) {
                NivelRaro r = (NivelRaro) animal;
                msg = NivelRaro.TIPO;
                cuerno = r.getNumeroCuerno();
                colmillos = r.getColmillos();
            } else if (animal instanceof NivelPokemonn) {
                msg = NivelPokemonn.TIPO;
                NivelPokemonn p = (NivelPokemonn) animal;
                cuerno = p.getNumeroCuerno();
                colmillos = p.getColmillos();
            }

            System.out.println("El " + animal.getNombre() + " es de nivel, " + msg + " tiene " + cuerno + " cuernos y "
                    + colmillos + " colmillos");
        }
    }

    public static void mostrarPosicion() {

        List<Animal> animal = zoopedia.getAn();
        System.out.println("Escribe el numero de poscicon ");
        int auxPosic = Entrada.leerEntero();
        int cuerno = 0;
        int colmillos = 0;
        String msg = "";
        int inddex = 1;

        if (auxPosic > 0 && auxPosic <= zoopedia.getAn().size()) {
            for (Animal animal2 : animal) {

                if (animal2 instanceof NivelNormal) {

                    msg = NivelNormal.TIPO;
                    cuerno = animal2.getNumeroCuerno();
                    colmillos = animal2.getColmillos();
                    inddex++;
                } else if (animal2 instanceof NivelRaro) {

                    msg = NivelRaro.TIPO;
                    cuerno = animal2.getNumeroCuerno();
                    colmillos = animal2.getColmillos();
                    inddex++;
                } else if (animal2 instanceof NivelPokemonn) {

                    cuerno = animal2.getNumeroCuerno();
                    colmillos = animal2.getColmillos();
                    inddex++;
                }

                System.out.println("El " + animal2.getNombre() + " es de nivel, " + msg + " tiene " + cuerno
                        + " cuernos y " + colmillos + " colmillos");
            }

            zoopedia.getAn().get(auxPosic - 1).toString();
        }

    }

    public static void mostrarFavourito() {
        int cuerno = 0;
        int colmillos = 0;
        
        for (Animal animal : zoopedia.getAn()) {
            if (animal.isEsFavourito() == true) {
                if (animal instanceof NivelNormal) {

                    msg = NivelNormal.TIPO;
                    cuerno = animal.getNumeroCuerno();
                    colmillos = animal.getColmillos();

                } else if (animal instanceof NivelRaro) {

                    msg = NivelRaro.TIPO;
                    cuerno = animal.getNumeroCuerno();
                    colmillos = animal.getColmillos();

                } else if (animal instanceof NivelPokemonn) {

                    cuerno = animal.getNumeroCuerno();
                    colmillos = animal.getColmillos();

                }

                System.out.println("El " + animal.getNombre() + " es de nivel, " + msg + " tiene " + cuerno
                        + " cuernos y " + colmillos + " colmillos");
            }
        }

    }

    public static void fiche() {
        for (Usuario usuario : zoopedia.getUs()) {
            fichero(usuario);
        }
    }

    public static void fichero(Usuario usuario) {

        try {
            
                for (Animal a : zoopedia.getAn()) {
                    try (BufferedWriter buf = new BufferedWriter(new FileWriter("Animal.txt"))) {
                        buf.write("El usuario " + usuario.getNombre() + " hizo esta operaciones durante la vista " + msg + " ,tiene " + a.getNumeroCuerno() + " cuerno y  " + a.getColmillos() + " colmillos\n");
                    }
                }
            

        } catch (IOException e) {
            System.out.println("Error " + e);
        }
    }
}
