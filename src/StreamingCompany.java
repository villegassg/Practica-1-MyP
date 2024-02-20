import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Clase pública StreamingCompany, define el comportamiento estándar 
 * de una compañía de streaming.
 */
public abstract class StreamingCompany 
    implements StreamingCompanyBehavior, StreamingCompanySubject {
    
    /** El nombre de la compañía de streaming. */
    public String name;
    /** La lista de servicios de la compañía de streaming. */
    public ArrayList<Service> services;
    /** La lista de clientes de la compañía de streaming. */
    private ArrayList<StreamingCompanyClient> clients;
    /** Los servicios que tiene contratado cada cliente. */
    private Hashtable<StreamingCompanyClient, Service> servicePerClient;

    /**
     * Constructor único de una compañía de streaming. Le asigna un nombre y 
     * una lista de servicios a una compañía de streaming.
     * @param name el nombre de la compañía de streaming.
     * @param services la lista de servicios de la compañía de streaming.
     */
    public StreamingCompany(String name, ArrayList<Service> services) {
        this.name = name;
        this.services = services;
        servicePerClient = new Hashtable<>();
    }

    /**
     * Registra un cliente a la compañía de streaming. Simplemente lo agrega 
     * a la lista de clientes, y después asocia al cliente con un servicio en 
     * el diccionario de servicios por cliente.
     * @param c el cliente a registrar.
     * @param s el servicio asociado al cliente.
     */
    @Override
    public void registerClient(StreamingCompanyClient c, Service s) {
        clients.add(c);
        servicePerClient.put(c, s);
    }

    /**
     * Desuscribe a un cliente de la compañía de streaming. Simplemente lo 
     * elimina de la lista de clientes.
     * @param c el cliente a eliminar.
     */
    @Override
    public void removeClient(StreamingCompanyClient c) {
        clients.remove(c);
    }

    @Override
    public void notify(String message) {
        if (clients.size() > 0) 
            for (StreamingCompanyClient c : clients) 
                c.update(message);
    }

    /**
     * Le notifica su pago mensual a todos los clientes (asumiendo que todos
     * contrataron el servicio al mismo tiempo).
     */
    @Override
    public abstract void notifyPayment();

    /**
     * Le notifica de su registro a la compañía de streaming al cliente que se 
     * acaba de suscribir.
     */
    @Override
    public abstract void notifyRegister(StreamingCompanyClient c);

    /**
     * Le notifica de su desuscripción a la compañía de streaming al cliente que se 
     * acaba de desuscribir.
     */
    @Override
    public abstract void notifyUnregister(StreamingCompanyClient c);

    /**
     * Le hace el cobro a todos los clientes de la compañía por sus servicios.
     */
    public abstract void charge();

    /**
     * Simula que una compañía de streaming está reproduciendo algo de su 
     * repertorio de productos.
     */
    public abstract void play();
}