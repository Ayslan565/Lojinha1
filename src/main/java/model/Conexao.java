package model;

public class Conexao {
    private static Conexao instancia;

    private Conexao() {
        System.out.println("[SISTEMA EXTERNO] Ligação ao Gateway de Pagamento estabelecida.");
    }

    public static synchronized Conexao getInstancia() {
        if (instancia == null) {
            instancia = new Conexao();
        }
        return instancia;
    }

    public void cobrar(float valor) {
        System.out.println("[SISTEMA EXTERNO] Processando pagamento de R$ " + valor + "...");
        System.out.println("[SISTEMA EXTERNO] Transação aprovada!");
    }
}
