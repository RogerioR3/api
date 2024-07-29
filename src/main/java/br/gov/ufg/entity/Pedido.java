import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;

public class Pedido {
    private Integer idPedido;
    private Date dataPedido;
    private String status;
    private List<Item> itens;
    
    
    public Pedido (Integer idPedido, Date dataPedido, String status) {
        this.idPedido = idPedido;
        this.dataPedido = dataPedido;
        this.status = status;
        this.itens = new ArrayList<>();
    }
    
    public BigDecimal calcularTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (Item item : itens) {
            total = total.add(item.calcularSubtotal());
        }
        return total;
    }
    
    public void atualizarStatus(String status) {
        this.status = status;
    }
    
    // Adiciona um item ao pedido
    public void adicionarItem(Item item) {
        this.itens.add(item);
    }

    // Remove um item do pedido
    public void removerItem(Item item) {
        this.itens.remove(item);
    }
    
    // Getters and Setters
    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
}
