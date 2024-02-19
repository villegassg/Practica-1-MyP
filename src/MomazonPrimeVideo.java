import java.util.ArrayList;

/**
 * Compañía de streaming MomazonPrimeVideo. Hereda de StreamingCompany.
 */
public class MomazonPrimeVideo extends StreamingCompany {
    
    /**
     * Constructor único de una compañía de streaming. Le asigna un nombre y 
     * una lista de servicios a una compañía de streaming.
     * @param name el nombre de la compañía de streaming.
     * @param services la lista de servicios de la compañía de streaming.
     */
    public MomazonPrimeVideo(String name, ArrayList<Service> services) {
        super(name, services);
    }
    
    /**
     * Le notifica su pago mensual a todos los clientes (asumiendo que todos
     * contrataron el servicio al mismo tiempo).
     */
    public void notifyPayment() {

    }

    /**
     * Le notifica de su registro a la compañía de streaming al cliente que se 
     * acaba de suscribir.
     */
    public void notifyRegister(Client c) {

    }

    /**
     * Le notifica de su desuscripción a la compañía de streaming al cliente que se 
     * acaba de desuscribir.
     */
    public void notifyUnregister(Client c) {

    }

    /**
     * Le hace el cobro a todos los clientes de la compañía por sus servicios.
     */
    public void charge() {

    }
}