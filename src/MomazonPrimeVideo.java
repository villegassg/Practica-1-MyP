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
        String payment = "you have to pay for your service with " + this.name + ".";
        notify(payment);
    }

    /**
     * Le notifica de su registro a la compañía de streaming al cliente que se 
     * acaba de suscribir.
     */
    public void notifyRegister(StreamingCompanyClient c) {
        String register = "welcome to " + this.name + 
            ". We hope you have the best experience with us.";
        notify(register);
    }

    /**
     * Le notifica de su desuscripción a la compañía de streaming al cliente que se 
     * acaba de desuscribir.
     */
    public void notifyUnregister(StreamingCompanyClient c) {
        String unregister = "we're sad you have to leave us :(.";
        notify(unregister);
    }

    /**
     * Le hace el cobro a todos los clientes de la compañía por sus servicios.
     */
    public void charge() {

    }

    /**
     * Simula que la compañía MomazonPrimeVideo está reproduciendo una película 
     * de prueba en su plataforma.
     */
    public void play() {
        String play = this.name + " is playing a movie trial. Look out for it!";
        notify(play);
    }
}