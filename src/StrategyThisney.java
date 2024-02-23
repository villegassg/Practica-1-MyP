/**
 * Interfaz pública StrategyThisney. Simula las estrategias de cobro de los 
 * distintos servicios que ofrece Thisney. 
 */
public interface StrategyThisney {
    
    /**
     * Cobra por algún servicio que ofrece Thisney.
     */
    public boolean charge(Client c, int amount, Bank bank);
}