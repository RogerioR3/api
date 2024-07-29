import java.math.BigDecimal;

public class Item {
    private Integer idItem;
    private int quantidade;
    private BigDecimal precoUnitario;
    
    
    public Item (Integer idItem, int quantidade, BigDecimal precoUnitario) {
        this.idItem = idItem;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        
    }
    
    public BigDecimal calcularSubtotal() {
        String xText = this.quantidade + "";
        return new BigDecimal(xText).multiply(precoUnitario);
    }
    
    // Getters and Setters
    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }
}
