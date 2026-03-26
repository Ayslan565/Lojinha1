package service;

import model.Cliente;
import model.Produto;

import java.util.ArrayList;
import java.util.List;
import model.Pedido;

public class Lojinha {
public List<Cliente> clientes = new ArrayList<>();
public List<Produto> produtos = new ArrayList<>();

    public Lojinha() {
        this.clientes.add(new Cliente("Ana Silva", "1234", "11122233344", "Asa Sul", 10203040));
        this.clientes.add(new Cliente("Bruno Oliveira", "abcd", "55566677788", "Águas Claras", 50607080));
        this.clientes.add(new Cliente("Carla Souza", "qwer", "99900011122", "Guará", 90102030));
        this.clientes.add(new Cliente("Daniel Santos", "zxcv", "33344455566", "Ceilândia", 40506070));

        // Listagem de produtos (Catálogo simulado)
        this.produtos.add(new Produto("Teclado Mecânico RGB", 15, "Switch azul e retroiluminação", 250.00f));
        this.produtos.add(new Produto("Mouse Gamer 12000 DPI", 20, "Sensor óptico de alta precisão", 120.50f));
        this.produtos.add(new Produto("Monitor 24 Polegadas", 5, "Frequência de 144Hz Full HD", 1150.00f));
        this.produtos.add(new Produto("Headset Gamer 7.1", 10, "Som surround e microfone removível", 320.00f));


    }
    
    public void fazerPedido(Cliente cliente, Produto produto) {
    System.out.println("[LOJA] Iniciando compra para " + cliente.getNome());

    // 1. Criar o Carrinho e adicionar o produto escolhido
    model.Carrinho carrinho = new model.Carrinho(1); 
    carrinho.adicionarProduto(produto);
    System.out.println("[CARRINHO] Item adicionado: " + produto.getNome());

    // 2. Criar o Pedido associado ao Cliente e ao Carrinho
    // (Ajustamos o construtor do Pedido para receber o Carrinho se preferir)
    model.Pedido novoPedido = new model.Pedido(1001, cliente);
    novoPedido.adicionarItem(produto); 

    // 3. O Singleton cobra o valor vindo do CARRINHO
    model.Conexao gateway = model.Conexao.getInstancia();
    gateway.cobrar(carrinho.getPrecoTotal());

    novoPedido.setStatus("PAGO");
    System.out.println("[LOJA] Checkout concluído. Status: " + novoPedido.getStatus());
}
}