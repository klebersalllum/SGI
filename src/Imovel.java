public class Imovel {
    private String nomeProprietario;
    private double valorLocacao;
    private double valorVenda;
    private String endereco;
    private int numQuartos;
    private int numBanheiros;
    private boolean disponivelLocacao;
    private boolean disponivelVenda;

    public Imovel(String nomeProprietario, double valorLocacao, double valorVenda, String endereco,
                  int numQuartos, int numBanheiros, boolean disponivelLocacao, boolean disponivelVenda) {
        this.nomeProprietario = nomeProprietario;
        this.valorLocacao = valorLocacao;
        this.valorVenda = valorVenda;
        this.endereco = endereco;
        this.numQuartos = numQuartos;
        this.numBanheiros = numBanheiros;
        this.disponivelLocacao = disponivelLocacao;
        this.disponivelVenda = disponivelVenda;
    }

    public String getNomeProprietario() {
        return nomeProprietario;
    }

    public double getValorLocacao() {
        return valorLocacao;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public String getEndereco() {
        return endereco;
    }

    public int getNumQuartos() {
        return numQuartos;
    }

    public int getNumBanheiros() {
        return numBanheiros;
    }

    public boolean isDisponivelLocacao() {
        return disponivelLocacao;
    }

    public boolean isDisponivelVenda() {
        return disponivelVenda;
    }
}
