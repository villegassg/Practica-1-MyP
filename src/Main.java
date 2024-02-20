import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Crear instancias de servicios
        Service memeflix1Device = new Service("Memeflix (1 dispositivo)", 120);
        Service memeflix2Devices = new Service("Memeflix (2 dispositivos)", 170);
        Service memeflix4Devices = new Service("Memeflix (4 dispositivos)", 200);
        Service momazonNormal = new Service("Momazon Prime Video (Normal)", 110);
        Service momazonPremium = new Service("Momazon Prime Video (Premium)", 150);
        Service spootifyPremium = new Service("Spootify (Premium)", 80);
        Service thisneyFirst3Months = new Service("Thisney+ (Primeros 3 meses)", 130);
        Service thisneyAfter3Months = new Service("Thisney+ (Después de 3 meses)", 160);
        Service hvoFirst3Months = new Service("HVO Max (Primeros 3 meses)", 0); // Gratis los primeros 3 meses
        Service hvoAfter3Months = new Service("HVO Max (Después de 3 meses)", 140);

        // Crear instancias de compañías de streaming
        ArrayList<Service> memeflixServices = new ArrayList<>();
        memeflixServices.add(memeflix1Device);
        memeflixServices.add(memeflix2Devices);
        memeflixServices.add(memeflix4Devices);
        Memeflix memeflix = new Memeflix("Memeflix", memeflixServices);

        ArrayList<Service> momazonServices = new ArrayList<>();
        momazonServices.add(momazonNormal);
        momazonServices.add(momazonPremium);
        MomazonPrimeVideo momazon = new MomazonPrimeVideo("Momazon Prime Video", momazonServices);

        ArrayList<Service> spootifyServices = new ArrayList<>();
        spootifyServices.add(spootifyPremium);
        Spootify spootify = new Spootify("Spootify", spootifyServices);

        ArrayList<Service> thisneyServices = new ArrayList<>();
        thisneyServices.add(thisneyFirst3Months);
        thisneyServices.add(thisneyAfter3Months);
        ThisneyPlus thisney = new ThisneyPlus("Thisney+", thisneyServices);

        ArrayList<Service> hvoServices = new ArrayList<>();
        hvoServices.add(hvoFirst3Months);
        hvoServices.add(hvoAfter3Months);
        HvoMax hvoMax = new HvoMax("HVO Max", hvoServices);

        // Crear instancias de clientes
        Client alicia = new Client("Alicia", 15000);
        Client bob = new Client("Bob", 2400);
        Client cesar = new Client("César", 5000);
        Client diego = new Client("Diego", 9000);
        Client erika = new Client("Erika", 10000);
        Client fausto = new Client("Fausto", 5000);

        // Simular la contratación inicial de servicios
        alicia.hire(memeflix);
        alicia.hire(momazon);
        alicia.hire(spootify);
        alicia.hire(thisney);
        alicia.hire(hvoMax);

        bob.hire(memeflix);
        bob.hire(momazon);
        bob.hire(spootify);
        bob.hire(thisney);
        bob.hire(hvoMax);

        cesar.hire(thisney);
        cesar.hire(hvoMax);

        diego.hire(hvoMax);
        diego.hire(momazon);
        diego.hire(spootify);

        erika.hire(memeflix);
        erika.hire(spootify);
        erika.hire(hvoMax);

        fausto.hire(thisney);
        fausto.hire(hvoMax);

        // Simular el transcurso de los meses
        for (int month = 1; month <= 12; month++) {
            // Notificar los meses contratados
            memeflix.notifyMonths(month);
            momazon.notifyMonths(month);
            spootify.notifyMonths(month);
            thisney.notifyMonths(month);
            hvoMax.notifyMonths(month);

            // Realizar cobros mensuales
            memeflix.charge();
            momazon.charge();
            spootify.charge();
            thisney.charge();
            hvoMax.charge();

            // Simular cancelaciones y nuevas contrataciones según el mes
            switch (month) {
                case 4:
                    bob.unhire(thisney);
                    bob.unhire(hvoMax);
                    break;
                case 7:
                    cesar.hire(spootify);
                    diego.hire(thisney);
                    diego.unhire(momazon);
                    erika.unhire(memeflix);
                    erika.unhire(spootify);
                    erika.unhire(hvoMax);
                    break;
                case 10:
                    erika.hire(momazon);
                    erika.hire(hvoMax);
                    erika.hire(thisney);
                    break;
            }
        }
    }
}
