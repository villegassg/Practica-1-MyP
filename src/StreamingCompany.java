import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

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
    protected ArrayList<Client> clients;
    /** Los servicios que tiene contratado cada cliente. */
    protected Hashtable<Client, Service> servicePerClient;
    /** Las recomendaciones del mes. */
    public ArrayList<Recommendation> recommendations;
    /** La recomendación a recomendar. */
    public String recommendationMonth;
    /** El generador de números aleatorios para recomendar una película. */
    protected Random random;
    /** 
     * El banco con el que los servicios de streaming cobrarán por sus 
     * servicios.
     */
    protected Bank bank;


    /**
     * Constructor único de una compañía de streaming. Le asigna un nombre y 
     * una lista de servicios a una compañía de streaming.
     * @param name el nombre de la compañía de streaming.
     * @param services la lista de servicios de la compañía de streaming.
     */
    public StreamingCompany(String name, ArrayList<Service> services, Bank bank) {
        this.name = name;
        this.services = services;
        clients = new ArrayList<>();
        servicePerClient = new Hashtable<>();
        recommendations = new ArrayList<>();
        this.bank = bank;
        random = new Random();
    }

    /**
     * Registra un cliente a la compañía de streaming. Simplemente lo agrega 
     * a la lista de clientes, y después asocia al cliente con un servicio en 
     * el diccionario de servicios por cliente.
     * @param c el cliente a registrar.
     * @param s el servicio asociado al cliente.
     */
    @Override
    public void registerClient(Client c, Service s) {
        if(clients.contains(c)) {
            notifyChangeService(c, s.getDescription());
            servicePerClient.put(c, s);
        } else if (servicePerClient.containsKey(c)) {
            if (!s.equals(servicePerClient.get(c)))
                servicePerClient.put(c, s);
            notifyWelcomeBack(c);
        } else {
            clients.add(c);
            servicePerClient.put(c, s);
            notifyRegister(c);
        }
    }

    /**
     * Desuscribe a un cliente de la compañía de streaming. Simplemente lo 
     * elimina de la lista de clientes.
     * @param c el cliente a eliminar.
     */
    @Override
    public void removeClient(Client c) {
        clients.remove(c);
        notifyUnregister(c);
    }

    /**
     * Le notifica a los clientes sobre un mensaje en específico.
     * @param message el mensaje a notificar.
     */
    @Override
    public void notify(String message) {
        if (clients.size() > 0) 
            for (Client c : clients) 
                c.update(message);
    }

    /**
     * Le notifica su pago mensual a todos los clientes (asumiendo que todos
     * contrataron el servicio al mismo tiempo).
     * @param c el cliente a notificar.
     * @param amount la cantidad a pagar.
     */
    @Override
    public abstract void notifyPayment(Client c, int amount);

    /**
     * Le notifica de su registro a la compañía de streaming al cliente que se 
     * acaba de suscribir.
     * @param c el cliente a notificar.
     */
    @Override
    public abstract void notifyRegister(Client c);

    /**
     * Le notifica de su desuscripción a la compañía de streaming al cliente que se 
     * acaba de desuscribir.
     * @param c el cliente a notificar.
     */
    @Override
    public abstract void notifyUnregister(Client c);

    /**
     * Le notifica a un cliente su bienvenida de vuelta después de haber recontratado 
     * un servicio de streaming.
     * @param c el cliente a notificar.
     */
    @Override
    public abstract void notifyWelcomeBack(Client c);

    /**
     * Le notifica a un cliente sobre el cambio de su servicio.
     * @param c el cliente.
     * @param s la descripción de su nuevo servicio.
     */
    @Override
    public abstract void notifyChangeService(Client c, String s);

    /**
     * Le notifica a los clientes sobre la recomendación del mes.
     */
    @Override
    public abstract void notifyRecommendation();

    /**
     * Agrega una recomendación a la lista de recomendaciones.
     * @param r la recomendación a agregar.
     */
    @Override
    public void addRecommendation(Recommendation r) {
        recommendations.add(r);
    }

    /**
     * Le hace el cobro a todos los clientes de la compañía por sus servicios.
     */
    public abstract void charge();

    /**
     * Simula que una compañía de streaming está reproduciendo algo de su 
     * repertorio de productos.
     */
    @Override
    public abstract void play();

    /**
     * Simula el paso del tiempo en las compañías.
     */
    @Override
    public abstract void increseTime();
}