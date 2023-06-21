package controllers;

import controllers.entidades.Cliente;
import controllers.entidades.Contrato;
import controllers.entidades.Funcionario;
import controllers.entidades.Imovel;
import controllers.interfaces.Dimensoes;
import controllers.interfaces.Strings;
import model.SGIBD;
import views.*;

import javax.swing.*;
import java.awt.*;

/*
 * Classe responsável por coordenar a exibição das interfaces gráficas
 */
public class ControladorUI implements Dimensoes {
    public static Funcionario funcionarioLogado;

    public static TelaDashboard instanciaTelaDashboard;

    public static Dialog instanciaDialogoTela;

    public static void exibirTelaLogin() {
        TelaLogin login = new TelaLogin();
        login.show();
    }

    public static void exibirTelaDashboard() {
        instanciaTelaDashboard = new TelaDashboard(funcionarioLogado, SGIBD.carregarConfiguracoes());
        instanciaTelaDashboard.show();
    }

    public static void exibirDialogoConfiguracoes() {
        instanciaDialogoTela = new DialogoConfiguracoes();
        instanciaDialogoTela.setIconImage(new ImageIcon(Strings.ICONE_32).getImage());
        instanciaDialogoTela.setSize(DIALOGO_CONFIGURACOES);
        instanciaDialogoTela.setLocation(Dimensoes.getCentroTela(instanciaDialogoTela.getWidth(), instanciaDialogoTela.getHeight()));
        instanciaDialogoTela.setVisible(true);
    }

    public static void exibirDialogoAlterarCliente(int clienteID) {
        Cliente cliente = SGIBD.getClienteByID(clienteID);

        instanciaDialogoTela = new DialogoAlterarCliente(cliente);
        instanciaDialogoTela.setIconImage(new ImageIcon(Strings.ICONE_32).getImage());
        instanciaDialogoTela.setSize(Dimensoes.DIALOGO_ALTERAR_CLIENTE);
        instanciaDialogoTela.setLocation(Dimensoes.getCentroTela(instanciaDialogoTela.getWidth(), instanciaDialogoTela.getHeight()));
        instanciaDialogoTela.setVisible(true);
    }

    public static void exibirDialogoAlterarImoveis(int imovelID) {
        Imovel imovel = SGIBD.getImovelByID(imovelID);
        instanciaDialogoTela = new DialogoAlterarImoveis(imovel);
        instanciaDialogoTela.setIconImage(new ImageIcon(Strings.ICONE_32).getImage());
        instanciaDialogoTela.setSize(Dimensoes.DIALOGO_ALTERAR_IMOVEL);
        instanciaDialogoTela.setLocation(Dimensoes.getCentroTela(instanciaDialogoTela.getWidth(), instanciaDialogoTela.getHeight()));
        instanciaDialogoTela.setVisible(true);
    }

    public static void exibirDialogoAlterarContratos(int contratoID) {
        Contrato contrato = SGIBD.getContratoByID(contratoID);

        instanciaDialogoTela = new DialogoAlterarContrato(contrato, SGIBD.getImoveis(), SGIBD.getClientes());
        instanciaDialogoTela.setIconImage(new ImageIcon(Strings.ICONE_32).getImage());
        instanciaDialogoTela.setSize(Dimensoes.DIALOGO_ALTERAR_CONTRATO);
        instanciaDialogoTela.setLocation(Dimensoes.getCentroTela(instanciaDialogoTela.getWidth(), instanciaDialogoTela.getHeight()));
        instanciaDialogoTela.setVisible(true);
    }

    public static void exibirDialogoAlterarFuncionarios(int funcionarioID) {
        Funcionario funcionario = SGIBD.getFuncionarioByID(funcionarioID);

        instanciaDialogoTela = new DialogoAlterarFuncionario(funcionario);
        instanciaDialogoTela.setIconImage(new ImageIcon(Strings.ICONE_32).getImage());
        instanciaDialogoTela.setSize(Dimensoes.DIALOGO_ALTERAR_FUNCIONARIO);
        instanciaDialogoTela.setLocation(Dimensoes.getCentroTela(instanciaDialogoTela.getWidth(), instanciaDialogoTela.getHeight()));
        instanciaDialogoTela.setVisible(true);
    }

    public static void exibirDialogoMensagens(String mensagemDadosInvalidos) {
        DialogoMensagem dialogoMensagem = new DialogoMensagem(mensagemDadosInvalidos);
        dialogoMensagem.setIconImage(new ImageIcon(Strings.ICONE_32).getImage());
        dialogoMensagem.setSize(Dimensoes.DIALOGO_MENSAGEM);
        dialogoMensagem.setLocation(Dimensoes.getCentroTela(dialogoMensagem.getWidth(), dialogoMensagem.getHeight()));
        dialogoMensagem.setVisible(true);
    }

    public static void mudarPosicaoMenus(int pos) {
        instanciaTelaDashboard.setMenuPosition(pos + 1);
        SGIBD.salvarConfiguracao(pos + 1, (boolean) SGIBD.carregarConfiguracoes().get("temaEscuro"));
    }

}