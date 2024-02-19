import java.util.ArrayList;

/**
 * Clase pública para representar a los clientes de las compañías 
 * de Streaming.
 */
public class Client {
    /** El nombre del cliente. */
    String name;
    /** La cantidad de dinero del cliente. */
    int money;
    /** La lista de servicios que tiene contratados el cliente. */
    ArrayList<StreamingCompany> streamingServices;

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
     * Actualiza la información que tiene el cliente sobre sus servicios 
     * de streaming.
     */
    public void update() {

    }

    /**
     * Simula la contratación de un servicio. Agrega el cliente a la lista 
     * de observadores de la compañía de streaming <code>sc</code>, y agrega la 
     * compañia de streaming a la lista propia de servicios de streaming.
     * @param sc la compañía de streaming que se desea contratar.
     */
    public void hire(StreamingCompany sc) {

    }

    /**
     * Simula la descontratación de un servicio. Elimina al cliente de la 
     * lista observadores de la compañía de streaming <code>sc</code>, y elimina 
     * a la misma compañía de la lista propia de servicios de streaming contratados.
     * @param sc la compañía de streaming que se desea descontratar.
     */
    public void unhire(StreamingCompany sc) {

    }

    /**
     * Permite obtener la lista de servicios que el cliente tiene contratados.
     * @return la lista de servicios de streaming.
     */
    public void getServices() {

    }
}