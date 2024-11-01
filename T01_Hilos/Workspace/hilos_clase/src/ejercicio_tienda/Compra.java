package ejercicio_tienda;

class Compra extends Thread {
    private Cliente cliente;
    private Tienda tienda;

    public Compra(Cliente cliente, Tienda tienda) {
        this.cliente = cliente;
        this.tienda = tienda;
    }

    @Override
    public void run() {
        tienda.comprar(cliente);
    }
}
