import java.util.List;
import java.util.Scanner;

public class SistemaView {
    private Sistema controller;
    private Scanner scanner;
    private String tipoUsuario;

    public SistemaView(Sistema controller) {
        this.controller = controller;
        scanner = new Scanner(System.in);
        tipoUsuario = "";
    }

    private void exibirMenuFuncionario() {
        System.out.println("----- Menu Funcionário -----");
        System.out.println("1. Adicionar Cliente");
        System.out.println("2. Remover Cliente");
        System.out.println("3. Listar Clientes");
        System.out.println("4. Editar Cliente");
        System.out.println("5. Adicionar Imóvel");
        System.out.println("6. Remover Imóvel");
        System.out.println("7. Listar Imóveis");
        System.out.println("8. Editar Imóvel");
        System.out.println("0. Sair");
        System.out.println("-----------------------------");
    }

    private void exibirMenuGerente() {
        System.out.println("----- Menu Gerente -----");
        System.out.println("1. Adicionar Cliente");
        System.out.println("2. Remover Cliente");
        System.out.println("3. Listar Clientes");
        System.out.println("4. Editar Cliente");
        System.out.println("5. Adicionar Imóvel");
        System.out.println("6. Remover Imóvel");
        System.out.println("7. Listar Imóveis");
        System.out.println("8. Editar Imóvel");
        System.out.println("9. Criar Contrato");
        System.out.println("10. Listar Contratos Ativos");
        System.out.println("11. Listar Contratos Terminados");
        System.out.println("12. Renovação de Contrato");
        System.out.println("13. Rescisão de Contrato");
        System.out.println("0. Sair");
        System.out.println("-------------------------");
    }

    private void realizarLogin() {
        System.out.println("Bem-vindo! Escolha o tipo de usuário:");
        System.out.println("1. Gerente");
        System.out.println("2. Funcionário");

        int opcao = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        if (opcao == 1) {
            tipoUsuario = "Gerente";
        } else if (opcao == 2) {
            tipoUsuario = "Funcionário";
        } else {
            System.out.println("Opção inválida. Encerrando o programa.");
            System.exit(0);
        }

        System.out.println("Digite o login:");
        String login = scanner.nextLine();
        System.out.println("Digite a senha:");
        String senha = scanner.nextLine();

        if (controller.validarLogin(login, senha, tipoUsuario)) {
            System.out.println("Login autenticado com sucesso!");
        } else {
            System.out.println("Login e/ou senha inválidos. Encerrando o programa.");
            System.exit(0);
        }
    }

    public void executar() {
        realizarLogin();

        if (tipoUsuario.equals("Gerente")) {
            executarGerente();
        } else if (tipoUsuario.equals("Funcionário")) {
            executarFuncionario();
        }
    }

    private void executarGerente() {
        int opcao;
        try {
            do {
                exibirMenuGerente();
                if (scanner.hasNextInt()) {
                    opcao = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer do scanner

                    switch (opcao) {
                        case 1:
                            adicionarCliente();
                            break;
                        case 2:
                            removerCliente();
                            break;
                        case 3:
                            listarClientes();
                            break;
                        case 4:
                            editarCliente();
                            break;
                        case 5:
                            adicionarImovel();
                            break;
                        case 6:
                            removerImovel();
                            break;
                        case 7:
                            listarImoveis();
                            break;
                        case 8:
                            editarImovel();
                            break;
                        case 9:
                            criarContrato();
                            break;
                        case 10:
                            listarContratosAtivos();
                            break;
                        case 11:
                            listarContratosTerminados();
                            break;
                        case 12:
                            renovarContrato();
                            break;
                        case 13:
                            rescindirContrato();
                            break;
                        case 0:
                            System.out.println("Saindo...");
                            break;
                        default:
                            System.out.println("Opção inválida. Tente novamente.");
                            break;
                    }
                } else {
                    System.out.println("Opção inválida. Tente novamente.");
                    scanner.nextLine(); // Limpar o buffer do scanner
                    opcao = -1; // Definir um valor inválido para opcao
                }

            } while (opcao != 0);
        } finally {
            scanner.close();
        }
    }

