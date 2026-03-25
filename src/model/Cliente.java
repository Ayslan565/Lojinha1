package model;

public class Cliente {
    private String Nome;
    private String Senha;
    private String CPF;
    private String Endereco;
    private int cartao;

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String endereco) {
        Endereco = endereco;
    }

    public int getCartao() {
        return cartao;
    }

    public void setCartao(int cartao) {
        this.cartao = cartao;
    }

    public Cliente(String nome, String senha, String CPF, String endereco, int cartao) {
        Nome = nome;
        Senha = senha;
        this.CPF = CPF;
        Endereco = endereco;
        this.cartao = cartao;
    }
}
