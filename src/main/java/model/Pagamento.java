package model;

import java.util.Date;

public class Pagamento {
    private int idPagamento;
    private Date dataPagamento;
    private String statusPagamento;
    private float valorTotal;

    public Pagamento(int id, float valor) {
        this.idPagamento = id;
        this.valorTotal = valor;
        this.dataPagamento = new Date();
        this.statusPagamento = "APROVADO";
    }

    public String getStatusPagamento() { return statusPagamento; }
}