/**
 * Simula la estrategia de cobro de Memeflix por su servicio de streaming cuando 
 * está contratado para dos dispositivo.
 */
public class MemeflixTwoDevices implements StrategyMemeflix {
    
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