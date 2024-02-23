import java.util.ArrayList;

/**
 * Compañía de streaming Memeflix. Hereda de StreamingCompany.
 */
public class Memeflix extends StreamingCompany {

    private StrategyMemeflix cobrador;
    
    /**
     * Constructor único de una compañía de streaming. Le asigna un nombre y 
     * una lista de servicios a una compañía de streaming.
     * @param name el nombre de la compañía de streaming.
     * @param services la lista de servicios de la compañía de streaming.
     */
    public Memeflix(String name, ArrayList<Service> services, Bank bank) {
        super(name, services, bank);
    }
    
    /**
     * Le notifica su pago mensual a todos los clientes (asumiendo que todos
     * contrataron el servicio al mismo tiempo).
     * @param c el cliente a notificar.
     * @param amount la cantidad a pagar por el servicio.
     */
    public void notifyPayment(Client c, int amount) {
        String payment = String.format("you have to pay $%.2f for your service with %s.", 
            (float)amount, this.name);
        c.update(payment);
    }

    /**
     * Le notifica de su registro a la compañía de streaming al cliente que se 
     * acaba de suscribir.
     */
    public void notifyRegister(Client c) {
        String register = "welcome to " + this.name + 
            ". We hope you have the best experience with us.";
        c.update(register);
    }

    /**
     * Le notifica de su desuscripción a la compañía de streaming al cliente que se 
     * acaba de desuscribir.
     */
    public void notifyUnregister(Client c) {
        String unregister = "we're sad you have to leave us :(.";
        c.update(unregister);
    }

    /**
     * Le notifica a un cliente su bienvenida de vuelta después de haber recontratado 
     * un servicio de streaming.
     * @param c el cliente a notificar.
     */
    public void notifyWelcomeBack(Client c) {
        String welcomeBack = "welcome back to " + this.name + 
            ". We hope you stay this time :').";
        c.update(welcomeBack);
    }

    /**
     * Le notifica a los clientes sobre la recomendación del mes.
     */
    public void notifyRecommendation() {
        int movie = random.nextInt(recommendations.size());
        String recommendation = String.format("%s recommends you to watch %s.", 
            this.name, recommendations.get(movie).getDescription());
        notify(recommendation);
    }

    /**
     * Le hace el cobro a todos los clientes de la compañía por sus servicios.
     */
    public void charge() {
        ArrayList<Client> toRemove = new ArrayList<>();
        for (Client c : clients) {
            Service s = servicePerClient.get(c);
            if (s.equals(services.get(0))) {
                cobrador = new MemeflixOneDevice();
                boolean payment = cobrador.charge(c, 120, bank);
                notifyPayment(c, 120);
                if (!payment) toRemove.add(c);
            } else if (s.equals(services.get(1))) {
                cobrador = new MemeflixTwoDevices();
                boolean payment = cobrador.charge(c, 170, bank);
                notifyPayment(c, 170);
                if (!payment) toRemove.add(c);
            } else if (s.equals(services.get(2))) {
                cobrador = new MemeflixFourDevices();
                boolean payment = cobrador.charge(c, 200, bank);
                notifyPayment(c, 200);
                if (!payment) toRemove.add(c);
            }
        }

        for (Client c : toRemove)
            removeClient(c);
    }

    /**
     * Simula que la compañía Memeflix está reproduciendo una película de prueba 
     * en su plataforma.
     */
    public void play() {
        String play = this.name + " is playing a movie trial. Look out for it!";
        notify(play);
    }

    public void increseTime() {
        for (Client c : clients) {
            Service s = servicePerClient.get(c);
            s.increaseTimeHired();
        }
    }
}