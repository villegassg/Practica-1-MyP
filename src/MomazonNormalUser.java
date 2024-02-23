/**
 * Simula la estrategia de cobro de Momazon por su servicio de streaming cuando 
 * está contratado por un usuario normal.
 */
public class MomazonNormalUser implements StrategyMomazon {
    
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