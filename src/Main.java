import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
/*
 * Clase principal, gobierna el funcionamiento del programa de la práctica 
 * 1 de Modelado y Programación.
 */

public class Main {

    /** Se utilizará para leer la entrada del usuario. */
    Scanner sc;

    /** El archivo donde se escribirá la salida del programa. */
    File file;
    
    /** Servicio de streaming para un dispositivo de Memeflix. */
    Service memeflix1Device;
    /** Servicio de streaming para dos dispositivos de Memeflix. */
    Service memeflix2Devices;
    /** Servicio de streaming para cuatro dispositivos de Memeflix. */
    Service memeflix4Devices;
    /** Servicio de streaming para usuario normal de Momazon. */
    Service momazonNormal;
    /** Servicio de streaming para usuario premium de Momazon. */
    Service momazonPremium;
    /** Servicio de streaming para usuario normal de Spootify. */
    Service spootifyNormal;
    /** Servicio de streaming para usuario premium de Spootify. */
    Service spootifyPremium;
    /** Servicio de streaming para los primeros tres meses de Thisney+. */
    Service thisneyFirst3Months;
    /** Servicio de streaming para después de los tres meses de Thisney+. */
    Service thisneyAfter3Months;
    /** Servicio de streaming para los primeros tres meses de HVO Max. */
    Service hvoFirst3Months;
    /** Servicio de streaming para después de los tres meses de HVO Max. */
    Service hvoAfter3Months;

    /** El banco que efectuará los cobros por los servicios. */
    Bank bank;

    /** La lista de servicios de la compañía de streaming Memeflix. */
    ArrayList<Service> memeflixServices = new ArrayList<>();
    /** La lista de servicios de la compañía de streaming Momazon. */
    ArrayList<Service> momazonServices = new ArrayList<>();
    /** La lista de servicios de la compañía de streaming Spootify. */
    ArrayList<Service> spootifyServices = new ArrayList<>();
    /** La lista de servicios de la compañía de streaming Thisney+. */
    ArrayList<Service> thisneyServices = new ArrayList<>();
    /** La lista de servicios de la compañía de streaming HVOMax. */
    ArrayList<Service> hvoServices = new ArrayList<>();

    /** La compañía de streaming Memeflix. */
    Memeflix memeflix;
    /** La compañía de streaming Momazon. */
    MomazonPrimeVideo momazon;
    /** La compañía de streaming Spootify. */
    Spootify spootify;
    /** La compañía de streaming Thisney+. */
    Thisney thisney;
    /** La compañía de streaming HVOMax. */
    HVOMax hvoMax;

    /** Cliente Alicia. */
    Client alicia;
    /** Cliente Bob. */
    Client bob;
    /** Cliente Cesar. */
    Client cesar;
    /** Cliente Diego. */
    Client diego;
    /** Cliente Erika. */
    Client erika;
    /** Cliente Fausto. */
    Client fausto;

    /** El mes en el que estamos. */
    int month = -1;

    public void run() {
        newFile();
        createServices();
        addServices();
        createCompanies();
        createClients();
        sc = new Scanner(System.in);

        System.out.println("Are you ready to run the best program? [y/n]");
        String response = sc.next();
        if (response.equals("n")) System.exit(0);
        
        do {
            System.out.println("\n\n Please select the option you want to execute: \n\n");
            System.out.println("1. Let a month pass.\n");
            System.out.println("2. Exit the program :(.\n");
            int selection = -1;

            while (true) {
                try {
                    selection = sc.nextInt();
                    break;
                } catch (NumberFormatException nfe) {
                    System.out.println("Please try again, insert a valid number.\n");
                }
            }
            month++;

            if(selection == 2) System.exit(0);

            switch (month) {
                case 0 : 
                    timePass(1);

                    toHire(alicia, memeflix, memeflix4Devices);
                    toHire(alicia, momazon, momazonPremium);
                    toHire(alicia, spootify, spootifyPremium);
                    toHire(alicia, thisney, thisneyFirst3Months);
                    toHire(alicia, hvoMax, hvoFirst3Months);

                    toHire(bob, memeflix, memeflix4Devices);
                    toHire(bob, momazon, momazonPremium);
                    toHire(bob, spootify, spootifyPremium);
                    toHire(bob, thisney, thisneyFirst3Months);
                    toHire(bob, hvoMax, hvoFirst3Months);

                    toHire(cesar, thisney, thisneyFirst3Months);
                    toHire(cesar, hvoMax, hvoFirst3Months);

                    toHire(diego, momazon, momazonPremium);
                    toHire(diego, spootify, spootifyNormal);
                    toHire(diego, hvoMax, hvoFirst3Months);
                    
                    toHire(erika, memeflix, memeflix4Devices);
                    toHire(erika, spootify, spootifyNormal);
                    toHire(erika, hvoMax, hvoFirst3Months);

                    toHire(fausto, thisney, thisneyFirst3Months);
                    toHire(fausto, hvoMax, hvoFirst3Months);
                    break;
                
                case 1: 
                    allCompaniesCharge();
                    timePass(2);
                    break;
                
                case 2: 
                    allCompaniesCharge();
                    timePass(3);

                    toUnhire(bob, thisney);
                    toUnhire(bob, hvoMax);

                    toUnhire(erika, hvoMax);
                    toHire(erika, thisney, thisneyFirst3Months);

                    toUnhire(fausto, thisney);
                    toUnhire(fausto, hvoMax);
                    toHire(fausto, memeflix, memeflix1Device);
                    break;
                
                case 3: 
                    allCompaniesCharge();
                    timePass(4);

                    toUnhire(bob, memeflix);
                    toUnhire(bob, momazon);
                    break;
                
                case 4: 
                    allCompaniesCharge();
                    timePass(5);

                    toHire(fausto, thisney, thisneyAfter3Months);
                    toHire(fausto, hvoMax, hvoAfter3Months);
                    break;
                
                case 5: 
                    allCompaniesCharge();
                    timePass(6);

                    toHire(diego, thisney, thisneyFirst3Months);

                    toUnhire(erika, memeflix);
                    toUnhire(erika, spootify);
                    toUnhire(erika, thisney);

                    toUnhire(fausto, memeflix);
                    toUnhire(fausto, thisney);
                    toUnhire(fausto, hvoMax);
                    break;
                
                case 7: 
                    allCompaniesCharge();
                    timePass(7);

                    toHire(cesar, spootify, spootifyPremium);

                    toHire(diego, memeflix, memeflix1Device);
                    toHire(diego, spootify, spootifyPremium);
                    toUnhire(diego, momazon);

                    allCompaniesCharge();
                    break;
                
                case 8: 
                    allCompaniesCharge();
                    timePass(8);
                    break;
                
                case 9: 
                    allCompaniesCharge();
                    timePass(9);
                    break;
                
                case 10: 
                    allCompaniesCharge();
                    timePass(10);

                    toHire(erika, momazon, momazonPremium);
                    toHire(erika, thisney, thisneyAfter3Months);
                    toHire(erika, hvoMax, hvoAfter3Months);

                    allCompaniesCharge();
                    timePass(11);
                    break;
                
                case 11: 
                    allCompaniesCharge();
                    break;
                
                case 12: 
                    System.exit(0);
                    break;
                default:
                    break;
                
            }
        } while (true);
    }

