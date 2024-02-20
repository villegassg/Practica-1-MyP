/**
 * Interfaz pública StreamingCompanySubject. Define el comportamiento de 
 * sujeto observable a las distintas compañías de streaming.
 */
public interface StreamingCompanySubject {

    /**
     * Registra al cliente a un servicio de streaming.
     * @param c el cliente a registrar.
     * @param s el servicio asociado al cliente
     */
    public void registerClient(StreamingCompanyClient c, Service s);

    /**
     * Desuscribe al cliente de un servicio de streaming.
     * @param c el cliente a desuscribir.
     */
    public void removeClient(StreamingCompanyClient c);

    /**
     * Le notifica a los clientes sobre un mensaje en específico.
     * @param message el mensaje a notificar.
     */
    public void notify(String message);
}