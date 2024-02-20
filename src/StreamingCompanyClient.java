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
// Idea de Implemnetacion 
public class Client implements StreamingCompanyClient {
    // Atributos existentes...
    private LocalDate serviceStartDate;
    private boolean isPromotionApplied;

    // Constructor y métodos existentes...

    public LocalDate getServiceStartDate() {
        return serviceStartDate;
    }

    public void setServiceStartDate(LocalDate serviceStartDate) {
        this.serviceStartDate = serviceStartDate;
    }

    public boolean isPromotionApplied() {
        return isPromotionApplied;
    }

    public void setPromotionApplied(boolean promotionApplied) {
        isPromotionApplied = promotionApplied;
    }
}
