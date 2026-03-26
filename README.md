Relatório Técnico: Simulação de Sistema da Lojinha
1. Descrição Geral
   Este projeto consiste em uma simulação programática de um sistema de vendas online, desenvolvido em conformidade com os princípios da Orientação a Objetos. O sistema abrange as funcionalidades core de identificação de usuários, gerenciamento de catálogo de produtos, formalização de pedidos e integração com um serviço de pagamento.

2. Estrutura do Projeto
   A organização do código segue a segregação por responsabilidades em pacotes distintos, garantindo a manutenibilidade do monólito:

Pacote model: Define as entidades de dados e objetos de valor.

Cliente: Armazena dados cadastrais e credenciais do usuário.

Produto: Define as propriedades técnicas e comerciais dos itens.

Pedido: Responsável pelo agrupamento de itens e vínculo com o consumidor.

Pagamento: Modela a transação financeira, tendo valor, data e status.

Conexao: Classe designada para a integração com serviços externos de pagamento.

Carrinho: Gerencia o estado do carrinho de compras permitidno a adição e 

Pacote service: Implementa a lógica de negócio e as regras operacionais.

Loja: Atua como a camada de serviço (API), contendo a lógica de negócio.
É responsável por: 
           . Gerenciar clientes e produtos
           . Criar carrinho e pedido;
           . Processar pagamentos
   
Pacote Raiz:

Main: Ponto de entrada da aplicação que orquestra a execução da simulação.

3. Decisões Arquiteturais
   3.1 Arquitetura Monolítica Cliente-Servidor
   A aplicação foi projetada como um monólito onde a distinção entre cliente e servidor ocorre em nível lógico:

Camada de Cliente: Representada pela classe Main, simula as requisições de um usuário final ou de uma interface externa.

Camada de Servidor (API): Representada pela classe Loja, que processa as solicitações, valida dados e gerencia o estado da aplicação.

3.2 Persistência e Identificação Estática
Para fins de simulação, o sistema utiliza armazenamento em memória através de coleções (ArrayList). A identificação de clientes e a carga do catálogo de produtos ocorrem de forma estática durante a instanciação da classe Loja.

4. Implementação do Padrão Singleton

O padrão de projeto Singleton foi aplicado exclusivamente na classe Conexao.java, responsável pela interface com o sistema de pagamentos.

4.1 Justificativa

A escolha do Singleton para este componente fundamenta-se nos seguintes pontos:

Unidade de Instância: Garante que exista apenas um ponto de acesso à comunicação com o provedor de pagamento, evitando múltiplas instâncias concorrentes.
Gestão de Recursos: Reduz o overhead de memória e processamento ao evitar a criação repetitiva de objetos de conexão.
Sincronização: O uso de métodos sincronizados (synchronized) assegura que o acesso global à instância única seja thread-safe, prevenindo condições de corrida.

4.2 Detalhes da Implementação

A classe Conexao foi implementada utilizando o padrão Singleton clássico:

public class Conexao {
    private static Conexao instancia;

    private Conexao(){
        System.out.println("Conexão Externa [SUCESSO!]");
    }

    public static synchronized Conexao getInstance(){
        if (instancia == null){
            instancia = new Conexao();
        }
        return instancia;
    }
}

    
Características da implementação:
Construtor privado impede instanciamento externo
Instância armazenada em atributo estático
Método getInstance() controla a criação e acesso
Uso de synchronized garante segurança em ambiente concorrente

4.3 Uso no Fluxo do Sistema

Durante o processamento de um pedido, a aplicação utiliza a instância única da classe Conexao para realizar a comunicação com o sistema de pagamento:

Conexao conexao = Conexao.getInstance();
boolean status = conexao.processamentoPagamento(valor);

Esse processo ocorre na etapa de finalização da compra (checkout), sendo responsável por determinar se o pedido será confirmado ou rejeitado.

4.4 Observação Técnica

Durante a análise da implementação, foi identificado que o método de processamento de pagamento não retornava corretamente o status de aprovação.

Correção aplicada:

public boolean processamentoPagamento(double valor){
    if (valor > 0){
        System.out.println("Transação aprovada por provedor externo");
        return true;
    }
    return false;
}

Essa correção garante a consistência do fluxo de decisão do sistema.

4.5 Conclusão

A aplicação do padrão Singleton na classe Conexao assegura um controle eficiente sobre a comunicação com o sistema externo de pagamento, promovendo economia de recursos, consistência e organização arquitetural.


5. Requisitos Técnicos
   Linguagem: Java.

Paradigma: Orientação a Objetos.

Gerenciamento de Memória: Uso de coleções dinâmicas para simulação de base de dados.

Padrões de Projeto: Singleton (Creational Pattern).

6. Fluxo de Execução

Inicialização: O sistema carrega os dados estáticos de clientes e produtos.

Listagem: A aplicação percorre o catálogo e exibe os itens disponíveis.

Identificação: O sistema valida a identidade do cliente logado.

Carrinho: Um carrinho é criado e recebe os produtos selecionados.

Pedido: Um pedido é gerado a partir dos itens presentes no carrinho.

Processamento: Ao criar um pedido, a lógica de negócio invoca a instância única do Singleton de pagamento para processar a transação financeira.

Finalização: O pedido é concluído com status "PAGO".

7. Conclusão
O sistema atende aos requisitos propostos, implementando uma simulação funcional de uma loja online.
A utilização do padrão Singleton na comunicação com o sistema de pagamento garante eficiência, organização e controle de recursos, enquanto a estrutura orientada a objetos facilita a manutenção e evolução do sistema.
