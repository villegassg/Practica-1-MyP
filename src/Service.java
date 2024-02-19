/**
 * Clase pública Service, define lo que es un servicio.
 */
public class Service {
    
    /** La descripción del producto. */
    String description;
    /** El costo del produto. */
    int cost;
    /** El tiempo en meses que lleva contratado el servicio. */
    int timeHired;

    /**
     * Constructor único, crea un servicio asignándole una descripción y un 
     * costo determinados.
     * @param description la descripción del servicio.
     * @param cost el costo del servicio.
     */
    public Service(String description, int cost) {
        this.description = description;
        this.cost = cost;
    }

    /**
     * Obtiene la descripción del servicio.
     * @return la descripción del servicio.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Obtiene el coste del servicio.
     * @return el coste del servicio.
     */
    public int getCost() {
        return cost;
    }

    /**
     * Obtiene el tiempo que lleva contratado el servicio.
     * @return el tiempo que lleva contratado el servicio.
     */
    public int getTimeHired() {
        return timeHired;
    }

    /**
     * Incrementa en uno el tiempo que lleva contrado el servicio.
     */
    public void increaseTimeHired() {
        timeHired+=1;
    }
}
