package es.parla.prog.examen.Zoopedia.Modelo.Factoria;

import es.parla.prog.examen.Zoopedia.Modelo.Animal;
import es.parla.prog.examen.Zoopedia.Modelo.NivelNormal;
import es.parla.prog.examen.Zoopedia.Modelo.NivelPokemonn;
import es.parla.prog.examen.Zoopedia.Modelo.NivelRaro;

public class FactoriaAnimal {
    

    public static Animal crearAnimal(int opc, int numeroCuerno,  int colmillos) {
        switch (opc) {
            case 1:
                if (numeroCuerno == 0 && colmillos == 0) {
                    return new NivelNormal();
                }

            case 2:
                if (numeroCuerno <=2 && colmillos <=2) {
                    return new NivelRaro();
                }

            case 3:
                if (numeroCuerno > 2 && colmillos > 2) {
                    return new NivelPokemonn();
                }

            default:
                throw new IllegalArgumentException("************No puedes crear este Animal*********************");

        }
    }

}
