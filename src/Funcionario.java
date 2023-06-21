public class Funcionario {
    private String nome;
    private double salario;
    private String cpf;
    private String login;
    private String email;
    private String senha;

    public Funcionario(String nome, double salario, String cpf, String login, String email, String senha) {
        this.nome = nome;
        this.salario = salario;
        this.cpf = cpf;
        this.login = login;
        this.email = email;
        this.senha = senha;
    }
    
    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}