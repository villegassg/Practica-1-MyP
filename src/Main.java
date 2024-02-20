import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Crear compañías de streaming
        Memeflix memeflix = new Memeflix("Memeflix", new ArrayList<>());
        MomazonPrimeVideo momazon = new MomazonPrimeVideo("Momazon Prime Video", new ArrayList<>());
        Spootify spootify = new Spootify("Spootify", new ArrayList<>());
        Thisney thisney = new Thisney("Thisney+", new ArrayList<>());
        HVOMax hvoMax = new HVOMax("HVO Max", new ArrayList<>());

        // Crear servicios para cada compañía
        Service memeflixService1 = new Service("Memeflix para 1 dispositivo", 120);
        Service memeflixService2 = new Service("Memeflix para 2 dispositivos", 170);
        Service memeflixService3 = new Service("Memeflix para 4 dispositivos", 200);
        Service momazonService1 = new Service("Momazon Prime Video Normal", 110);
        Service momazonService2 = new Service("Momazon Prime Video Premium", 150);
        Service spootifyService1 = new Service("Spootify Normal", 0);
        Service spootifyService2 = new Service("Spootify Premium", 80);
        Service thisneyService1 = new Service("Thisney+ (3 primeros meses)", 130);
        Service thisneyService2 = new Service("Thisney+ (después del 3er mes)", 160);
        Service hvoMaxService1 = new Service("HVO Max (3 primeros meses)", 0);
        Service hvoMaxService2 = new Service("HVO Max (después del 3er mes)", 140);

        // Agregar servicios a las compañías
        memeflix.getServices().addAll(Arrays.asList(memeflixService1, memeflixService2, memeflixService3));
        momazon.getServices().addAll(Arrays.asList(momazonService1, momazonService2));
        spootify.getServices().addAll(Arrays.asList(spootifyService1, spootifyService2));
        thisney.getServices().addAll(Arrays.asList(thisneyService1, thisneyService2));
        hvoMax.getServices().addAll(Arrays.asList(hvoMaxService1, hvoMaxService2));

        // Crear clientes
        Client alicia = new Client("Alicia", 15000);
        Client bob = new Client("Bob", 2400);
        Client cesar = new Client("César", 5000);
        Client diego = new Client("Diego", 9000);
        Client erika = new Client("Erika", 10000);
        Client fausto = new Client("Fausto", 5000);

        // Suscribir a los clientes a los servicios
        alicia.hire(memeflix, memeflixService3); // Alicia se suscribe a Memeflix con la versión más cara
        alicia.hire(momazon, momazonService2);   // Alicia se suscribe a Momazon Prime Video Premium
        alicia.hire(spootify, spootifyService2); // Alicia se suscribe a Spootify Premium
        alicia.hire(thisney, thisneyService2);   // Alicia se suscribe a Thisney+ después del periodo de prueba
        alicia.hire(hvoMax, hvoMaxService2);     // Alicia se suscribe a HVO Max después del periodo de prueba

        // Repetir el proceso de suscripción para los demás clientes...

        // Simular el transcurso de 12 meses
        for (int month = 1; month <= 12; month++) {
            System.out.println("Mes " + month + ":");

            // Cobrar a los clientes
            memeflix.charge();
            momazon.charge();
            spootify.charge();
            thisney.charge();
            hvoMax.charge();

            // Actualizar el tiempo de suscripción de los clientes
            alicia.update();
            bob.update();
            cesar.update();
            diego.update();
            erika.update();
            fausto.update();

            // Simular otras acciones necesarias para el final del mes

            System.out.println(); // Espacio para separar meses
        }
    }
}
