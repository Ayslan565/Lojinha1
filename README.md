Relatório Técnico: Simulação de Sistema da Lojinha
1. Descrição Geral
   Este projeto consiste em uma simulação programática de um sistema de vendas online, desenvolvido em conformidade com os princípios da Orientação a Objetos. O sistema abrange as funcionalidades core de identificação de usuários, gerenciamento de catálogo de produtos, formalização de pedidos e integração com um serviço de pagamento.

2. Estrutura do Projeto
   A organização do código segue a segregação por responsabilidades em pacotes distintos, garantindo a manutenibilidade do monólito:

Pacote model: Define as entidades de dados e objetos de valor.

Cliente: Armazena dados cadastrais e credenciais do usuário.

Produto: Define as propriedades técnicas e comerciais dos itens.

Pedido: Responsável pelo agrupamento de itens e vínculo com o consumidor.

Conexao: Classe designada para a integração com serviços externos de pagamento.

Pacote service: Implementa a lógica de negócio e as regras operacionais.

Loja: Atua como o controlador central, gerenciando as listas de dados e fluxos de compra.

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

4.1 Justificativa Técnica
A escolha do Singleton para este componente fundamenta-se nos seguintes pontos:

Unicidade de Instância: Garante que exista apenas um ponto de acesso à comunicação com o provedor de pagamento, evitando múltiplas instâncias concorrentes.

Gestão de Recursos: Reduz o overhead de memória e processamento ao evitar a criação repetitiva de objetos de conexão pesados.

Sincronização: O uso de métodos sincronizados (synchronized) assegura que o acesso global à instância única seja thread-safe, prevenindo condições de corrida em ambientes multitarefa.

5. Requisitos Técnicos
   Linguagem: Java.

Paradigma: Orientação a Objetos.

Gerenciamento de Memória: Uso de coleções dinâmicas para simulação de base de dados.

Padrões de Projeto: Singleton (Creational Pattern).

6. Fluxo de Execução
   Inicialização: O sistema carrega os dados estáticos de clientes e produtos.

Listagem: A aplicação percorre o catálogo e exibe os itens disponíveis.

Identificação: O sistema valida a identidade do cliente logado.

Processamento: Ao criar um pedido, a lógica de negócio invoca a instância única do Singleton de pagamento para processar a transação financeira.