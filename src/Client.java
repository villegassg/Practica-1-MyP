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

    /**
     * Constructor único. Recibe el nombre y la cantidad de dinero deseada
     * y crea un cliente con ello.
     * @param name el nombre del cliente.
     * @param money el dinero del cliente.
     */
    public Client(String name, int money) {
        this.name = name;
        this.money = money;
    }

    /**
     * Actualiza la información que tiene el cliente sobre sus servicios de 
     * streaming.
     */
    public void update(String message) {
        System.out.println("Dear " + name + ", " + message);
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
     * Permite obtener la lista de servicios que el cliente tiene contratados.
     * @return la lista de servicios de streaming.
     */
    public ArrayList<Service> getServices() {
        return streamingServices;
    }
}