    private void executarFuncionario() {
        int opcao;
        try {
            do {
                exibirMenuFuncionario();
                if (scanner.hasNextInt()) {
                    opcao = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer do scanner

                    switch (opcao) {
                        case 1:
                            adicionarCliente();
                            break;
                        case 2:
                            removerCliente();
                            break;
                        case 3:
                            listarClientes();
                            break;
                        case 4:
                            editarCliente();
                            break;
                        case 5:
                            adicionarImovel();
                            break;
                        case 6:
                            removerImovel();
                            break;
                        case 7:
                            listarImoveis();
                            break;
                        case 8:
                            editarImovel();
                            break;
                        case 0:
                            System.out.println("Saindo...");
                            break;
                        default:
                            System.out.println("Opção inválida. Tente novamente.");
                            break;
                    }
                } else {
                    System.out.println("Opção inválida. Tente novamente.");
                    scanner.nextLine(); // Limpar o buffer do scanner
                    opcao = -1; // Definir um valor inválido para opcao
                }

            } while (opcao != 0);
        } finally {
            scanner.close();
        }
    }

    private void adicionarCliente() {
        System.out.println("Informe o nome do cliente:");
        String nome = scanner.nextLine();
        System.out.println("Informe o CPF do cliente:");
        String cpf = scanner.nextLine();
        System.out.println("Informe a renda do cliente:");
        double renda = scanner.nextDouble();
        System.out.println("Informe o CPF do cliente:");
        String email = scanner.nextLine();
        scanner.nextLine(); // Limpar o buffer do scanner
        Cliente cliente = new Cliente(nome, cpf, renda, email);
        controller.adicionarCliente(cliente);
        System.out.println("Cliente adicionado com sucesso!");
    }

    public void removerCliente() {
        System.out.println("Informe o CPF do cliente a ser removido:");
        String cpf = scanner.nextLine();
        Cliente cliente=controller.buscarClientePorCpf(cpf);
        controller.removerCliente(cliente);
    }

    public void listarClientes() {
        System.out.println("Clientes do sistema:");
        for (Cliente cliente : controller.getClientes()) {
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("CPF: " + cliente.getCpf());
            System.out.println("Renda: " + cliente.getRenda());
            System.out.println("Email: " + cliente.getEmail());
            System.out.println();
        }
    }

