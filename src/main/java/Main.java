import service.Lojinha;
import model.Cliente;
import model.Produto;

public class Main {
    public static void main(String[] args) {
       
        Lojinha apiLoja = new Lojinha();

        System.out.println("========== BEM-VINDO À LOJINHA ONLINE ==========");

        System.out.println("\n[API] Listando produtos disponíveis:");
        for (Produto p : apiLoja.produtos) {
            System.out.println("- " + p.getNome() + ": R$ " + p.getPreco());
        }


        Cliente clienteLogado = apiLoja.clientes.get(0);
        System.out.println("\n[API] Cliente identificado: " + clienteLogado.getNome());


        Produto produtoEscolhido = apiLoja.produtos.get(0);

        System.out.println("\n[API] Criando pedido para: " + produtoEscolhido.getNome());

        apiLoja.fazerPedido(clienteLogado, produtoEscolhido);

        System.out.println("\n================================================");
    }
}
