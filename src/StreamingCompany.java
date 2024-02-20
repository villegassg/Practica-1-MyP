import java.util.ArrayList;

/**
 * Clase pública StreamingCompany, define el comportamiento estándar 
 * de una compañía de streaming.
 */
public abstract class StreamingCompany implements StreamingCompanyBehavior, StreamingCompanySubject {
    
    /** El nombre de la compañía de streaming. */
    String name;
    /** La lista de servicios de la compañía de streaming. */
    ArrayList<Service> services;
    /** La lista de clientes de la compañía de streaming. */
    ArrayList<Client> clients;

    /**
     * Constructor único de una compañía de streaming. Le asigna un nombre y 
     * una lista de servicios a una compañía de streaming.
     * @param name el nombre de la compañía de streaming.
     * @param services la lista de servicios de la compañía de streaming.
     */
    public StreamingCompany(String name, ArrayList<Service> services) {
        this.name = name;
        this.services = services;
    }

    /**
     * Registra un cliente a la compañía de streaming. Simplemente lo agrega 
     * a la lista de clientes.
     * @param c el cliente a registrar.
     */
    public void registerClient(Client c) {

    }

    /**
     * Desuscribe a un cliente de la compañía de streaming. Simplemente lo 
     * elimina de la lista de clientes.
     * @param c el cliente a eliminar.
     */
    public void removeClient(Client c) {

    }

    /**
     * Le notifica su pago mensual a todos los clientes (asumiendo que todos
     * contrataron el servicio al mismo tiempo).
     */
    public abstract void notifyPayment();

    /**
     * Le notifica de su registro a la compañía de streaming al cliente que se 
     * acaba de suscribir.
     */
    public abstract void notifyRegister(Client c);

    /**
     * Le notifica de su desuscripción a la compañía de streaming al cliente que se 
     * acaba de desuscribir.
     */
    public abstract void notifyUnregister(Client c);
    //---------------------------------------------------------------------------------
    @Override
    public void applyPromotion(Client c) {
        // Aplicar 3 meses gratis y 120 pesos de descuento
        LocalDate threeMonthsAgo = LocalDate.now().minusMonths(3);
        if (c.getServiceStartDate().isBefore(threeMonthsAgo)) {
            c.setPromotionApplied(true); // Un flag para indicar que la promoción ya fue aplicada
            c.update("A promotional discount has been applied to your account.");
        }
    }

    @Override
    public void chargeClient(Client c) {
        // Realizar el cobro considerando la promoción
        if (c.isPromotionApplied()) {
            // Si ya se aplicó la promoción, cobrar con descuento
            c.setMoney(c.getMoney() - calculateDiscountedPrice());
        } else {
            // Si no, cobrar el precio completo
            c.setMoney(c.getMoney() - calculateFullPrice());
        }
        notifyPayment();
    }
    //-----------------------------------------------------------------------------------------------
    private float calculateFullPrice() {
    float total = 0;
    for (Service service : services) {
        total += service.getCost();
    }
    return total;
}

private float calculateDiscountedPrice() {
    float fullPrice = calculateFullPrice();
    // Asegúrate de que el descuento no lleve el precio a ser negativo
    return Math.max(fullPrice - 120, 0);
}

    /**
     * Le hace el cobro a todos los clientes de la compañía por sus servicios.
     */
    public abstract void charge();
    
}