    private void editarCliente() {
        System.out.println("Editar Cliente");
        
        // Exibir lista de clientes
        List<Cliente> clientes = controller.getClientes();
        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);
            System.out.println((i + 1) + ". " + cliente.getNome());
        }
        
        // Solicitar ao usuário que escolha um cliente
        System.out.print("Digite o número do cliente que deseja editar: ");
        int numeroCliente = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        
        // Obter o cliente selecionado
        Cliente clienteSelecionado = clientes.get(numeroCliente - 1);

        System.out.println("1. Nome");
        System.out.println("2. CPF");
        System.out.println("3. Salário");
        System.out.println("4. Email");

        // Solicitar ao usuário que escolha uma opção
        System.out.print("Digite o número da opção que deseja editar: ");
        int numeroOpcao = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        switch (numeroOpcao) {
            case 1: // Editar nome
                System.out.print("Digite o novo nome: ");
                String novoNome = scanner.nextLine();
                clienteSelecionado.setNome(novoNome);
                System.out.println("Nome atualizado com sucesso!");
                break;
            case 2: // Editar CPF
                System.out.print("Digite o novo CPF: ");
                String novoCpf = scanner.nextLine();
                clienteSelecionado.setCpf(novoCpf);
                System.out.println("CPF atualizado com sucesso!");
                break;
            case 3: // Editar salário
                System.out.print("Digite o novo salário: ");
                double novoSalario = scanner.nextDouble();
                scanner.nextLine(); // Limpar o buffer
                clienteSelecionado.setSalario(novoSalario);
                System.out.println("Salário atualizado com sucesso!");
                break;
            case 4: // Editar email
                System.out.print("Digite o novo email: ");
                String novoEmail = scanner.nextLine();
                clienteSelecionado.setEmail(novoEmail);
                System.out.println("Email atualizado com sucesso!");
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }


    private void adicionarImovel() {
                System.out.println("Informe o nome do proprietário do imóvel:");
                String nomeProprietario = scanner.nextLine();
                System.out.println("Informe o valor de locação do imóvel:");
                double valorLocacao = scanner.nextDouble();
                System.out.println("Informe o valor de venda do imóvel:");
                double valorVenda = scanner.nextDouble();
                scanner.nextLine(); // Limpar o buffer do scanner
                System.out.println("Informe o endereço do imóvel:");
                String endereco = scanner.nextLine();
                System.out.println("Informe o número de quartos do imóvel:");
                int numQuartos = scanner.nextInt();
                System.out.println("Informe o número de banheiros do imóvel:");
                int numBanheiros = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer do scanner
                System.out.println("O imóvel está disponível para locação? (S/N)");
                boolean disponivelLocacao = scanner.nextLine().equalsIgnoreCase("S");
                System.out.println("O imóvel está disponível para venda? (S/N)");
                boolean disponivelVenda = scanner.nextLine().equalsIgnoreCase("S");
                Imovel imovel = new Imovel(nomeProprietario, valorLocacao, valorVenda, endereco, numQuartos, numBanheiros, disponivelLocacao, disponivelVenda);
                controller.adicionarImovel(imovel);
            
                System.out.println("Imóvel adicionado com sucesso!");
        
    }

    private void removerImovel() {
        System.out.println("Remover Imóvel");
        // Implementação do método
    }

    private void listarImoveis() {
        // Exibindo os imóveis do sistema
        System.out.println("Imóveis do sistema:");
        for (Imovel imovel : controller.getImoveis()) {
            System.out.println("Nome do proprietário: " + imovel.getNomeProprietario());
            System.out.println("Valor de locação: " + imovel.getValorLocacao());
            System.out.println("Valor de venda: " + imovel.getValorVenda());
            System.out.println("Endereço: " + imovel.getEndereco());
            System.out.println("Número de quartos: " + imovel.getNumQuartos());
            System.out.println("Número de banheiros: " + imovel.getNumBanheiros());
            System.out.println("Disponível para locação: " + imovel.isDisponivelLocacao());
            System.out.println("Disponível para venda: " + imovel.isDisponivelVenda());
            System.out.println();
        }
    }

    private void editarImovel() {
        System.out.println("Editar Imóvel");
        // Implementação do método
    }

    private void criarContrato() {
        System.out.println("Criar Contrato");
        // Implementação do método
    }

    private void listarContratosAtivos() {
        // Exibindo os contratos do sistema
        System.out.println("Contratos do sistema:");
        for (Contrato contrato : controller.getContratos()) {
            System.out.println("Cliente: " + contrato.getCliente().getNome());
            System.out.println("Imóvel: " + contrato.getImovel().getEndereco());
            System.out.println("Data de início: " + contrato.getDataInicio());
            System.out.println("Data de fim: " + contrato.getDataFim());
            System.out.println("Tipo de contrato: " + contrato.getTipoContrato());
            System.out.println();
        }
    }

    private void listarContratosTerminados() {
        System.out.println("Listar Contratos Terminados");
        // Implementação do método
    }

    private void renovarContrato() {
        System.out.println("Renovação de Contrato");
        // Implementação do método
    }

    private void rescindirContrato() {
        System.out.println("Rescisão de Contrato");
        // Implementação do método
    }
}

