/**
 * Interfaz pública StrategyMemeflix. Simula las estrategias de cobro de los 
 * distintos servicios que ofrece Memeflix. 
 */
public interface StrategyMemeflix {
    
    /**
     * Cobra por algún servicio que ofrece Momazon.
     */
    public boolean charge(Client c, int amount, Bank bank);
}
