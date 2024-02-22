/**
 * Interfaz pública StrategyHVOMax. Simula las estrategias de cobro de los 
 * distintos servicios que ofrece HVOMax. 
 */
public interface StrategyHVOMax {
    
    /**
     * Cobra por algún servicio que ofrece HVOMax.
     */
    public boolean charge(Client c, int amount, Bank bank);
}
