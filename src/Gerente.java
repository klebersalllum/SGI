public class Gerente extends Funcionario {
    private String departamento;

    public Gerente(String nome, double salario, String cpf, String login, String email, String senha, String departamento) {
        super(nome, salario, cpf, login, email, senha);
        this.departamento = departamento;
    }
    // Getter e Setter
    public String getDepartamento() {
        return departamento;
    }
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}
