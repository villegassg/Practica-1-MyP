/**
 * Clase pública Service, define lo que es un servicio.
 */
public class Service {
    
    /** La compañía que posee el servicio. */
    String streamingCompany;
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
    public Service(String streamingCompany, String description, int cost) {
        this.streamingCompany = streamingCompany;
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

    /**
     * Nos dice si un servicio es igual a otro.
     */
    @Override
    public boolean equals(Object o) {
        if (o.getClass() != Service.class) return false;
        Service s = (Service)o;
        return this.streamingCompany.equals(s.streamingCompany) &&
                this.description.equals(s.description) &&
                this.cost == s.cost &&
                this.timeHired == s.timeHired;
    }
}
