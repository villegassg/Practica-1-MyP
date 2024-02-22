import java.util.ArrayList;

/**
 * Clase pública Bank. Simula la existencia de un banco que efectuará el cobro de 
 * algún servicio de Streaming a los clientes.
 */
public class Bank {
    
    /** La Lista de clientes del banco. */
    private ArrayList<Client> clients;

    /**
     * Constructor único. Únicamente inicia la lista de clientes.
     */
    public Bank() {
        this.clients = new ArrayList<>();
    }

    public void add(Client c) {
        clients.add(c);
    }

    /**
     * Le cobra a un cliente una cantidad determinada.
     * @param c el cliente.
     * @param amount la cantidad.
     */
    public boolean charge(Client c, int amount) {
        if (clients.contains(c)) 
            if (c.money >= amount) {
                c.pay(amount);
                return true;
            } else return false;
        return false;
    }
}
