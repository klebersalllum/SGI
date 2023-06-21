import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Sistema implements ClienteObserver, ImovelObserver{
    private static Sistema instancia;//instancia padrao Singleton
    private List<Cliente> clientes;
    private List<Imovel> imoveis;
    private List<Contrato> contratos;
    /*private List<Funcionario> funcionarios;
    private List<Gerente> gerentes;*/

    public Sistema() {
        this.clientes = new ArrayList<>();
        this.imoveis = new ArrayList<>();
        //funcionarios = new ArrayList<>();
        //gerentes = new ArrayList<>();
        this.contratos = new ArrayList<>();
        criarBD();

    }
    
    //padrao Singleton 
    public static Sistema getInstance() {
        if (instancia == null) {
            instancia = new Sistema();
        }
        return instancia;
    }

    private void criarBD(){
        adicionarClientes();
        adicionarContratos();
        adicionarImoveis();
    }

    private void adicionarClientes() {
        Cliente cliente1 = new Cliente("João Silva", "12345678901", 5000.0, "joao@example.com");
        Cliente cliente2 = new Cliente("Maria Souza", "98765432109", 6000.0, "maria@example.com");
        Cliente cliente3 = new Cliente("Pedro Santos", "45678912304", 4000.0, "pedro@example.com");
        Cliente cliente4 = new Cliente("Ana Oliveira", "90817263548", 5500.0, "ana@example.com");
        Cliente cliente5 = new Cliente("Carlos Ferreira", "25487963125", 4500.0, "carlos@example.com");
        
        adicionarCliente(cliente1);
        adicionarCliente(cliente2);
        adicionarCliente(cliente3);
        adicionarCliente(cliente4);
        adicionarCliente(cliente5);
    }
    
    private void adicionarImoveis() {
        Imovel imovel1 = new Imovel("João Silva", 1000.0, 200000.0, "Rua A, 123",
                3, 2, true, false);
        Imovel imovel2 = new Imovel("Maria Souza", 1500.0, 250000.0, "Rua B, 456",
                4, 3, true, true);
        Imovel imovel3 = new Imovel("Pedro Santos", 800.0, 180000.0, "Rua C, 789",
                2, 1, false, true);
        Imovel imovel4 = new Imovel("Ana Oliveira", 1200.0, 220000.0, "Rua D, 321",
                3, 2, true, true);
        Imovel imovel5 = new Imovel("Carlos Ferreira", 900.0, 190000.0, "Rua E, 654",
                2, 1, true, false);
        
        adicionarImovel(imovel1);
        adicionarImovel(imovel2);
        adicionarImovel(imovel3);
        adicionarImovel(imovel4);
        adicionarImovel(imovel5);
    }
    
    private void adicionarContratos() {
        Cliente cliente1 = buscarClientePorCpf("12345678901");
        Cliente cliente2 = buscarClientePorCpf("98765432109");
        Imovel imovel1 = buscarImovelPorEndereco("Rua A, 123");
        Imovel imovel2 = buscarImovelPorEndereco("Rua B, 456");
        
        Contrato contrato1 = new Contrato(cliente1, 1, imovel1, "01/06/2023", "01/06/2024", "Locação");
        Contrato contrato2 = new Contrato(cliente2, 2, imovel2, "01/07/2023", "01/07/2024", "Venda");
        
        contratos.add(contrato1);
        contratos.add(contrato2);
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
        notificarClienteAdicionado(cliente);
    }

    public void removerCliente(Cliente cliente) {
        clientes.remove(cliente);
        notificarClienteRemovido(cliente);
    }

    public void adicionarImovel(Imovel imovel) {
        imoveis.add(imovel);
        notificarImovelAdicionado(imovel);
    }

    public void removerImovel(Imovel imovel) {
        imoveis.remove(imovel);
        notificarImovelRemovido(imovel);
    }

    public void adicionarContrato(Contrato contrato) {
        contratos.add(contrato);
    }

    public void removerContrato(Contrato contrato) {
        contratos.remove(contrato);
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Imovel> getImoveis() {
        return imoveis;
    }

    public List<Contrato> getContratos() {
        return contratos;
    }

    // Métodos relacionados ao padrão Observer

    private List<ClienteObserver> clienteObservers = new ArrayList<>();
    private List<ImovelObserver> imovelObservers = new ArrayList<>();

    public void adicionarClienteObserver(ClienteObserver observer) {
        clienteObservers.add(observer);
    }

    public void removerClienteObserver(ClienteObserver observer) {
        clienteObservers.remove(observer);
    }

    public void adicionarImovelObserver(ImovelObserver observer) {
        imovelObservers.add(observer);
    }

    public void removerImovelObserver(ImovelObserver observer) {
        imovelObservers.remove(observer);
    }

    public void notificarClienteAdicionado(Cliente cliente) {
        for (ClienteObserver observer : clienteObservers) {
            observer.clienteAdicionado(cliente);
        }
    }

    public void notificarClienteRemovido(Cliente cliente) {
        for (ClienteObserver observer : clienteObservers) {
            observer.clienteRemovido(cliente);
        }
    }

    public void notificarImovelAdicionado(Imovel imovel) {
        for (ImovelObserver observer : imovelObservers) {
            observer.imovelAdicionado(imovel);
        }
    }

    public void notificarImovelRemovido(Imovel imovel) {
        for (ImovelObserver observer : imovelObservers) {
            observer.imovelRemovido(imovel);
        }
    }
    @Override
    public void clienteAdicionado(Cliente cliente) {
        // Lógica de tratamento quando um cliente é adicionado
        System.out.println("Cliente adicionado: " + cliente.getNome());
    }

    @Override
    public void clienteRemovido(Cliente cliente) {
        // Lógica de tratamento quando um cliente é removido
        System.out.println("Cliente removido: " + cliente.getNome());
    }

    @Override
    public void imovelAdicionado(Imovel imovel) {
        // Lógica de tratamento quando um imóvel é adicionado
        System.out.println("Imóvel adicionado: " + imovel.getNomeProprietario());
    }

    @Override
    public void imovelRemovido(Imovel imovel) {
        // Lógica de tratamento quando um imóvel é removido
        System.out.println("Imóvel removido: " + imovel.getNomeProprietario());
    }
    
    public Cliente buscarClientePorCpf(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null; // Retorna null se o cliente não for encontrado
    }
    
    public Imovel buscarImovelPorEndereco(String endereco) {
        for (Imovel imovel : imoveis) {
            if (imovel.getEndereco().equals(endereco)) {
                return imovel;
            }
        }
        return null; // Retorna null se o imóvel não for encontrado
    }
    
    public Contrato buscarContratoPorId(int idContrato) {
        for (Contrato contrato : contratos) {
            if (contrato.getIdContrato() == idContrato) {
                return contrato;
            }
        }
        return null; // Retorna null se o contrato não for encontrado
    }

    public boolean validarLogin(String login, String senha, String tipoUsuario) {
        if (tipoUsuario.equals("Gerente")) {
            return validarGerente(login, senha);
        } else if (tipoUsuario.equals("Funcionário")) {
            return validarFuncionario(login, senha);
        }
        return false; // Login inválido
    }


    private boolean validarFuncionario(String login, String senha) {
        try (Scanner scanner = new Scanner(new File("src/funcionarios.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] dados = line.split(";");
                if (dados.length == 2 && dados[0].equals(login) && dados[1].equals(senha)) {
                    /*
                    Funcionario funcionario = new Funcionario(dados[0], dados[2]);
                    funcionarios.add(funcionario);*/
                    return true; // Login válido
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return false; // Login inválido
    }

    private boolean validarGerente(String login, String senha) {
        try (Scanner scanner = new Scanner(new File("src/gerentes.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] dados = line.split(";");

                if (dados.length == 2 && dados[0].equals(login) && dados[1].equals(senha)) {
                    /*Gerente gerente = new Gerente(dados[0], dados[2]);
                    gerentes.add(gerente);*/
                    return true; // Login válido
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return false; // Login inválido
    }
}
