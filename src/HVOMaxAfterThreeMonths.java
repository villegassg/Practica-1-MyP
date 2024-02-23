/**
 * Simula la estrategia de cobro de HVOMax por su servicio de streaming cuando 
 * lleva contratado más de tres meses.
 */
public class HVOMaxAfterThreeMonths implements StrategyHVOMax {
    
    /**
     * Mediante un banco le cobra a un cliente una cantidad determinada.
     * @param c el cliente.
     * @param amount la cantidad.
     * @param bank el banco.
     */
    public boolean charge(Client c, int amount, Bank bank) {
        return bank.charge(c, amount);
    }
}