    private void newFile() {
        file = new File("Bitácora_Práctica_1.txt");
        try {
            FileWriter fw = new FileWriter(file);
            fw.close();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }


    private void createServices() {
        memeflix1Device = new Service("Memeflix", "Memeflix (1 dispositivo)", 120);
        memeflix2Devices = new Service("Memeflix", "Memeflix (2 dispositivos)", 170);
        memeflix4Devices = new Service("Memeflix", "Memeflix (4 dispositivos)", 200);

        momazonNormal = new Service("MomazonPrimeVideo", "Momazon Prime Video (Normal)", 110);
        momazonPremium = new Service("MomazonPrimeVideo", "Momazon Prime Video (Premium)", 150);

        spootifyNormal = new Service("Spootify", "Spootify (Normal)", 0);
        spootifyPremium = new Service("Spootify", "Spootify (Premium)", 80);

        thisneyFirst3Months = new Service("Thisney+", "Thisney+ (Primeros 3 meses)", 130);
        thisneyAfter3Months = new Service("Thisney+", "Thisney+ (Después de 3 meses)", 160);

        hvoFirst3Months = new Service("HVO Max", "HVO Max (Primeros 3 meses)", 0);
        hvoAfter3Months = new Service("HVO Max", "HVO Max (Después de 3 meses)", 140);
    }

    private void addServices() {
        memeflixServices.add(memeflix1Device);
        memeflixServices.add(memeflix2Devices);
        memeflixServices.add(memeflix4Devices);

        momazonServices.add(momazonNormal);
        momazonServices.add(momazonPremium);

        spootifyServices.add(spootifyNormal);
        spootifyServices.add(spootifyPremium);

        thisneyServices.add(thisneyFirst3Months);
        thisneyServices.add(thisneyAfter3Months);

        hvoServices.add(hvoFirst3Months);
        hvoServices.add(hvoAfter3Months);
    }

    private void createCompanies() {
        bank = new Bank();

        memeflix = new Memeflix("Memeflix", memeflixServices, bank);
        momazon = new MomazonPrimeVideo("Momazon Prime Video", momazonServices, bank);
        spootify = new Spootify("Spootify", spootifyServices, bank);
        thisney = new Thisney("Thisney+", thisneyServices, bank);
        hvoMax = new HVOMax("HVO Max", hvoServices, bank);
    }

    private void createClients() {
        alicia = new Client("Alicia", 15000);
        bob = new Client("Bob", 2400);
        cesar = new Client("César", 5000);
        diego = new Client("Diego", 9000);
        erika = new Client("Erika", 10000);
        fausto = new Client("Fausto", 5000);

        bank.add(alicia);
        bank.add(bob);
        bank.add(cesar);
        bank.add(diego);
        bank.add(erika);
        bank.add(fausto);
    }

    private void toHire(Client c, StreamingCompany sc, Service s) {
        c.hire(s);
        sc.registerClient(c, s);
    }

    private void toUnhire(Client c, StreamingCompany sc) {
        c.unhire(sc);
        sc.removeClient(c);
    }

    private void timePass(int month) {
        System.out.println("\n Month " + month + "\n\n");
        try {
            FileWriter fw = new FileWriter(file, true);
            fw.write("\n Month " + month + "\n\n");
            fw.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    } 

    private void allCompaniesCharge() {
        memeflix.charge();
        momazon.charge();
        spootify.charge();
        thisney.charge();
        hvoMax.charge();

        memeflix.increseTime();
        momazon.increseTime();
        spootify.increseTime();
        thisney.increseTime();
        hvoMax.increseTime();
    }
}