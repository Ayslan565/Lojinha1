import service.Loja;
import model.Cliente;
import model.Produto;

public class Main {
    public static void main(String[] args) {
        // 1. Iniciar a Simulação (O "Servidor" Monolítico)
        Loja apiLoja = new Loja();

        System.out.println("========== BEM-VINDO À LOJINHA ONLINE ==========");

        // 2. Funcionalidade: Listagem de Produtos
        System.out.println("\n[API] Listando produtos disponíveis:");
        for (Produto p : apiLoja.produtos) {
            System.out.println("- " + p.getNome() + ": R$ " + p.getPreco());
        }

        // 3. Funcionalidade: Identificação de Cliente
        // Simulamos o login pegando o primeiro cliente criado estaticamente
        Cliente clienteLogado = apiLoja.clientes.get(0);
        System.out.println("\n[API] Cliente identificado: " + clienteLogado.getNome());

        // 4. Funcionalidade: Criação de Pedido e Pagamento
        // O cliente escolhe o primeiro produto da lista
        Produto produtoEscolhido = apiLoja.produtos.get(0);

        System.out.println("\n[API] Criando pedido para: " + produtoEscolhido.getNome());

        apiLoja.fazerPedido(clienteLogado, produtoEscolhido);

        System.out.println("\n================================================");
    }
}