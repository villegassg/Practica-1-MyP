/**
 * Interfaz pública StrategyMomazon. Simula las estrategias de cobro de los 
 * distintos servicios que ofrece Momazon. 
 */
public interface StrategyMomazon {
    
    /**
     * Cobra por algún servicio que ofrece Momazon.
     */
    public boolean charge(Client c, int amount, Bank bank);
}
