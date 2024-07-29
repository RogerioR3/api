public class Memento {
    private Pedido pedido;

    public Memento(Pedido pedido) {
        this.pedido = pedido;
    }

    public Pedido getPedido() {
        return pedido;
    }
}
