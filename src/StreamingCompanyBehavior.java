/**
 * Interfaz pública StreamingCompanyBehavior. Define el comportamiento 
 * estándar de una compañía de streaming, pero haciendo posible la 
 * diferencia de comportamiento entre las distintas compañías.
 */
public interface StreamingCompanyBehavior {

    /**
     * Le notifica a los clientes el pago de su servicio de streaming.
     * @param amount la cantidad a pagar.
     */
    public void notifyPayment(Client c, int amount);

    /**
     * Le notifica a un cliente de su registro a una compañía de streaming.
     * @param c el cliente a notificar.
     */
    public void notifyRegister(Client c);

    /**
     * Le notifica a un cliente de su desuscripción a una compañía de 
     * streaming.
     * @param c el cliente a notificar.
     */
    public void notifyUnregister(Client c);

    /**
     * Le notifica al cliente su bienvenida de vuelta al recontratar un 
     * servicio de streaming.
     * @param c el cliente a notificar
     */
    public void notifyWelcomeBack(Client c);

    /**
     * Le notifica a los clientes sobre la recomendación del mes.
     */
    public void notifyRecommendation();

    /**
     * Agrega una recomendación a la lista de recomendaciones.
     * @param r la recomendación a agregar.
     */
    public void addRecommendation(Recommendation r);

    /**
     * Simula que una compañía de streaming está reproduciendo algo de su 
     * repertorio de productos.
     */
    public void play();

    /**
     * Simula el paso del tiempo en las compañías.
     */
    public void increseTime();
}