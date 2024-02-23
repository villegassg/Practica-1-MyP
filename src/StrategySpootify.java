/**
 * Interfaz pública StrategySpootify. Simula las estrategias de cobro de los 
 * distintos servicios que ofrece Spootify. 
 */
public interface StrategySpootify {
    
    /**
     * Cobra por algún servicio que ofrece Spootify.
     */
    public boolean charge(Client c, int amount, Bank bank);
}