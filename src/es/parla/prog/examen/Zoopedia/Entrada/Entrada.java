package es.parla.prog.examen.Zoopedia.Entrada;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Entrada {

    static Scanner sc = new Scanner(System.in);

    public static int leerEntero() {
        int num = 0;

        try {
            num = sc.nextInt();

            if (num < 0) {
                throw new InputMismatchException("Numero negativo, debe ser mayor aue 0.");
            }
        } catch (InputMismatchException e) {
            System.out.println("No valido.");

        } finally {
            sc.nextLine();
        }

        return num;
    }

    public static String leerString() {
        String texto = "";

        try {
            texto = sc.nextLine();
        } catch (Exception e) {
            System.out.println("Error reading input: " + e.getMessage());
        }

        return texto;
    }

    // public static boolean leerBoo(){
        
    // }
}
