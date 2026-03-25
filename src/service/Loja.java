package service;

import model.Cliente;
import model.Produto;

import java.util.ArrayList;
import java.util.List;

public class Loja {
public List<Cliente> clientes = new ArrayList<>();
public List<Produto> produtos = new ArrayList<>();

    public Loja() {
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
        System.out.println("[LOJA] Registando pedido para " + cliente.getNome());

        // Uso do Singleton de Pagamento
        model.Conexao pagamento = model.Conexao.getInstancia();
        pagamento.cobrar(produto.getPreco());

        System.out.println("[LOJA] Pedido finalizado com sucesso!");
    }
}
