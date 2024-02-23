/**
 * Clase pública Recommendation. Básicamente es una cadena que contendrá una 
 * recomendación de una película o una canción según sea la compañía que emite 
 * la recomendación.
 */
public class Recommendation {
    /** La descripción de la recomendación. */
    private String description;

    /**
     * Constructor único, define la descripción de la recomendación.
     * @param description la descripción de la recomendación.
     */
    public Recommendation(String description) {
        this.description = description;
    }

    /**
     * Permite obtener la descripción de la recomendación.
     * @return la recomendación.
     */
    public String getDescription() {
        return description;
    }
}
