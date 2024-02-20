import java.util.ArrayList;

/**
 * Compañía de streaming Momazon Prime Video. Hereda de StreamingCompany.
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
    @Override
    public void notifyPayment() {
        for (Client client : clients) {
            System.out.println("Se ha cobrado el servicio de Momazon Prime Video a " + client.getName());
        }
    }

    /**
     * Le notifica de su registro a la compañía de streaming al cliente que se 
     * acaba de suscribir.
     */
    @Override
    public void notifyRegister(Client c) {
        System.out.println("El cliente " + c.getName() + " se ha registrado en Momazon Prime Video.");
    }

    /**
     * Le notifica de su desuscripción a la compañía de streaming al cliente que se 
     * acaba de desuscribir.
     */
    @Override
    public void notifyUnregister(Client c) {
        System.out.println("El cliente " + c.getName() + " se ha desuscrito de Momazon Prime Video.");
    }

    /**
     * Le hace el cobro a todos los clientes de la compañía por sus servicios.
     */
    @Override
    public void charge() {
        for (Client client : clients) {
            System.out.println("Cobro mensual de Momazon Prime Video a " + client.getName());
            client.decreaseBalance(150); // Se cobra $150 por el servicio mensual de Momazon Prime Video
        }
    }
}
