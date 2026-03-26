package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
    private int idPedido;
    private Date data;
    private String status;
    private Cliente cliente; 
    private List<Produto> itens = new ArrayList<>();

    public Pedido(int idPedido, Cliente cliente) {
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.data = new Date();
        this.status = "AGUARDANDO PAGAMENTO";
    }

    public void adicionarItem(Produto p) {
        this.itens.add(p);
    }

    public float calcularTotal() {
        float total = 0;
        for (Produto p : itens) {
            total += p.getPreco();
        }
        return total;
    }

    public void setStatus(String status) { this.status = status; }
    public String getStatus() { return status; }
}