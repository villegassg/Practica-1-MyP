/**
 * Interfaz pública StreamingCompanyBehavior. Define el comportamiento 
 * estándar de una compañía de streaming, pero haciendo posible la 
 * diferencia de comportamiento entre las distintas compañías.
 */
public interface StreamingCompanyBehavior {

    /**
     * Le notifica a los clientes el pago de su servicio de streaming.
     */
    public void notifyPayment();

    /**
     * Le notifica a un cliente de su registro a una compañía de streaming.
     * @param c el cliente a notificar.
     */
    public void notifyRegister(StreamingCompanyClient c);

    /**
     * Le notifica a un cliente de su desuscripción a una compañía de 
     * streaming.
     * @param c el cliente a notificar.
     */
    public void notifyUnregister(StreamingCompanyClient c);    
}