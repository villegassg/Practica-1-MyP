/**
 * Interfaz pública StreamingCompanySubject. Define el comportamiento de 
 * sujeto observable a las distintas compañías de streaming.
 */
public interface StreamingCompanySubject {

    /**
     * Registra al cliente a un servicio de streaming.
     * @param c el cliente a registrar.
     */
    public void registerClient(Client c);

    /**
     * Desuscribe al cliente de un servicio de streaming.
     * @param c el cliente a desuscribir.
     */
    public void removeClient(Client c);
}