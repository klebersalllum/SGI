public class App {
    public static void main(String[] args) {
        // Obter a instância única do sistema
        Sistema sistema = Sistema.getInstance();
        
        // Criação do objeto de visualização do sistema
        SistemaView view = new SistemaView(sistema);
        view.executar();
    }
}
