public class Contrato {
    private Cliente cliente;
    private int idContrato;
    private Imovel imovel;
    private String dataInicio;
    private String dataFim;
    private String tipoContrato;

    public Contrato(Cliente cliente, int idContrato, Imovel imovel, String dataInicio, String dataFim, String tipoContrato) {
        this.cliente = cliente;
        this.imovel = imovel;
        this.idContrato=idContrato;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.tipoContrato = tipoContrato;
    }
    public int getIdContrato(){
        return idContrato;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }
}
