public class Cliente {
    private String nome;
    private String cpf;
    private double renda;
    private String email;

    public Cliente(String nome, String cpf, double renda, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.renda = renda;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public double getRenda() {
        return renda;
    }

    public String getEmail() {
        return email;
    }

    public void setCpf(String novoCpf) {
        this.cpf=novoCpf;
    }

    public void setSalario(double novoSalario) {
        this.renda=novoSalario;
    }

    public void setEmail(String novoEmail) {
        this.email=novoEmail;
    }

    public void setNome(String novoNome) {
        this.nome=novoNome;
    }
}
