/**
 * Interfaz pública StreamingCompanyClient. Define el comportamiento de 
 * tipo "escucha" para los clientes de las compañias de streaming; les 
 * permite recibir "notificaciones" de las distintas compañías.
 */
public interface StreamingCompanyClient {

    /**
     * Actualiza la información que tiene el cliente sobre sus servicios 
     * de streaming.
     */
    public void update();
    
}