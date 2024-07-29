public class Originator {
    private Pedido pedido;
    
    public Originator(Pedido pedido) {
        this.pedido = pedido;
    }

    public void setProdutos(Pedido pedido) {
        this.pedido = pedido;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public Memento save() {
        return new Memento(pedido);
    }

    public void restore(Memento memento) {
        pedido = memento.getPedido();
    }
}
