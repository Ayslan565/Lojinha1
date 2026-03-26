package model;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private int idCarrinho;
    private List<Produto> produtos = new ArrayList<>();
    private float precoTotal;

    public Carrinho(int id) {
        this.idCarrinho = id;
        this.precoTotal = 0.0f;
    }

    public void adicionarProduto(Produto p) {
        this.produtos.add(p);
        this.precoTotal += p.getPreco();
    }

    public float getPrecoTotal() {
        return precoTotal;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}