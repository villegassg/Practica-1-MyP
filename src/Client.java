import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

/**
 * Clase pública para representar a los clientes de las compañías 
 * de Streaming.
 */
public class Client implements StreamingCompanyClient{
    /** El nombre del cliente. */
    String name;
    /** La cantidad de dinero del cliente. */
    int money;
    /** La lista de servicios que tiene contratados el cliente. */
    ArrayList<Service> streamingServices;
    /** El archivo donde se escribirá la salida del programa. */
    String file = "Bitácora_Práctica_1.txt";

    /**
     * Constructor único. Recibe el nombre y la cantidad de dinero deseada
     * y crea un cliente con ello.
     * @param name el nombre del cliente.
     * @param money el dinero del cliente.
     */
    public Client(String name, int money) {
        this.name = name;
        this.money = money;
        streamingServices = new ArrayList<>();
    }

    /**
     * Actualiza la información que tiene el cliente sobre sus servicios de 
     * streaming.
     */
    public void update(String message) {
        String print = "Dear " + name + ", " + message + "\n";
        System.out.println(print);
        try {
            FileWriter fw = new FileWriter(file, true);
            fw.write(print);
            fw.close();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Simula la contratación de un servicio. Agrega el servicio contratado 
     * a la lista propia de servicios de streaming.
     * @param sc la compañía de streaming que se desea contratar.
     */
    public void hire(Service s) {
        streamingServices.add(s);
    }

    /**
     * Simula la descontratación de un servicio. Elimina un servicio de la lista 
     * propia de servicios de streaming contratados.
     * @param sc la compañía de streaming que se desea descontratar.
     */
    public void unhire(Service s) {
        streamingServices.remove(s);
    }

    /**
     * Simula la descontratación de un servicio. Dado el nombre de una compañía 
     * de streaming cualquiera, elimina el servicio asociado a la misma de la lista 
     * propia de servicios de streaming contratados.
     * @param sc la compañía de streaming que se desea descontratar.
     */
    public void unhire(StreamingCompany sc) {
        String name = sc.name;
        for (Service s : streamingServices) 
            if (s.streamingCompany.equals(name)) {
                streamingServices.remove(s);
                break;
            }
    }

    /**
     * Permite obtener la lista de servicios que el cliente tiene contratados.
     * @return la lista de servicios de streaming.
     */
    public ArrayList<Service> getServices() {
        return streamingServices;
    }

    /**
     * Simula el pago del cliente por algún servicio.
     * @param amount la cantidad a pagar por el servicio.
     */
    public void pay(int amount) {
        this.money -= amount;
    }
}